package cn.tedu.shoot;

import java.awt.image.BufferedImage;
import java.util.Random;

/**
 * 敌机类
 * */
public class AirPlane extends FlyingObject implements Enemy{
	//敌机下移参数
	int ySpeed=2;
	//图片数组
	BufferedImage[]images;
	int index;
	
	Random random=new Random();
	
	public AirPlane() {
		image=ShootGame.flys0;
		width=image.getWidth();
		height=image.getHeight();
		x=random.nextInt(ShootGame.WIDTH-this.width);
		y=-this.height;
		images=new BufferedImage[]{
				ShootGame.flys0,ShootGame.flys1,ShootGame.flys2,
				ShootGame.flys3,ShootGame.flys4,ShootGame.flys5};
		index=0;
	}

	@Override
	public void step() {
		// 图片切换
		image=images[index++/60%images.length];
		// y坐标移动
		y+=ySpeed;
	}

	@Override
	public boolean outOfBounds() {
		return y>=ShootGame.HEIGHT;
	}

}
