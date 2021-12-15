package core.data;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;

import core.model.client.Client;
import core.model.compte.Compte;
import core.model.transaction.Transaction;
import core.model.transaction.Depot;
import core.model.transaction.Transfert;
import core.model.transaction.Retrait;
import core.model.transaction.TypeTransaction;

public class DataTransaction {
	
	private ArrayList<Integer> idTransaction;
	private ArrayList<LocalDateTime> dateTransaction;
	private ArrayList<TypeTransaction> type;
	
	public static DataTransaction dataTransaction = new DataTransaction();
	
	private DataTransaction() {
		super();
		this.idTransaction = new ArrayList<Integer>();
		this.dateTransaction = new ArrayList<LocalDateTime>();
		this.type = new ArrayList<TypeTransaction>();
	}

	public void enregistrer(Transaction transaction) {
		
		TypeTransaction typeTransaction = transaction.getType();
		this.idTransaction.add(transaction.getIdTransaction());
		this.dateTransaction.add(transaction.getDateTransaction());
		this.type.add(typeTransaction);
		
		switch(typeTransaction) {
		
		case depot :{
			DataDepot.dataDepot.enregistrer(transaction);
		}break;
		
		case transfert:{
			DataTransfert.dataTransfert.enregistrer(transaction);
		}break;
		
		case retrait:{
			DataRetrait.dataRetrait.enregistrer(transaction);
		}break;
		
		}
	}
	
	public Transaction rechercher(int id) {
		int indexIdTransaction = this.idTransaction.indexOf(id);
		if(indexIdTransaction < 0 ) {
			return null;
		}
		
		Transaction transaction = null;
		TypeTransaction typeTransaction = this.type.get(indexIdTransaction);
		
		switch(typeTransaction) {
		
		case depot :{
			return DataDepot.dataDepot.Depot(indexIdTransaction, idTransaction.get(indexIdTransaction), dateTransaction.get(indexIdTransaction));
		}
		
		case transfert:{
			return DataTransfert.dataTransfert.transfert(indexIdTransaction, idTransaction.get(indexIdTransaction), dateTransaction.get(indexIdTransaction));
		}
		
		case retrait:{
			return DataRetrait.dataRetrait.retrait(indexIdTransaction, idTransaction.get(indexIdTransaction), dateTransaction.get(indexIdTransaction));
		}
		
		default :{
			return null;
		}
		
		}
	}
	
	public void modifier(Transaction transaction) throws NoExistException {
		int indexIdTransaction = this.idTransaction.indexOf(transaction.getIdTransaction());
		if(indexIdTransaction < 0) {
			throw new NoExistException();
		}
		TypeTransaction typeTransaction = transaction.getType();
		this.idTransaction.set(indexIdTransaction, transaction.getIdTransaction());
		this.dateTransaction.set(indexIdTransaction, transaction.getDateTransaction());
		this.type.set(indexIdTransaction, typeTransaction);
		
		switch(typeTransaction) {
		
		case depot :{
			DataDepot.dataDepot.modifier(indexIdTransaction,transaction);
		}break;
		
		case transfert:{
			DataTransfert.dataTransfert.modifier(indexIdTransaction,transaction);
		}break;
		
		case retrait:{
			DataRetrait.dataRetrait.modifier(indexIdTransaction,transaction);
		}break;
		
		}
		
	}
	
	public void supprimer(int id) throws NoExistException {
		int indexIdTransaction = this.idTransaction.indexOf(id);
		if(indexIdTransaction < 0) {
			throw new NoExistException();
		}
		
		TypeTransaction typeTransaction = this.type.get(indexIdTransaction);
		this.idTransaction.remove(indexIdTransaction);
		this.dateTransaction.remove(indexIdTransaction);
		this.type.remove(indexIdTransaction);
		
		switch(typeTransaction) {
		
		case depot :{
			DataDepot.dataDepot.supprimer(indexIdTransaction);
		}break;
		
		case transfert:{
			DataTransfert.dataTransfert.supprimer(indexIdTransaction);
		}break;
		
		case retrait:{
			DataRetrait.dataRetrait.supprimer(indexIdTransaction);
		}break;
		
		}
	}
	
	public ArrayList<Transaction> lister(){
		ArrayList<Transaction> listeTransaction = new ArrayList<Transaction>();
		for(int i = 0 ; i< this.idTransaction.size();i++) {
			listeTransaction.add(this.rechercher(this.idTransaction.get(i)));
		}
		return listeTransaction;
	}
}	


class DataDepot{

	private ArrayList<Integer> idCompte;
	private ArrayList<Double> montant;
	private ArrayList<String> nomDeposant;
	private ArrayList<String> prenomDeposant;
	
	public static DataDepot dataDepot = new DataDepot();
	
	private DataDepot() {
		super();
		this.idCompte = new ArrayList<Integer>();
		this.montant = new ArrayList<Double>();
		this.nomDeposant = new ArrayList<String>();
		this.prenomDeposant = new ArrayList<String>();
	}

	public void enregistrer(Transaction transaction) {
		this.idCompte.add(((Depot) transaction).getCompte().getNumero());
		this.montant.add(((Depot) transaction).getMontant());
		this.nomDeposant.add(((Depot) transaction).getNomDeposant());
		this.prenomDeposant.add(((Depot) transaction).getPrenomDeposant());
	}
	
	public Depot Depot(int index,int idTransaction,LocalDateTime localDateTime) {
		return new Depot(idTransaction,
				localDateTime,
				DataCompte.dataCompte.rechercher(this.idCompte.get(index)),
				this.montant.get(index),
				this.nomDeposant.get(index),
				this.prenomDeposant.get(index)
				);
	}
	
	public void modifier(int index, Transaction transaction) {
		this.idCompte.set(index,((Depot) transaction).getCompte().getNumero());
		this.montant.set(index,((Depot) transaction).getMontant());
		this.nomDeposant.set(index,((Depot) transaction).getNomDeposant());
		this.prenomDeposant.set(index,((Depot) transaction).getPrenomDeposant());
	}
	
	public void supprimer(int index) {
		this.idCompte.remove(index);
		this.montant.remove(index);
		this.nomDeposant.remove(index);
		this.prenomDeposant.remove(index);
	}
}

class DataTransfert{
	private ArrayList<Integer> idCompteDebiteur;
	private ArrayList<Double> montantDebiteur;
	private ArrayList<Integer> idCompteCrediteur;
	private ArrayList<Double> montantCrediteur;
	private ArrayList<String> description;
	
	public static DataTransfert dataTransfert = new DataTransfert();
	
	private DataTransfert() {
		super();
		this.idCompteDebiteur = new ArrayList<Integer>();
		this.montantDebiteur = new ArrayList<Double>();
		this.idCompteCrediteur = new ArrayList<Integer>();
		this.montantCrediteur = new ArrayList<Double>();
		this.description = new ArrayList<String>();
	}
	
	public void enregistrer(Transaction transaction) {
		this.idCompteDebiteur.add(((Transfert) transaction).getCompteDebiteur().getNumero());
		this.montantDebiteur.add(((Transfert) transaction).getMontantDebiteur());
		this.idCompteCrediteur.add(((Transfert) transaction).getCompteCrediteur().getNumero());
		this.montantCrediteur.add(((Transfert) transaction).getMontantCrediteur());
		this.description.add(((Transfert) transaction).getDescription());
	}
	
	public Transfert transfert(int index,int idTransaction,LocalDateTime localDateTime) {
		return new Transfert(
				idTransaction,
				localDateTime,
				DataCompte.dataCompte.rechercher(this.idCompteDebiteur.get(index)),
				this.montantDebiteur.get(index),
				DataCompte.dataCompte.rechercher(this.idCompteCrediteur.get(index)),
				this.montantCrediteur.get(index),
				this.description.get(index)
				);
	}
	
	public void modifier(int index,Transaction transaction) {
		this.idCompteDebiteur.set(index,((Transfert) transaction).getCompteDebiteur().getNumero());
		this.montantDebiteur.set(index,((Transfert) transaction).getMontantDebiteur());
		this.idCompteCrediteur.set(index,((Transfert) transaction).getCompteCrediteur().getNumero());
		this.montantCrediteur.set(index,((Transfert) transaction).getMontantCrediteur());
		this.description.set(index,((Transfert) transaction).getDescription());
	}
	
	public void supprimer(int index) {
		this.idCompteDebiteur.remove(index);
		this.montantDebiteur.remove(index);
		this.idCompteCrediteur.remove(index);
		this.montantCrediteur.remove(index);
		this.description.remove(index);
	}
}

class DataRetrait{
	
	private ArrayList<Integer> idCompte;
	private ArrayList<Double> montant;
	
	public static DataRetrait dataRetrait = new DataRetrait();

	private DataRetrait() {
		super();
		this.idCompte = new ArrayList<Integer>();
		this.montant = new ArrayList<Double>();
	}
	
	public void enregistrer(Transaction transaction) {
		this.idCompte.add(((Retrait) transaction).getCompte().getNumero());
		this.montant.add(((Retrait) transaction).getMontant());
	}
	
	public Retrait retrait(int index,int idTransaction,LocalDateTime localDateTime) {
		return new Retrait(idTransaction,
				localDateTime,
				DataCompte.dataCompte.rechercher(this.idCompte.get(index)),
				this.montant.get(index)
				);
	}
	
	public void modifier(int index,Transaction transaction) {
		this.idCompte.set(index,((Retrait) transaction).getCompte().getNumero());
		this.montant.set(index,((Retrait) transaction).getMontant());
	}
	
	public void supprimer(int index) {
		this.idCompte.remove(index);
		this.montant.remove(index);
	}
}
