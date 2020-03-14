package logic.factory;


import java.io.IOException;

import javafx.scene.control.Alert.AlertType;
import logic.CustomAlertBox;
import logic.exception.ControllerLoadingException;
import logic.exception.UserNotFoundException;

public class AlertFactory {
	private static AlertFactory instance = null;	
	private AlertFactory() {}
	
	public static synchronized AlertFactory getInstance() {
		if(AlertFactory.instance == null) {
			AlertFactory.instance = new AlertFactory();
		}
		return AlertFactory.instance; 
	}
	
	public CustomAlertBox createAlert(Exception e) {
		if(e instanceof UserNotFoundException) {
			return new CustomAlertBox(AlertType.ERROR, e);
		} else if(e instanceof IOException){
			return new CustomAlertBox(AlertType.ERROR, e);
		} else {
			return new CustomAlertBox(e);
		}
	}
}
