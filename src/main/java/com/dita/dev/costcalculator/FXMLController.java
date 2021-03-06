package com.dita.dev.costcalculator;


import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.validation.RequiredFieldValidator;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.collections.ObservableList;
import javafx.collections.FXCollections;
import com.dita.dev.costcalculator.Controller.Utilities;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.concurrent.Task;
import javafx.scene.control.ProgressIndicator;

public class FXMLController implements Initializable {
    
    Utilities utilities = new Utilities();
    @FXML
    private Label label;
    
    @FXML
    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
        label.setText("Hello World!");
    }
    
    @FXML private JFXTextField txtName;
    @FXML private TextField txtAccountNo;
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
    @FXML private Label lblProcessing;
   
    @FXML private ProgressIndicator prgIndicator;
    private int counter= 0;
    Task worker;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {
        try{
            showProcess().setVisible(false);
        RequiredFieldValidator validator = new RequiredFieldValidator();
        //validator.setIcon(MaterialIcon.WARNING);
        validator.setMessage("Input Required");
        getName().getValidators().add(validator);
        
        validator = new RequiredFieldValidator();
        validator.setMessage("Input Required");
        getPhoneNumber().getValidators().add(validator);
        
        validator = new RequiredFieldValidator();
        validator.setMessage("Input Required");
        getAddress().getValidators().add(validator);
        
        generatePriceHandler();
        progressHandler();
        
        ObservableList<String> options = FXCollections.observableArrayList(utilities.getCarModels());
        getModel().setItems(options);
        
        ObservableList<String> packages = FXCollections.observableArrayList("Package A","Package B");
        getPackage().setItems(packages);
        
        ObservableList<String> paintJob = FXCollections.observableArrayList("Metallic","Normal");
        getPaintDetail().setItems(paintJob);
        
        ObservableList<String> paymentMethod = FXCollections.observableArrayList("Financing","Cash","Trade In");
        getPaymentDetails().setItems(paymentMethod);
        
        txtAccountNo.setText(utilities.generateSerial());
        }catch(Exception ex){
            ex.printStackTrace();
        }
        
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
    public ProgressIndicator showProcess(){
        return  prgIndicator;
    }
    public JFXButton getPrinter(){
        return btnCalculate;
    }
    
    public void generatePriceHandler(){
        generatePrice().setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                try{
                if(!getName().validate() || !getPhoneNumber().validate() || !getAddress().validate()){
                    return;                   
                }
                Alert.show("Welcome");
                }catch(Exception ex ){
                    ex.printStackTrace();
                }
            }           
        });       
    }
    
    public void progressHandler(){
        getPrinter().setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                try{
                    lblProcessing.setVisible(true);
                    showProcess().setVisible(true);
                    showProcess().setProgress(0);
                    worker = utilities.createWorker();
                    showProcess().progressProperty().unbind();
                    showProcess().progressProperty().bind(worker.progressProperty());
                    worker.messageProperty().addListener(new ChangeListener<String>(){
                        @Override
                        public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                            System.out.println(newValue);
                           // worker = utilities.createWorker();
                            lblProcessing.setVisible(false);
                         
                             
                        }                      
                    });
                }catch(Exception ex){
                    ex.printStackTrace();
                }               
                new Thread(worker).start();              
                counter =1;
            }           
        });
    } 
 }
