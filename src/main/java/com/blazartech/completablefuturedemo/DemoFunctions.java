/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.blazartech.completablefuturedemo;

import java.util.concurrent.CompletableFuture;
import org.springframework.scheduling.annotation.Async;

/**
 *
 * @author aar1069
 */
public interface DemoFunctions {
    
    @Async public CompletableFuture<Person> getPerson();
    @Async default public CompletableFuture<Person> addAge(Person p) { return addAge(p, 25); }
    @Async public CompletableFuture<Person> addAge(Person person, int age);
    @Async default public CompletableFuture<Person> addGender(Person p) { return addGender(p, "default"); }
    @Async public CompletableFuture<Person> addGender(Person p, String gender);
}
