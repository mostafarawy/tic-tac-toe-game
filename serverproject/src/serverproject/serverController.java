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
import javafx.application.Platform;
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
 
    Serverproject serverproject = null ;
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

    user v = new user();
    Thread thread;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void ButtonAction(ActionEvent e) throws IOException, SQLException, Exception {
        if (e.getSource() == TurnOn) {
          
            
            database.sendall();
            v = database.sendall();
      
             new Thread(()->{
            
                try {
                    serverproject=   new Serverproject();
                } catch (IOException ex) {
                    Logger.getLogger(serverController.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(serverController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }).start();
    
           for (int i = 0; i < v.vec.size(); i++) {
                    
                    tfuser.appendText(v.vec.get(i).username + "\n" );
                }
           
            TurnOn.setDisable(true);
        }

        if (e.getSource() == TurnOff) {

            System.exit(0);

        }

    }

    @FXML
    private void handleMouseEvent(MouseEvent event) {
    }

    
}
