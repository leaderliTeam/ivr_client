package com.pccc.sip.ivrclient.bean;

public class SessionData {

    private String callid;

    private String type;

    private String seq;

    private InputProtocol request;

    private OutputProtocol response;

    public String getCallid() {
        return callid;
    }

    public void setCallid(String callid) {
        this.callid = callid;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSeq() {
        return seq;
    }

    public void setSeq(String seq) {
        this.seq = seq;
    }

    public InputProtocol getRequest() {
        return request;
    }

    public void setRequest(InputProtocol request) {
        this.request = request;
    }

    public OutputProtocol getResponse() {
        return response;
    }

    public void setResponse(OutputProtocol response) {
        this.response = response;
    }
}
