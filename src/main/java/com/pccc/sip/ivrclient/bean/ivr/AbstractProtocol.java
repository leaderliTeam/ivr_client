package com.pccc.sip.ivrclient.bean.ivr;

import com.pccc.sip.ivrclient.bean.SessionData;
import com.pccc.sip.ivrclient.constant.KeyConstant;
import com.pccc.sip.ivrclient.core.CoreService;

import java.util.HashMap;
import java.util.Map;

public abstract class AbstractProtocol {

    public Map<String, Object> packageRequest(SessionData session) {
        HashMap<String, Object> map = new HashMap<>();
        map.put(KeyConstant.CALL_ID, session.getCallid());
        map.put(KeyConstant.TYPE, session.getType());
        map.put(KeyConstant.SEQ, CoreService.seqIncrease(session));
        map.put(session.getType(), this);
        return map;
    }
}
