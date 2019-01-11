package model;

import java.awt.Graphics;

public class QuaiVat {
	private int toaDoX;
	private int toaDoY;
	private HinhAnh hinhAnh;
	public QuaiVat(int toaDoX, int toaDoY, HinhAnh hinhAnh) {
		super();
		this.toaDoX = toaDoX;
		this.toaDoY = toaDoY;
		this.hinhAnh = hinhAnh;
	}
	public int getToaDoX() {
		return toaDoX;
	}
	public void setToaDoX(int toaDoX) {
		this.toaDoX = toaDoX;
	}
	public int getToaDoY() {
		return toaDoY;
	}
	public void setToaDoY(int toaDoY) {
		this.toaDoY = toaDoY;
	}
	public HinhAnh getHinhAnh() {
		return hinhAnh;
	}
	public void setHinhAnh(HinhAnh hinhAnh) {
		this.hinhAnh = hinhAnh;
	}
	public void veQuaiVat(Graphics g){
		g.drawImage(hinhAnh.quaiVat, getToaDoX()*20+10, getToaDoY()*20+10, null);
	}
}
