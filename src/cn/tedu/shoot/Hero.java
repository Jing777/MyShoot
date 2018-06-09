package cn.tedu.shoot;

import java.awt.image.BufferedImage;

/**
 * 英雄机
 * 图片数组
 * 移动
 * 是否越界
 * 生命值 火力值
 * */
public class Hero extends FlyingObject{
	public BufferedImage[]images;//图片数组
	int index;//切换图片的变量
	int life;
	int doubleFire;
	//在构造方法里给变量赋值
	public Hero() {
		image=ShootGame.hero0;
		width=image.getWidth();
		height=image.getHeight();
		x=200;
		y=500;
		index=0;
		life=3;
		doubleFire=0;
		images=new BufferedImage[]{
				ShootGame.hero0,ShootGame.hero1,ShootGame.hero2,
				ShootGame.hero3,ShootGame.hero4,ShootGame.hero5,
				ShootGame.hero6,ShootGame.hero7,ShootGame.hero8,
				ShootGame.hero9
		};
	}
	
	//英雄机跟随鼠标
	public void MoveTo(int x,int y) {
		this.x=x-this.width/2;
		this.y=y-this.height/2;
	}

	//英雄级发射子弹
	public Bullet[] shoot(){
		int xStep=this.width/6;
		int yStep=10;
		if(doubleFire>0){
			//双倍火力
			Bullet[]bullets=new Bullet[2];
			bullets[0]=new Bullet(this.x+2*xStep,this.y-yStep);
			bullets[1]=new Bullet(this.x+4*xStep,this.y-yStep);
			doubleFire-=2;
			return bullets;
		}else{
			Bullet[]bullets=new Bullet[1];
			bullets[0]=new Bullet(this.x+3*xStep,this.y-yStep);
			return bullets;
			//单倍火力
			
		}
	}
	@Override
	public void step() {
		//图片的切换
		image=images[index++/10%images.length];
		
	}

	@Override
	public boolean outOfBounds() {
		//英雄机永不越界
		return false;
	}
	
	public boolean hit(FlyingObject obj){
		int x1=obj.x-this.width/2+10;
		int x2=obj.x+this.width/2+obj.width-10;
		int y1=obj.y-this.height/2+10;
		int y2=obj.y+this.height/2+obj.height-10;
		int x=this.x+this.width/2;
		int y=this.y+this.height/2;
		return x>x1&&x<x2&&y>y1&&y<y2;
	}

}
