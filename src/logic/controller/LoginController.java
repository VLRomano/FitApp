package logic.controller;
import java.util.logging.Level;
import java.util.logging.Logger;

import logic.DAO;
import logic.LoginBean;

public class LoginController {
	private final Logger logger = Logger.getLogger(getClass().getName());
	public boolean checkAuthentication(LoginBean bean) {
		logger.log(Level.INFO, "Connecting...");
		return DAO.getInstance().checkLogIn(bean);
	}
}
