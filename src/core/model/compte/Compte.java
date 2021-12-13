package core.model.compte;

import core.model.client.Client;
import core.model.exception.MontantNonValideException;

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

	public void debiter(double montant) throws MontantNonValideException {
		if(montant>this.getSolde() || montant < 0) {
			throw new MontantNonValideException();
		}
		this.setSolde(this.getSolde() -montant);
	}
	
	public void crediter(double montant) throws MontantNonValideException {
		if(montant < 0) {
			throw new MontantNonValideException();
		}
		this.setSolde(this.getSolde() + montant);
	}

	@Override
	public String toString() {
		return "Compte [numero=" + numero + ", type=" + type.getType() + ", devise=" + devise.getDevise() + ", solde=" + solde + ", etat="
				+ etat.getEtat() + ", proprietaire=" + proprietaire + "]";
	}
	
	
}
