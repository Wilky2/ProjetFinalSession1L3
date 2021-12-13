package core.view;

public abstract class Show {
    public static void menuShow() {
        display(" \n-----------------------------------------------MENU---------------------------------------------\n");
        display("********************************Gestion des Clients********************************");
        display(" 1. Gestion de compte");
        display(" 2. Gestion de client");
        display(" 3. Gestion des transactions\n");
        displayF(" Choix :... ");

    }

    public static void gestionCompte() {
        display("********************************Gestion De Compte********************************");
        display(" 1. Enregistrer");
        display(" 2. Modifier");
        display(" 3. Afficher");
        display(" 4. Rechercher");
    }

    public static void gestionClient() {
        display(" 1. Enregistrer");
        display(" 2. Modifier");
        display(" 3. Afficher");
        display(" 4. Supprimer");
        display(" 5. Rechercher");
    }

    public static void display(Object o) {
        System.out.println(o);
    }

    public static void displayF(Object o) {
        System.out.print(o);
    }
}
