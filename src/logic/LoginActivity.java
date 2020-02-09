package logic;

import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class LoginActivity extends Application {
	private double offsetX;
	private double offsetY;
	private final Logger logger = Logger.getLogger(getClass().getName());

	@Override
	public void start(Stage loginStage) throws Exception{
		try {
		Parent root = FXMLLoader.load(getClass().getResource("fxmls/login.fxml"));
		Scene loginScene = new Scene(root);
        loginScene.getStylesheets().add(getClass().getResource("styles.css").toExternalForm());

		loginStage.setScene(loginScene);
		loginStage.initStyle(StageStyle.UNDECORATED);
		
		root.setOnMousePressed(event -> {
			offsetX = event.getSceneX();
        	offsetY = event.getSceneY();			
		});
		
		root.setOnMouseDragged(event -> {
			loginStage.setX(event.getScreenX()-offsetX);
        	loginStage.setY(event.getScreenY()-offsetY);
		});
		
		new animatefx.animation.FadeIn(root).play();
		loginStage.show();
		} catch (Exception e) {
			logger.log(Level.SEVERE, "Unable to load application\n"+e);
		}
	}
}
	
//	public static void main(String[] args) {
//		launch(args);
//	}
//}
