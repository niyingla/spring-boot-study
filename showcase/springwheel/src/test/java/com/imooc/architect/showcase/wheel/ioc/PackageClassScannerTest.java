package com.imooc.architect.showcase.wheel.ioc;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
class PackageClassScannerTest {

    @Test
    void scan() {
        PackageClassScanner scanner = new PackageClassScanner();
        Set<Class<?>> classSet = scanner.scan("com.imooc.architect.showcase.wheel.demo");
        for (Class<?> aClass : classSet) {
            log.info("class = {}",aClass.getSimpleName());
        }

    }
}