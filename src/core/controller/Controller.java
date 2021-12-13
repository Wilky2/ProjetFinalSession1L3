package core.controller;

import java.sql.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

import core.data.DataClient;
import core.data.DataCompte;
import core.data.NoExistException;
import core.features.GenerateId;
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
    GenerateId gen = new GenerateId();
    Read read;
    TypeCompte type;
    Client client;
    Devise devise;
    Etat etat;
    Sexe sexe;
    Scanner sc = new Scanner(System.in);
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

    public void running() throws NoExistException {
        switchCaseProgram();
    }

    /**
     * switchCaseProgram
     * 
     * @throws NoExist
     */
    public void switchCaseProgram() throws NoExistException {

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
                    // transactionSwitchCase();
                    break;
                default:
                    break;
            }

        }
        // catch (NullPointerException e) {
        // Show.display("Mauvaise choix");
        // sc.nextLine();
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

    public void compteSwitchCase() throws NoExistException {
        Integer choix;
        Integer response;

        do {

            Show.operation();
            try {
                choix = read.readInt();
                response = 1;

                switch (choix) {
                    case 1:
                        DataCompte.dataCompte.enregistrer(CompteMain());
                        break;

                    case 2:
                        DataCompte.dataCompte.modifier(modifierCompteMain());
                        break;

                    case 3:
                        Show.display(DataCompte.dataCompte.lister());
                        break;

                    case 4:
                        Show.display(DataCompte.dataCompte.rechercher(modifierNumberCompte()));
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

    public void clientSwitchCase() throws NoExistException {
        Integer choix;
        Integer response;

        do {

            Show.gestionClient();
            try {
                choix = read.readInt();
                response = 1;

                switch (choix) {
                    case 1:
                        DataClient.dataClient.enregistrer(ClientMain());
                        break;
                    case 2:
                        DataClient.dataClient.modifier(modifierClientMain());
                        break;
                    case 3:
                        Show.display(DataClient.dataClient.lister());
                        break;
                    case 4:
                        DataClient.dataClient.supprimer(supprimerIdClient());
                        break;
                    case 5:
                        Show.display(DataClient.dataClient.rechercher(modifierIdClient()));
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

    public Compte modifierCompteMain() {

        int numero;
        double solde;
        Show.display("--------->Option Gompte ");

        Show.displayF("Entrer le numero a modifier du compte : ");
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

        String idClient;
        String nom, prenom, adresse;
        Show.display("--------->Option Client ");

        idClient = gen.valueIdCLient();
        Show.displayF("L'idClient du Client : " + idClient);
        // idClient = sc.nextLine();

        Show.displayF("\nEntrer le nom du Client : ");
        nom = sc.nextLine();

        Show.displayF("Entrer le prenom du Client : ");
        prenom = sc.nextLine();

        typeClient = typeClientValue();
        sexe = sexeClientValue();

        Show.displayF("Entrer l'adresse du Client : ");
        adresse = sc.nextLine();

        return new Client(idClient, nom, prenom, typeClient, sexe, adresse);

    }

    public Client modifierClientMain() {
        String idClient;
        String nom, prenom, adresse;
        Show.display("--------->Option Client ");

        Show.displayF("Entrer l'id du Client a modifier : ");
        idClient = read.readNextLine();

        Show.displayF("Entrer le nom du Client : ");
        nom = read.readNextLine();

        Show.displayF("Entrer le prenom du Client : ");
        prenom = read.readNextLine();

        typeClient = typeClientValue();
        sexe = sexeClientValue();

        Show.displayF("Entrer l'adresse du Client : ");
        adresse = sc.next();

        return new Client(idClient, nom, prenom, typeClient, sexe, adresse);

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

    // --------------------------------------------------------------------------------------
    // Fonction d'aides pour les Classe DATA
    // --------------------------------------------------------------------------------------
    public String modifierIdClient() {
        Show.display("Rechercher par id client");
        String m_idClient = sc.nextLine();
        return m_idClient;
    }

    public String supprimerIdClient() {
        Show.display("Supprimer par id client");
        String s_idCLient = sc.nextLine();
        return s_idCLient;
    }

    public int modifierNumberCompte() {
        Show.display("Supprimer un compte par numero");
        int numero = read.readInt();
        return numero;
    }

}
