package model;

import java.awt.Graphics;
import java.util.Observable;
import java.util.Observer;

import controller.ControllerTong;
import view.Game;

public class QuaiVat extends Observable {
	protected int toaDoX;
	protected int toaDoY;
	protected HinhAnh hinhAnh;
	protected int tocDo;
	protected static int len = 1, xuong = 2, trai = 3, phai = 4;
	protected int huong = 4;
	boolean chet = false;
	protected int rong =20, cao=20;

	public QuaiVat(int toaDoX, int toaDoY) {
		super();
		this.toaDoX = toaDoX;
		this.toaDoY = toaDoY;
		this.hinhAnh = ControllerTong.hinhAnh;
	}
	public QuaiVat(int toaDoX, int toaDoY,int tocdo) {
		super();
		this.toaDoX = toaDoX;
		this.toaDoY = toaDoY;
		this.hinhAnh = ControllerTong.hinhAnh;
		this.tocDo = tocdo;
	}

public int getTocDo() {
		return tocDo;
	}
	public void setTocDo(int tocDo) {
		this.tocDo = tocDo;
	}
public boolean xuLyTrungBom(int xBom,int yBom){
	if(xBom == toaDoX && yBom == toaDoY){
		 return chet = true;
	}
	return false;
}
	public boolean kiemTraDiChuyen(int xQuaiVat, int yQuaiVat, int[][] map) {
		if (map[yQuaiVat][xQuaiVat] == 0) {
			return true;
		}
	return false;
	}

public void kiemTraHuong(int xHero,int yHero,int[][] map){
	try {
	if (xHero != toaDoX && yHero != toaDoY) {
			if (kiemTraDiChuyen(toaDoX-1,(toaDoY),map) && huong != phai ) {
				if(toaDoX-1<=0){	
					huong = phai;
				}
				else{ 
					huong = trai;
				}
			}
			else if (kiemTraDiChuyen(toaDoX, (toaDoY + 1), map )&& huong != len) {
				huong = xuong;
				if((toaDoY+1) >= 19){
					huong = len;
				}
			}
			else if (kiemTraDiChuyen((toaDoX + 1), toaDoY, map) &&  huong != trai  ) {
				if((toaDoX+1) >=19){
					huong = trai;
				}
				else{
					huong = phai;
					}
			}
			else if (kiemTraDiChuyen((toaDoX ), (toaDoY-1), map) && huong != xuong ) {
				huong = len; 
				if((toaDoY-1) <=0){
					huong = xuong;
				}
			}
		}
		
	} catch (Exception e) {
		System.out.println(" ");
	}
}
	public void diChuyen(int xHero, int yHero, int[][] map) {
		kiemTraHuong(xHero, yHero, map);
		switch (huong) {
		case 1: // len
			toaDoY--;
			break;
		case 2: // xuong
			toaDoY++;
			break;

		case 3: // trai
			toaDoX--;
			break;

		case 4: // phai
			toaDoX++;
			break;

		default:
			break;
		}
setChanged();
notifyObservers();
	}

	public void veQuaiVat(Graphics g) {
		if(!chet)
		g.drawImage(hinhAnh.da5, toaDoX * 20+10 , toaDoY * 20, rong, cao, null);
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
}
