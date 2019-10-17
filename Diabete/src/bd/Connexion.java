package bd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import application.Individu;

public class Connexion {
	public static void firstConnexion() {
		Connection conn = null;
		try {
			String url = "jdbc:sqlite:C:/sqlite/db/baseDiabete.db";

			conn = DriverManager.getConnection(url);

			String tableIndividu = "CREATE TABLE IF NOT EXISTS individu (\n" + "    id integer PRIMARY KEY,\n"
					+ "    nom text NOT NULL,\n" + "    prenom text NOT NULL,\n" + "    dateNaissance text NOT NULL,\n"
					+ "    sexe int NOT NULL,\n" + "    numSecu int NOT NULL \n" + ");";

			String tableDonnees = "CREATE TABLE IF NOT EXISTS donnees (\n" + "    id integer PRIMARY KEY,\n"
					+ "idIndividu int NOT NULL,\n" + "taille int NOT NULL,\n" + "poids int NOT NULL, \n"
					+ "age int NOT NULL,\n" + "tourDeTaille int NOT NULL,\n" + "actPhy int NOT NULL,\n"
					+ "atcdAntiHTA int NOT NULL,\n" + "atcdFamille int NOT NULL,\n" + "atcdGlycemie int NOT NULL,\n"
					+ "legumeVert int NOT NULL, \n" + "resultat int NOT NULL,\n" + "date text NOT NULL,\n"
					+ "FOREIGN KEY(idIndividu) REFERENCES individu(id) );";

			System.out.println("Connection to SQLite has been established.");
			Statement stmt = conn.createStatement();
			stmt.execute(tableIndividu);
			stmt.execute(tableDonnees);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException ex) {
				System.out.println(ex.getMessage());
			}
		}
	}

	public static Connection connect() {
		String url = "jdbc:sqlite:C:/sqlite/db/baseDiabete.db";
		Connection conn = null;

		try {
			conn = DriverManager.getConnection(url);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return conn;
	}

	public static void insertIndividu(String name, String prenom, String dateNaissance, boolean sexe, String numSecu) {
		String sql = "INSERT INTO Individu (nom, prenom, dateNaissance, sexe, numSecu) VALUES (?,?,?,?,?)";

		try (Connection conn = connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, name);
			pstmt.setString(2, prenom);
			pstmt.setString(3, dateNaissance);
			pstmt.setBoolean(4, sexe);
			pstmt.setString(5, numSecu);
			pstmt.executeUpdate();

			conn.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public static void insertDonnees(int idIndividu, float taille, float poids, int age, int tourDeTaille,
			boolean actPhy, boolean atcdHta, boolean atcdFamille, boolean atcdGlyce, int legume, int resultat,
			String date) {
		String sql = "INSERT INTO donnees (idIndividu, taille, poids, age, tourDeTaille, actPhy, atcdAntiHTA, atcdFamille, atcdGlycemie, legumeVert, resultat ,date) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";

		try (Connection conn = connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setInt(1, idIndividu);
			pstmt.setFloat(2, taille);
			pstmt.setFloat(3, poids);
			pstmt.setInt(4, age);
			pstmt.setInt(5, tourDeTaille);
			pstmt.setBoolean(6, actPhy);
			pstmt.setBoolean(7, atcdHta);
			pstmt.setBoolean(8, atcdFamille);
			pstmt.setBoolean(9, atcdGlyce);
			pstmt.setInt(10, legume);
			pstmt.setInt(11, resultat);
			pstmt.setString(12, date);
			pstmt.executeUpdate();

			conn.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public static int getIdIndividu(String nom, String prenom) {
		String sql = "SELECT id FROM individu WHERE nom = '"+ nom +"' and prenom = '"+ prenom +"'";
		int id = 0;
		try (Connection conn = connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			System.out.println(sql);
			Statement stmt = conn.createStatement();
			ResultSet res = stmt.executeQuery(sql);
			while (res.next()) {
				id = res.getInt("id");
			}
			conn.close();
			return id;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return id;

	}
	public static int getStat1Accueil() {
		String sql = "SELECT resultat FROM donnees where resultat<1 or resultat=1";
		int id = 0 ;
		try (Connection conn = connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			System.out.println(sql);
			Statement stmt = conn.createStatement();
			ResultSet res = stmt.executeQuery(sql);
			while (res.next()) {
				id++;
			}
			conn.close();
			return id;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return id;

	}
	public static int getStat4Accueil() {
		String sql = "SELECT resultat FROM donnees where resultat<4 and resultat>1 or resultat=4 ";
		int id = 0 ;
		try (Connection conn = connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			System.out.println(sql);
			Statement stmt = conn.createStatement();
			ResultSet res = stmt.executeQuery(sql);
			while (res.next()) {
				id++;
			}
			conn.close();
			return id;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return id;

	}
	public static int getStat17Accueil() {
		String sql = "SELECT resultat FROM donnees where resultat<17 and resultat>4 or resultat=17 ";
		int id = 0 ;
		try (Connection conn = connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			System.out.println(sql);
			Statement stmt = conn.createStatement();
			ResultSet res = stmt.executeQuery(sql);
			while (res.next()) {
				id++;
			}
			conn.close();
			return id;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return id;

	}
	public static int getStat33Accueil() {
		String sql = "SELECT resultat FROM donnees where resultat<33 and resultat>17 or resultat=33";
		int id = 0 ;
		try (Connection conn = connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			System.out.println(sql);
			Statement stmt = conn.createStatement();
			ResultSet res = stmt.executeQuery(sql);
			while (res.next()) {
				id ++;
			}
			conn.close();
			return id;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return id;

	}
	public static int getStat50Accueil() {
		String sql = "SELECT resultat FROM donnees,individu where resultat<50 and resultat>33 or resultat=50";
		int id = 0 ;
		try (Connection conn = connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			System.out.println(sql);
			Statement stmt = conn.createStatement();
			ResultSet res = stmt.executeQuery(sql);
			while (res.next()) {
				id ++;
			}
			conn.close();
			return id;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return id;

	}public static int getStat1AccueilF() {
		String sql = "SELECT resultat FROM donnees,individu where (resultat<1  or resultat=1) and sexe=false and individu.id=donnees.idIndividu";
		int id = 0 ;
		try (Connection conn = connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			System.out.println(sql);
			Statement stmt = conn.createStatement();
			ResultSet res = stmt.executeQuery(sql);
			while (res.next()) {
				id++;
			}
			conn.close();
			return id;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return id;

	}
	public static int getStat4AccueilF() {
		String sql = "SELECT resultat FROM donnees,individu where (resultat<4 and resultat>1  or resultat=4) and sexe=false and individu.id=donnees.idIndividu";
		int id = 0 ;
		try (Connection conn = connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			System.out.println(sql);
			Statement stmt = conn.createStatement();
			ResultSet res = stmt.executeQuery(sql);
			while (res.next()) {
				id++;
			}
			conn.close();
			return id;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return id;

	}
	public static int getStat17AccueilF() {
		String sql = "SELECT resultat FROM donnees,individu where (resultat<17 and resultat>4  or resultat=17) and sexe=false and individu.id=donnees.idIndividu";
		int id = 0 ;
		try (Connection conn = connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			System.out.println(sql);
			Statement stmt = conn.createStatement();
			ResultSet res = stmt.executeQuery(sql);
			while (res.next()) {
				id++;
			}
			conn.close();
			return id;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return id;

	}
	public static int getStat33AccueilF() {
		String sql = "SELECT resultat FROM donnees,individu where (resultat<33 and resultat>17  or resultat=33) and sexe=false and individu.id=donnees.idIndividu";
		int id = 0 ;
		try (Connection conn = connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			System.out.println(sql);
			Statement stmt = conn.createStatement();
			ResultSet res = stmt.executeQuery(sql);
			while (res.next()) {
				id ++;
			}
			conn.close();
			return id;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return id;

	}
	public static int getStat50AccueilF() {
		String sql = "SELECT resultat FROM donnees,individu where (resultat<50 and resultat>33  or resultat=50) and sexe=false and individu.id=donnees.idIndividu";
		int id = 0 ;
		try (Connection conn = connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			System.out.println(sql);
			Statement stmt = conn.createStatement();
			ResultSet res = stmt.executeQuery(sql);
			while (res.next()) {
				id ++;
			}
			conn.close();
			return id;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return id;

	}
	public static int getStat1AccueilH() {
		String sql = "SELECT resultat FROM donnees,individu where (resultat<1  or resultat=1) and sexe=true and individu.id=donnees.idIndividu";
		int id = 0 ;
		try (Connection conn = connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			System.out.println(sql);
			Statement stmt = conn.createStatement();
			ResultSet res = stmt.executeQuery(sql);
			while (res.next()) {
				id++;
			}
			conn.close();
			return id;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return id;

	}
	public static int getStat4AccueilH() {
		String sql = "SELECT resultat FROM donnees,individu where (resultat<4 and resultat>1 or resultat=4) and sexe=true and individu.id=donnees.idIndividu";
		int id = 0 ;
		try (Connection conn = connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			System.out.println(sql);
			Statement stmt = conn.createStatement();
			ResultSet res = stmt.executeQuery(sql);
			while (res.next()) {
				id++;
			}
			conn.close();
			return id;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return id;

	}
	public static int getStat17AccueilH() {
		String sql = "SELECT resultat FROM donnees,individu where (resultat<17 and resultat>4 or resultat=17) and sexe=true and individu.id=donnees.idIndividu";
		int id = 0 ;
		try (Connection conn = connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			System.out.println(sql);
			Statement stmt = conn.createStatement();
			ResultSet res = stmt.executeQuery(sql);
			while (res.next()) {
				id++;
			}
			conn.close();
			return id;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return id;

	}
	public static int getStat33AccueilH() {
		String sql = "SELECT resultat FROM donnees,individu where (resultat<33 and resultat>17 or resultat=33) and sexe=true and individu.id=donnees.idIndividu";
		int id = 0 ;
		try (Connection conn = connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			System.out.println(sql);
			Statement stmt = conn.createStatement();
			ResultSet res = stmt.executeQuery(sql);
			while (res.next()) {
				id ++;
			}
			conn.close();
			return id;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return id;

	}
	public static int getStat50AccueilH() {
		String sql = "SELECT resultat FROM donnees,individu where (resultat<50 and resultat>33 or resultat=50) and sexe=true and individu.id=donnees.idIndividu";
		int id = 0 ;
		try (Connection conn = connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			System.out.println(sql);
			Statement stmt = conn.createStatement();
			ResultSet res = stmt.executeQuery(sql);
			while (res.next()) {
				id ++;
			}
			conn.close();
			return id;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return id;

	}
	public static List<Individu> getListIndividues() throws ParseException {
		String sql = "SELECT * FROM individu";
		ArrayList<Individu> indi = new ArrayList<Individu>();
		try (Connection conn = connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			System.out.println(sql);
			Statement stmt = conn.createStatement();
			ResultSet res = stmt.executeQuery(sql);
			while (res.next()) {
				try {
					System.out.println(res.getString("dateNaissance"));
					indi.add(new Individu(res.getString("nom"),res.getString("prenom"),res.getString("dateNaissance"), Boolean.parseBoolean(res.getString("sexe")), Long.parseLong(res.getString("numsecu"))));
				} catch (NumberFormatException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			conn.close();
			return indi;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return indi;

	}

	

}