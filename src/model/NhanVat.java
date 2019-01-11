package model;

import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;
import java.util.Observable;

import javax.swing.JOptionPane;

import controller.ControllerTong;

import java.util.*;

public class NhanVat extends Observable implements Observer {
	public static final int LEN = 1, XUONG = 2, TRAI = 3, PHAI = 4;
	private int chieuRong = 20, chieuCao = 30;
	private int huongDi;
	private int toaDoX;
	private int toaDoY;
	private int capDoBoom;
	private int lua;
	private int soMang;
	private int diemSo;
	private int manChoi;
	private HinhAnh hinhAnh;
	private DanhSachQuaiVat observable;
	private ArrayList<Boom> danhSachBoom; // khoa da them phan nay
	private ArrayList<Boom> dsBoomNo;
	private int soBoomDuocDat;

	public NhanVat(int huongDi, int toaDoX, int toaDoY, int capDoBoom, int soMang, int diemSo, int manChoi,
			HinhAnh hinhAnh) {
		this.huongDi = huongDi;
		this.toaDoX = toaDoX;
		this.toaDoY = toaDoY;
		this.capDoBoom = capDoBoom;
		this.lua = capDoBoom;
		this.soMang = soMang;
		this.diemSo = diemSo;
		this.manChoi = manChoi;
		this.hinhAnh = hinhAnh;
		this.danhSachBoom = new ArrayList<>();
		this.dsBoomNo = new ArrayList<>();
		observable.getInstance().addObserver(this);
		this.soBoomDuocDat = 2;
	}

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		if (o instanceof DanhSachQuaiVat) {
			setManChoi(getManChoi() + 1);
		}
		else if(o instanceof QuaiVat){
			QuaiVat qv = (QuaiVat) o;
			int count =0;
			if(qv.getToaDoX() == toaDoX && qv.getToaDoY() == toaDoY ){
				diemSo--;
			}
		}
	}

	// khoa da them phan nay
	public void veHinh(Image img, int x, int y, Graphics g) {
		g.drawImage(img, x * chieuRong + 10, y * chieuRong, chieuRong, chieuCao, null);
	}

	// khoa da sua phan nay
	public void setChangeViTri(int x, int y, String item) {
		this.toaDoX = x;
		this.toaDoY = y;
		// this.huongDi = huong;
		setChanged();
		// notifyObservers();
		notifyObservers(item);
		countObservers();
	}

	/*
	 * Khoa da sua phan nay
	 * 
	 */
	public void veNhanVat(Graphics g) {
		switch (huongDi) {
		case LEN:
			veHinh(hinhAnh.nhanVatXoayLen, toaDoX, toaDoY, g);
			break;
		case XUONG:
			veHinh(hinhAnh.nhanVatXoayXuong, toaDoX, toaDoY, g);
			break;
		case TRAI:
			veHinh(hinhAnh.nhanVatXoayTrai, toaDoX, toaDoY, g);
			break;
		case PHAI:
			veHinh(hinhAnh.nhanVatXoayPhai, toaDoX, toaDoY, g);
			break;
		default:
			break;
		}
		for (int i = 0; i < danhSachBoom.size(); i++) {
			danhSachBoom.get(i).veBoom(g);
		}
		for (int i = 0; i < dsBoomNo.size(); i++) {
			dsBoomNo.get(i).bombNo(g);
		}
		for (int i = 0; i < dsBoomNo.size(); i++) {
			// AmThanh.music(AmThanh.Sound_Bomb);
			dsBoomNo.get(i).bombNo(g);
			new ControllerTong().boomNoTimer.stop();
			;
		}
	}

	public void xuLyTrungBom(int x, int y) {
		if (toaDoX == x && toaDoY == y) {
			soMang--;
		}
	}

	public int getLua() {
		return lua;
	}

	public void setLua(int lua) {
		this.lua = lua;
	}

	public int getHuongDi() {
		return huongDi;
	}

	public void setHuongDi(int huongDi) {
		this.huongDi = huongDi;
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

	public int getCapDoBoom() {
		return capDoBoom;
	}

	public void setCapDoBoom(int capDoBoom) {
		this.capDoBoom = capDoBoom;
	}

	public int getSoMang() {
		return soMang;
	}

	public void setSoMang(int soMang) {
		this.soMang = soMang;
	}

	public int getDiemSo() {
		return diemSo;
	}

	public void setDiemSo(int diemSo) {
		this.diemSo = diemSo;
	}

	public int getManChoi() {
		return manChoi;
	}

	public void setManChoi(int manChoi) {
		this.manChoi = manChoi;
	}

	public ArrayList<Boom> getDanhSachBoom() {
		return danhSachBoom;
	}

	public void setDanhSachBoom(ArrayList<Boom> danhSachBoom) {
		this.danhSachBoom = danhSachBoom;
	}

	public ArrayList<Boom> getDsBoomNo() {
		return dsBoomNo;
	}

	public int getSoBoomDuocDat() {
		return soBoomDuocDat;
	}

	public void setSoBoomDuocDat(int soBoomDuocDat) {
		this.soBoomDuocDat = soBoomDuocDat;
	}

}
