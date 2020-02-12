package logic;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import logic.factory.AbstractSubView;
import logic.factory.SubViewFactory;
import logic.fxmlcontrollers.MainController;

public class MainView extends Application {
	private double offsetX;
	private double offsetY;
	private Parent root;
	public Parent getRoot() {
		return this.root;
	}
	public void setRoot(Parent root) {
		this.root = root;
	}
	private final Logger logger = Logger.getLogger(getClass().getName());
	
	public MainView() { // may be singleton
		try {
			load();
		} catch (IOException e) {
			logger.log(Level.SEVERE,"Unable to load controller: "+getClass().getName()+"\nException: "+e);
		}
	}
	public void load() throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/logic/fxmls/Container.fxml"));
		 setRoot(loader.load());
	}

	@Override
	public void start(Stage mainStage) throws Exception{		
		try {
			Scene mainView = new Scene(root);
			mainStage.setScene(mainView);
			mainStage.initStyle(StageStyle.UNDECORATED);
			root.setOnMousePressed(event -> {
				offsetX = event.getSceneX();
				offsetY = event.getSceneY();			
			});

			root.setOnMouseDragged(event -> {
				mainStage.setX(event.getScreenX()-offsetX);
				mainStage.setY(event.getScreenY()-offsetY);
			});
			MainController ctrl = new MainController();
			SubViewFactory factory = SubViewFactory.getInstance();
			AbstractSubView subview = factory.createSubView(0);
			ctrl.replace((BorderPane)getAllNodes(root).get(0), subview);
			mainStage.show();
		} catch (Exception e) {
			logger.log(Level.SEVERE,"Unable to load application: "+e);
		}

	}
	public static List<Node> getAllNodes(Parent p){
		ArrayList<Node> nodes = new ArrayList<>();
		addAllDescendents(p,nodes);
		return nodes;
	}
	private static void addAllDescendents(Parent p, ArrayList<Node> nodes) {
		for (Node n : p.getChildrenUnmodifiable()) {
			nodes.add(n);
			if(n instanceof Parent)
				addAllDescendents((Parent)n,nodes);
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
