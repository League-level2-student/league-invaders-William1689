import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener, KeyListener {
	Timer frameDraw;
	Timer alienSpawn;
	Font textFont;
	Font titleFont;
	final int MENU = 0;
	final int GAME = 1;
	final int END = 2;
	public static BufferedImage image;
	public static boolean needImage = true;
	Rocketship ship = new Rocketship(250, 700, 50, 50);
	int currentState = MENU;
	public static boolean gotImage = false;
	ObjectManager manager;

	public GamePanel() {

		manager = new ObjectManager(ship);
		titleFont = new Font("Arial", Font.PLAIN, 48);
		textFont = new Font("Arial", Font.PLAIN, 20);
		frameDraw = new Timer(1000 / 60, this);
		frameDraw.start();
		if (needImage) {
			loadImage("bg.png");
		}
	}

	public void startGame() {
		alienSpawn = new Timer(90, manager);
		alienSpawn.start();

	}

	void loadImage(String imageFile) {
		if (needImage) {
			try {
				image = ImageIO.read(this.getClass().getResourceAsStream(imageFile));
				gotImage = true;
			} catch (Exception e) {

			}
			needImage = false;
		}
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
		if (ship.isActive == false) {
			currentState = END;
		}
		manager.update();

	}

	void updateEndState() {

	}

	void drawMenuState(Graphics g) {
		g.setColor(Color.BLUE);
		g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);
		g.setFont(titleFont);
		g.setColor(Color.YELLOW);
		g.drawString("Universe Invaders", 105, 100);
		g.setFont(textFont);
		g.drawString("Press enter to begin", 100, 400);
		g.drawString("Press space for instructions", 100, 600);

	}

	void drawGameState(Graphics g) {
		if (gotImage) {
			g.drawImage(image, 0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT, null);
		} else {
			g.setColor(Color.BLACK);
			g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);
		}
		manager.draw(g);

	}

	void drawEndState(Graphics g) {
		g.setColor(Color.RED);
		g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);
		g.setColor(Color.BLACK);
		g.setFont(textFont.deriveFont(300));
		g.drawString(String.valueOf(manager.getScore()), LeagueInvaders.WIDTH / 2, LeagueInvaders.HEIGHT / 2);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub

		repaint();
		if (currentState == MENU) {
			updateMenuState();
		} else if (currentState == GAME) {
			updateGameState();
		} else if (currentState == END) {
			updateEndState();
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			if (currentState == END) {

				ship = new Rocketship(250, 700, 50, 50);
				manager = new ObjectManager(ship);
				currentState = MENU;

			} else {
				currentState++;
				if (currentState == GAME) {
					startGame();
				}

			}
		}
		if (e.getKeyCode() == KeyEvent.VK_UP) {
			ship.movingUp = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			ship.movingDown = true;
		}

		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			ship.movingRight = true;
		}

		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			ship.movingLeft = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_SPACE) {
			manager.addProjectile(ship.getProjectile());
		}

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		if (e.getKeyCode() == KeyEvent.VK_UP) {
			ship.movingUp = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			ship.movingDown = false;
		}

		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			ship.movingRight = false;
		}

		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			ship.movingLeft = false;
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}
}