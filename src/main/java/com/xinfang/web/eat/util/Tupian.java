package com.xinfang.web.eat.util;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

public class Tupian {
	
	
	public static BufferedImage creatImage(){
        int width=300, height=300;
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        final Graphics2D g2d = image.createGraphics();
        g2d.setColor(new Color(255, 0, 0));
        g2d.fillOval(100, 100, 100, 100);
        g2d.setColor(new Color(0, 255, 0));
        g2d.fillOval(105, 105, 90, 90);
        return image;
    }
}
