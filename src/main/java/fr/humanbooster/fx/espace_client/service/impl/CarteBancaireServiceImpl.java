package fr.humanbooster.fx.espace_client.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import fr.humanbooster.fx.espace_client.business.CarteBancaire;
import fr.humanbooster.fx.espace_client.business.Client;
import fr.humanbooster.fx.espace_client.service.CarteBancaireService;
import fr.humanbooster.fx.espace_client.service.ClientService;

public class CarteBancaireServiceImpl implements CarteBancaireService {

	private static List<CarteBancaire> cartesBancaires = new ArrayList<>();
	private ClientService clientService = new ClientServiceImpl();

	public CarteBancaireServiceImpl() {
		if (cartesBancaires.isEmpty()) {
			generateCarteBancaire(20);
		}
	}

	private void generateCarteBancaire(int range) {
		for (int i = 0; i < range; i++) {
			Random randInt = new Random();

			String num1 = Integer.toString(randInt.nextInt(10));
			String num2 = Integer.toString(randInt.nextInt(10));
			String num3 = Integer.toString(randInt.nextInt(10));
			String num4 = Integer.toString(randInt.nextInt(10));
			String num = num1 + num2 + num3 + num4;
			String numero = num + " " + num + " " + num + " " + num;

			int annee = randInt.nextInt(3) + 2021;

			int mois = randInt.nextInt(12) + 1;

			String crypto = num1 + num4 + num2;

			Long id = Integer.toUnsignedLong(randInt.nextInt(10) + 1);
			ajouterCarteBancaire(numero, annee, mois, crypto, id);
		}
	}

	@Override
	public CarteBancaire ajouterCarteBancaire(String numero, int anneeExpiration, int moisExpiration,
			String cryptogramme, Long idClient) {
		Client client = clientService.recupererClient(idClient);
		CarteBancaire carteBancaire = new CarteBancaire(numero, moisExpiration, anneeExpiration, cryptogramme, client);
		cartesBancaires.add(carteBancaire);
		return carteBancaire;
	}

	@Override
	public CarteBancaire recupererCarteBancaire(Long id) {
		for (CarteBancaire carteBancaire : cartesBancaires) {
			if (carteBancaire.getId() == id) {
				return carteBancaire;
			}
		}
		return null;
	}

	@Override
	public List<CarteBancaire> recupererCartesBancaires(Long idClient) {
		List<CarteBancaire> cartesBancairesClient = new ArrayList<>();
		for (CarteBancaire carteBancaire : cartesBancaires) {
			if (carteBancaire.getClient().getId() == idClient) {
				cartesBancairesClient.add(carteBancaire);
			}
		}
		return cartesBancairesClient;
	}

	@Override
	public boolean supprimerCarteBancaire(Long idCarte, Long idClient) {
		CarteBancaire carteBancaire = recupererCarteBancaire(idCarte);
		if (carteBancaire != null && carteBancaire.getClient().getId() == idClient) {
			cartesBancaires.remove(carteBancaire);
			return true;
		}
		return false;
	}

}