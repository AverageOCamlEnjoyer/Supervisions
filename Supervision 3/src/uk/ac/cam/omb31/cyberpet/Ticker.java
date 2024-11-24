package uk.ac.cam.omb31.cyberpet;

import java.util.concurrent.TimeUnit;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.SwingWorker;

public class Ticker extends SwingWorker{
	private Pet myPet;
	private JLabel statsLabel;
	private JLabel imageLabel;
	
	public Ticker(Pet myPet, JLabel statsLabel, JLabel imageLabel) {
		this.myPet = myPet;
		this.statsLabel = statsLabel;
		this.imageLabel = imageLabel;
	}

	@Override
	protected Object doInBackground() throws Exception {
		while (true) {
			if (myPet.alive) {
			myPet.tick();
			statsLabel.setText("Hunger: " + myPet.hunger + " Boredom: " + myPet.boredom + " Tiredness: " + myPet.tiredness);
			TimeUnit.SECONDS.sleep(1);
			} else {
				imageLabel.setIcon(new ImageIcon("./src/uk/ac/cam/omb31/cyberpet/tombstone.png"));
				statsLabel.setText(myPet.deathReason.toUpperCase());
			}
			
		}
	}

}
