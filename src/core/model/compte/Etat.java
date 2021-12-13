package core.model.compte;

public enum Etat {
	A("Attribué"),N("Non attribué"),F("Fermé");
	
	private String etat;
	
	private Etat(String etat) {
		this.etat = etat;
	}

	public String getEtat() {
		return etat;
	}
}
