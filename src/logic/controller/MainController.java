package logic.controller;

import javafx.scene.layout.BorderPane;
import logic.factory.AbstractSubView;

public class MainController {
	public void replace(BorderPane container, AbstractSubView node) {
		container.setCenter(node.getRoot());
	}
}
