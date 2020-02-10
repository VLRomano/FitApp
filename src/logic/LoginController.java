package logic;

import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.stage.Stage;
import logic.fxmlcontrollers.LoginViewController;
import logic.fxmls.LoginView;
import logic.DAO;

public class LoginController {
	
	private final Logger logger = Logger.getLogger(getClass().getName());
	
	private Stage loginStage;
	
	public LoginController() {}
	
	public LoginController(Stage stage) {
		this.loginStage = stage;
	}
	
	public void setStage(Stage stage) {
		loginStage = stage;
	}
	
	public void launchView() {
		LoginView view = new LoginView();
		try {
			System.out.println(loginStage);
			view.start(loginStage);
		} catch (Exception e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
			logger.log(Level.SEVERE, "Unable to load application\n"+e);
		}
	}
	
	
	
	public boolean checkAuthentication(LoginBean bean) {
		
		if(DAO.getInstance().checkLogIn(bean.getUsername(), bean.getPassword())) {
			return true;
		}
		else {
			return false;
		}
	}
}
