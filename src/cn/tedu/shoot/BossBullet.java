package cn.tedu.shoot;

import java.awt.image.BufferedImage;

/**
 * boss»ú×Óµ¯
 * */
public class BossBullet extends FlyingObject{
	public BufferedImage[]images;
	int index=0;
	int ySteep=2;
	public BossBullet(int x,int y) {
		image=ShootGame.bossbullet0;
		width=image.getWidth();
		height=image.getHeight();
		this.x=x;
		this.y=y;
		images=new BufferedImage[]{
				ShootGame.bossbullet0,ShootGame.bossbullet1
		};
	}

	@Override
	public void step() {
		image=images[index++/20%images.length];
		y+=ySteep;
	}

	@Override
	public boolean outOfBounds() {
		return y>ShootGame.HEIGHT;
	}

}
