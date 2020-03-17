package logic.controller;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import logic.entity.Session;
import logic.factory.viewfactory.ViewType;
import logic.viewcontroller.CardViewController;

public class CardController {
	private final Logger logger = Logger.getLogger(getClass().getName());

	public Parent createCard(Session s) {
		FXMLLoader loader = new FXMLLoader(ViewType.getUrl(ViewType.CARD));
		Parent card = null;
		try {
			card = loader.load();
		} catch (IOException e) {
			logger.log(Level.SEVERE, "unable to create the card\n", e);
		}
		CardViewController controller = loader.getController();
		controller.setDate(s.getDate().toString());
		controller.setGymName(s.getGym().getGymName());
		controller.setDescription(s.getDescription());
		controller.setDuration(s.printDuration(s.getDuration()));
		controller.setSessionName("Session: "+s.getSessionId());
		return card;
	}
}
