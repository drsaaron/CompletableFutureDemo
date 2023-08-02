package com.blazartech.completablefuturedemo;

import java.util.concurrent.CompletableFuture;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author aar1069
 */
@Component
@Slf4j
public class DemoCommandLineRunner implements CommandLineRunner {

    @Autowired
    private DemoFunctions demoFunctions;

    @Override
    public void run(String... args) throws Exception {
        log.info("running demo");

        CompletableFuture<Person> person = demoFunctions.getPerson()
                .thenCompose(p -> demoFunctions.addAge(p))
                .thenCompose(p -> demoFunctions.addGender(p));
        
        Person p = person.get();
        log.info("got person {}", p);
    }

}
