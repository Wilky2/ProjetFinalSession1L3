package core.model.client;

public enum TypeClient {
	Physique("Physique"),Moral("Moral");
	
	private String type;
	
	private TypeClient(String type) {
		this.type = type;
	}
	
	public String getType() {
		return type;
	}
	
}
