package model;

import java.awt.Graphics;
import java.util.Observable;

public class Boss extends Observable {
	private int toaDoX;
	private int toaDoY;
	private int sinhLuc;
	private HinhAnh hinhAnh;

	public Boss(int toaDoX, int toaDoY, int sinhLuc, HinhAnh hinhAnh) {
		this.toaDoX = toaDoX;
		this.toaDoY = toaDoY;
		this.sinhLuc = sinhLuc;
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

	public void diXuong() {
		toaDoY++;
	}

	public void diLen() {
		toaDoY--;
	}

	public void sangTrai() {
		toaDoX--;
	}

	public void sangPhai() {
		toaDoX++;
	}

	public int getSinhLuc() {
		return sinhLuc;
	}

	public void setSinhLuc(int sinhLuc) {
		this.sinhLuc = sinhLuc;
		setChanged();
		notifyObservers();
	}

	public void veBoss(Graphics g) {
		g.drawImage(hinhAnh.boss, getToaDoX() + 10, getToaDoY() - 10, 60, 60, null);
	}
}
