package com.pccc.sip.ivrclient.bean.ivr;

public class InputProtocol {

    private String interdigittimeout;

    private String value;

    /**
     * normal
     * noinput
     * nomatch
     */
    private String state;

    private String des;

    public String getInterdigittimeout() {
        return interdigittimeout;
    }

    public void setInterdigittimeout(String interdigittimeout) {
        this.interdigittimeout = interdigittimeout;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }
}
