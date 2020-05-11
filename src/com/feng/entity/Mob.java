package com.feng.entity;

import com.feng.main.MyJframe;
import com.feng.untils.Constant;
import com.feng.untils.ImageUtil;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName mob
 * @Description: TODO
 * @Author Xu Feng
 * @Date 2020/3/19
 * @Version V1.0
 **/
public class Mob {

    public int x;
    public int y;
    public int width;
    public int height;
    public int hp;
    public boolean live;
    public MyJframe mf;
    public BloodBar bb;

    public static Image[] imgs = new Image[100];
    public List<Mob> mobs = new ArrayList<>();

    static {
        for (int i=0;i<4;i++){
            imgs[i] = ImageUtil.getImage("mob_xue_stand"+i);
        }
    }

    public Mob(MyJframe mf, int x){
        this.x = x;
        this.y = 370;
        this.live = true;
        this.width = imgs[0].getWidth(null);
        this.height = imgs[0].getHeight(null);
        this.mf = mf;
        this.bb = new BloodBar(this.x,this.y);
        this.hp = Constant.HP;
    }

    //设置怪物计数器
    public int count=0;

    public void draw(Graphics g){
        if (count>3){
            count = 0;
        }
        g.drawImage(imgs[count++],x,y,null);
        bb.draw(g);
    }

    public List<Mob> creatMod(MyJframe mf,int num){
        for (int i=0;i<num;i++){
            Mob mob = new Mob(mf,this.x+70*i);
            mobs.add(mob);
        }
        return mobs;
    }


    public Rectangle rectangle(){
        return new Rectangle(x,y,width,height);
    }

    /**
    * @Description 画怪物的血条
    * @Params
    * @Return
    * @Author Xu Feng
    * @Date 2020/3/20 17:45
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
            g.drawRect(x,y-5,width,5);
            g.getColor();
            g.setColor(Color.green);
            g.fillRect(x,y-5,width*hp/100,5);
            g.getColor();
        }

    }

}
