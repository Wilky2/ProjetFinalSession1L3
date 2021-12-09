package core.model.compte;

public class MontantNonValideException extends Exception{
	private String message;
	
	public MontantNonValideException() {
		this.message = "Montant non valide";
	}

	public String getMessage() {
		return message;
	}
}
