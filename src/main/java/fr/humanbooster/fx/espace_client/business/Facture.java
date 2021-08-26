package fr.humanbooster.fx.espace_client.business;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Facture {

	private Long id;
	private Date dateCreation;
	private Date dateEcheance;
	private Client client;
	private float montantEnEuros;
	private List<Paiement> paiements;
	
	private static Long compteur = 0L;
	
	public Facture(Client client) {
		id = ++compteur;
		this.client = client;
		client.getFactures().add(this);
		dateCreation = new Date();
		paiements = new ArrayList<>();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}

	public Date getDateEcheance() {
		return dateEcheance;
	}

	public void setDateEcheance(Date dateEcheance) {
		this.dateEcheance = dateEcheance;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}
	
	public List<Paiement> getPaiements() {
		return paiements;
	}

	public void setPaiements(List<Paiement> paiements) {
		this.paiements = paiements;
	}
	
	public float getMontantEnEuros() {
		return montantEnEuros;
	}

	public void setMontantEnEuros(float montantEnEuros) {
		this.montantEnEuros = montantEnEuros;
	}

	public float getTotalPaiementsRecus() {
		float total = 0.0f;
		for (Paiement paiement : paiements) {
			total += paiement.getMontantEnEuros();
		}
		return total;
	}
	
	@Override
	public String toString() {
		return "Facture [id=" + id + ", dateCreation=" + dateCreation + ", dateEcheance=" + dateEcheance +
				", total des paiements recus=" + getTotalPaiementsRecus() + ", client=" + client.getNom() + "]";
	}

}