package ticktacktoe.game;

public class Moves {
public Boolean isValidMove(Board board, int from, int to, char who){
    boolean valid = false;
    if (board.get(from)==who){
        /*
        |1|2|3|
        |4|5|6|
        |7|8|9|
     */
        switch (from){
            case 1:{
                if (to == 2 && board.isEmpty(board.get(2))){
                    valid= true;
                }else if (to == 5 && board.isEmpty(board.get(5))){
                    valid = true;
                }else if (to == 4 && board.isEmpty(board.get(4))){
                    valid = true;
                }
            }
            case 2:{
                if (to == 1 && board.isEmpty(board.get(1))){
                    valid = true;
                }else if (to == 5 && board.isEmpty(board.get(5))){
                    valid = true;
                }else if (to == 3 && board.isEmpty(board.get(3))){
                    valid = true;
                }else{
                    valid = false;
                }
            }case 3:{
                if (to == 2 && board.isEmpty(board.get(2))){
                    valid = true;
                }else if (to == 5 && board.isEmpty(board.get(5))){
                    valid = true;
                }else if (to == 6 && board.isEmpty(board.get(6))){
                    valid = true;
                }else{
                    valid = false;
                }
            }case 4:{
                if (to == 1 && board.isEmpty(board.get(1))){
                    valid = true;
                }else if (to == 5 && board.isEmpty(board.get(5))){
                    valid = true;
                }else if (to == 7 && board.isEmpty(board.get(7))){
                    valid = true;
                }else{
                    valid = false;
                }
            }case 5:{
                if (to == 1 && board.isEmpty(board.get(1))){
                    valid = true;
                }else if (to == 2 && board.isEmpty(board.get(2))){
                    valid = true;
                }else if (to == 3 && board.isEmpty(board.get(3))){
                    valid = true;
                }else if (to == 4 && board.isEmpty(board.get(4))){
                    valid = true;
                }else if (to == 6 && board.isEmpty(board.get(6))){
                    valid = true;
                }else if (to == 7 && board.isEmpty(board.get(7))){
                    valid = true;
                }else if (to == 8 && board.isEmpty(board.get(8))){
                    valid = true;
                }else if (to == 9 && board.isEmpty(board.get(9))){
                    valid = true;
                }
            }case 6:{
                if (to == 3 && board.isEmpty(board.get(3))){
                    valid = true;
                }else if (to == 5 && board.isEmpty(board.get(5))){
                    valid = true;
                }else if (to == 9 && board.isEmpty(board.get(9))){
                    valid = true;
                }
            }case 7:{
                if (to == 4 && board.isEmpty(board.get(4))){
                    valid = true;
                }else if (to == 5 && board.isEmpty(board.get(5))){
                    valid = true;
                }else if (to == 8 && board.isEmpty(board.get(8))){
                    valid = true;
                }
            }case 8:{
                if (to == 7 && board.isEmpty(board.get(7))){
                    valid = true;
                }else if (to == 5 && board.isEmpty(board.get(5))){
                    valid = true;
                }else if (to == 9 && board.isEmpty(board.get(9))){
                    valid = true;
                }
            }case 9:{
                if (to == 8 && board.isEmpty(board.get(8))){
                    valid = true;
                }else if (to == 5 && board.isEmpty(board.get(5))){
                    valid = true;
                }else if (to == 6 && board.isEmpty(board.get(6))){
                    valid = true;
                }
            }
        }
    }
    return valid;
}
public Boolean movePiece(Board board, Player p1, Player p2, String moveTo, char who){
    try {
        String[] location = moveTo.split(",");
        int from = Integer.parseInt(location[0]);
        int to = Integer.parseInt(location[1]);
        if (isValidMove(board, from, to, who)) {
            board.setBoard(from, to, who);
            board.printBoard();
            return true;
        } else {
            System.out.println("You can't move a piece that's not yours.");
            return false;
        }
    }catch (Exception e){
        return false;
    }

}
}
