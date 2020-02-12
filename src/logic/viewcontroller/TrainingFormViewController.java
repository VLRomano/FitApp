package logic.viewcontroller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import logic.TrainingFormBean;

public class TrainingFormViewController {

    @FXML
    private Label homeLabel;

    @FXML
    private RadioButton singleRButton;

    @FXML
    private RadioButton groupRButton;

    @FXML
    private ChoiceBox<String> trainingTypeCBox;

    @FXML
    private TextField trainingNameTField;

    @FXML
    private ChoiceBox<String> trainerCBox;

    @FXML
    private TextField hourTField;

    @FXML
    private TextField minuteTField;

    @FXML
    private DatePicker datePicker;

    @FXML
    private TextArea descriptionTArea;

    @FXML
    private Button okButton;
    
    @FXML
    private ToggleGroup session;
    
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
			bean.setHour(hourTField.getText());
			bean.setMinute(minuteTField.getText());
			bean.setDate(datePicker.getValue());
			bean.setDescription(descriptionTArea.getText());
			
			//TODO launch confirmation screen
			
		}
    }	
}
