import java.util.ArrayList;
import java.util.List;


public class Game {

	public char[] templateOfBoard; // our board, TicTacToe field 
	public char userTurn; // users turn , only one letter some making it a char 
	public int count; // keeps track of user moves 
	public static final int row = 3; // our rows 
	public static final int col = 3; // our col 
	public static final int sizeOfBoard = row * col; // the size of our board is not going to change so we make it final
	// all the size is equal to the rows and the columns , so a 3 x 3 board 



	// constructor 
	// want to initialize the variable 
	// here we are stating the board size
	// the turns choices 

	public Game() throws BoardErrorException{

		count = 0; // number of turns starts at 0;

		userTurn = 'X'; // first turn will always be X

		templateOfBoard = new char[sizeOfBoard]; // size of the board we are going to make it 

		for(int spaces=0; spaces<sizeOfBoard; spaces++){

			templateOfBoard[spaces] = ' '; // the board is being created, looping through all rows and col

			//every index of the board not has a char value equal to a space 

			//determine if everything came out correctly 
			//should equal of a total of 9
			// 3x3
			//System.out.println(templateOfBoard[i]);
			//System.out.println(sizeOfBoard);
			//System.out.println(templateOfBoard.length);
		}
		System.out.println("Board template created");
	}




	public Game userMove(int moveMade) throws UserMoveErrorExcepion {

		templateOfBoard[moveMade] = userTurn; // index of the board, or in simpler terms, where the user
		// inserts there turn i.e X or O, 0-8
		//System.out.println(userMove);

		//boolean statement to determine the turns 
		// So user X starts first
		//if the turn is X, the nextTurn is now O,
		if(userTurn == 'X'){
			userTurn = 'O';
			System.out.println("User Turn " +userTurn);
		}

		else { // if the userTurn is not X, i.e the letter ), the turn after that is now X 
			userTurn = 'X';
			System.out.println("User Turn" + userTurn);
		}

		count = count+1;
		// System.out.print("Switch made" + count);

		// System.out.println(userTurn);
		return this; // going to return the userTurn
		// issue actually entering the userTurn is not giving right value, but using 'this' does 
	}

	// this method will need to determine if the board has any more moves left
	// and if so, which moves 

	public List<Integer> MovesCanTake() throws NoMoreMovesException{ 
		// integerList 

		List<Integer> numberValue = new ArrayList<>();		
		// moves we can make 
		// basically every space has a value 
		//since we can not only use Strings to define the spaces
		// determine spaces by the value(1-9) of that space

		for(int i=0; i<templateOfBoard.length;i++){
			//sizeOfBoard.length;
			//templateOfBoard.length-1;

			if(templateOfBoard[i] == ' '){

				// so if at a certain position there is a space 
				// we are going to add a number to it, at that index 
				//basically no moves have been made, so the board should have all spaces 
				numberValue.add(i);
				//System.out.println(templateOfBoard[i]);
			}


			else if(templateOfBoard[i] == 'X' || templateOfBoard[i] == 'O'){
				// on initial turn for testing purposes, there is an X on the board 
				// so new turn must be a O
				System.out.println("Move placed"); // move was a X
				System.out.println("User Turn " + userTurn); // turn should now a an O 
				//System.out.println(templateOfBoard[i]);
			}

			else{
				String message = null;
				//try {
				try {
					throw new UserMoveErrorExcepion(message);
				} catch (UserMoveErrorExcepion e) {
					e.printStackTrace();
				} // Saying that i can not take any more moves???
			} //catch (NoMoreMovesException e) {
			//e.printStackTrace();
		}
		//}

		return numberValue;
	}

	//}

	// for some odd reason the toString is causing some issues, keep getting @hash code
	//saw online to override it like this 
	// will make the board out of emepty strings 
	// going to return a string representation of an object 

	public String toString(){
		return new String(templateOfBoard);
	}



	public Game winner() throws WinnerErrorException { // determines who is the winner

		// combinations of all the possible wins 
		// you can only win at these index

		 //testing purposes 
		   templateOfBoard[0] = 'X';
		   templateOfBoard[1] = 'X';
		   templateOfBoard[2] = 'X';
		   //count = 8; // possible number of moves is only 8, if after 8 switch, there is no winnder, it becomes a draw 
		
		   //list below defines all the possible win combinations 
		   // the index of where a X or O can be place
		   // placed the locations to a int value 
		   
		int win1 = templateOfBoard[0] + templateOfBoard[1] + templateOfBoard[2];	
		int win2 = templateOfBoard[3] + templateOfBoard[4] + templateOfBoard[5];
		int win3 = templateOfBoard[6] + templateOfBoard[7] + templateOfBoard[8];
		int win4 = templateOfBoard[0] + templateOfBoard[3] + templateOfBoard[6];
		int win5 = templateOfBoard[1] + templateOfBoard[4] + templateOfBoard[7];
		int win6 = templateOfBoard[2] + templateOfBoard[5] + templateOfBoard[8];
		int win7 = templateOfBoard[0] + templateOfBoard[4] + templateOfBoard[8];
		int win8 = templateOfBoard[6] + templateOfBoard[4] + templateOfBoard[2];

		int[] win = new int[]{win1,win2,win3,win4,win5,win6,win7,win8}; // making a array to go through all the possibile wins 
		//possible total of wins is 8

		for(int i = 0;i<win.length;i++){	 // looping through the win possibilities 
			
			// System.out.println(i+ " dsffd " + win[i]);
			if(win[i] == 264){ // if one of the the combinations equal 'X','X','X' which equals 264, then there is a winner 
				 System.out.println("X is the winner!!!");	
				//System.out.println(templateOfBoard[0]+templateOfBoard[1]+templateOfBoard[2]);
			}
			else if(win[i] == 237 ){ // if one of the the combinations equal 'O','O','O' which equals 234, then there is a winner 
				 System.out.println("O is the winner!!!");
				//System.out.println(templateOfBoard[0]+templateOfBoard[1]+templateOfBoard[2]);
			}
			else{
				if(count == 8){ // else if after 8 clicks, or 8 turns, if there is no winner, it is a draw 
					throw new WinnerErrorException("So sorry, There was no winner, DRAW");
				}

			}

		}
		return this;
	}
}
