package com.spinic.scheduleruber;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableConfigurationProperties
@EnableFeignClients
@EnableScheduling
public class SchedulerUberApplication {

    public static void main(String[] args) {
        SpringApplication.run(SchedulerUberApplication.class, args);
    }

}
