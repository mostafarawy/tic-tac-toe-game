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
public class main extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent main = FXMLLoader.load(getClass().getResource("main.fxml"));
        
        Scene scene = new Scene(main);
//        stage.initStyle(StageStyle.UNDECORATED);
        stage.setTitle("Tic Tac Toe Game");
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
