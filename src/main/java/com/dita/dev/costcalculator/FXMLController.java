package com.dita.dev.costcalculator;


import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.validation.RequiredFieldValidator;
import java.awt.event.ActionListener;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

public class FXMLController implements Initializable {
    
    @FXML
    private Label label;
    
    @FXML
    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
        label.setText("Hello World!");
    }
    
    @FXML 
    private JFXTextField txtName;
    @FXML
    private TextField txtAccountNo;
    
  /*  @FXML 
    private ProgressIndicator progress;
    */
    @FXML private JFXTextField txtPhone;
    @FXML private JFXTextField txtAddress;
    @FXML private JFXButton btnCalculate;
    @FXML private Button Exit;
    @FXML private JFXComboBox cmbModel;
    @FXML private JFXComboBox cmbPackage;
    @FXML private Pane pnlMain;
    @FXML private JFXComboBox cmbPaint;
    @FXML private JFXComboBox cmbPayment;
    @FXML private JFXButton btnPrice;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {
        RequiredFieldValidator validator = new RequiredFieldValidator();
        //validator.setIcon(MaterialIcon.WARNING);
        validator.setMessage("Input Required");
        getName().getValidators().add(validator);
        
        String account_number = "123644";
        txtAccountNo.setText(account_number);
        ObservableList<String> options = FXCollections.observableArrayList("1",
                "2");
        cmbPackage.setItems(options);
        pnlMain.setStyle("-fx-border-color: black");
        generatePriceHandler();
                
    }
    
    @FXML
    private void handleExit(ActionEvent event){
        System.exit(0);
    }
    
    public JFXTextField getName(){
        return txtName;
    }
    
    public JFXTextField getPhoneNumber(){
        return txtPhone;
    }
    public JFXTextField getAddress(){
        return txtAddress;
    }
    public JFXComboBox getModel(){
        return cmbModel;
    }
    public JFXComboBox getPackage(){
        return cmbPackage;
    }
    public JFXComboBox getPaintDetail(){
        return cmbPaint;
    }
    public JFXComboBox getPaymentDetails(){
        return cmbPayment;
    }
    public JFXButton generatePrice(){
        return btnPrice;
    }
    
    public void generatePriceHandler(){
        generatePrice().setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                if(!getName().validate()){
                    return;
                }
                
            }
            
        });
       
    }
    
        
}
