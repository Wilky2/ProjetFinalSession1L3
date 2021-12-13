package core.features;

import java.util.Random;

public class GenerateId {

    int idClient = 1000;
    int numeroCompte = 100_000;

    public String valueIdCLient() {
        return  String.valueOf(idClient++);
    }

    public String valueNumeroCompte(Object value) {
        return  String.valueOf(numeroCompte++);
    }
}
