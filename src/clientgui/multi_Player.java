/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientgui;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Mohamed Ibrahim
 */
public class multi_Player extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent multi_Player = FXMLLoader.load(getClass().getResource("multi_Player.fxml"));
        
        Scene scene = new Scene(multi_Player);
//        stage.initStyle(StageStyle.UNDECORATED);   
        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
