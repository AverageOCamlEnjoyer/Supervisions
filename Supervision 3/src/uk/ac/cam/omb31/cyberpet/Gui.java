package uk.ac.cam.omb31.cyberpet;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Gui {
	private JFrame frame;
	public Pet myPet = new Pet();
	private String petImageNumber = "00";
	
	public void setup() {
	    frame = new JFrame("Cyber Pet");
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setSize(600, 300);
	    frame.setLayout(new GridBagLayout());
	    frame.setLocationRelativeTo(null);
	    GridBagConstraints c = new GridBagConstraints();
	    c.insets = new Insets(3, 3, 3, 3);
	    c.fill = GridBagConstraints.HORIZONTAL;

	    // Pet selector
	    c.gridx = 0;
	    c.gridy = 0;
	    c.gridwidth = 2;
	    c.weightx = 1.0;
	    c.ipadx = 0;
	    c.ipady = 0;
	    String[] pets = {"Tiny Chick", "Stinky Skunk", "Slow Turtle", "Clucking Chicken", "Spikey Porcupine", "Leaping Frog"};
	    JComboBox<String> selector = new JComboBox<>(pets);
	    frame.add(selector, c);
	    
	    // Pet image
	    c.gridx = 0;
	    c.gridy = 1;
	    c.gridwidth = 3;
	    c.weightx = 1.0;
	    c.ipadx = 10;
	    c.ipady = 10;
	    ImageIcon image = new ImageIcon("./src/uk/ac/cam/omb31/cyberpet/" + petImageNumber + ".png");
	    JLabel imageLabel = new JLabel(image);
	    frame.add(imageLabel, c);
	    
	    // Display Pet's stats
	    c.gridx = 0;
	    c.gridy = 4;
	    c.gridwidth = 3;
	    c.weightx = 1.0;
	    c.ipadx = 0;
	    c.ipady = 0;
	    JLabel statsLabel = new JLabel("Hunger: " + myPet.hunger + " Boredom: " + myPet.boredom + " Tiredness: " + myPet.tiredness);
	    frame.add(statsLabel, c);
	    
	    
	    // Submit button for pet type
	    c.gridx = 2;
	    c.gridy = 0;
	    c.gridwidth = 1;
	    c.weightx = 0.5;
	    c.ipadx = 0;
	    c.ipady = 0;
	    JButton submitType = new JButton("Submit");
	    submitType.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	            int index = selector.getSelectedIndex();
	            int first = index / 3;
	            int second = index % 3;
	            petImageNumber = String.valueOf(first) + String.valueOf(second);
	            imageLabel.setIcon(new ImageIcon("./src/uk/ac/cam/omb31/cyberpet/" + petImageNumber + ".png"));
	    	    //Begin the ticker
	            myPet = new Pet();
	    	    new Ticker(myPet,statsLabel,imageLabel).execute();
	        }
	    });
	    frame.add(submitType, c);



	    // Pet name label
	    c.gridx = 0;
	    c.gridy = 2;
	    c.gridwidth = 1;
	    c.weightx = 0.5;
	    c.ipadx = 0;
	    c.ipady = 0;
	    JLabel nameLabel = new JLabel("Enter Pet Name:");
	    frame.add(nameLabel, c);

	    // Pet speak label
	    c.gridx = 1;
	    c.gridy = 2;
	    c.gridwidth = 2;
	    c.weightx = 1.0;
	    c.ipadx = 10;
	    c.ipady = 10;
	    JLabel petSpeak = new JLabel("What is my name?");
	    frame.add(petSpeak, c);

	    // Pet name input box
	    c.gridx = 0;
	    c.gridy = 3;
	    c.gridwidth = 2;
	    c.weightx = 1.0;
	    c.ipadx = 0;
	    c.ipady = 0;
	    JTextField nameBox = new JTextField();
	    frame.add(nameBox, c);

	    // Submit button for pet name
	    c.gridx = 2;
	    c.gridy = 3;
	    c.gridwidth = 1;
	    c.weightx = 0.5;
	    c.ipadx = 0;
	    c.ipady = 0;
	    JButton submit = new JButton("Enter");
	    submit.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	            String petName = nameBox.getText();
	            myPet.name = petName;
	            petSpeak.setText("My name is " + myPet.name);
	            nameBox.setText(null);
	        }
	    });
	    frame.add(submit, c);

	    // Feed button
	    c.gridx = 0;
	    c.gridy = 5;
	    c.gridwidth = 1;
	    c.weightx = 0.33;
	    c.ipadx = 10;
	    c.ipady = 5;
	    JButton feed = new JButton("Feed");
	    feed.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	            myPet.feed();
	            statsLabel.setText("Hunger: " + myPet.hunger + " Boredom: " + myPet.boredom + " Tiredness: " + myPet.tiredness);
	        }
	    });
	    frame.add(feed, c);

	    // Play button
	    c.gridx = 1;
	    c.gridy = 5;
	    c.gridwidth = 1;
	    c.weightx = 0.33;
	    JButton play = new JButton("Play");
	    play.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	            myPet.play();
	            statsLabel.setText("Hunger: " + myPet.hunger + " Boredom: " + myPet.boredom + " Tiredness: " + myPet.tiredness);
	        }
	    });
	    frame.add(play, c);

	    // Sleep button
	    c.gridx = 2;
	    c.gridy = 5;
	    c.gridwidth = 1;
	    c.weightx = 0.33;
	    JButton sleep = new JButton("Sleep");
	    sleep.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	            myPet.sleep();
	            statsLabel.setText("Hunger: " + myPet.hunger + " Boredom: " + myPet.boredom + " Tiredness: " + myPet.tiredness);
	        }
	    });
	    frame.add(sleep, c);
	    
	    frame.setVisible(true);
	}
}
