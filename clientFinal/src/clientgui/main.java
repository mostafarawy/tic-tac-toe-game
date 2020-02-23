/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientgui;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Mohamed Ibrahim
 * 
 */
public class main extends Application {
    boolean flag=true;
    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader SplashScreen=new FXMLLoader();
        FXMLLoader main=new FXMLLoader();
        FXMLLoader single_player=new FXMLLoader();
        FXMLLoader SignIn_SignUp=new FXMLLoader();
        FXMLLoader multi_player=new FXMLLoader();
        FXMLLoader online_user=new FXMLLoader();
        FXMLLoader invitation=new FXMLLoader();
        
        SplashScreen.setLocation(getClass().getResource("SplashScreen.fxml"));
        main.setLocation(getClass().getResource("main.fxml"));
        single_player.setLocation(getClass().getResource("single_player.fxml"));
        SignIn_SignUp.setLocation(getClass().getResource("SignIn_SignUp.fxml"));
        multi_player.setLocation(getClass().getResource("multi_player.fxml"));
        online_user.setLocation(getClass().getResource("online_user.fxml"));
        invitation.setLocation(getClass().getResource("invitation.fxml"));
        
        Parent root=main.load();
        Parent single=single_player.load();
        Parent Splash=SplashScreen.load();
        Parent SignInSignUp=SignIn_SignUp.load();
        Parent multiPlayer=multi_player.load();
        Parent onlineuser=online_user.load();
        Parent invite =invitation.load();
        
        MainController FS=main.getController();
        FS.test(flag);
        
        Scene scene = new Scene(Splash);
//        stage.initStyle(StageStyle.UNDECORATED);
        stage.setTitle("Tic Tac Toe Game");
        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
