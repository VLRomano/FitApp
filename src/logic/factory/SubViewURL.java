package logic.factory;

public enum SubViewURL {
	OFFERTRAININGFORM(0), 
	BOOKINGFORM(1);
	
	private final int type;
	SubViewURL(int value){
		this.type = value;
	}
	private static SubViewURL getURLItem(int type) {
		for(SubViewURL url : SubViewURL.values()) if(url.type == type) return url;
		throw new IllegalArgumentException("No URL found");
	}
	private static String[] path = {
			"/logic/fxmls/OfferTrainingForm.fxml",
			"/logic/fxmls/BookingForm.fxml",
	};
	public static String getURL(int type) {
		return path[getURLItem(type).type];
	}
}
