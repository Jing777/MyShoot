package cn.tedu.shoot;

import java.awt.image.BufferedImage;
import java.util.Random;

/**
 * ÏÂ½µµÄboss»ú
 * */
public class Boss2 extends FlyingObject{
	public BufferedImage []images;
	int life=40;
	int xSpeed=1;
	int ySpeed=1;
	int index=0;
	Random random=new Random();
	
	public Boss2() {
		image=ShootGame.boss0;
		width=image.getWidth();
		height=image.getHeight();
		x=random.nextInt(ShootGame.WIDTH-width);
		y=-height-100;
		images=new BufferedImage[]{
				ShootGame.boss0,ShootGame.boss1
		};
	}
	
	public BossBullet[] shoot(){
		int xStep=width/10;
		int yStep=10;
		BossBullet bossbullets[]=new BossBullet[4];
		bossbullets[0]=new BossBullet(x+xStep*2, y+height+yStep);
		bossbullets[1]=new BossBullet(x+xStep*3, y+height+yStep);
		bossbullets[2]=new BossBullet(x+xStep*7, y+height+yStep);
		bossbullets[3]=new BossBullet(x+xStep*8, y+height+yStep);
		return bossbullets;
	}

	@Override
	public void step() {
		image=images[index++/20%images.length];
		if(y<100){
			y+=ySpeed;
		}else{
			if(x>ShootGame.WIDTH-width||x<0)
				xSpeed=-xSpeed;
			x+=xSpeed;
		}
	}

	@Override
	public boolean outOfBounds() {
		return false;
	}

}
