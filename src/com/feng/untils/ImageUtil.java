package com.feng.untils;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName ImageUtil
 * @Description: 游戏存放图片类
 * @Author Xu Feng
 * @Date 2020/3/18
 * @Version V1.0
 **/
public class ImageUtil {

    public static Map<String, Image> imgs = new HashMap<>();

    static{
        //游戏开始界面
        imgs.put("game_start0", GameUtil.getImage("/img/gameload/gameB01.png"));
        imgs.put("game_start1", GameUtil.getImage("/img/gameload/gameB00.png"));
        imgs.put("boss_fu_stand", GameUtil.getImage("/img/bossStand/0.png"));
        //游戏加载界面
        for (int i=0;i<5;i++){
            imgs.put("gameload_scenes"+i, GameUtil.getImage("/img/gameload/gl_"+i+".png"));
        }
        //游戏加载背景
        imgs.put("gl",GameUtil.getImage("/img/gameload/sbg.jpg"));
        //游戏背景
        imgs.put("bg", GameUtil.getImage("/img/scenes/game_back.png"));
        //掉落的道具
        imgs.put("hero_props_drop", GameUtil.getImage("/img/props/christmas.png"));
        //游戏英雄右站立
        imgs.put("hero_right_stand",GameUtil.getImage("/img/hero/stand_r/stand1_0.png"));
        for (int i=0;i<4;i++){
            imgs.put("hero_right_stand0"+i, GameUtil.getImage("/img/hero/stand_r/stand1_"+i+".png"));
        }
        //游戏英雄左站立
        for (int i=0;i<4;i++){
            imgs.put("hero_left_stand0"+i, GameUtil.getImage("/img/hero/stand_l/stand1_"+i+".png"));
        }
        //英雄右行走
        for (int i=0;i<5;i++){
            imgs.put("hero_right_walk0"+i, GameUtil.getImage("/img/hero/walk_r/walk1_"+i+".png"));
        }
        //英雄左行走
        for (int i=0;i<5;i++){
            imgs.put("hero_left_walk0"+i, GameUtil.getImage("/img/hero/walk_l/walk1_"+i+".png"));
        }
        //英雄向右跳跃
        imgs.put("hero_right_jump",GameUtil.getImage("/img/hero/jump/jump_r.png"));
        //英雄向左跳跃
        imgs.put("hero_left_jump",GameUtil.getImage("/img/hero/jump/jump_l.png"));
        //英雄右射击
        for (int i = 0;i<4;i++){
            imgs.put("hero_right_shoot0"+i,GameUtil.getImage("/img/hero/shoot_r/shoot1_"+i+".png"));
        }
        //英雄左射击
        for (int i = 0;i<4;i++){
            imgs.put("hero_left_shoot0"+i,GameUtil.getImage("/img/hero/shoot_l/shoot1_"+i+".png"));
        }
        //子弹右边
        imgs.put("hero_right_bullet",GameUtil.getImage("/img/hero/bullet/bullet_r.png"));
        //子弹左边
        imgs.put("hero_left_bullet",GameUtil.getImage("/img/hero/bullet/bullet_l.png"));
        //雪精灵站立怪物
        for (int i=0;i<4;i++){
            imgs.put("mob_xue_stand"+i,GameUtil.getImage("/img/0100130-雪精灵/stand.frames/"+i+".png"));
        }
        //雪精灵死亡怪物
        for (int i=0;i<9;i++){
            imgs.put("mob_xue_die"+i,GameUtil.getImage("/img/0100130-雪精灵/die1.frames/"+i+".png"));
        }
        //boss站立
        for (int i=0;i<2;i++){
            imgs.put("boss_fu_stand"+i,ImageUtil.getImage("/img/bossStand/"+i+".png"));
        }
        //boss死亡
        for (int i=0;i<12;i++){
            imgs.put("boss_fu_die"+i,ImageUtil.getImage("/img/bossdie/"+i+".png"));
        }

    }

    public static Image getImage(String key){
        return imgs.get(key);
    }

}
