import java.awt.Color;
import java.awt.Graphics;

public class Rocketship extends GameObject {

	boolean movingUp = false;
	boolean movingDown = false;
	boolean movingRight = false;
	boolean movingLeft = false;

	public Rocketship(int x, int y, int width, int height) {
		super(x, y, width, height);
		speed = 5;
	}

	public void draw(Graphics g) {
	      g.setColor(Color.BLUE);
	        g.fillRect(x, y, width, height);
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
