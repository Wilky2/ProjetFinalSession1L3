package core.model.transaction;

public class CompteNonValideException extends Exception {
	
	private String message;
	
	public CompteNonValideException() {
		this.message  = "Compte non valide";
	}

}
