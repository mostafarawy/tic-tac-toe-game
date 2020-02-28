/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serverproject;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author ahmed
 */
public class serverController implements Initializable {

    @FXML
    private Label serverstatus;
    @FXML
    private Button TurnOn;
    @FXML
    private Button TurnOff;
    @FXML
    private ImageView close;
    @FXML
    private TextArea tfuser;
    
    Thread servthread;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void ButtonAction(ActionEvent e) throws IOException, SQLException{
        if(e.getSource() == TurnOn){
            
            try {
                new Serverproject();
                TurnOn.setDisable(true);
            } catch (IOException ex) {
                Logger.getLogger(serverController.class.getName()).log(Level.SEVERE, null, ex);
            }
          
        }
                   
         if(e.getSource()==TurnOff){
     
            System.exit(0);
        }
        

    }

    @FXML
    private void handleMouseEvent(MouseEvent event) {
    }
    

}