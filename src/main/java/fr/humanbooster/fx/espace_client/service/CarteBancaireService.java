package fr.humanbooster.fx.espace_client.service;

import java.util.List;

import fr.humanbooster.fx.espace_client.business.CarteBancaire;

public interface CarteBancaireService {

	CarteBancaire ajouterCarteBancaire(String numero, int anneeExpiration, int moisExpiration, String cryptogramme, Long idClient);
	
	CarteBancaire recupererCarteBancaire(Long id);
	
	List<CarteBancaire> recupererCartesBancaires(Long idClient);
	
	boolean supprimerCarteBancaire(Long idCarte, Long idClient);

}
