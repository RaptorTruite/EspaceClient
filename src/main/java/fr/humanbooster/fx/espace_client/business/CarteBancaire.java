package fr.humanbooster.fx.espace_client.business;

public class CarteBancaire {

	private Long id;
	private String numero;
	private int moisExpiration;
	private int anneeExpiration;
	private String cryptogramme;
	private Client client;
	
	private static Long compteur = 0L;

	public CarteBancaire(String numero, int moisExpiration, int anneeExpiration, String cryptogramme, Client client) {
		super();
		this.id = ++compteur;
		this.numero = numero;
		this.moisExpiration = moisExpiration;
		this.anneeExpiration = anneeExpiration;
		this.cryptogramme = cryptogramme;
		this.client = client;
		this.client.getCartesBancaires().add(this);
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public int getMoisExpiration() {
		return moisExpiration;
	}
	public void setMoisExpiration(int moisExpiration) {
		this.moisExpiration = moisExpiration;
	}
	public int getAnneeExpiration() {
		return anneeExpiration;
	}
	public void setAnneeExpiration(int anneeExpiration) {
		this.anneeExpiration = anneeExpiration;
	}
	public String getCryptogramme() {
		return cryptogramme;
	}
	public void setCryptogramme(String cryptogramme) {
		this.cryptogramme = cryptogramme;
	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}

	@Override
	public String toString() {
		return "CarteBancaire [id=" + id + ", numero=" + numero + ", moisExpiration=" + moisExpiration
				+ ", anneeExpiration=" + anneeExpiration + ", cryptogramme=" + cryptogramme + ", client=" + client.getNom()
				+ "]";
	}	
	
}