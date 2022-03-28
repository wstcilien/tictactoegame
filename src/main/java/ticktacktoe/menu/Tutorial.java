package ticktacktoe.menu;

import ticktacktoe.Driver;
import ticktacktoe.game.Board;
import ticktacktoe.game.Moves;
import ticktacktoe.game.Player;

import java.util.concurrent.TimeUnit;

public class Tutorial {
    public Tutorial()  {
        String instructions = "In this form of TickTackToe, a player has 3 pieces and the goal is to align them diagonally to win. \nExample 1:\n" +
                "|*| | |       " + "| | |*|       " +"| | | |\n" +
                "| |*| |   or  " + "| |*| |   or  " +"|*|*|*|\n" +
                "| | |*|       " + "|*| | |       " +"| | | |\n" +
                "\nThere are some forbidden moves:\n" +
                "you can only move a piece to an empty space either on the right, left, up, or down of your current piece or to the middle" +
                " and you can't move over an opponent's piece\nExample 2:\n" +
                "|X| | |                                    |X| |O|\n" +
                "|O|X|X|               ->                   |O|X|X|\n" +
                "|O| |O|  This move of O is not allowed     | | |O|\n\n" +
                "How to move a piece?\n" +
                "space on the TickTackToe boar is indexed from 1 to 9 as shown below\n" +
                "|1|2|3|\n" +
                "|4|5|6|\n" +
                "|7|8|9|\n" +
                "if you want to move a piece you have to first give the index of that piece and the index of where you want to move it to " +
                "separated by a comma (,)\n" +
                "|X| | |                           | | | |\n" +
                "| | | |  input 1,5 will give you  | |X| |\n" +
                "| | | |                           | | | |\n" +
                "I hope you understand the game and it's Rules. :)";
        System.out.println(instructions);
        System.out.println("Do you want a quick tutorial of the game?");
        String input = Driver.scn.nextLine();
        if (input.toUpperCase().contains("Y")||input.toUpperCase().contains("YES")){
            System.out.println("Here is a quick tutorial to get yourself familiarized with the game.");
            Player computer = new Player('X');
            Player user = new Player('O');
            Board board = new Board();
            System.out.println("Initial Board state. you are player O");
            board.initBoard(user,computer);
            System.out.println("Enter 1,4 to move the first X to the space below it");
            Moves moves = new Moves();
            while (true){
                input = Driver.scn.nextLine();
                switch (input){
                    case "1,4":{
                        if (board.get(0,Board.translater[1])=='O' && board.get(0,Board.translater[2])=='O' && board.get(0,Board.translater[3])=='O'){
                            try{
                                 moves.movePiece(board,computer,user,input,user.getPiecesTags());
                                System.out.println("Computer's move");
                                TimeUnit.SECONDS.sleep(2);
                                moves.movePiece(board,computer,user,"8,5",computer.getPiecesTags());
                                System.out.println("now enter 3,6 to move the third piece to the space below it");
                            }catch (Exception e){
                                System.out.println(e.getMessage());
                            }
                        }else {
                            System.out.println("This is not a valid entry please type 1,4 and press enter");
                        }
                        break;
                    }
                    case "3,6":{
                        if (board.get(1,Board.translater[4])=='O' && board.get(0,Board.translater[2])=='O' && board.get(0,Board.translater[3])=='O'){
                            try{
                                moves.movePiece(board,computer,user,input,user.getPiecesTags());
                                System.out.println("Computer's move");
                                TimeUnit.SECONDS.sleep(2);
                                moves.movePiece(board,computer,user,"9,8",computer.getPiecesTags());
                                System.out.println("now enter 6,9 to move the piece in the 6th's space to the space below it");
                            }catch (Exception e){
                                System.out.println(e.getMessage());
                            }

                        }else {
                            System.out.println("This is not a valid entry please type 3,6 and press enter");
                        }
                        break;
                    }
                    case "6,9":{
                        if (board.get(0,Board.translater[2])=='O' && board.get(1,Board.translater[4])=='O' && board.get(1,Board.translater[6])=='O'){
                            try{
                                moves.movePiece(board,computer,user,input,user.getPiecesTags());
                                System.out.println("Computer's move");
                                TimeUnit.SECONDS.sleep(2);
                                moves.movePiece(board,computer,user,"5,6",computer.getPiecesTags());
                                System.out.println("now enter 2,5 to move the top piece in middle space");
                            }catch (Exception e){
                                System.out.println(e.getMessage());
                            }

                        }else {
                            System.out.println("This is not a valid entry please type 3,6 and press enter");
                        }
                        break;
                    }
                    case "2,5":{
                        if (board.get(0,Board.translater[2])=='O' && board.get(1,Board.translater[4])=='O' && board.get(2,Board.translater[9])=='O'){
                            try{
                                moves.movePiece(board,computer,user,input,user.getPiecesTags());
                                System.out.println("Computer's move");
                                TimeUnit.SECONDS.sleep(2);
                                moves.movePiece(board,computer,user,"6,3",computer.getPiecesTags());
                                System.out.println("now enter 4,1 to move the piece in the 4th's space to the space above it");
                            }catch (Exception e){
                                System.out.println(e.getMessage());
                            }

                        }else {
                            System.out.println("This is not a valid entry please type 3,6 and press enter");
                        }
                        break;
                    }
                    case "4,1":{
                        if (board.get(1,Board.translater[4])=='O' && board.get(1,Board.translater[5])=='O' && board.get(2,Board.translater[9])=='O'){
                            try{
                                moves.movePiece(board,computer,user,input,user.getPiecesTags());
                                System.out.println("Yayyyy you won the game!!!!");
                                return;
                            }catch (Exception e){
                                System.out.println(e.getMessage());
                            }

                        }else {
                            System.out.println("This is not a valid entry please type 3,6 and press enter");
                        }
                        break;
                    }
                }
            }
        }
    }
    public void filter(){

    }

}
