package cn.tedu.shoot;

import java.awt.image.BufferedImage;
import java.util.Random;

/**
 * boss机由下往上
 * */
public class Boss1 extends FlyingObject{
	public BufferedImage[]images;
	Random random=new Random();
	int ySpeed=2;
	int index=0;
	
	public Boss1() {
		image=ShootGame.bosss0;
		width=image.getWidth();
		height=image.getHeight();
		x=random.nextInt(ShootGame.WIDTH-width);
		y=ShootGame.HEIGHT-80;
		images=new BufferedImage[]{
				ShootGame.bosss0,ShootGame.bosss1
				};
	}

	@Override
	public void step() {
		image=images[index++/20%images.length];
		this.y-=ySpeed;
	}
	@Override
	public boolean outOfBounds() {
		return this.y<-this.height;
	}
}
