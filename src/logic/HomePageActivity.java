package logic;

import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class HomePageActivity extends Application {
	private double offsetX;
	private double offsetY;
	private final Logger logger = Logger.getLogger(getClass().getName());
	
	@Override
	public void start(Stage homePageStage) throws Exception{
		try {
		Parent root = FXMLLoader.load(getClass().getResource("fxmls/homepageView.fxml"));
		Scene homepageViewScene = new Scene(root);
        homepageViewScene.getStylesheets().add(getClass().getResource("styles.css").toExternalForm());

		homePageStage.setScene(homepageViewScene);
//		homePageStage.initStyle(StageStyle.UNDECORATED);
		

			
		root.setOnMousePressed(event -> {
			offsetX = event.getSceneX();
        	offsetY = event.getSceneY();			
		});
		
		root.setOnMouseDragged(event -> {
			homePageStage.setX(event.getScreenX()-offsetX);
        	homePageStage.setY(event.getScreenY()-offsetY);
		});
		
		new animatefx.animation.FadeIn(root).play();
		
		new animatefx.animation.FadeIn(root).play();
		homePageStage.show();
		} catch (Exception e) {
			logger.log(Level.SEVERE, "Unable to load application\n"+e);
		}
	}
	
//	public static void main(String[] args) {
//		launch(args);
//	}
}
