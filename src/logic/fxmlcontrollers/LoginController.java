package logic.fxmlcontrollers;
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
import logic.DAO;
import logic.LoginBean;

public class LoginController {
	private final Logger logger = Logger.getLogger(getClass().getName());
	public boolean checkAuthentication(LoginBean bean) {
		return DAO.getInstance().checkLogIn(bean.getUsername(), bean.getPassword());
	}
}
