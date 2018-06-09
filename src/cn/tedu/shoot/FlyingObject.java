package cn.tedu.shoot;

import java.awt.image.BufferedImage;

/**飞行物类*/
public abstract class FlyingObject {
	//图片
	public BufferedImage image;
	//宽高
	int width,height;
	//坐标
	int x,y;
	//飞行物的移动方法
	public abstract void step();
	//判断飞行物是否越界
	public abstract boolean outOfBounds();
	
	//判断是否被击中
	public boolean ShootBy(Bullet b){
		int x1=this.x;
		int x2=this.x+this.width;
		int y1=this.y;
		int y2=this.y+this.height;
		int x=b.x;
		int y=b.y;
		return x>x1&&x<x2&&y>y1&&y<y2;
	}
}
