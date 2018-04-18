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

    public String generateSerial(){
        String ALPHA_NUMERIC = "ABCDEFGHIJKLMNOPQRST0123456789";
         StringBuilder builder = new StringBuilder();
        try{
           
            for(int i = 0;i<16;i++){
                int character = (int)(Math.random()*ALPHA_NUMERIC.length());
                builder.append(ALPHA_NUMERIC.charAt(character));
            }
            
            
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return builder.toString();
    }
}
