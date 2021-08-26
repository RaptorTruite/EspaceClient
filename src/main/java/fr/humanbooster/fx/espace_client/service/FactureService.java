package fr.humanbooster.fx.espace_client.service;

import java.util.Date;
import java.util.List;

import fr.humanbooster.fx.espace_client.business.Facture;

public interface FactureService {

	Facture ajouterFacture(Long idClient, Date dateEcheance, float montantEnEuros);
	
	List<Facture> recupererFactures();
	
	Facture recupererFacture(Long id);
	
	List<Facture> recupererFacturesARegler(Long idClient);
	
	List<Facture> recupererFacturesReglees(Long idClient);
	
}
