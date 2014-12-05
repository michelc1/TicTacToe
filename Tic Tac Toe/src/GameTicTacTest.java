import static org.junit.Assert.*; // external jar, used for failed cases 

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;


public class GameTicTacTest {

	//testing class, going to test out constructor first 
	@Test
	public void test() throws BoardErrorException {

		Game choice = new Game(); //object of the Game board 


		assertEquals('X', choice.userTurn); // we can use this method for writing test 
		//only the failed test are recorded 
		// here we are testing the users turn , marked by the char " x " 

		assertEquals("         ", choice.toString()); // testing the board 
		//3x3 board 
		// what the board should look like, should be a blank board at this point 

	}

	@Test
	public void testUserMove() throws UserMoveErrorExcepion{

		Game choice = null;
		try {
			choice = new Game().userMove(1);
		} catch (BoardErrorException e) {
			e.printStackTrace();
		} // after the first move, i.e X just went 
		assertEquals('O', choice.userTurn); // next Turn should not be a O, once the user X goes 
		assertEquals(" X       ", choice.toString()); // what the board looks like now after an X has been inserted and now it is 
		// O turn
		// note to self, every move must have a space after quote
		// look at the JNIT failure test to determine where the 'actual' is at 

	}

	@Test 
	public void testMovesCanTake() throws NoMoreMovesException, BoardErrorException, UserMoveErrorExcepion{

		//testing the method  MovesCanTake

		List<Integer> numberValue = new ArrayList<>(); // integerList 
		// basically every space has a value 
		//since we can not only use Strings to define the spaces
		// determine spaces by the value of that space


		for(int i =0;i<Game.sizeOfBoard;i++){ // looping through the board at every space 
			numberValue.add(i); // every space now has a integer value 
		}

		numberValue.remove(new Integer(1)); 
		// removes the value of the space that the user made, the object created 
		// i.e at the space X was made, so it can not be made again so we are going to remove it 
		// from the list, i.e that space also gets remove 

		//	try {
		assertEquals(numberValue, new Game().userMove(1).MovesCanTake());
	} //catch (BoardErrorException e) {
	//e.printStackTrace();
	//}

	@Test
	public void testWinner() throws WinnerErrorException, BoardErrorException{ // testing to ensure there can be a winner

		Game choice = new Game(); //object of the Game board 

		choice = new Game().winner();

		// assertEquals("XXX      ",choice.winner() ); // should return a winner
		//testing the board the ensure that winner works 
		//
		 
		 choice.winner();
		 
	}
}




