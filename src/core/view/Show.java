package core.view;

import java.util.ArrayList;

import core.model.client.Client;
import core.model.compte.Compte;
import core.model.transaction.Transaction;

public abstract class Show {
    public static void menuShow() {

        display("\n-----------------------------------------------------------------------------------------------------");
        display("  ****************************************MENU PRINCIPAL****************************************");
        display("----------------------------------------------------------------------------------------------------\n");

        display(" 1. Gestion de compte");
        display(" 2. Gestion de client");
        display(" 3. Gestion des transactions");
        display(" 0. Quitter le programme\n");
        display(" Choix :... ");

    }

    public static void gestionCompte() {
        display("\n-----------------------------------------------------------------------------------------------------");
        display("****************************************Gestion Des Comptes****************************************");
        display("----------------------------------------------------------------------------------------------------\n");

        display(" 1. Creer des comptes");
        display(" 2. fermer un compte");
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
        displayFormat(15, "Proprietaire");

        display("\n-----------------------------------------------------------------------------------------------------------------");

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
        display("\n\n*******************************Affichage des Transactions************************\n");
        barnerCompte();
        Show.display(transaction.toString());
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
            if (compte2.getProprietaire().equals(null)) {
                displayFormat(15, "");
            } else {
                displayFormat(15, compte2.getProprietaire());
            }
            System.out.println();
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
            displayFormat(15, client2.getNif());
            displayFormat(15, client2.getTelephone());
            System.out.println();
        }

    }

    public static void displayFormat(int length, Object o) {
        System.out.print(String.format("%-" + length + "s", o));
    }

    // public static void disFormat(Object o) {
    // System.out.print(String.format("%15s", o));
    // }

    // public static void viewFormat(Object o) {
    // String.format("%-15s", o);
    // }

    public static void isNull() {

    }

}
