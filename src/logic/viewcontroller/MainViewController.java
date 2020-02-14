package logic.viewcontroller;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.shape.Circle;
import logic.factory.AbstractSubView;
import logic.factory.SubViewFactory;
import logic.fxmlcontrollers.MainController;

public class MainViewController implements Initializable{
	private final Logger logger = Logger.getLogger(getClass().getName());

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

	@FXML
	private void onMouseClickedEvent(MouseEvent event){
		if(event.getSource()==btnClose) {
			System.exit(0);
		}
		if(event.getSource() == place) {
			logger.log(Level.INFO, "placeholder");
			try {
				SubViewFactory factory = SubViewFactory.getInstance();
				AbstractSubView subview = factory.createSubView(1);
//				MainController.getInstance().replace(MainController.getContainer(), subview);
				MainController ctrl = MainController.getInstance();
				ctrl.replace(MainController.getContainer(), subview);
			} catch (IOException e) {
				logger.log(Level.SEVERE,"Unable to load controller: "+getClass().getName()+"\nException: "+e);
			}
		}
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		MainController.setContainer(container);
	}	


}