package fr.humanbooster.fx.espace_client.business;

import java.util.Date;

public class Paiement {

	private Long id;
	private Facture facture;
	private CarteBancaire carteBancaire;
	private Date dateCreation;
	private Date dateEffective;	
	private float montantEnEuros;
	
	private static Long compteur = 0L;

	public Paiement(Facture facture, CarteBancaire carteBancaire, float montantEnEuros, Date dateEffective) {
		id = ++compteur;
		setFacture(facture);
		setCarteBancaire(carteBancaire);
		setDateCreation(new Date());
		setMontantEnEuros(montantEnEuros);
		setDateEffective(dateEffective);
		facture.getPaiements().add(this);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Facture getFacture() {
		return facture;
	}

	public void setFacture(Facture facture) {
		this.facture = facture;
	}

	public CarteBancaire getCarteBancaire() {
		return carteBancaire;
	}

	public void setCarteBancaire(CarteBancaire carteBancaire) {
		this.carteBancaire = carteBancaire;
	}

	public Date getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}

	public Date getDateEffective() {
		return dateEffective;
	}

	public void setDateEffective(Date dateEffective) {
		this.dateEffective = dateEffective;
	}

	public float getMontantEnEuros() {
		return montantEnEuros;
	}

	public void setMontantEnEuros(float montantEnEuros) {
		this.montantEnEuros = montantEnEuros;
	}

	@Override
	public String toString() {
		return "Paiement [id=" + id + ", facture=" + facture + ", carteBancaire=" + carteBancaire + ", dateCreation="
				+ dateCreation + ", dateEffective=" + dateEffective + ", montantEnEuros=" + montantEnEuros + "]";
	}

}