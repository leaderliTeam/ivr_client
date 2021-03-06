package com.pccc.sip.ivrclient.bean.ivr;

public class StartProtocol extends AbstractProtocol{

    private String ani;

    private String dnis;

    private String ucid;

    private String site = "SH";

    private String platform = "TEST";

    private String channel;

    private String other_ucid;

    private String times;

    private String calldata;

    public StartProtocol() {
    }

    public StartProtocol(String ani, String dnis, String ucid) {
        this.ani = ani;
        this.dnis = dnis;
        this.ucid = ucid;
    }

    public StartProtocol(String ani, String dnis, String ucid, String site, String platform, String channel, String other_ucid, String times, String calldata) {
        this.ani = ani;
        this.dnis = dnis;
        this.ucid = ucid;
        this.site = site;
        this.platform = platform;
        this.channel = channel;
        this.other_ucid = other_ucid;
        this.times = times;
        this.calldata = calldata;
    }

    public String getAni() {
        return ani;
    }

    public void setAni(String ani) {
        this.ani = ani;
    }

    public String getDnis() {
        return dnis;
    }

    public void setDnis(String dnis) {
        this.dnis = dnis;
    }

    public String getUcid() {
        return ucid;
    }

    public void setUcid(String ucid) {
        this.ucid = ucid;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public String getOther_ucid() {
        return other_ucid;
    }

    public void setOther_ucid(String other_ucid) {
        this.other_ucid = other_ucid;
    }

    public String getTimes() {
        return times;
    }

    public void setTimes(String times) {
        this.times = times;
    }

    public String getCalldata() {
        return calldata;
    }

    public void setCalldata(String calldata) {
        this.calldata = calldata;
    }

}
