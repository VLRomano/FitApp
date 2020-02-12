package logic.factory;

import java.io.IOException;

import javafx.scene.Parent;

public interface AbstractSubView {
	public void load(int type) throws IOException;
	public Parent getRoot();
	public void setRoot(Parent root);
}
