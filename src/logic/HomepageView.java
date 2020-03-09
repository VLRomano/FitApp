package logic;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import logic.factory.AbstractSubView;
import logic.factory.SubViewURL;

public class HomepageView implements AbstractSubView {
	private Parent root;
	private Scene homepageScene;
	public Scene gethomepageScene() {
		return homepageScene;
	}
	public void setHompageScene(Scene homepageScene) {
		this.homepageScene = homepageScene;
	}
	@Override
	public Parent getRoot() {
		return root;
	}
	@Override
	public void setRoot(Parent root) {
		this.root = root;
	}

	private final Logger logger = Logger.getLogger(getClass().getName());
	
	public HomepageView(int type) {
		try {
			load(type);
		} catch (IOException e) {
			logger.log(Level.SEVERE,"Unable to load controller: "+getClass().getName()+"\nException: "+e);
		}
	}
	@Override
	public void load(int type) throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource(SubViewURL.getViewByType(type)));
		setRoot(loader.load());
	}
}