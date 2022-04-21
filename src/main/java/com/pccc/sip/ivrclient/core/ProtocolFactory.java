package com.pccc.sip.ivrclient.core;

import com.pccc.sip.ivrclient.bean.InputProtocol;
import com.pccc.sip.ivrclient.bean.SessionData;
import com.pccc.sip.ivrclient.bean.ivr.*;
import com.pccc.sip.ivrclient.constant.ProtocolConstant;

public class ProtocolFactory {

    public static AbstractProtocol createProtocol(SessionData session) {
        InputProtocol request = session.getRequest();
        switch (session.getType()) {
            case ProtocolConstant.START:
                return new StartProtocol(request.getAni(),request.getDnis(),request.getCallid());
            case ProtocolConstant.EVENT:
                return new EventProtocol();
            case ProtocolConstant.SELECT:
                return new SelectProtocol();
            case ProtocolConstant.INPUT:
                return new InputProtocol();
            case ProtocolConstant.ASR:
                return new AsrProtocol();
            case ProtocolConstant.RECORD:
                return new RecordProtocol();
            default:
                return new PublicProtocol();
        }
    }
}
