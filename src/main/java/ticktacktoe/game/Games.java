package ticktacktoe.game;

public class Games {
    private String name;
    private Board board = new Board();
    private char turn;
    private int mode;
    private String endState;
    private char player1;
    private char player2;
    private char winner;
    private char looser;

    public Games(String name,Board board, int mode,Player one,Player two){
        this.name = name;
        this.board = board;
        this.turn = ' ';
        this.endState = "in progress";
        this.player1 = one.getPiecesTags();
        this.player2 = two.getPiecesTags();
        this.winner = ' ';
        this.looser = ' ';
        this.mode = mode;
    }
    public Games(String name, String board, String turn, int mode, String endState,String p1,String p2, String winner, String looser){
        this.name = name;
        this.board.parse(board);
        this.turn = turn.charAt(0);
        this.mode = mode;
        this.endState = endState;
        this.player1 = p1.charAt(0);
        this.player2 = p2.charAt(0);
        this.winner = winner.charAt(0);
        this.looser = looser.charAt(0);

    }

    public String getName() {
        return name;
    }

    public void setTurn(char turn) {
        this.turn = turn;
    }
    public void setEndState(){
        this.endState = "completed";
    }
    public void winLose(char w){
        if (w == player1){
            this.winner = player1;
            this.looser = player2;
        }else{
            this.winner = player2;
            this.looser = player1;
        }
    }

    public String getBoard() {
        return this.board.toString();
    }
    public Board getBoardObject(){
        return this.board;
    }

    public char getTurn() {
        return turn;
    }

    public int getMode() {
        return mode;
    }

    public String getEndState() {
        return endState;
    }

    public char getPlayer1() {
        return player1;
    }

    public char getPlayer2() {
        return player2;
    }

    public char getWinner() {
        return winner;
    }

    public char getLooser() {
        return looser;
    }

    @Override
    public String toString() {
        return "Games{" +
                "name='" + name + '\'' +
                ", board=" + board.toString() +
                ", turn=" + turn +
                ", mode=" + mode +
                ", endState='" + endState + '\'' +
                ", player1=" + player1 +
                ", player2=" + player2 +
                ", winner=" + winner +
                ", looser=" + looser +
                '}';
    }
}
