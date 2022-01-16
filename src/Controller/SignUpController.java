/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import java.sql.Connection;
import java.sql.Statement;
import ConToDB.DBConnection;
import javafx.scene.control.Label;

/**
 * FXML Controller class
 *
 * @author samuel
 */
public class SignUpController extends MultipleScene implements Initializable {


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    
    @FXML
    private TextField tfUsername;
    @FXML
    private TextField tfEmail;
    @FXML
    private TextField tfPassword;
    @FXML
    private Button btnLogIn;    
    @FXML
    private Button btnSignUp;
    @FXML
    private Label messageLabel;
    

    @FXML
    private void signUpButtonOnAction (ActionEvent event) {
         
        
        if((tfUsername.getText().isBlank()== false && tfEmail.getText().isBlank()==false) && tfPassword.getText().isBlank()== false) {
            String query = "INSERT INTO account (username, email, password) VALUES ('"+tfUsername.getText() + "','" + tfEmail.getText() + "','" + tfPassword.getText()+ "')";
            // Establish the connection
            DBConnection connectNow = new DBConnection();
            Connection conn = connectNow.getConnection();
            
            Statement st;
            try{
                st = conn.createStatement();
                st.executeUpdate(query);
                messageLabel.setText("Sign Up Successfully!");
                //Move the Scene to notification
                moveScene("/Viewer/NotificationFXML.fxml",btnSignUp);
            }catch(Exception ex){
                ex.printStackTrace();
                ex.getCause();
            }
        }else{
            messageLabel.setText("Please fill the blank!");
        }
    
    }

    @FXML
    private void logInOnAction(ActionEvent event) {
        moveScene("/Viewer/LoginFXML.fxml",btnLogIn);
    }
    
}
