package logic;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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

	private static final String URL = "jdbc:postgresql://localhost:5432/fitappdb";
	private static final String USR = "postgres";
	private static final String PWD= "postgres";
	private final Logger logger = Logger.getLogger(getClass().getName());


	public boolean checkLogIn(String username, String password) {
		try(Connection con = DriverManager.getConnection(URL,USR,PWD);
				PreparedStatement pst = con.prepareStatement(Query.getLogin())){
			pst.setString(1, username);
			pst.setString(2, password);
			try(ResultSet rs = pst.executeQuery()){
				rs.next();
				if(rs.getInt(1)>0) {
					logger.log(Level.INFO,"user found");
					return true;
				} else {
					logger.log(Level.SEVERE, "Wrong Username or Password");
				}
			}
		} catch (SQLException connEx) {
			logger.log(Level.SEVERE, connEx.getMessage(),connEx);
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
		} catch (SQLException trainingListEx) {
			logger.log(Level.SEVERE, trainingListEx.getMessage(),trainingListEx);
		}
		return trainingList;
	}

	public Gym getGymEntity(String username) {
		Integer gymId = 0;
		int managerId = 0;
		String managerName = null;
		String street = "";
		Map<Integer, String> trainers = null;
		Map<Integer, String> courses = null;
		boolean found = false;
		try(Connection con = DriverManager.getConnection(URL,USR,PWD);
				PreparedStatement pst = con.prepareStatement(
						"select gym_id, street, manager_id, manager_name"
						+ " from gym where gym_name = ?")){
			pst.setString(1,username);
			try(ResultSet rs = pst.executeQuery()){
				if(rs.next()) {
					found = true;
					gymId = rs.getInt("gym_id");
					street = rs.getString("street");
					managerId = rs.getInt("manager_id");
					managerName = rs.getString("manager_name");
				}
			}
		} catch(SQLException gymEx) {
			logger.log(Level.SEVERE, gymEx.getMessage(), gymEx);
		}
		if(found) {
			trainers = getTrainers(gymId);
			courses = getCourses();
		}
		
		return new Gym(gymId, username, managerId, managerName, street, trainers, courses);
	}

	// return a map of registered trainer for the current gymUser instance
	public Map<Integer,String> getTrainers(int gymId) {
		HashMap<Integer, String> tMap = new HashMap<>();
		Integer tId;
		String tName;
		try(Connection con = DriverManager.getConnection(URL,USR,PWD);
				PreparedStatement pst = con.prepareStatement(
						"select trainer_id, trainer_name from trainer where gym_id = ?")){
			pst.setInt(1, gymId);
			try(ResultSet rs = pst.executeQuery()){
				while(rs.next()) {
					tId = rs.getInt("trainer_id");
					tName = rs.getString("trainer_name");
					if(!tMap.containsKey(tId))
						tMap.put(tId, tName);
				}
			}
		} catch(SQLException trainerEx) {
			logger.log(Level.SEVERE, trainerEx.getMessage(), trainerEx);
		}
		return tMap;
	}

	// return a map of all available courses in the database
	public Map<Integer, String> getCourses(){
		HashMap<Integer, String> cMap = new HashMap<>();
		try(Connection con = DriverManager.getConnection(URL,USR,PWD);
				PreparedStatement pst = con.prepareStatement(
						"select course_id, course_name from course")){
			try(ResultSet rs = pst.executeQuery()){
				while(rs.next()) {
					cMap.put(rs.getInt(1), rs.getString(2));
				}
			}
		} catch(SQLException courseEx) {
			logger.log(Level.SEVERE, courseEx.getMessage(), courseEx);
		}
		return cMap;
	}
	public void resetTable() {
		try(Connection con = DriverManager.getConnection(URL, USR, PWD);
				PreparedStatement pst = con.prepareStatement(Query.getResetTable())){
			pst.executeQuery();
		} catch (SQLException resetEx) {
			logger.log(Level.SEVERE, resetEx.getMessage(), resetEx);
		}
	}
	public void fillTable() {
		try(Connection con = DriverManager.getConnection(URL, USR, PWD);
				PreparedStatement pst = con.prepareStatement(Query.getFillTable())){
			pst.execute();
		} catch (SQLException fillEx) {
			logger.log(Level.SEVERE, fillEx.getMessage(), fillEx);
		}
	}
	public static void main(String[] args) {
		/* useless at the moment */
		DAO d = DAO.getInstance();
		//d.resetTable();
		//d.fillTable();
		Gym g = d.getGymEntity("gym1");
		System.out.println("id: "+g.getGymId());
		System.out.println("gymName: "+g.getGymName());
		System.out.println("managerid: "+g.getManagerId());
		System.out.println("manager name: "+g.getManagerName());
		System.out.println("street: "+g.getstreet());
		System.out.println("course list: "+g.getCourses());
		System.out.println("trainer list: "+g.getTrainers());
	}
}