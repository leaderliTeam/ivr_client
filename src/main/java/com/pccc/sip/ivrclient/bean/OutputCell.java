package com.pccc.sip.ivrclient.bean;

public class OutputCell {

    private String type;

    private String value;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "OutputSingle{" +
                "type='" + type + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}
