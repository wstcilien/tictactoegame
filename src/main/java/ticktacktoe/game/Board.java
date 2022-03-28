package ticktacktoe.game;

public class Board {
    private char[][] board;
    public static final int[] translater = {0,1,3,5,1,3,5,1,3,5};


    public Board(){
        this.board = new char[][]{{'|',' ','|',' ','|',' ','|'}, {'|', ' ', '|', ' ', '|', ' ', '|'}, {'|', ' ', '|', ' ', '|', ' ', '|'}};
    }
    public void initBoard(Player player1, Player player2){
        board[0][translater[1]] = player1.getPiecesTags();
        board[0][translater[2]] = player1.getPiecesTags();
        board[0][translater[3]] = player1.getPiecesTags();
        board[2][translater[7]] = player2.getPiecesTags();
        board[2][translater[8]] = player2.getPiecesTags();
        board[2][translater[9]] = player2.getPiecesTags();
        printBoard();

    }
    public void setBoard(int from,int to,char playerMarker){
        if (from<=3){
            if (to<=3){
                board[0][Board.translater[from]] = ' ';
                board[0][Board.translater[to]] = playerMarker;

            }else if(to > 3 && to<=6){
                board[0][Board.translater[from]] = ' ';
                board[1][Board.translater[to]] = playerMarker;
            }
        }else if(from > 3 && from<=6){
            if (to<=3){
                board[1][Board.translater[from]] = ' ';
                board[0][Board.translater[to]] = playerMarker;
            }else if(to > 3 && to<=6){
                board[1][Board.translater[from]] = ' ';
                board[1][Board.translater[to]] = playerMarker;
            }else if(to >6 && to <= 9){
                board[1][Board.translater[from]] = ' ';
                board[2][Board.translater[to]] = playerMarker;
            }
        }else if (from > 6 && from<=9){
            if (to<=3){
                board[2][Board.translater[from]] = ' ';
                board[0][Board.translater[to]] = playerMarker;
            }else if(to > 3 && to<=6){
                board[2][Board.translater[from]] = ' ';
                board[1][Board.translater[to]] = playerMarker;
            }else if(to >6 && to<=9){
                board[2][Board.translater[from]] = ' ';
                board[2][Board.translater[to]] = playerMarker;
            }
        }
    }
    public void parse(String board){
        String[] sp = board.split(",");
        this.board[0][1] = sp[0].charAt(0);
        this.board[0][3] = sp[1].charAt(0);
        this.board[0][5] = sp[2].charAt(0);
        this.board[1][1] = sp[3].charAt(0);
        this.board[1][3] = sp[4].charAt(0);
        this.board[1][5] = sp[5].charAt(0);
        this.board[2][1] = sp[6].charAt(0);
        this.board[2][3] = sp[7].charAt(0);
        this.board[2][5] = sp[8].charAt(0);
    }
    public char get(int row,int colomn){
        return board[row][colomn];
    }
    public char get(int index){
        int row;
        if (index<=3){
            row = 0;
            return get(row,translater[index]);
        }else if (index >3 && index <=6){
            row = 1;
            return get(row,translater[index]);
        }else{
            row = 2;
            return get(row,translater[index]);
        }
    }
    public boolean isEmpty(char c){
        return c==' ';
    }
    public boolean containsAt(char a, int at){
        return a==get(at);
    }
    public void printBoard(){
        System.out.println(board[0]);
        System.out.println(board[1]);
        System.out.println(board[2]);
    }
    public boolean isAWinner(char p){
        if (containsAt(p,4)&&containsAt(p,5)&&containsAt(p, 6)){
            return true;
        }else if(containsAt(p,1)&&containsAt(p,5)&&containsAt(p,9)){
            return true;
        }else if (containsAt(p,3)&&containsAt(p,5)&&containsAt(p,7)){
            return true;
        }else{
            return false;
        }

    }

    @Override
    public String toString() {
        return  board[0][1] +","+
                board[0][3] +","+
                board[0][5] +","+
                board[1][1] +","+
                board[1][3] +","+
                board[1][5] +","+
                board[2][1] +","+
                board[2][3] +","+
                board[2][5];
    }
}
