package codingFinalAlt;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import creatingPeople.Dealer;
import creatingPeople.Players;

//Class GameFrame extends JFrame
public class GameFrame extends JFrame implements ActionListener{
	private String[] responses = {"Hit me!", "Stand"};
	private String Action;
	private JMenuBar menuBar;
	private JMenu menu;
	private JMenuItem colorChange;
	private JMenuItem keepGoing;
	private String resetText = "";
	MenuPanel dealerPanel = new MenuPanel(500, 350);
	GamePanel playerPanel = new GamePanel(500, 350);
	GamePlayLoop playing = new GamePlayLoop();
	
	public GameFrame(int Width, int Height) {
		
		this.setPreferredSize(new Dimension(Width, Height));
		this.setLayout(new BorderLayout());
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setTitle("Blackjack");
		
		//Menu setting
		menuBar = new JMenuBar();
				
		menu = new JMenu("Gameplay");
				
		colorChange = new JMenuItem("Change player color?");
		keepGoing = new JMenuItem("Take turn?");
		colorChange.addActionListener(this);
		keepGoing.addActionListener(this);
		menu.add(colorChange);
		menu.add(keepGoing);
		menuBar.add(menu);
		this.setJMenuBar(menuBar);
		this.add(playerPanel, BorderLayout.SOUTH);
		this.add(dealerPanel, BorderLayout.NORTH);

		this.pack();
		this.setLocationRelativeTo(null);
		this.setVisible(true);	
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		//Source of what button has been pressed
		Object Source = e.getSource();
		
		//checking which source has been used to be able to judge what to do
		if(Source == keepGoing) {
			int actionChosen = JOptionPane.showOptionDialog(null, "Hit me or Stand", "Taking Turn", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, responses, null);
			if(actionChosen == 0) {
				Action = "hitme";
			}else {
				Action = "stand";
			}
			int gameWon = playing.currentTurn(playerPanel.players, dealerPanel.dealer, playerPanel, dealerPanel, Action);
			if (gameWon == 1) {
				playerPanel.text.setText("Final Score: " + playerPanel.players.scoreToString());
				int keepGoing = JOptionPane.showOptionDialog(null, "Do you want to play again?", "Taking Turn", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, null, null);
				if(keepGoing == 1) {
					this.dispose();
				}else{
					playerPanel.text.setText(resetText);
					dealerPanel.text.setText(resetText);
					playerPanel.players.setCards(0);
					dealerPanel.dealer.setCards(0);
					playerPanel.players.setScore(0);
					playerPanel.currentText = " ";
					dealerPanel.currentText = " ";
				}
			}if(gameWon == 2) {
				playerPanel.text.setText("Current Score: " + playerPanel.players.scoreToString());
				int keepGoing = JOptionPane.showOptionDialog(null, "Do you want to keep playing?", "Taking Turn", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, null, null);
				if(keepGoing == 1) {
					this.dispose();
				}else{
					playerPanel.text.setText(resetText);
					dealerPanel.text.setText(resetText);
					playerPanel.players.setCards(0);
					dealerPanel.dealer.setCards(0);
					playerPanel.currentText = " ";
					dealerPanel.currentText = " ";
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
}