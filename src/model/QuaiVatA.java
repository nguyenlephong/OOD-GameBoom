package model;

import java.awt.Graphics;

public class QuaiVatA extends QuaiVat {

	public QuaiVatA(int toaDoX, int toaDoY) {
		super(toaDoX, toaDoY);
		this.tocDo = 200;
		this.rong = 20;
		this.cao=30;
		this.huong = xuong;
		// TODO Auto-generated constructor stub
	}
@Override
public void veQuaiVat(Graphics g) {
	if(!chet){
//		len = 1, xuong = 2, trai = 3, phai = 4;
		switch (huong) {
		case 1:
			g.drawImage(hinhAnh.quaiVatLen, toaDoX * 20+10 , toaDoY * 20, rong, cao, null);
			break;
		case 2:
			g.drawImage(hinhAnh.quaiVatXuong, toaDoX * 20+10 , toaDoY * 20, rong, cao, null);
			break;
		case 3:
			g.drawImage(hinhAnh.quaiVatTrai, toaDoX * 20+10 , toaDoY * 20, rong, cao, null);
			break;
		case 4:
			g.drawImage(hinhAnh.quaiVatPhai, toaDoX * 20+10 , toaDoY * 20, rong, cao, null);
			break;
		default:
			break;
		}
		
	}	
}
@Override
public void kiemTraHuong(int xHero, int yHero, int[][] map) {
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
		System.out.println("");
	}
		
	
}

/*@Override
public void kiemTraHuong(int xHero, int yHero, int[][] map) {
	try {
		if (xHero != toaDoX && yHero != toaDoY) {
			if(xHero < toaDoX ){
				huong = trai;
			}
			else if (yHero > toaDoY) {
				huong = xuong;
			}
			else if (yHero < toaDoX) {
				huong = len;
			}
			else if (xHero > toaDoX) {
				huong = phai;
			}
			
			
		}
		
	} catch (Exception e) {
		System.out.println("Lỗi kiemTraHuong Quai Vat A"+ e.getMessage());
	}
		}
		*/
}
