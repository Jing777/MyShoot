package cn.tedu.shoot;
/**
 * Ó¢ÐÛ»ú×Óµ¯
 * */
public class Bullet extends FlyingObject{
	int ySpeed=2;
	public Bullet(int x,int y) {
		image=ShootGame.bullet;
		width=image.getWidth();
		height=image.getHeight();
		this.x=x;
		this.y=y;
	}

	@Override
	public void step() {
		y-=ySpeed;
	}

	@Override
	public boolean outOfBounds() {
		// TODO Auto-generated method stub
		return this.y<=-this.height;
	}

}
