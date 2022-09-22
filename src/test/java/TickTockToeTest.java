
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import ticktacktoe.array.ArrayFactory;
import ticktacktoe.game.Board;
import ticktacktoe.game.Games;
import ticktacktoe.game.Moves;
import ticktacktoe.game.Player;
import ticktacktoe.services.DataBaseServices;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TickTockToeTest {

//     static Board board;
//     static Moves moves;
//     static DataBaseServices services;
//     @BeforeAll
//     static void setUp(){
//         board = new Board();
//         board.initBoard(new Player('X'),new Player('O'));
//         moves = new Moves();
//         services = new DataBaseServices();
//     }
// //
//     @Test
//     public void testMovingEmptySpace(){

//         // test moving a space
// //         assertFalse(moves.isValidMove(board,4,1,'X'));
// //         assertFalse(moves.isValidMove(board,4,2,'X'));
// //         assertFalse(moves.isValidMove(board,4,3,'X'));
// //         assertFalse(moves.isValidMove(board,4,4,'X'));
// //         assertFalse(moves.isValidMove(board,4,5,'X'));
// //         assertFalse(moves.isValidMove(board,4,6,'X'));
// //         assertFalse(moves.isValidMove(board,4,7,'X'));
// //         assertFalse(moves.isValidMove(board,4,8,'X'));
// //         assertFalse(moves.isValidMove(board,4,9,'X'));

// //         assertFalse(moves.isValidMove(board,5,1,'X'));
// //         assertFalse(moves.isValidMove(board,5,2,'X'));
// //         assertFalse(moves.isValidMove(board,5,3,'X'));
// //         assertFalse(moves.isValidMove(board,5,4,'X'));
// //         assertFalse(moves.isValidMove(board,5,5,'X'));
// //         assertFalse(moves.isValidMove(board,5,6,'X'));
// //         assertFalse(moves.isValidMove(board,5,7,'X'));
// //         assertFalse(moves.isValidMove(board,5,8,'X'));
// //         assertFalse(moves.isValidMove(board,5,9,'X'));

// //         assertFalse(moves.isValidMove(board,6,1,'X'));
// //         assertFalse(moves.isValidMove(board,6,2,'X'));
// //         assertFalse(moves.isValidMove(board,6,3,'X'));
// //         assertFalse(moves.isValidMove(board,6,4,'X'));
// //         assertFalse(moves.isValidMove(board,6,5,'X'));
// //         assertFalse(moves.isValidMove(board,6,6,'X'));
// //         assertFalse(moves.isValidMove(board,6,7,'X'));
// //         assertFalse(moves.isValidMove(board,6,8,'X'));
// //         assertFalse(moves.isValidMove(board,6,9,'X'));


//     }
//     @Test
//     public void testMovingToSameSpot(){
//         // test x moving to the same position, to a position it already has a piece at, or over an empty spot
// //         assertFalse(moves.isValidMove(board,1,1,'X'));
// //         assertFalse(moves.isValidMove(board,1,2,'X'));
// //         assertFalse(moves.isValidMove(board,1,3,'X'));

// //         assertFalse(moves.isValidMove(board,2,1,'X'));
// //         assertFalse(moves.isValidMove(board,2,2,'X'));
// //         assertFalse(moves.isValidMove(board,2,3,'X'));

// //         assertFalse(moves.isValidMove(board,3,1,'X'));
// //         assertFalse(moves.isValidMove(board,3,2,'X'));
// //         assertFalse(moves.isValidMove(board,3,3,'X'));

//         // test o moving to the same position, to a position it already has a piece at, or over an empty spot
// //         assertFalse(moves.isValidMove(board,7,7,'O'));
// //         assertFalse(moves.isValidMove(board,7,8,'O'));
// //         assertFalse(moves.isValidMove(board,7,9,'O'));

// //         assertFalse(moves.isValidMove(board,8,7,'O'));
// //         assertFalse(moves.isValidMove(board,8,7,'O'));
// //         assertFalse(moves.isValidMove(board,8,7,'O'));

// //         assertFalse(moves.isValidMove(board,9,8,'O'));
// //         assertFalse(moves.isValidMove(board,9,7,'O'));
// //         assertFalse(moves.isValidMove(board,9,9,'O'));
//     }
//     @Test
//     public void testMovingOthersPiece(){
//         // moving an opponent O piece
// //         assertFalse(moves.isValidMove(board,7,1,'X'));
// //         assertFalse(moves.isValidMove(board,7,2,'X'));
// //         assertFalse(moves.isValidMove(board,7,3,'X'));
// //         assertFalse(moves.isValidMove(board,7,4,'X'));
// //         assertFalse(moves.isValidMove(board,7,5,'X'));
// //         assertFalse(moves.isValidMove(board,7,6,'X'));
// //         assertFalse(moves.isValidMove(board,7,7,'X'));
// //         assertFalse(moves.isValidMove(board,7,8,'X'));
// //         assertFalse(moves.isValidMove(board,7,9,'X'));

// //         assertFalse(moves.isValidMove(board,8,1,'X'));
// //         assertFalse(moves.isValidMove(board,8,2,'X'));
// //         assertFalse(moves.isValidMove(board,8,3,'X'));
// //         assertFalse(moves.isValidMove(board,8,4,'X'));
// //         assertFalse(moves.isValidMove(board,8,5,'X'));
// //         assertFalse(moves.isValidMove(board,8,6,'X'));
// //         assertFalse(moves.isValidMove(board,8,7,'X'));
// //         assertFalse(moves.isValidMove(board,8,8,'X'));
// //         assertFalse(moves.isValidMove(board,8,9,'X'));

// //         assertFalse(moves.isValidMove(board,9,1,'X'));
// //         assertFalse(moves.isValidMove(board,9,2,'X'));
// //         assertFalse(moves.isValidMove(board,9,3,'X'));
// //         assertFalse(moves.isValidMove(board,9,4,'X'));
// //         assertFalse(moves.isValidMove(board,9,5,'X'));
// //         assertFalse(moves.isValidMove(board,9,6,'X'));
// //         assertFalse(moves.isValidMove(board,9,7,'X'));
// //         assertFalse(moves.isValidMove(board,9,8,'X'));
// //         assertFalse(moves.isValidMove(board,9,9,'X'));

//         // moving an opponent X piece
// //         assertFalse(moves.isValidMove(board,1,1,'O'));
// //         assertFalse(moves.isValidMove(board,1,2,'O'));
// //         assertFalse(moves.isValidMove(board,1,3,'O'));
// //         assertFalse(moves.isValidMove(board,1,4,'O'));
// //         assertFalse(moves.isValidMove(board,1,5,'O'));
// //         assertFalse(moves.isValidMove(board,1,6,'O'));
// //         assertFalse(moves.isValidMove(board,1,7,'O'));
// //         assertFalse(moves.isValidMove(board,1,8,'O'));
// //         assertFalse(moves.isValidMove(board,1,9,'O'));

// //         assertFalse(moves.isValidMove(board,2,1,'O'));
// //         assertFalse(moves.isValidMove(board,2,2,'O'));
// //         assertFalse(moves.isValidMove(board,2,3,'O'));
// //         assertFalse(moves.isValidMove(board,2,4,'O'));
// //         assertFalse(moves.isValidMove(board,2,5,'O'));
// //         assertFalse(moves.isValidMove(board,2,6,'O'));
// //         assertFalse(moves.isValidMove(board,2,7,'O'));
// //         assertFalse(moves.isValidMove(board,2,8,'O'));
// //         assertFalse(moves.isValidMove(board,2,9,'O'));

// //         assertFalse(moves.isValidMove(board,3,1,'O'));
// //         assertFalse(moves.isValidMove(board,3,2,'O'));
// //         assertFalse(moves.isValidMove(board,3,3,'O'));
// //         assertFalse(moves.isValidMove(board,3,4,'O'));
// //         assertFalse(moves.isValidMove(board,3,5,'O'));
// //         assertFalse(moves.isValidMove(board,3,6,'O'));
// //         assertFalse(moves.isValidMove(board,3,7,'O'));
// //         assertFalse(moves.isValidMove(board,3,8,'O'));
// //         assertFalse(moves.isValidMove(board,3,9,'O'));
//     }
//     @Test
//     public void testGettingAllSavedGames(){
// //         ArrayFactory<Games> games = new ArrayFactory<>();
// //         assertTrue(services.getAllGames().size()>0);
// //     }
//     @Test
//     public void testWriteToDataBase(){
// //         assertTrue(services.writeToDataBase(new Games("name",board, 1,new Player('X'),new Player('O'))));
//     }

}
