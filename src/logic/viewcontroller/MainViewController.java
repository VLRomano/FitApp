package logic.viewcontroller;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.shape.Circle;
import logic.factory.AbstractSubView;
import logic.factory.SubViewFactory;
import logic.fxmlcontrollers.MainController;

public class MainViewController{
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

			try {
				SubViewFactory factory = SubViewFactory.getInstance();
				AbstractSubView subview = factory.createSubView(1);
				MainController ctrl = new MainController();
				ctrl.replace(container, subview);
			} catch (IOException e) {
				logger.log(Level.SEVERE,"Unable to load controller: "+getClass().getName()+"\nException: "+e);
			}
		}
	}	


}