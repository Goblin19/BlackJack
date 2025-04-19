package codingFinalAlt;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import Awards.ImageAward;
import creatingPeople.Dealer;
import creatingPeople.Players;
import sounds.Audio;

//Class GameFrame extends JFrame
public class GameFrame extends JFrame implements ActionListener{
	//JSwing Elements
	private JMenuBar menuBar;
	private JMenu menu;
	private JMenuItem Attributions;
	private JMenuItem colorChange;
	private JMenuItem keepGoing;
	private String resetText = "";
	boolean lastRound;
	int count = 0;
	BufferedWriter writer;
	//Instantiating Audio Class
	Audio music = new Audio();
	MenuPanel dealerPanel = new MenuPanel(500, 350);
	GamePanel playerPanel = new GamePanel(500, 350);
	GamePlayLoop playing = new GamePlayLoop();
	ImageAward award = new ImageAward();
	
	public GameFrame(int Width, int Height) {
		
		this.setPreferredSize(new Dimension(Width, Height));
		//Uses a layout Manager
		this.setLayout(new BorderLayout());
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setTitle("Blackjack");
		
		//setup Music
		music.backgroundSound(0);
		
		
		//Menu setting
		menuBar = new JMenuBar();
				
		menu = new JMenu("Gameplay");
				
		Attributions = new JMenuItem("Attributions");
		colorChange = new JMenuItem("Change player color?");
		keepGoing = new JMenuItem("Take turn?");
		Attributions.addActionListener(this);
		colorChange.addActionListener(this);
		keepGoing.addActionListener(this);
		menu.add(colorChange);
		menu.add(keepGoing);
		menu.add(Attributions);
		menuBar.add(menu);
		this.setJMenuBar(menuBar);
		this.add(playerPanel, BorderLayout.SOUTH);
		this.add(dealerPanel, BorderLayout.NORTH);

		this.pack();
		this.setLocationRelativeTo(null);
		this.setVisible(true);	
	}
	
	//Overridden Method
	@Override
	public void actionPerformed(ActionEvent e) {
		//Source of what button has been pressed
		Object Source = e.getSource();
		
		//attributions
		if(Source == Attributions) {
			JOptionPane.showMessageDialog(null, "Funk Lead Loop by ehohnke -- https://freesound.org/s/376416/ -- License: Creative Commons 0");
		}
		//checking which source has been used to be able to judge what to do
		if(Source == keepGoing) {
			if(count == 2) {
				lastRound = true;
			}
			int gameWon = playing.currentTurn(playerPanel.players, dealerPanel.dealer, playerPanel, dealerPanel, lastRound);
			count++;
			if (gameWon == 1) {
				playerPanel.text.setText("Final Score: " + playerPanel.players.scoreToString());
				int keepGoing = JOptionPane.showOptionDialog(null, "Do you want to play again?", "Taking Turn", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, null, null);
				if(keepGoing == 1) {
					fileWriter(playerPanel.players);
					this.dispose();
				}else{
					playerPanel.text.setText(resetText);
					dealerPanel.text.setText(resetText);
					playerPanel.players.setCards(0);
					dealerPanel.dealer.setCards(0);
					playerPanel.players.setScore(0);
					playerPanel.score.setText(playerPanel.players.scoreToString());
					playerPanel.currentText = " ";
					dealerPanel.currentText = " ";
					count = 0;
					lastRound = false;
				}
			}if(gameWon == 2) {
				playerPanel.text.setText(playerPanel.players.scoreToString());
				int keepGoing = JOptionPane.showOptionDialog(null, "Do you want to keep playing?", "Taking Turn", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, null, null);
				if(keepGoing == 1) {
					fileWriter(playerPanel.players);
					this.dispose();
				}else{
					playerPanel.text.setText(resetText);
					dealerPanel.text.setText(resetText);
					playerPanel.players.setCards(0);
					dealerPanel.dealer.setCards(0);
					playerPanel.currentText = " ";
					dealerPanel.currentText = " ";
					count = 0;
					lastRound = false;
				}
			}
		}
		
		if(Source == colorChange) {
			String color = JOptionPane.showInputDialog("What color do you want to change the color to?");
			try {
				playerPanel.changeColor(color);
			} catch (ColorException e1) {
				e1.printStackTrace();
			}
		}
	}
	
	//Writes to a file
	public void fileWriter(Players object) {
		try {
			writer = new BufferedWriter(new FileWriter("FinalScore.txt"));
			if (object.lastName.equals("")) {
				writer.write("Final Score for " + object.firstName +  ": " + object.score);
			}else {
				writer.write("Final Score for " + object.firstName + " " + object.lastName + ": " + object.score);
			}
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}