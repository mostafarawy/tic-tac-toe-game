/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientgui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author Mohamed Ibrahim
 */
public class MainController implements Initializable {

    @FXML
    private Button btn_computer;
    @FXML
    private Button btn_player;
    @FXML
    private AnchorPane main;
    @FXML
    private Button exit;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void ButtonAction(ActionEvent e) throws IOException{
        if(e.getSource()==btn_computer){
            AnchorPane pane=FXMLLoader.load(getClass().getResource("single_Player.fxml"));
            main.getChildren().setAll(pane);
        }
        
        if(e.getSource()==btn_player){
            AnchorPane pane=FXMLLoader.load(getClass().getResource("signIn_signUp.fxml"));
            main.getChildren().setAll(pane);
        }
        
        if(e.getSource()==exit){
            System.exit(0);
        }
    }

    
}
