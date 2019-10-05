package bd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

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
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public static void insertDonnees(Integer idIndividu, float taille, float poids, int age, int tourDeTaille,
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
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

}