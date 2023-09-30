package com.anibalvillalva.auth.config;

import org.springframework.beans.factory.annotation.Value;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@EnableAsync
@Slf4j
public class Application {

    @Value("${api.environment}")
    private static String environment;
    public static void main(final String[] args) {
        log.info("Start on:", environment);
        SpringApplication.run(Application.class, args);
    }

}
