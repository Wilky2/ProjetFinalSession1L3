package core.model.compte;

public class MontantNonValide extends Exception{
	private String message;
	
	public MontantNonValide() {
		this.message = "Montant non valide";
	}

	public String getMessage() {
		return message;
	}
}
