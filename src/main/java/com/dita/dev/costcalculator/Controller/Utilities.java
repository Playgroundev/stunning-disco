/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dita.dev.costcalculator.Controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Properties;

/**
 *
 * @author brian-kamau
 */
public class Utilities {
    Properties properties = new Properties();
    InputStream inputStream;
    public  ArrayList<String> getCarModels(){
        ArrayList<String> models = new ArrayList<>();
        try{
            File file = new File("prices.properties");
            inputStream = new FileInputStream(file);
            properties.load(inputStream);
            Enumeration enumeration = properties.propertyNames();
            
            while(enumeration.hasMoreElements()){
                String key = (String)enumeration.nextElement();
                models.add(key);
            }
            
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return models;
    }
   
    
}
