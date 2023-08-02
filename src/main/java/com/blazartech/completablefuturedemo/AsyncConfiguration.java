package com.blazartech.completablefuturedemo;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.concurrent.Executor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

/**
 * enable asynchronous method execution via the @Async annotation.
 * 
 * @author AAR1069
 */
@Configuration
@EnableAsync
@Slf4j
public class AsyncConfiguration implements AsyncConfigurer {
    
    @Value("${threadPool.minSize:6}")
    private int minSize;

    @Value("${threadPool.maxSize:10}")
    private int maxSize;

    @Value("${threadPool.queueCount:10}")
    private int queueSize;

    @Value("${threadPool.threadPrefix:asyncThread-}")
    private String threadPrefix;

    @Override
    @Bean(destroyMethod = "shutdown")
    public Executor getAsyncExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(minSize);
        executor.setMaxPoolSize(maxSize);
        executor.setQueueCapacity(queueSize);
        executor.setThreadNamePrefix(threadPrefix);
        executor.initialize();
        return executor;
    }

    @Override
    public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
        return (ex, method, params) -> log.error("Uncaught async error", ex);
    }

}
