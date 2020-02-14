package logic;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import logic.entity.Gym;

public class DAO {

	private static DAO instance = null;

	private DAO() {}

	public static synchronized DAO getInstance(){
		if(DAO.instance == null){
			DAO.instance = new DAO();
		}
		return DAO.instance;
	}

	private Connection connection = null;
	private static final String URL = "jdbc:postgresql://localhost:5432/fitappdb";
	private static final String USR = "postgres";
	private static final String PWD= "password";
	private final Logger logger = Logger.getLogger(getClass().getName());
	public Connection getConnection(){
		return this.connection;
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
	public boolean checkLogIn(String username, String password) {
		try(Connection con = DriverManager.getConnection(URL,USR,PWD);
			PreparedStatement pst = con.prepareStatement(Query.getLogin())){
			pst.setString(1, username);
			pst.setString(2, password);
			try(ResultSet rs = pst.executeQuery()){
				System.out.println(rs);
				rs.next();
				if(rs.getInt(1)>0) {
					logger.log(Level.INFO,"user found");
					return true;
				} else {
					logger.log(Level.SEVERE, "Wrong Username or Password");
				}
			}
		} catch (SQLException connException) {
			logger.log(Level.SEVERE, connException.getMessage(),connException);
		}		
		return false;
	}
	
	public List<String> getTtrainingList() {
		
		ArrayList<String> trainingList = new ArrayList<>();
		String query = "select * from trainingtypes;";
		try (Connection con = DriverManager.getConnection(URL,USR,PWD);
				PreparedStatement pst = con.prepareStatement(query);
				ResultSet rs = pst.executeQuery()){
			while(rs.next()) {
				trainingList.add(rs.getString(1));
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return trainingList;
	}
	
	public Gym getGymEntity(String username) {
		
		List<String> courses = new ArrayList<String>();
		courses.add("One");
		courses.add("Two");
		courses.add("Three");
		courses.add("Four");
		
		List<String> trainers = new ArrayList<String>();
		trainers.add("TOne");
		trainers.add("TTwo");
		trainers.add("TThree");
		trainers.add("TFour");
		
		int id = 1;
		String name = "palestra";
		String position = "via generica";
		
		Gym gym = new Gym();
		
		gym.setCourses(courses);
		gym.setId(id);
		gym.setName(name);
		gym.setPosition(position);
		gym.setTrainers(trainers);
		
//		String query = "select * from gym where username = ?";
//		try(Connection con = DriverManager.getConnection(URL,USR,PWD);
//			PreparedStatement pst = con.prepareStatement(query)){
//			pst.setString(1, username);
//			try(ResultSet rs = pst.executeQuery()){
//				if(rs.next()) {
//					logger.log(Level.INFO,"gym found");
//					gym.setName(rs.getString("gymname"));
//					//TODO finish initializing the gym entity
//				}
//			}		
//		} catch (SQLException e1) {
//			logger.log(Level.SEVERE, e1.getMessage(),e1);
//		}
		
		
//		gym.setId(id);
//		gym.setName(name);
		
		return gym;
	}
	
	public static void main(String[] args) {
		DatabaseConnection con = new DatabaseConnection();		
		con.createDatabase(con.getConnection());
	}
}