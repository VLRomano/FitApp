package logic.factory;

public enum SubViewURL {
	LOGIN(0),
	GYMPAGE(1),
	USERPAGE(2),
	OFFERTRAININGFORM(3), 
	BOOKINGFORM(4),
	OFFERTRAININGCONFIRMATION(5);
	/* MAX SUBVIEW DIM: 900 x 542
	 * */
	
	private final int type;
	SubViewURL(int value){
		this.type = value;
	}
	private static SubViewURL getURLItem(int type) {
		for(SubViewURL url : SubViewURL.values()) if(url.type == type) return url;
		throw new IllegalArgumentException("No URL found");
	}
	private static String[] path = {
			"/logic/fxml/Login.fxml",
			"/logic/fxml/GymPage.fxml",
			"/logic/fxml/UserPage.fxml",
			"/logic/fxml/OfferTrainingForm.fxml",
			"/logic/fxml/BookingForm.fxml",
			"/logic/fxml/OfferTrainingConfirmation.fxml"
	};
	public static String getURL(int type) {
		return path[getURLItem(type).type];
	}
}
