package com.imooc.architect.showcase.wheel.ioc;

import java.util.Set;

public class ApplicationContext {
    private transient PackageClassScanner packageClassScanner;
    private final BeanFactory beanFactory;

    public ApplicationContext() {
        this.packageClassScanner = new PackageClassScanner();
        this.beanFactory = new BeanFactory();
    }

    public ApplicationContext(String packageName) {
        this();
        registerPackage(packageName);
        refresh();
    }

    public ApplicationContext(Class<?> clazz) {
        this();
        registerClass(clazz);
        refresh();
    }

    public void registerClass(Class<?> clazz) {
        this.beanFactory.registerClass(clazz);
    }

    public void refresh() {
        refreshBean();
    }

    private void refreshBean() {
        String[] beanNames = beanFactory.getBeanNames();
        for (String beanName : beanNames) {
            beanFactory.getBean(beanName);
        }
    }

    public void registerPackage(String packageName) {
        Set<Class<?>> classSet = packageClassScanner.scan(packageName);
        for (Class<?> aClass : classSet) {
            beanFactory.registerClass(aClass);
        }
    }
    public void close(){
        beanFactory.close();
    }

    public Object getBean(String beanName) {
        return beanFactory.getBean(beanName);
    }
    public <T> T getBean(Class<T> clazz) {
        return beanFactory.getBean(clazz);
    }

    public int getBeanCount() {
        return beanFactory.getBeanCount();
    }
    public BeanFactory getBeanFactory(){
        return beanFactory;
    }
}
