package com.feng.untils;

import java.awt.*;
import java.awt.event.*;

/**
 * @ClassName FrameUtil
 * @Description: 窗口初始化工具类
 * @Author Xu Feng
 * @Date 2020/3/17
 * @Version V1.0
 **/
public class FrameUtil extends Frame implements KeyListener, MouseListener, MouseMotionListener{

    public void Init(){
        //设置窗口的初始位置
        this.setBounds(400,200,Constant.GAME_WIDTH,Constant.GAME_HEIGHT);
        //设置窗口的标题
        this.setTitle("冒险岛");
        //设置窗口关闭的监听事件
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        //添加键盘监听映射
        this.addKeyListener(this);
        //添加鼠标监听映射
        this.addMouseListener(this);


        //设置可见性
        this.setVisible(true);
        //设置聚焦
        this.setFocusable(true);
        //启动线程
        new MyThread().run();
    }

    // 解决图片闪烁的问题，用双缓冲方法解决闪烁问题
    Image backImg = null;

    // 重写update()方法，在窗口的里层添加一个虚拟的图片
    @Override
    public void update(Graphics g) {
        if (backImg == null) {
            // 如果虚拟图片不存在，创建一个和窗口一样大小的图片
            backImg = createImage(Constant.GAME_WIDTH, Constant.GAME_HEIGHT);
        }
        // 获取到虚拟图片的画笔
        Graphics backg = backImg.getGraphics();
        Color c = backg.getColor();
        backg.setColor(Color.white);
        backg.fillRect(0, 0, Constant.GAME_WIDTH, Constant.GAME_HEIGHT);
        backg.setColor(c);
        // 调用虚拟图片的paint()方法，每50ms刷新一次
        paint(backg);
        g.drawImage(backImg, 0, 0, null);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }


    //启动线程重画画布
    class MyThread extends Thread {

        @Override
        public void run() {
            for (; ; ) {
                repaint();
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
