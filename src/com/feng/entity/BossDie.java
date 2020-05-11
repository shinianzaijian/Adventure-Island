package com.feng.entity;

import com.feng.untils.FrameUtil;
import com.feng.untils.ImageUtil;

import java.awt.*;

/**
 * @ClassName BossDie
 * @Description: TODO
 * @Author Xu Feng
 * @Date 2020/3/22
 * @Version V1.0
 **/
public class BossDie extends FrameUtil {

    public static Image[] imgs = new Image[100];
    static {
        for (int i=0;i<12;i++){
            imgs[i] = ImageUtil.getImage("boss_fu_die"+i);
        }
    }

    public int x;
    public int y;

    public BossDie(){
        this.x = 200;
        this.y = 200;
    }

    public int count = 0;

    @Override
    public void paint(Graphics g) {
        if (count>11){
            count = 0;
        }
        g.drawImage(imgs[count++],x,y,null);
    }

    public static void main(String[] args) {
        new BossDie().Init();
    }
}
