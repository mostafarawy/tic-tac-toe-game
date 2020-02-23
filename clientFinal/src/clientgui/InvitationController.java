
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


public class InvitationController implements Initializable {

    @FXML
    private AnchorPane invitation;
    @FXML
    private Label invite_text;
    @FXML
    private Button accept;
    @FXML
    private Button decline;
    @FXML
    private Button back_invite;
    @FXML
    private Button exit_invite;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void invite_ButtonAction(ActionEvent event) throws IOException {
        if(event.getSource()==accept){
            AnchorPane pane=FXMLLoader.load(getClass().getResource("multi_player.fxml"));
            invitation.getChildren().setAll(pane);
        }
        if(event.getSource()==decline){
            AnchorPane pane=FXMLLoader.load(getClass().getResource("online_user.fxml"));
            invitation.getChildren().setAll(pane);
        }
        if(event.getSource()==exit_invite){
            System.exit(0);
        }
    }
    
}
