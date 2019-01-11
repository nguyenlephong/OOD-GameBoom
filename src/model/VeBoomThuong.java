package model;

import java.awt.Graphics;

public class VeBoomThuong implements VeBoomStrategy {
	@Override
	public void veBoom(Graphics g, int xBoom, int yBoom) {
		g.drawImage(HinhAnh.boom, xBoom * 20 + 10, yBoom * 20 + 10, null);
	}

}
