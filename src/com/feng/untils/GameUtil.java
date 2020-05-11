package com.feng.untils;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

public class GameUtil {

	/**
	 * ����ͼƬ�ķ���
	 * @param imgpath ͼƬ����·��
	 * @param beishu �Ŵ����С�ı���
	 */
	public static Image getImage(String imgpath,double beishu) {
		InputStream imgInput = new GameUtil().getClass().getResourceAsStream(imgpath);
		Image image = null;
		try {
			BufferedImage imgBuffered = ImageIO.read(imgInput);
			int width = (int) (imgBuffered.getWidth()*beishu);
			int height = (int) (imgBuffered.getHeight()*beishu);
			image = imgBuffered.getScaledInstance(width, height, Image.SCALE_DEFAULT);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return image;
	}
	
	/**
	 * ����ͼƬ�ķ���
	 * @param imgpath ͼƬ����·��
	 */
	public static Image getImage(String imgpath) {
		InputStream imgInput = new GameUtil().getClass().getResourceAsStream(imgpath);
		Image image = null;
		try {
			BufferedImage imgBuffered = ImageIO.read(imgInput);
			int width = imgBuffered.getWidth();
			int height = imgBuffered.getHeight();
			image = imgBuffered.getScaledInstance(width, height, Image.SCALE_DEFAULT);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return image;
	}

	/**
	 * ����ͼƬ�ķ���
	 * @param imgpath ͼƬ����·��
	 * @param bian ��Ҫ����������ŵ����
	 * @param state (0|1)����0���������ţ�1����������
	 */
	public static Image getImage(String imgpath,int bian,int state) {
		InputStream imgInput = new GameUtil().getClass().getResourceAsStream(imgpath);
		Image image = null;
		try {
			BufferedImage imgBuffered = ImageIO.read(imgInput);
			int width = imgBuffered.getWidth();
			int height = imgBuffered.getHeight();
			if(state==0) {
				height = (int) ((double) bian / width * height) ;
				width = bian;
			}else {
				width = (int) ((double) bian / height * width) ;
				height = bian;				
			}
			image = imgBuffered.getScaledInstance(width, height, Image.SCALE_DEFAULT);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return image;
	}
}
