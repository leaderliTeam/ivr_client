package com.pccc.sip.ivrclient.bean;

import java.util.List;

public class OutputProtocol {

    private String callid;

    private List<OutputCell> outputList;

    public String getCallid() {
        return callid;
    }

    public void setCallid(String callid) {
        this.callid = callid;
    }

    public List<OutputCell> getOutputList() {
        return outputList;
    }

    public void setOutputList(List<OutputCell> outputList) {
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
