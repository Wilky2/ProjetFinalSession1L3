package core.model.compte;

import core.model.client.Client;
import core.model.exception.MontantNonValideException;

/*
 * Classe permettant de gerer les comptes
 */
public class Compte {
	private int numero;
	private TypeCompte type;
	private Devise devise;
	private double solde;
	private Etat etat;
	private Client proprietaire;
	
	public Compte(int numero, TypeCompte type, Devise devise, double solde, Etat etat, Client proprietaire) {
		super();
		this.numero = numero;
		this.type = type;
		this.devise = devise;
		this.solde = solde;
		this.etat = etat;
		this.proprietaire = proprietaire;
	}

	public Compte(int numero, TypeCompte type, Devise devise, double solde, Etat etat) {
		super();
		this.numero = numero;
		this.type = type;
		this.devise = devise;
		this.solde = solde;
		this.etat = etat;
		this.proprietaire = null;
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
	
	public Client getProprietaire() {
		return proprietaire;
	}

	public void setProprietaire(Client proprietaire) {
		this.proprietaire = proprietaire;
	}

	/*
	 * methode permettant de reduire le montant d'un compte
	 */
	public void debiter(double montant) throws MontantNonValideException {
		/*
		 * verification si le montant est valide
		 * pas de montant superieur au solde du compte 
		 * pas de montant inferieur a 0
		 */
		if(montant>=this.getSolde() || montant <= 0) {
			throw new MontantNonValideException();
		}
		this.setSolde(this.getSolde() - montant);
	}
	
	/*
	 * methode permettant d'augmenter le montant d'un compte
	 */
	public void crediter(double montant) throws MontantNonValideException {
		/*
		 * pas de montant inferieur a zero
		 */
		if(montant <= 0) {
			throw new MontantNonValideException();
		}
		this.setSolde(this.getSolde() + montant);  
	}

	@Override
	public String toString() {
		String idProprietaire = "";
		if(proprietaire!=null) {
			idProprietaire = proprietaire.getIdClient();
		}
		return numero  + " "  + type.getType()  + " "  + devise.getDevise()  + " "  + solde  + " "  + etat.getEtat()  + " "  + idProprietaire;
	}
}
