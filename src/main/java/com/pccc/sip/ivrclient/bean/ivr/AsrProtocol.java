package com.pccc.sip.ivrclient.bean.ivr;

public class AsrProtocol {

    private String interdigittimeout;

    private String dtmf;

    private String value;

    /**
     * normal
     * noinput
     * nomatch
     */
    private String state;

    public String getInterdigittimeout() {
        return interdigittimeout;
    }

    public void setInterdigittimeout(String interdigittimeout) {
        this.interdigittimeout = interdigittimeout;
    }

    public String getDtmf() {
        return dtmf;
    }

    public void setDtmf(String dtmf) {
        this.dtmf = dtmf;
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
