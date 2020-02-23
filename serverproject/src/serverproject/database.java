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
 * @author Mostafa
 */
public class database {
   
   
    public user register( user us ) throws SQLException {
         Connection conn = null ;
        conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/game","postgres", "1234");
         PreparedStatement pst;    
         pst = conn.prepareStatement("insert into users (username , password , status) values ( ? , ? , ? ) ;");    
         pst.setString(1 , us.username );
         pst.setInt(2, us.password);
         pst.setBoolean(3, true);
         pst.executeUpdate();
         pst = conn.prepareStatement("select id from users where username like ? and password = ?  ;");    
         pst.setString(1 , us.username);
         pst.setInt(2, us.password);
         ResultSet rs= pst.executeQuery() ;
         rs.next() ;
         us.id1= rs.getInt(1);
         us.state=true ;
         return us ;
         
        }
    
     public user login(user us) throws SQLException {
         Connection conn = null ;
         conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/game","postgres", "1234");
         PreparedStatement pst;    
         pst = conn.prepareStatement("select count(id) from users where username like ? and password = ?  ;");    
         pst.setString(1 , us.username);
         pst.setInt(2, us.password);
         ResultSet rs= pst.executeQuery() ;
         rs.next() ;

         System.out.println(rs.getInt(1));

         if (rs.getInt(1)>0){  
         pst = conn.prepareStatement("update users set status=true where username like ? and password = ? ;");    
         pst.setString(1 , us.username);
         pst.setInt(2, us.password);
         pst.executeUpdate();
         pst = conn.prepareStatement("select id from users where username like ? and password = ?  ;");    
         pst.setString(1 , us.username);
         pst.setInt(2, us.password);
         rs= pst.executeQuery() ;
         rs.next() ;
         us.id1= rs.getInt(1);
         us.state= true ;
         return us ;
         }
         else {
         us.state=false ;
         return us ;
         }
        }
     /*
     public int recieveacceptinvite(user us) throws SQLException {
         Connection conn = null ;
         conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/game","postgres", "1234");
         PreparedStatement pst;    
         pst = conn.prepareStatement("select * from users where id= ?");    
         pst.setInt(1, us.id1);
         ResultSet rs= pst.executeQuery() ;
         rs.next() ;
         return us.id2;
     }
    */
    public void play(user us) throws SQLException {
        Connection conn = null ;
        conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/game","postgres", "1234");
        PreparedStatement pst;    
        pst = conn.prepareStatement("update games set ? = ? where gameid =? ;");    
        pst.setInt(1,us.loc);
        pst.setInt(2,us.symbol);
        pst.setInt(3,us.gameid);
        pst.executeUpdate();
        
        }
    public void receivegamefinish(user us) throws SQLException {
        Connection conn = null ;
        conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/game","postgres", "1234");
        PreparedStatement pst;    
        pst = conn.prepareStatement("update games set ? =  ? where gameid =? ;");    
        pst.setInt(1,us.loc);
        pst.setInt(2,us.symbol);
        pst.setInt(3,us.gameid);
        pst.executeUpdate();
        
        }
    
    public user sendonline (user us) throws SQLException{
         Connection conn = null ;
         conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/game","postgres", "1234");
         PreparedStatement pst;   
         pst = conn.prepareStatement("select * from users where status = true ");    
        ResultSet rs= pst.executeQuery() ;
        while(rs.next()){
         user m= new user ();
         m.id1=rs.getInt(1);
         m.username=rs.getString(2);
         m.score= rs.getInt(4);
         us.vec.add(m) ;
           }
        return us ;
      }
    public user receiveacceptinvitation (user us) throws SQLException{
         Connection conn = null ;
         conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/game","postgres", "1234");
         PreparedStatement pst;    
         pst = conn.prepareStatement("insert into games (user1id , user2id  ) values (? , ? )  "); 
         pst.setInt(1 , us.id1 );
         pst.setInt(2 , us.id2 );
        // pst.setString(3,"play");
         us.invitres ="accept" ;
         pst.executeQuery() ;
         pst = conn.prepareStatement("insert into games (user1id , user2id  ) values (? , ? )  ");
         return us ;
    }
    public void receivewin(user us) throws SQLException{
         Connection conn = null ;
         conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/game","postgres", "1234");
         PreparedStatement pst;    
         pst = conn.prepareStatement("update games set winner = ? wehere gameid =?  "); 
         pst.setInt(1 , us.id1 );
         pst.setInt(2 , us.gameid );
         pst.executeQuery() ;
    
    }
       
    
    
     public static void main(String[] args) throws IOException, SQLException {
        // TODO code application logic here
    user us =new  user ("mostafa" ,123456 ,1,1,1,1,1,true ,"login","") ;
    user m = null ;
    database ba =  new database ();
    m= ba.login(us);
    System.out.println(m.id1);
    System.out.println();
    System.out.println(m.password);
    System.out.println(m.id2);
    System.out.println(m.state);
    }

    
    
}
