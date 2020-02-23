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
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author Mohamed Ibrahim
 */
public class Multi_playerController implements Initializable {
 /*----------------------- Multi player page elements --------------------------*/
    @FXML
    private AnchorPane multi_player;
    @FXML
    private Pane gameUi_m,userUi_m;
    @FXML
    private Button bt1_m,bt2_m,bt3_m,bt4_m,bt5_m,bt6_m,bt7_m,bt8_m,bt9_m,exit_m,back_m;
    @FXML
    private Label Player1_name_m,player1_symbol_m,player1_score_m,Player2_name_m,player2_symbol_m,player2_score_m;


                /*------------- Chat page elements -------------*/
    @FXML
    private TextField chat_inputText;
    @FXML
    private Button send_m;
    @FXML
    private TextArea chat_textarea;
                /*----------- Game end page elements -----------*/
    @FXML
    private Pane game_end_m;
    @FXML
    private Button play_again_m;
    @FXML
    private Button gameBack_m,gameExit_m;
    @FXML
    private Label gameEnd_m;
 /*----------------- Initializes Multi Player controller class. ----------------*/

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    @FXML
    private void multi_ButtonAction(ActionEvent event) throws IOException {
       if(event.getSource()==back_m){
           AnchorPane pane=FXMLLoader.load(getClass().getResource("Online_user.fxml"));
            multi_player.getChildren().setAll(pane);
        }
        
        if(event.getSource()==play_again_m){
            game_end_m.toBack();
        }
        
        if(event.getSource()==gameBack_m){
            game_end_m.toBack();
        }
        
        if(event.getSource()==gameExit_m||event.getSource()==exit_m){
            System.exit(0);
        }
        
        if(event.getSource()==bt1_m){
          game_end_m.toFront();
        }
        
        if(event.getSource()==send_m){    
//            ps.println(chat_inputText.getText());
            chat_inputText.setText("");
//            String s = dis.readLine();
//            chat_textarea.appendText("MSG From Server: " +s);
            String newline="\n";
            chat_textarea.appendText(newline);
        }
    }
    /*-----------------------------------------------------------------------------*/
    

    @FXML
    private void Multi_keyAction(KeyEvent event) {
    }
    
}
