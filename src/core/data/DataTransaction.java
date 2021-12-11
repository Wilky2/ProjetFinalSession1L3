package core.data;

import java.util.ArrayList;
import java.util.Date;

import core.model.compte.Compte;
import core.model.transaction.Transaction;
import core.model.transaction.Depot;
import core.model.transaction.Transfert;
import core.model.transaction.Retrait;
import core.model.transaction.TypeTransaction;

public class DataTransaction {
	
	private ArrayList<Integer> idTransaction;
	private ArrayList<Date> dateTransaction;
	private ArrayList<TypeTransaction> type;
	
	public static DataTransaction dataTransaction = new DataTransaction();
	
	private DataTransaction() {
		super();
		this.idTransaction = new ArrayList<Integer>();
		this.dateTransaction = new ArrayList<Date>();
		this.type = new ArrayList<TypeTransaction>();
	}

	public void enregistrer(Transaction transaction) {
		
		TypeTransaction typeTransaction = transaction.getType();
		idTransaction.add(transaction.getIdTransaction());
		dateTransaction.add(transaction.getDateTransaction());
		type.add(typeTransaction);
		
		switch(typeTransaction) {
		
		case depot :{
			DataDepot.dataDepot.enregistrer(transaction);
		}
		
		case transfert:{
			DataTransfert.dataTransfert.enregistrer(transaction);
		}
		
		case retrait:{
			DataRetrait.dataRetrait.enregistrer(transaction);
		}
		
		}
	}
	
	public Transaction rechercher(int id) {
		int indexIdTransaction = idTransaction.indexOf(idTransaction);
		if(indexIdTransaction < 0 ) {
			return null;
		}
		
		Transaction transaction = null;
		TypeTransaction typeTransaction = type.get(indexIdTransaction);
		
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
	
	public void modifier(Transaction transaction) throws NoExist {
		int indexIdTransaction = idTransaction.indexOf(transaction.getIdTransaction());
		if(indexIdTransaction < 0) {
			throw new NoExist();
		}
		TypeTransaction typeTransaction = transaction.getType();
		idTransaction.set(indexIdTransaction, transaction.getIdTransaction());
		dateTransaction.set(indexIdTransaction, transaction.getDateTransaction());
		type.set(indexIdTransaction, typeTransaction);
		
		switch(typeTransaction) {
		
		case depot :{
			DataDepot.dataDepot.modifier(indexIdTransaction,transaction);
		}
		
		case transfert:{
			DataTransfert.dataTransfert.modifier(indexIdTransaction,transaction);
		}
		
		case retrait:{
			DataRetrait.dataRetrait.modifier(indexIdTransaction,transaction);
		}
		
		}
		
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
		idCompte.add(((Depot) transaction).getCompte().getNumero());
		montant.add(((Depot) transaction).getMontant());
		nomDeposant.add(((Depot) transaction).getNomDeposant());
		prenomDeposant.add(((Depot) transaction).getPrenomDeposant());
	}
	
	public Depot Depot(int index,int idTransaction,Date dateTransaction) {
		return new Depot(idTransaction,
				dateTransaction,
				DataCompte.dataCompte.rechercher(idCompte.get(index)),
				montant.get(index),
				nomDeposant.get(index),
				prenomDeposant.get(index)
				);
	}
	
	public void modifier(int index, Transaction transaction) {
		idCompte.set(index,((Depot) transaction).getCompte().getNumero());
		montant.set(index,((Depot) transaction).getMontant());
		nomDeposant.set(index,((Depot) transaction).getNomDeposant());
		prenomDeposant.set(index,((Depot) transaction).getPrenomDeposant());
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
		idCompteDebiteur.add(((Transfert) transaction).getCompteDebiteur().getNumero());
		montantDebiteur.add(((Transfert) transaction).getMontantDebiteur());
		idCompteCrediteur.add(((Transfert) transaction).getCompteCrediteur().getNumero());
		montantCrediteur.add(((Transfert) transaction).getMontantCrediteur());
		description.add(((Transfert) transaction).getDescription());
	}
	
	public Transfert transfert(int index,int idTransaction,Date dateTransaction) {
		return new Transfert(
				idTransaction,
				dateTransaction,
				DataCompte.dataCompte.rechercher(idCompteDebiteur.get(index)),
				montantDebiteur.get(index),
				DataCompte.dataCompte.rechercher(idCompteCrediteur.get(index)),
				montantCrediteur.get(index),
				description.get(index)
				);
	}
	
	public void modifier(int index,Transaction transaction) {
		idCompteDebiteur.set(index,((Transfert) transaction).getCompteDebiteur().getNumero());
		montantDebiteur.set(index,((Transfert) transaction).getMontantDebiteur());
		idCompteCrediteur.set(index,((Transfert) transaction).getCompteCrediteur().getNumero());
		montantCrediteur.set(index,((Transfert) transaction).getMontantCrediteur());
		description.set(index,((Transfert) transaction).getDescription());
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
		idCompte.add(((Retrait) transaction).getCompte().getNumero());
		montant.add(((Retrait) transaction).getMontant());
	}
	
	public Retrait retrait(int index,int idTransaction,Date dateTransaction) {
		return new Retrait(idTransaction,
				dateTransaction,
				DataCompte.dataCompte.rechercher(idCompte.get(index)),
				montant.get(index)
				);
	}
	
	public void modifier(int index,Transaction transaction) {
		idCompte.set(index,((Retrait) transaction).getCompte().getNumero());
		montant.set(index,((Retrait) transaction).getMontant());
	}
	
}
