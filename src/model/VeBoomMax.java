package model;

import java.awt.Graphics;

public class VeBoomMax implements VeBoomStrategy {

	@Override
	public void veBoom(Graphics g, int xBoom, int yBoom) {
		g.drawImage(HinhAnh.boomMax, xBoom * 20 + 10, yBoom * 20 + 10, null);
	}

}
