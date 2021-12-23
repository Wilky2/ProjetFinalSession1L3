package core.features;

import java.util.Random;

import core.data.DataCompte;
import core.model.compte.Compte;
import core.model.compte.Devise;
import core.model.compte.Etat;
import core.model.compte.TypeCompte;

public class Generate {

    private int idClient;
    private int numeroCompte;
    private int idTransaction;
    
    public static Generate generate = new Generate();
    
    private Generate() {
    	this.idClient = 10;
        this.numeroCompte = 100000;
        this.idTransaction = 100000;
    }
    
    public int generateNumeroCompte() {
    	int numero = this.numeroCompte;
    	this.numeroCompte++;
    	return numero;
    }
    
    public int generatIdTransaction() {
    	int id = this.idTransaction;
    	this.idTransaction++;
    	return id;
    }
    
    public String generateIdClient(String nom,String prenom) {
    	/*
    	 * 1er caracter nom + 1er caracter prenom + valeur variable idClient
    	 */
    	String idClient = nom.substring(0,1) + prenom.substring(0,1) + this.idClient;
    	this.idClient ++;
    	return idClient;
    }
    
    public void generateCompte(int quantite, TypeCompte type,Devise devise) {
    	for(int i = 0;i<quantite;i++) {
    		DataCompte.dataCompte.enregistrer(new Compte(this.generateNumeroCompte(),
    				type,
    				devise,
    				0,
    				Etat.N
    				));
    	}
    }
}
