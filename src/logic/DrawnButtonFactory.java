package logic;

public class DrawnButtonFactory {

	//use getButton method to get object of type button
	public DrawnButton getButton(String type) {
		if(type == null) {
			return null;
		}
		if(type.equalsIgnoreCase("PLAY")) {
			return new PlayButton();
		}
		else if(type.equalsIgnoreCase("BACK")) {
			return new BackButton();
		}
		else if(type.equalsIgnoreCase("SETTINGS")) {
			return new SettingsButton();
		}
		else if(type.equalsIgnoreCase("SCORES")) {
			return new ScoreButton();
		}
		else if(type.equalsIgnoreCase("CREDITS")) {
			return new CreditsButton();
		}
		else if(type.equalsIgnoreCase("PAUSE")) {
			return new PauseButton();
		}
		return null;
	}
}
