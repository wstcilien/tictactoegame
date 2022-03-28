package ticktacktoe.services;

import ticktacktoe.Driver;
import ticktacktoe.array.ArrayFactory;
import ticktacktoe.game.Board;
import ticktacktoe.game.Games;
import ticktacktoe.util.ConnectionUtil;

import java.sql.*;

public class DataBaseServices {
    Connection conn;
    public DataBaseServices(){
        conn = ConnectionUtil.getConnection();
    }

    public ArrayFactory<Games> getAllGames() {
        ArrayFactory<Games> allGames = new ArrayFactory<>();
        try{
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery("Select * From game where endstate = 'in progress'");
            while(rs.next()){
                Games game = new Games(rs.getString("name"),rs.getString("board"),rs.getString("turn"),
                        rs.getInt("mode"),rs.getString("endstate"),rs.getString("player1"),
                        rs.getString("player2"),rs.getString("winner"), rs.getString("looser"));
                allGames.add(game);
            }
            rs.close();
            return allGames;
        }catch (SQLException s){
            System.out.println("There are no games in the database: \n"+s);
            return allGames;
        }
    }
    public ArrayFactory<Games> getAllCompletedGamesForTwoP(){
        ArrayFactory<Games> allGames = new ArrayFactory<>();
        try{
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery("Select * From game where endstate = 'completed' and mode = 2");
            while(rs.next()){
                Games game = new Games(rs.getString("name"),rs.getString("board"),rs.getString("turn"),
                        rs.getInt("mode"),rs.getString("endstate"),rs.getString("player1"),
                        rs.getString("player2"),rs.getString("winner"), rs.getString("looser"));
                allGames.add(game);
            }
            rs.close();
        }catch (SQLException s){
        }
        return allGames;
    }
    public ArrayFactory<Games> getAllCompletedGamesForOneP(){
        ArrayFactory<Games> allGames = new ArrayFactory<>();
        try{
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery("Select * From game where endstate = 'completed' and mode =1");
            while(rs.next()){
                Games game = new Games(rs.getString("name"),rs.getString("board"),rs.getString("turn"),
                        rs.getInt("mode"),rs.getString("endstate"),rs.getString("player1"),
                        rs.getString("player2"),rs.getString("winner"), rs.getString("looser"));
                allGames.add(game);
            }
            rs.close();
        }catch (SQLException s){
        }
        return allGames;
    }
    public ArrayFactory<Games> getAllGamesForTwoPWithXWins(){
        ArrayFactory<Games> allGames = new ArrayFactory<>();
        try{
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery("Select * From game where endstate = 'completed', mode = 2, winner = 'X';");
            while(rs.next()){
                Games game = new Games(rs.getString("name"),rs.getString("board"),rs.getString("turn"),
                        rs.getInt("mode"),rs.getString("endstate"),rs.getString("player1"),
                        rs.getString("player2"),rs.getString("winner"), rs.getString("looser"));
                allGames.add(game);
            }
            rs.close();
        }catch (SQLException s){
            Driver.log.warn("Does have any games in the data and trying get specifics");
        }
        return allGames;
    }
    public ArrayFactory<Games> getAllGamesForOnePWithXWins(){
        ArrayFactory<Games> allGames = new ArrayFactory<>();
        try{
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery("Select * From game where endstate = 'completed' and mode = 1 and winner = 'X';");
            while(rs.next()){
                Games game = new Games(rs.getString("name"),rs.getString("board"),rs.getString("turn"),
                        rs.getInt("mode"),rs.getString("endstate"),rs.getString("player1"),
                        rs.getString("player2"),rs.getString("winner"), rs.getString("looser"));
                allGames.add(game);
            }
            rs.close();
        }catch (SQLException s){
            Driver.log.warn("Does have any games in the data and trying get specifics");
        }
        return allGames;
    }
    public void updateToDataBase(Games game, Board board) {
        try{
            Driver.log.info("saving game on database");
            PreparedStatement statement = conn.prepareStatement(
                    "update game set board = (?), turn = (?) where name = (?);");
            statement.setString(3, game.getName());
            statement.setString(1, game.getBoard());
            statement.setString(2, String.valueOf(game.getTurn()));
            statement.executeUpdate();
        }catch (SQLException s){
            Driver.log.warn("Something is wrong while updating game in progress ");
        }
    }
    public void updateFinalStateToDataBase(Games game){
        Driver.log.info("Updated the game on database as complete");
        try{
            PreparedStatement statement = conn.prepareStatement(
                    "update game set board = (?), turn = (?), endstate = (?), winner = (?), looser = (?) where name = (?);" );
            statement.setString(6, String.valueOf(game.getName()));
            statement.setString(1, game.getBoard());
            statement.setString(2,String.valueOf(game.getTurn()));
            statement.setString(3, game.getEndState());
            statement.setString(4, String.valueOf(game.getWinner()));
            statement.setString(5, String.valueOf(game.getLooser()));
            statement.executeUpdate();
        }catch (SQLException s){

            Driver.log.warn("Something is wrong while updating game to its final state");
        }
    }
    public boolean writeToDataBase(Games game)  {
        try{
            PreparedStatement statement = conn.prepareStatement(
                    "Insert into game (name, board, turn, mode, endstate, player1, player2, winner, looser)" +
                            "Values" +
                            "(?,?,?,?,?,?,?,?,?)");
            int parameterIndex = 0;
            statement.setString(++parameterIndex, game.getName());
            statement.setString(++parameterIndex, game.getBoard());
            statement.setString(++parameterIndex, String.valueOf(game.getTurn()));
            statement.setInt(++parameterIndex, game.getMode());
            statement.setString(++parameterIndex, game.getEndState());
            statement.setString(++parameterIndex, String.valueOf(game.getPlayer1()));
            statement.setString(++parameterIndex, String.valueOf(game.getPlayer2()));
            statement.setString(++parameterIndex, String.valueOf(game.getWinner()));
            statement.setString(++parameterIndex, String.valueOf(game.getLooser()));
            statement.executeUpdate();
            return true;
        }catch (SQLException s){
            Driver.log.warn("Tried to save a duplicate game");
            return false;
        }
    }
}
