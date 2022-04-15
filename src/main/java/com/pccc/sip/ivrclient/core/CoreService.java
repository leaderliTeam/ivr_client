package com.pccc.sip.ivrclient.core;

import com.pccc.sip.ivrclient.bean.InputProtocol;
import com.pccc.sip.ivrclient.bean.OutputCell;
import com.pccc.sip.ivrclient.bean.OutputProtocol;
import com.pccc.sip.ivrclient.bean.SessionData;
import com.pccc.sip.ivrclient.common.Response;
import com.pccc.sip.ivrclient.constant.ProtocolConstant;
import org.apache.commons.lang3.StringUtils;

import javax.validation.constraints.NotNull;
import java.util.HashMap;
import java.util.List;
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
            DataCache.SESSION_MAP.put(sessionData.getCallid(),sessionData);
        }
        return null;
    }

    public static SessionData initSessionData(InputProtocol inputProtocol) {
//        OutputCell outputCell = new OutputCell();
//        outputCell.setType(ProtocolConstant.START);
//        outputCell.setValue(inputProtocol.getValue());
//        outputProtocol.getOutput().add(outputCell);
        return SessionData.builder().type(ProtocolConstant.START).request(inputProtocol).build();
    }

    public SessionData resetSessionData(InputProtocol inputProtocol) {
        SessionData sessionData = DataCache.SESSION_MAP.get(inputProtocol.getCallid());
        sessionData.setRequest(inputProtocol);
        return sessionData;
    }

    public static OutputProtocol coreService(SessionData session) {
        List<String> values = session.getRequest().getValue();
        for (String value : values) {
            interaction(value,session);
        }
        return session.getResponse();
    }

    public static void interaction(String value,SessionData session) {
        boolean flag = true;
        while (flag) {
            switch (session.getType()) {
                case ProtocolConstant.START:
//                    HttpUtil.postForSip()
                case ProtocolConstant.BARGIN:
                case ProtocolConstant.PLAY:
                case ProtocolConstant.HOLD:
                case ProtocolConstant.REDIRECT:
                case ProtocolConstant.RECORD:
                case ProtocolConstant.SWITCH_APP:
                case ProtocolConstant.TRANSFER:
                    break;
                case ProtocolConstant.INPUT:
                case ProtocolConstant.SELECT:
                case ProtocolConstant.ASR:
                    flag = false;
                    break;
                case ProtocolConstant.EVENT:
                    System.out.println();
                    break;
            }
        }
    }



    /**
     * 根据功能码去查取本通会话中的动态菜单进入此功能的按键序列，查取不到则本次交互失败。
     * @param callId
     * @param flowCode
     * @return
     */
    public String fetchMenuSeq(String callId, String flowCode) {
        return null;
    }

    public String seqIncrease(SessionData sessionData) {
        AtomicInteger atomicInteger = new AtomicInteger(Integer.parseInt(sessionData.getSeq()));
        return String.valueOf(atomicInteger.incrementAndGet());
    }
}
