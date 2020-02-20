package logic.factory;

import java.io.IOException;


import logic.GymPageSubView;
import logic.LoginView;
import logic.TrainingConfirmationSubView;
import logic.TrainingFormSubView;

public class SubViewFactory {
	private static SubViewFactory instance = null;
	private SubViewFactory() {}
	public static synchronized SubViewFactory getInstance() {
		if(SubViewFactory.instance == null) {
			SubViewFactory.instance = new SubViewFactory();
		}
		return SubViewFactory.instance;
	}
	public AbstractSubView createSubView(int type) throws IOException {
		switch(type) {
		case 0:	// return login
			return new LoginView(type);
		case 1: // return gymPage
			return new GymPageSubView(type);
		case 2: // return userPage
			return new TrainingConfirmationSubView(type);
		case 3: // return offerTraining
			return new TrainingFormSubView(type);
		case 4:
			return new TrainingConfirmationSubView(type);
		default:
			throw new IOException("SubViewFactory exception");
		}
	}
}
