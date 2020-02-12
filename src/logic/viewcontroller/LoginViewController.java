package logic.viewcontroller;
import java.util.logging.Level;
import java.util.logging.Logger;
import animatefx.animation.ZoomIn;
import animatefx.animation.ZoomOut;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import logic.LoginBean;
import logic.fxmlcontrollers.LoginController;

public class LoginViewController {
	private LoginController controller;
	private final Logger logger = Logger.getLogger(getClass().getName());
	@FXML
	private HBox topMenu;
	@FXML
	private Button btnLogIn;
	@FXML
	private Button btnNoAcc;
	@FXML
	private Button btnSignUp;    
	@FXML
	private ImageView btnBack;    
	@FXML
	private Circle btnClose;
	@FXML
	private Circle btnExpand;
	@FXML
	private Circle btnReduce;
	@FXML
	private TextField tfUsername;
	@FXML
	private PasswordField tfPwd;
	@FXML
	private TextField tfEmailAddr;
	@FXML
	private Pane pnSignUp;
	@FXML
	private Pane pnSignIn;
	@FXML
	private AnchorPane anchRoot;

	@FXML
	private void handleButtonEvent(ActionEvent event) {
		if(event.getSource().equals(btnNoAcc)) {
			new ZoomOut(pnSignIn).play();
			pnSignIn.toBack();
			new ZoomIn(pnSignUp).play();
			pnSignUp.setVisible(true);
			pnSignUp.toFront();
		}
		if(event.getSource().equals(btnSignUp)) {
			String email = tfEmailAddr.getText();
			if(!email.equals(""))
				// TODO: implement a real mailing system.
				logger.log(Level.INFO,"Sending email to: "+tfEmailAddr.getText());
		}
		if(event.getSource().equals(btnLogIn)) {
			String username = tfUsername.getText();
			String password = tfPwd.getText();
			if(!username.equals("") && !password.equals("")) {
				LoginController ctrl = new LoginController();
				ctrl.checkAuthentication(new LoginBean(username, password));
				}
			}
		}
	
	@FXML
	private void handleMouseEvent(MouseEvent event){
		if(event.getSource()==btnClose) {
			System.exit(0);
		}
		if(event.getSource().equals(btnBack)) {
			new ZoomOut(pnSignUp).play();
			pnSignUp.toBack();
			new ZoomIn(pnSignIn).play();
			pnSignIn.toFront();
		}
	}
	@FXML
	void initialize() {
		assert topMenu != null : "fx:id=\"topMenu\" was not injected: check your FXML file 'scene.fxml'.";
		assert btnReduce != null : "fx:id=\"btnReduce\" was not injected: check your FXML file 'scene.fxml'.";
		assert btnExpand != null : "fx:id=\"btnExpand\" was not injected: check your FXML file 'scene.fxml'.";
		assert btnClose != null : "fx:id=\"btnClose\" was not injected: check your FXML file 'scene.fxml'.";
		assert pnSignUp != null : "fx:id=\"pnSignUp\" was not injected: check your FXML file 'scene.fxml'.";
		assert btnSignUp != null : "fx:id=\"btnSignUp\" was not injected: check your FXML file 'scene.fxml'.";
		assert tfEmailAddr != null : "fx:id=\"tfEmailAddr\" was not injected: check your FXML file 'scene.fxml'.";
		assert btnBack != null : "fx:id=\"btnBack\" was not injected: check your FXML file 'scene.fxml'.";
		assert pnSignIn != null : "fx:id=\"pnSignIn\" was not injected: check your FXML file 'scene.fxml'.";
		assert tfUsername != null : "fx:id=\"tfUsername\" was not injected: check your FXML file 'scene.fxml'.";
		assert tfPwd != null : "fx:id=\"tfPwd\" was not injected: check your FXML file 'scene.fxml'.";
		assert btnLogIn != null : "fx:id=\"btnLogIn\" was not injected: check your FXML file 'scene.fxml'.";
		assert btnNoAcc != null : "fx:id=\"btnNoAcc\" was not injected: check your FXML file 'scene.fxml'.";
	}

}
