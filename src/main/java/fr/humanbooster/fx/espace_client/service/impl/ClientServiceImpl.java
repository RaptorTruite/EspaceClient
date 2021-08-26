package fr.humanbooster.fx.espace_client.service.impl;

import java.util.ArrayList;
import java.util.List;

import fr.humanbooster.fx.espace_client.business.Client;
import fr.humanbooster.fx.espace_client.service.ClientService;

public class ClientServiceImpl implements ClientService {

	private static List<Client> clients = new ArrayList<>();

	public ClientServiceImpl() {
		if (clients.isEmpty()) {
			generateClient(10);
		}
	}
	
	private void generateClient(int range) {
		for (int i = 1; i <= range; i++) {
			String nom = "client" + i;
			String email = nom + "@hb.fr";
			String motDePasse = nom;
			ajouterClient(nom, nom, email, motDePasse);
		}
	}

	@Override
	public Client ajouterClient(String nom, String prenom, String email, String motDePasse) {
		Client client = new Client(nom, prenom, email, motDePasse);
		clients.add(client);
		return client;
	}

	@Override
	public List<Client> recupererClients() {
		return clients;
	}

	@Override
	public Client recupererClient(Long id) {
		for (Client client : clients) {
			if (client.getId() == id)
				return client;
		}
		return null;
	}

	@Override
	public Client recupererClient(String email, String motDePasse) {
		for (Client client : clients) {
			if (client.getEmail().equals(email) && client.getMotDePasse().equals(motDePasse)) {
				return client;
			}
		}
		return null;
	}

}