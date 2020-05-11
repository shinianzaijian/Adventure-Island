package com.feng.untils;

/**
 * @ClassName MyThreadG
 * @Description: TODO
 * @Author Xu Feng
 * @Date 2020/3/20
 * @Version V1.0
 **/
public class MyThreadG extends Thread {

    public volatile boolean exit = false;
    @Override
    public void run() {
        while (!exit){
            for (int i=0;i<5;i++){
                System.out.println("aaa");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            }
        }


    public static void main(String[] args) throws InterruptedException {
        MyThreadG t = new MyThreadG();
        t.start();
        sleep(1000);
        t.exit = true;
    }

}
