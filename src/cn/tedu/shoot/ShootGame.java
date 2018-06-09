package cn.tedu.shoot;



import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Arrays;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class ShootGame extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final int WIDTH=512;
	public static final int HEIGHT=768;
	//程序的几重状态
	public static final int START=0;//启动状态
	public static final int RUNNING=1;//
	public static final int PAUSE=2;//暂停状态
	public static final int GAME_OVER=3;//结束状态
	//当前状态
	public int state=START;
	//声明背景图片的变量
	public static BufferedImage background;
	public static BufferedImage hero0;      //英雄机0
	public static BufferedImage hero1;		//英雄机1
	public static BufferedImage hero2;
	public static BufferedImage hero3;
	public static BufferedImage hero4;
	public static BufferedImage hero5;
	public static BufferedImage hero6;
	public static BufferedImage hero7;
	public static BufferedImage hero8;
	public static BufferedImage hero9;
	public static BufferedImage flys0;   //敌机      
	public static BufferedImage flys1;
	public static BufferedImage flys2;
	public static BufferedImage flys3;
	public static BufferedImage flys4;
	public static BufferedImage flys5;
	public static BufferedImage bee0; //小蜜蜂
	public static BufferedImage bee1;
	public static BufferedImage bee2;
	public static BufferedImage bee3;
	public static BufferedImage bee4;
	public static BufferedImage bee5;
	public static BufferedImage bee6;
	public static BufferedImage bee7;
	public static BufferedImage bee8;
	public static BufferedImage start;      //启动图
	public static BufferedImage bullet;
	public static BufferedImage boss0;
	public static BufferedImage boss1;
	public static BufferedImage bosss0;
	public static BufferedImage bosss1;
	public static BufferedImage bossbullet0;//boss子弹
	public static BufferedImage bossbullet1;
	public static BufferedImage gg;
	public static BufferedImage jj;
	public static BufferedImage blife1;//boss血条
	public static BufferedImage blife2;
	public static BufferedImage blife3;
	public static BufferedImage blife4;
	public static BufferedImage blife5;
	public static BufferedImage blife6;
	public static BufferedImage blife7;
	public static BufferedImage blife8;
	public static BufferedImage blife9;
	public static BufferedImage blife10;
	
	//创建英雄机对象
	Hero hero=new Hero();
	//创建敌机对象数组
	FlyingObject[] flyings={};
	Bullet[] bullets={};
	int score=0;
	Boss1[] bossUp={};
	Boss2[] bossDown={};
	BossBullet[] bossbulets={};
	int stage=1;
	int level=1;
	int level_=level;
	
	static{
		try {
			background=ImageIO.read(ShootGame.class.getResource("background.jpg"));
			hero0 = ImageIO.read(ShootGame.class.getResource("ws00.png"));
			hero1 = ImageIO.read(ShootGame.class.getResource("ws01.png"));
			hero2 = ImageIO.read(ShootGame.class.getResource("ws02.png"));
			hero3 = ImageIO.read(ShootGame.class.getResource("ws03.png"));
			hero4 = ImageIO.read(ShootGame.class.getResource("ws04.png"));
			hero5 = ImageIO.read(ShootGame.class.getResource("ws05.png"));
			hero6 = ImageIO.read(ShootGame.class.getResource("ws06.png"));
			hero7 = ImageIO.read(ShootGame.class.getResource("ws07.png"));
			hero8 = ImageIO.read(ShootGame.class.getResource("ws08.png"));
			hero9 = ImageIO.read(ShootGame.class.getResource("ws09.png"));
			flys0 = ImageIO.read(ShootGame.class.getResource("flys0.png"));
			flys1 = ImageIO.read(ShootGame.class.getResource("flys1.png"));
			flys2 = ImageIO.read(ShootGame.class.getResource("flys2.png"));
			flys3 = ImageIO.read(ShootGame.class.getResource("flys3.png"));
			flys4 = ImageIO.read(ShootGame.class.getResource("flys4.png"));
			flys5 = ImageIO.read(ShootGame.class.getResource("flys5.png"));
			bee0 = ImageIO.read(ShootGame.class.getResource("qq00.png"));
			bee1 = ImageIO.read(ShootGame.class.getResource("qq01.png"));
			bee2 = ImageIO.read(ShootGame.class.getResource("qq02.png"));
			bee3 = ImageIO.read(ShootGame.class.getResource("qq03.png"));
			bee4 = ImageIO.read(ShootGame.class.getResource("qq04.png"));
			bee5 = ImageIO.read(ShootGame.class.getResource("qq05.png"));
			bee6 = ImageIO.read(ShootGame.class.getResource("qq06.png"));
			bee7 = ImageIO.read(ShootGame.class.getResource("qq07.png"));
			bee8 = ImageIO.read(ShootGame.class.getResource("qq08.png"));
			start = ImageIO.read(ShootGame.class.getResource("start.jpg"));
			bullet = ImageIO.read(ShootGame.class.getResource("bullets.png"));
			boss0 = ImageIO.read(ShootGame.class.getResource("boss0.png"));
			boss1 = ImageIO.read(ShootGame.class.getResource("boss1.png"));
			bosss0 = ImageIO.read(ShootGame.class.getResource("bosss0.png"));
			bosss1 = ImageIO.read(ShootGame.class.getResource("bosss1.png"));
			bossbullet0 = ImageIO.read(ShootGame.class.getResource("bossbu0.png"));
			bossbullet1 = ImageIO.read(ShootGame.class.getResource("bossbu1.png"));
			gg = ImageIO.read(ShootGame.class.getResource("gg.png"));
			jj = ImageIO.read(ShootGame.class.getResource("jj.png"));
			blife1 = ImageIO.read(ShootGame.class.getResource("blife1.jpg"));
			blife2 = ImageIO.read(ShootGame.class.getResource("blife2.jpg"));
			blife3 = ImageIO.read(ShootGame.class.getResource("blife3.jpg"));
			blife4 = ImageIO.read(ShootGame.class.getResource("blife4.jpg"));
			blife5 = ImageIO.read(ShootGame.class.getResource("blife5.jpg"));
			blife6 = ImageIO.read(ShootGame.class.getResource("blife6.jpg"));
			blife7 = ImageIO.read(ShootGame.class.getResource("blife7.jpg"));
			blife8 = ImageIO.read(ShootGame.class.getResource("blife8.jpg"));
			blife9 = ImageIO.read(ShootGame.class.getResource("blife9.jpg"));
			blife10 = ImageIO.read(ShootGame.class.getResource("blife10.jpg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//飞行物入场方法
	int flyingIndex=0;
	public void EnteredAction(){
		flyingIndex++;
		if(flyingIndex %80/level_==0){
			FlyingObject one= nextOne();//提取生成的一个飞机
			//给飞行物数组flyings扩容
			flyings=Arrays.copyOf(flyings, flyings.length+1);//给数组扩容，每次一个单位
			flyings[flyings.length-1]=one;
		}
		//生成子弹
		if(flyingIndex %30==0){
			Bullet[] bs=hero.shoot();
			bullets=Arrays.copyOf(bullets, bullets.length+bs.length);//给数组扩容，每次一个单位
			if(bs.length<=1){
				System.arraycopy(bs, 0, bullets, bullets.length-1, 1);
			}else{
				System.arraycopy(bs, 0, bullets, bullets.length-2, 2);
			}
		}
		//生成一个boss上升机
		if(flyingIndex %2000==0){
			bossUp=Arrays.copyOf(bossUp, bossUp.length+1);
			bossUp[bossUp.length-1]=new Boss1();
		}
		//boss上升机越界删除，生成下降机
		for(int i=0;i<bossUp.length;i++){
			if(bossUp[i].outOfBounds()){
				bossUp[i]=bossUp[bossUp.length-1];
				bossUp=Arrays.copyOf(bossUp, bossUp.length-1);
				bossDown=Arrays.copyOf(bossDown, bossDown.length+1);
				bossDown[bossDown.length-1]=new Boss2();
			}
		}
		//生成boss子弹
		if(flyingIndex %200==0){
			for(int i=0;i<bossDown.length;i++){
				BossBullet [] bbs=bossDown[i].shoot();
				bossbulets=Arrays.copyOf(bossbulets, bossbulets.length+4);
				System.arraycopy(bbs, 0, bossbulets, bossbulets.length-4, 4);
			}
		}
	}
	
	//生成一个敌机
	public FlyingObject nextOne(){
		Random random=new Random();
		int num=random.nextInt(20);
		if(num>=18){
			return new Bee();
		}else{
			return new AirPlane();
		}
	}
	
	//飞行物移动方法
	public void stepAction(){
		hero.step();
		for(int i=0;i<flyings.length;i++){
			flyings[i].step();
		}
		for(int i=0;i<bullets.length;i++){
			bullets[i].step();
		}
		for(int i=0;i<bossUp.length;i++){
			bossUp[i].step();
		}
		for(int i=0;i<bossDown.length;i++){
			bossDown[i].step();
		}
		for(int i=0;i<bossbulets.length;i++){
			bossbulets[i].step();
		}
	}
	
	//敌机击中英雄机
	private void hitAction() {
		for(int i=0;i<flyings.length;i++){
			if(hero.hit(flyings[i])){
				hit(flyings[i],i,1);//撞击敌机
			}
		}
		for(int i=0;i<bossbulets.length;i++){
			FlyingObject f=(FlyingObject)bossbulets[i];
			if(hero.hit(f)){
				hit(f,i,2);//撞击子弹
			}
		}
	}
	
	//英雄机被敌机击中
	public void hit(FlyingObject obj,int index3,int type){
		if(hero.hit(obj)){
			int index=index3;
			hero.life--;
			//删除敌机
			if(type==1){
				FlyingObject t;
				t=flyings[flyings.length-1];
				flyings[flyings.length-1]=flyings[index];
				flyings[index]=t;
				flyings=Arrays.copyOf(flyings, flyings.length-1);
			}
			//删除子弹
			if(type==2){
				bossbulets[index]=bossbulets[bossbulets.length-1];
				bossbulets=Arrays.copyOf(bossbulets, bossbulets.length-1);
			}
			if(hero.life<=0){
				state=GAME_OVER;
			}
		}
	} 
	
	//子弹击中敌机处理方法
	private void bangAction() {
		for(int i=0;i<bullets.length;i++){
			bang(bullets[i],i);
		}
	}
	
	//一个子弹击中敌机的处理方法
	public void bang(Bullet b,int index2){
		int type=0;
		int index=-1;
		//判断敌机有没有被该子弹击中，击中取出敌机坐标
		for(int i=0;i<flyings.length;i++){
			if(flyings[i].ShootBy(b)){
				index=i;
				type=1;
				break;
			}
		}
		//判断击中boss机
		for(int i=0;i<bossDown.length;i++){
			if(bossDown[i].ShootBy(b)){
				index=i;
				type=2;
				break;
			}
		}
		//如果击中，进行处理
		if(index!=-1){
			//删除子弹
			bullets[index2]=bullets[bullets.length-1];
			bullets=Arrays.copyOf(bullets,bullets.length-1);
			if(type==1){
				FlyingObject one=flyings[index];//获取被击中的敌机
				if(one instanceof Enemy){//是airplane
					score+=5;
				}
				if(one instanceof Award){
					Bee bee=(Bee)one;
					int Atype=bee.getAwardType();
					if(Atype==Award.DOUBLE_FIRE){
						//增加火力值
						hero.doubleFire+=40;
					}
					if(Atype==Award.LIFE && hero.life<5){
						//增加生命值
						hero.life++;
					}
				}
				//删除敌机
				FlyingObject t;
				t=flyings[flyings.length-1];
				flyings[flyings.length-1]=flyings[index];
				flyings[index]=t;
				flyings=Arrays.copyOf(flyings, flyings.length-1);
			}
			if(type==2){
				bossDown[index].life--;
				if(bossDown[index].life<=0){
					bossDown[index]=bossDown[bossDown.length-1];
					bossDown=Arrays.copyOf(bossDown, bossDown.length-1);
					stage++;
				}
			}
		}
	}
	
	/**程序执行方法*/
	private void action() {
		//鼠标事件监听
		MouseAdapter m=new MouseAdapter() {
			//鼠标点击事件
			@Override
			public void mouseClicked(MouseEvent e) {
				if(state==START){
					state=RUNNING;
					level_=level;
				}
				if(state==GAME_OVER){
					state=START;
					//清空数据
					hero=new Hero();
					stage=1;
					score=0;
					flyings=new FlyingObject[]{};
					bossUp=new Boss1[]{};
					bossDown=new Boss2[]{};
					bossbulets=new BossBullet[]{};
					}
			}
			//鼠标移动时间
			@Override
			public void mouseMoved(MouseEvent e) {
				if(state==RUNNING){
					int x=e.getX();
					int y=e.getY();//获取鼠标坐标
					hero.MoveTo(x,y);
				}
			}
			//鼠标移出事件
			@Override
			public void mouseExited(MouseEvent e) {
				if(state==RUNNING){
					state=PAUSE;
				}
			}
			//鼠标移入事件
			@Override
			public void mouseEntered(MouseEvent e) {
				if(state==PAUSE){
					state=RUNNING;
				}
			}
			public void mouseWheelMoved(MouseWheelEvent e){
				int dir=e.getWheelRotation();
				//down
				if(dir==1){
					level=level%3+1;
				}
				//up
				if(dir==-1){
					level--;
					level=(level+2)%3+1;
				}
			}
		};
		
		//添加鼠标事件监听
		this.addMouseListener(m);
		this.addMouseMotionListener(m);
		this.addMouseWheelListener(m);
		// 计时器
		Timer timer=new Timer();
		int interval=10;
		timer.schedule(new TimerTask() {
			
			@Override
			public void run() {
				if(state==RUNNING){
					EnteredAction();
					stepAction();
					bangAction();
					hitAction();
				}
				repaint();//
			}
		}, interval, interval);
	}
	
	//清除越界
	public void outOfBounds(){
		for(int i=0;i<flyings.length;i++){
			if(flyings[i].y>HEIGHT){
				flyings[i]=flyings[flyings.length-1];
				flyings=Arrays.copyOf(flyings, flyings.length-1);
			}
		}
		for(int i=0;i<bullets.length;i++){
			if(bullets[i].outOfBounds()){
				bullets[i]=bullets[bullets.length-1];
				bullets=Arrays.copyOf(bullets, bullets.length-1);
			}
		}
		for(int i=0;i<bossbulets.length;i++){
			if(bossbulets[i].outOfBounds()){
				bossbulets[i]=bossbulets[bossbulets.length-1];
				bossbulets=Arrays.copyOf(bossbulets, bossbulets.length-1);
			}
		}
	}
	
	int a=0;
	int b=0;
	//绘制方法
	@Override
	public void paint(Graphics g) {
		if(state==RUNNING){
			//绘制背景
			a++;
			g.drawImage(background,0, a, null);
			g.drawImage(background, 0, -background.getHeight()+a,null);
			if(a== background.getHeight()){
				a=0;
			}
			//绘制英雄机
			g.drawImage(hero.image, hero.x,hero.y,null);
			//清除越界
			outOfBounds();
			//绘制敌机
			for(int i=0;i<flyings.length;i++){
				FlyingObject f=flyings[i];
				g.drawImage(f.image, f.x,f.y, null);
			}
			//绘制子弹
			for(int i=0;i<bullets.length;i++){
				Bullet b=bullets[i];
				g.drawImage(b.image,b.x,b.y,null);
			}
			//绘制boss上升
			for(int i=0;i<bossUp.length;i++){
				Boss1 b=bossUp[i];
				g.drawImage(b.image, b.x, b.y, null);
			}
			//绘制boss下降
			for(int i=0;i<bossDown.length;i++){
				Boss2 b=bossDown[i];
				g.drawImage(b.image, b.x, b.y, null);
			}
			//绘制boss子弹
			for(int i=0;i<bossbulets.length;i++){
				BossBullet b=bossbulets[i];
				g.drawImage(b.image, b.x, b.y, null);
			}
			//状态栏
			paintScoreAndLife(g);
		}
		//状态背景
		if(state==START){
			a++;
			g.drawImage(start,0, a, null);
			g.drawImage(start, 0, -start.getHeight()+a,null);
			if(a== start.getHeight()){
				a=0;
			}
			g.setColor(new Color(0xf0f0f0));
			g.setFont(new Font(Font.SANS_SERIF,Font.BOLD,65));
			g.drawString("飞机大战", 110, 250);
			g.setFont(new Font(Font.SANS_SERIF,Font.BOLD,28));
			switch(level){
			case 1:
				g.drawString("EASY", 215, 400);break;
			case 2:
				g.drawString("NORMAL", 195, 400);break;
			case 3:
				g.drawString("HARD", 215, 400);break;
			}
			g.setFont(new Font(Font.SANS_SERIF,Font.BOLD,18));
			if(a%200<60){
				g.drawString("滑动滚轮以选择难度", 170, 600);
				g.drawString("点击任意处开始", 188, 630);
			}
			else if(a%200<120){
				g.setColor(new Color(0xd0d0d0));
				g.drawString("滑动滚轮以选择难度", 170, 600);
				g.drawString("点击任意处开始", 188, 630);
			}
		}
		if(state==PAUSE){
			b++;
			if(b== start.getHeight()){
				b=0;
			}
			g.drawImage(start,0, a, null);
			g.drawImage(start, 0, -start.getHeight()+a,null);
			g.setColor(new Color(0xf0f0f0));
			g.setFont(new Font(Font.SANS_SERIF,Font.BOLD,65));
			g.drawString("PAUSE", 140, 250);
			g.setFont(new Font(Font.SANS_SERIF,Font.BOLD,28));
			g.drawString("life:"+hero.life, 210, 350);
			g.drawString("stage:"+stage, 195, 400);
			g.setFont(new Font(Font.SANS_SERIF,Font.BOLD,18));
			if(b%200<60){
				g.drawString("将鼠标移回继续游戏", 170, 600);
			}
			else if(b%200<120){
				g.setColor(new Color(0xd0d0d0));
				g.drawString("将鼠标移回继续游戏", 170, 600);
			}
		}
		if(state==GAME_OVER){
			a++;
			g.drawImage(start,0, a, null);
			g.drawImage(start, 0, -start.getHeight()+a,null);
			if(a== start.getHeight()){
				a=0;
			}
			g.setColor(new Color(0xf0f0f0));
			g.setFont(new Font(Font.SANS_SERIF,Font.BOLD,60));
			g.drawString("GAME OVER", 75, 250);
			g.setFont(new Font(Font.SANS_SERIF,Font.BOLD,28));
			g.drawString("level:"+level_, 200, 360);
			g.drawString("stage:"+stage, 195, 400);
			if(score<10){
				g.drawString("score:"+score, 193, 440);
			}else if(score<100){
				g.drawString("score:"+score, 190, 440);
			}else{
				g.drawString("score:"+score, 183, 440);
			}
			g.setFont(new Font(Font.SANS_SERIF,Font.BOLD,18));
			if(a%200<60){
				g.drawString("点击任意处重新开始", 170, 600);
			}
			else if(a%200<120){
				g.setColor(new Color(0xd0d0d0));
				g.drawString("点击任意处重新开始", 170, 600);
			}
		}
	}
	public void paintScoreAndLife(Graphics g){
		g.setColor(new Color(0xf0f0f0));
		g.setFont(new Font(Font.SANS_SERIF,Font.BOLD,28));
		g.drawString("得分:"+score, 350, 710);
		g.setFont(new Font(Font.SANS_SERIF,Font.BOLD,28));
		g.drawString("生命:x"+hero.life, 80, 710);
		g.setFont(new Font(Font.SANS_SERIF,Font.BOLD,24));
		g.drawString("关卡:"+stage, 415, 30);
		g.setFont(new Font(Font.SANS_SERIF,Font.BOLD,24));
		g.drawImage(gg,0,660,null);
		g.drawImage(jj, 190, 685, null);
		for(int i=0;i<bossDown.length;i++){
			g.drawString(bossDown[i].life*2.5+"%",325,30);
			if(bossDown[i].life>36){
				g.drawImage(blife10, 20, 10, null);
			}else if(bossDown[i].life>32){
				g.drawImage(blife9, 20, 10, null);
			}else if(bossDown[i].life>28){
				g.drawImage(blife8, 20, 10, null);
			}else if(bossDown[i].life>24){
				g.drawImage(blife7, 20, 10, null);
			}else if(bossDown[i].life>20){
				g.drawImage(blife6, 20, 10, null);
			}else if(bossDown[i].life>16){
				g.drawImage(blife5, 20, 10, null);
			}else if(bossDown[i].life>12){
				g.drawImage(blife4, 20, 10, null);
			}else if(bossDown[i].life>8){
				g.drawImage(blife3, 20, 10, null);
			}else if(bossDown[i].life>4){
				g.drawImage(blife2, 20, 10, null);
			}else if(bossDown[i].life>0){
				g.drawImage(blife1, 20, 10, null);
			}
		}
	}

	/**
	 * @ljq
	 */
	public static void main(String[] args) {
		//生成窗体
		JFrame frame =new JFrame();
		//创建面板对象
		ShootGame game=new ShootGame();
		frame.add(game);
		//设置窗体大小
		frame.setSize(WIDTH,HEIGHT);
		//居中
		frame.setLocationRelativeTo(null);
		//窗体设置标题
		frame.setTitle("飞机大战-小组作业");
		//设置窗体关闭功能
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//设置窗体大小不可改变
		frame.setResizable(false);
		//设置窗体永远在最上方
		frame.setAlwaysOnTop(true);
		// 让窗体显示
		frame.setVisible(true);
		game.action();
	}

}
