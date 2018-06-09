package cn.tedu.shoot;

import java.awt.image.BufferedImage;

/**
 * Ӣ�ۻ�
 * ͼƬ����
 * �ƶ�
 * �Ƿ�Խ��
 * ����ֵ ����ֵ
 * */
public class Hero extends FlyingObject{
	public BufferedImage[]images;//ͼƬ����
	int index;//�л�ͼƬ�ı���
	int life;
	int doubleFire;
	//�ڹ��췽�����������ֵ
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
	
	//Ӣ�ۻ��������
	public void MoveTo(int x,int y) {
		this.x=x-this.width/2;
		this.y=y-this.height/2;
	}

	//Ӣ�ۼ������ӵ�
	public Bullet[] shoot(){
		int xStep=this.width/6;
		int yStep=10;
		if(doubleFire>0){
			//˫������
			Bullet[]bullets=new Bullet[2];
			bullets[0]=new Bullet(this.x+2*xStep,this.y-yStep);
			bullets[1]=new Bullet(this.x+4*xStep,this.y-yStep);
			doubleFire-=2;
			return bullets;
		}else{
			Bullet[]bullets=new Bullet[1];
			bullets[0]=new Bullet(this.x+3*xStep,this.y-yStep);
			return bullets;
			//��������
			
		}
	}
	@Override
	public void step() {
		//ͼƬ���л�
		image=images[index++/10%images.length];
		
	}

	@Override
	public boolean outOfBounds() {
		//Ӣ�ۻ�����Խ��
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
