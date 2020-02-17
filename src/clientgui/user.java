/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientgui;

/**
 *
 * @author Mostafa
 */
import java.util.Vector;

/**
 *
 * @author Mostafa
 */
public class user {
    
    String username ; 
    int password ; 
    int score ; 
    int id1 ; 
    int id2 ;
    String move ;
    int loc; 
    
    boolean state ;
    String invitres  ;
    int ugame ;
    String  mysymbol ; 
    String  opponentsymbol ; 
    int gameid ;
    String action ; 
    String chat  ;
  Vector<user> vec = new Vector<user>();  
 
   user (){
   this.username ="" ; 
    this.password =0 ; 
    this.score =0; 
    this.id1 =0; 
    this.id2 =0;
    this.move ="";
    this.loc=0; 
   
    this.state =false;
    this.invitres ="" ;
    this.ugame=0 ;
    this.mysymbol ="";
    this.opponentsymbol="";
    this.gameid =0;
    this.action =""; 
    this.chat=""  ;
    Vector<user> vec = new Vector<user>();  
    }
    user (String _username ,int _password , int _score , int _id1 , int _id2,String _move , int _cell , boolean _state , String _action , String _inviteres ,String _chat , String _mysymbol , String _opponentsymbol ){
    this.username =_username ; 
    this.password =password ; 
    this.score =_score; 
    this.id1 =_id1; 
    this.id2 =_id2;
    this.move =_move;
    this.loc=_cell; 
    this.state =false;
    this.invitres =_inviteres  ;
    this.ugame=0 ;
    this.mysymbol =_mysymbol;
    this.opponentsymbol=_opponentsymbol ;
    this.gameid =0;
    this.action =_action; 
    this.chat=_chat  ;
    
    Vector<user> vec = new Vector<user>(); 
    }
    
}

