package diabet;

import java.util.Date;

public class Individu {
	private int id;
	private String nom;
	private String prenom;
	private Date dateNaissance;
	private Boolean sexe;
	private int numSecu;

	// Constructeur

	public Individu(int id, String nom, String prenom, Date dateNaissance, Boolean sexe, int numSecu) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.dateNaissance = dateNaissance;
		this.sexe = sexe;
		this.numSecu = numSecu;
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

	public Date getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	public Boolean getSexe() {
		return sexe;
	}

	public void setSexe(Boolean sexe) {
		this.sexe = sexe;
	}

	public int getNumSecu() {
		return numSecu;
	}

	public void setNumSecu(int numSecu) {
		this.numSecu = numSecu;
	}
	
	//toString
	
	@Override
	public String toString() {
		return "Individu [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", dateNaissance=" + dateNaissance
				+ ", sexe=" + sexe + ", numSecu=" + numSecu + "]";
	}
}
