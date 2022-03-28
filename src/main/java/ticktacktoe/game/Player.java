package ticktacktoe.game;

public class Player {
    private char piecesTags;

    public Player(char piecesTags){

        this.piecesTags = piecesTags;
    }
    public Boolean isEmpty(int where, Player p1){
        Boolean fact = false;
        return fact;
    }
    public void setPiecesTags(Character piecesTags) {
        this.piecesTags = piecesTags;
    }

    public Character getPiecesTags(){
        return piecesTags;
    }
}
