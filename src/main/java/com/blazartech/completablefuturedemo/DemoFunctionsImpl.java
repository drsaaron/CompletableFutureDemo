/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.blazartech.completablefuturedemo;

import java.util.concurrent.CompletableFuture;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 *
 * @author aar1069
 */
@Component
@Slf4j
public class DemoFunctionsImpl implements DemoFunctions {

    @Override
    @Async
    public CompletableFuture<Person> getPerson() {
        log.info("initializing person");
        Person p = new Person("Scott");
        
        try {
            Thread.sleep(2000);
        } catch (InterruptedException ex) {
            log.error(null, ex);
        }
        return CompletableFuture.completedFuture(p);
    }

    @Override
    @Async
    public CompletableFuture<Person> addAge(Person p) {
        log.info("adding age");
        p.setAge(25);
        return CompletableFuture.completedFuture(p);
    }
    
    
    @Override
    @Async
    public CompletableFuture<Person> addGender(Person p) {
        log.info("adding gender");
        p.setGender("male");
        return CompletableFuture.completedFuture(p);
    }
}
