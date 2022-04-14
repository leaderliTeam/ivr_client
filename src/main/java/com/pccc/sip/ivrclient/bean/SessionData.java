package com.pccc.sip.ivrclient.bean;

public class SessionData {

    private String callid;

    private String type;

    private String seq;

    private InputProtocol request;

    private OutputProtocol response;

    private SessionData(String callid, String type, String seq, InputProtocol request, OutputProtocol response) {
        this.callid = callid;
        this.type = type;
        this.seq = seq;
        this.request = request;
        this.response = response;
    }

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

    @Override
    public String toString() {
        return "SessionData{" +
                "callid='" + callid + '\'' +
                ", type='" + type + '\'' +
                ", seq='" + seq + '\'' +
                ", request=" + request +
                ", response=" + response +
                '}';
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private String callid;

        private String type;

        private String seq;

        private InputProtocol request;

        private OutputProtocol response;

        private Builder() {
        }

        public Builder callid(String callid) {
            this.callid = callid;
            return this;
        }

        public Builder type(String type) {
            this.type = type;
            return this;
        }
        public Builder seq(String seq) {
            this.seq = seq;
            return this;
        }
        public Builder request(InputProtocol request) {
            this.request = request;
            return this;
        }
        public Builder response(OutputProtocol response) {
            this.response = response;
            return this;
        }

        public SessionData build() {
            return new SessionData(callid,type,seq,request,response);
        }
    }
}
