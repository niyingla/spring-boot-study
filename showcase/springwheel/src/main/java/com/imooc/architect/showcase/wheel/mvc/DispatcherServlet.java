package com.imooc.architect.showcase.wheel.mvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.imooc.architect.showcase.wheel.ioc.ApplicationContext;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Collection;
@Slf4j
@WebServlet(urlPatterns = "/",
        initParams = {@WebInitParam(name = "basePackage",
                value = "com.imooc.architect.showcase.wheel.demo.mvc")}
)
public class DispatcherServlet extends HttpServlet {
    private ApplicationContext context;
    private HandlerMapping handlerMapping;
    private ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;

        HandlerAdapter handler = handlerMapping.getHandler(request);
        if (handler ==null){
            response.sendError(404);
            return;
        }

        Object bean = handler.getBean();
        Method method = handler.getMethod();

        try {
            Object invoke = method.invoke(bean);
            String value = objectMapper.writeValueAsString(invoke);
            response.getWriter().print(value);
            response.getWriter().close();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }


    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        initContext(config);
        initHandlerMapping();
    }

    private void initHandlerMapping() {
        this.handlerMapping = new HandlerMapping();
        Collection<Class<?>> registerClass = this.context.getBeanFactory().getRegisterClass();
        for (Class<?> aClass : registerClass) {
            scanAndReisterMapping(aClass);
        }

    }

    private void scanAndReisterMapping(Class<?> beanClass) {
        boolean annotationPresent = beanClass.isAnnotationPresent(RequestMapping.class);
        if (annotationPresent) {
            RequestMapping beanClassAnnotation = (RequestMapping) beanClass.getAnnotation(RequestMapping.class);
            Method[] methods = beanClass.getDeclaredMethods();
            for (Method method : methods) {
                boolean present = method.isAnnotationPresent(RequestMapping.class);
                if (present) {
                    RequestMapping methodAnnotation = method.getAnnotation(RequestMapping.class);
                    String path = beanClassAnnotation.path() + methodAnnotation.path();
                    String key = HandlerMapping.buildKey(path, methodAnnotation.method());

                    HandlerAdapter handlerAdapter = new HandlerAdapter(path, methodAnnotation.method(), method, context.getBean(beanClass));
                    handlerMapping.registerHandler(key, handlerAdapter);
                }
            }
        }
    }

    private void initContext(ServletConfig config) {
        String basePackage = config.getInitParameter("basePackage");
        ApplicationContext context = new ApplicationContext(basePackage);
        this.context = context;
    }
}
