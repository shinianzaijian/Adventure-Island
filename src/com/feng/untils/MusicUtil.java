package com.feng.untils;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

import java.io.BufferedInputStream;
import java.io.File;

/**
 * @ClassName MusicUtil
 * @Description: TODO
 * @Author Xu Feng
 * @Date 2020/3/20
 * @Version V1.0
 **/
public class MusicUtil extends Thread {

    private Player player;
    private File music;

    private String musicPath;
    private boolean loop;

    public MusicUtil(String musicPath){
        this.musicPath = musicPath;
    }

    public MusicUtil(String musicPath,boolean loop){
        this.musicPath = musicPath;
        this.loop = loop;
    }

    @Override
    public void run() {
        super.run();
        try {
            if (loop){
                while (true){
                    play();
                }
            }else {
                play();
            }
        }catch (JavaLayerException e){
            e.printStackTrace();
        }
    }

    public void play() throws JavaLayerException {
        BufferedInputStream buff = new BufferedInputStream(MusicUtil.class.getClassLoader()
                .getResourceAsStream(musicPath));
        player = new Player(buff);
        player.play();
    }

    public static void main(String[] args) {
        MusicUtil musicUtil = new MusicUtil("music/Bruno Mars - Talking to the Moon (Acoustic Piano).mp3",true);
        musicUtil.start();
    }

}
