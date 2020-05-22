package com.profinch.fincluez.tlibrary;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class FinCluezTLibraryApplication {
    public static void main(String[] args) {
        SpringApplication.run(FinCluezTLibraryApplication.class, args);
    }

}
