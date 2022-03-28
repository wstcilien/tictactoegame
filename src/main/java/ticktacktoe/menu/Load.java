package ticktacktoe.menu;

import ticktacktoe.Driver;
import ticktacktoe.game.Board;
import ticktacktoe.game.Games;
import ticktacktoe.services.DataBaseServices;

public class Load {
    public Load(Games game, char turn, int mode, DataBaseServices sqlServices){
        switch (mode){
            case 1:{
                Board board = new Board();
                board.parse(game.getBoard());
                board.printBoard();
                PlayerVComputer playerVComputer = new PlayerVComputer(turn,game,sqlServices);
                Driver.log.info("loaded a one player game");
            }
            break;
            case 2:{
                Board board = new Board();
                board.parse(game.getBoard());
                board.printBoard();
                TwoPlayer twoPlayer = new TwoPlayer(turn,game,sqlServices);
                Driver.log.info("loaded a two player game");
            }
            break;
        }

    }
}
