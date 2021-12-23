package core.model.transaction;

import java.time.LocalDateTime;
import java.util.Date;

import core.model.compte.Compte;
import core.model.compte.Etat;
import core.model.exception.CompteNonValideException;
import core.model.exception.MontantNonValideException;

public class Retrait extends Transaction{
	private Compte compte;
	private double montant;
	
	public Retrait(int idTransaction, LocalDateTime dateTransaction,Compte compte,double montant) {
		super(idTransaction, dateTransaction,TypeTransaction.retrait);
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
		/*
		 * verification si le compte est attribue, 
		 * si ce n'est pas le cas on leve une exception
		 */
		if(this.compte.getEtat() != Etat.A) {
			throw new CompteNonValideException();
		}
		
		compte.debiter(montant);
		
	}



	@Override
	public String toString() {
		return "Retrait [compte=" + compte + ", montant=" + montant + ", toString()=" + super.toString() + "]";
	}
	
}
