package logic.fxmlcontrollers;

import javafx.scene.layout.BorderPane;
import logic.factory.AbstractSubView;

public class MainController {
	private static MainController instance;
	private static BorderPane container;
	
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
}
