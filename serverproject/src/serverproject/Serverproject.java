/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serverproject;

import java.awt.TextArea;
import com.google.gson.Gson;
import com.sun.swing.internal.plaf.basic.resources.basic;
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
 * @author rim
 */
public class Serverproject extends Application {

    user v = new user();
    int i;
    Thread thread;

    ServerSocket serversocket;

    public Serverproject() throws IOException, SQLException {
        serversocket = new ServerSocket(5008);
        database.sendall();
        v = database.sendall();
        for (i = 0; i < v.vec.size(); i++) {

            System.out.println(v.vec.get(i).username + "/t" + v.vec.get(i).state);
        }

        while (true) {
            
            Socket s = serversocket.accept();
            new chathandler(s);
        }

    }

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    @Override
    public void start(Stage primaryStage) throws Exception {
        // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}

class chathandler extends Thread implements Runnable {

    database ba = new database();
    DataInputStream dis;
    PrintStream ps;
    int id1;
    int id2;
    int m;

    String mysymb;
    String Oppsymb;
    static Vector<chathandler> clients = new Vector<>();

    public chathandler(Socket cs) throws IOException {
        this.id1 = 0;
        this.id2 = 0;

        dis = new DataInputStream(cs.getInputStream());
        ps = new PrintStream(cs.getOutputStream());
        clients.add(this);
        start();
    }

    @Override
    public void run() {
        while (true) {

            try {

                String str = null;
                try {
                    str = dis.readLine();
                } catch (IOException ex) {
                    Logger.getLogger(chathandler.class.getName()).log(Level.SEVERE, null, ex);
                }
                Gson g = new Gson();
                user us = new user();
                us = g.fromJson(str, user.class);
                this.id1 = us.id1;
                System.out.println(us.action);
                switch (us.action) {
                    case "usersendlogin":
                        System.out.println("in login in switch");
                        us = ba.login(us);
                        break;

                    case "usersendregister":
                        us = ba.register(us);
                        break;
                    case "usersendchat":
                        us.action = "serversendchat";
                        break;
                    case "usersendplay":
                        // us = ba.sendonline(us);
                        ba.play(us);
                        us.action = "serversendplay";
                        break;
                    case "usersendinvitation":
                        us.action = "serversendinvitation";
                        us = ba.checkbef(us);
                        break;
                    case "useracceptinvitation":
                        //  us=ba.resume(us);
                        us = ba.receiveacceptinvitation(us);
                        us.action = "serveracceptinvitation";
                        break;
                    case "userdeclineinvitation":
                        ba.userdeclined(us);
                        us.action = "serverdeclineinvitation";
                        break;
                    case "usersendwin":
                        ba.receivewin(us);
                        us.action = "serversendwin";
                        break;
                    case "usersendupdate":
                        us = ba.sendupdatee(us);
                        us.action = "serversendupdate";
                        break;
                    case "usersendpause":
                        us.action = "serversendpause";
                        break;
                    case "usersendresume":
                        us.action = "serversendresume";
                        break;
                    case "usersenddraw":
                        us.action = "serversenddraw";
                        break;

                    case "usersendcancel":
                        ba.userdeclined(us);
                        us.action = "serversendcancel";
                        break;
                    case "usersendfinish":
                        ba.usersignout(us);
                        break;
                    
                    default:
                        System.out.println("no right option");

                }

                System.out.println(us.action);
                this.id1 = us.id1;
                this.id2 = us.id2;
                m = us.id2;
                us.id2 = us.id1;
                us.id1 = m;
                mysymb = us.mysymbol;
                us.mysymbol = us.opponentsymbol;
                us.opponentsymbol = mysymb;
                str = g.toJson(us, user.class);

                sendMessageToAll(str, this.id2);
                if (us.action == "serversendlogin" || us.action == "serversendregister" || us.action == "usersendfinish") {
                    user noti = new user();
                    noti.username = us.username;
                    if (us.action == "serversendlogin") {
                        noti.action = "noti";
                        noti.invitres = "isonline";
                    }
                    if (us.action == "serversendregister") {
                        noti.action = "noti";
                        noti.invitres = "isoffline";
                    }
                    if (us.action == "usersendfinish") {
                        noti.action = "noti";
                        noti.invitres = "isoffline";
                    }
                    str = g.toJson(noti, user.class);
                    send(str, this.id1);
                }

            } catch (SQLException ex) {
                Logger.getLogger(chathandler.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    void sendMessageToAll(String msg, int id2) {
        for (chathandler s : clients) {
            System.out.println("first");
            System.out.println(s.id1);
            System.out.println(s.id2);
            if (s.id1 == this.id2) {

                s.ps.println(msg);
            }
        }
    }

    void send(String msg, int id) {
        for (chathandler s : clients) {
            System.out.println("first");
            System.out.println(s.id1);
            System.out.println(s.id2);
            if (s.id1 == this.id1) {
                continue;
            }
            s.ps.println(msg);

        }
    }

//    public static void main(String[] args) throws IOException, SQLException {
//        // TODO code application logic here
//        new Serverproject();
//    }

}
