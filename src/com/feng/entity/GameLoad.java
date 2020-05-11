package com.feng.entity;

import com.feng.untils.FrameUtil;
import com.feng.untils.ImageUtil;

import java.awt.*;

/**
 * @ClassName GameLoad
 * @Description: 游戏加载界面类
 * @Author Xu Feng
 * @Date 2020/3/20
 * @Version V1.0
 **/
public class GameLoad extends FrameUtil {

    public static Image[] imgs = new Image[10];
    public int x;
    public int y;


    public GameLoad(){
        this.x = 0;
        this.y = 0;
    }


    static {
        for (int i=0;i<5;i++){
            imgs[i] = ImageUtil.getImage("gameload_scenes"+i);
        }
    }


    public int count = 0;
//    public int speed = 200;
    public void draw(Graphics g){
        if (count>4){
            count = 0;
        }
        g.drawImage(imgs[count++],x,y,null);

    }

    @Override
    public void paint(Graphics g) {
        if (count<3000){
            g.drawImage(imgs[count++],x,y,null);
        }else {
            count = 0;
        }
    }

}
