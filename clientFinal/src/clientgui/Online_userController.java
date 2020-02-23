
package clientgui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;


public class Online_userController implements Initializable {
/*----------------- Online user page elements -----------------*/
    @FXML
    private AnchorPane online_user;
    @FXML
    private Button test;
    @FXML
    private TableView<?> table;
    @FXML
    private TableColumn<?, ?> id;
    @FXML
    private TableColumn<?, ?> name;
/*-----------------------------------------------------------------------------*/
/*----------------- Initializes Online user controller class. -----------------*/
    @FXML
    private TableColumn<?, ?> score;
    @FXML
    private TableColumn<?, ?> invite;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    


    @FXML
    private void onlineUserEventAction(ActionEvent event) throws IOException {
        if(event.getSource()==test){
            AnchorPane pane=FXMLLoader.load(getClass().getResource("invitation.fxml"));
            online_user.getChildren().setAll(pane);
        }
    }
    
}
