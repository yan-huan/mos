package com.myb.commons.utils;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import javax.imageio.ImageIO;

/**
 * 图片压缩
 * 
 * @author 宋海强
 */
public class ImgCompress {
	private Image img;
	private int width;
	private int height;

	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws Exception {
		File f = new File("E:\\qq.png");
		System.out.println("aa="+f.getAbsolutePath());
		
		System.out.println("开始：" + new Date().toLocaleString());
		ImgCompress imgCom = new ImgCompress("E:\\qq.png");
		String filePath = "c:\\temp\\s.png";
		
		imgCom.resizeFix(400, 800, filePath);
		System.out.println("结束：" + new Date().toLocaleString());
	}

	/**
	 * 构造函数
	 * 
	 * @param fileName 需要转换的源文件完整路径
	 * @throws IOException
	 */
	public ImgCompress(String fileName) throws IOException {
		// 读入文件
		File file = new File(fileName);
		// 构造Image对象
		img = ImageIO.read(file);
		// 得到源图宽
		width = img.getWidth(null);
		// 得到源图长
		height = img.getHeight(null);
	}
	
	
	public ImgCompress(Image img) throws IOException {
		// 构造Image对象
		this.img = img;
		// 得到源图宽
		width = img.getWidth(null);
		// 得到源图长
		height = img.getHeight(null);
	}

	/**
	 * 构造函数
	 * 
	 * @param file 需要转换的源文件
	 * @throws IOException
	 */
	public ImgCompress(File file) throws IOException {
		// 构造Image对象
		this.img = ImageIO.read(file);
		// 得到源图宽
		this.width = this.img.getWidth(null);
		// 得到源图长
		this.height = this.img.getHeight(null);
	}

	/**
	 * 按照宽度还是高度进行压缩
	 * 
	 * @param w int 最大宽度
	 * @param h int 最大高度
	 */
	public void resizeFix(int w, int h, String filePath) throws IOException {
		if (width / height > w / h) {
			resizeByWidth(w, filePath);
		}
		else {
			resizeByHeight(h, filePath);
		}
	}

	/**
	 * 以宽度为基准，等比例放缩图片
	 * 
	 * @param w int 新宽度
	 */
	public void resizeByWidth(int w, String filePath) throws IOException {
		int h = (int) (height * w / width);
		resize(w, h, filePath);
	}

	/**
	 * 以高度为基准，等比例缩放图片
	 * 
	 * @param h int 新高度
	 */
	public void resizeByHeight(int h, String filePath) throws IOException {
		int w = (int) (width * h / height);
		resize(w, h, filePath);
	}

	/**
	 * 强制压缩/放大图片到固定的大小
	 * 
	 * @param w int 新宽度
	 * @param h int 新高度
	 */
	public void resize(int w, int h, String filePath) throws IOException {
		// SCALE_SMOOTH 的缩略算法 生成缩略图片的平滑度的 优先级比速度高 生成的图片质量比较好 但速度慢
		BufferedImage image = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
		// 绘制缩小后的图
		image.getGraphics().drawImage(img, 0, 0, w, h, null);
		String formatName = filePath.substring(filePath.lastIndexOf(".") + 1);
		File destFile = new File(filePath);
		// 输出到文件流
		FileOutputStream out = new FileOutputStream(destFile);
		// 可以正常实现bmp、png、gif转jpg
		ImageIO.write(image,formatName,new File(filePath));
		out.close();
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}
}