package com.project.appointmentapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class AppointmentappApplication {

    public static void main(String[] args) {
        SpringApplication.run(AppointmentappApplication.class, args);
    }

}
