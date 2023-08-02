/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.blazartech.completablefuturedemo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 *
 * @author aar1069
 */
@SpringBootApplication
@Slf4j
public class CompletableFutureDemo {

    public static void main(String[] args) {
        SpringApplication.run(CompletableFutureDemo.class, args);
        
        // force the process to end
        log.info("all setup, shutting down");
        System.exit(0);
    }
}
