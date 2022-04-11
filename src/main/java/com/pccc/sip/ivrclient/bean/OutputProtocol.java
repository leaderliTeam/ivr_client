package com.pccc.sip.ivrclient.bean;

import java.util.List;

public class OutputProtocol {

    private String callid;

    private List<OutputSingle> outputList;

    public String getCallid() {
        return callid;
    }

    public void setCallid(String callid) {
        this.callid = callid;
    }

    public List<OutputSingle> getOutputList() {
        return outputList;
    }

    public void setOutputList(List<OutputSingle> outputList) {
        this.outputList = outputList;
    }

    @Override
    public String toString() {
        return "OutputProtocol{" +
                "callid='" + callid + '\'' +
                ", outputList=" + outputList +
                '}';
    }
}
