package core.model.transaction;

import java.time.LocalDateTime;
import java.util.Date;

import core.model.exception.CompteNonValideException;
import core.model.exception.MontantNonValideException;

/*
 * Classe abstraite destinee a servir de classe mere pour toutes les classes
 * qui vont gerer differents types de transaction, tel que les depots, les retraits
 * les transferts etc...
 */
public abstract class Transaction {
	private int idTransaction;
	private LocalDateTime dateTransaction;
	private TypeTransaction type;
	public static double tauxGourdeEnDollar = 105;

	protected Transaction(int idTransaction, LocalDateTime dateTransaction, TypeTransaction type) {
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

	public LocalDateTime getDateTransaction() {
		return dateTransaction;
	}

	public void setDateTransaction(LocalDateTime dateTransaction) {
		this.dateTransaction = dateTransaction;
	}

	public TypeTransaction getType() {
		return type;
	}

	public void setType(TypeTransaction type) {
		this.type = type;
	}

	/*
	 * methode a appeler pour valider la transaction
	 */
	abstract public void effectuer() throws MontantNonValideException, CompteNonValideException;

	@Override
	public String toString() {
		return "Transaction [idTransaction=" + idTransaction + ", dateTransaction=" + dateTransaction + ", type=" + type.getType()
				+ "]";
	}
	
	
}
