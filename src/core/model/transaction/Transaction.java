package core.model.transaction;

import java.util.Date;

import core.model.exception.CompteNonValideException;
import core.model.exception.MontantNonValideException;

public abstract class Transaction {
	private int idTransaction;
	private Date dateTransaction;
	private TypeTransaction type;

	protected Transaction(int idTransaction, Date dateTransaction, TypeTransaction type) {
		super();
		this.idTransaction = idTransaction;
		this.dateTransaction = dateTransaction;
		this.type = type;
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

	public TypeTransaction getType() {
		return type;
	}

	public void setType(TypeTransaction type) {
		this.type = type;
	}

	abstract public void effectuer() throws MontantNonValideException, CompteNonValideException;
}
