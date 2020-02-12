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
	public Parent getRoot() {
		return root;
	}
	public void setRoot(Parent root) {
		this.root = root;
	}


	private AbstractViewController loginViewController;
	public AbstractViewController getLoginViewController() {
		return loginViewController;
	}
	public void setLoginViewController(AbstractViewController loginViewController) {
		this.loginViewController = loginViewController;
	}


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
//			ViewControllerFactory factory = ViewControllerFactory.getInstance();
//			AbstractViewController loginViewController = factory.createController(0);
			
			//this.root = loginViewController.getView();
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


	public static void main(String[] args) {
		launch(args);
	}


	@Override
	public void load() throws IOException {
		// TODO Auto-generated method stub
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/logic/fxmls/Login.fxml"));
		this.root = loader.load();
		this.setLoginViewController(loader.getController());
	}


	@Override
	public Parent getView() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void setView(Parent view) {
		// TODO Auto-generated method stub
		
	}
}
