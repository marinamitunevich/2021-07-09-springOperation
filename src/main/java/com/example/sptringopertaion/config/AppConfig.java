package com.example.sptringopertaion.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

@Configuration
@EnableAsync

public class AppConfig {

    @Value("${outPut}")
    String filePath;

    @Bean
    public PrintWriter getPrintWriter() throws FileNotFoundException {
        return new PrintWriter(new FileOutputStream(filePath));
    }

    @Bean
    public Executor getExecutor(){
        return Executors.newFixedThreadPool(5);
    }

}
