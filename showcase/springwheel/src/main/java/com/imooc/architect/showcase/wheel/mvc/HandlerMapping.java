package com.imooc.architect.showcase.wheel.mvc;

import com.google.common.base.Strings;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class HandlerMapping {

    private Map<String, HandlerAdapter> mapping = new ConcurrentHashMap<>();
    public HandlerAdapter getHandler(HttpServletRequest request) {
        String[] strings = buildKey(request);
        for (String string : strings) {
            HandlerAdapter handlerAdapter = mapping.get(string);
            if (handlerAdapter != null) {
                return handlerAdapter;
            }
        }
        return null;
    }
    public void registerHandler(String key, HandlerAdapter handlerAdapter) {
        mapping.put(key, handlerAdapter);
    }
    private String[] buildKey(HttpServletRequest request) {
        return new String[]{buildKey(request.getRequestURI(), request.getMethod())
                , buildKey(request.getRequestURI(), null)};
    }

    public static String buildKey(String path, String method) {
        StringBuilder sb = new StringBuilder();
        sb.append(path);
        sb.append("_");
        sb.append(Strings.nullToEmpty(method));
        return sb.toString();
    }
}
