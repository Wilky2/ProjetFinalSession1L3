package core.model.client;

public class Client {
	private int idClient;
	private String nom;
	private String prenom;
	private TypeClient type;
	private Sexe sexe;
	private String adresse;
	private String nif;
	private String telephone;
	
	public Client(int idClient, String nom, String prenom, TypeClient type, Sexe sexe, String adresse, String nif,
			String telephone) {
		super();
		this.idClient = idClient;
		this.nom = nom;
		this.prenom = prenom;
		this.type = type;
		this.sexe = sexe;
		this.adresse = adresse;
		this.nif = nif;
		this.telephone = telephone;
	}

	public Client(int idClient, String nom, String prenom, TypeClient type, Sexe sexe, String adresse) {
		super();
		this.idClient = idClient;
		this.nom = nom;
		this.prenom = prenom;
		this.type = type;
		this.sexe = sexe;
		this.adresse = adresse;
	}

	public int getIdClient() {
		return idClient;
	}

	public void setIdClient(int idClient) {
		this.idClient = idClient;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public TypeClient getType() {
		return type;
	}

	public void setType(TypeClient type) {
		this.type = type;
	}

	public Sexe getSexe() {
		return sexe;
	}

	public void setSexe(Sexe sexe) {
		this.sexe = sexe;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getNif() {
		return nif;
	}

	public void setNif(String nif) {
		this.nif = nif;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	
	
}
