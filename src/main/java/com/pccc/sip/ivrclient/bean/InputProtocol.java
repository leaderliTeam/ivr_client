package com.pccc.sip.ivrclient.bean;

public class InputProtocol {

    private String callid;

    private String ani;

    private String dnis;

    private String value;

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

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "InputProtocol{" +
                "callid='" + callid + '\'' +
                ", ani='" + ani + '\'' +
                ", dnis='" + dnis + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}
