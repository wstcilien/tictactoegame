package ticktacktoe.menu;

import ticktacktoe.Driver;
import ticktacktoe.array.ArrayFactory;
import ticktacktoe.game.Games;
import ticktacktoe.services.DataBaseServices;

import java.util.Scanner;

public class UserMenu {
    public UserMenu(DataBaseServices sqlServices){
        while (true){
            Driver.scn  = new Scanner(System.in);
            System.out.println("Menu: \n" +
                    "load = load a past game\n" +
                    "new = to start a new game\n"+
                    "rules = see instructions of the game\n" +
                    "stats = to see the statistics\n"+
                    "quit = to quit the game\n");
            String input = Driver.scn.nextLine();
            ArrayFactory<Games> gamesArrayFactory=new ArrayFactory<>();
            gamesArrayFactory = sqlServices.getAllGames();
            switch (input){
                case "load":{
                    if (gamesArrayFactory.size()>0){
                        System.out.println("Saved Games");
                        for (int i=0;i<gamesArrayFactory.size();i++) {
                            System.out.println(i+": "+gamesArrayFactory.get(i).getName());
                        }
                        try{
                            System.out.println("Please enter the index of the game you want to load");
                            int index = Driver.scn.nextInt();
                            if (index<gamesArrayFactory.size()){
                                Load loadGame = new Load(gamesArrayFactory.get(index),gamesArrayFactory.get(index).getTurn(),
                                        gamesArrayFactory.get(index).getMode(),sqlServices);
                            }else {

                                System.out.println("This not a valid input");
                            }
                        }catch (Exception e){

                        }

                    }else{

                        System.out.println("There are no games to load. Please start a new game.");
                    }

                    break;
                }
                case "rules":{
                    Tutorial tutorial = new Tutorial();
                    break;
                }
                case "quit":{
                    Driver.tracker = false;
                    return;
                }
                case "new":{
                    System.out.println("Please enter the mode that you would like to play.\n" +
                            "1: Play Computer\n" +
                            "2: Two Players");
                    try{
                        int response = Driver.scn.nextInt();
                        switch (response){
                            case 1: {
                                //System.out.println("This mod is not available yet. Please keep an eye out for an update soon");
                                System.out.println("Under what name would you like your progress to save?");
                                String name = Driver.scn.next();
                                PlayerVComputer pvc = new PlayerVComputer(name,sqlServices);
                            }
                            break;
                            case 2:{
                                System.out.println("Under what name would you like your progress to save?");
                                String name = Driver.scn.next();
                                TwoPlayer pvp = new TwoPlayer(name,sqlServices);
                            }
                            break;
                        }
                    }catch (Exception e){
                        System.out.println("You have entered a wong input");
                    }
                    break;
                }
                case "stats":{
                    Statistics statistics = new Statistics(sqlServices);
                    break;
                }
            }
        }
    }
}