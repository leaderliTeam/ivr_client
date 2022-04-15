package com.pccc.sip.ivrclient.bean;

import java.util.ArrayList;
import java.util.List;

public class OutputProtocol {

    private String callid;

    private List<OutputCell> output = new ArrayList<>();

    public OutputProtocol() {
    }

    public OutputProtocol(String callid) {
        this.callid = callid;
    }

    public OutputProtocol(String callid, List<OutputCell> output) {
        this.callid = callid;
        this.output = output;
    }

    public String getCallid() {
        return callid;
    }

    public void setCallid(String callid) {
        this.callid = callid;
    }

    public List<OutputCell> getOutput() {
        return output;
    }

    public void setOutput(List<OutputCell> output) {
        this.output = output;
    }

    public void add(OutputCell cell) {
        this.output.add(cell);
    }
}
