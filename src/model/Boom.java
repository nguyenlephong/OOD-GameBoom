package model;

import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;

import controller.ControllerTong;

/**
 * Phần code này đã được copy hoàn toàn từ project của phong.
 * Chạy ổn định và phần code cũ được xóa bỏ hẳn do ko cần thiết
 * 
 * 
 * */

public abstract class Boom {
	private int toaDoX;
	private int toaDoY;
	private int levelBoom;
	protected VeBoomStrategy strategy;
	//mang vitri là mang chua vi tri cac noi boom no,dung de xu ly hero bi mat mau
	public static ArrayList<Point> vitri = new ArrayList<>();
	public static ArrayList<Point> vitriTrungBoss = new ArrayList<>();

	BanDo banDo=ControllerTong.banDo;

	// Tao bien boolean de dung timer
	public static boolean dungTimerBatDauNoBom = false;
	public static boolean dungTimerSauKhiBomNo = false;

	private int tren;
	private int duoi;
	private int trai;
	private int phai;

	private int vatCanTren = 0;
	private int vatCanduoi = 0;
	private int vatCanTrai = 0;
	private int vatCanPhai = 0;

	private int chieuDaiKhung = 20;

	
	public Boom(int toaDoX, int toaDoY) {
		super();
		this.toaDoX = toaDoX;
		this.toaDoY = toaDoY;
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

	public int getLevelBoom() {
		return levelBoom;
	}

	public void setLevelBoom(int levelBoom) {
		this.levelBoom = levelBoom;
	}
	
//	public void veBoom(Graphics g) {
//		banDo.getMap()[getToaDoY()][getToaDoX()]=10;
//		//g.drawImage(HinhAnh.boom, getToaDoX() * 20 + 10, getToaDoY() * 20 + 10, null);
//		
//	}
	public void veBoom(Graphics g){
		strategy.veBoom(g, getToaDoX(), getToaDoY());
	}
	public void bombNo(Graphics g) {
//		AmThanh.music(AmThanh.Sound_Bomb);
		g.drawImage(HinhAnh.boomNo, getToaDoX() * 20 + 10, getToaDoY() * 20 + 10, 20, 20, null);
		banDo.getMap()[getToaDoY()][getToaDoX()] = 0;
		vitri.add(new Point(getToaDoX(), getToaDoY()));
		for (int i = 1; i <= ControllerTong.nhanVat.getCapDoBoom(); i++) {
			tren = getToaDoY() - i;
			duoi = getToaDoY() + i;
			trai = getToaDoX() - i;
			phai = getToaDoX() + i;
			if (getToaDoX() > (i - 1)) {
				if (ControllerTong.banDo.getMap()[getToaDoY()][getTrai()] == 3||ControllerTong.banDo.getMap()[getToaDoY()][getTrai()] == 9) {
					setVatCanTrai(1);
				}
			}
			if (getToaDoX() < (getChieuDaiKhung() - i)) {
				if (ControllerTong.banDo.getMap()[getToaDoY()][getPhai()] == 3||ControllerTong.banDo.getMap()[getToaDoY()][getPhai()] == 9) {
					setVatCanPhai(1);
				}
			}
			if (getToaDoY() > (i - 1)) {
				if (ControllerTong.banDo.getMap()[getTren()][getToaDoX()] == 3||ControllerTong.banDo.getMap()[getTren()][getToaDoX()] == 9) {
					setVatCanTren(1);
				}
			}
			if (getToaDoY() < (getChieuDaiKhung() - i)) {
				if (ControllerTong.banDo.getMap()[getDuoi()][getToaDoX()] == 3||ControllerTong.banDo.getMap()[getDuoi()][getToaDoX()] == 9) {
					setVatCanduoi(1);
				}
			}
			if (getVatCanTrai() == 0) {
				if (getToaDoX() > (i - 1)) {
					g.drawImage(HinhAnh.boomNo, getTrai() * 20 + 10, getToaDoY() * 20 + 10, null);
					ControllerTong.banDo.getMap()[getToaDoY()][getTrai()] = 0;
					vitri.add(new Point(getTrai(), getToaDoY()));
					vitriTrungBoss.add(new Point(getTrai(), getToaDoY()));
				}
			}

			if (getVatCanPhai() == 0) {
				if (getToaDoX() < (chieuDaiKhung - i)) {
					g.drawImage(HinhAnh.boomNo, getPhai() * 20 + 10, getToaDoY() * 20 + 10, null);
					ControllerTong.banDo.getMap()[getToaDoY()][getPhai()] = 0;
					vitri.add(new Point(getPhai(), getToaDoY()));
					vitriTrungBoss.add(new Point(getPhai(), getToaDoY()));
				}
			}
			if (getVatCanTren() == 0) {
				if (getToaDoY() > (i - 1)) {
					g.drawImage(HinhAnh.boomNo, getToaDoX() * 20 + 10, getTren() * 20 + 10, null);
					ControllerTong.banDo.getMap()[getTren()][getToaDoX()] = 0;
					vitri.add(new Point(getToaDoX(), getTren()));
					vitriTrungBoss.add(new Point(getToaDoX(), getTren()));
				}
			}
			if (getVatCanduoi() == 0) {
				if (getToaDoY() < (chieuDaiKhung - i)) {
					g.drawImage(HinhAnh.boomNo, getToaDoX() * 20 + 10, getDuoi() * 20 + 10, null);
					ControllerTong.banDo.getMap()[getDuoi()][getToaDoX()] = 0;
					vitri.add(new Point(getToaDoX(), getDuoi()));
					vitriTrungBoss.add(new Point(getToaDoX(), getDuoi()));
				}
			}
		}
		setVatCanTren(0);
		setVatCanduoi(0);
		setVatCanTrai(0);
		setVatCanPhai(0);

	}

	public static boolean isDungTimerBatDauNoBom() {
		return dungTimerBatDauNoBom;
	}

	public static void setDungTimerBatDauNoBom(boolean dungTimerBatDauNoBom) {
		Boom.dungTimerBatDauNoBom = dungTimerBatDauNoBom;
	}

	public static boolean isDungTimerSauKhiBomNo() {
		return dungTimerSauKhiBomNo;
	}

	public static void setDungTimerSauKhiBomNo(boolean dungTimerSauKhiBomNo) {
		Boom.dungTimerSauKhiBomNo = dungTimerSauKhiBomNo;
	}

	public int getTren() {
		return tren;
	}

	public void setTren(int tren) {
		this.tren = tren;
	}

	public int getDuoi() {
		return duoi;
	}

	public void setDuoi(int duoi) {
		this.duoi = duoi;
	}

	public int getTrai() {
		return trai;
	}

	public void setTrai(int trai) {
		this.trai = trai;
	}

	public int getPhai() {
		return phai;
	}

	public void setPhai(int phai) {
		this.phai = phai;
	}

	public int getVatCanTren() {
		return vatCanTren;
	}

	public void setVatCanTren(int vatCanTren) {
		this.vatCanTren = vatCanTren;
	}

	public int getVatCanduoi() {
		return vatCanduoi;
	}

	public void setVatCanduoi(int vatCanduoi) {
		this.vatCanduoi = vatCanduoi;
	}

	public int getVatCanTrai() {
		return vatCanTrai;
	}

	public void setVatCanTrai(int vatCanTrai) {
		this.vatCanTrai = vatCanTrai;
	}

	public int getVatCanPhai() {
		return vatCanPhai;
	}

	public void setVatCanPhai(int vatCanPhai) {
		this.vatCanPhai = vatCanPhai;
	}

	public int getChieuDaiKhung() {
		return chieuDaiKhung;
	}

	public void setChieuDaiKhung(int chieuDaiKhung) {
		this.chieuDaiKhung = chieuDaiKhung;
	}
	public ArrayList<Point> getVitri() {
		return vitri;
	}

	public void setVitri(ArrayList<Point> vitri) {
		this.vitri = vitri;
	}

	
}
