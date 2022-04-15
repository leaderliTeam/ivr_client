package com.pccc.sip.ivrclient.bean;

import com.pccc.sip.ivrclient.constant.ProtocolConstant;
import org.junit.Test;

public class SessionDataTest {

    @Test
    public void buildTest() {
        String callId = "000000" + System.nanoTime();
        InputProtocol inputProtocol = new InputProtocol();
//        inputProtocol.setValue("1");
        OutputProtocol outputProtocol = new OutputProtocol();
        outputProtocol.setCallid(callId);
//        OutputCell outputCell = new OutputCell();
//        outputCell.setType(ProtocolConstant.START);
//        outputCell.setValue(inputProtocol.getValue());
//        outputProtocol.getOutput().add(outputCell);
        SessionData sessionData = SessionData.builder().callid(callId).type(ProtocolConstant.START).seq("0").request(inputProtocol).response(outputProtocol).build();

        System.out.println(sessionData);
    }
}
