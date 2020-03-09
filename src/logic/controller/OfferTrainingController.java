package logic.controller;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import logic.TrainingFormBean;
import logic.dao.GymDAO;
import logic.entity.Gym;
import logic.factory.AbstractSubView;
import logic.factory.SubViewFactory;

public class OfferTrainingController {
	
	private static OfferTrainingController instance = null;

	private OfferTrainingController() {}

		public static synchronized OfferTrainingController getInstance(){
			if(OfferTrainingController.instance == null){
				OfferTrainingController.instance = new OfferTrainingController();
			}
			return OfferTrainingController.instance;
		}
	
	private final Logger logger = Logger.getLogger(getClass().getName());
	MainController ctrl = MainController.getInstance();
	private Integer id = 1; 
	private TrainingFormBean trainingBean;

	GymDAO dao = GymDAO.getInstance();

	public ObservableList<String> getTrainingList(){
		return FXCollections.observableArrayList(dao.getTrainingList());
	}

	public ObservableList<String> getTrainerList(){
		ArrayList<String> list = new ArrayList<>();
		Gym g = getGymEntity();
		for(Integer key : g.getTrainers().keySet()) {
			list.add(g.getTrainers().get(key));
		} 
		return FXCollections.observableArrayList(list); 
	}
	
	public void checkValidity() {
		if(trainingBean.getDate().isBefore(LocalDate.now())) {
			ctrl.showDateAlert();
		}
		else {
			logger.log(Level.INFO, "onto confirmation screen");
			try {
				SubViewFactory factory = SubViewFactory.getInstance();
				AbstractSubView subview = factory.createSubView(5);
				ctrl.replace(MainController.getContainer(), subview);
			} catch (IOException e) {
				logger.log(Level.SEVERE,"Unable to load controller: "+getClass().getName()+"\nException: "+e);
			}
		}
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

