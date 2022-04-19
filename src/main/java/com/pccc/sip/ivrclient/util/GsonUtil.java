package com.pccc.sip.ivrclient.util;

import com.google.gson.Gson;

public class GsonUtil {
    public static final Gson gson = new Gson();

    public static <T> T formJson(String json,Class<T> clazz) {
        return gson.fromJson(json,clazz);
    }

    public static String toJson(Object object) {
        return gson.toJson(object);
    }
}
