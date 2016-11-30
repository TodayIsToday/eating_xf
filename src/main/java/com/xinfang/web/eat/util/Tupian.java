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

import javax.imageio.ImageIO;

import org.apache.commons.lang3.StringUtils;

public class Tupian {

	private static final String centerName = "黄凯专用章";
	public static void main(String[] args) throws Exception {

		
		// 设置字体属性
		int fontsize = 40;

		String codeOut = "123"; // code
		String organName = "生与死轮回不止，我们生他们死"; // before name

		String _match1 = "(", _match2 = "（", _match3 = "、"; // reg
		int organNameNumber = organName.length(); // 单位名称长度
		// 1.去除括号中子
		if (StringUtils.contains(organName, _match1)) {
			int reg = organName.indexOf(_match1);
			organName = organName.substring(0, reg);
			organNameNumber = organName.length(); // 单位名称长度
		} else if (StringUtils.contains(organName, _match2)) {
			int reg = organName.indexOf(_match2);
			organName = organName.substring(0, reg);
			organNameNumber = organName.length(); // 单位名称长度
		}
		// 去除顿号
		if (StringUtils.contains(organName, _match3)) {
			organName = organName.replace(_match3, StringUtils.EMPTY);
			organNameNumber = organNameNumber -1;
		}

		// 2.动态判断字体大小
		if (0 < organNameNumber && organNameNumber < 14) {
			fontsize = 50;
		} else if (14 <= organNameNumber && organNameNumber < 17) {
			fontsize = 43;
		}else if (17 <= organNameNumber && organNameNumber < 20) {
			fontsize = 37;
		}else if (20 <= organNameNumber && organNameNumber < 100) {
			fontsize = 30;
		} else {
			System.out.print("字数超出范围name:{},code:{}");
		}

		String message = organName;

		BufferedImage image = null;
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
			// g2.setFont(new Font("宋体", Font.LAYOUT_LEFT_TO_RIGHT, 40));// 写入签名
			g2.setFont(new Font("宋体", Font.BOLD, 65));
			if (centerName != null) {
				g2.drawString(centerName, 80, 380);
			}
			// 根据输入字符串得到字符数组

			String[] messages2 = message.split("", 0);
			String[] messages = new String[messages2.length - 1];
			System.arraycopy(messages2, 1, messages, 0, messages2.length - 1);
			// 输入的字数
			int ilength = messages.length;

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
				g2.drawString(messages[first], (float) (x0 - char_interval / 2), (float) y0);
				// 中心点的右边
				for (int i = first + 1; i < ilength; i++) {
					double aa = (i - first) * a;
					double ax = radius2 * Math.sin(aa);
					double ay = radius2 - radius2 * Math.cos(aa);
					AffineTransform transform = AffineTransform.getRotateInstance(aa);// ,x0
																						// +
																						// ax,
																						// y0
																						// +
																						// ay);
					Font f2 = f.deriveFont(transform);
					g2.setFont(f2);
					g2.drawString(messages[i], (float) (x0 + ax - char_interval / 2 * Math.cos(aa)),
							(float) (y0 + ay - char_interval / 2 * Math.sin(aa)));
				}
				// 中心点的左边
				for (int i = first - 1; i > -1; i--) {
					double aa = (first - i) * a;
					double ax = radius2 * Math.sin(aa);
					double ay = radius2 - radius2 * Math.cos(aa);
					AffineTransform transform = AffineTransform.getRotateInstance(-aa);// ,x0
																						// +
																						// ax,
																						// y0
																						// +
																						// ay);
					Font f2 = f.deriveFont(transform);
					g2.setFont(f2);
					g2.drawString(messages[i], (float) (x0 - ax - char_interval / 2 * Math.cos(aa)),
							(float) (y0 + ay + char_interval / 2 * Math.sin(aa)));
				}
			} else {
				// 中心点的右边
				for (int i = second; i < ilength; i++) {
					double aa = (i - second + 0.5) * a;
					double ax = radius2 * Math.sin(aa);
					double ay = radius2 - radius2 * Math.cos(aa);
					AffineTransform transform = AffineTransform.getRotateInstance(aa);// ,x0
																						// +
																						// ax,
																						// y0
																						// +
																						// ay);
					Font f2 = f.deriveFont(transform);
					g2.setFont(f2);

					g2.drawString(messages[i], (float) (x0 + ax - char_interval / 2 * Math.cos(aa)),
							(float) (y0 + ay - char_interval / 2 * Math.sin(aa)));
				}
				// 中心点的左边
				for (int i = first; i > -1; i--) {
					double aa = (first - i + 0.5) * a;
					double ax = radius2 * Math.sin(aa);
					double ay = radius2 - radius2 * Math.cos(aa);
					AffineTransform transform = AffineTransform.getRotateInstance(-aa);// ,x0
																						// +
																						// ax,
																						// y0
																						// +
																						// ay);

					Font f2 = f.deriveFont(transform);
					g2.setFont(f2);
					g2.drawString(messages[i], (float) (x0 - ax - char_interval / 2 * Math.cos(aa)),
							(float) (y0 + ay + char_interval / 2 * Math.sin(aa)));
				}
			}
			g2.dispose();
			// 保存文件
			ImageIO.write(image, "png", new File("d:/" + codeOut + ".png"));
			// ByteArrayOutputStream os = new ByteArrayOutputStream();
			// ImageIO.write(image, "png", os);
			// is = new ByteArrayInputStream(os.toByteArray());
		}

	}
}
