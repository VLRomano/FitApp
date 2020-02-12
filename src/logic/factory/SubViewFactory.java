package logic.factory;

import java.io.IOException;

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
		case 0:
			return new TrainingFormSubView(type);
//		case 1:
//			return new BookingFormSubView();
			default:
				throw new IOException("SubViewFactory exception");
		}
	}
}
