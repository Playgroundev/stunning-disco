/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dita.dev.costcalculator;

import com.jfoenix.controls.JFXButton;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 *
 * @author brian-kamau
 */
public class AlertController implements Initializable {
    
    @FXML JFXButton okayButton;
    @FXML Button closeButton;
    @FXML Label messageLabel;

    
    @FXML 
    private void okayAction(ActionEvent event){
        closeAction(event);
    }
    @FXML
    private void closeAction(ActionEvent event){
        Stage stage = (Stage) closeButton.getScene().getWindow();
        stage.close();
    }
    
    public void setMessage(String message){
        messageLabel.setText(message);
        okayButton.requestFocus();
    }
    
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
    }
    
}
