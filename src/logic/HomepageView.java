package logic;

import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import logic.viewcontroller.MainViewController;

public class HomepageView extends Application {
	
	private final Logger logger = Logger.getLogger(getClass().getName());
	MainViewController
	
	@Override
	public void start(Stage homepageStage) throws Exception{
		try {
		Parent p = MainViewController.getView();
		container = (BorderPane) MainViewController.getAllNodes(p).get(0);
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/logic/fxmls/PlaceHolder.fxml"));
		Node replace = loader.load();
		container.setCenter(replace);
	} catch (IOException e) {
		e.printStackTrace();
	}
	}	
	public static void main(String[] args) {
		launch(args);
	}
}
