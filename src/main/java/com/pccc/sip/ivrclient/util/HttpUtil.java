package com.pccc.sip.ivrclient.util;

import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

public class HttpUtil {


    private static final RestTemplate restTemplate = initRestTemplate();

    public static RestTemplate initRestTemplate() {
        SimpleClientHttpRequestFactory factory = new SimpleClientHttpRequestFactory();
        factory.setConnectTimeout(5000);
        factory.setReadTimeout(3000);
        return new RestTemplate(factory);
    }

    public static Map<String,Object> postForSip(String url,Map<String,Object> request) {
        //TODO 补充restTemplate请求时逻辑
        return restTemplate.postForObject(url, request, Map.class);
    }
}
