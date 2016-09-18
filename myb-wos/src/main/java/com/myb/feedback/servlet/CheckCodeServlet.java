package com.myb.feedback.servlet;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.geom.Line2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CheckCodeServlet extends HttpServlet {
	private static final long serialVersionUID = 3067649287781066695L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setHeader("Pragma", "No-cache");
		response.setHeader("Cache-Control", "No-cache");
		response.setDateHeader("Expires", 0);
		response.setContentType("image/jpeg");
		
		Random rand = new Random();
		
		int width = 223;
		int height = 43;
		
		BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		Graphics2D g = (Graphics2D) image.getGraphics();
		g.setColor(getColor(rand, 200, 250));
		g.fillRect(0, 0, width, height);
		
		for (int i = 0; i < 2000; i++) {
			int x1 = rand.nextInt(width - 1);
			int y1 = rand.nextInt(height - 1);
			int x2 = rand.nextInt(6) + 1;
			int y2 = rand.nextInt(10) + 1;
			Line2D line = new Line2D.Double(x1, y1, x1 + x2, y1 + y2);
			BasicStroke bs = new BasicStroke(1f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL);
			g.setStroke(bs);
			g.setColor(getColor(rand, 140, 200));
			g.draw(line);
		}
		
		Font font = new Font("宋体", Font.BOLD, 20);
		g.setFont(font);
		FontMetrics fm = g.getFontMetrics();
		int ascent = fm.getAscent();
		int descent = fm.getDescent();
		int fontHeight = ascent + descent;
		String stemp = null;
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 4; i++) {
			
			int random = rand.nextInt(3);
			String[] strLower = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
			switch (random) {
			case 0:
				stemp = rand.nextInt(10) + "";
				break;
			case 1:
				random = rand.nextInt(26);
				stemp = strLower[random];
				break;
			case 2:
				random = rand.nextInt(26);
				stemp = strLower[random].toUpperCase();
				break;	
			}
			sb.append(stemp);
			int fontWidth = fm.stringWidth(stemp);
			g.setColor(new Color(rand.nextInt(110) + 20, rand.nextInt(110) + 20, rand.nextInt(110) + 20));
			AffineTransform trans = new AffineTransform();
			int r = rand.nextInt(2);
			double theta = 0;
			if(r == 0) {
				theta = rand.nextInt(30) * 3.14/180;
			} else {
				theta = (rand.nextInt(30) + 330) * 3.14/180;
			}
			trans.rotate(theta, (width/4*i + ((width/4-fontWidth)/2)), (height-fontHeight)/2 + ascent);
			float scaleSize = rand.nextFloat() + 0.8f;
			if(scaleSize > 1f) {
				scaleSize = 1f;
			}
			trans.scale(scaleSize, scaleSize);
			g.setTransform(trans);
			g.drawString(stemp, (width/4*i + ((width/4-fontWidth)/2)), (height-fontHeight)/2 + ascent);
		}
		request.getSession().setAttribute("checkCode", sb.toString());
		g.dispose();
		ImageIO.write(image, "JPEG", response.getOutputStream());
	}
	
	private Color getColor(Random rand, int s, int e) {
		if(s > 255) s = 255;
		if(e > 255) e = 255;
		int r = s + rand.nextInt(e- s);
		int g = s + rand.nextInt(e- s);
		int b = s + rand.nextInt(e- s);
		return new Color(r, g, b);
	}

}
