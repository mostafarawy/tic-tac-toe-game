/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serverproject;

import java.util.Vector;

public class user {
    String username ; 
    int password ; 
    int score ; 
    int id1 ; 
    int id2 ;
    int move ;
    int loc; 
    boolean state ;
    String invitres  ;
    int ugame ;
    int symbol ; 
    int gameid ;
    String action ; 
  Vector<user> vec = new Vector<user>();  
 
   user (){
   this.username ="" ; 
    this.password =0 ; 
    this.score =0; 
    this.id1 =0; 
    this.id2 =0;
    this.move =0;
    this.loc=0; 
    this.state =false;
    this.invitres ="" ;
    this.ugame=0 ;
    this.symbol =0; 
    this.gameid =0;
    this.action =""; 
    Vector<user> vec = new Vector<user>();  
    }
    user (String _username ,int _password , int _score , int _id1 , int _id2,int _move , int _cell , boolean _state , String _action , String _inviteres){
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
    this.symbol =0; 
    this.gameid =0;
    this.action =_action; 
    Vector<user> vec = new Vector<user>(); 
    }
    
}






