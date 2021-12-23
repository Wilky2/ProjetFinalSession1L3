package core.data;

import java.util.ArrayList;

import core.model.client.Client;
import core.model.client.Sexe;
import core.model.client.TypeClient;

public class DataClient {
	
	private ArrayList<String> idClient;
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
		this.idClient = new ArrayList<String>();
		this.nom = new ArrayList<String>();
		this.prenom = new ArrayList<String>();
		this.type = new ArrayList<TypeClient>();
		this.sexe = new ArrayList<Sexe>();
		this.adresse = new ArrayList<String>();
		this.nif = new ArrayList<String>();
		this.telephone = new ArrayList<String>();
	}

	public void enregistrer(Client client) {
		this.idClient.add(client.getIdClient());
		this.nom.add(client.getNom());
		this.prenom.add(client.getPrenom());
		this.type.add(client.getType());
		this.sexe.add(client.getSexe());
		this.adresse.add(client.getAdresse());
		this.nif.add(client.getNif());
		this.telephone.add(client.getTelephone());
	}
	
	public Client rechercher(String id) {
		int indexIdClient = this.idClient.indexOf(id);
		if(indexIdClient < 0 ) {
			return null;
		}
		return new Client(this.idClient.get(indexIdClient),
				this.nom.get(indexIdClient),
				this.prenom.get(indexIdClient),
				this.type.get(indexIdClient),
				this.sexe.get(indexIdClient),
				this.adresse.get(indexIdClient),
				this.nif.get(indexIdClient),
				this.telephone.get(indexIdClient)
				);
				
	}
	
	public void modifier(Client client) throws NoExistException {
		int indexIdClient = this.idClient.indexOf(client.getIdClient());
		if(indexIdClient < 0 ) {
			throw new NoExistException();
		}
		this.idClient.set(indexIdClient, client.getIdClient());
		this.nom.set(indexIdClient,client.getNom());
		this.prenom.set(indexIdClient,client.getPrenom());
		this.type.set(indexIdClient,client.getType());
		this.sexe.set(indexIdClient,client.getSexe());
		this.adresse.set(indexIdClient,client.getAdresse());
		this.nif.set(indexIdClient,client.getNif());
		this.telephone.set(indexIdClient,client.getTelephone());
	}
	
	public void supprimer(String id) throws NoExistException {
		int indexIdClient = this.idClient.indexOf(id);
		if(indexIdClient < 0) {
			throw new NoExistException();
		}
		
		this.idClient.remove(indexIdClient);
		this.nom.remove(indexIdClient);
		this.prenom.remove(indexIdClient);
		this.type.remove(indexIdClient);
		this.sexe.remove(indexIdClient);
		this.adresse.remove(indexIdClient);
		this.nif.remove(indexIdClient);
		this.telephone.remove(indexIdClient);
		
	}
	
	public ArrayList<Client> lister(){
		ArrayList<Client> listeClient = new ArrayList<Client>();
		for(int i = 0 ; i< this.idClient.size();i++) {
			listeClient.add(this.rechercher(this.idClient.get(i)));
		}
		return listeClient;
	}
}
