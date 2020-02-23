package computer;
import java.util.ArrayList;
import java.util.Scanner;

import javafx.scene.control.Button;

public class config {
    private static Scanner in = new Scanner(System.in);
    private static GameBoard GameBoard = new GameBoard();
    
    
    private static boolean gameEnded = false;
    private static boolean player = true;

    public static void main(String[] args){
//        System.out.println(GameBoard);
        while(!gameEnded){
            PlayerPosition PlayerPosition = null;
            if(player){
                PlayerPosition = makeMove();
                GameBoard = new GameBoard(GameBoard, PlayerPosition, Player.Cross);
            }else{
                GameBoard = findBestMove(GameBoard);
            }               
            player = !player;
                System.out.println(GameBoard);
                evaluateGame();
        }
    }

    private static GameBoard findBestMove(GameBoard GameBoard) {
        ArrayList<PlayerPosition> PlayerPositions = GameBoard.getFreePlayerPositions();
        GameBoard bestChild = null;
        int previous = Integer.MIN_VALUE;
        for(PlayerPosition p : PlayerPositions){
            GameBoard child = new GameBoard(GameBoard, p, Player.Circle);
            int current = min(child);
            //System.out.println("Child Score: " + current);
            if(current > previous){
                bestChild = child;
                previous = current;
            }
        }
        return bestChild;
    }

    public static int max(GameBoard GameBoard){
        GameStatus GameStatus = GameBoard.getGameStatus();
        if(GameStatus == GameStatus.CircleWin)
            return 1;
        else if(GameStatus == GameStatus.CrossWin)
            return -1;
        else if(GameStatus == GameStatus.Draw)
            return 0;
        ArrayList<PlayerPosition> PlayerPositions = GameBoard.getFreePlayerPositions();
        int best = Integer.MIN_VALUE;
        for(PlayerPosition p : PlayerPositions){
            GameBoard b = new GameBoard(GameBoard, p, Player.Circle);
            int move = min(b);
            if(move > best)
                best = move;
        }       
        return best;
    }

    public static int min(GameBoard GameBoard){
        GameStatus GameStatus = GameBoard.getGameStatus();
        if(GameStatus == GameStatus.CircleWin)
            return 1;
        else if(GameStatus == GameStatus.CrossWin)
            return -1;
        else if(GameStatus == GameStatus.Draw)
            return 0;
        ArrayList<PlayerPosition> PlayerPositions = GameBoard.getFreePlayerPositions();
        int best = Integer.MAX_VALUE;
        for(PlayerPosition p : PlayerPositions){
            GameBoard b = new GameBoard(GameBoard, p, Player.Cross);
            int move = max(b);
            if(move < best)
                best = move;
        }
        return best;
    }

    private static void evaluateGame(){
        GameStatus GameStatus = GameBoard.getGameStatus();
        gameEnded = true;
        switch(GameStatus){
            case CrossWin : 
                System.out.println("You Won!");
                break;
            case CircleWin : 
                System.out.println("Computer Won!");
                break;
            case Draw : 
                System.out.println("Draw!");
                break;
            default : gameEnded = false;
                break;
        }
    }

    public static PlayerPosition makeMove(){
        PlayerPosition PlayerPosition = null;
        Button [] b=new Button[9];
        		while(true){
//            System.out.print("Pick 0, 1 or 2 for column: ");
//            int column = getColOrRow();
//            System.out.print("Pick 0, 1 or 2 for row: ");
//            int row = getColOrRow();
//            PlayerPosition = new PlayerPosition(column, row);
        	int button=getbutton();
        	PlayerPosition=new PlayerPosition(b[button]);
        	
            if(GameBoard.isMarked(PlayerPosition))
                System.out.println("Already marked!");
            else break;
        }
        return PlayerPosition;
    }

    private static int getbutton(){
        int ret = -1;
        while(true){
            try{
                ret = Integer.parseInt(in.nextLine());
            } catch (NumberFormatException e){}
            if(ret < 0 | ret > 9)
                System.out.print("\nInvalid input.");
            else break;
        }
        return ret;
    }
}

final class PlayerPosition {
   
    private final Button bttn;

   
    public PlayerPosition(Button b){
        this.bttn=b;
    }
  
    public Button getbtn(){
	return this.bttn;
    }
}

enum Player{
    Cross, Circle
}

enum GameStatus {
    Incomplete, CrossWin, CircleWin, Draw
}

class GameBoard {
    private Button[] GameBoard; //e = empty, x = cross, o = circle.

    public GameBoard(){
        GameBoard = new Button[9];
        for(int y = 0; y < 9; y++)
               GameBoard[y].setText("");; //GameBoard initially empty
    }

    public GameBoard(GameBoard from, PlayerPosition PlayerPosition, Player sign){
        GameBoard = new Button[9];
        for(int y = 0; y < 9; y++) {
           GameBoard[y] = from.GameBoard[y];
        if (sign == Player.Cross)
			GameBoard[y].setText("x");
		else
			GameBoard[y].setText("o");}
    }

    public ArrayList<PlayerPosition> getFreePlayerPositions(){
        ArrayList<PlayerPosition> retArr = new ArrayList<PlayerPosition>();     
        for(int y = 0; y < 9; y++)
                if(GameBoard[y].getText()=="")
                    retArr.add(new PlayerPosition(GameBoard[y]));
        return retArr;
    }

    public GameStatus getGameStatus(){    
        if(hasWon("x"))
            return GameStatus.CrossWin;
        else if(hasWon("o"))
            return GameStatus.CircleWin;
        else if(getFreePlayerPositions().size() == 0)
            return GameStatus.Draw;
        else return GameStatus.Incomplete;
    }

    private boolean hasWon(String sign){ 
	int x;

	//Check diagonals
	if(GameBoard[0].getText()==sign && GameBoard[4].getText() == sign && GameBoard [9].getText()==sign)
	    return true;
	if(GameBoard[2].getText()==sign && GameBoard[4].getText() == sign && GameBoard [6].getText()==sign)
	    return true;

	//Check row
	for(x=0;x<9;x++){
		if(GameBoard[x].getText() != sign)
		    break;
	    if(x==9)
		return true;
	}

	//Check col
	for(x=0;x<3;x++){
		if(GameBoard[x].getText() != sign)
		    break;
	    if(x==9)
		return true;
	}
       	return false;
    }

    public boolean isMarked(PlayerPosition PlayerPosition){
    	for(int i=0;i<9;i++) {
        if(GameBoard[i].getText() != "")
            return true;}
        return false;
    }

    public String toString(){
        String retString = "\n";
        for(int y = 0; y < 3; y++){
                if(GameBoard[y].getText() ==  "x" || GameBoard[y].getText() == "o")
                    retString += "["+GameBoard[y]+"]";
                else
                    retString += "[ ]";
            }
            retString += "\n";
           
        return retString;
    }   

}