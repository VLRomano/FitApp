package logic;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import logic.factory.AbstractSubView;
import logic.factory.SubViewURL;

public class UserPageSubView implements AbstractSubView {
	private Parent root;
	private final Logger logger = Logger.getLogger(getClass().getName());
	public UserPageSubView(int type) {
		try {
			load(type);
		} catch (IOException gympageEx) {
			logger.log(Level.SEVERE,"Unable to load controller: "+getClass().getName()+"\nException: "+gympageEx);
		}
	}
	@Override
	public void load(int type) throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource(SubViewURL.getViewByType(type)));
		setRoot(loader.load());
	}
	@Override
	public Parent getRoot() {
		return this.root;
	}
	@Override
	public void setRoot(Parent root) {
		this.root = root;
	}
}
