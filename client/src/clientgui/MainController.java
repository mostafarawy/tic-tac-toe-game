
package clientgui;


import com.google.gson.Gson;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.*;
import java.util.Random;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import org.controlsfx.control.Notifications;

public class MainController implements Initializable {
   String turn ;
    user usr = new user() ;
    Gson jo = new Gson() ;
    
  //   Vector<onlineuser> onusr = new Vector <> () ;
 //  ObservableList<onlineuser> Data = FXCollections.observableArrayList();
    public boolean flag;
    int l ;
    @FXML
    private Label test1;
    @FXML
    private Label test2;
    @FXML
    private Button invite;
    @FXML
    private Button online_back;
    @FXML
    private Button refresh;
    private Label test;
    @FXML
    private Button chat_btn;
   
    

    
    
public void shownoti(user us){
Notifications.create().text(us.username+"isonline").showWarning();

}
    
    void test(boolean flagc){
        flag=flagc;
    }
    
    void set(user us){
    usr =us ;
    }
    
     user get(){
   return usr  ;
    }

    /*---------------------------- Main page elements ----------------------------*/
    @FXML
    private Button btn_computer,btn_player,mainExit;
    @FXML
    private AnchorPane main;
    String path="src\\img\\music.mp3";
    Media media=new Media(new File(path).toURI().toString());
    MediaPlayer mediaplayer=new MediaPlayer(media);
        @FXML
    private ImageView playMusic;
    @FXML
    private ImageView pauseMusic;
   /*-----------------------------------------------------------------------------*/   
   /*--------------------- Initializes Main controller class. -------------------*/
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    boardButtons = new Button[3*3];
        boardButtons[0] = bt1;
        boardButtons[1] = bt2;
        boardButtons[2] = bt3;
        boardButtons[3] = bt4;
        boardButtons[4] = bt5;
        boardButtons[5] = bt6;
        boardButtons[6] = bt7;
        boardButtons[7] = bt8;
        boardButtons[8] = bt9;  
        Player1_name.setText("Ali");
        
       
       
        
        
        
        
         
    }
    
    
    @FXML
    private void MainMouseAction(MouseEvent event) {
         if(event.getSource()==playMusic){
            mediaplayer.play();
        }
        
        if(event.getSource()==pauseMusic){
            mediaplayer.pause();
        }
    }
    
    @FXML
    private void MainButtonAction(ActionEvent event) throws IOException {
        if(event.getSource()==btn_computer){
           single_player.toFront();
        }
        
        if(event.getSource()==btn_player){
            login_reg.toFront();
        }
        
        if(event.getSource()==mainExit){
             usr.action="usersendfinish"  ;
           String str = jo.toJson(usr, user.class) ;
          Client.ps.println(str);
          Client.ps.close();
           
            System.exit(0);
        }
    }
    /*-----------------------------------------------------------------------------*/
    
    /************************************************************************************************/
    
    /*---------------------------- Single player page elements ----------------------------*/  
    @FXML
    private AnchorPane single_player;
    @FXML
    private Pane game_end,userUi,gameUi;
    @FXML
    private Button play_again,gameBack,gameExit,bt1,bt2,bt3,bt4,bt5,bt6,bt7,bt8,bt9,back,singleExit;
    @FXML
    private Label Computer;
    @FXML
    private Label Computer_symbol;
    @FXML
    private Label Computer_score;
    @FXML
    private Label gameEnd,playerScore,player1_symbol,Player1_name;
    Button[] boardButtons;
    Boolean isGameEnds =false;
    int Xocount = 0; 
    Random r = new Random();
    int randomnum;
    boolean isFirstPlayerTurn = true;
    boolean computerTurn = false;
    /*-------------------------------------------------------------------------------------*/
    /*--------------------- Initializes Single player controller class. -------------------*/
    public void disableButtons(){
        bt1.setDisable(true);
        bt2.setDisable(true);
        bt3.setDisable(true);
        bt4.setDisable(true);
        bt5.setDisable(true);
        bt6.setDisable(true);
        bt7.setDisable(true);
        bt8.setDisable(true);
        bt9.setDisable(true);
    }
     
    public void activeButtons(){
        bt1.setDisable(false);
        bt2.setDisable(false);
        bt3.setDisable(false);
        bt4.setDisable(false);
        bt5.setDisable(false);
        bt6.setDisable(false);
        bt7.setDisable(false);
        bt8.setDisable(false);
        bt9.setDisable(false);
    }
        
    public void resetButtons(){  
        bt1.setText("");
        bt2.setText("");
        bt3.setText("");
        bt4.setText("");
        bt5.setText("");
        bt6.setText("");
        bt7.setText("");
        bt8.setText("");
        bt9.setText("");      
        }
    
    public void wincolor(Button b1, Button b2, Button b3){
        b1.setStyle("-fx-background-color: linear-gradient(to bottom left,#371897,#2D75E6);");
        b2.setStyle("-fx-background-color: linear-gradient(to bottom left,#371897,#2D75E6);");
        b3.setStyle("-fx-background-color: linear-gradient(to bottom left,#371897,#2D75E6);");
    }
    
    public void resetwincolor(){
        bt1.setStyle("-fx-background-color:#ffffff");
        bt2.setStyle("-fx-background-color:#ffffff");
        bt3.setStyle("-fx-background-color:#ffffff");
        bt4.setStyle("-fx-background-color:#ffffff");
        bt5.setStyle("-fx-background-color:#ffffff");
        bt6.setStyle("-fx-background-color:#ffffff");
        bt7.setStyle("-fx-background-color:#ffffff");
        bt8.setStyle("-fx-background-color:#ffffff");
        bt9.setStyle("-fx-background-color:#ffffff");
    }
    
    int player_score = 0;
    int Comp_score = 0;
    public void checkWinnerAndGameEnd(){
        String t00 = boardButtons[0].getText();
        String t01 = boardButtons[1].getText();
        String t02 = boardButtons[2].getText();
        String t10 = boardButtons[3].getText();
        String t11 = boardButtons[4].getText();
        String t12 = boardButtons[5].getText();
        String t20=  boardButtons[6].getText();
        String t21 = boardButtons[7].getText();
        String t22 = boardButtons[8].getText();
    
        if (t00.equals(t01) && t00.equals(t02)&& !t00.equals("")) {
            wincolor(boardButtons[0],boardButtons[1],boardButtons[2]);
            isGameEnds = true;
            game_end.toFront();
            gameEnd.setText("You are the winner");
            player_score+=100;
            String s=String.valueOf(player_score);
            playerScore.setText(s);           
        }

        if (t10.equals(t11) && t10.equals(t12) && !t10.equals("")) {
            wincolor(boardButtons[3],boardButtons[4],boardButtons[5]);
            isGameEnds = true;
            game_end.toFront();
            gameEnd.setText("You are the winner");
            player_score+=100;
            String s=String.valueOf(player_score);
            playerScore.setText(s); 
        }
 
        if (t20.equals(t21) && t20.equals(t22) && !t20.equals("")) {
            wincolor(boardButtons[6],boardButtons[7],boardButtons[8]);
            isGameEnds = true;
            game_end.toFront();
            gameEnd.setText("You are the winner");
            player_score+=100;
            String s=String.valueOf(player_score);
            playerScore.setText(s);
        }
 
        if (t00.equals(t10) && t00.equals(t20) && !t00.equals("")) {
            wincolor(boardButtons[0],boardButtons[3],boardButtons[6]);
            isGameEnds = true;
            game_end.toFront();
            gameEnd.setText("You are the winner");
            player_score+=100;
            String s=String.valueOf(player_score);
            playerScore.setText(s);
        }
 
        if (t01.equals(t11) && t01.equals(t21) && !t01.equals("")) {
            wincolor(boardButtons[1],boardButtons[4],boardButtons[7]);
            isGameEnds = true;
            game_end.toFront();
            gameEnd.setText("You are the winner");
            player_score+=100;
            String s=String.valueOf(player_score);
            playerScore.setText(s);
        }
 
        if (t02.equals(t12) && t02.equals(t22) && !t02.equals("")) {
            wincolor(boardButtons[2],boardButtons[5],boardButtons[8]);
            isGameEnds = true;
            game_end.toFront();
            gameEnd.setText("You are the winner");
            player_score+=100;
            String s=String.valueOf(player_score);
            playerScore.setText(s);
        }
 
        if (t00.equals(t11) && t00.equals(t22) && !t00.equals("")) {
            wincolor(boardButtons[0],boardButtons[4],boardButtons[8]);
            isGameEnds = true;
            game_end.toFront();
            gameEnd.setText("You are the winner");
            player_score+=100;
            String s=String.valueOf(player_score);
            playerScore.setText(s);
        }
 
        if (t02.equals(t11) && t02.equals(t20) && !t02.equals("")) {
            wincolor(boardButtons[2],boardButtons[4],boardButtons[6]);
            isGameEnds = true;
            game_end.toFront();
            gameEnd.setText("You are the winner");
            player_score+=100;
            String s=String.valueOf(player_score);
            playerScore.setText(s);
        }
        
        if( Xocount >= 9)
        {
            isGameEnds = true;
            isFirstPlayerTurn = true;
            Xocount = 0;
            game_end.toFront();
            gameEnd.setText("No one is Winner!");
        }
    }
    
    private void setCurrentrSymbol() {
        if (isFirstPlayerTurn == true){
            player1_symbol.setText("X");
            Computer_symbol.setText("O");
        }
        else{
            player1_symbol.setText("O");
            Computer_symbol.setText("X");
        }   
    }
                    
    @FXML
    private void Single_ButtonAction(ActionEvent event) {
        if(event.getSource()==back){
            single_player.toBack();
        }
        
        if(event.getSource()==play_again){
            isGameEnds =false;
            Xocount = 0;
            game_end.toBack();
            resetButtons();
            activeButtons();
            resetwincolor();
        }
        
        if(event.getSource()==gameBack){
             single_player.toBack();
        }
        
        if(event.getSource()==gameExit||event.getSource()==singleExit){
            System.exit(0);
        }
        
            Button clickedButton = (Button) event.getSource();
         if(isGameEnds == false && clickedButton.getText().equals("")){
                Xocount++;
                clickedButton.setStyle("-fx-text-fill:#861515");
                clickedButton.setText("X");
                checkWinnerAndGameEnd();
                if(isGameEnds == false){
                    disableButtons();
                    Xocount++;
                    isFirstPlayerTurn = false;
                      for (;;) {
                        randomnum = r.nextInt(9);
                        if (boardButtons[randomnum].getText().equals(""))
                        {
                             computerTurn = false;  
                             boardButtons[randomnum].setStyle("-fx-text-fill:#2540a1");
                             boardButtons[randomnum].setText("O");
                            break;
                        }
                    }
                    checkWinnerAndGameEnd();
                    activeButtons();
                
                }
         }
    }
    /*-------------------------------------------------------------------------------------*/
    
    /************************************************************************************************/
    
    /*-------------------- SignIn and SignUp page elements ------------------------*/
    @FXML
    private AnchorPane login_reg;
    @FXML
    private Pane signUp,signIn;
    @FXML
    private TextField tfusername_signUp,tfusername_login;
    @FXML
    private PasswordField tfpass_signUp,tfPass_login;
    @FXML
    private Button btnSignUp,btnSignIn,SignUp;
    @FXML
    private ImageView backicon,mainicon;
     @FXML
    private TextField ip;
    @FXML
    private TextField socket;
    @FXML
    private Button connect;
    /*-----------------------------------------------------------------------------*/
    /*-------------- Initializes SignIn and SignUp controller class. --------------*/
    @FXML
    private void login_regButtonAction(ActionEvent event) throws IOException {
        if(event.getSource()==btnSignUp){
            usr.username= tfusername_signUp.getText() ;
            usr.password=Integer.parseInt(tfpass_signUp.getText());
            usr.action= "usersendregister" ;
            String str = jo.toJson(usr, user.class) ;
            Client.ps.println(str);
        }
        
        if(event.getSource()==btnSignIn){
            usr.username= tfusername_login.getText() ;
            usr.password=Integer.parseInt(tfPass_login.getText());
            usr.action= "usersendlogin" ;
            String str = jo.toJson(usr, user.class) ;
            Client.ps.println(str);           
        }
        
        if(event.getSource()==SignUp){
            signUp.toFront();
        }
    }

    @FXML
    private void login_regMouseEvent(MouseEvent event) {
        if(event.getSource()==backicon){
            signUp.toBack();
        }
         
        if(event.getSource()==mainicon){
            login_reg.toBack();
        }
    }
    /*-----------------------------------------------------------------------------*/
    
    /************************************************************************************************/

    /*----------------------- Online user page elements ---------------------------*/
    @FXML
    private Label Ouser1,Ouser2,Ouser3,Ouser4,Ouser5;
    @FXML
    private Label Oscore1,Oscore2,Oscore3,Oscore4,Oscore5;
    @FXML
    private Button Oinvite1,Oinvite2,Oinvite3,Oinvite4,Oinvite5;
    @FXML
    private AnchorPane online_user;
 
    public void online (){
           online_user.toFront();
   }
    /*-----------------------------------------------------------------------------*/
     
    @FXML
    private void Onlineuser_ButtonAction(ActionEvent event) {
//        if(event.getSource()==invite){   
//           
//         }
//        
        if(event.getSource()==online_back){ 
            online_user.toBack();
        }
         Button ButtAr[] = new Button[5];
         ButtAr[0]= Oinvite1;
       ButtAr[1]= Oinvite2;
       ButtAr[2]= Oinvite3;
       ButtAr[3]= Oinvite4;
       ButtAr[4]= Oinvite5;
     
       for (int i = 0 ; i <usr.vec.size(); i++){
      if (usr.vec.get(i)==null)
          continue;
           if(event.getSource()==ButtAr[i]){ 
             turn = "myturn";
            send_m.setId("pause");
            System.out.println("in send invitation button");
            usr.id2= usr.vec.get(i).id1 ;
            usr.action="usersendinvitation";
            usr.mysymbol="X";
            usr.opponentsymbol="O";
            String str = jo.toJson(usr, user.class) ;
              Client.ps.println(str);
        }
    }}
    
    public void inv(){
     invitation.toFront();
    }    
    
   public void setinv(user usr){
      
       Label scorAr[] = new Label[5];
       Label arr[] = new Label[5] ;
   
       arr[0]= Ouser1;
       arr[1]= Ouser2;
       arr[2]= Ouser3;
       arr[3]= Ouser4;
       arr[4]= Ouser5;
       scorAr[0]= Oscore1;
       scorAr[1]= Oscore2;
       scorAr[2]= Oscore3;
       scorAr[3]= Oscore4;
       scorAr[4]= Oscore5;
      
           int i ;
        for ( i = 0 ; i<usr.vec.size() ;i++){
            if (usr.vec.get(i).username==null)
                continue ;
            arr[i].setText(usr.vec.get(i).username);
            //usr.vec.get(i).score.toString();
          //  scorAr[i].setText();
       System.out.println(usr.vec.get(i).username);
      
        
        } 
   
   }
    
   
    
    /*-----------------------------------------------------------------------------*/
    
    /************************************************************************************************/

    /*----------------------- Multi player page elements --------------------------*/
    @FXML
    private AnchorPane multi_player;
    @FXML
    private Pane gameUi_m,userUi_m;
    @FXML
    private Button bt1_m,bt2_m,bt3_m,bt4_m,bt5_m,bt6_m,bt7_m,bt8_m,bt9_m,exit_m,back_m;
  
    public void buttondisabled(){
        bt1_m.setDisable(true);
        bt2_m.setDisable(true);
        bt3_m.setDisable(true);
        bt4_m.setDisable(true);
        bt5_m.setDisable(true);
        bt6_m.setDisable(true);
        bt7_m.setDisable(true);
        bt8_m.setDisable(true);
        bt9_m.setDisable(true);
    } 
    
    public void buttonenabled(){
        bt1_m.setDisable(false);
        bt2_m.setDisable(false);
        bt3_m.setDisable(false);
        bt4_m.setDisable(false);
        bt5_m.setDisable(false);
        bt6_m.setDisable(false);
        bt7_m.setDisable(false);
        bt8_m.setDisable(false);
        bt9_m.setDisable(false);
    } 
    
    public boolean checkdraw (){
        boolean gamef =true ;
        Button [] b = new Button[10] ;
        b[1]= bt1_m ;
        b[2]= bt2_m ;
        b[3]= bt3_m ;
        b[4]= bt4_m ;
        b[5]= bt5_m ;
        b[6]= bt6_m ;
        b[7]= bt7_m ;
        b[8]= bt8_m ;
        b[9]= bt9_m ;
        for (int i =1 ; i <10 ;i++ ){
            if (b[i].getId()!="m"){
                gamef=false;
            }
        }
        return gamef ;
    }
    
    public void enable (){
        Button [] b = new Button[10] ;
        b[1]= bt1_m ;
        b[2]= bt2_m ;
        b[3]= bt3_m ;
        b[4]= bt4_m ;
        b[5]= bt5_m ;
        b[6]= bt6_m ;
        b[7]= bt7_m ;
        b[8]= bt8_m ;
        b[9]= bt9_m ;
        for (int i =1 ; i <=9 ;i++ ){
            if (b[i].getId()=="m")
                continue;
            b[i].setDisable(false);
        }
    
    }
    
    @FXML
    private Label Player1_name_m,player1_simple_m,player1_score_m,Player2_name_m,player2_simple_m,player2_score_m;
    @FXML
    private TextField chat_inputText;
    @FXML
    private Button send_m;
    @FXML
    private TextArea chat_textarea;
    @FXML
    private Pane game_end_m;
    @FXML
    private Button play_again_m,gameBack_m,gameExit_m;
    @FXML
    private Label gameEnd_m;
    @FXML
    private Button pause;
    
    public void clearchat (){
        resetgame();
        chat_textarea.clear();
    }
    
    public void setchat(user us){
        chat_textarea.appendText(us.chat);
        String Newline="\n";
        chat_textarea.appendText(Newline);
    }
    
    public String getchat(){
        String s = chat_inputText.getText();
        return s ;
    }
    
    int myscore ;
    public void setmyscore ( int _score){
        myscore = _score ;
    }
    
    int opscore ;
    public void setopscore ( int _score){
        opscore = _score ;
    }
    boolean gameend = false ;
    /*-----------------------------------------------------------------------------*/
    /*----------------- Initializes Multi Player controller class. ----------------*/
    public void resetbtm(){        
        bt1_m.setText("");
        bt2_m.setText("");
        bt3_m.setText("");
        bt4_m.setText("");
        bt5_m.setText("");
        bt6_m.setText("");
        bt7_m.setText("");
        bt8_m.setText("");
        bt9_m.setText("");               
    }
    
    public void setpause (){
        send_m.setId("pause");
        send_m.setText("pause");
    }
    
    public void setresume (){
        send_m.setId("pause");
        send_m.setText("resume");
    }
    public void sendupd(){
    usr.action="usersendupdate" ;
    String str = jo.toJson(usr, user.class) ;
    Client.ps.println(str);
    }
    
    @FXML
    private void multi_ButtonAction(ActionEvent event) throws IOException {
       if(event.getSource()==back_m){
           usr.action="usersendcancel";
           String str = jo.toJson(usr, user.class) ;
           Client.ps.println(str);
           usr.action="usersendupdate" ;
           str = jo.toJson(usr, user.class) ;
           Client.ps.println(str);
           multi_player.toBack();
           online_user.toFront(); 
        }

        if(event.getSource()==play_again_m){
            turn = "myturn";
            send_m.setId("pause");
            System.out.println("in send invitation button");
            //usr.id2= usr.vec.get(l).id1 ;
            usr.action="usersendinvitation";
            usr.mysymbol="X";
            usr.opponentsymbol="O";
            String str = jo.toJson(usr, user.class) ;
            Client.ps.println(str);
         }
        
        if(event.getSource()==gameBack_m){
            resetgame();
           usr.action="usersendcancel";
           String str = jo.toJson(usr, user.class) ;
             Client.ps.println(str);
           // game_end_m.toBack();
           // multi_player.toBack();
       //    usr.action="usersendupdate" ;
       //    str = jo.toJson(usr, user.class) ;
       //     Client.ps.println(str);
            multi_player.toBack();
            online_user.toFront();
             sendupd();
         }
        
        if(event.getSource()==gameExit_m||event.getSource()==exit_m){
            usr.action="usersendfinish"  ;
            String str = jo.toJson(usr, user.class) ;
            Client.ps.println(str);
            Client.ps.close();
            System.exit(0);
        }
      
        
        
        if(event.getSource()==bt1_m){
         if (bt1_m.getId()=="m"){ 
             System.out.println("enter valid cell");
         }else{
            bt1_m.setText(usr.mysymbol);
            bt1_m.setDisable(true);
            bt1_m.setId("m");
            buttondisabled();
            usr.action="usersendplay";
            usr.loc=1 ;
            usr.move ="loc1";
            check();
        }
            
        }
        
        if(event.getSource()==bt2_m){
            if ("m".equals(bt2_m.getId())){ 
             System.out.println("enter valid cell");
         }else{
            bt2_m.setText(usr.mysymbol);
            bt2_m.setDisable(true);
            bt2_m.setId("m");
            buttondisabled();
            usr.action="usersendplay";
            usr.loc=2 ;
            usr.move ="loc2";
            check() ;
           
            
        }}
        
        if(event.getSource()==bt3_m){
            if ("m".equals(bt3_m.getId())){ 
             System.out.println("enter valid cell");
         }else{
            bt3_m.setText(usr.mysymbol);
            bt3_m.setDisable(true);
            bt3_m.setId("m");
            buttondisabled();
            usr.action="usersendplay";
            usr.loc=3 ;
            usr.move ="loc3";
            check();
           
        }}
        
        if(event.getSource()==bt4_m){
            if ("m".equals(bt4_m.getId())){ 
             System.out.println("enter valid cell");
         }else{
            bt4_m.setText(usr.mysymbol);
            bt4_m.setDisable(true);
            bt4_m.setId("m");
            buttondisabled();
            usr.action="usersendplay";
            usr.loc=4 ;
            usr.move ="loc4";
            check();
           
            
        }}
        
        if(event.getSource()==bt5_m){
            if ("m".equals(bt5_m.getId())){ 
             System.out.println("enter valid cell");
           }else{
            bt5_m.setText(usr.mysymbol);
            bt5_m.setDisable(true);
            bt5_m.setId("m");
            buttondisabled();
            usr.action="usersendplay";
            usr.loc=5 ;
            usr.move ="loc5";
            
            check();
         }}
        
        if(event.getSource()==bt6_m){
            if ("m".equals(bt6_m.getId())){ 
             System.out.println("enter valid cell");
         }else{
            bt6_m.setText(usr.mysymbol);
            bt6_m.setDisable(true);
            bt6_m.setId("m");
            usr.action="usersendplay";
            buttondisabled();
            usr.move ="loc6";
            usr.loc=6 ;
           
            check();
            
        }}
        
        if(event.getSource()==bt7_m){
            if ("m".equals(bt7_m.getId())){ 
             System.out.println("enter valid cell");
         }else{
            bt7_m.setText(usr.mysymbol);
            bt7_m.setDisable(true);
            bt7_m.setId("m");
            usr.action="usersendplay";
            buttondisabled();
            usr.move ="loc7";
            usr.loc=7 ;
            
            check();
             
        }}
        if(event.getSource()==bt8_m){
            if ("m".equals(bt8_m.getId())){ 
             System.out.println("enter valid cell");
         }else{
             bt8_m.setText(usr.mysymbol);
            bt8_m.setDisable(true);
            bt8_m.setId("m");
            buttondisabled();
            usr.move ="loc8";
           usr.action="usersendplay";
            usr.loc=8 ;
            
            check();
      
        }}
        if(event.getSource()==bt9_m){
            if ("m".equals(bt9_m.getId())){ 
             System.out.println("enter valid cell");
         }else{
            bt9_m.setText(usr.mysymbol);
            bt9_m.setDisable(true);
            bt9_m.setId("m");
            buttondisabled();
            usr.move ="loc9";
            usr.action="usersendplay";
            usr.loc=9 ;
            
             check();
             
        }}
        
        if(event.getSource()==chat_btn){
            usr.action= "usersendchat" ;
            usr.chat=chat_inputText.getText(); ; 
            
            String str = jo.toJson(usr, user.class) ;
            Client.ps.println(str);
            
            chat_inputText.setText("me :"+usr.chat);
        }
        
        if(event.getSource()==pause)
                   
            {
                if (send_m.getId()=="pause"){
        if(turn=="myturn") 
        { buttondisabled();
        send_m.setId("resume");
        send_m.setText("resume");
        gameEnd_m.setText("paused");
        game_end_m.toFront();
        usr.action="usersendpause";
        Client.ps.println(jo.toJson(usr, user.class));
        }
        else {
            
         send_m.setId("resume");  
         send_m.setText("resume");
         gameEnd_m.setText("paused");
         game_end_m.toFront();       
        usr.action="usersendpause";
        Client.ps.println(jo.toJson(usr, user.class));       
               }
                }
                else{if(turn=="myturn") 
        { enable();
        send_m.setText("pause");
        send_m.setId("pause");
        game_end_m.toBack();
        usr.action="usersendresume";
         Client.ps.println(jo.toJson(usr, user.class));
        }else {
        send_m.setId("pause");            
        send_m.setText("pause");
        game_end_m.toBack();
        usr.action="usersendresume";
          Client.ps.println(jo.toJson(usr, user.class));       
                
                } } } }
    
    
    
    public void winl (){
        clearchat ();
        resetgame();
      gameEnd_m.setText("WON");
      game_end_m.toFront();
      }
    public void bck(){
    
    multi_player.toBack();
    }
    
    public void lose (){
        clearchat ();
        resetgame();
      gameEnd_m.setText("lost");
      game_end_m.toFront();
      }
    
        public void drawl (){
            clearchat ();
            resetgame();
      gameEnd_m.setText("DRAW");
      game_end_m.toFront();
      }
    
    public void check(){
        String t00 = bt1_m.getText();
        String t01 = bt2_m.getText();
        String t02 = bt3_m.getText();
        String t10 = bt4_m.getText();
        String t11 = bt5_m.getText();
        String t12 = bt6_m.getText();
        String t20=  bt7_m.getText();
        String t21 = bt8_m.getText();
        String t22 = bt9_m.getText();
      
        if (t00.equals(t01) && t00.equals(t02) && !t00.equals("")) {
             
            System.out.println("you won");
            usr.action="usersendwin" ;
            winl();
            }
 
     else   if (t10.equals(t11) && t10.equals(t12) && !t10.equals("")) {
            
            System.out.println("you won");
            usr.action="usersendwin" ;
            winl();
        }
 
     else    if (t20.equals(t21) && t20.equals(t22) && !t20.equals("")) {
          
         System.out.println("you won");
            usr.action="usersendwin" ;
            winl();
        }
 
   else      if (t00.equals(t10) && t00.equals(t20) && !t00.equals("")) {
          
            System.out.println("you won");
            usr.action="usersendwin" ;
            winl();
        }
 
  else       if (t01.equals(t11) && t01.equals(t21) && !t01.equals("")) {
          
      game_end_m.toFront(); 
            usr.action="usersendwin" ;
            winl();
        }
 
    else     if (t02.equals(t12) && t02.equals(t22) && !t02.equals("")) {
          
        System.out.println("you won");
            usr.action="usersendwin" ;
            winl();
        }
 
    else     if (t00.equals(t11) && t00.equals(t22) && !t00.equals("")) {
          
        System.out.println("you won");
            usr.action="usersendwin" ;
            winl();
        }
 
    else     if (t02.equals(t11) && t02.equals(t20) && !t02.equals("")) {
          
        System.out.println("you won");
                    winl();
            usr.action="usersendwin" ;
        }
        
     else if(checkdraw() == true)
        {   
           
            System.out.println("draw");
            usr.action="usersenddraw" ;
            
           drawl();
        }
       turn ="opponentturn" ;
               String str = jo.toJson(usr, user.class) ;
            Client.ps.println(str);
    }
    
    
    
    
    public void buttonaction(user usr){
    Button [] b = new Button[10] ;
     b[0]=null;
    b[1]= bt1_m ;
    b[2]= bt2_m ;
    b[3]= bt3_m ;
    b[4]= bt4_m ;
    b[5]= bt5_m ;
    b[6]= bt6_m ;
    b[7]= bt7_m ;
    b[8]= bt8_m ;
    b[9]= bt9_m ;
    System.out.println(b[usr.loc]);
    b[usr.loc].setText(usr.opponentsymbol);
    b[usr.loc].setId("m");
    b[usr.loc].setDisable(true); 
    enable();
   turn ="myturn";
    }
    
    /*-----------------------------------------------------------------------------*/
    
    /************************************************************************************************/

    /*----------------------- invitation page elements ---------------------------*/
    @FXML
    private AnchorPane invitation;
    @FXML
    private Label invite_text;
    @FXML
    private Button accept,decline,back_invite,exit_invite;
    /*-----------------------------------------------------------------------------*/
    /*------------------ Initializes invitation controller class. -----------------*/
   public void  gameend (){
   game_end_m.toBack();
   }
    


    @FXML
    private void invite_ButtonAction(ActionEvent event) {
        if(event.getSource()==accept){
           send_m.setId("pause");
            turn="opponentturn"; 
            invitation.toBack();
            game_end_m.toBack();
             resetgame();
             multi_player.toFront();
            buttondisabled();
            usr.action="useracceptinvitation";
            Client.ps.println(jo.toJson(usr, user.class));
        }
        
        if(event.getSource()==decline){
          invitation.toBack();
             
            usr.action="userdeclineinvitation";
           String str = jo.toJson(usr, user.class) ;
             Client.ps.println(str);
          //   usr.action="usersendupdate" ;
          //  str = jo.toJson(usr, user.class) ;
          //  Client.ps.println(str);
            multi_player.toBack();
            online_user.toFront();
             sendupd();
        }
        
        if(event.getSource()==back_invite){
          resetgame();
          game_end_m.toBack();
         invitation.toBack();
            usr.action="userdeclineinvitation";
           String str = jo.toJson(usr, user.class) ;
             Client.ps.println(str);
            
            multi_player.toBack();
            online_user.toFront();
             sendupd();
        }
        
        if(event.getSource()==exit_invite){
            usr.action="usersendfinish"  ;
           String str = jo.toJson(usr, user.class) ;
          Client.ps.println(str);
          Client.ps.close();
            System.exit(0);
        }
    }
    public void receivepause(){
    if (turn=="myturn"){
    send_m.setDisable(true);
    buttondisabled();
    gameEnd_m.setText("paused");
    game_end_m.toFront();
    }
    else{
         send_m.setDisable(true);
      gameEnd_m.setText("paused");
    game_end_m.toFront();
    }    
    }
    public void receiveresume(){
    if (turn=="myturn"){
    send_m.setDisable(false);
    enable();
    game_end_m.toBack();
    }
    else{
    send_m.setDisable(false);
    game_end_m.toBack();
    }   
    
    }
    
    public void log(){
        multi_player.toFront();
    }
    public void resetgame (){
    Button b[] = new Button[10] ;
    b[1]= bt1_m ;
    b[2]= bt2_m ;
    b[3]= bt3_m ;
    b[4]= bt4_m ;
    b[5]= bt5_m ;
    b[6]= bt6_m ;
    b[7]= bt7_m ;
    b[8]= bt8_m ;
    b[9]= bt9_m ;
    for (int i=1 ;i<10;i++){
    b[i].setId("");
    b[i].setDisable(false);
    b[i].setText("");
    
    }
    
    
    
    
    }
    
    
    @FXML
    private void Multi_keyAction(KeyEvent event) throws IOException {
        if(event.getSource()==chat_inputText){
//            ps.println(chat_inputText.getText());
//            chat_inputText.setText("");
//            String s = dis.readLine();
//            chat_textarea.appendText("MSG From Server: " +s);
//            String newline="\n";
//            chat_textarea.appendText(newline);      
        }
    }
    /*-----------------------------------------------------------------------------*/ 

   
}
class onlineuser{
public SimpleIntegerProperty id; 
public SimpleStringProperty name ;
public  SimpleIntegerProperty score ;
onlineuser(){
this.id =new SimpleIntegerProperty(0) ;
name=new SimpleStringProperty("") ; 
score =new SimpleIntegerProperty(0) ;}

onlineuser(int _id,String _name , int _score){
this.id=new SimpleIntegerProperty( _id) ; 
this.score =new SimpleIntegerProperty(_score) ;
this.name =new SimpleStringProperty(_name) ;
}


}