
package clientgui;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

public class SignIn_SignUpController implements Initializable {
 
    Socket mySocket;
    DataInputStream dis;
    PrintStream ps;
    String ipn; 
    
    @FXML
    private AnchorPane login_reg;
    @FXML
    private Pane signUp,signIn;
    @FXML
    private TextField tfusername_signUp,tfusername_login,ip,socket;
    @FXML
    private PasswordField tfpass_signUp,tfPass_login;
    @FXML
    private Button btnSignUp,btnSignIn,SignUp,Conect;
    @FXML
    private ImageView backicon,mainicon;
    @FXML
    private Label login_valid,login_valid1,test1,test2,server;


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void login_regButtonAction(ActionEvent event) throws IOException {
        if(event.getSource()==btnSignUp){
            signIn.toFront();
        }
        
        if(event.getSource()==btnSignIn){
            AnchorPane pane=FXMLLoader.load(getClass().getResource("online_user.fxml"));
            login_reg.getChildren().setAll(pane);
        }
        
        if(event.getSource()==SignUp){
            signUp.toFront();
        }
        
        if(event.getSource()==Conect){
            ipn=ip.getText();
           String soc=socket.getText();
           int socn = Integer.parseInt(soc);			

            try{
                mySocket = new Socket (ipn, socn);
//                mySocket = new Socket ("10.145.3.91", 5008);
                dis = new DataInputStream(mySocket.getInputStream());
                ps = new PrintStream(mySocket.getOutputStream()); 
                server.setText("Server is Online");
            }
            catch(IOException ex){
                ex.printStackTrace();
                server.setText("Server is Offline");
            }
            
        }
    }
    
    
    
    @FXML
    private void login_regMouseEvent(MouseEvent event) throws IOException {
         if(event.getSource()==backicon){
            signUp.toBack();
        }
         
        if(event.getSource()==mainicon){
            AnchorPane pane=FXMLLoader.load(getClass().getResource("main.fxml"));
            login_reg.getChildren().setAll(pane);
        }
    }
    
}
