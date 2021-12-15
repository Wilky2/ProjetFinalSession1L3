package core.data;

public class NoExistException extends Exception {
	private String message;
	
	public NoExistException() {
		this.message = "Donne inexistant";
	}
}
