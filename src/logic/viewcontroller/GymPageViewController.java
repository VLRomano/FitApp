package logic.viewcontroller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

public class GymPageViewController {
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
