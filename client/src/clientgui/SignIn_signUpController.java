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
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author Mohamed Ibrahim
 */
public class SignIn_signUpController implements Initializable {

    @FXML
    private PasswordField tfpass_signUp;
    @FXML
    private Button btnSignUp;
    @FXML
    private ImageView back;
    @FXML
    private PasswordField tfPass_login;
    @FXML
    private Button btnSignIn;
    @FXML
    private Button SignUp;
    @FXML
    private Pane signUp;
    @FXML
    private Pane signIn;
    @FXML
    private AnchorPane sign;
    @FXML
    private ImageView main;
    @FXML
    private TextField tfusername_login;
    @FXML
    private TextField tfusername_signUp;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void ButtonAction(ActionEvent event) {
        if(event.getSource()==SignUp){
            signUp.toFront();
        }
    }

    @FXML
    private void handleMouseEvent(MouseEvent event) throws IOException {
        if(event.getSource()==back){
            signIn.toFront();
        }
        
         if(event.getSource()==main){
            AnchorPane pane=FXMLLoader.load(getClass().getResource("main.fxml"));
            sign.getChildren().setAll(pane);
        }
    }
    
}
