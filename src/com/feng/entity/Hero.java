package com.feng.entity;

import com.feng.main.MyJframe;
import com.feng.untils.Constant;
import com.feng.untils.ImageUtil;
import com.feng.untils.JumpUtil;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName Hero
 * @Description: TODO
 * @Author 英雄精灵类
 * @Date 2020/3/18
 * @Version V1.0
 **/
public class Hero {

    public static Image[] imgs = new Image[100];

    static{
        //向右行走
        for (int i=0;i<5;i++){
            imgs[i] = ImageUtil.getImage("hero_right_walk0"+i);
        }
        //向左行走
        for (int i=5;i<10;i++){
            imgs[i] = ImageUtil.getImage("hero_left_walk0"+(i-5));
        }
        //向右站立
        for (int i=10;i<14;i++){
            imgs[i] = ImageUtil.getImage("hero_right_stand0"+(i-10));
        }
        //向左站立
        for (int i=14;i<18;i++){
            imgs[i] = ImageUtil.getImage("hero_left_stand0"+(i-14));
        }
        //向右发射子弹
        for (int i=18;i<22;i++){
            imgs[i] = ImageUtil.getImage("hero_right_shoot0"+(i-18));
        }
        //向左发射子弹
        for (int i=22;i<26;i++){
            imgs[i] = ImageUtil.getImage("hero_left_shoot0"+(i-22));
        }
    }

    public Image img;
    public int x;
    public int y;
    public int speed;
    public int width;
    public int height;
    boolean walk, left, right, jump, shoot;

    public Action action;
    public Direction dir;

    public MyJframe mf;

    public Hero(MyJframe mf){
        this.img = ImageUtil.getImage("hero_right_stand");
        this.x = 20;
        this.y = 316;
        this.width = img.getWidth(null);
        this.height = img.getHeight(null);
        this.speed = 7;
        this.mf = mf;
        this.dir = Direction.RIGHT;
        this.action = Action.STAND;
    }

    //越界
    public void offBounds(){
        if (x<0){
            x = 0;
        }
        if (x>Constant.GAME_WIDTH-width){
            x=Constant.GAME_WIDTH-width;
        }
        if (y<20){
            y = 20;
        }
        if (y>Constant.GAME_HEIGHT-height-5){
            y = Constant.GAME_HEIGHT-height-5;
        }
    }
    //设置英雄向右走计数器
    public static int walk_right_count = 0;
    //设置英雄向左走计数器
    public static int walk_left_count = 5;
    //设置英雄向右站立计数器
    public static int stand_right_count = 10;
    //设置英雄向左站立计数器
    public static int stand_left_count = 14;
    //设置英雄向右射击计时器
    public static int shoot_right_count = 18;
    //设置英雄向左射击计时器
    public static int shoot_left_count = 22;


    //画出英雄
    public void draw(Graphics g) {
        //控制向右行走刷新
        if (walk_right_count>4){
            walk_right_count = 0;
        }
        //控制向左行走刷新
        if (walk_left_count>9){
            walk_left_count = 5;
        }
        //控制向右站立刷新
        if (stand_right_count>13){
            stand_right_count = 10;
        }
        //控制向左站立刷新
        if (stand_left_count>17){
            stand_left_count = 14;
        }
        //
        if (shoot_right_count>21){
            shoot_right_count = 18;
        }
        //
        if (shoot_left_count>25){
            shoot_left_count = 22;
        }
        switch (dir){
            case RIGHT:
                switch (action){
                    case WALK:
                        g.drawImage(imgs[walk_right_count++],x,y,null);
                        break;
                    case STAND:
                        g.drawImage(imgs[stand_right_count++],x,y,null);
                        break;
                    case JUMP:
                        g.drawImage(ImageUtil.getImage("hero_right_jump"),x,y,null);
                        break;
                    case SHOOT:
                        g.drawImage(imgs[shoot_right_count++],x,y,null);
                        break;
                }
                break;
            case LEFT:
                switch (action){
                    case WALK:
                        g.drawImage(imgs[walk_left_count++],x,y,null);
                        break;
                    case STAND:
                        g.drawImage(imgs[stand_left_count++],x,y,null);
                        break;
                    case JUMP:
                        g.drawImage(ImageUtil.getImage("hero_left_jump"),x,y,null);
                        break;
                    case SHOOT:
                        g.drawImage(imgs[shoot_left_count++],x,y,null);
                        break;
                }
                break;
        }
        move();
        offBounds();
    }

    //英雄的移动
    public void move() {
        if (walk){
            action = Action.WALK;
            if (right) {
                dir = Direction.RIGHT;
                x += speed;
                if (jump){
                    action = Action.JUMP;
                    jump();
                }
                if (shoot){
                    shoot();
                    action = Action.SHOOT;
                }
            }

            if (left) {
                dir = Direction.LEFT;
                x -= speed;
                if (jump){
                    action = Action.JUMP;
                    jump();
                }
                if (shoot){
                    shoot();
                    action = Action.SHOOT;
                }
            }

        }else if (jump){
            action = Action.JUMP;
            jump();
            if (shoot){
                shoot();
                action = Action.SHOOT;
            }
        }else if (shoot){
            shoot();
            action = Action.SHOOT;
        }else {
            action = Action.STAND;
        }


    }

    //英雄的按键方法
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()){
            case KeyEvent.VK_A:
                shoot = true;
                break;
            case KeyEvent.VK_SPACE:
                jump = true;
                break;
            case KeyEvent.VK_LEFT:
                left = true;
                walk = true;
                break;
            case KeyEvent.VK_RIGHT:
                right = true;
                walk = true;
                break;
        }
    }

    //按键释放方法
    public void keyReleased(KeyEvent e) {
        switch (e.getKeyCode()){
            case KeyEvent.VK_A:
                shoot = false;
                break;
            case KeyEvent.VK_SPACE:
                break;
            case KeyEvent.VK_LEFT:
                left = false;
                walk = false;
                break;
            case KeyEvent.VK_RIGHT:
                right = false;
                walk = false;
                break;
        }
    }

    //英雄跳跃位移方法
    double v0 = 30;
    double vt = 0;
    double g = 9.8;
    double t = 0.5;
    double d_h = 0;

    boolean jump_up = true;

    public void jump(){
        //竖直上抛运动
        if (jump_up){
                vt = v0 - g * t;
                d_h = v0 * t;
                v0 = vt;
                this.y -= d_h;
                if (vt<=0){
                    v0 = 0;
                    vt = 0;
                    jump_up = false;
                }
        }
        //自由落体
        else {
                vt = v0 + g * t;
                d_h = v0 * t;
                v0 = vt;
                this.y += d_h;
                if (y>=325){
                    y = 325;
                    v0 = 30;
                    vt = 0;
                    jump_up = true;
                    jump = false;
                }
        }
    }

    //发射子弹类
    public void shoot(){
        Bullet bullet = new Bullet(mf, x, y+this.height/2, dir);
        mf.bullets.add(bullet);
    }

    //子弹打击
    public Rectangle rectangle(){
        return new Rectangle(x,y,width,height);
    }


}
