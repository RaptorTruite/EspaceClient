package fr.humanbooster.fx.espace_client.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import fr.humanbooster.fx.espace_client.business.Client;
import fr.humanbooster.fx.espace_client.business.Facture;
import fr.humanbooster.fx.espace_client.service.ClientService;
import fr.humanbooster.fx.espace_client.service.FactureService;

public class FactureServiceImpl implements FactureService {

	private static List<Facture> factures = new ArrayList<>();
	private ClientService clientService = new ClientServiceImpl();
	
	public FactureServiceImpl() {
		if (factures.isEmpty()) {
			generateFacture(100);
		}
	}
	
	private void generateFacture(int range) {
		for (int i = 0; i < range; i++) {
			Random rand = new Random();
			
			Long id = Integer.toUnsignedLong(rand.nextInt(10) + 1);
			
			Date date = new Date();
			
			float montant = rand.nextInt(100);
			
			ajouterFacture(id, date, montant);
		}
	}
	
	@Override
	public Facture ajouterFacture(Long idClient, Date dateEcheance, float montantEnEuros) {
		Client client = clientService.recupererClient(idClient);
		Facture facture = new Facture(client);
		facture.setDateEcheance(dateEcheance);
		facture.setMontantEnEuros(montantEnEuros);
		factures.add(facture);
		return facture;
	}

	@Override
	public List<Facture> recupererFactures() {
		return factures;
	}

	@Override
	public Facture recupererFacture(Long id) {
		for (Facture facture : factures) {
			if (facture.getId() == id)
				return facture;
		}
		return null;
	}

	@Override
	public List<Facture> recupererFacturesARegler(Long idClient) {
		List<Facture> facturesARegler = new ArrayList<>();
		for (Facture facture : factures) {
			if (facture.getClient().getId()==idClient) {
				if (facture.getTotalPaiementsRecus()<facture.getMontantEnEuros()) {
					facturesARegler.add(facture);
				}
			}
		}
		return facturesARegler;
	}

	@Override
	public List<Facture> recupererFacturesReglees(Long idClient) {
		List<Facture> facturesReglees = new ArrayList<>();
		for (Facture facture : factures) {
			if (facture.getClient().getId()==idClient) {
				if (facture.getTotalPaiementsRecus()==facture.getMontantEnEuros()) {
					facturesReglees.add(facture);
				}
			}
		}
		return facturesReglees;
	}

}