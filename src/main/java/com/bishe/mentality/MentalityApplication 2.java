package com.bishe.mentality;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.bishe.mentality.dao")
public class MentalityApplication {

    public static void main(String[] args) {
        SpringApplication.run(MentalityApplication.class, args);
    }

}
