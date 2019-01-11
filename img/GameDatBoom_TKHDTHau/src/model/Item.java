package model;

import java.awt.Graphics;

import view.VaoGame;

public class Item {
	private int xItem;
	private int yItem;
	private String tenItem;
	public static boolean xuatHienItemBoom;
	public static boolean xuatHienItemLua;
	public static boolean xuatHienItemHeart;
	public static boolean nhanItemChua;

	public Item(int xItem, int yItem, String tenItem) {
		super();
		this.xItem = xItem;
		this.yItem = yItem;
		this.tenItem = tenItem;
	}

	public void veItem(Graphics g) {
		if (getTenItem().equals("itemBomb")) {
			g.drawImage(HinhAnh.itemBomb, getxItem() * 20 + 10, getyItem() * 20 + 10, 20, 20, null);
		}
		if (getTenItem().equals("itemLua")) {
			g.drawImage(HinhAnh.itemLua, getxItem() * 20 + 10, getyItem() * 20 + 10, 20, 20, null);
		}
		if (getTenItem().equals("itemHeart")) {
			g.drawImage(HinhAnh.itemHeart, getxItem() * 20 + 10, getyItem() * 20 + 10, 20, 20, null);
		}
	}

	public static boolean isXuatHienItemBoom() {
		return xuatHienItemBoom;
	}

	public static boolean isXuatHienItemLua() {
		return xuatHienItemLua;
	}

	public static boolean isXuatHienItemHeart() {
		return xuatHienItemHeart;
	}

	public static boolean isNhanItemChua() {
		return nhanItemChua;
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

	public boolean itemXuatHien(Boom bomb) {
		if (xItem == bomb.getToaDoX() && yItem == bomb.getToaDoY()) {
			return true;
		}
		if (xItem == bomb.getToaDoX() + 1 && yItem == bomb.getToaDoY()) {
			return true;
		}
		if (xItem == bomb.getToaDoX() - 1 && yItem == bomb.getToaDoY()) {
			return true;
		}
		if (xItem == bomb.getToaDoX() && yItem == bomb.getToaDoY() + 1) {
			return true;
		}
		if (xItem == bomb.getToaDoX() && yItem == bomb.getToaDoY() - 1) {
			return true;
		} else
			return false;
	}
}
