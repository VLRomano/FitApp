package logic.viewcontroller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import logic.TrainingFormBean;
import logic.controller.OfferTrainingController;
import logic.factory.AbstractSubView;
import logic.factory.SubViewFactory;
import logic.fxmlcontrollers.MainController;

public class TrainingFormViewController implements Initializable{
	
	OfferTrainingController OTController = OfferTrainingController.getInstance();
	
	private final Logger logger = Logger.getLogger(getClass().getName());

	 @FXML
	    private Label homeLabel;

	    @FXML
	    private RadioButton singleRButton;

	    @FXML
	    private ToggleGroup session;

	    @FXML
	    private RadioButton groupRButton;

	    @FXML
	    private ChoiceBox<String> trainingTypeCBox;

	    @FXML
	    private TextField trainingNameTField;

	    @FXML
	    private ChoiceBox<String> trainerCBox;

	    @FXML
	    private ComboBox<Integer> startHourCBox;

	    @FXML
	    private ComboBox<Integer> startMinuteCBox;
	    
	    @FXML
	    private ComboBox<Integer> endHourCBox;

	    @FXML
	    private ComboBox<Integer> endMinuteCBox;

	    @FXML
	    private DatePicker datePicker;

	    @FXML
	    private TextArea descriptionTArea;

	    @FXML
	    private Button okButton;
    
    @Override
	public void initialize(URL location, ResourceBundle resources) {
    	
		ObservableList<String> typeList = OTController.getTrainingList();
    	trainingTypeCBox.setItems(typeList);
    	trainingTypeCBox.setValue(typeList.get(0));
    	
    	ObservableList<String> trainerList = OTController.getTrainerList();
    	trainerCBox.setItems(trainerList);
    	trainerCBox.setValue(trainerList.get(0)); 	System.out.println("start initialization");
    	
    	startHourCBox.getItems().addAll(hourGenerator());
    	startHourCBox.setPromptText("HH");
    	
    	startMinuteCBox.getItems().addAll(minuteList);
    	startMinuteCBox.setPromptText("MM");
    	
    	endHourCBox.getItems().addAll(hourGenerator());
    	endHourCBox.setPromptText("HH");
    	
    	endMinuteCBox.getItems().addAll(minuteList);
    	endMinuteCBox.setPromptText("MM");
    	
    	
	}
    	
    @FXML
	private void onMouseClickedEvent(MouseEvent event){
    	if(event.getSource().equals(homeLabel)) {
    		//TODO launch home view
    	}
		if(event.getSource().equals(okButton)) {
			
			TrainingFormBean bean = new TrainingFormBean();
			
			bean.setSingle(singleRButton.isSelected());
			bean.setGroup(groupRButton.isSelected());
			bean.setTrainingType(trainingTypeCBox.getValue());
			bean.setTrainingName(trainingNameTField.getText());
			bean.setTrainerName(trainerCBox.getValue());
			bean.setStartHour(startHourCBox.getValue());
			bean.setStartMinute(startMinuteCBox.getValue());
			bean.setEndHour(endHourCBox.getValue());
			bean.setEndMinute(endMinuteCBox.getValue());
			bean.setDate(datePicker.getValue());
			bean.setDescription(descriptionTArea.getText());
			
			OTController.setTrainingBean(bean);	
			
			//TODO: create check schedule for trainer in OfferTrainingController
			
			logger.log(Level.INFO, "onto confirmation screen");
			try {
				SubViewFactory factory = SubViewFactory.getInstance();
				AbstractSubView subview = factory.createSubView(3);
				MainController ctrl = MainController.getInstance();
				ctrl.replace(MainController.getContainer(), subview);
			} catch (IOException e) {
				logger.log(Level.SEVERE,"Unable to load controller: "+getClass().getName()+"\nException: "+e);
			}
		}
    }
    
    private Integer[] minuteList = {00, 15, 30, 45};

    private Integer[] hourGenerator() {
    	Integer[] list = new Integer[24];
    	
    	for (int i = 0; i < 24; i++)
    	    list[i] = i;
    	return list;
    	}
}
