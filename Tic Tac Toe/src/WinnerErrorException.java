
public class WinnerErrorException extends Exception {
	
	public WinnerErrorException(String message){
		super("There was no winner, draw");
		
	}

}
