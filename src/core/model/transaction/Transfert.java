package core.model.transaction;

import java.util.Date;

import core.model.compte.Compte;
import core.model.compte.Etat;
import core.model.compte.MontantNonValideException;

public class Transfert extends Transaction {
	
	private Compte compteDebiteur;
	private double montantDebiteur;
	private Compte compteCrediteur;
	private double montantCrediteur;
	private String description;
	
	

	public Transfert(int idTransaction, Date dateTransaction,Compte compteDebiteur,double montantDebiteur,Compte compteCrediteur,double montantCrediteur,String description) {
		super(idTransaction, dateTransaction);
		this.compteDebiteur = compteDebiteur;
		this.montantDebiteur = montantDebiteur;
		this.compteCrediteur = compteCrediteur;
		this.montantCrediteur = montantCrediteur;
		this.description = description;
	}

	

	public Compte getCompteDebiteur() {
		return compteDebiteur;
	}



	public void setCompteDebiteur(Compte compteDebiteur) {
		this.compteDebiteur = compteDebiteur;
	}



	public double getMontantDebiteur() {
		return montantDebiteur;
	}



	public void setMontantDebiteur(double montantDebiteur) {
		this.montantDebiteur = montantDebiteur;
	}



	public Compte getCompteCrediteur() {
		return compteCrediteur;
	}



	public void setCompteCrediteur(Compte compteCrediteur) {
		this.compteCrediteur = compteCrediteur;
	}



	public double getMontantCrediteur() {
		return montantCrediteur;
	}



	public void setMontantCrediteur(double montantCrediteur) {
		this.montantCrediteur = montantCrediteur;
	}



	public String getDescription() {
		return description;
	}



	public void setDescription(String description) {
		this.description = description;
	}



	@Override
	public void effectuer() throws MontantNonValideException, CompteNonValideException {
		if(this.compteDebiteur.getEtat() != Etat.A || this.compteCrediteur.getEtat() != Etat.A) {
			throw new CompteNonValideException();
		}
		
		if(this.montantDebiteur < this.montantCrediteur) {
			throw new MontantNonValideException();
		}
		
		this.compteDebiteur.debiter(this.montantDebiteur);
		this.compteCrediteur.crediter(montantCrediteur);
	}

}
