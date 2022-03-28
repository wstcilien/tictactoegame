package ticktacktoe.menu;

import ticktacktoe.Driver;
import ticktacktoe.game.Board;
import ticktacktoe.game.Games;
import ticktacktoe.game.Moves;
import ticktacktoe.game.Player;
import ticktacktoe.services.DataBaseServices;

import java.sql.SQLException;

public class TwoPlayer {

    public TwoPlayer(String name,DataBaseServices sqlServices) throws SQLException {
        Player p1 = new Player('X');
        Player p2 = new Player('O');
        Board board = new Board();
        int whoGoesFirst = (int) (Math.random()*1);
        char goingFirst;
        char turn;
        if (whoGoesFirst == 0){
            goingFirst = p1.getPiecesTags();
        }else {
            goingFirst = p2.getPiecesTags();
        }
        turn = goingFirst;
        board.initBoard(p1,p2);
        Games game = new Games(name,board,2,p1,p2);
        game.setTurn(turn);
        System.out.println("It's "+turn+"'s turn.");
        if (sqlServices.writeToDataBase(game)){
            continuation(turn,p1,p2,game,sqlServices);
        }else{
            System.out.println("Name already exist");
        }
    }
    public TwoPlayer(char turn,Games game,DataBaseServices sqlServices){
        Player one = new Player('X');
        Player two = new Player('O');
        continuation(turn,one,two,game,sqlServices);
    }
    private void continuation(char turn, Player p1, Player p2, Games game,DataBaseServices sqlServices){
        Moves move = new Moves();
        while (true){
            System.out.println(turn+" enter your move in this format from,to for example 1,5");
            String input = Driver.scn.next();
            if (input.contains("quit")){
                return;
            }
            boolean valid = move.movePiece(game.getBoardObject(),p1,p2,input,turn);
            if (valid){
                if (game.getBoardObject().isAWinner(turn)){
                    System.out.println("Yayyyyy "+turn+" is a winner. Good job!");
                    game.setEndState();
                    game.winLose(turn);
                    sqlServices.updateFinalStateToDataBase(game);
                    return;
                }else {
                    if (turn==p1.getPiecesTags()){
                        turn = p2.getPiecesTags();
                    }else{
                        turn = p1.getPiecesTags();
                    }
                    sqlServices.updateToDataBase(game,game.getBoardObject());
                }
            }
            else{
                System.out.println(turn+" this is not a valid move because you can't move to a space that's not empty or you are trying to move" +
                        " to a space that's not\none space on the right, left, up, down, or in the middle of the board relative to the piece you are" +
                        " trying to move.\n");
            }
        }
    }


}
