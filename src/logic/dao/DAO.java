package logic.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import logic.Query;
import logic.bean.LoginBean;
import logic.exception.UserNotFoundException;
import logic.factory.alertfactory.AlertFactory;

public class DAO {

	private static DAO instance = null;

	protected DAO() {
	}

	public static synchronized DAO getInstance() {
		if (DAO.instance == null) {
			DAO.instance = new DAO();
		}
		return DAO.instance;
	}

	private static final String URL = "jdbc:postgresql://localhost:5432/fitappdb";
	private static final String USR = "postgres";
	private static final String PWD = "postgres";
	private final Logger logger = Logger.getLogger(getClass().getName());

	public boolean checkLogIn(LoginBean bean) {
		String username = bean.getUsername();
		String password = bean.getPassword();
		try (Connection con = DriverManager.getConnection(URL, USR, PWD);
				PreparedStatement pst = con.prepareStatement(Query.getLogin())) {
			pst.setString(1, username);
			pst.setString(2, password);
			try (ResultSet rs = pst.executeQuery()) {
				if (rs.next()) {
					logger.log(Level.INFO, "user found");
					bean.setId(rs.getInt(1));
					if (rs.getBoolean("manager")) {
						bean.setType(true);
					}
					return true;
				} else {
					throw (UserNotFoundException) new UserNotFoundException(); 
				}

			}
		} catch (SQLException connEx) {
			AlertFactory.getInstance().createAlert(connEx);
		} catch (UserNotFoundException unf) {
			AlertFactory.getInstance().createAlert(unf);
		}
		return false;
	}


	public void resetTable() {
		try (Connection con = DriverManager.getConnection(URL, USR, PWD);
				PreparedStatement pst = con.prepareStatement(Query.getResetTable())) {
			pst.executeQuery();
		} catch (SQLException resetEx) {
			logger.log(Level.SEVERE, resetEx.getMessage(), resetEx);
		}
	}

	public void fillTable() {
		try (Connection con = DriverManager.getConnection(URL, USR, PWD);
				PreparedStatement pst = con.prepareStatement(Query.getFillTable())) {
			pst.execute();
		} catch (SQLException fillEx) {
			logger.log(Level.SEVERE, fillEx.getMessage(), fillEx);
		}
	}
}
