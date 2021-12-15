package core.controller;

import java.io.Console;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.InputMismatchException;
import core.data.DataClient;
import core.data.DataCompte;
import core.data.DataTransaction;
import core.data.NoExistException;
import core.features.Generate;
import core.model.client.Client;
import core.model.client.Sexe;
import core.model.client.TypeClient;
import core.model.compte.Compte;
import core.model.compte.Devise;
import core.model.compte.Etat;
import core.model.compte.TypeCompte;
import core.model.exception.CompteNonValideException;
import core.model.exception.MontantNonValideException;
import core.model.transaction.Depot;
import core.model.transaction.Retrait;
import core.model.transaction.Transaction;
import core.model.transaction.Transfert;
import core.view.Read;
import core.view.Show;

public class Controller {
    Read read;
    
    public Controller() {
        read = new Read();
    }

    public void running() {
        switchCaseProgram();
    }

    public void switchCaseProgram() {

        int choice = 1;
      
        while(choice!=0){

	        try {
	            Show.menuShow();
	            choice = read.readInt();
	            
	            switch (choice) {
	            	case 0:{
	            		Show.display("Fin du programme");
	            	}break;
	            	
	                case 1:{
	                    compteSwitchCase();
	                }break;
	
	                case 2:{
	                    clientSwitchCase();
	                }break;
	
	                case 3:{
	                    transactionSwitchCase();
	                }break;
	                
	                default:{
	                	Show.display("Mauvais choix");
	                }break;
	            }
	
	        }
	        catch (InputMismatchException e) {
	            Show.display("Mauvais choix");
	            read.readNextLine();
	        }
	        
	        if(choice!=0) {
	            Show.display("Presser enter pour continuer");
		        try {
					System.in.read();
				} catch (IOException e) {
				}
            }
        }
    }

    private void transactionSwitchCase() {
    	int choice = 1;
        
        while(choice!=0){

	        try {
	            Show.gestionTransaction();
	            choice = read.readInt();  
	            switch (choice) {
	            	case 0:{
	            		
	            	}break;
	            	
	                case 1:{
	                    Show.display("Entrer l'id du compte sur lequel vous voulez deposer le montant");
	                    Compte compte = DataCompte.dataCompte.rechercher(read.readInt());
	                    if(compte!=null){
	                    	Show.display("Entrer le montant du depot");
	                    	double montant = read.readDouble();
	                    	Show.display("Entrer le nom du deposant");
	                    	String nom = read.readString();
	                    	Show.display("Entrer le prenom du deposant");
	                    	String prenom = read.readString();
	                    	Transaction transaction = new Depot(Generate.generate.generatIdTransaction(),
	                    			LocalDateTime.now(),
	                    			compte,
	                    			montant,
	                    			nom,
	                    			prenom
	                    			);
	                    	transaction.effectuer();
	                    	DataCompte.dataCompte.modifier(compte);
	                    	DataTransaction.dataTransaction.enregistrer(transaction);
	                    }
	                    else {
	                    	Show.display("Le compte sur lequel vous voulez effectuer le depot n'existe pas");
	                    }
	                }break;
	
	                case 2:{
	                	Show.display("Entrer l'id du compte sur lequel vous voulez effectuer le retrait");
	                    Compte compte = DataCompte.dataCompte.rechercher(read.readInt());
	                    if(compte!=null) {
	                    	Show.display("Ëntrer le montant du retrait");
	                    	double montant = read.readDouble();
	                    	Transaction transaction = new Retrait(Generate.generate.generatIdTransaction(),
	                    			LocalDateTime.now(),
	                    			compte,
	                    			montant
	                    			);
	                    	transaction.effectuer();
	                    	DataCompte.dataCompte.modifier(compte);
	                    	DataTransaction.dataTransaction.enregistrer(transaction);
	                    }
	                    else {
	                    	Show.display("Le compte sur lequel vous voulez effectuer le retrait n'existe pas");
	                    }
	                    
	                }break;
	
	                case 3:{
	                	Show.display("Entrer l'id du compte debiteur");
	                    Compte compteDebiteur = DataCompte.dataCompte.rechercher(read.readInt());
	                    if(compteDebiteur!=null) {
	                    	Show.display("Entrer le montant a debiter");
	                    	double montantDebiteur = read.readDouble();
	                    	Show.display("Entrer l'id du compte crediteur");
	                    	Compte compteCrediteur = DataCompte.dataCompte.rechercher(read.readInt());
	                    	if(compteCrediteur!=null) {
	                    		Show.display("Entre le montant a crediter");
	                    		double montantCrediteur = read.readDouble();
	                    		Show.display("Description du transfert");
	                    		String description = read.readString();
	                    		Transaction transaction = new Transfert(Generate.generate.generatIdTransaction(),
		                    			LocalDateTime.now(),
		                    			compteDebiteur,
		                    			montantDebiteur,
		                    			compteCrediteur,
		                    			montantCrediteur,
		                    			description
	                    				);
	                    		transaction.effectuer();
	                    		DataCompte.dataCompte.modifier(compteDebiteur);
	                    		DataCompte.dataCompte.modifier(compteCrediteur);
		                    	DataTransaction.dataTransaction.enregistrer(transaction);
	                    	}
	                    	else {
	                    		Show.display("Le compte crediteur n'existe pas");
	                    	}
	                    }
	                    else {
	                    	Show.display("Le compte debiteur n'existe pas");
	                    }
	                }break;
	                
	                case 4:{
	                	Show.displayTransaction(DataTransaction.dataTransaction.lister());
	                }break;
	                
	                default:{
	                	Show.display("Mauvais choix");
	                }break;
	            }
	
	        }
	        catch (InputMismatchException e) {
	            Show.display("Mauvais choix");
	            read.readNextLine();
	        }
	        catch (CompteNonValideException e) {
	        	Show.display("Vous ne pouvez pas effectuer de transaction sur ce compte");
	        }
	        catch(MontantNonValideException e) {
	        	Show.display("Le montant que vous avez entrer n'est pas valide");
	        }
	        catch(NoExistException e){
	        	Show.display("Le compte ne se trouve pas dans notre base de donnée");
	        }
	        
	        if(choice!=0) {
	            Show.display("Presser enter pour continuer");
		        try {
					System.in.read();
				} catch (IOException e) {
				}
            }
	        
        }		
	}

    private void compteSwitchCase(){
        int choix=1;
        
        while(choix!=0){

            Show.gestionCompte();
            try {
                choix = read.readInt();

                switch (choix) {
                	
                	case 0:
                		break;
                
                	case 1:
                        CompteMain();
                        break;

                    case 2:
                        modifierCompteMain();
                        break;

                    case 3:
                        Show.displayCompte(DataCompte.dataCompte.lister());
                        break;

                    case 4:
                    	Show.display("Entrer le numero du compte a rechercher");
                        int numero = read.readInt();
                        Compte compte = DataCompte.dataCompte.rechercher(numero); 
                        if(compte == null) {
                        	Show.display("Le compte n'existe pas");
                        }
                        else {
                        	Show.display(compte);
                        }
                        break;

                    default:
                        break;
                }

            } catch (InputMismatchException e) {
                Show.display("Choix ne correspond pas");
                read.readNextLine();
            }
            catch(NoExistException e) {
            	Show.display("Le compte que vous voulez modifier n'existe pas");
            }
            
            if(choix!=0) {
	            Show.display("Presser enter pour continuer");
		        try {
					System.in.read();
				} catch (IOException e) {
				}
            }
        } 

    }

    private void clientSwitchCase(){
        int choix=1;
        int response;

        while(choix!=0){

            Show.gestionClient();
            try {
                choix = read.readInt();

                switch (choix) {
                
                	case 0:
                		break;
                    case 1:
                        ClientMain();
                        break;
                    case 2:
                        modifierClientMain();
                        break;
                    case 3:
                        Show.displayClient(DataClient.dataClient.lister());
                        break;
                    case 4:
                        supprimerIdClient();
                        break;
                    case 5:
                    	Show.display("Entrer l'id du client");
                        String idClient = read.readString();
                        Client client = DataClient.dataClient.rechercher(idClient);
                        if(client == null) {
                        	Show.display("Le client ne se trouve pas dans la base de donnée");
                        }
                        else {
                        	Show.display(client);
                        }	
                        break;
                        
                    case 6:{
                    	ajouterCompte();
                    }break;
                    
                    case 7:{
                    	Show.display("Entrer l'id du client");
                    	Show.displayCompte(DataCompte.dataCompte.rechercherParClient(read.readString()));
                    }break;
                    default:
                        break;
                }

            } catch (InputMismatchException e) {
                Show.display("Choix ne correspond pas");
                read.readNextLine();
            }
            catch(NoExistException e) {
            	Show.display("Le client n'existe pas");
            }
            if(choix!=0) {
	            Show.display("Presser enter pour continuer");
		        try {
					System.in.read();
				} catch (IOException e) {
				}
            }
        } 

    }

  private void ajouterCompte() throws NoExistException {
		Show.display("Entrer l'id du client");
		Client client = DataClient.dataClient.rechercher(read.readString());
		if(client == null) {
			Show.display("Le client n'existe pas dans la base de donnée");
			return;
		}
		TypeCompte type = typeCompteValue();
		Devise devise = deviseCompteValue();
		
		ArrayList<Compte> listeCompteClient = DataCompte.dataCompte.rechercherParClient(client.getIdClient());
		for(Compte c : listeCompteClient){
			if(c.getType() == type && c.getDevise() == devise) {
				Show.display("Vous avez deja un compte du meme type");
				return;
			}
		}
		
		Compte compte = DataCompte.dataCompte.rechercher(type, devise, Etat.N);
	       
	    if(compte == null) {
	    	Show.display("Il n y'a pas de compte disponible, veuillez en creer");
	    	return;
	   }
	    
	   compte.setProprietaire(client);
	   compte.setEtat(Etat.A);
	   
	   DataCompte.dataCompte.modifier(compte);
	}

// ----------------------------------------------------------------------------------------------------
    // endSwitchCaseProgram
    // ----------------------------------------------------------------------------------------------------

    private void CompteMain() {

        int quantite;

        Show.display("Entrer la quantite de compte a generer");
        quantite = read.readInt();

        TypeCompte type = typeCompteValue();
        Devise devise = deviseCompteValue();
        
        Generate.generate.generateCompte(quantite, type, devise);
    }

    private void modifierCompteMain() throws NoExistException {

        int numero;

        Show.display("Entrer le numero du compte a fermer : ");
        numero = read.readInt();
        
        Compte compte = DataCompte.dataCompte.rechercher(numero);
        if(compte == null) {
        	Show.display("Le compte n'existe pas");
        	return;
        }
        
        if(compte.getEtat() == Etat.N) {
        	Show.display("Le compte n'est pas encore attribué");
        	return;
        }
        
        compte.setEtat(Etat.F);
        
        DataCompte.dataCompte.modifier(compte);

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

                Show.display("Devise du comptes est : Gourde\n");

                dv = Devise.gourde;

            }

            if (choix == 2) {

                Show.display("Devise du comptes est : Dollar\n");

                dv = Devise.dollar;

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

    public void ClientMain() throws NoExistException {

    	int choix;
        String idClient;
        String nom, prenom, adresse,telephone = null ,nif = null;

        Show.display("\nEntrer le nom du Client : ");
        nom = read.readString();

        Show.display("Entrer le prenom du Client : ");
        prenom = read.readString();
 
        TypeClient typeClient = typeClientValue();
        Sexe sexe = sexeClientValue();

        Show.display("Entrer l'adresse du Client : ");
        adresse = read.readString();
        
       do {
    	   Show.display("Avez vous un numero telephone\n1. oui\n2. non");
    	   choix = read.readInt();
       }while(choix!=1 && choix!=2); 
       
       if(choix == 1) {
    	   Show.display("Entrer votre numero telephone");
    	   telephone = read.readString();
       }
       
       do {
    	   Show.display("Avez vous un numero nif\n1. oui\n2. non");
    	   choix = read.readInt();
       }while(choix!=1 && choix!=2);
       
       if(choix == 1) {
    	   Show.display("Entrer votre numero nif");
    	   nif = read.readString();
       }
       
       TypeCompte typeCompte = typeCompteValue();
       Devise devise = deviseCompteValue();
       Compte compte = DataCompte.dataCompte.rechercher(typeCompte, devise, Etat.N);
       
       if(compte == null) {
    	   Show.display("Il n y'a pas de compte disponible, veuillez en creer");
    	   return;
        }
       double montantBase = 0;
       if(compte.getDevise() == Devise.gourde) {
    	   montantBase = 500;
       }
       else {
    	   montantBase = 10;
       }
       
       double montant;
       
       do {
    	   Show.display("Entrer le montant superieur a :" + montantBase);
    	   montant = read.readDouble();
       }while(montant < montantBase);
       
       idClient = 	Generate.generate.generateIdClient(nom,prenom);
       
       Client client = new Client(idClient, nom, prenom, typeClient, sexe, adresse,nif,telephone);
       
       compte.setProprietaire(client);
       compte.setEtat(Etat.A);
       compte.setSolde(montant);
       
       Show.display("L'id du client :" + client.getIdClient());
       Show.display("Le numero compte du client :" + compte.getNumero());
       
       DataCompte.dataCompte.modifier(compte);
       DataClient.dataClient.enregistrer(client);
    }

    private void modifierClientMain() throws NoExistException {

    	Show.display("Entrer l'id du client a modifier");
        Client client  = DataClient.dataClient.rechercher(read.readString());
        
        if(client!=null) {
        	int choix=1;
     
	        while(choix!=0){
	        Show.menuModifierClient();
	        choix = read.readInt();
	        
	        switch(choix) {
	        	
	        case 0:{
	        	DataClient.dataClient.modifier(client);
	        }break;
	        
	        case 1 : {
	        	Show.display("Entrer le nouveau nom du Client");
		        client.setNom(read.readString());
	        }
	        
	        case 2 :{
	        	Show.display("Entrer le nouveau prenom du Client");
			    client.setPrenom(read.readString());
	        }
	        
	        case 3:{
	        	client.setType(typeClientValue());
	        }
	        
	        case 4:{
	        	client.setSexe(sexeClientValue());
	        }
	        
	        case 5:{
	        	Show.display("Entrer la nouvelle adresse du Client");
		        client.setAdresse(read.readString());
	        }
	        
	        case 6:{
	        	Show.display("Entrer le nouveau nif du Client");
		        client.setNif(read.readString());
	        }
	        
	        case 7:{
	        	Show.display("Entrer le nouveau numero telphone du Client");
		        client.setTelephone(read.readString());
	        }
	        }
	        
	        }
        }
        else {
        	Show.display("Le client que voulez modifier n'existe pas");
        }

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
        String m_idClient = read.readString();
        return m_idClient;
    }

    public void supprimerIdClient() throws NoExistException {
        Show.display("Supprimer par id client");
        String s_idCLient = read.readString();
        DataClient.dataClient.supprimer(s_idCLient);
        ArrayList<Compte> compte = DataCompte.dataCompte.rechercherParClient(s_idCLient);
        for(Compte c:compte) {
        	DataCompte.dataCompte.supprimer(c.getNumero());
        }
    }

}