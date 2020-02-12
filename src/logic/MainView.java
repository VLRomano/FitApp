package logic;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import logic.factory.AbstractView;
import logic.factory.AbstractViewController;
import logic.factory.ViewControllerFactory;

public class MainView extends Application implements AbstractView{
	private double offsetX;
	private double offsetY;
	private final Logger logger = Logger.getLogger(getClass().getName());
//java.lang.ClassCastException: logic.fxmlcontrollers.LoginViewController cannot be cast to logic.fxmlcontrollers.LoginController


	@Override
	public void start(Stage mainStage) {		
		try {
			ViewControllerFactory factory = ViewControllerFactory.getInstance();
			AbstractViewController viewController = factory.createController(1);
			Parent root = viewController.getView();
			Scene mainView = new Scene(root);
			mainStage.setScene(mainView);
			mainStage.initStyle(StageStyle.UNDECORATED);
			root.setOnMousePressed(event -> {
				offsetX = event.getSceneX();
				offsetY = event.getSceneY();			
			});

			root.setOnMouseDragged(event -> {
				mainStage.setX(event.getScreenX()-offsetX);
				mainStage.setY(event.getScreenY()-offsetY);
			});
			mainStage.show();
		} catch (IOException e) {
			logger.log(Level.SEVERE,"Unable to load application: "+e);
		}

	}

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void load() throws IOException {
		// TODO Auto-generated method stub
		
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
