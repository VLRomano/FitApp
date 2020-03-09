package logic.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import logic.entity.Session;

public class SessionDAO {
	private static final String URL = "jdbc:postgresql://localhost:5432/fitappdb";
	private static final String USR = "postgres";
	private static final String PWD= "postgres";
	private final Logger logger = Logger.getLogger(getClass().getName());

	private static SessionDAO instance = null;

	private SessionDAO() {}

	public static synchronized SessionDAO getInstance(){
		if(SessionDAO.instance == null){
			SessionDAO.instance = new SessionDAO();
		}
		return SessionDAO.instance;
	}

	public List<Integer> getBooking(Integer userId){
		String sql = "select session_id from booked_session where user_id = ?";
		ArrayList<Integer> bookings = new ArrayList<>();
		try(Connection con = DriverManager.getConnection(URL,USR,PWD);
				PreparedStatement pst = con.prepareStatement(sql)){
			pst.setInt(1, userId);
			try(ResultSet rs = pst.executeQuery()){
				while(rs.next()) {
					bookings.add(rs.getInt("session_id"));
				}
			}
		}catch(SQLException e) {
			logger.log(Level.SEVERE, e.getMessage(), e);
		}
		return bookings;
	}

	public List<Session> getSessionList(List<Integer> listId) {
		String sql = "select * from training_session";
		Integer id;
		ArrayList<Session> bookedSession = new ArrayList<>();
		try(Connection con = DriverManager.getConnection(URL,USR,PWD);
				PreparedStatement pst = con.prepareStatement(sql)){
			try(ResultSet rs = pst.executeQuery()){
				while(rs.next()) {
					id = rs.getInt("session_id");
					if(listId.contains(id)) {
						Time[] duration = {rs.getTime("time_start"), rs.getTime("time_end")};
						bookedSession.add(
								new Session (id, GymDAO.getInstance().getGymEntity(rs.getInt("gym_id")),
										duration, rs.getDate("day"),
										rs.getString("description")));
					}
				}
			}
		} catch(SQLException e) {
			logger.log(Level.SEVERE, e.getMessage(), e);
		}

		return bookedSession;
	}
}

