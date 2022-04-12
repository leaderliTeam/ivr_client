package com.pccc.sip.ivrclient.bean.ivr;

public class EventProtocol {

    private String name;

    private String param;

    private String priority;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getParam() {
        return param;
    }

    public void setParam(String param) {
        this.param = param;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    @Override
    public String toString() {
        return "EventProtocol{" +
                "name='" + name + '\'' +
                ", param='" + param + '\'' +
                ", priority='" + priority + '\'' +
                '}';
    }
}
