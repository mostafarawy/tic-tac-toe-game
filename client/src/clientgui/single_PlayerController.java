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
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

/**
 *
 * @author Mohamed Ibrahim
 */
public class single_PlayerController implements Initializable {
    
    @FXML
    private Label label;
    @FXML
    private Button bt1;
    @FXML
    private Button bt2;
    @FXML
    private Button bt3;
    @FXML
    private Button bt4;
    @FXML
    private Button bt5;
    @FXML
    private Button bt6;
    @FXML
    private Button bt7;
    @FXML
    private Button bt8;
    @FXML
    private Button bt9;
    @FXML
    private Button exit;
    @FXML
    private Pane gameUi;
    @FXML
    private Pane userUi;
    @FXML
    private Label player1_simple;
    @FXML
    private Label player1_score;
    @FXML
    private Label Player1_name;
    @FXML
    private Label Computer;
    @FXML
    private Label Computer_simple;
    @FXML
    private Label Computer_score;
    @FXML
    private AnchorPane single_player;
    @FXML
    private Button back;
    @FXML
    private Pane game_end;
    @FXML
    private Label game;
    @FXML
    private Button play_again;
    @FXML
    private Button back1;
    @FXML
    private Button exit1;
    



    @FXML
    private void ButtonAction(ActionEvent event) throws IOException {
        if(event.getSource()==exit || event.getSource()==exit1){
            System.exit(0);
        }
        
         if(event.getSource()==back || event.getSource()==back1){
            AnchorPane pane=FXMLLoader.load(getClass().getResource("main.fxml"));
            single_player.getChildren().setAll(pane);
        }
         
        if(event.getSource()==play_again){
            game_end.toBack();
        }

//         gameUi.toFront();
//            userUi.toFront();
        if(event.getSource()==bt1){
            bt1.setText("X");   //For test
            Player1_name.setText("Mohamed");    //For test
        }
        
        if(event.getSource()==bt2){
        }
        
        if(event.getSource()==bt3){
        }
        
        if(event.getSource()==bt4){
        }
        
        if(event.getSource()==bt5){
        }
        
        if(event.getSource()==bt6){
        }
        
        if(event.getSource()==bt7){
        }
        
        if(event.getSource()==bt8){
        }
        
        if(event.getSource()==bt9){
        }
        
        
       

    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    
}
