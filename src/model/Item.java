package model;

import java.awt.Graphics;

public class Item {
	private int xItem;
	private int yItem;
	private HinhAnh hinhAnh;
	private String tenItem;

	public Item(int xItem, int yItem, HinhAnh hinhAnh, String tenItem) {
		super();
		this.xItem = xItem;
		this.yItem = yItem;
		this.hinhAnh = hinhAnh;
		this.tenItem = tenItem;
	}

	public void veItem(Graphics g) {
		switch (tenItem) {
		case "itemBoom":
			g.drawImage(hinhAnh.itemBomb, xItem*20+10, yItem*20+10,20,20, null);
			break;
		case "itemLua":
			g.drawImage(hinhAnh.itemLua, xItem*20+10, yItem*20+10,20,20, null);
			break;
		case "itemHeart":
			g.drawImage(hinhAnh.itemHeart, xItem*20+10, yItem*20+10,20,20, null);
			break;
		default:
			break;
		}
	}

	public int getxItem() {
		return xItem;
	}

	public void setxItem(int xItem) {
		this.xItem = xItem;
	}

	public int getyItem() {
		return yItem;
	}

	public void setyItem(int yItem) {
		this.yItem = yItem;
	}

	public String getTenItem() {
		return tenItem;
	}

	public void setTenItem(String tenItem) {
		this.tenItem = tenItem;
	}
}
