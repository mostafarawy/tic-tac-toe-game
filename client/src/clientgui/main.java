/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientgui;

import com.google.gson.Gson;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.application.Platform;
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
        public  String m ;
        public  String o ;
        public  int scoreb ;
        user us = new user() ;
        public  int x ;
        public String myname ;
        public  int y ;
        Gson jo= new Gson ();
        
    @Override
    public void start(Stage stage) throws Exception {
       
        Client u= new Client() ;
        FXMLLoader main=new FXMLLoader();
        main.setLocation(getClass().getResource("main.fxml"));
        Parent root=main.load();
        MainController FS=main.getController();
        Scene scene = new Scene(root);
        stage.setTitle("Tic Tac Toe Game");
        stage.setScene(scene);
        stage.show();
 
        new Thread(new Runnable() {
            @Override
            @SuppressWarnings("empty-statement")
            public void run() {
                System.out.println("in run");
                while(true)
                    
                {   try {
         {  String s = u.dis.readLine();
            us = jo.fromJson(s, user.class);
              FS.set(us);
          switch(us.action){
         case "serversendlogin":
           if (us.state==false){FS.test(false);}
        else{  x = us.id1  ;
           scoreb = us.score ; 
          myname = us.username ;
        Platform.runLater(new Runnable() {
        @Override public void run() {
            FS.setinv(us);
            
            
            FS.online();
        System.out.println(us.state);}});}
        break ;
        
         case "serversendregister":
       
         {     x= us.id1  ;
              scoreb =us.score ;
              myname = us.username ;
              Platform.runLater(new Runnable() {
            @Override public void run() {
                  
                FS.online();
                   System.out.println(us.state);}});}
                 break ;
        
        case "serveracceptinvitation":
             System.out.println(us.action);
          FS.resetgame();
     {    Platform.runLater(new Runnable() {
         @Override public void run() {
            System.out.println("inv acccepted");
            System.out.println(us.action);
            FS.gameend();
            FS.log();
            System.out.println(us.action);
            }});}
             break ;
          
        case "serversendplay":
             
         {  System.out.println("send play");
             Platform.runLater(new Runnable() {
        @Override public void run() {
            System.out.println("received play");
            FS.log();
            FS.buttonaction(us);
          }});}
       break ; 
     
        case "serversendinvitation":       
        {  System.out.println(us.id2);
    Platform.runLater(new Runnable() {
        @Override public void run() 
        {   FS.gameend();
            FS.inv();
           System.out.println(us.state);}});  }     
            break ;
       
        case "serversendupdate":  
            
        {  System.out.println(us.id2);
    Platform.runLater(new Runnable() {
        @Override public void run() 
        {   FS.setinv(us);
            FS.online();
           System.out.println(us.id2); 
           System.out.println(us.state);}});  }     
            break ;
      
        case "serversendpause":
             {  System.out.println(us.id2);
    Platform.runLater(new Runnable() {
        @Override public void run() 
        {  FS.receivepause();
           System.out.println(us.state);}});  }     
            break ;
            
        case "serversendresume":
             {  System.out.println(us.id2);
    Platform.runLater(new Runnable() {
        @Override public void run() 
        { 
            FS.receiveresume();
           System.out.println(us.state);}});  }     
            break ; 
             case "noti":       
     Platform.runLater(new Runnable() {
        @Override public void run() 
        {  FS.shownoti(us);
           System.out.println(us.state);}});       
            break ;
    
     case "serverdeclineinvitation":       
     Platform.runLater(new Runnable() {
        @Override public void run() 
        {  
        FS.sendupd();
        FS.gameend();
        FS.setinv(us);
        FS.online();
           System.out.println(us.state);}});       
            break ;
    
        case "serversendwin":       
  
        Platform.runLater(new Runnable() {
        @Override public void run() 
        {  
           FS.resetgame();
           FS.lose();
           System.out.println(us.state);}});       
            break ;
       
        case "serversenddraw" :
      Platform.runLater(new Runnable() {
        @Override public void run() 
        {  
           FS.resetgame();  
           FS.drawl();
           
           System.out.println(us.state);}});       
            break ; 
     
        case "serversendcancel" :
    
          Platform.runLater(new Runnable() {
        @Override public void run() 
        {  
            FS.sendupd();
           FS.resetgame();  
           FS.bck();
           FS.online();
           System.out.println(us.state);}});       
            break ; 
         
        case "serversendchat":   
           
         Platform.runLater(new Runnable() {
        @Override public void run() 
        {   FS.setchat(us);
           
            System.out.println(us.state);}});
            break ; 
            default :
            System.out.println("no valid action");
            }
                    } }catch (IOException ex) {
                        Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
                    }
}}}).start();      
        
        
    }
    
   

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
class Client
    {
   public      Socket mySocket;
   public     DataInputStream dis;
   public  static  PrintStream ps;
        
        public Client()
        {
            try{
     //       mySocket = new Socket ("10.145.3.91", 5008);
            mySocket = new Socket ("127.0.0.1", 5008);
            dis = new DataInputStream(mySocket.getInputStream());
            ps = new PrintStream(mySocket.getOutputStream());   
            
            }
            catch(IOException ex)
            {
            ex.printStackTrace();
            } 
        }
     
    }