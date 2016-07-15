package com.xinfang.web.eat.util;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.font.FontRenderContext;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import javax.imageio.ImageIO;

public class Tupian {
	
	public static void main(String[] args) throws Exception{
		BufferedImage image = null;
		InputStream is = null;
		String centerName = "信访专用章";
		String message = "上海市公园管理事务中上海市公园管理事务中上海市公园管";
		int fontsize = 30;
		
		// 20 - ++ 60
		// 10 - 20 40
		// 0  - 15 50
		if (message != null) {
			final int CENTERX = 250;
			final int CENTERY = 250;
			final int radius = 230;
			// 获取get_png文件夹

			String filePath = "D:\\temp";
			String path = filePath;
			image = ImageIO.read(new FileInputStream(path + File.separator + "4.png"));

			Graphics2D g2 = image.createGraphics();// 得到图形上下文
			g2.setColor(Color.RED); // 设置画笔颜色
			g2.setColor(new Color(198, 23, 31));
			
			// 设置字体
			g2.setFont(new Font("宋体", Font.LAYOUT_LEFT_TO_RIGHT, 40));// 写入签名
			if (centerName != null) {
				g2.drawString(centerName, 150, 380);
			}
			// 根据输入字符串得到字符数组

			String[] messages2 = message.split("", 0);
			String[] messages = new String[messages2.length - 1];
			System.arraycopy(messages2, 1, messages, 0, messages2.length - 1);
			// 输入的字数
			int ilength = messages.length;
			// 设置字体属性
			
			Font f = new Font("", Font.BOLD, fontsize);
			FontRenderContext context = g2.getFontRenderContext();
			Rectangle2D bounds = f.getStringBounds(message, context);
			// 字符宽度＝字符串长度/字符数
			double char_interval = (bounds.getWidth() / ilength);
			// 上坡度
			double ascent = -bounds.getY();
			int first = 0, second = 0;
			boolean odd = false;
			if (ilength % 2 == 1) {
				first = (ilength - 1) / 2;
				odd = true;
			} else {
				first = (ilength) / 2 - 1;
				second = (ilength) / 2;
				odd = false;
			}
			double radius2 = radius - ascent;
			double x0 = CENTERX;
			double y0 = CENTERY - radius + ascent;
			// 旋转角度
			double a = 2 * Math.asin(char_interval / (2 * radius2));
			if (odd) {
				g2.setFont(f);
				g2.drawString(messages[first],(float) (x0 - char_interval / 2), (float) y0);
				// 中心点的右边
				for (int i = first + 1; i < ilength; i++) {
					double aa = (i - first) * a;
					double ax = radius2 * Math.sin(aa);
					double ay = radius2 - radius2 * Math.cos(aa);
					AffineTransform transform = AffineTransform.getRotateInstance(aa);// ,x0 + ax, y0 + ay);
					Font f2 = f.deriveFont(transform);
					g2.setFont(f2);
					g2.drawString(messages[i],(float) (x0 + ax - char_interval / 2* Math.cos(aa)),(float) (y0 + ay - char_interval / 2 * Math.sin(aa)));
				}
				// 中心点的左边
				for (int i = first - 1; i > -1; i--) {
					double aa = (first - i) * a;
					double ax = radius2 * Math.sin(aa);
					double ay = radius2 - radius2 * Math.cos(aa);
					AffineTransform transform = AffineTransform.getRotateInstance(-aa);// ,x0 + ax, y0 + ay);
					Font f2 = f.deriveFont(transform);
					g2.setFont(f2);
					g2.drawString(messages[i],(float) (x0 - ax - char_interval / 2 * Math.cos(aa)),(float) (y0 + ay + char_interval / 2 * Math.sin(aa)));
				}
			} else {
				// 中心点的右边
				for (int i = second; i < ilength; i++) {
					double aa = (i - second + 0.5) * a;
					double ax = radius2 * Math.sin(aa);
					double ay = radius2 - radius2 * Math.cos(aa);
					AffineTransform transform = AffineTransform.getRotateInstance(aa);// ,x0 + ax, y0 + ay);
					Font f2 = f.deriveFont(transform);
					g2.setFont(f2);

					g2.drawString(messages[i],(float) (x0 + ax - char_interval / 2* Math.cos(aa)),(float) (y0 + ay - char_interval / 2 * Math.sin(aa)));
				}
				// 中心点的左边
				for (int i = first; i > -1; i--) {
					double aa = (first - i + 0.5) * a;
					double ax = radius2 * Math.sin(aa);
					double ay = radius2 - radius2 * Math.cos(aa);
					AffineTransform transform = AffineTransform.getRotateInstance(-aa);// ,x0 + ax, y0 + ay);

					Font f2 = f.deriveFont(transform);
					g2.setFont(f2);
					g2.drawString(messages[i],(float) (x0 - ax - char_interval / 2 * Math.cos(aa)),(float) (y0 + ay + char_interval / 2 * Math.sin(aa)));
				}
			}
			g2.dispose();
			// 保存文件    
			ImageIO.write(image, "png", new File("c:/test.png"));
			
			
		}
	}
}
