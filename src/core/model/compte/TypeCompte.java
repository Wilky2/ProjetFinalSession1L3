package core.model.compte;

public enum TypeCompte {
	courant("courant"),epargne("epargne");
	
	private String type;
	
	private TypeCompte(String type) {
		this.type = type;
	}
	
	public String getType() {
		return type;
	}
}
