package com.feng.entity;

import com.feng.main.MyJframe;
import com.feng.untils.FrameUtil;
import com.feng.untils.ImageUtil;

import java.awt.*;
import java.util.List;

/**
 * @ClassName Boss
 * @Description: TODO
 * @Author Xu Feng
 * @Date 2020/3/22
 * @Version V1.0
 **/
public class Boss extends FrameUtil {

    public Image img;
    public int x;
    public int y;
    public int height;
    public int width;
    public int hp;
    public boolean live;
    public BloodBar bb;
    public MyJframe mf;
    public List<Bullet> bullets;


    public Boss(MyJframe mf, List<Bullet> bullets){
        this.x = 600;
        this.img = ImageUtil.getImage("boss_fu_stand");
        this.height = img.getHeight(null);
        this.width = img.getWidth(null);
        this.y = 400-height;
        this.hp = 1000;
        this.bb = new BloodBar(this.x,this.y);
        this.bullets = bullets;
        this.mf = mf;
        this.live = true;
    }


    public void draw(Graphics g){
        g.drawImage(img,x,y,null);
        bb.draw(g);
        hit();
    }

    public Rectangle rectangle(){
        return new Rectangle(x,y,width,height);
    }

    public void hit(){
        for (int i=0;i<bullets.size();i++){
            if (bullets.get(i).rectangle().intersects(rectangle())){
                mf.bullets.remove(i);
                hp -= 10;
            }
            if (hp<=0){
                live = false;
            }
        }
    }


    /**
    * @Description boss的血量
    * @Params
    * @Return
    * @Author Xu Feng
    * @Date 2020/3/22 16:07
    **/
    class BloodBar{
        int x;
        int y;
        public BloodBar(int x, int y){
            this.x = x;
            this.y = y;
        }

        public void draw(Graphics g){
            Color c = g.getColor();
            g.setColor(new Color(13, 13, 13, 121));
            g.drawRect(x,y-7,width-140,5);
            g.getColor();
            g.setColor(Color.green);
            g.fillRect(x,y-7,(width-140)*hp/100,5);
            g.getColor();
        }

    }

}
