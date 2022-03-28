package ticktacktoe.menu;

import ticktacktoe.Driver;
import ticktacktoe.game.Board;
import ticktacktoe.game.Games;
import ticktacktoe.game.Moves;
import ticktacktoe.game.Player;
import ticktacktoe.services.DataBaseServices;

public class PlayerVComputer {
    private int pickIndex;
    public PlayerVComputer(String name, DataBaseServices sqlServices){
        Player p1 = new Player('X');
        Player p2 = new Player('C');
        Board board = new Board();
        int whoGoesFirst = (int) (Math.random()*2);
        char goingFirst;
        char turn;
        if (whoGoesFirst == 0){
            goingFirst = p1.getPiecesTags();
        }else {
            goingFirst = p2.getPiecesTags();
        }
        turn = goingFirst;
        System.out.println("It's "+turn+"'s turn.");
        board.initBoard(p1,p2);
        Games game = new Games(name,board,1,p1,p2);
        game.setTurn(turn);
        sqlServices.writeToDataBase(game);
        continuation(turn,p1,p2,game,sqlServices);
    }
    public PlayerVComputer(char turn,Games game,DataBaseServices sqlServices){
        Player one = new Player('X');
        Player two = new Player('C');
        continuation(turn,one,two,game,sqlServices);
    }
    private void continuation(char turn, Player p1, Player p2, Games game,DataBaseServices sqlServices){
        Moves move = new Moves();
        while (true){
            if (turn == 'C'){
                System.out.println("Computer is moving\n");
                String[] randomMoves = {"1,4","1,2","1,5","2,1","2,5","2,3","3,2","3,6","3,5"
                        ,"4,1","4,5","4,7","5,1","5,2","5,3","5,4","5,6","5,7","5,8","5,9",
                        "6,3","6,5","6,9","7,4","7,8","7,5","8,7","8,5","8,9","9,8","9,5","9,6"};
                recursionPick(randomMoves,move,game.getBoardObject());
                String pick = randomMoves[pickIndex];
                move.movePiece(game.getBoardObject(),p1,p2,pick,'C');
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
            }else {
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

    private void recursionPick(String[] random,Moves move,Board board){
        pickIndex = (int) (Math.random()*random.length);
        String[] sp = random[pickIndex].split(",");
        int from = Integer.parseInt(sp[0]);
        int to = Integer.parseInt(sp[1]);

        if (!move.isValidMove(board,from,to,'C')){
            recursionPick(random,move,board);
        }else{
            return;
        }

    }
}
