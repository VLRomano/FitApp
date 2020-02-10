package logic.fxmls;

import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import logic.fxmlcontrollers.LoginViewController;

public class LoginView extends Application{
	
	private final Logger logger = Logger.getLogger(getClass().getName());
	
	@Override
	public void start(Stage loginStage) throws Exception{
		try {
		Parent root = FXMLLoader.load(getClass().getResource("login.fxml"));
		FXMLLoader loader = new FXMLLoader();
		loader.setController(new LoginViewController());
		Scene loginScene = new Scene(root);

		loginStage.setScene(loginScene);
		loginStage.initStyle(StageStyle.UNDECORATED);
		loginStage.show();
		} catch (Exception e) {
			logger.log(Level.SEVERE, "Unable to load application\n"+e);
		}
	}
}
