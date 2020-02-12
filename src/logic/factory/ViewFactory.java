package logic.factory;

import java.io.IOException;

import logic.LoginView;
import logic.MainView;

public class ViewFactory {
	private static ViewFactory instance = null;
	private ViewFactory() {}
	public static synchronized ViewFactory getInstance() throws NullPointerException {
		if(ViewFactory.instance == null) {
			ViewFactory.instance = new ViewFactory();
		}
		return ViewFactory.instance;
	}
	public AbstractView createView(int type) throws IOException {
		switch(type) {
		case 0:
			return new LoginView();
		case 1: 
			return new MainView();
		default:
			throw new IOException("ViewFactory exception");
		}
	}
}
