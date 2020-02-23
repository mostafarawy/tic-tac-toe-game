package clientgui;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;


public class MainController implements Initializable {
    String path="src\\img\\music.mp3";
    Media media=new Media(new File(path).toURI().toString());
    MediaPlayer mediaplayer=new MediaPlayer(media);
    
    public boolean flag;
    @FXML
    private ImageView playMusic;
    @FXML
    private ImageView pauseMusic;

    void test(boolean flagc){
        flag=flagc;
    }
    /*---------------------------- Main page elements ----------------------------*/
    @FXML
    private Button btn_computer,btn_player,mainExit;
    @FXML
    private AnchorPane main;    
   /*-----------------------------------------------------------------------------*/   
    /*--------------------- Initializes Main controller class. -------------------*/
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }
    
    @FXML
    private void MainMouseAction(MouseEvent event) {
        if(event.getSource()==playMusic){
            mediaplayer.play();
        }
        
        if(event.getSource()==pauseMusic){
            mediaplayer.pause();
        }
    }
   
    @FXML
    private void MainButtonAction(ActionEvent event) throws IOException {
   if(event.getSource()==btn_computer){
             AnchorPane pane=FXMLLoader.load(getClass().getResource("single_Player.fxml"));
            main.getChildren().setAll(pane);
        }
        
        if(event.getSource()==btn_player){
            AnchorPane pane=FXMLLoader.load(getClass().getResource("SignIn_SignUp.fxml"));
            main.getChildren().setAll(pane);
        }
        
        if(event.getSource()==mainExit){
            System.exit(0);
        }
    }
}