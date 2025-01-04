import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class LeagueInvaders {
	final int MENU = 0;
	final int GAME = 1;
	final int END = 2;
	  int currentState = MENU;
	public static final int WIDTH = 500;
	public static final int HEIGHT = 800;
	JFrame frame;
	GamePanel panel;

	public LeagueInvaders( ) {
		frame = new JFrame();
		panel = new GamePanel();
	}

	public void setup(){
		frame.add(panel);
		frame.setVisible(true);
		frame.setSize(WIDTH, HEIGHT);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public class GamePanel extends JPanel{
		@Override
		public void paintComponent(Graphics g){
			g.fillRect(10, 10, 100, 100);
		}

	}

	void updateMenuState() { 
		
	}
	void updateGameState() { 
		
	}
	 void updateEndState()  {  
		 
	 }




	public static void main(String[] args) {

		LeagueInvaders game = new LeagueInvaders();
		game.setup();
	}
}