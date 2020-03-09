package logic.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import logic.entity.User;

public class UserDAO {
	
	
	private static final String URL = "jdbc:postgresql://localhost:5432/fitappdb";
	private static final String USR = "postgres";
	private static final String PWD= "postgres";
	private final Logger logger = Logger.getLogger(getClass().getName());
	
	private static UserDAO instance = null;

	private UserDAO() {}

	public static synchronized UserDAO getInstance(){
		if(UserDAO.instance == null){
			UserDAO.instance = new UserDAO();
		}
		return UserDAO.instance;
	}
	
	public User getUserEntity(Integer userId) {
		String username = "";
		boolean isManager = false;
		ArrayList<Integer> bookedSession = new ArrayList<>();
		String sql = "select username, manager from users where user_id = ?";
		try(Connection con = DriverManager.getConnection(URL,USR,PWD);
				PreparedStatement pst = con.prepareStatement(sql)){
			pst.setInt(1, userId);
			try(ResultSet rs = pst.executeQuery()){
				if(rs.next()) {
					username = rs.getString("username");
					isManager = rs.getBoolean("manager");
					bookedSession = (ArrayList<Integer>) getBooking(userId);
				}
			}
		} catch(SQLException e) {
			logger.log(Level.SEVERE, e.getMessage(), e);
			return null;
		}
		return new User(userId, username, isManager, bookedSession);
	}
	
	public List<Integer> getBooking(Integer userId) {
		ArrayList<Integer> sessionList = new ArrayList<>();
		String sql = "select session_id from booked_session where user_id = ?";
		try(Connection con = DriverManager.getConnection(URL,USR,PWD);
				PreparedStatement pst = con.prepareStatement(sql)){
			pst.setInt(1, userId);
			try(ResultSet rs = pst.executeQuery()){
				while(rs.next()) {
					sessionList.add(rs.getInt("session_id"));
				}
			}
		} catch(SQLException e) {
			logger.log(Level.SEVERE, e.getMessage(), e);
			
		}
		return sessionList;
	}
	
}
