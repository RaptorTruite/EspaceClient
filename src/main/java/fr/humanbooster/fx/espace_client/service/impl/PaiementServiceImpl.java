package fr.humanbooster.fx.espace_client.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import fr.humanbooster.fx.espace_client.business.CarteBancaire;
import fr.humanbooster.fx.espace_client.business.Facture;
import fr.humanbooster.fx.espace_client.business.Paiement;
import fr.humanbooster.fx.espace_client.service.CarteBancaireService;
import fr.humanbooster.fx.espace_client.service.FactureService;
import fr.humanbooster.fx.espace_client.service.PaiementService;

public class PaiementServiceImpl implements PaiementService {

	private static List<Paiement> paiements = new ArrayList<>();
	private CarteBancaireService carteBancaireService = new CarteBancaireServiceImpl();
	private FactureService factureService = new FactureServiceImpl();
	
	@Override
	public Paiement ajouterPaiement(Long idFacture, Long idCarteBancaire, float montantEnEuros, Date dateEffective) {
		CarteBancaire carteBancaire = carteBancaireService.recupererCarteBancaire(idCarteBancaire);
		Facture facture = factureService.recupererFacture(idFacture);
		Paiement paiement = new Paiement(facture, carteBancaire, montantEnEuros, dateEffective);
		paiements.add(paiement);
		return paiement;
	}

	@Override
	public List<Paiement> recupererPaiements(Long idFacture) {
		List<Paiement> paiementsAssocies = new ArrayList<>();
		for (Paiement paiement : paiements) {
			if (paiement.getFacture().getId()==idFacture) {
				paiementsAssocies.add(paiement);
			}
		}
		return paiementsAssocies;
	}
	
}