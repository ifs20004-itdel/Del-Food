/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author samuel
 */
public abstract class MultipleScene {
    public void moveScene(String typeScene, Button btn){
                try{
                Parent root = FXMLLoader.load(getClass().getResource(typeScene));
                Stage stage = new Stage();
                Scene scene = new Scene(root);
                
                // Agar tombol close, minimize dan maximize tidak muncul pada main_form dan notification form
                if(typeScene == "/Viewer/MenuUtamaFXML.fxml"){
                    stage.initStyle(StageStyle.UNDECORATED);
                    }
                    else if(typeScene == "/Viewer/NotificationFXML.fxml"){
                    stage.initStyle(StageStyle.UNDECORATED);
                    }
                // Title aplikasi
                if(typeScene == "/Viewer/NotificationFXML.fxml"){
                    stage.setTitle("Notification");
                }else{
                    stage.setTitle("DEL FOOD");
                }
                stage.setScene(scene);
                stage.show();
        }
            catch(Exception ex){
                ex.printStackTrace();
                ex.getCause();
        }
        Stage stage = (Stage) btn.getScene().getWindow();
        stage.close();        
    };
}