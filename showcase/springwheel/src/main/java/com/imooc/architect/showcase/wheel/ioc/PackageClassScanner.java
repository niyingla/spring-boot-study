package com.imooc.architect.showcase.wheel.ioc;

import org.apache.commons.lang3.StringUtils;

import javax.annotation.ManagedBean;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Set;

public class PackageClassScanner {

    public Set<Class<?>> scan(String packageName) {
        Set<Class<?>> classSet = new HashSet<>();
        ClassLoader classLoader = getClassLoader();

        try {
            String name = StringUtils.replace(packageName, ".", "/");
            Enumeration<URL> resources = classLoader.getResources(name);

            while (resources.hasMoreElements()) {
                URL url = resources.nextElement();
                String protocol = url.getProtocol();
                if ("file".equals(protocol)) {
                    String path = url.getPath();
                    //
                    scanFile(classSet, path, packageName);
                }


            }
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }


        return classSet;
    }

    private ClassLoader getClassLoader() {
        return Thread.currentThread().getContextClassLoader();
    }

    private void scanFile(Set<Class<?>> classSet, String path, String packageName) {
        File[] files = new File(path).listFiles(
                file -> {
                    return file.isDirectory()
                            || (file.isFile() && file.getName().endsWith(".class"));
                }
        );

        for (File file : files) {
            String name = file.getName();
            if (file.isFile()) {
                String className = name.substring(0, name.lastIndexOf("."));
                if (StringUtils.isNotEmpty(className)) {
                    className = packageName + "." + className;
                    addClass(classSet, className);
                }
            } else {
                scanFile(classSet, file.getPath(), packageName + "." + file.getName());
            }
        }
    }

    private void addClass(Set<Class<?>> classSet, String className) {
        try {
            Class<?> aClass = Class.forName(className, false, getClassLoader());
            if (aClass.isAnnotationPresent(ManagedBean.class)) {
                classSet.add(aClass);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
