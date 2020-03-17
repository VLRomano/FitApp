package logic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DatabaseConnection {
	private static final String URL = "jdbc:postgresql://localhost:5432/fitappdb";
	private static final String USR = "postgres";
	private static final String PWD= "postgres";
	private final Logger logger = Logger.getLogger(getClass().getName());



	public void fillTable() {
		try(Connection con = DriverManager.getConnection(URL,USR,PWD);
				PreparedStatement pst = con.prepareStatement(Query.getFillTable())){
			pst.executeUpdate();
		} catch (SQLException createEx) {
			logger.log(Level.SEVERE, createEx.getMessage(),createEx);
		}
	}
	
	// see table printer on google to print tables in a formatted way.
}
