package com.pccc.sip.ivrclient.util;

import com.pccc.sip.ivrclient.bean.InputProtocol;
import io.leaderli.litil.meta.Lino;
import org.junit.Test;

public class LitilTest {


    @Test
    public void linoTest() {
        InputProtocol inputProtocol = new InputProtocol();
        System.out.println(Lino.of(inputProtocol).map(InputProtocol::getCallid).get() == null);
    }
}
