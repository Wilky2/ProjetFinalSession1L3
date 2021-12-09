package core.model.transaction;

import java.util.Date;

import core.model.compte.MontantNonValideException;

public abstract class Transaction {
	private int idTransaction;
	private Date dateTransaction;
	
	
	
	public Transaction(int idTransaction, Date dateTransaction) {
		super();
		this.idTransaction = idTransaction;
		this.dateTransaction = dateTransaction;
	}

	

	public int getIdTransaction() {
		return idTransaction;
	}



	public void setIdTransaction(int idTransaction) {
		this.idTransaction = idTransaction;
	}



	public Date getDateTransaction() {
		return dateTransaction;
	}



	public void setDateTransaction(Date dateTransaction) {
		this.dateTransaction = dateTransaction;
	}



	abstract public void effectuer() throws MontantNonValideException, CompteNonValideException;
}
