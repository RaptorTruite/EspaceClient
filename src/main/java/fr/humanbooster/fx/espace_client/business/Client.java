package fr.humanbooster.fx.espace_client.business;

import java.util.ArrayList;
import java.util.List;

public class Client {

	private Long id;
	private String nom;
	private String prenom;
	private String email;
	private String motDePasse;
	private List<CarteBancaire> cartesBancaires;
	private List<Facture> factures;
	
	private static Long compteur = 0L;

	public Client(String nom, String prenom, String email, String motDePasse) {
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.motDePasse = motDePasse;
		id = ++compteur;
		setFactures(new ArrayList<>());
		setCartesBancaires(new ArrayList<>());
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMotDePasse() {
		return motDePasse;
	}

	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}

	public List<Facture> getFactures() {
		return factures;
	}

	public void setFactures(List<Facture> factures) {
		this.factures = factures;
	}

	public List<CarteBancaire> getCartesBancaires() {
		return cartesBancaires;
	}

	public void setCartesBancaires(List<CarteBancaire> cartesBancaires) {
		this.cartesBancaires = cartesBancaires;
	}

	@Override
	public String toString() {
		return "Client [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", email=" + email + ", motDePasse="
				+ motDePasse + "]";
	}

}