package com.pccc.sip.ivrclient.core;

import com.pccc.sip.ivrclient.bean.InputProtocol;
import com.pccc.sip.ivrclient.bean.ivr.*;
import com.pccc.sip.ivrclient.constant.ProtocolConstant;

public class ProtocolFactory {


    public static IProtocol createProtocol(String type) {
        switch (type) {
            case ProtocolConstant.START:
                return new StartProtocol();
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
            case ProtocolConstant.PLAY:
            case ProtocolConstant.BARGIN:
            case ProtocolConstant.HOLD:
            case ProtocolConstant.TRANSFER:
            case ProtocolConstant.SWITCH_APP:
            case ProtocolConstant.REDIRECT:
                return new PublicProtocol();
        }
        return null;
    }
}
