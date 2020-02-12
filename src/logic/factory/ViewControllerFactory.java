package logic.factory;
import java.io.IOException;
import logic.viewcontroller.LoginViewController;
import logic.viewcontroller.MainViewController;

public class ViewControllerFactory {
	private static ViewControllerFactory instance = null;
	private ViewControllerFactory() {
		
	}
	public static synchronized ViewControllerFactory getInstance() throws NullPointerException {
		if(ViewControllerFactory.instance == null) {
			ViewControllerFactory.instance = new ViewControllerFactory();
		}
		return ViewControllerFactory.instance;
	}
	public AbstractViewController createController(int type) throws IOException{
		switch(type) {
		case 0:
			return new LoginViewController();
		case 1:
			return new MainViewController();
		default:
			throw new IOException("ViewControllerFactory exception");
		}
	}
}
