package com.imooc.architect.showcase.wheel.mvc;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.lang.reflect.Method;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HandlerAdapter {
    private String path;
    private String requestMethod;
    private Method method;
    private Object bean;
}
