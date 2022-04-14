package com.pccc.sip.ivrclient.common;

public enum ResponseEnum {

    SUCCESS("0000","操作成功"),
    FAIL("9999","操作失败")
    ;
    private String returnCode;

    private String returnMsg;

    public String getReturnCode() {
        return returnCode;
    }

    public void setReturnCode(String returnCode) {
        this.returnCode = returnCode;
    }

    public String getReturnMsg() {
        return returnMsg;
    }

    public void setReturnMsg(String returnMsg) {
        this.returnMsg = returnMsg;
    }

    ResponseEnum(String returnCode, String returnMsg) {
        this.returnCode = returnCode;
        this.returnMsg = returnMsg;
    }
}
