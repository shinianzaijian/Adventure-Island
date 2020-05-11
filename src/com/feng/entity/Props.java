package com.feng.entity;

import com.feng.main.MyJframe;
import com.feng.untils.FrameUtil;
import com.feng.untils.ImageUtil;

import java.awt.*;

/**
 * @ClassName Props
 * @Description: TODO
 * @Author Xu Feng
 * @Date 2020/3/21
 * @Version V1.0
 **/
public class Props extends FrameUtil{

    public int x;
    public int y;
    public int height;
    public int width;
    public boolean create;
    public Image img;
    public Hero hero;
    public Mob mob;
    public MyJframe mf;

    public Props(Hero hero, int x){
        this.x = x;
        this.y = 400;
        this.create = false;
        this.hero = hero;
        this.img = ImageUtil.getImage("hero_props_drop");
        this.height = img.getHeight(null);
        this.width = img.getWidth(null);
    }

    public void draw(Graphics g){
        if (create){
            g.drawImage(img,x,y-height,null);
            jump();
            eatProps(hero);
        }
    }

    public void eatProps(Hero hero){
        if (this.getRectangle().intersects(hero.rectangle())){
            create = false;
        }
    }



    //物体弹出方法
    double v0 = 15;
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
            this.x -=d_h;
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
            if (y>=400){
                y = 400;
                v0 = 15;
                vt = 0;
                jump_up = true;
            }
        }
    }

    public Rectangle getRectangle(){
        return new Rectangle(x, y, width, height);
    }

}
