package logic;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import logic.factory.AbstractView;
import logic.factory.AbstractViewController;
import logic.factory.ViewControllerFactory;

public class LoginView extends Application implements AbstractView{
	private double offsetX;
	private double offsetY;
	private Parent root;
	private final Logger logger = Logger.getLogger(getClass().getName());
	
	public LoginView() {
		try {
			load();
		} catch (IOException e) {
			logger.log(Level.SEVERE,"Unable to load controller: "+getClass().getName()+"\nException: "+e);
		}
	}
	@Override
	public void start(Stage loginStage) throws Exception{
		try {
			Scene loginScene = new Scene(root);

			loginStage.setScene(loginScene);
			loginStage.initStyle(StageStyle.UNDECORATED);

			this.root.setOnMousePressed(event -> {
				offsetX = event.getSceneX();
				offsetY = event.getSceneY();			
			});

			this.root.setOnMouseDragged(event -> {
				loginStage.setX(event.getScreenX()-offsetX);
				loginStage.setY(event.getScreenY()-offsetY);
			});

			new animatefx.animation.FadeIn(root).play();
			loginStage.show();
		} catch (Exception e) {
			logger.log(Level.SEVERE, "Unable to load application\n"+e);
		}
	}
	
	@Override
	public void load() throws IOException {
		// TODO Auto-generated method stub
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/logic/fxmls/Login.fxml"));
		setRoot(loader.load());
	}
	
	public Parent getRoot() {
		return root;
	}
	public void setRoot(Parent root) {
		this.root = root;
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
