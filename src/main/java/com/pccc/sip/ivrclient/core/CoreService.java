package com.pccc.sip.ivrclient.core;

import com.pccc.sip.ivrclient.bean.InputProtocol;
import com.pccc.sip.ivrclient.bean.OutputCell;
import com.pccc.sip.ivrclient.bean.OutputProtocol;
import com.pccc.sip.ivrclient.bean.SessionData;
import com.pccc.sip.ivrclient.bean.ivr.EventProtocol;
import com.pccc.sip.ivrclient.common.Response;
import com.pccc.sip.ivrclient.constant.EventConstant;
import com.pccc.sip.ivrclient.constant.KeyConstant;
import com.pccc.sip.ivrclient.constant.ProtocolConstant;
import com.pccc.sip.ivrclient.exception.EventException;
import com.pccc.sip.ivrclient.exception.InteractionException;
import com.pccc.sip.ivrclient.util.HttpUtil;
import io.leaderli.litil.collection.LiMapUtil;
import org.apache.commons.lang3.StringUtils;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class CoreService {

    /**
     * 1.输入输出实体类
     * 2.与IVR交互的类似sipsession的实体类
     * 3.缓存：callid为key，sipsession为value
     * 4.状态转移函数
     * 5.遇到终止事件时，将这一通会话结束并删除相应的缓存
     */

    public static Response<OutputProtocol> launch(@NotNull InputProtocol inputProtocol) {

        if (StringUtils.isBlank(inputProtocol.getCallid())) {
            SessionData sessionData = initSessionData(inputProtocol);
            DataCache.SESSION_MAP.put(sessionData.getCallid(), sessionData);
        }
        SessionData session = DataCache.SESSION_MAP.get(inputProtocol.getCallid());
        session.setRequest(inputProtocol);
        return Response.success(coreService(session));
    }

    public static SessionData initSessionData(InputProtocol inputProtocol) {
        return SessionData.builder().type(ProtocolConstant.START).next(inputProtocol.getDnis()).request(inputProtocol).build();
    }


    public static OutputProtocol coreService(SessionData session) {
        List<String> values = session.getRequest().getValue();

        for (String value : values) {
            if (StringUtils.startsWith(value, KeyConstant.FLOW_CODE)) {
                dynamicMenuInteraction(value, session);
            } else {
                interaction(value, session);
            }
        }
        return session.getResponse();
    }

    /**
     * 与IVR交互逻辑
     *
     * @param value
     * @param session
     */
    public static void interaction(String value, SessionData session) throws InteractionException {
        boolean flag = true;
        List<OutputCell> output = session.getResponse().getOutput();
        output.clear();
        while (flag) {
            Map<String, Object> response = responseHandle(session);
            switch (session.getType()) {
                case ProtocolConstant.INPUT:
                case ProtocolConstant.SELECT:
                case ProtocolConstant.ASR:
                    inputHandle(value);
                    flag = false;
                    break;
                case ProtocolConstant.BARGIN:
                case ProtocolConstant.PLAY:
                case ProtocolConstant.TRANSFER:
                case ProtocolConstant.HOLD:
                case ProtocolConstant.REDIRECT:
                case ProtocolConstant.RECORD:
                case ProtocolConstant.SWITCH_APP:
                    break;
                case ProtocolConstant.EVENT:
                    EventProtocol event = LiMapUtil.getTypeObject(response, ProtocolConstant.EVENT, EventProtocol.class).get();
                    if (StringUtils.equals(event.getName(), EventConstant.HANGUP)) {
                        break;
                    } else if (StringUtils.equals(event.getName(), EventConstant.DISCONNECT)){
                        HttpUtil.postForSip(session.getNext(),new EventProtocol().packageRequest(session));
                    } else {
                        throw new EventException(event);
                    }
            }
        }
    }

    public static void inputHandle(String value) {
        if (StringUtils.equals(value, "-3")) {

        }
    }

    public static Map<String, Object> responseHandle(SessionData session) {
        Map<String, Object> response = HttpUtil.postForSip(session.getNext(), ProtocolFactory.createProtocol(session).packageRequest(session));
        session.setNext(LiMapUtil.getTypeObject(response, KeyConstant.NEXT, String.class).get());
        session.setSeq(LiMapUtil.getTypeObject(response, KeyConstant.SEQ, String.class).get());
        session.setType(LiMapUtil.getTypeObject(response, KeyConstant.TYPE, String.class).get());
        return response;
    }


    /**
     * 根据功能码去查取本通会话中的动态菜单进入此功能的按键序列，查取不到则本次交互失败。
     *
     * @param flowCode
     * @return
     */
    public static List<String> fetchMenuSeq(String flowCode) {
        return null;
    }


    public static void dynamicMenuInteraction(String flowCode, SessionData session) {
        List<String> menuSeq = fetchMenuSeq(flowCode);
        if (menuSeq == null) {
            throw new InteractionException("未找到可进入此流程的动态菜单，请查看执行案例编写是否正确！");
        }
        for (String value : menuSeq) {
            coreService(session);
        }
    }

    public static String seqIncrease(SessionData sessionData) {
        int seq = Integer.parseInt(sessionData.getSeq());
        if (seq % 2 == 0) {
            return sessionData.getSeq();
        }
        AtomicInteger atomicInteger = new AtomicInteger(seq);
        sessionData.setSeq(String.valueOf(atomicInteger.incrementAndGet()));
        return sessionData.getSeq();
    }
}
