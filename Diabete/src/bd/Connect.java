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
    public static void connect() {
        Connection conn = null;
        try {
            // db parameters
            String url = "jdbc:sqlite:C:/sqlite/db/baseDiabete.db";
            // create a connection to the database
            conn = DriverManager.getConnection(url);
            
            /*String sql = "CREATE TABLE IF NOT EXISTS individu (\n"
                    + "    id integer PRIMARY KEY,\n"
                    + "    nom text NOT NULL,\n"
                    + "    prenom text NOT NULL,\n"
                    + "    dateNaissance text NOT NULL,\n"
                    + "    sexe int NOT NULL,\n"
                    + "    numSecu int NOT NULL \n"
                    + ");";*/
            
            System.out.println("Connection to SQLite has been established.");
            //Statement stmt = conn.createStatement();
           // stmt.execute(sql);
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