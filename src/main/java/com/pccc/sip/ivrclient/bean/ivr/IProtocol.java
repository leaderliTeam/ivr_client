package com.pccc.sip.ivrclient.bean.ivr;

import com.pccc.sip.ivrclient.bean.SessionData;

import java.util.Map;

public interface IProtocol {

    Map<String,Object> packageRequest(SessionData session);
}
