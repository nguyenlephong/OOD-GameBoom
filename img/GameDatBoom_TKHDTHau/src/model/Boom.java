package model;

import java.awt.Graphics;

public class Boom {
	private int toaDoX;
	private int toaDoY;
	private int levelBoom;
	//Tao bien boolean de dung timer
	public static boolean dungTimerBatDauNoBom=false;
	public static boolean dungTimerSauKhiBomNo=false;
	
	private  int tren;
	private  int duoi;
	private  int trai;
	private  int phai;
	
	private int vatCanTren=0;
	private int vatCanduoi=0;
	private int vatCanTrai=0;
	private int vatCanPhai=0;
	
	private int chieuDaiKhung=20;
	public Boom(int toaDoX, int toaDoY) {
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
	public void veBoom(Graphics g){
		g.drawImage(HinhAnh.boom, getToaDoX() * 20 + 10, getToaDoY() * 20 + 10, null);
	}
	public void bombNo(Graphics g) {
		g.drawImage(HinhAnh.boomNo, getToaDoX() * 20 + 10, getToaDoY() * 20 + 10, 20, 20, null);
		BanDo.mapGame[getToaDoY()][getToaDoX()] = 0;
		for (int i = 1; i <=NhanVat.capDoBoom; i++) {
			tren=getToaDoY()-i;
			duoi=getToaDoY()+i;
			trai=getToaDoX()-i;
			phai=getToaDoX()+i;
			if(getToaDoX()>(i-1)){
				if(BanDo.mapGame[getToaDoY()][getTrai()]==3){
					setVatCanTrai(1);
				}
			}
			if(getToaDoX()<(getChieuDaiKhung()-i)){
				if(BanDo.mapGame[getToaDoY()][getPhai()]==3){
					setVatCanPhai(1);
				}
			}
			if(getToaDoY()>(i-1)){
				if(BanDo.mapGame[getTren()][getToaDoX()]==3){
					setVatCanTren(1);;
				}
			}
			if(getToaDoY()<(getChieuDaiKhung()-i)){
				if(BanDo.mapGame[getDuoi()][getToaDoX()]==3){
					setVatCanduoi(1);
				}
			}
			if(getVatCanTrai()==0){
				if(getToaDoX()>(i-1)){
					g.drawImage(HinhAnh.getBoomNo(), getTrai()*20+10, getToaDoY()*20+10, null);
					BanDo.mapGame[getToaDoY()][getTrai()]=0;
				}
			}
			
			
			if(getVatCanPhai()==0){
				if(getToaDoX()<(chieuDaiKhung-i)){
					g.drawImage(HinhAnh.getBoomNo(), getPhai()*20+10, getToaDoY()*20+10, null);
					BanDo.mapGame[getToaDoY()][getPhai()]=0;	
				}
			}
			if(getVatCanTren()==0){
				if(getToaDoY()>(i-1)){
					g.drawImage(HinhAnh.getBoomNo(), getToaDoX()*20+10, getTren()*20+10, null);
					BanDo.mapGame[getTren()][getToaDoX()]=0;
				}				
			}
			if(getVatCanduoi()==0){
				if(getToaDoY()<(chieuDaiKhung-i)){
					g.drawImage(HinhAnh.getBoomNo(), getToaDoX()*20+10,getDuoi()*20+10, null);
					BanDo.mapGame[getDuoi()][getToaDoX()]=0;
					
				}
			}
		}
		setVatCanTren(0);setVatCanduoi(0);setVatCanTrai(0);setVatCanPhai(0);
		
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
	
}
