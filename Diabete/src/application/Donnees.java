package diabet;

import java.util.Calendar;
import java.util.Date;

public class Donnees {
	private int id;
	private int idIndividu;
	private double taille;
	private double poids;
	private int age;
	private double tourDeTaille;
	private boolean actPhysique;
	private boolean atcdAntiHTA;
	private boolean atcdFamille;
	private boolean atcdGlycemie;
	private int legumeVert;
	private int resultat;
	private Date date;

	// Constructeur

	public Donnees(int id, int idIndividu, double taille, double poids, int age, double tourDeTaille,
			boolean actPhysique, boolean atcdAntiHTA, boolean atcdFamille, boolean atcdGlycemie, int legumeVert) {
		super();
		this.id = id;
		this.idIndividu = idIndividu;
		this.taille = taille;
		this.poids = poids;
		this.age = age;
		this.tourDeTaille = tourDeTaille;
		this.actPhysique = actPhysique;
		this.atcdAntiHTA = atcdAntiHTA;
		this.atcdFamille = atcdFamille;
		this.atcdGlycemie = atcdGlycemie;
		this.legumeVert = legumeVert;
		Date courant = new Date();
		this.date = courant;
	}

	// Getters and Setters

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdIndividu() {
		return idIndividu;
	}

	public void setIdIndividu(int idIndividu) {
		this.idIndividu = idIndividu;
	}

	public double getTaille() {
		return taille;
	}

	public void setTaille(float taille) {
		this.taille = taille;
	}

	public double getPoids() {
		return poids;
	}

	public void setPoids(float poids) {
		this.poids = poids;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public double getTourDeTaille() {
		return tourDeTaille;
	}

	public void setTourDeTaille(float tourDeTaille) {
		this.tourDeTaille = tourDeTaille;
	}

	public boolean isActPhysique() {
		return actPhysique;
	}

	public void setActPhysique(boolean actPhysique) {
		this.actPhysique = actPhysique;
	}

	public boolean isAtcdAntiHTA() {
		return atcdAntiHTA;
	}

	public void setAtcdAntiHTA(boolean atcdAntiHTA) {
		this.atcdAntiHTA = atcdAntiHTA;
	}

	public boolean isAtcdFamille() {
		return atcdFamille;
	}

	public void setAtcdFamille(boolean atcdFamille) {
		this.atcdFamille = atcdFamille;
	}

	public boolean isAtcdGlycemie() {
		return atcdGlycemie;
	}

	public void setAtcdGlycemie(boolean atcdGlycemie) {
		this.atcdGlycemie = atcdGlycemie;
	}

	public int getLegumeVert() {
		return legumeVert;
	}

	public void setLegumeVert(int legumeVert) {
		this.legumeVert = legumeVert;
	}

	public int getResultat() {
		return resultat;
	}

	public void setResultat(int resultat) {
		this.resultat = resultat;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	// Méthodes & Fonctions

	// Fonction qui calcul l'age d'un individu
	// Entrée : Date
	// Sortie : Entier
	public int calculAge(Date dateNaissance) throws Exception {
		// Récupération des dates.
		Calendar courant = Calendar.getInstance();
		Calendar naissance = Calendar.getInstance();

		// Mise à jour de la date de naissance en fonction du paramètre d'entrée
		naissance.setTime(dateNaissance);

		// Verification que la date de naissance n'est pas supérieur à la date
		// d'aujourd'hui.
		if (naissance.get(Calendar.YEAR) > courant.get(Calendar.YEAR)) {
			throw new Exception("Erreur age.");
		}

		// Calcul de l'age
		int resultat = courant.get(Calendar.YEAR) - naissance.get(Calendar.YEAR);

		return resultat;
	}

	// Fonction qui calcul le score du diabète dans les 10 ans
	// Entrée : Double*3, Entier*2, boolean*5
	// Sortie : Entier
	public int calculResultat(double taille, double poids, int age, double tourDeTaille, boolean sexe, boolean actPhy,
			int legumeVert, boolean atcdAntiHTA, boolean atcdFamille, boolean atcdGlycemie) throws Exception {
		int resultat = 0;

		// Vérification que la taille, le poids et le tour de taille n'ont pas des
		// valeurs négatives ou nulles.
		if (taille <= 0.0 || poids <= 0.0 || tourDeTaille <= 0.0) {
			throw new Exception("Erreur sur une des valeurs suivantes : taille, poids ou tour de taille.");
		}

		// Calcul du score concernant l'age.
		resultat = resultatAge(age, resultat);
		// Calcul du score concernant l'IMC.
		resultat = resultatIMC(taille, poids, resultat);
		// Calcul du score concernant le tour de taille.
		resultat = resultatTourDeTaille(tourDeTaille, sexe, resultat);
		// Calcul du score concernant l'activité physique.
		resultat = resultatActPhy(actPhy, resultat);
		// Calcul du score concernant les légumes verts.
		resultat = resultatLegumeVert(legumeVert, resultat);
		// Calcul du score concernant les antécédent
		resultat = resultatATCD(atcdAntiHTA, atcdFamille, atcdGlycemie, resultat);

		return resultat;
	}

	// Fonction qui retourne le score pour les antédédents
	// Entrée : boolean*2, entier
	// Sortie : entier
	private int resultatATCD(boolean atcdAntiHTA, boolean atcdFamille, boolean atcdGlycemie, int resultat) {
		if (atcdAntiHTA) {
			resultat = resultat + 2;
		}
		if (atcdFamille) {
			resultat = resultat + 3;
		}
		if (atcdGlycemie) {
			resultat = resultat + 5;
		}
		return resultat;
	}

	// Fonction qui retourne le score pour les légumes verts
	// Entrée : entier*2
	// Sortie : entier
	private int resultatLegumeVert(int legumeVert, int resultat) {
		if (legumeVert == 1) {
			resultat = resultat + 1;
		}
		if (legumeVert == 2) {
			resultat = resultat + 2;
		}
		return resultat;
	}

	// Fonction qui retourne le score pour les activités physiques
	// Entrée : boolean, entier
	// Sortie : entier
	private int resultatActPhy(boolean actPhy, int resultat) {
		if (!actPhy) {
			resultat = resultat + 2;
		}
		return resultat;
	}

	// Fonction qui retourne le score pour le tour de taille
	// Entrée : boolean, entier, double
	// Sortie : entier
	private int resultatTourDeTaille(double tourDeTaille, boolean sexe, int resultat) {
		// Pour sexe : true = homme //\\ false = femme
		if (sexe) {
			if (tourDeTaille >= 94 && tourDeTaille <= 102) {
				resultat = resultat + 3;
			}
			if (tourDeTaille > 102) {
				resultat = resultat + 4;
			}
		} else {
			if (tourDeTaille >= 80 && tourDeTaille <= 88) {
				resultat = resultat + 3;
			}
			if (tourDeTaille > 88) {
				resultat = resultat + 4;
			}
		}
		return resultat;
	}

	// Fonction qui retourne le score pour l'IMC
	// Entrée : double*2, entier
	// Sortie : entier
	private int resultatIMC(double taille, double poids, int resultat) {
		double IMC = poids / Math.pow(taille, 2);

		if (IMC >= 25.0 && IMC <= 30) {
			resultat = resultat + 1;
		}
		if (IMC >= 30.0) {
			resultat = resultat + 3;
		}
		return resultat;
	}

	// Fonction qui retourne le score pour l'age
	// Entrée : entier*2
	// Sortie : entier
	private int resultatAge(int age, int resultat) {
		if (age >= 45 && age <= 54) {
			resultat = resultat + 2;
		}
		if (age >= 55 && age <= 64) {
			resultat = resultat + 3;
		}
		if (age >= 64) {
			resultat = resultat + 4;
		}
		return resultat;
	}

	// toString
	
	public String toString(int resulat) {
		String sortie = "Risque faible (~1%) => 1 personne sur 100 développera un diabète.";
		if (resulat > 7 && resulat <= 11) {
			sortie = "Risque légèrement élevé (~4%) => 1 personne sur 25 développera un diabète.";
		}
		if (resulat >= 12 && resulat <= 14) {
			sortie = "Risque modéré (~17%) => 1 personne sur 6 développera un diabète.";
		}
		if (resulat >= 15 && resulat <= 20) {
			sortie = "Risque élevé (~33%) => 1 personne sur 3 développera un diabète.";
		}
		if (resulat >= 20) {
			sortie = "Risque très élevé (~50%) => 1 personne sur 2 développera un diabète.";
		}
		return sortie;
	}

}
