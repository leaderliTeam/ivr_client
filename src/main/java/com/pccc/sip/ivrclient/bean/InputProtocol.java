package com.pccc.sip.ivrclient.bean;

import com.pccc.sip.ivrclient.bean.ivr.IProtocol;

import java.util.List;
import java.util.Map;

public class InputProtocol implements IProtocol {

    private String callid;

    private String ani;

    private String dnis;

    private List<String> value;

    public String getCallid() {
        return callid;
    }

    public void setCallid(String callid) {
        this.callid = callid;
    }

    public String getAni() {
        return ani;
    }

    public void setAni(String ani) {
        this.ani = ani;
    }

    public String getDnis() {
        return dnis;
    }

    public void setDnis(String dnis) {
        this.dnis = dnis;
    }

    public List<String> getValue() {
        return value;
    }

    public void setValue(List<String> value) {
        this.value = value;
    }

    @Override
    public Map<String, Object> packageRequest(SessionData session) {
        return null;
    }
}
