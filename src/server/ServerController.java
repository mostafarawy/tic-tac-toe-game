/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import static java.awt.Color.red;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;

/**
 * FXML Controller class
 *
 * @author Mohamed Ibrahim
 */
public class ServerController implements Initializable {

    @FXML
    private Button TurnOn;
    @FXML
    private Button TurnOff;
    @FXML
    private ImageView close;
    @FXML
    private TextArea tfuser;
    @FXML
    private Label serverstatus;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
   

    @FXML
    private void handleMouseEvent(javafx.scene.input.MouseEvent event) {
        if(event.getSource()==close){
            System.exit(0);
        }
    }
    
    @FXML
    private void ButtonAction(ActionEvent e) {
        if(e.getSource()==TurnOn){
            serverstatus.setText("server is Online");
        }
        
        if(e.getSource()==TurnOff){
            serverstatus.setText("server is Offline");
        }
    }
    
}
