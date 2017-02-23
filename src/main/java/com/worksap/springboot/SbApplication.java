package com.worksap.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

/**
 * Created by zzl on 16-12-28.
 */
@SpringBootApplication
public class SbApplication extends SpringBootServletInitializer {
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder applicationBuilder) {
        return applicationBuilder.sources(SbApplication.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(SbApplication.class, args);
    }
}
