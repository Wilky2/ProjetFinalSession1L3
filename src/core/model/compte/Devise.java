package core.model.compte;

public enum Devise {
	gourde("gourde"),dollar("dollar");
	
	private String devise;
	
	private Devise(String devise) {
		this.devise = devise;
	}

	public String getDevise() {
		return devise;
	}
	
}
