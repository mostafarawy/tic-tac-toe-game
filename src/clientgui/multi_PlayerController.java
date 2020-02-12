/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientgui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author Mohamed Ibrahim
 */
public class multi_PlayerController implements Initializable {

    @FXML
    private Pane gameUi;
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
    private Pane userUi;
    @FXML
    private Label Player1_name;
    @FXML
    private Label player1_simple;
    @FXML
    private Label player1_score;
    @FXML
    private Label Player2_name;
    @FXML
    private Label player2_simple;
    @FXML
    private Label player2_score;
    @FXML
    private Button exit;
    @FXML
    private Label label;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void ButtonAction(ActionEvent event) {
         if(event.getSource()==exit){
            System.exit(0);
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
    
}
