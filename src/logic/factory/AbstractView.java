package logic.factory;

import java.io.IOException;

import javafx.scene.Parent;

public interface AbstractView {
	public void load() throws IOException;
	public Parent getView();
	public void setView(Parent view);

}
