/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package serverproject;

 //import java.sql.SQLException;

/**
 *
 * @author Mostafa
 *//*
public class Gamecontroller {
    int id1 ;
    int id2 ;
    
    database ba =new database() ;
    public void check(user us){   } ;
    
    public user serverreceivelogin(user us) throws SQLException{
                     
                        us=ba.login(us);
                        this.id1 =us.id1;
                        this.id2 =us.id1;
                        return us ;
    } ;
    
    public user serverreceiveregister(user us) throws SQLException{
                        us = ba.register(us) ;
                        this.id1 =us.id1;
                        this.id2 =us.id1;
                        return us ;
    
    } ; 
    
    public void serverreceiveinvitation(){} ; 
    
    public void serverreceiveacceptrefuseinvitation(){} ;
    
    public user serverreceiveplay(user us) throws SQLException{
                       ba.play(us);
                       us.action="serversendplay";
                       this.id2=us.id2 ;
                       
                       return us ;
    
    } ;
    
    public void serverreceivegamestatus(){} ;
    
    public user serverreceivechat(user us){
                        
                        System.out.println("in send chat function");
                        System.out.println(us.chat);
                        us.action="serversendchat";
                        
                        System.out.println(us.chat);
                        System.out.println(this.id1);
                        System.out.println(this.id2);
                        return us ;
    
    } ;
    
    
}
*/