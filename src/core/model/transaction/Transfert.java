package core.model.transaction;

import java.time.LocalDateTime;
import java.util.Date;

import core.model.compte.Compte;
import core.model.compte.Devise;
import core.model.compte.Etat;
import core.model.exception.CompteNonValideException;
import core.model.exception.MontantNonValideException;

public class Transfert extends Transaction {
	
	private Compte compteDebiteur;
	private double montantDebiteur;
	private Compte compteCrediteur;
	private double montantCrediteur;
	private String description;
	
	

	public Transfert(int idTransaction, LocalDateTime dateTransaction,Compte compteDebiteur,double montantDebiteur,Compte compteCrediteur,double montantCrediteur,String description) {
		super(idTransaction, dateTransaction,TypeTransaction.transfert);
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
		/*
		 * verification si les deux comptes sont attribues et ne sont pas les memes
		 */
		if(this.compteDebiteur.getEtat() != Etat.A || this.compteCrediteur.getEtat() != Etat.A || this.compteCrediteur.getNumero() == compteDebiteur.getNumero()) {
			throw new CompteNonValideException();
		}
		
		/*
		 * verification des devises des deux comptes
		 * en cas ou les deux comptes n'ont pas les memes devises 
		 * on convertit le montant a debiter pour que ce montant soit exprimer au 
		 * meme devise que le montant a crediter
		 * apres on effectue les operations
		 */
		double montantConvertit = this.montantDebiteur;
		if(compteDebiteur.getDevise()!=compteCrediteur.getDevise()) {
			if(compteCrediteur.getDevise()==Devise.dollar) {
				montantConvertit /=105;
			}
			else {
				montantConvertit*=105;
			}
		}
		
		/*
		 * verification si l'equivalent du montant a debiter est superieur au montant
		 * a crediter
		 */
		
		if(montantConvertit < this.montantCrediteur) {
			throw new MontantNonValideException();
		}
		
		this.compteDebiteur.debiter(this.montantDebiteur);
		this.compteCrediteur.crediter(montantCrediteur);
	}

	@Override
	public String toString() {
		return "Transfert [compteDebiteur=" + compteDebiteur + ", montantDebiteur=" + montantDebiteur
				+ ", compteCrediteur=" + compteCrediteur + ", montantCrediteur=" + montantCrediteur + ", description="
				+ description + ", toString()=" + super.toString() + "]";
	}
	
	

}
