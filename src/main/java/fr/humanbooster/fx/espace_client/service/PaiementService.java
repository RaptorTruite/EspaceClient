package fr.humanbooster.fx.espace_client.service;

import java.util.Date;
import java.util.List;

import fr.humanbooster.fx.espace_client.business.Paiement;

public interface PaiementService {

	Paiement ajouterPaiement(Long idFacture, Long idCarte, float montantEnEuros, Date dateEffective);

	List<Paiement> recupererPaiements(Long idFacture);
}
