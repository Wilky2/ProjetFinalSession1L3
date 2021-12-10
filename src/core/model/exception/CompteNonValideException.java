package core.model.exception;

public class CompteNonValideException extends Exception {
	
	private String message;
	
	public CompteNonValideException() {
		this.message  = "Compte non valide";
	}

}
