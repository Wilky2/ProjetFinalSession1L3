package core.model.transaction;

import java.time.LocalDateTime;
import java.util.Date;

import core.model.compte.Compte;
import core.model.compte.Etat;
import core.model.exception.CompteNonValideException;
import core.model.exception.MontantNonValideException;

/*
 * Classe gerant les depots
 */
public class Depot extends Transaction {
	
	private Compte compte;
	private double montant;
	private String nomDeposant;
	private String prenomDeposant;
	
	

	public Depot(int idTransaction, LocalDateTime dateTransaction,Compte compte,double montant,String nomDeposant,String prenomDeposant) {
		super(idTransaction, dateTransaction,TypeTransaction.depot);
		this.compte = compte;
		this.montant = montant;
		this.nomDeposant = nomDeposant;
		this.prenomDeposant = prenomDeposant;
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



	public String getNomDeposant() {
		return nomDeposant;
	}



	public void setNomDeposant(String nomDeposant) {
		this.nomDeposant = nomDeposant;
	}



	public String getPrenomDeposant() {
		return prenomDeposant;
	}



	public void setPrenomDeposant(String prenomDeposant) {
		this.prenomDeposant = prenomDeposant;
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
		
		compte.crediter(montant);

	}

	@Override
	public String toString() {
		return "Depot [compte=" + compte + ", montant=" + montant + ", nomDeposant=" + nomDeposant + ", prenomDeposant="
				+ prenomDeposant + ", toString()=" + super.toString() + "]";
	}
	
}
