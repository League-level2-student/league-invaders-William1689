import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

public class Rocketship extends GameObject {

	boolean movingUp = false;
	boolean movingDown = false;
	boolean movingRight = false;
	boolean movingLeft = false;
	public static BufferedImage image;
	public static boolean needImage = true;
	public static boolean gotImage = false;	
	public Rocketship(int x, int y, int width, int height) {
		super(x, y, width, height);
		speed = 5;
		if (needImage) {
		    loadImage ("SpaceShip.png");
		}

	}

	public void draw(Graphics g) {

	        if (gotImage) {
	        	g.drawImage(image, x, y, width, height, null);
	        } else {
	        	g.setColor(Color.BLUE);
	        	g.fillRect(x, y, width, height);
	        }
	}
	
	@Override
	public void update() {
		// TODO Auto-generated method stub
		super.update();
		
		if(movingUp == true) {
			up();
		}
			if(movingDown == true) {
				down();
				}
			if(movingLeft == true) {
				left(); 
				}
			if(movingRight == true) {
				right();
			}
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
	
	public void right() {
	   if(x<LeagueInvaders.WIDTH-this.width){
		   x+=speed;
	   }
	}
	public void left() {
		if(x>0) {
		    x-=speed;
		}
	
	}
	public void up() {
	   if(y>0) {
		   y-=speed;
	   }
	}
	public void down() {
	    
		if(y<LeagueInvaders.HEIGHT-this.height) {
			y+=speed;
		}
	}
}
