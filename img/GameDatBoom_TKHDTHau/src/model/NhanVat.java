package model;

import java.awt.Graphics;
import java.util.ArrayList;

import controller.ControllerTong;

public class NhanVat {
	private int huongDi;
	private int toaDoX;
	private int toaDoY;
	public static int soMang;
	private int manChoi;
	public static int capDoBoom;
	private HinhAnh hinhAnh;
	public static final int LEN=1,XUONG=2,TRAI=3,PHAI=4;
	public static ArrayList<Boom> listBomb;
	public static ArrayList<Boom> listBombNo;
	public static ArrayList<Boom> dsViTriBomb = new ArrayList<>();
	
	public NhanVat(int huongDi, int toaDoX, int toaDoY, int capDoBoom, int soMang, int manChoi,HinhAnh hinhAnh) {
		this.huongDi = huongDi;
		this.toaDoX = toaDoX;
		this.toaDoY = toaDoY;
		this.soMang = soMang;
		this.manChoi = manChoi;
		this.hinhAnh=hinhAnh;
		this.capDoBoom=capDoBoom;
		listBomb=new ArrayList<>();
		listBombNo=new ArrayList<>();
	}
	public ArrayList<Boom> getListBoom() {
		return listBomb;
	}

	public ArrayList<Boom> getListBoomNo() {
		return listBombNo;
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
	public int getSoMang() {
		return soMang;
	}
	public void setSoMang(int soMang) {
		this.soMang = soMang;
	}
	public int getManChoi() {
		return manChoi;
	}
	public void setManChoi(int manChoi) {
		this.manChoi = manChoi;
	}
	
	public int getCapDoBoom() {
		return capDoBoom;
	}
	public void setCapDoBoom(int capDoBoom) {
		this.capDoBoom = capDoBoom;
	}
	public void veNhanVat(Graphics g){
			switch (huongDi) {
			case LEN:
				g.drawImage(hinhAnh.nhanVatXoayLen, toaDoX*20+10, toaDoY*20,20,30,null);
				break;
			case XUONG:
				g.drawImage(hinhAnh.nhanVatXoayXuong, toaDoX*20+10, toaDoY*20,20,30,null);
				break;
			case TRAI:
				g.drawImage(hinhAnh.nhanVatXoayTrai, toaDoX*20+10, toaDoY*20,20,30,null);
				break;
			case PHAI:
				g.drawImage(hinhAnh.nhanVatXoayPhai, toaDoX*20+10, toaDoY*20,20,30,null);
				break;
			default:
				break;
			}
			ArrayList<Boom>dsBoom=getListBoom();
			for (int i = 0; i < dsBoom.size(); i++) {
				listBomb.get(i).veBoom(g);
			}
			ArrayList<Boom>dsBoomNo=getListBoomNo();
			for (int i = 0; i < dsBoomNo.size(); i++) {
				listBombNo.get(i).bombNo(g);
				
			}
	}

	public boolean isNhanDuocItem(Item item) {
		if (toaDoX == item.getxItem() && toaDoY == item.getyItem()) {
			return true;
		} else
			return false;

	}
}
