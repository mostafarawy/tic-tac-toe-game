package serverproject;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import jdk.nashorn.internal.objects.NativeError;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author rim
 */
public class database {

    public user register(user us) throws SQLException {
        Connection conn = null;
        conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/game","postgres", "1234");
        PreparedStatement pst;
        pst = conn.prepareStatement("insert into users (username , password , score,status ,play) values ( ? , ? , 0 ,true ,false ) ;");
        pst.setString(1, us.username);
        pst.setInt(2, us.password);
        // pst.setBoolean(3, true);
        pst.executeUpdate();
        pst = conn.prepareStatement("select id from users where username like ? and password = ?  ;");
        pst.setString(1, us.username);
        pst.setInt(2, us.password);
        ResultSet rs = pst.executeQuery();
        rs.next();
        us = sendupdatee(us);
        us.action = "serversendregister";
        us.id1 = rs.getInt(1);
        us.state = true;
        us.id2 = us.id1;
        pst.close();
        conn.close();
        return us;

    }

    public user login(user us) throws SQLException {
        Connection conn = null;
        conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/game","postgres", "1234");
        PreparedStatement pst;
        pst = conn.prepareStatement("select count(id) from users where username like ? and password = ?  ;");
        pst.setString(1, us.username);
        pst.setInt(2, us.password);
        ResultSet rs = pst.executeQuery();
        rs.next();
        System.out.println("in login function" + rs.getInt(1));
        if (rs.getInt(1) > 0) {
            pst = conn.prepareStatement("update users set status=true , play = false where username like ? and password = ? ;");
            pst.setString(1, us.username);
            pst.setInt(2, us.password);
            pst.executeUpdate();
            pst = conn.prepareStatement("select id from users where username like ? and password = ?  ;");
            pst.setString(1, us.username);
            pst.setInt(2, us.password);
            rs = pst.executeQuery();
            rs.next();
            us.id1 = rs.getInt(1);
            us.id2 = us.id1;
            us = sendupdatee(us);
            us.action = "serversendlogin";
            //us.id1= rs.getInt(1);

            us.state = true;
            return us;
        } else {
            us.action = "serversendlogin";
            us.state = false;
            pst.close();
            conn.close();
            return us;
        }
    }

    public void play(user us) throws SQLException {
        Connection conn = null;
        conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/game","postgres", "1234");
        PreparedStatement pst = null;
        if (us.loc == 1) {
            pst = conn.prepareStatement("update games set loc1 = ? where gameid = ? ;");
        } else if (us.loc == 2) {
            pst = conn.prepareStatement("update games set loc2 = ? where gameid = ? ;");
        } else if (us.loc == 3) {
            pst = conn.prepareStatement("update games set loc3 = ? where gameid = ? ;");
        } else if (us.loc == 4) {
            pst = conn.prepareStatement("update games set loc4 = ? where gameid = ? ;");
        } else if (us.loc == 5) {
            pst = conn.prepareStatement("update games set loc5 = ? where gameid = ? ;");
        } else if (us.loc == 6) {
            pst = conn.prepareStatement("update games set loc6 = ? where gameid = ? ;");
        } else if (us.loc == 7) {
            pst = conn.prepareStatement("update games set loc7 = ? where gameid = ? ;");
        } else if (us.loc == 8) {
            pst = conn.prepareStatement("update games set loc8 = ? where gameid = ? ;");
        } else if (us.loc == 9) {
            pst = conn.prepareStatement("update games set loc9 = ? where gameid = ? ;");
        }

        //   pst.setString(1,us.move);
        pst.setString(1, us.mysymbol);
        pst.setInt(2, us.gameid);
        pst.executeUpdate();
        pst.close();
        conn.close();

    }

    public void usersignout(user us) throws SQLException {
        Connection conn = null;
        conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/game","postgres", "1234");
        PreparedStatement pst;

        pst = conn.prepareStatement("select count(id) from users where id =  ? and play = true  ;");
        pst.setInt(1, us.id1);
        ResultSet rs = pst.executeQuery();
        rs.next();
        if (rs.getInt(1) > 0) {
            pst = conn.prepareStatement("update games set  state = 'canelled' where gameid  = ? ;");
            pst.setInt(1, us.gameid);
            pst.executeUpdate();
        }
        pst = conn.prepareStatement("update users set status = false , play = false where id = ? ;");
        pst.setInt(1, us.id1);
        pst.executeUpdate();
        pst.close();
        conn.close();

    }

    public void userdeclined(user us) throws SQLException {
        Connection conn = null;
        conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/game","postgres", "1234");
        PreparedStatement pst;

        pst = conn.prepareStatement("select count(id) from users where id =  ? and play = true  ;");
        pst.setInt(1, us.id1);
        ResultSet rs = pst.executeQuery();
        rs.next();
        if (rs.getInt(1) > 0) {
            pst = conn.prepareStatement("update games set  state = 'canelled' where gameid  = ? ;");
            pst.setInt(1, us.gameid);
            pst.executeUpdate();
            pst = conn.prepareStatement("update users set status = true , play = false where id = ?  ;");
            pst.setInt(1, us.id1);
            pst.executeUpdate();
            pst = conn.prepareStatement("update users set status = true , play = false where id = ?  ;");
            pst.setInt(1, us.id2);
            pst.executeUpdate();
            pst.close();
            conn.close();
        }

    }

    public user checkbef(user us) throws SQLException {
        boolean j;
        Connection conn = null;
        conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/game","postgres", "1234");
        PreparedStatement pst;
        pst = conn.prepareStatement("select * from users where  id =? ");
        pst.setInt(1, us.id2);
        pst.executeQuery();
        ResultSet rs = pst.executeQuery();
        rs.next();
        j = rs.getBoolean(6);
        if (j == true) {
            us.action = "serverdeclineinvitation";
            us = sendupdatee(us);
            us.id2 = us.id1;

        }
        pst.close();
        conn.close();
        return us;
    }

    /*
    public user sendonline (user us) throws SQLException{
         Connection conn = null ;
         conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/game","postgres", "1234");
         PreparedStatement pst;   
         pst = conn.prepareStatement("select * from users where status = true and play = false ");    
         ResultSet rs= pst.executeQuery() ;
         while(rs.next()){
         user m= new user ();
         m.id1=rs.getInt(1);
         m.username=rs.getString(2);
         m.score= rs.getInt(4);
         if (m.id1==us.id1)
             continue ;
        us.vec.add(m) ;
        
           }
        
        return us ;
      }*/
    public user sendupdatee(user us) throws SQLException {
        us.vec.clear();
        Connection conn = null;

        conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/game","postgres", "1234");
        PreparedStatement pst;
        pst = conn.prepareStatement("select * from users where status = true and play = false ");
        ResultSet rs = pst.executeQuery();
        while (rs.next()) {
            user m = new user();
            m.id1 = rs.getInt(1);
            m.username = rs.getString(2);
            m.score = rs.getInt(4);
            if (m.id1 == us.id1) {
                continue;
            }
            us.vec.add(m);

        }
        us.id2 = us.id1;
        pst.close();
        conn.close();
        return us;

    }

    public static user sendall() throws SQLException {
        user us = new user();
        Connection conn = null;
        conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/game","postgres", "1234");
        PreparedStatement pst;
        pst = conn.prepareStatement("select * from users");
        ResultSet rs = pst.executeQuery();
        while (rs.next()) {
            user m = new user();
            m.id1 = rs.getInt(1);
            m.username = rs.getString(2);
            m.score = rs.getInt(4);
            us.vec.add(m);
        }
        pst.close();
        conn.close();
        return us;
    }

    /*
    public user checkpause(user us) throws SQLException{
          Connection conn = null ;
         conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/game","postgres", "1234");
         PreparedStatement pst;  
             
         pst = conn.prepareStatement("select count(gameid) from games where user1id =  ? and user2id =? and state = 'paused'  ;");    
         pst.setInt(1, us.id1);
         pst.setInt(2, us.id2);
         ResultSet rs= pst.executeQuery() ;
         rs.next() ;
         if (rs.getInt(1)>0){
         us=checkpause(us) ;
         }
    return us ;
    }
     */
 /*
    
    public user resume(user us) throws SQLException{
    int user1 =0 ;
   // int user2 =0 ;
   int  countx =0 ;
   int counto =0 ;
    Connection conn = null ;
    String arr[]  ;
    arr = new String[10];
    conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/game","postgres", "1234");
    PreparedStatement pst;  
    pst = conn.prepareStatement("select loc1 ,loc2 ,loc3 , loc4 ,loc5 , loc6 , loc7 , loc8 , loc9  from games where user1id= ? and user2id = ?  and state='paused' ;");    
    pst.setInt(1 ,us.id1);
    pst.setInt(2 ,us.id2);
    ResultSet rs= pst.executeQuery() ;
    rs.next() ;
            arr[1]= rs.getString(1);
            arr[2]= rs.getString(2);
            arr[3]= rs.getString(3);
            arr[4]= rs.getString(4);
            arr[5]= rs.getString(5);
            arr[6]= rs.getString(6);
            arr[7]= rs.getString(7);
            arr[8]= rs.getString(8);
            arr[9]= rs.getString(9);
          //  arr[10]= rs.getString(12);
          //  arr[11]= rs.getString(15);
            user1 = rs.getInt(10);
         // user2 = rs.getInt(11);
            for (int i=1 ; i<10 ; i++ ){
            if (arr[i]=="X"){
            arr[i]="X";     
            countx++ ;
             }
            else if (arr[i]=="O"){
          arr[i]="O";  
                counto++ ;
            }
            else{arr[i]="";}
            }
            if (countx <counto) {
            if (us.id1==user1){
            us.turn = "myturn" ;}
            else if (us.id2==user1){
              us.turn = "opponentturn" ;      
                    }  }
            else {if (us.id1==user1){
            us.turn = "opponentturn" ;}
            else if (us.id2==user1){
              us.turn = "myturn" ;      
                    }  }
     
    us.action="serversendresume" ;      
    return us; 
    }
    
     */
    public user receiveacceptinvitation(user us) throws SQLException {
        Connection conn = null;
        conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/game","postgres", "1234");
        PreparedStatement pst;
        pst = conn.prepareStatement("insert into games (user1id , user2id  ) values (? , ? )  ");
        pst.setInt(1, us.id1);
        pst.setInt(2, us.id2);
        pst.executeUpdate();
        pst = conn.prepareStatement("update users set play =true  where id in (? ,? )   ");
        pst.setInt(1, us.id1);
        pst.setInt(2, us.id2);
        pst.executeUpdate();
        pst = conn.prepareStatement("select gameid from games where user1id= ? and user2id = ?  ;");
        pst.setInt(1, us.id1);
        pst.setInt(2, us.id2);
        ResultSet rs = pst.executeQuery();
        rs.next();
        us.gameid = rs.getInt(1);
        us.action = "serveracceptinvitation";
        pst.close();
        conn.close();
        pst.close();
        conn.close();
        return us;
    }

    public void receivewin(user us) throws SQLException {
        Connection conn = null;
        conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/game","postgres", "1234");
        PreparedStatement pst;
        pst = conn.prepareStatement("update games set winner = ? , state= 'finished' where gameid =?  ");
        pst.setInt(1, us.id1);
        pst.setInt(2, us.gameid);
        pst.executeUpdate();
        pst = conn.prepareStatement("update users set score = score+10  where id = ?  ");
        pst.setInt(1, us.id1);
        pst.executeUpdate();
        pst = conn.prepareStatement("update users set play =false  where id in (? ,? )   ");
        pst.setInt(1, us.id1);
        pst.setInt(2, us.id2);
        pst.executeUpdate();
        pst.close();
        conn.close();
        // pst.setInt(2 , us.gameid);

    }

}
