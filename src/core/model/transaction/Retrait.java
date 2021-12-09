package core.model.transaction;

import java.util.Date;

import core.model.compte.Compte;
import core.model.compte.Etat;
import core.model.compte.MontantNonValideException;

public class Retrait extends Transaction{
	private Compte compte;
	private double montant;
	
	public Retrait(int idTransaction, Date dateTransaction,Compte compte,double montant) {
		super(idTransaction, dateTransaction);
		this.compte = compte;
		this.montant = montant;
	}
	
	

	public Compte getCompte() {
		return compte;
	}



	public void setCompte(Compte compte) {
		this.compte = compte;
	}



	public double getMontant() {
		return montant;
	}



	public void setMontant(double montant) {
		this.montant = montant;
	}



	@Override
	public void effectuer() throws MontantNonValideException, CompteNonValideException {
		
		if(this.compte.getEtat() != Etat.A) {
			throw new CompteNonValideException();
		}
		
		compte.debiter(montant);
		
	}
	
	
	
}
