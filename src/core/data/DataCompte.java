package core.data;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

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
	private ArrayList<String> idProprietaire;
	
	public static DataCompte dataCompte = new DataCompte();
	
	private DataCompte(){
		super();
		this.numeroCompte = new ArrayList<Integer>();
		this.type = new ArrayList<TypeCompte>();
		this.devise = new ArrayList<Devise>();
		this.solde = new ArrayList<Double>();
		this.etat = new ArrayList<Etat>();
		this.idProprietaire = new ArrayList<String>();
	}

	public void enregistrer(Compte compte) {
		this.numeroCompte.add(compte.getNumero());
		this.type.add(compte.getType());
		this.devise.add(compte.getDevise());
		this.solde.add(compte.getSolde());
		this.etat.add(compte.getEtat());
		if(compte.getProprietaire() == null) {
			this.idProprietaire.add(null);
		}
		else {
			this.idProprietaire.add(compte.getProprietaire().getIdClient());
		}	
	}
	
	public Compte  rechercher(int numero) {
		
		int indexNumeroCompte = this.numeroCompte.indexOf(numero);
		if(indexNumeroCompte < 0) {
			return null;
		}
		Client proprietaire = DataClient.dataClient.rechercher(idProprietaire.get(indexNumeroCompte));
		return new Compte(this.numeroCompte.get(indexNumeroCompte),
				this.type.get(indexNumeroCompte),
				this.devise.get(indexNumeroCompte),
				this.solde.get(indexNumeroCompte),
				this.etat.get(indexNumeroCompte),
				proprietaire
				);
	}
	
	public ArrayList<Compte> rechercherParClient(String idClient) {
		ArrayList<Compte> listeCompte = new ArrayList<Compte>();
		for(int i = 0 ; i< this.numeroCompte.size();i++) {
			if(this.idProprietaire.get(i) !=null && this.idProprietaire.get(i).equals(idClient)) {
				listeCompte.add(this.rechercher(this.numeroCompte.get(i)));
			}		
		}
		return listeCompte;
	}
	
	public void modifier(Compte compte) throws NoExistException {
		int indexNumeroCompte = this.numeroCompte.indexOf(compte.getNumero());
		if(indexNumeroCompte < 0) {
			throw new NoExistException();
		}
		this.numeroCompte.set(indexNumeroCompte, compte.getNumero());
		this.type.set(indexNumeroCompte, compte.getType());
		this.devise.set(indexNumeroCompte, compte.getDevise());
		this.solde.set(indexNumeroCompte, compte.getSolde());
		this.etat.set(indexNumeroCompte, compte.getEtat());
		if(compte.getProprietaire() == null) {
			this.idProprietaire.set(indexNumeroCompte, null);
		}
		else {
			this.idProprietaire.set(indexNumeroCompte, compte.getProprietaire().getIdClient());
		}
	}
	
	public void supprimer(int id) throws NoExistException {
		int indexNumeroCompte = this.numeroCompte.indexOf(id);
		if(indexNumeroCompte < 0) {
			throw new NoExistException();
		}
		this.numeroCompte.remove(indexNumeroCompte);
		this.type.remove(indexNumeroCompte);
		this.devise.remove(indexNumeroCompte);
		this.solde.remove(indexNumeroCompte);
		this.etat.remove(indexNumeroCompte);
		this.idProprietaire.remove(indexNumeroCompte);
	}
	
	public ArrayList<Compte> lister(){
		ArrayList<Compte> listeCompte = new ArrayList<Compte>();
		for(int i = 0 ; i< this.numeroCompte.size();i++) {
			listeCompte.add(this.rechercher(this.numeroCompte.get(i)));
		}
		return listeCompte;
	}
	
	public Compte rechercher(TypeCompte type,Devise devise,Etat etat) {
		for(int index = 0;index<this.type.size();index++) {
			if(this.type.get(index) == type && this.devise.get(index) == devise && this.etat.get(index) ==etat) {
				return this.rechercher(this.numeroCompte.get(index));
			} 
		}
		return null;
		
	}
}
