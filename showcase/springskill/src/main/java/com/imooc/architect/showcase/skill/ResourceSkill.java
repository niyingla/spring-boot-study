package com.imooc.architect.showcase.skill;

import org.springframework.core.io.ClassRelativeResourceLoader;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.FileSystemResourceLoader;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

/**
 * @author jimmy
 */
public class ResourceSkill {

    public ResourceLoader resourceLoader() {
        return new DefaultResourceLoader();
    }
    public ResourceLoader fileSystemResourceLoader() {
        return new FileSystemResourceLoader();
    }

    public ResourceLoader classRelativeResourceLoader() {
        return new ClassRelativeResourceLoader(ResourceSkill.class);
    }


    public ResourcePatternResolver resourcePatternResolver() {
        return new PathMatchingResourcePatternResolver();
    }



}
