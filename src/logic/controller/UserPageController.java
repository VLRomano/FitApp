package logic.controller;

import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.sun.javafx.scene.control.skin.DatePickerSkin;

import javafx.scene.Node;
import javafx.scene.control.DatePicker;
import javafx.scene.layout.BorderPane;


public class UserPageController {
	private final Logger logger = Logger.getLogger(getClass().getName());

	private DatePicker picker;
	private LocalDate selectedDate;
	public LocalDate getSelectedDate() {
		return selectedDate;
	}
	public void setSelectedDate(LocalDate selectedDate) {
		this.selectedDate = selectedDate;
	}
	public UserPageController() {
		setPicker(new DatePicker(LocalDate.now()));
		setSelectedDate(getPicker().getValue());
		getPicker().valueProperty().addListener((obs, oldValue, newValue)->{
			logger.log(Level.INFO, "Date picked: "+ newValue);
		});
	}
	public DatePicker getPicker() {
		return picker;
	}
	public void setPicker(DatePicker picker) {
		this.picker = picker;
	}
	public void calendar(BorderPane p) {
		DatePickerSkin skin = new DatePickerSkin(getPicker());
		Node calendar = skin.getPopupContent();
		p.setCenter(calendar);
	}
}
