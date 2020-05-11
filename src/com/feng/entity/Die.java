package com.feng.entity;

import com.feng.main.MyJframe;
import com.feng.untils.ImageUtil;

import java.awt.*;

/**
 * @ClassName Die
 * @Description: TODO
 * @Author Xu Feng
 * @Date 2020/3/20
 * @Version V1.0
 **/
public class Die {

    public int x;
    public int y;
    public boolean live;
    public MyJframe mf;
    public static Image[] imgs = new Image[20];

    static {
        for (int i=0;i<9;i++){
            imgs[i] = ImageUtil.getImage("mob_xue_die"+i);
        }
    }

    public Die(MyJframe mf, int x, int y){
        this.x=x;
        this.y = y;
        this.mf = mf;
        this.live = true;
    }

    public int count = 0;

    public void draw(Graphics g){
        if (!live){
            mf.dies.remove(this);
            return;
        }
        if (count > 8){
            live = false;
            count = 8;
        }
        g.drawImage(imgs[count++],x,y,null);
    }

}
