package core.model.compte;

public class Compte {
	private int numero;
	private TypeCompte type;
	private Devise devise;
	private double solde;
	private Etat etat;
	private int idClient;
	
	public Compte(int numero, TypeCompte type, Devise devise, double solde, Etat etat, int idClient) {
		super();
		this.numero = numero;
		this.type = type;
		this.devise = devise;
		this.solde = solde;
		this.etat = etat;
		this.idClient = idClient;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public TypeCompte getType() {
		return type;
	}

	public void setType(TypeCompte type) {
		this.type = type;
	}

	public Devise getDevise() {
		return devise;
	}

	public void setDevise(Devise devise) {
		this.devise = devise;
	}

	public double getSolde() {
		return solde;
	}

	public void setSolde(double solde) {
		this.solde = solde;
	}

	public Etat getEtat() {
		return etat;
	}

	public void setEtat(Etat etat) {
		this.etat = etat;
	}

	public int getIdClient() {
		return idClient;
	}

	public void setIdClient(int idClient) {
		this.idClient = idClient;
	}
	
	public void debiter(double montant) throws MontantNonValide {
		if(montant>this.getSolde() || montant < 0) {
			throw new MontantNonValide();
		}
		this.setSolde(this.getSolde() -montant);
	}
	
	public void crediter(double montant) throws MontantNonValide {
		if(montant < 0) {
			throw new MontantNonValide();
		}
		this.setSolde(this.getSolde() + montant);
	}
	
}
