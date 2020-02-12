package logic.viewcontroller;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.shape.Circle;
import logic.factory.AbstractViewController;
import logic.fxmlcontrollers.MainController;

public class MainViewController extends AbstractViewController{
	private MainViewController controller;
	//private static MainViewController instance = null;
	private Parent view;
	private final Logger logger = Logger.getLogger(getClass().getName());

//	public MainViewController() throws IOException {
//		try{ 
//			load();
//		} catch (IOException e) {
//			logger.log(Level.SEVERE,"Unable to load controller: "+getClass().getName()+"\nException: "+e);
//		}
//	}
//	@Override
//	public void load() throws IOException {
//		FXMLLoader loader = new FXMLLoader(getClass().getResource("/logic/fxmls/Container.fxml"));
//		view = loader.load();
//		this.setController(loader.getController());
//	}
//	public static synchronized  MainViewController getInstance() throws IOException{
//		if(MainViewController.instance == null){
//			MainViewController.instance = new MainViewController();
//		}
//		return MainViewController.instance;
//	}
	@Override
	public Parent getView() {
		return view ;
	}
	public MainViewController getController() {
		return this.controller;
	}
	public void setController(MainViewController controller) {
		this.controller = controller;
	}
	@Override
	public void setView(Parent view) {
		this.view = view;
	}
	 @FXML
	    private HBox topMenu;
	    
	    @FXML
	    private BorderPane container;
	    
	    @FXML
	    private Circle btnReduce;

	    @FXML
	    private Circle btnExpand;

	    @FXML
	    private Circle btnClose;
	    
	    @FXML
	    private Button place;
//		Node replace = FXMLLoader(getClass().getResource("/logic/fxmls/PlaceHolder.fxml"));

	    
	    
		@FXML
		private void onMouseClickedEvent(MouseEvent event){
			if(event.getSource()==btnClose) {
				System.exit(0);
			}
			if(event.getSource() == place) {
//				try {
//					Parent p = MainViewController.getView();
//					container = (BorderPane) MainViewController.getAllNodes(p).get(0);
//					FXMLLoader loader = new FXMLLoader(getClass().getResource("/logic/fxmls/PlaceHolder.fxml"));
//					Node replace = loader.load();
//					container.setCenter(replace);
//				} catch (IOException e) {
//					e.printStackTrace();
//				}
			}
		}	


}