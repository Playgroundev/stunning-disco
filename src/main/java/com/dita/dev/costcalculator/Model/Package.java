/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dita.dev.costcalculator.Model;

/**
 *
 * @author brian-kamau
 */
public class Package {
    
    private String name;
    
    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }
    
    @Override
    public String toString(){
        return "Package Name: " + name;
    }
    
    
}
