package clientgui;

import java.io.IOException;
import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author Mohamed Ibrahim
 */
public class Single_playerController implements Initializable {
    /*---------------------------- Single player page elements ----------------------------*/  
    @FXML
    private AnchorPane single_player;
    @FXML
    private Pane game_end,userUi,gameUi;
    @FXML
    private Button play_again,gameBack,gameExit,bt1,bt2,bt3,bt4,bt5,bt6,bt7,bt8,bt9,back,singleExit;
    @FXML
    private Label Computer,Computer_symbol,Computer_score,gameEnd,playerScore,player1_symbol,Player1_name;
    
    Button[] boardButtons;
    Boolean isGameEnds =false;
    int Xocount = 0; 
    Random r = new Random();
    int randomnum;
    boolean isFirstPlayerTurn = true;
    boolean computerTurn = false;
    /*-----------------------------------------------------------------------------*/

    /*--------------------- Initializes Single player controller class. -------------------*/
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
    }    
    
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
    String player="x";
    String computer="o";
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
//        boardButtons[0].setText("x");
//        boardButtons[1].setText("x");
//        boardButtons[2].setText("x");
//        if("x".equals(boardButtons[0].getText())&&"x".equals(boardButtons[1].getText())&&"".equals(boardButtons[2].getText())){
//        System.out.println("test");
//        }
        
        if (t00.equals(t01) && t00.equals(t02)&& !t00.equals("")) {
            wincolor(boardButtons[0],boardButtons[1],boardButtons[2]);
            isGameEnds = true;
                          game_end.toFront();
            gameEnd.setText("You are the winner");
            player_score+=100;
            String s=String.valueOf(player_score);
            Player1_name.setText("Mohamed");
            playerScore.setText(s);
            
//            if(isFirstPlayerTurn==false&&computerTurn==true){
//  
//            }
//            
//            if(computerTurn==true){
//                game_end.toFront();
//            gameEnd.setText("Computer is the winner");
//            Comp_score+=100;
//            String s1=String.valueOf(Comp_score);
//            Computer.setText(s1);
//            }
            
        }
        
     
        
        
 
        if (t10.equals(t11) && t10.equals(t12) && !t10.equals("")) {
            wincolor(boardButtons[3],boardButtons[4],boardButtons[5]);
            isGameEnds = true;
            game_end.toFront();
        }
 
        if (t20.equals(t21) && t20.equals(t22) && !t20.equals("")) {
            wincolor(boardButtons[6],boardButtons[7],boardButtons[8]);
            isGameEnds = true;
            game_end.toFront();
        }
 
        if (t00.equals(t10) && t00.equals(t20) && !t00.equals("")) {
            wincolor(boardButtons[0],boardButtons[3],boardButtons[6]);
            isGameEnds = true;
            game_end.toFront();
        }
 
        if (t01.equals(t11) && t01.equals(t21) && !t01.equals("")) {
            wincolor(boardButtons[1],boardButtons[4],boardButtons[7]);
            isGameEnds = true;
            game_end.toFront();
        }
 
        if (t02.equals(t12) && t02.equals(t22) && !t02.equals("")) {
            wincolor(boardButtons[2],boardButtons[5],boardButtons[8]);
            isGameEnds = true;
            game_end.toFront();
        }
 
        if (t00.equals(t11) && t00.equals(t22) && !t00.equals("")) {
            wincolor(boardButtons[0],boardButtons[4],boardButtons[8]);
            isGameEnds = true;
            game_end.toFront();
        }
 
        if (t02.equals(t11) && t02.equals(t20) && !t02.equals("")) {
            wincolor(boardButtons[2],boardButtons[4],boardButtons[6]);
            isGameEnds = true;
            game_end.toFront();
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
    private void Single_ButtonAction(ActionEvent event) throws IOException {
        if(event.getSource()==back){
            AnchorPane pane=FXMLLoader.load(getClass().getResource("main.fxml"));
            single_player.getChildren().setAll(pane);
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
            AnchorPane pane=FXMLLoader.load(getClass().getResource("main.fxml"));
            single_player.getChildren().setAll(pane);
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
    
}
