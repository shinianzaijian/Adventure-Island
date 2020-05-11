package com.feng.test;

import javax.swing.*;
import java.awt.*;

/**
 * @ClassName TestBackGround
 * @Description: TODO
 * @Author Xu Feng
 * @Date 2020/3/16
 * @Version V1.0
 **/
public class TestBackGround {


    public static void main(String[] args) {
        double i = 10;
        boolean flag = true;
        if (flag){
            for (;;){
                i -= 1;
                System.out.println(i);
                if (i<=5){
                    i = 15;
                    System.out.println(i);
                    flag = false;
                    System.out.println(flag);
                    break;
                }
            }
        }
        if (flag == false){
            System.out.println("第二个"+i);
            System.out.println("第二个if");
        }
    }
}
