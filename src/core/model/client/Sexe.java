package core.model.client;

public enum Sexe {
	masculin("masculin"),feminin("feminin"),aucun("aucun");
	
	private String sexe;
	private Sexe(String sexe) {
		this.sexe = sexe;
	}
	public String getSexe() {
		return sexe;
	}
}
