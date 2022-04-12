package com.pccc.sip.ivrclient.bean.ivr;

import com.pccc.sip.ivrclient.bean.OutputCell;

import java.util.List;

public class PlayProtocol {

    private boolean bargin;

    private int timeout;

    private String language;

    private String img;

    private List<OutputCell> voices;

    private List<String> attribute;

    public boolean isBargin() {
        return bargin;
    }

    public void setBargin(boolean bargin) {
        this.bargin = bargin;
    }

    public int getTimeout() {
        return timeout;
    }

    public void setTimeout(int timeout) {
        this.timeout = timeout;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public List<OutputCell> getVoices() {
        return voices;
    }

    public void setVoices(List<OutputCell> voices) {
        this.voices = voices;
    }

    public List<String> getAttribute() {
        return attribute;
    }

    public void setAttribute(List<String> attribute) {
        this.attribute = attribute;
    }
}
