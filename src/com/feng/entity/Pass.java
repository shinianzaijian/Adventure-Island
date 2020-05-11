package com.feng.entity;

import com.feng.untils.Constant;
import com.feng.untils.FrameUtil;
import sun.applet.Main;

import java.awt.*;

/**
 * @ClassName Pass
 * @Description: TODO
 * @Author Xu Feng
 * @Date 2020/3/22
 * @Version V1.0
 **/
public class Pass extends FrameUtil {

    public int x;
    public int y;

    public Pass(){
        this.x = Constant.GAME_WIDTH/2-130;
        this.y = Constant.GAME_HEIGHT/2-70;
    }

    public void draw(Graphics g){
        Color c = g.getColor();
        g.setColor(new Color(255, 143, 0, 255));
        g.setFont(new Font("宋体",Font.BOLD, 40));
        g.drawString("恭喜你过关了！",x,y);
        g.getColor();
    }

    @Override
    public void paint(Graphics g) {
        Color c = g.getColor();
        g.setColor(Color.gray);
        g.setFont(new Font("宋体",Font.BOLD, 40));
        g.drawString("恭喜你过关了！",x,y);
        g.getColor();
    }

    public static void main(String[] args) {
        new Pass().Init();
    }
}
