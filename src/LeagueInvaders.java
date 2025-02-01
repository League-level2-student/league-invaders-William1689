import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;


public class LeagueInvaders {
	
	public static final int WIDTH = 500;
	public static final int HEIGHT = 800;
	JFrame frame;
	GamePanel panel;

	public LeagueInvaders() {
		frame = new JFrame();
		panel = new GamePanel();
	}

	public void setup() {
		frame.add(panel);
		frame.setVisible(true);
		panel.setPreferredSize(new Dimension(WIDTH, HEIGHT));
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.addKeyListener(panel);
	}



	public static void main(String[] args) {

		LeagueInvaders game = new LeagueInvaders();
		game.setup();
		
	}
}