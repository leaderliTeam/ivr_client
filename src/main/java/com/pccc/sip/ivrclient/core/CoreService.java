package com.pccc.sip.ivrclient.core;

import com.pccc.sip.ivrclient.bean.InputProtocol;
import com.pccc.sip.ivrclient.bean.OutputCell;
import com.pccc.sip.ivrclient.bean.OutputProtocol;
import com.pccc.sip.ivrclient.bean.SessionData;
import com.pccc.sip.ivrclient.bean.ivr.PlayProtocol;
import com.pccc.sip.ivrclient.common.Response;
import com.pccc.sip.ivrclient.constant.KeyConstant;
import com.pccc.sip.ivrclient.constant.ProtocolConstant;
import com.pccc.sip.ivrclient.exception.InteractionException;
import com.pccc.sip.ivrclient.util.GsonUtil;
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
        return SessionData.builder().type(ProtocolConstant.START).request(inputProtocol).build();
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
    public static void interaction(String value, SessionData session) {
        boolean flag = true;
        List<OutputCell> output = session.getResponse().getOutput();
        output.clear();
        while (flag) {
            switch (session.getType()) {
                case ProtocolConstant.START:
                case ProtocolConstant.BARGIN:
                case ProtocolConstant.PLAY:
                    Map<String, Object> response = HttpUtil.postForSip(session.getNext(), ProtocolFactory.createProtocol(session.getType()).packageRequest(session));
                    session.setNext(LiMapUtil.getTypeObject(response,KeyConstant.NEXT,String.class).get());
                    String type = LiMapUtil.getTypeObject(response, KeyConstant.TYPE, String.class).get();
                    session.setType(type);
                    PlayProtocol playProtocol = GsonUtil.formJson(LiMapUtil.getTypeObject(response, type, String.class).get(), PlayProtocol.class);
                    output.addAll(playProtocol.getVoices());
                    break;
                case ProtocolConstant.HOLD:
                case ProtocolConstant.REDIRECT:
                case ProtocolConstant.RECORD:
                case ProtocolConstant.SWITCH_APP:
                case ProtocolConstant.TRANSFER:
                    Map<String, Object> response1 = HttpUtil.postForSip(session.getNext(), ProtocolFactory.createProtocol(session.getType()).packageRequest(session));
                    session.setNext(LiMapUtil.getTypeObject(response1,KeyConstant.NEXT,String.class).get());
                    output.add(new OutputCell(KeyConstant.VDN,LiMapUtil.getTypeObject(response1,KeyConstant.VDN,String.class).get()));
                    break;
                case ProtocolConstant.INPUT:
                case ProtocolConstant.SELECT:
                case ProtocolConstant.ASR:
                    flag = false;
                    break;
                case ProtocolConstant.EVENT:
                    break;
            }
        }
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
