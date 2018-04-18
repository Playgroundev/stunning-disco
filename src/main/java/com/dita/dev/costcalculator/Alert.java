/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dita.dev.costcalculator;

import javafx.event.EventType;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author brian-kamau
 */
public class Alert {
    
    public static void show(String message){
        try{
            FXMLLoader loader = new FXMLLoader(Alert.class.getResource("/fxml/Alert.fxml"));
            Parent root = loader.load();
            AlertController controller = loader.getController();
            controller.setMessage(message);
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.centerOnScreen();
            stage.setResizable(false);
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.initStyle(StageStyle.UNDECORATED);
            stage.show();
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
    
}
