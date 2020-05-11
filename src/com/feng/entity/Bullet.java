package com.feng.entity;

import com.feng.main.MyJframe;
import com.feng.untils.ImageUtil;

import java.awt.*;
import java.util.List;

/**
 * @ClassName Bullet
 * @Description: TODO
 * @Author Xu Feng
 * @Date 2020/3/19
 * @Version V1.0
 **/
public class Bullet {

    public Image img;
    public int x;
    public int y;
    public int width;
    public int height;
    public int speed;
    public boolean live;
    public Direction dir;
    public MyJframe mf;


    public Bullet(MyJframe mf, int x, int y, Direction dir){
        this.x = x;
        this.y = y;
        this.speed=30;
        this.live = true;
        this.mf = mf;
        this.dir = dir;
        if (dir == Direction.RIGHT){
            this.img = ImageUtil.getImage("hero_right_bullet");
        }else {
            this.img = ImageUtil.getImage("hero_left_bullet");
        }
        this.width = img.getWidth(null);
        this.height = img.getHeight(null);
    }

    public void draw(Graphics g){
//        if (!live){
//            mf.bullets.remove(this);
//        }
        g.drawImage(img,x,y,null);
        move();
    }

    //子弹移动
    public void move(){
        if (dir == Direction.RIGHT){
            this.x += speed;
        }else {
            this.x -= speed;
        }
    }

    public boolean hit(Mob mob){
        if (this.rectangle().intersects(mob.rectangle())){
            mf.bullets.remove(this);
            return true;
        }
        return false;
    }

    public boolean hit(List<Mob> mobs){
        for (int i=0;i<mobs.size();i++){
            Mob mob = mobs.get(i);
            if (hit(mob)){
                //子弹死
                this.live = false;
                mob.hp -= 10;
                if (mob.hp<=0){
                    //怪物死
                    mob.live = false;
                    mf.mobs.remove(mob);
                    Die die = new Die(mf,mob.x,mob.y);
                    mf.dies.add(die);
                    return true;
                }
            }
        }
        return false;
    }


    public Rectangle rectangle(){
        return new Rectangle(x,y,width,height);
    }
}


