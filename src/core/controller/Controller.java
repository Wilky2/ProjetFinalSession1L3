package core.controller;

import java.util.InputMismatchException;
import java.util.Scanner;

import core.data.DataClient;
import core.data.DataCompte;
import core.model.client.Client;
import core.model.client.Sexe;
import core.model.client.TypeClient;
import core.model.compte.Compte;
import core.model.compte.Devise;
import core.model.compte.Etat;
import core.model.compte.TypeCompte;
// import core.model.features.Operation;
import core.view.Read;
import core.view.Show;

public class Controller {
    Read read;
    TypeCompte type;
    Client client;
    Devise devise;
    Etat etat;
    Sexe sexe;
    Scanner sc = new Scanner(System.in);
    DataClient dataClient;
    DataCompte dataCompte;
    TypeClient typeClient;


    public Controller() {
        read = new Read();
        Scanner sc = new Scanner(System.in);
        TypeCompte type;
        Devise devise;
        Etat etat;
        Sexe sexe;
        DataClient dataClient;
        // typeClient
    }

    public void running() {
        switchCaseProgram();
    }

    /**
     * switchCaseProgram
     */
    public void switchCaseProgram() {

        int choice;
        Show.menuShow();

        try {
            choice = read.readInt();

            switch (choice) {
                case 1:
                    compteSwitchCase();
                    break;
                case 2:
                    clientSwitchCase();
                    break;

                case 3:
                    // null
                    break;
                default:
                    break;
            }

        }
        //  catch (NullPointerException e) {
        //     Show.display("Mauvaise choix");
        //     sc.nextLine();
        // }

        catch (InputMismatchException e) {
            Show.display("Choix ne correspond pas");
            sc.nextLine();

        }

        catch (IndexOutOfBoundsException e) {
            Show.display("Vous avez depasser la taille prevue");
            sc.nextLine();

        }

        Show.display("Presser 1 pour continuer");
        String press = sc.next();
        if (press.equals("1")) {
            switchCaseProgram();
        }

    }

    // ----------------------------------------------------------------------------------------------------
    // clientSwitchCase
    // ----------------------------------------------------------------------------------------------------

    public void clientSwitchCase() {
        Integer choix;
        Integer response;

        do {

            Show.operation();
            try {
                choix = read.readInt();
                response = 1;

                switch (choix) {
                    case 1:
                        dataClient.enregistrer(ClientMain());
                        // DataClient.getInstance().
                        break;

                    case 2:
                        // dataClient.enregistrer(ClientMain());
                        Show.display("Rechercher par id client");
                        int idclient = read.readInt();
                        dataClient.rechercher(idclient);
                        break;

                    default:
                        break;
                }

            } catch (InputMismatchException e) {
                Show.display("Choix ne correspond pas");
                sc.nextLine();
            }

            Show.display("Souhaiter Vous Continuer (Oui 1) (0 Non)");
            response = read.readInt();
        } while (response.equals(1));

    }

    public void compteSwitchCase() {
        Integer choix;
        Integer response;

        do {

            Show.operation();
            try {
                choix = read.readInt();
                response = 1;

                switch (choix) {
                    case 1:
                        dataCompte.enregistrer(CompteMain());
                        break;

                    case 2:

                        break;

                    default:
                        break;
                }

            } catch (InputMismatchException e) {
                Show.display("Choix ne correspond pas");
                sc.nextLine();
            }

            Show.display("Souhaiter Vous Continuer (Oui 1) (0 Non)");
            response = read.readInt();
        } while (response.equals(1));

    }

    public static void name() {
        
    }
    // ----------------------------------------------------------------------------------------------------
    // endSwitchCaseProgram
    // ----------------------------------------------------------------------------------------------------

    public Compte CompteMain() {

        int numero;
        double solde;
        Show.display("--------->Option Gompte ");

        Show.displayF("Entrer le numero du compte : ");
        numero = read.readInt();

        type = typeCompteValue();
        devise = deviseCompteValue();

        Show.displayF("Entrer le solde du compte : ");
        solde = read.readInt();

        etat = etatCompteValue();
        return new Compte(numero, type, devise, solde, etat);

    }

    public TypeCompte typeCompteValue() {
        TypeCompte tp = null;
        int choix = 0;

        do {

            Show.display("\nchoisissez le type de compte");
            Show.display(" 1. Compte courant");
            Show.display(" 2. Compte epargne");
            choix = read.readInt();

            if (choix == 1) {

                Show.display("Le compte est de : Type  courant");

                tp = TypeCompte.courant;

            }

            if (choix == 2) {

                Show.display("Le compte est de : Type  epargne");

                tp = TypeCompte.epargne;

            }

        } while (choix != 1 && choix != 2);

        return tp;
    }

    public Devise deviseCompteValue() {
        Devise dv = null;
        int choix = 0;

        do {

            Show.display("\nchoisissez la devise du compte");
            Show.display(" 1. Devise du Compte en GOURDE");
            Show.display(" 2. Devise du Compte en DOLLAR");
            choix = read.readInt();

            if (choix == 1) {

                Show.display("Devise du comptes est : Dollar\n");

                dv = Devise.dollar;

            }

            if (choix == 2) {

                Show.display("Devise du comptes est : Gourde\n");

                dv = Devise.gourde;

            }

        } while (choix != 1 && choix != 2);

        return dv;
    }

    public Etat etatCompteValue() {
        Etat et = null;
        int choix = 0;

        do {

            Show.display("\nDefinissez l'etat du compte");
            Show.display(" 1. Attribuer : A");
            Show.display(" 2. Non Attribuer : N");
            Show.display(" 3. Fermer : F");
            choix = read.readInt();

            if (choix == 1) {

                Show.display("Le compte est maintenant : Attribuer\n");

                et = Etat.A;

            }

            if (choix == 2) {

                Show.display("Le compte est maintenant : Non Attribuer\n");

                et = Etat.N;

            }

            if (choix == 3) {

                Show.display("L'etat de compte : Fermer\n");

                et = Etat.F;

            }

        } while (choix != 1 && choix != 2 && choix != 3);

        return et;
    }

    // ----------------------------------------------------------------------------------------------------
    // endCompte
    // ----------------------------------------------------------------------------------------------------

    public Client ClientMain() {

        int idClient;
        String nom, prenom, adresse;
        Show.display("--------->Option Client ");

        Show.displayF("Entrer l'idClient du Client : ");
        idClient = read.readInt();

        Show.displayF("Entrer le nom du Client : ");
        nom = sc.nextLine();

        Show.displayF("Entrer le prenom du Client : ");
        prenom = sc.nextLine();

        typeClient = typeClientValue();
        sexe = sexeClientValue();

        Show.displayF("Entrer l'adresse du Client : ");
        adresse = sc.next();

        client = new Client(idClient, nom, prenom, typeClient, sexe, adresse);
        return client;

    }

    public TypeClient typeClientValue() {
        TypeClient tClient = null;
        int choix;

        do {

            Show.display("\nchoisissez le type de compte");
            Show.display(" 1. Client type Moral");
            Show.display(" 2. Client type Physique");
            // Show.display(" 2. Compte epargne");
            choix = read.readInt();

            if (choix == 1) {

                Show.display("Client de type : Moral");

                tClient = TypeClient.Moral;

            }

            if (choix == 2) {

                Show.display("Client de type : Physique");

                tClient = TypeClient.Physique;

            }

        } while (choix != 1 && choix != 2);

        return tClient;
    }

    public Sexe sexeClientValue() {
        Sexe sx = null;
        int choix;

        do {

            Show.display("\nDefinissez le sexe");
            Show.display(" 1. Masculin");
            Show.display(" 2. Feminin");
            Show.display(" 3. Aucun");
            choix = read.readInt();

            if (choix == 1) {

                Show.display("Le sexe est : Masculin\n");

                sx = Sexe.masculin;

            }

            if (choix == 2) {

                Show.display("Le sexe est : Feminin\n");

                sx = Sexe.masculin;

            }

            if (choix == 3) {

                Show.display("Aucun choix faites\n");

                sx = Sexe.masculin;

            }

        } while (choix != 1 && choix != 2 && choix != 3);

        return sx;
    }

    // ----------------------------------------------------------------------------------------------------
    // endClient
    //



}