package com.trootech.Hospitalappbackend;

import com.trootech.Hospitalappbackend.filter.CORSFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class HospitalAppBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(HospitalAppBackendApplication.class, args);
    }

    @Bean
    public CORSFilter corsFilter() {
        return new CORSFilter();
    }

}
