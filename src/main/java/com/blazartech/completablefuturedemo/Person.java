/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.blazartech.completablefuturedemo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author aar1069
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Person {
    
    private String name;
    private int age;
    private String gender;
    
    public Person(String name) {
        this.name = name;
    }
}
