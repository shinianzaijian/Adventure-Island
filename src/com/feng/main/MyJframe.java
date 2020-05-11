package com.feng.main;

import com.feng.entity.*;
import com.feng.untils.Constant;
import com.feng.untils.FrameUtil;
import com.feng.untils.MusicUtil;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName Jframe
 * @Description: 游戏启动类
 * @Author Xu Feng
 * @Date 2020/3/16
 * @Version V1.0
 **/
public class MyJframe extends FrameUtil{

    Hero hero = new Hero(this);
    BackGround backGround = new BackGround();
    Mob mob = new Mob(this,400);
    GameLoad gl = new GameLoad();
    GameStartScenes gs = new GameStartScenes();
    Props props = new Props(this.hero,400);
    public Pass pass = new Pass();

    //装子弹容器
    public List<Bullet> bullets = new ArrayList<>();
    //装怪物的容器
    public List<Mob> mobs = mob.creatMod(this,5);
    //装死亡怪物的容器
    public List<Die> dies = new ArrayList<>();

    Boss bs = new Boss(this,bullets);

    //定义计数器
    public int count = 0;
    //定义延时次数
    public int delay = 70;

    @Override
    public void paint(Graphics g) {
        if (!gs.begin){
            //画开始界面
            gs.draw(g);
        }else{
            if (this.count<delay){
                //画加载画面
                gl.draw(g);
                this.count++;
            }else {
                //画游戏背景方法
                backGround.draw(g);
                //画英雄
                hero.draw(g);
                props.draw(g);
                //画怪物
                for (int i=0;i<mobs.size();i++){
                    mobs.get(i).draw(g);
                }
                if (mobs.size()==0){
                    if (bs.live){
                        bs.draw(g);
                    }else {
                        pass.draw(g);
                    }
                }

                //画怪物死亡
                for (int i=0;i<dies.size();i++){
                    dies.get(i).draw(g);
                    props.create = true;
                }
                //画子弹
                for (int j=0;j<bullets.size();j++){
                    bullets.get(j).draw(g);
                    bullets.get(j).hit(mobs);
                }
            }
        }
        }


    @Override
    public void keyPressed(KeyEvent e) {
        hero.keyPressed(e);
    }

    @Override
    public void keyReleased(KeyEvent e) {
        hero.keyReleased(e);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        gs.moClicked(e);
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        gs.moMoved(e);
    }



    public static void main(String[] args){
        new MusicUtil("music/片岡真央、岩田恭明 - 時の神殿.mp3",true).start();
        new MyJframe().Init();

    }

}

