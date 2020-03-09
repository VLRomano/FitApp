package logic.viewcontroller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import logic.controller.MainController;
import logic.factory.AbstractSubView;
import logic.factory.SubViewFactory;

public class GymPageViewController {
	private final Logger logger = Logger.getLogger(getClass().getName());

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private AnchorPane anchorPane;

	@FXML
	private Hyperlink viewRecorder;

	@FXML
	private ImageView userIcon;

	@FXML
	private ImageView logOutIcon;

	@FXML
	private Button newTrainer;

	@FXML
	private Button newSession;

	@FXML
	private ListView<?> reviewList;

	@FXML
	private ListView<?> sessionList;

	@FXML
	private ImageView sideUserIcon;

	@FXML
	private Label sideUsername;

	@FXML
	private Label sideGymName;

	@FXML
	private Label sideGymStreet;

	MainController ctrl = MainController.getInstance();
	SubViewFactory factory = SubViewFactory.getInstance();
	AbstractSubView subview;
	public void handleMouseEvent(MouseEvent event) {
		if(event.getSource().equals(logOutIcon)) {
			try {
				ctrl.replace(MainController.getContainer(), factory.createSubView(0));
			} catch (IOException e) {
				logger.log(Level.SEVERE,"Unable to load controller: "+getClass().getName()+"\nException: "+e);
			}
		}	
	}
	
	@FXML
	private void onMouseClickedEvent(MouseEvent event) {
		if(event.getSource().equals(newSession)) {
			try {
				ctrl.replace(MainController.getContainer(), factory.createSubView(3));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	@FXML
	void initialize() {
		assert anchorPane != null : "fx:id=\"anchorPane\" was not injected: check your FXML file 'GymPage.fxml'.";
		assert viewRecorder != null : "fx:id=\"viewRecorder\" was not injected: check your FXML file 'GymPage.fxml'.";
		assert userIcon != null : "fx:id=\"userIcon\" was not injected: check your FXML file 'GymPage.fxml'.";
		assert logOutIcon != null : "fx:id=\"logOutIcon\" was not injected: check your FXML file 'GymPage.fxml'.";
		assert newTrainer != null : "fx:id=\"newTrainer\" was not injected: check your FXML file 'GymPage.fxml'.";
		assert newSession != null : "fx:id=\"newSession\" was not injected: check your FXML file 'GymPage.fxml'.";
		assert reviewList != null : "fx:id=\"reviewList\" was not injected: check your FXML file 'GymPage.fxml'.";
		assert sessionList != null : "fx:id=\"sessionList\" was not injected: check your FXML file 'GymPage.fxml'.";
		assert sideUserIcon != null : "fx:id=\"sideUserIcon\" was not injected: check your FXML file 'GymPage.fxml'.";
		assert sideUsername != null : "fx:id=\"sideUsername\" was not injected: check your FXML file 'GymPage.fxml'.";
		assert sideGymName != null : "fx:id=\"sideGymName\" was not injected: check your FXML file 'GymPage.fxml'.";
		assert sideGymStreet != null : "fx:id=\"sideGymStreet\" was not injected: check your FXML file 'GymPage.fxml'.";
	}
}
