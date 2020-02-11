package logic.viewcontroller;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import logic.factory.AbstractViewController;
import logic.fxmlcontrollers.LoginActivityController;

public class LoginActivityViewController extends AbstractViewController {
	private LoginActivityController controller;
	private static LoginActivityViewController instance = null;
	private Parent view;
	private LoginActivityViewController() throws IOException {
		try {
			load();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static synchronized LoginActivityViewController getInstance() throws IOException {
		if(LoginActivityViewController.instance == null) {
			LoginActivityViewController.instance = new LoginActivityViewController();
		}
		return LoginActivityViewController.instance;
	}
	@Override
	public void load() throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/logic/fxmls/Login.fxml"));
		setView(loader.load());
		this.setController(loader.getController());
	}
	//	public void setController(LoginActivityController controller) {
	//		this.controller = controller;
	//	}

	@Override
	public Parent getView() {
		return view;
	}
	@Override
	public void setView(Parent view) {
		this.view = view;
	}
	public LoginActivityController getController() {
		return controller;
	}
	public void setController(LoginActivityController controller) {
		this.controller = controller;
	}

}
