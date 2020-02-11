package logic.fxmlcontrollers;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.shape.Circle;
import logic.viewcontroller.MainActivityViewController;

public class MainActivityController {

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
//	Node replace = FXMLLoader(getClass().getResource("/logic/fxmls/PlaceHolder.fxml"));

    
    
	@FXML
	private void onMouseClickedEvent(MouseEvent event){
		if(event.getSource()==btnClose) {
			System.exit(0);
		}
		if(event.getSource() == place) {
			try {
				Parent p = MainActivityViewController.getInstance().getView();
				container = (BorderPane) MainActivityViewController.getAllNodes(p).get(0);
				FXMLLoader loader = new FXMLLoader(getClass().getResource("/logic/fxmls/PlaceHolder.fxml"));
				Node replace = loader.load();
				container.setCenter(replace);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}	

}
