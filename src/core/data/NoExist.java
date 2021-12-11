package core.data;

public class NoExist extends Exception {
	private String message;
	
	public NoExist() {
		this.message = "Donne inexistant";
	}
}
