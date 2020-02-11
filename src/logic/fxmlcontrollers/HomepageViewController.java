package logic.fxmlcontrollers;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
//import logic.LoginController;

public class HomepageViewController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane anchorPane;

    @FXML
    private VBox verticalFrame;

    @FXML
    private HBox topLineBox;

    @FXML
    private HBox buttonBarBox;

    @FXML
    private Button signUpButton;

    @FXML
    private Button logInButton;

    @FXML
    private HBox imagesBox;

    @FXML
    private VBox personalClassBox;

    @FXML
    private Button findPersonalButton;

    @FXML
    private VBox classBox;

    @FXML
    private Button findClassButton;

    @FXML
    private VBox offerClassBox;

    @FXML
    private Button offerTrainingButton;

    @FXML
    private HBox bottomLineBox;
    
    Stage loginStage = new Stage();
    
    private final Logger logger = Logger.getLogger(getClass().getName());
    
    @FXML
	private void handleMouseEvent(ActionEvent event) {
		if(event.getSource().equals(signUpButton)) {
			//TODO: LINK TO SIGNUP PAGE 
		}
//		if(event.getSource().equals(logInButton)) {
//			LoginController loginController = new LoginController(loginStage);
////			LoginViewController log = new LoginViewController();
//			try {
//				loginController.launchView();
////				log.start(loginStage);
//			} catch (Exception e) {
//				// TODO Auto-generated catch block
//				logger.log(Level.SEVERE, "Unable to load application\n"+e);
//			}
//		}
		if(event.getSource().equals(findPersonalButton)) {
			//TODO: LINK TO FIND PERSONAL CLASS PAGE
		}
		if(event.getSource().equals(findClassButton)) {
			//TODO: LINK TO FIND CLASS PAGE
		}
		if(event.getSource().equals(offerTrainingButton)) {
			//TODO: LINK TO OFFER TRAINING PAGE
		}
	}

    @FXML
    void initialize() {
        assert anchorPane != null : "fx:id=\"anchorPane\" was not injected: check your FXML file 'homepage.fxml'.";
        assert verticalFrame != null : "fx:id=\"verticalFrame\" was not injected: check your FXML file 'homepage.fxml'.";
        assert topLineBox != null : "fx:id=\"topLineBox\" was not injected: check your FXML file 'homepage.fxml'.";
        assert buttonBarBox != null : "fx:id=\"buttonBarBox\" was not injected: check your FXML file 'homepage.fxml'.";
        assert signUpButton != null : "fx:id=\"signUpButton\" was not injected: check your FXML file 'homepage.fxml'.";
        assert logInButton != null : "fx:id=\"logInButton\" was not injected: check your FXML file 'homepage.fxml'.";
        assert imagesBox != null : "fx:id=\"imagesBox\" was not injected: check your FXML file 'homepage.fxml'.";
        assert personalClassBox != null : "fx:id=\"personalClassBox\" was not injected: check your FXML file 'homepage.fxml'.";
        assert findPersonalButton != null : "fx:id=\"findPersonalButton\" was not injected: check your FXML file 'homepage.fxml'.";
        assert classBox != null : "fx:id=\"classBox\" was not injected: check your FXML file 'homepage.fxml'.";
        assert findClassButton != null : "fx:id=\"findClassButton\" was not injected: check your FXML file 'homepage.fxml'.";
        assert offerClassBox != null : "fx:id=\"offerClassBox\" was not injected: check your FXML file 'homepage.fxml'.";
        assert offerTrainingButton != null : "fx:id=\"offerTrainingButton\" was not injected: check your FXML file 'homepage.fxml'.";
        assert bottomLineBox != null : "fx:id=\"bottomLineBox\" was not injected: check your FXML file 'homepage.fxml'.";

    }
}
