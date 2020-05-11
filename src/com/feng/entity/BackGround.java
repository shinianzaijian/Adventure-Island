package com.feng.entity;

import com.feng.untils.Constant;
import com.feng.untils.GameUtil;
import com.feng.untils.ImageUtil;

import java.awt.*;

/**
 * @ClassName BackGround
 * @Description: 游戏背景
 * @Author Xu Feng
 * @Date 2020/3/18
 * @Version V1.0
 **/
public class BackGround {

    public Image img;
    public int x;
    public int y;

    public BackGround(){
        this.img = ImageUtil.getImage("bg");
        this.x = 0;
        this.y = 0;
    }

    //画出背景
    public void draw(Graphics g){
        g.drawImage(img,x,y,null);
    }


}
