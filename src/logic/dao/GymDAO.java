package logic.dao;

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

import logic.Query;
import logic.entity.Gym;

public class GymDAO {
	
	private static GymDAO instance = null;

	private GymDAO() {}

	public static synchronized GymDAO getInstance(){
		if(GymDAO.instance == null){
			GymDAO.instance = new GymDAO();
		}
		return GymDAO.instance;
	}
	
	private static final String URL = "jdbc:postgresql://localhost:5432/fitappdb";
	private static final String USR = "postgres";
	private static final String PWD= "postgres";
	private final Logger logger = Logger.getLogger(getClass().getName());

	public List<String> getTrainingList() {
		ArrayList<String> trainingList = new ArrayList<>();
		String query = "select * from course;";
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

	public Gym getGymEntity(Integer gymId) {
		String gymName = null;
		int managerId = 0;
		String managerName = null;
		String street = "";
		Map<Integer, String> trainers = null;
		Map<Integer, String> courses = null;
		boolean found = false;
		try(Connection con = DriverManager.getConnection(URL,USR,PWD);
				PreparedStatement pst = con.prepareStatement(
						"select gym_name, street, manager_id, manager_name"
						+ " from gym where gym_id = ?")){
			pst.setInt(1,gymId);
			try(ResultSet rs = pst.executeQuery()){
				if(rs.next()) {
					found = true;
					gymName = rs.getString("gym_name");
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
		
		return new Gym(gymId, gymName, managerId, managerName, street, trainers, courses);
	}

	// return a map of registered trainer for the current gymUser instance
	public Map<Integer,String> getTrainers(int gymId) {
		HashMap<Integer, String> tMap = new HashMap<>();
		Integer tId;
		String tName;
		try(Connection con = DriverManager.getConnection(URL,USR,PWD);
				PreparedStatement pst = con.prepareStatement(Query.getTrainerList())){
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
				PreparedStatement pst = con.prepareStatement(Query.getCourseList())){
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
}
