package core.data;

import java.util.ArrayList;

import core.model.client.Client;
import core.model.client.Sexe;
import core.model.client.TypeClient;

public class DataClient {
	
	private ArrayList<Integer> idClient;
	private ArrayList<String> nom;
	private ArrayList<String> prenom;
	private ArrayList<TypeClient> type;
	private ArrayList<Sexe> sexe;
	private ArrayList<String> adresse;
	private ArrayList<String> nif;
	private ArrayList<String> telephone;
	
	public static DataClient dataClient = new DataClient();
	
	private DataClient() {
		super();
		this.idClient = new ArrayList<Integer>();
		this.nom = new ArrayList<String>();
		this.prenom = new ArrayList<String>();
		this.type = new ArrayList<TypeClient>();
		this.sexe = new ArrayList<Sexe>();
		this.adresse = new ArrayList<String>();
		this.nif = new ArrayList<String>();
		this.telephone = new ArrayList<String>();
	}

	public void enregistrer(Client client) {
		idClient.add(client.getIdClient());
		nom.add(client.getNom());
		prenom.add(client.getPrenom());
		type.add(client.getType());
		sexe.add(client.getSexe());
		adresse.add(client.getAdresse());
		nif.add(client.getNif());
		telephone.add(client.getTelephone());
	}
	
	public Client rechercher(int idclient) {
		int indexIdClient = idClient.indexOf(idClient);
		if(indexIdClient < 0 ) {
			return null;
		}
		return new Client(idClient.get(indexIdClient),
				nom.get(indexIdClient),
				prenom.get(indexIdClient),
				type.get(indexIdClient),
				sexe.get(indexIdClient),
				adresse.get(indexIdClient),
				nif.get(indexIdClient),
				telephone.get(indexIdClient)
				);
				
	}
	
}
