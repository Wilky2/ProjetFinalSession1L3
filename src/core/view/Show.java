package core.view;

import java.util.ArrayList;

import core.model.client.Client;
import core.model.compte.Compte;
import core.model.transaction.Depot;
import core.model.transaction.Retrait;
import core.model.transaction.Transaction;
import core.model.transaction.Transfert;

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
        display(client.toString());
    }

    public static void display(Compte compte) {
        display(compte.toString());
    }

    public static void display(Transaction transaction) {
        display(transaction.toString());
    }

    public static void displayCompte(ArrayList<Compte> compte) {
        display("\n\n*******************************Affichage des Comptes************************\n");
        barnerCompte();
        for (Compte compte2 : compte) {
            displayFormat(15, compte2.getNumero());
            displayFormat(15, compte2.getType());
            displayFormat(15, compte2.getDevise());
            displayFormat(15, compte2.getSolde());
            displayFormat(15, compte2.getEtat());
            if (compte2.getProprietaire() != null) {
                displayFormat(15, compte2.getProprietaire().getIdClient());
            } else {
                displayFormat(15, "");
            }
            System.out.println();
        }
    }

    public static void displayClient(ArrayList<Client> client) {
        display("\n\n*******************************Affichage des Clients************************\n");
        barnerClient();
        for (Client client2 : client) {
            displayFormat(15, client2.getIdClient());
            displayFormat(15, client2.getNom());
            displayFormat(15, client2.getPrenom());
            displayFormat(15, client2.getType());
            displayFormat(15, client2.getSexe());
            displayFormat(15, client2.getAdresse());
            if (client2.getNif() != null) {
                displayFormat(15, client2.getNif());
            } else {
                displayFormat(15, "");
            }
            if (client2.getTelephone() != null) {
                displayFormat(15, client2.getTelephone());
            } else {
                displayFormat(15, "");
            }
            System.out.println();
        }

    }

    /**
     * FOnction Space String 
     * @param length
     * @param o
     */
    public static void displayFormat(int length, Object o) {
        System.out.print(String.format("%-" + length + "s", o));
    }

    // *****************************************************************************************
    // ****************************************** LISTER LES TRANSACTIONS
    // ***********************************************
    // *****************************************************************************************

    public static void displayTransaction(ArrayList<Transaction> transaction) {
        display("\n\n*******************************Affichage des Transactions************************\n");
        barnerTransaction();
        for (Transaction transaction2 : transaction) {
            displayFormat(15, transaction2.getIdTransaction());
            displayFormat(15, transaction2.getDateTransaction());
            displayFormat(15, transaction2.getType());
        }
        System.out.println();
    }

    private static void barnerTransaction() {

        displayFormat(15, "idTransaction");
        displayFormat(15, "dateTransaction");
        displayFormat(15, "type");

        display("\n-----------------------------------------------------------------------------------------------------------------");

    }

    public static void barnerDepot() {

        displayFormat(15, "idTransaction");
        displayFormat(15, "dateTransaction");
        displayFormat(15, "type");
        displayFormat(15, "compte");
        displayFormat(15, "montant");
        displayFormat(15, "nomDeposant");
        displayFormat(15, "prenomDeposant");

        display("\n-----------------------------------------------------------------------------------------------------------------");

    }

    public static void displayDepot(ArrayList<Depot> depots) {
        display("\n\n*******************************Affichage des Depots************************\n");
        barnerDepot();
        for (Depot depot2 : depots) {
            displayFormat(15, depot2.getIdTransaction());
            displayFormat(15, depot2.getDateTransaction());
            displayFormat(15, depot2.getType());
            displayFormat(15, depot2.getCompte());
            displayFormat(15, depot2.getMontant());
            displayFormat(15, depot2.getNomDeposant());
            displayFormat(15, depot2.getPrenomDeposant());

            System.out.println();
        }
    }

    public static void barnerTransfert() {
        displayFormat(15, "idTransaction");
        displayFormat(15, "dateTransaction");
        displayFormat(15, "type");
        displayFormat(15, "compteDebiteur");
        displayFormat(15, "montantDebiteur");
        displayFormat(15, "compteCrediteur");
        displayFormat(15, "montantCrediteur");
        displayFormat(15, "description");

        display("\n-----------------------------------------------------------------------------------------------------------------");

    }

    public static void displayTransfert(ArrayList<Transfert> transferts) {
        display("\n\n*******************************Affichage des Transferts************************\n");
        barnerTransfert();

        for (Transfert transfert2 : transferts) {
            displayFormat(15, transfert2.getIdTransaction());
            displayFormat(15, transfert2.getDateTransaction());
            displayFormat(15, transfert2.getType());
            displayFormat(15, transfert2.getCompteDebiteur());
            displayFormat(15, transfert2.getMontantDebiteur());
            displayFormat(15, transfert2.getCompteCrediteur());
            displayFormat(15, transfert2.getMontantCrediteur());
            displayFormat(15, transfert2.getDescription());
        }

    }

    public static void barnerRetrait() {
        displayFormat(15, "idTransaction");
        displayFormat(15, "dateTransaction");
        displayFormat(15, "type");
        displayFormat(15, "compte");
        displayFormat(15, "montant");


        display("\n-----------------------------------------------------------------------------------------------------------------");

    }

    public static void displayRetrait(ArrayList<Retrait> retraits) {
        display("\n\n*******************************Affichage des Retraits************************\n");
        barnerRetrait();

        for (Retrait retrait2 : retraits) {
            displayFormat(15, retrait2.getIdTransaction());
            displayFormat(15, retrait2.getDateTransaction());
            displayFormat(15, retrait2.getType());
            displayFormat(15, retrait2.getCompte());
            displayFormat(15, retrait2.getMontant());
        }
        System.out.println();


    }

}
