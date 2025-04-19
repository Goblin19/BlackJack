package codingFinalAlt;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import creatingPeople.Players;


//class Game panel extends JPanel
public class GamePanel extends JPanel implements ActionListener{
	//initializing variables
	Players players = new Players("Jasper", "");
	//JSwing elements
	JLabel playerName;
	JLabel score;
	JButton changingPlayerName;
	JScrollPane scrollPane;
	JTextArea text;
	Color color = Color.GREEN;
	public String currentText = " ";
	
	public GamePanel(int gamePanelWidth, int gamePanelHeight) {
		
		this.setPreferredSize(new Dimension(gamePanelWidth, gamePanelHeight));
		this.setBackground(color);
		
		text = new JTextArea(17, 98);
		score = new JLabel("Current score: 0");
		playerName = new JLabel("Araragi");
		changingPlayerName = new JButton("Change name?");
		changingPlayerName.setFocusable(false);
		changingPlayerName.addActionListener(this);
		text.setBackground(Color.LIGHT_GRAY);
		text.setFont(new Font("Lexend", Font.PLAIN, 13));
		text.setForeground(color.blue);
		text.setEditable(false);
		scrollPane = new JScrollPane(text);
		scrollPane.setBounds(501, 351, 498, 349);
		
		this.add(playerName);
		this.add(changingPlayerName);
		this.add(score);
		this.add(scrollPane);
	}
	
	//Overridden Method
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
	
	//Throws Custom Exception and does not crash
	public void changeColor(String S) throws ColorException {
		S = S.toUpperCase();
		if(S.equals("BLUE")) {
			this.setBackground(color.blue);
		}
		else if(S.equals("CYAN")) {
			this.setBackground(color.cyan);
		}else if(S.equals("BLACK")) {
			this.setBackground(color.black);
		}else if(S.equals("GRAY")) {
			this.setBackground(color.gray);
		}else if(S.equals("DARK GRAY")) {
			this.setBackground(color.DARK_GRAY);
		}else if(S.equals("GREEN")) {
			this.setBackground(color.green);
		}else if(S.equals("RED")) {
			this.setBackground(color.red);
		}else if(S.equals("PINK")) {
			this.setBackground(color.pink);
		}else if(S.equals("LIGHT GRAY")) {
			this.setBackground(color.LIGHT_GRAY);
		}else if(S.equals("MAGENTA")) {
			this.setBackground(color.magenta);
		}else if(S.equals("ORANGE")) {
			this.setBackground(color.orange);
		}else if(S.equals("WHITE")) {
			this.setBackground(color.white);
		}else if(S.equals("YELLOW")) {
			this.setBackground(color.yellow);
		}else {
			throw new ColorException();
		}
	}
	
	

}
