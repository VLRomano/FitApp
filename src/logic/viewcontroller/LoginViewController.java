package logic.viewcontroller;
import java.io.IOException;
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
import logic.controller.LoginController;
import logic.controller.MainController;
import logic.factory.AbstractSubView;
import logic.factory.SubViewFactory;

public class LoginViewController {
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
	private void handleButtonEvent(ActionEvent event) throws IOException {
		if(event.getSource().equals(btnNoAcc)) {
			loginAnimation(true);
		}
		if(event.getSource().equals(btnSignUp)) {
			String email = tfEmailAddr.getText();
			if(!email.equals(""))
				logger.log(Level.INFO,"Sending email to: "+tfEmailAddr.getText());
		}
		if(event.getSource().equals(btnLogIn)) {
			String username = tfUsername.getText();
			String password = tfPwd.getText();
			if(!username.equals("") && !password.equals("")) {
				loginTransitions(username, password);
			}
		}
	}
	private void loginTransitions(String username, String password) throws IOException {
		LoginController ctrl = new LoginController();
		LoginBean bean = new LoginBean(username, password);
		if (ctrl.checkAuthentication(bean)) {
			SubViewFactory factory = SubViewFactory.getInstance();
			AbstractSubView subview;
			if(bean.getType()) {
				 subview = factory.createSubView(1);
			} else {
				subview = factory.createSubView(2);
			}
			MainController.getInstance().replace(MainController.getContainer(), subview);
		}
	}
	@FXML
	private void handleMouseEvent(MouseEvent event){
		if(event.getSource()==btnClose) {
			System.exit(0);
		}
		if(event.getSource().equals(btnBack)) {
			loginAnimation(false);
		}
	}
	private void loginAnimation(boolean animation) {
		if(animation) {
			new ZoomOut(pnSignIn).play();
			pnSignIn.toBack();
			new ZoomIn(pnSignUp).play();
			pnSignUp.setVisible(true);
			pnSignUp.toFront();
		} else {
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
