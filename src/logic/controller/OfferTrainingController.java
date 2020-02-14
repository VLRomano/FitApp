package logic.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import logic.DAO;
import logic.entity.Gym;

public class OfferTrainingController {
	
	private String username = "user"; //
	
	DAO dao = DAO.getInstance();
	
	public ObservableList<String> getTrainingList(){
	
		ObservableList<String> trainingList = FXCollections.observableArrayList(dao.getTtrainingList());
		return trainingList;
	}
	
	public ObservableList<String> getTrainerList(){
		ObservableList<String> trainerList = FXCollections.observableArrayList(getGymEntity().getTrainers()); 
		System.out.println(getGymEntity().getName());	
		return trainerList;
	}
	
	
	public Gym getGymEntity(/*user name dynamically gotten*/) {
		Gym gym = dao.getGymEntity(username); //this method is a dummy needs to be implemented
		return gym;
	}
}

