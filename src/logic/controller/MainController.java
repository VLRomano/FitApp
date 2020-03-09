package logic.controller;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.BorderPane;
import logic.factory.AbstractSubView;

public class MainController {
	private static MainController instance;
	private static BorderPane container;
	private int id = 0; 

	public void setId(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	private MainController() {}

	public static synchronized MainController getInstance() {
		if(MainController.instance == null) {
			MainController.instance = new MainController();
		}
		return MainController.instance;
	}

	public static BorderPane getContainer() {
		return container;
	}

	public static void setContainer(BorderPane container) {
		MainController.container = container;
	}

	public void replace(BorderPane container, AbstractSubView node) {
		container.setCenter(node.getRoot());
	}

	//TODO create a a factory for all alerts
	public void showDateAlert() {
		Alert dateAlert = new Alert(AlertType.ERROR, "You cannot select a past date", ButtonType.OK);	    	dateAlert.showAndWait();

		if(dateAlert.getResult() == ButtonType.OK) {
			dateAlert.close();
		}
	}
}


