package com.pccc.sip.ivrclient.core;

import com.pccc.sip.ivrclient.bean.SessionData;

import java.util.HashMap;
import java.util.Map;

public class DataCache {
    /**
     * 储存一通会话的中的变量
     */
    private static final Map<String, SessionData> SESSION_MAP = new HashMap<>();
}
