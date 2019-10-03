package bd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author sqlitetutorial.net
 */
public class Connect {
	/**
	 * Connect to a sample database
	 */
	public static void firstConnexion() {
		Connection conn = null;
		try {
			// db parameters
			String url = "jdbc:sqlite:C:/sqlite/db/baseDiabete.db";
			// create a connection to the database
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
			// stmt.execute(query);
			System.out.println("BD");
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

}