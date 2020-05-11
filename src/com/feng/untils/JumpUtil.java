package com.feng.untils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.TimerTask;

/**
 * @ClassName JumpUtil
 * @Description: TODO
 * @Author Xu Feng
 * @Date 2020/3/19
 * @Version V1.0
 **/
public class JumpUtil{

    //英雄的跳算法

    public static List<Integer> jump(int y){
        double v0 = 30;
        double vt = 0;
        double g = 9.8;
        double t = 0.5;
        double d_h = 0;

        List<Integer> jumps = new ArrayList();

        boolean jump_up = true;


        //竖直上抛运动
        if (jump_up){
            for (;;){
                System.out.println(+y);
                vt = v0 - g * t;
                d_h = v0 * t;
                v0 = vt;
                y -= d_h;
                jumps.add(y);
                System.out.println("竖直上抛:"+y);
                if (vt<=0){
                    v0 = 0;
                    vt = 0;
                    jump_up = false;
                    System.out.println("自由落体最终:"+y);
                    break;
                }
            }
        }
        //自由落体
        if (!jump_up){
            for (;;){
                vt = v0 + g * t;
                d_h = v0 * t;
                v0 = vt;
                y += d_h;
                jumps.add(y);
                if (y>=400){
                    y = 400;
                    v0 = 30;
                    vt = 0;
                    jump_up = true;
                    System.out.println("自由落体最终:"+y);
                    break;
                }
            }
        }
        if (jumps.get(jumps.size()-1)>= y){
            Collections.replaceAll(jumps,jumps.get(jumps.size()-1),y);
        }
      return jumps;
    }

    static class jumpThread extends Thread{

        @Override
        public void run() {
            for (int dy : jump(400)){
                System.out.println(dy);
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
//        for (int dy : jump(400)){
//            System.out.println(dy);
//        }
        new jumpThread().run();
    }

}
