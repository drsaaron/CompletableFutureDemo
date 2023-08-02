/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.blazartech.completablefuturedemo;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 *
 * @author aar1069
 */
@Component
@Slf4j
public class DemoArrayCommandLineRunner implements CommandLineRunner {

    @Autowired
    private DemoFunctions demoFunctions;

    private CompletableFuture<Person> buildPerson(String name) {
        return CompletableFuture.supplyAsync(() -> new Person(name))
                .thenCompose(p -> demoFunctions.addAge(p))
                .thenCompose(p -> demoFunctions.addGender(p));
    }

    private Person getPerson(CompletableFuture<Person> pf) {
        try {
            return pf.get();
        } catch (InterruptedException |ExecutionException ex) {
            log.error(null, ex);
            return null;
        } 
    }
    
    @Override
    public void run(String... args) throws Exception {
        log.info("running array demo");

        List<String> names = Arrays.asList("Scott", "Katheen", "Sarah", "Issak", "EVH", "Jimmy Page", "Eric Clapton");
        List<CompletableFuture<Person>> peopleList = names.stream()
                .map(p -> buildPerson(p))
                .collect(Collectors.toList());

        peopleList.stream()
                .map(f -> getPerson(f))
                .forEach(p -> log.info("got person {}", p));
    }

}
