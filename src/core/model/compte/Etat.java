package core.model.compte;

public enum Etat {
	A("Attribu�"),N("Non attribu�"),F("Ferm�");
	
	private String etat;
	
	private Etat(String etat) {
		this.etat = etat;
	}

	public String getEtat() {
		return etat;
	}
}
