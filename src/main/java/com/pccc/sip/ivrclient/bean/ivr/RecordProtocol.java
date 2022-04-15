package com.pccc.sip.ivrclient.bean.ivr;

import com.pccc.sip.ivrclient.bean.SessionData;

import java.util.Map;

public class RecordProtocol implements IProtocol{

    private boolean beep;

    private String maxtime;

    private String finalSilence;

    private boolean dtfmTerm;

    private String type;

    private String mode;

    private String url;

    public boolean isBeep() {
        return beep;
    }

    public void setBeep(boolean beep) {
        this.beep = beep;
    }

    public String getMaxtime() {
        return maxtime;
    }

    public void setMaxtime(String maxtime) {
        this.maxtime = maxtime;
    }

    public String getFinalSilence() {
        return finalSilence;
    }

    public void setFinalSilence(String finalSilence) {
        this.finalSilence = finalSilence;
    }

    public boolean isDtfmTerm() {
        return dtfmTerm;
    }

    public void setDtfmTerm(boolean dtfmTerm) {
        this.dtfmTerm = dtfmTerm;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public Map<String, Object> packageRequest(SessionData session) {
        return null;
    }
}
