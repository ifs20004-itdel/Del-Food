/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.Connection;
import ConToDB.DBConnection;

/**
 *
 * @author samuel
 */
public class LoginController extends MultipleScene implements Initializable{
    
    @FXML
    private Button btnLogIn;
    
    @FXML
    private Button btnSignUp;
    
    @FXML
    private TextField tf_emailUsername;
    
    @FXML
    private PasswordField tf_password;
    
    @FXML
    private Label LogInMessageLabel;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //TODO      
    }
    
    @FXML
    public void logInButtonOnAction(ActionEvent event){
        
        if(tf_emailUsername.getText().isBlank()== false && tf_password.getText().isBlank()==false){               
                validateLogin();
                    
        }else{
            LogInMessageLabel.setText("Please enter email and password");
        }
    }
    
    @FXML
    public void signUpOnAction(ActionEvent event){
        //Move to scene Sign Up 
        moveScene("/Viewer/SignUpFXML.fxml",btnSignUp);
    }
    
    private void validateLogin() {
        DBConnection connectNow = new DBConnection();
        Connection conn = connectNow.getConnection();
        
        String validate = "SELECT COUNT(1) FROM `javafx-app`.account WHERE (email = '"+tf_emailUsername.getText()+"' AND password = '"+tf_password.getText()+"') OR (username = '"+tf_emailUsername.getText()+"' AND password = '"+tf_password.getText()+"');";

        try{
                Statement st = conn.createStatement();
                ResultSet rs = st.executeQuery(validate);
                
                while(rs.next()){
                    if(rs.getInt(1)==1){
                        LogInMessageLabel.setText("Login Successful!");
                        //Move to scene2
                        moveScene("/Viewer/MenuUtamaFXML.fxml",btnLogIn);
                    }else{
                        LogInMessageLabel.setText("Invalid Login. Please try again");
                    }  
                }
        }catch(Exception e){
            e.printStackTrace();
            e.getCause();
        }
    }      
     
}
