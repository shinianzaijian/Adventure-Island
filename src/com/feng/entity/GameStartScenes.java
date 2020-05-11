package com.feng.entity;

import com.feng.untils.FrameUtil;
import com.feng.untils.ImageUtil;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * @ClassName GameStartScenes
 * @Description: 游戏开始界面
 * @Author Xu Feng
 * @Date 2020/3/20
 * @Version V1.0
 **/
public class GameStartScenes extends FrameUtil{

    public Image img;
    public Image img1;
    public int x;
    public int y;
//    public int stauts;
    public boolean begin;


    public GameStartScenes(){
        this.x = 0;
        this.y = 0;
        this.img = ImageUtil.getImage("game_start0");
        this.img1 = ImageUtil.getImage("game_start1");
        this.begin = false;
    }

    public void draw(Graphics g){
        g.drawImage(img,x,y,null);
    }


    public void moClicked(MouseEvent e){
        if(e.getX()>273 && e.getX()<610 && e.getY()>300 && e.getY()<335){
            System.out.println("进入游戏！");
            this.begin = true;
        }
    }

    public void moMoved(MouseEvent e){
        if(e.getX()>273 && e.getX()<610 && e.getY()>300 && e.getY()<335){
            System.out.println("进入游戏！");
        }
    }



    @Override
    public void mouseClicked(MouseEvent e) {
        moClicked(e);
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        moMoved(e);
    }

}
