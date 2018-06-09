package cn.tedu.shoot;

import java.awt.image.BufferedImage;
import java.util.Random;

/**
 * 爱心
 * 奖励生命值或火力值
 * 奖励类型
 * */
public class Bee extends FlyingObject implements Award{
	//图片数组
	BufferedImage[]images;
	//切换图片变量
	int index;
	int xSpeed=1;
	int ySpeed=1;
	//奖励类型
	int awardType;
	
	Random random=new Random();
	
	public Bee() {
		image=ShootGame.bee0;
		width=image.getWidth();
		height=image.getHeight();
		x=random.nextInt(ShootGame.WIDTH-this.width);
		y=-this.height;
		awardType=random.nextInt(2);
		images=new BufferedImage[]{
				ShootGame.bee0,ShootGame.bee1,ShootGame.bee2,
				ShootGame.bee3,ShootGame.bee4,ShootGame.bee5,
				ShootGame.bee6,ShootGame.bee7,ShootGame.bee8};
		index=0;
	}

	@Override
	public void step() {
		image=images[index++/18%images.length];
		if(x>ShootGame.WIDTH-this.width||x<0)
			xSpeed=-xSpeed;
		x+=xSpeed;
		y+=ySpeed;
	}

	@Override
	public boolean outOfBounds() {
		return this.y>=ShootGame.HEIGHT;
	}

	@Override
	public int getAwardType() {
		return awardType;
	}

}
