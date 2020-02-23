/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serverproject;
import com.google.gson.Gson;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.SQLException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.stage.Stage;
/**
 *
 * @author Mostafa
 */
public class Serverproject extends Application {
ServerSocket serversocket;
Thread servthread;

    public Serverproject () throws IOException{
    serversocket= new ServerSocket(5005);
    servthread = new Thread(()->{
    while (true){
        try {
            Socket s = serversocket.accept();
            new chathandler(s);
        } catch (IOException ex) {
            Logger.getLogger(Serverproject.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    });
    }
        /**
         * @param args the command line arguments
         * @throws java.io.IOException
         */
        public static void main(String[] args) throws IOException {
            // TODO code application logic here
            new Serverproject() ;
        }

        @Override
        public void start(Stage primaryStage) throws Exception {
            // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }



    }       

   class chathandler extends Thread implements Runnable{
    database ba = new database ();
    DataInputStream dis   ;
    PrintStream ps ;
    int id1  ;
    int id2 ;
    static Vector <chathandler> clients = new Vector<>(); 
    public chathandler (Socket cs ) throws IOException{
    this.id1= 0;
    this.id2=0;
    dis = new DataInputStream (cs.getInputStream()) ;
    ps = new PrintStream (cs.getOutputStream());
    clients.add(this);
    start();
    }
    @Override
    public void run()
{   
        try {
            do
            {
                try {
                String str= dis.readLine();
                Gson g = new Gson () ;
                user us = new user() ;
                //  us = g.fromJson(str, user.class) ;
                us = g.fromJson(str, user.class);
                this.id1=us.id1;
        if (null != us.action)
                switch (us.action)
                {
                    case "register":
                        us=ba.register(us);
                        this.id1 =us.id1;
                        this.id2 =us.id1;
                        break;
                    case "login":
                        System.out.println("here first");
                         us=ba.login(us);
                        this.id1 =us.id1;
                        this.id2 =us.id1;
                        break;
                        case "getonline" :
                        System.out.println("here first");
                       ba.sendonline(us);
                       this.id2=us.id1 ;
                        break ;
                      case "play" :
                       ba.play(us);
                       this.id2=us.id2 ;
                        break;
                    case "invite":
                        us.action="invite" ;
                        this.id2=us.id2 ;
                        break ; 
                    case "acceptinvite":
                        us.action="accept";
                        this.id2=us.id2 ;
                        break ; 
                        
                       default :
                        System.out.println("no right option");
                } 
                str=str= g.toJson(us, user.class);
                sendMessageToAll(str , this.id2);
                } catch (IOException ex) {
                }  catch (SQLException ex) {
                    //Logger.getLogger(chathandler.class.getName()).log(Level.SEVERE, null, ex);
                }
            }  while(dis.readLine()!=null)  ;   }
                catch (IOException ex) {
           // Logger.getLogger(chathandler.class.getName()).log(Level.SEVERE, null, ex);
        }
}
void sendMessageToAll(String msg, int id2)
{
for(chathandler s: clients)
{
  System.out.println("first");
  System.out.println(s.id1);
  System.out.println(s.id2);
  System.out.println(s.id1);
  System.out.println(s.id2);
if (s.id1==this.id2){
   
s.ps.println(msg);

}

}


}}