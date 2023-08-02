/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.blazartech.completablefuturedemo;

import java.util.concurrent.CompletableFuture;

/**
 *
 * @author aar1069
 */
public interface DemoFunctions {
    
    public CompletableFuture<Person> getPerson();
    public CompletableFuture<Person> addAge(Person name);
    public CompletableFuture<Person> addGender(Person p);
}
