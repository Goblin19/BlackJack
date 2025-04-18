package codingFinalAlt;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import creatingPeople.Players;


//class Game panel extends JPanel
public class GamePanel extends JPanel implements ActionListener{
	//initializing variables
	Players players = new Players("Araragi", "");
	JLabel playerName;
	JLabel score;
	JButton changingPlayerName;
	
	public GamePanel(int gamePanelWidth, int gamePanelHeight) {
		
		this.setPreferredSize(new Dimension(gamePanelWidth, gamePanelHeight));
		this.setBackground(Color.GREEN);
		
		score = new JLabel("Current score: 0");
		playerName = new JLabel("Araragi");
		changingPlayerName = new JButton("Change name?");
		changingPlayerName.setFocusable(false);
		changingPlayerName.addActionListener(this);
		
		this.add(playerName);
		this.add(changingPlayerName);
		this.add(score);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		if(source == changingPlayerName) {
			//Using JOption pane to get the player to reset the name
			String firstName = JOptionPane.showInputDialog("enter your first name");
			String lastName = JOptionPane.showInputDialog("enter your last name (leave blank if you don't want to add one)");
			if(lastName.equals(null)) {
				lastName = " ";
			}
			players.setFirstName(firstName);
			players.setLastName(lastName);
			if(lastName != " ") {
				playerName.setText(players.firstName + " " + players.lastName);
			}else {
				playerName.setText(players.firstName);
			}
		}
		
	}
	
	

}
