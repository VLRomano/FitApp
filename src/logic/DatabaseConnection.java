package logic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DatabaseConnection {
	private Connection connection = null;
	private static final String URL = "jdbc:postgresql://localhost:5432/fitappdb";
	private static final String USR = "postgres";
	private static final String PWD= "postgres";
	private final Logger logger = Logger.getLogger(getClass().getName());
	
	public Connection getConnection(){
		return this.connection;
	}
	
	public DatabaseConnection() {
	    try {
	      // open connection
	      Connection con = DriverManager.getConnection(URL,USR,PWD);
	      // verify connection
	      Statement st = con.createStatement();
	      ResultSet rs = st.executeQuery("select version()");
	      if(rs.next())
	        logger.log(Level.SEVERE, null, rs.getString(1));
	      this.connection = con;
	    } catch (SQLException e) {
	      logger.log(Level.SEVERE, "Failed to Connect\n"+e);
	    }
	  }

	public void createDatabase(Connection con) {
		if(con!=null) {
			try(PreparedStatement pst = con.prepareStatement(Query.getCreateTable())){
				pst.executeUpdate();
				con.close();
			} catch (SQLException e) {
				logger.log(Level.SEVERE, e.getMessage(), e);
			}
		} else {
			DatabaseConnection newDbCon = new DatabaseConnection();
			newDbCon.createDatabase(newDbCon.getConnection());
		}
	}
	public boolean checkLogIn(Connection con, String username, String password) {
		if(con!=null) {
			try (PreparedStatement pst = con.prepareStatement(Query.getSelectItem());
					ResultSet rs = pst.executeQuery()){
				rs.next();
				if(rs.getInt(1)>0) {
					logger.log(Level.INFO,"user found");
					return true;
				} else {
					logger.log(Level.SEVERE, "Wrong Username or Password");
				}
				con.close();
			} catch (SQLException e) {
				logger.log(Level.SEVERE, e.getMessage(),e);
			}
		}
		
		return false;
	}
	public static void main(String[] args) {
		DatabaseConnection con = new DatabaseConnection();		
		con.createDatabase(con.getConnection());
	}
}
