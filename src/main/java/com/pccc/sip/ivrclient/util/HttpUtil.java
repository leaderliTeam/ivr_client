package com.pccc.sip.ivrclient.util;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.http.converter.json.GsonHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

public class HttpUtil {


    private static final RestTemplate restTemplate = initRestTemplate();

    public static RestTemplate initRestTemplate() {
        HttpComponentsClientHttpRequestFactory httpRequestFactory = new HttpComponentsClientHttpRequestFactory();
        httpRequestFactory.setConnectTimeout(45000);
        httpRequestFactory.setConnectionRequestTimeout(8000);
        httpRequestFactory.setReadTimeout(3000);
        RestTemplate restTemplate = new RestTemplate(httpRequestFactory);
        restTemplate.getMessageConverters().removeIf(c -> c.getClass() == MappingJackson2HttpMessageConverter.class);
        restTemplate.getMessageConverters().add(new GsonHttpMessageConverter());
        return restTemplate;
    }

    @SuppressWarnings("unchecked")
    public static Map<String, Object> postForSip(String url, Map<String, Object> request) {
        return restTemplate.postForObject(url, request, Map.class);
    }
}
