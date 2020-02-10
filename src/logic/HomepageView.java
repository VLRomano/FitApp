package logic;

import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class HomepageView extends Application {
	
	private final Logger logger = Logger.getLogger(getClass().getName());
	
	@Override
	public void start(Stage homepageStage) throws Exception{
		try {
		Parent root = FXMLLoader.load(getClass().getResource("fxmls/homepageView.fxml"));
		Scene homepageViewScene = new Scene(root);

		homepageStage.setScene(homepageViewScene);
		homepageStage.initStyle(StageStyle.UNDECORATED);
		homepageStage.show();
		} catch (Exception e) {
			logger.log(Level.SEVERE, "Unable to load application\n"+e);
		}
	}	
	public static void main(String[] args) {
		launch(args);
	}
}
