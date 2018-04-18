package com.dita.dev.costcalculator;


import com.jfoenix.controls.JFXButton;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class FXMLController implements Initializable {
    
    @FXML
    private Label label;
    
    @FXML
    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
        label.setText("Hello World!");
    }
    
    @FXML 
    private TextField txtName;
    @FXML
    private TextField txtAccountNo;
    
  /*  @FXML 
    private ProgressIndicator progress;
    */
    @FXML
    private TextField txtPhone;
    @FXML
    private TextField txtAddress;
    
    @FXML 
    private JFXButton btnCalculate;
    @FXML
    private Button Exit;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        String account_number = "123644";
        txtAccountNo.setText(account_number);
        
    } 
    
    
    @FXML
    private void handleExit(ActionEvent event){
        System.exit(0);
    }
}
