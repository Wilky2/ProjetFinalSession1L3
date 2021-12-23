package core.view;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import core.model.client.Client;
import core.model.compte.Compte;
import core.model.transaction.Depot;
import core.model.transaction.Retrait;
import core.model.transaction.Transaction;
import core.model.transaction.Transfert;
import core.model.transaction.TypeTransaction;

public abstract class Show {
	public static void menuShow() {

        display("\n-----------------------------------------------------------------------------------------------------");
        display("  ****************************************MENU PRINCIPAL****************************************");
        display("----------------------------------------------------------------------------------------------------\n");

        display(" 1. Gestion de compte");
        display(" 2. Gestion de client");
        display(" 3. Gestion des transactions");
        display(" 4. Taux de change");
        display(" 0. Quitter le programme\n");
        display(" Choix :... ");

    }
	
	public static void gestionCompte() {
        display("\n-----------------------------------------------------------------------------------------------------");
        display("****************************************Gestion Des Comptes****************************************");
        display("----------------------------------------------------------------------------------------------------\n");

        display(" 1. Creer des comptes");
        display(" 2. modifier un compte");
        display(" 3. Lister les comptes");
        display(" 4. Recherche un compter");
        display(" 0. Retour au menu principal"); 
    }

    public static void gestionClient() {

        display("\n-----------------------------------------------------------------------------------------------------");
        display("****************************************Gestion Des Clients****************************************");
        display("----------------------------------------------------------------------------------------------------\n");

        display(" 1. Enregistrer un client");
        display(" 2. Modifier un client");
        display(" 3. Lister les clients");
        display(" 4. Supprimer un client");
        display(" 5. Rechercher un client");
        display(" 6. Donner un compte supplementaire a un client");
        display(" 7. Liste des comptes d'un client");
        display(" 0. retour au menu principal");
    }

    public static void gestionTransaction() {
        display("\n-----------------------------------------------------------------------------------------------------");
        display("****************************************Gestion Des Transaction****************************************");
        display("----------------------------------------------------------------------------------------------------\n");

        display("1. depot");
        display("2. retrait");
        display("3. transfert");
        display("4. lister les transactions");
        display("0. retour au menu principal");
    }

    public static void menuModifierClient() {

        display("\n-----------------------------------------------------------------------------------------------------");
        display("**************************************** Menu Modification Clients****************************************");
        display("----------------------------------------------------------------------------------------------------\n");

        display("1. Modifier le nom");
        display("2. Modifier le prenom");
        display("3. Modifier le type");
        display("4. Modifier le sexe");
        display("5. Modifier le adresse");
        display("6. Modifier le nif");
        display("7. Modifier le telephone");
        display("0. modifier le client et retour au menu client");
    }
    
    public static void menuTaux() { 
    	display("\n-----------------------------------------------------------------------------------------------------");
        display("**************************************** Taux de change ****************************************");
        display("----------------------------------------------------------------------------------------------------\n");

    	display(" 1. Verifier le taux de change");
    	display(" 2. Changer le taux de change");
    	display(" 0. Retour au menu principal");
    }
    
    
    public static void menuListerTransaction() {
    	display("\n-----------------------------------------------------------------------------------------------------");
        display("**************************************** Menu Liste Transaction****************************************");
        display("----------------------------------------------------------------------------------------------------\n");

    	display("1. Lister tous les transaction");
    	display("2. Lister les depots");
    	display("3. Lister les retraits");
    	display("4. Lister les transferts");
    	display("0. Retour au menu transaction");
    }

    public static void barnerClient() {
        displayFormat(15, "IdClient");
        displayFormat(15, "Nom");
        displayFormat(15, "Prenom"); 
        displayFormat(15, "Type");
        displayFormat(15, "Sexe");
        displayFormat(15, "Adresse");
        displayFormat(15, "Nif");
        displayFormat(15, "Telephone");

        display("\n-----------------------------------------------------------------------------------------------------------------");

    }

    private static void barnerCompte() {
        displayFormat(15, "Numero");
        displayFormat(15, "Type");
        displayFormat(15, "Devise");
        displayFormat(15, "Solde");
        displayFormat(15, "Etat");
        displayFormat(15, "Id Proprietaire");

        display("\n-----------------------------------------------------------------------------------------------------------------");

    }

    public static void display(Object o) {
        System.out.println(o);
    }

    public static void display(Client client) {
    	ArrayList<Client> c =  new ArrayList<Client>(); 
    	c.add(client);
        displayClient(c);
    }

    public static void display(Compte compte) {
    	ArrayList<Compte> c =  new ArrayList<Compte>();
    	c.add(compte);
        displayCompte(c);
    }

    public static void display(Transaction transaction) {
    	ArrayList<Transaction> t =  new ArrayList<Transaction>();
    	t.add(transaction);
        displayTransaction(t);
    }
 
    public static void displayCompte(ArrayList<Compte> compte) {
        display("\n\n*******************************Affichage des Comptes************************\n");
        barnerCompte();
        int i = 0; 
        for (Compte compte2 : compte) {
            displayFormat(15, compte2.getNumero());
            displayFormat(15, compte2.getType());
            displayFormat(15, compte2.getDevise());
            displayFormat(15, compte2.getSolde());
            displayFormat(15, compte2.getEtat());
            if (compte2.getProprietaire()!=null) {
                displayFormat(15, compte2.getProprietaire().getIdClient());
            } else {
                displayFormat(15, "");
            }
            display("\n");
        }
    }

    public static void displayClient(ArrayList<Client> client) {
        display("\n\n*******************************Affichage des Clients************************\n");
        barnerClient();
        int i = 0;
        for (Client client2 : client) {
            displayFormat(15, client2.getIdClient());
            displayFormat(15, client2.getNom());
            displayFormat(15, client2.getPrenom());
            displayFormat(15, client2.getType());
            displayFormat(15, client2.getSexe());
            displayFormat(15, client2.getAdresse());
            if(client2.getNif()!=null) {
            	displayFormat(15, client2.getNif());
            }
            else {
            	displayFormat(15, "");
            }
            if(client2.getTelephone()!=null) {
            	displayFormat(15, client2.getTelephone());
            }
            else {
            	displayFormat(15, "");
            } 
            display("\n");
        }

    }

    public static void displayFormat(int length, Object o) {
        System.out.print(String.format("%-" + length + "s", o));
    }

    
    public static void displayTransaction(ArrayList<Transaction> transaction) {
    	ArrayList<Depot> depot = new ArrayList<Depot>();
    	ArrayList<Transfert> transfert = new ArrayList<Transfert>();
    	ArrayList<Retrait> retrait = new ArrayList<Retrait>();
    	TypeTransaction type = null;
        display("\n\n*******************************Affichage des Transactions************************\n");
        for (Transaction transaction2 : transaction) {
            type = transaction2.getType();
            switch(type) {
            case depot:{
            	depot.add((Depot) transaction2);
            }break;
            
            case retrait:{
            	retrait.add((Retrait) transaction2); 
            }break;
            
            case transfert:{
            	transfert.add((Transfert) transaction2);
            }break;
            }
        }
        if(!depot.isEmpty()) {
        	Show.displayDepot(depot);
        }
        
        if(!retrait.isEmpty()) {
        	Show.displayRetrait(retrait);
        }
        
        if(!transfert.isEmpty()) {
        	Show.displayTransfert(transfert);
        }
        System.out.println();
    }

    private static void barnerTransaction() {

        displayFormat(25, "id Transaction");
        displayFormat(25, "date Transaction");
        displayFormat(25, "type");

        display("\n-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");

    }

    public static void barnerDepot() {

        displayFormat(25, "Id Transaction");
        displayFormat(25, "Date Transaction");
        displayFormat(25, "Type");
        displayFormat(25, "Numero Compte");
        displayFormat(25, "Montant");
        displayFormat(25, "Nom Deposant");
        displayFormat(25, "Prenom Deposant");

        display("\n-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");   
   }    

    public static void displayDepot(ArrayList<Depot> depots) {
        display("\n\n*******************************Affichage des Depots************************\n");
        DateTimeFormatter date = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        
        barnerDepot();
        for (Depot depot2 : depots) {
            displayFormat(25, depot2.getIdTransaction());
            displayFormat(25, depot2.getDateTransaction().format(date));
            displayFormat(25, depot2.getType());
            displayFormat(25, depot2.getCompte().getNumero());
            displayFormat(25, depot2.getMontant());
            displayFormat(25, depot2.getNomDeposant());
            displayFormat(25, depot2.getPrenomDeposant());
            display("\n");
        }
    }

    public static void barnerTransfert() {
        displayFormat(25, "Id Transaction");
        displayFormat(25, "Date Transaction");
        displayFormat(25, "Type");
        displayFormat(25, "Numero Compte Debiteur");
        displayFormat(25, "Montant Debiteur");
        displayFormat(25, "Numero Compte Crediteur");
        displayFormat(25, "Montant Crediteur");
        displayFormat(25, "Description");

        display("\n-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
    }

    public static void displayTransfert(ArrayList<Transfert> transferts) {
        display("\n\n*******************************Affichage des Transferts************************\n");
        barnerTransfert();
        DateTimeFormatter date = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        for (Transfert transfert2 : transferts) {
            displayFormat(25, transfert2.getIdTransaction());
            displayFormat(25, transfert2.getDateTransaction().format(date));
            displayFormat(25, transfert2.getType());
            displayFormat(25, transfert2.getCompteDebiteur().getNumero());
            displayFormat(25, transfert2.getMontantDebiteur());
            displayFormat(25, transfert2.getCompteCrediteur().getNumero());
            displayFormat(25, transfert2.getMontantCrediteur()); 
            displayFormat(25, transfert2.getDescription());
            display("\n");
        }

    }

    public static void barnerRetrait() {
        displayFormat(25, "Id Transaction");
        displayFormat(25, "Date Transaction");
        displayFormat(25, "Type");
        displayFormat(25, "Numero Compte");
        displayFormat(25, "Montant");


        display("\n-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
    }
 
    public static void displayRetrait(ArrayList<Retrait> retraits) {
        display("\n\n*******************************Affichage des Retraits************************\n");
        barnerRetrait();
        DateTimeFormatter date = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        for (Retrait retrait2 : retraits) {
            displayFormat(25, retrait2.getIdTransaction());
            displayFormat(25, retrait2.getDateTransaction().format(date));
            displayFormat(25, retrait2.getType()); 
            displayFormat(25, retrait2.getCompte().getNumero());
            displayFormat(25, retrait2.getMontant());
            display("\n");
        }
    }

}
