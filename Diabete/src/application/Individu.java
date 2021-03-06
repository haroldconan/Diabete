package application;

import java.util.Date;

public class Individu {
	private int id;
	private String nom;
	private String prenom;
	private String dateNaissance;
	private Boolean sexe;
	private long numSecu;

	// Constructeur

	/**
	 * @param nom
	 * @param prenom
	 * @param dateNaissance
	 * @param sexe
	 * @param numSecu
	 */
	public Individu( String nom, String prenom, String dateNaissance, Boolean sexe, long numSecu) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.dateNaissance = dateNaissance;
		this.sexe = sexe;
		this.numSecu = numSecu;
	}
	public Individu() {
		super();
	}

	// Getters and Setters

	public int getId() {
		return id;
	}

	public void setId(int id) {
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

	public String getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(String dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	public Boolean getSexe() {
		return sexe;
	}

	public void setSexe(Boolean sexe) {
		this.sexe = sexe;
	}

	public long getNumSecu() {
		return numSecu;
	}

	public void setNumSecu(long numSecu) {
		this.numSecu = numSecu;
	}
	
	//toString
	
	@Override
	public String toString() {
		return "Individu [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", dateNaissance=" + dateNaissance
				+ ", sexe=" + sexe + ", numSecu=" + numSecu + "]";
	}
}
