package ticktacktoe;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import ticktacktoe.menu.UserMenu;
import ticktacktoe.services.DataBaseServices;

import java.util.Scanner;

public class Driver {
    private static DataBaseServices sqlServices = new DataBaseServices();
    public static boolean tracker = true;
    public static Scanner scn;
    public static final Logger log = LogManager.getLogger(Driver.class);
    public static void main(String[] args) {
        String welcome = "Welcome to the Haitian's style of TickTackToe!\nAt anytime, type quit to end the session." +
                " This will also automatically save your progress.";
        System.out.println(welcome);
        scn = new Scanner(System.in);
        log.info("loaded Game");
        while(tracker){
            System.out.println("Type menu to see your different options.");
            String resp = scn.next();
            switch (resp){
                case "menu": {
                    UserMenu userMenu = new UserMenu(sqlServices);
                }
                    break;
                case "quit":
                    tracker = false;
                    break;
            }
        }

    }
}
