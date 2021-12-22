package core.view;

import java.util.ArrayList;

import core.model.client.Client;
import core.model.compte.Compte;
import core.model.transaction.Transaction;

public abstract class Show {
    public static void menuShow() {

        display(" \n-----------------------------------------------MENU---------------------------------------------\n");
        display(" 1. Gestion de compte");
        display(" 2. Gestion de client");
        display(" 3. Gestion des transactions");
        display(" 0. Quitter le programme\n");
        display(" Choix :... ");

    }

    public static void gestionCompte() {
        display(" 1. Creer des comptes");
        display(" 2. fermer un compte");
        display(" 3. Lister les comptes");
        display(" 4. Recherche un compter");
        display(" 0. Retour au menu principal");
    }

    public static void gestionClient() {
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
    	display("1. depot");
    	display("2. retrait");
    	display("3. transfert");
    	display("4. lister les transactions");
    	display("0. retour au menu principal");
    }
    
    public static void menuModifierClient() {
    	display("1. Modifier le nom");
    	display("2. Modifier le prenom");
    	display("3. Modifier le type");
    	display("4. Modifier le sexe");
    	display("5. Modifier le adresse");
    	display("6. Modifier le nif");
    	display("7. Modifier le telephone");
    	display("0. modifier le client et retour au menu client");
    }

    public static void display(Object o) {
        System.out.println(o);
    }
    
    public static void display(Client client) {
        display(client.toString());
    }
    
    public static void display(Compte compte) {
        display(compte.toString());
    }
    
    public static void display(Transaction transaction) {
    	display(transaction.toString());
    }
    
    public static void displayTransaction(ArrayList<Transaction> transaction) {
    	Show.display(transaction.toString());
    }
    
    public static void displayCompte(ArrayList<Compte> compte) {
    	Show.display(compte.toString());
    }
    
    public static void displayClient(ArrayList<Client> client) {
    	Show.display(client.toString());
    }

}
