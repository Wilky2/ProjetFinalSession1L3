package core.model.transaction;

public enum TypeTransaction {
	depot("depot"),transfert("transfert"),retrait("retrait");
	
	private String type;
	
	private TypeTransaction(String type) {
		this.type = type;
	}
	
	public String getType() {
		return type;
	}
}
