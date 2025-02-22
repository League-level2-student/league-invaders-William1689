import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public class ObjectManager implements ActionListener
 {
	Rocketship rocket;
	ArrayList <Projectile> projectiles;
	ArrayList <Alien> aliens;
	Random random = new Random();
	public ObjectManager (Rocketship rocket) {
		this.rocket = rocket;
		this.projectiles = new ArrayList<Projectile>();
		this.aliens = new ArrayList<Alien>();
	}
	
	public void addProjectile(Projectile projectile) {
		projectiles.add(projectile);
	}
	public void addAlien() {
		aliens.add(new Alien(random.nextInt(LeagueInvaders.WIDTH),-50,50,50));
	}
	public void update() {
		for(int i = 0; i<aliens.size();i++) {
			Alien a = aliens.get(i);
			a.update();
			if(a.y>LeagueInvaders.HEIGHT) {
				a.isActive = false;
			}
		}
		for(int i = 0; i<projectiles.size();i++) {
			Projectile p = projectiles.get(i);
			p.update();
			if(p.y<0) {
				p.isActive = false;
			}
		}
rocket.update();
	}

	public void draw(Graphics g) {
		rocket.draw(g);
		for(int i = 0; i<aliens.size();i++) {
			aliens.get(i).draw(g);
		}
		for(int i = 0; i<projectiles.size();i++) {
			projectiles.get(i).draw(g);
		}
	}
	public void purgeObjects() {
		Iterator<Alien> iter = aliens.iterator();
		while(iter.hasNext()) {
			Alien a = iter.next();
			if(!a.isActive) {
				iter.remove();
			}
	
		}
		Iterator<Projectile> iters = projectiles.iterator();
		while(iters.hasNext()) {
			Projectile b = iters.next();
			if(!b.isActive) {
				iters.remove();
			}
	
		}
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		addAlien();
	}

}





