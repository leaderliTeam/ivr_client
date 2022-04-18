package com.pccc.sip.ivrclient.bean.ivr;

public class SelectProtocol extends AbstractProtocol{

    private String interdigittimeout;

    private String value;

    private String state;

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

}
