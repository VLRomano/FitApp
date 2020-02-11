package logic.viewcontroller;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import logic.factory.AbstractViewController;
import logic.fxmlcontrollers.MainActivityController;

public class MainActivityViewController extends AbstractViewController{
	private MainActivityController controller;
	private static MainActivityViewController instance = null;
	private Parent view;
	private final Logger logger = Logger.getLogger(getClass().getName());

	private MainActivityViewController() throws IOException {
		try{ 
			load();
		} catch (IOException e) {
			logger.log(Level.SEVERE,"Unable to load controller: "+getClass().getName()+"\nException: "+e);
		}
	}
	@Override
	public void load() throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/logic/fxmls/Container.fxml"));
		view = loader.load();
		this.setController(loader.getController());
	}
	public static synchronized  MainActivityViewController getInstance() throws IOException{
		if(MainActivityViewController.instance == null){
			MainActivityViewController.instance = new MainActivityViewController();
		}
		return MainActivityViewController.instance;
	}
	@Override
	public Parent getView() {
		return view ;
	}
	public MainActivityController getController() {
		return this.controller;
	}
	public void setController(MainActivityController controller) {
		this.controller = controller;
	}
	@Override
	public void setView(Parent view) {
		this.view = view;
	}

}