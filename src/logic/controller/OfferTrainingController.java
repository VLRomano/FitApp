package logic.controller;

import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import logic.DAO;
import logic.TrainingFormBean;
import logic.entity.Gym;

public class OfferTrainingController {
	
	private static OfferTrainingController instance = null;

	private OfferTrainingController() {}

		public static synchronized OfferTrainingController getInstance(){
			if(OfferTrainingController.instance == null){
				OfferTrainingController.instance = new OfferTrainingController();
			}
			return OfferTrainingController.instance;
		}

	private Integer id = 1; 
	private TrainingFormBean trainingBean;

	DAO dao = DAO.getInstance();

	public ObservableList<String> getTrainingList(){

		ObservableList<String> trainingList = FXCollections.observableArrayList(dao.getTrainingList());
		return trainingList;
	}

	public ObservableList<String> getTrainerList(){
		ArrayList<String> list = new ArrayList<>();
		Gym g = getGymEntity();
		for(Integer key : g.getTrainers().keySet()) {
			list.add(g.getTrainers().get(key));
		}
		ObservableList<String> trainerList = FXCollections.observableArrayList(list); 
		return trainerList;
	}
	
	

	public Gym getGymEntity(/*user name dynamically gotten*/) {
		Gym gym = dao.getGymEntity(id); //this method is a dummy needs to be implemented
		return gym;
	}
	
	public TrainingFormBean getTrainingBean() {
		return trainingBean;
	}

	public void setTrainingBean(TrainingFormBean trainingBean) {
		this.trainingBean = trainingBean;
	}
}

