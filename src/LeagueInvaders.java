import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class LeagueInvaders {
	final int MENU = 0;
	final int GAME = 1;
	final int END = 2;
	int currentState = MENU;
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
		frame.setSize(WIDTH, HEIGHT);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public class GamePanel extends JPanel implements ActionListener {
		Timer frameDraw;
		Font textFont;
		Font titleFont ;
		public GamePanel() {
		    titleFont = new Font("Arial", Font.PLAIN, 48);
		    textFont = new Font("Arial", Font.PLAIN, 20);
		    frameDraw = new Timer(1000/60,this);
		    frameDraw.start();

		}
		public void paintComponent(Graphics g) {
			
			
			g.fillRect(10, 10, 100, 100);
			if (currentState == MENU) {
				drawMenuState(g);
			} else if (currentState == GAME) {
				drawGameState(g);
			} else if (currentState == END) {
				drawEndState(g);
			}
		}



	void updateMenuState() {

	}

	void updateGameState() {

	}

	void updateEndState() {

	}

	void drawMenuState(Graphics g) {
		g.setColor(Color.BLUE);
		g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);
		g.setFont(titleFont);
		g.setColor(Color.YELLOW);
		g.drawString("Shrek Invaders", 125, 100);
		g.setFont(textFont);
		g.drawString("Press enter to begin", 100, 400);
		g.drawString("Press space for instructions", 100, 600);
	}

	void drawGameState(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);
	}

	void drawEndState(Graphics g) {
		g.setColor(Color.RED);
		g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
		repaint();
		if(currentState == MENU){
		    updateMenuState();
		}else if(currentState == GAME){
		    updateGameState();
		}else if(currentState == END){
		    updateEndState();
		}
	}
	}

	public static void main(String[] args) {

		LeagueInvaders game = new LeagueInvaders();
		game.setup();
	}
}