package ticktacktoe.menu;

import ticktacktoe.array.ArrayFactory;
import ticktacktoe.game.Games;
import ticktacktoe.services.DataBaseServices;

public class Statistics {
    public Statistics(DataBaseServices services){

        ArrayFactory<Games> completedGamesForTwoP = services.getAllCompletedGamesForTwoP();
        ArrayFactory<Games> completedGamesForOneP = services.getAllCompletedGamesForOneP();
        ArrayFactory<Games> xWinnersForOneP = services.getAllGamesForOnePWithXWins();
        ArrayFactory<Games> xWinnersForTwoP = services.getAllGamesForTwoPWithXWins();
        int numOfGamesOneP = completedGamesForOneP.size();
        int numOfGamesTwoP = completedGamesForTwoP.size();

        double xWinNumForOneP = xWinnersForOneP.size();
        double xWinNumForTwoP = xWinnersForTwoP.size();

        double yWinNumForOneP = numOfGamesOneP-xWinNumForOneP;
        double yWinNumForTwoP = numOfGamesTwoP-xWinNumForTwoP;
        if ((completedGamesForTwoP.size()==0)&&(completedGamesForOneP.size()==0)){
            System.out.println("Statistics:\n" +
                    "Two Players' Statistics\n" +
                    "Players     Won     win%     Lost     Lost%\n" +
                    "   X         -       -        -         -\n" +
                    "   O         -       -        -         -");
            System.out.println("Single Player's Statistics\n" +
                    "Players     Won     win%     Lost     Lost%\n" +
                    "   X         -       -        -         -\n" +
                    "   C         -       -        -         -");
        }else if ((completedGamesForTwoP.size()!=0)&&(completedGamesForOneP.size()==0)){

            System.out.println("Statistics:\n" +
                    "Two Players' Statistics\n" +
                    "Players     Won     win%     Lost     Lost%\n" +
                    "   X        "+xWinNumForTwoP+"     "+(xWinNumForTwoP/numOfGamesTwoP)*100+"%     "+
                    yWinNumForTwoP+"     "+(yWinNumForTwoP/numOfGamesTwoP)*100+"%\n" +
                    "   O        "+yWinNumForTwoP+"     "+(yWinNumForTwoP/numOfGamesTwoP)*100+"%     "+
                    xWinNumForTwoP+"     "+(xWinNumForTwoP/numOfGamesTwoP)*100+"%");
            System.out.println("Single Player's Statistics\n" +
                    "Players     Won     win%     Lost     Lost%\n" +
                    "   X         -       -        -         -\n" +
                    "   C         -       -        -         -");
        }else if ((completedGamesForTwoP.size()==0)&&(completedGamesForOneP.size()!=0)){
            System.out.println("Statistics:\n" +
                    "Two Players' Statistics\n" +
                    "Players     Won     win%     Lost     Lost%\n" +
                    "   X         -       -        -         -\n" +
                    "   O         -       -        -         -");
            System.out.println("Single Player's Statistics\n" +
                    "Players     Won     win%     Lost     Lost%\n" +
                    "   X        "+xWinNumForOneP+"     "+(xWinNumForOneP/numOfGamesOneP)*100+"%     "+
                    yWinNumForOneP+"     "+(yWinNumForOneP/numOfGamesOneP)*100+"%\n" +
                    "   C        "+yWinNumForOneP+"     "+(yWinNumForOneP/numOfGamesOneP)*100+"%     "+
                    xWinNumForOneP+"     "+(xWinNumForOneP/numOfGamesOneP)*100+"%");
        }else {
            System.out.println("Statistics:\n" +
                    "Two Players' Statistics\n" +
                    "Players     Won     win%     Lost     Lost%\n" +
                    "   X        "+xWinNumForTwoP+"     "+(xWinNumForTwoP/numOfGamesTwoP)*100+"%     "+
                    yWinNumForTwoP+"     "+(yWinNumForTwoP/numOfGamesTwoP)*100+"%\n" +
                    "   O        "+yWinNumForTwoP+"     "+(yWinNumForTwoP/numOfGamesTwoP)*100+"%     "+
                    xWinNumForTwoP+"     "+(xWinNumForTwoP/numOfGamesTwoP)*100+"%");
            System.out.println("Single Player's Statistics\n" +
                    "Players     Won     win%     Lost     Lost%\n" +
                    "   X        "+xWinNumForOneP+"     "+(xWinNumForOneP/numOfGamesOneP)*100+"%     "+
                    yWinNumForOneP+"     "+(yWinNumForOneP/numOfGamesOneP)*100+"%\n" +
                    "   C        "+yWinNumForOneP+"     "+(yWinNumForOneP/numOfGamesOneP)*100+"%     "+
                    xWinNumForOneP+"     "+(xWinNumForOneP/numOfGamesOneP)*100+"%");
        }
    }
}
