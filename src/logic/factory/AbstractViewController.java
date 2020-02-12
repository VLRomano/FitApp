package logic.factory;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javafx.scene.Node;
import javafx.scene.Parent;

public abstract class AbstractViewController {
	//public abstract void load() throws IOException;
	public static List<Node> getAllNodes(Parent p){
		ArrayList<Node> nodes = new ArrayList<>();
		addAllDescendents(p,nodes);
		return nodes;
	}
	private static void addAllDescendents(Parent p, ArrayList<Node> nodes) {
		for (Node n : p.getChildrenUnmodifiable()) {
			nodes.add(n);
			if(n instanceof Parent)
				addAllDescendents((Parent)n,nodes);
		}
	}
	public abstract Parent getView();
	public abstract void setView(Parent view);
}
