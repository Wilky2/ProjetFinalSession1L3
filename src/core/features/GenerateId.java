package core.features;

import java.util.Random;

public class GenerateId {

    int idClient = 1000;
    int numeroCompte;
    public String valueIdCLient() {
        return  String.valueOf(idClient++);
    }

    public String valueNumeroCompte() {
        return  String.valueOf(numeroCompte++);
    }
}
