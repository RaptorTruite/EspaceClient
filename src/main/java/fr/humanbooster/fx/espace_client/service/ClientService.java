package fr.humanbooster.fx.espace_client.service;

import java.util.List;

import fr.humanbooster.fx.espace_client.business.Client;

public interface ClientService {

	Client ajouterClient(String nom, String prenom, String email, String motDePasse);
	
	List<Client> recupererClients();
	
	Client recupererClient(Long id);

	Client recupererClient(String email, String motDePasse);
}
