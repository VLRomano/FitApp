package logic;

import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import logic.factory.AbstractViewController;
import logic.factory.ViewControllerFactory;

public class LoginActivity extends Application {
	private double offsetX;
	private double offsetY;
	private final Logger logger = Logger.getLogger(getClass().getName());

	@Override
	public void start(Stage loginStage) throws Exception{
		try {
			ViewControllerFactory factory = ViewControllerFactory.getInstance();
			AbstractViewController loginViewController = factory.createController(0);
			Parent root = loginViewController.getView();
			Scene loginScene = new Scene(root);

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


	public static void main(String[] args) {
		launch(args);
	}
}
