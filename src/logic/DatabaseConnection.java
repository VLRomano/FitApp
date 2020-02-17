package logic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

//import lib.DBTablePrinter;

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
	
//	public void printAllTables() {
//		try( Connection con = DriverManager.getConnection(URL,USR,PWD)){
//			DBTablePrinter.printTable(con, "trainer");
//			DBTablePrinter.printTable(con, "course");
//			DBTablePrinter.printTable(con, "users");
//			DBTablePrinter.printTable(con, "gym");
//		} catch (SQLException printEx) {
//			logger.log(Level.SEVERE, printEx.getMessage(), printEx);
//		}
//	}
//	public static void main(String[] args) {
//		DatabaseConnection con = new DatabaseConnection();		
//		con.createDatabase();
//		con.printAllTables();
//	}
}
