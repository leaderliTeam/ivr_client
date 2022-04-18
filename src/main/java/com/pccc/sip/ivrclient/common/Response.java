package com.pccc.sip.ivrclient.common;

public class Response<T> {

    private String returnCode;

    private String returnMsg;

    private T data;

    private Response() {
    }

    private Response(ResponseEnum responseEnum) {
        this.returnCode = responseEnum.getReturnCode();
        this.returnMsg = responseEnum.getReturnMsg();
    }

    private Response(ResponseEnum responseEnum,T data) {
        this.returnCode = responseEnum.getReturnCode();
        this.returnMsg = responseEnum.getReturnMsg();
        this.data = data;
    }

    public static Response<Void> success() {
        return success(ResponseEnum.SUCCESS);
    }

    public static Response<Void> success(ResponseEnum responseEnum) {
        return success(responseEnum,null);
    }

    public static <T> Response<T> success(T data) {
        return success(ResponseEnum.SUCCESS,data);
    }

    public static <T> Response<T> success(ResponseEnum responseEnum,T data) {
        return new Response<>(responseEnum,data);
    }


    public static Response<Void> error() {
        return success(ResponseEnum.FAIL);
    }

    public static Response<Void> error(ResponseEnum responseEnum) {
        return success(responseEnum,null);
    }

    public static <T> Response<T> error(T data) {
        return success(ResponseEnum.FAIL,data);
    }

    public static <T> Response<T> error(ResponseEnum responseEnum,T data) {
        return new Response<>(responseEnum,data);
    }
}
