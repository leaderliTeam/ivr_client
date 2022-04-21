package com.pccc.sip.ivrclient.bean;

import com.pccc.sip.ivrclient.util.SpringUtil;
import org.springframework.core.env.Environment;

public class SessionData {

    private String callid;

    private String type;

    private String seq;

    private String next;

    private InputProtocol request;

    private OutputProtocol response;

    private SessionData(String callid, String type, String seq, String next, InputProtocol request, OutputProtocol response) {
        this.callid = callid;
        this.type = type;
        this.seq = seq;
        this.next = next;
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

    public String getNext() {
        return next;
    }

    public void setNext(String next) {
        this.next = next;
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
                ", next='" + next + '\'' +
                ", request=" + request +
                ", response=" + response +
                '}';
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {

        private static final String CALL_ID_PREFIX = "000000";

        private String callid = CALL_ID_PREFIX + System.nanoTime();

        private String type;

        private String seq = "0";

        private String next;

        private InputProtocol request;

        private OutputProtocol response = new OutputProtocol(this.callid);

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

        public Builder next(String next) {
            this.next = SpringUtil.getBean(Environment.class).getProperty("ivrStartUrl." + next);
            return this;
        }

        public Builder request(InputProtocol request) {
            this.request = request;
            return this;
        }

        public Builder response(OutputProtocol response) {
            response.setCallid(this.callid);
            this.response = response;
            return this;
        }

        public SessionData build() {
            return new SessionData(callid, type, seq, next, request, response);
        }
    }
}
