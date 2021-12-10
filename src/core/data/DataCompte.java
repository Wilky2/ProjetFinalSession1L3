package core.data;

import java.util.ArrayList;

import core.model.client.Client;
import core.model.compte.Compte;
import core.model.compte.Devise;
import core.model.compte.Etat;
import core.model.compte.TypeCompte;

public class DataCompte {
	
	private ArrayList<Integer> numeroCompte;
	private ArrayList<TypeCompte> type;
	private ArrayList<Devise> devise;
	private ArrayList<Double> solde;
	private ArrayList<Etat> etat;
	private ArrayList<Integer> idProprietaire;
	
	public static DataCompte dataCompte = new DataCompte();
	
	private DataCompte(){
		super();
		this.numeroCompte = new ArrayList<Integer>();
		this.type = new ArrayList<TypeCompte>();
		this.devise = new ArrayList<Devise>();
		this.solde = new ArrayList<Double>();
		this.etat = new ArrayList<Etat>();
		this.idProprietaire = new ArrayList<Integer>();
	}

	public void enregistrer(Compte compte) {
		numeroCompte.add(compte.getNumero());
		type.add(compte.getType());
		devise.add(compte.getDevise());
		solde.add(compte.getSolde());
		etat.add(compte.getEtat());
		if(compte.getProprietaire() == null) {
			idProprietaire.add(-1);
		}
		else {
			idProprietaire.add(compte.getProprietaire().getIdClient());
		}	
	}
	
	public Compte  rechercher(int numero) {
		
		int indexNumeroCompte = numeroCompte.indexOf(numero);
		if(indexNumeroCompte < 0) {
			return null;
		}
		Client proprietaire = DataClient.dataClient.rechercher(idProprietaire.get(indexNumeroCompte));
		return new Compte(numeroCompte.get(indexNumeroCompte),
				type.get(indexNumeroCompte),
				devise.get(indexNumeroCompte),
				solde.get(indexNumeroCompte),
				etat.get(indexNumeroCompte),
				proprietaire
				);
	}
}
