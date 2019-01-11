package model;

import java.awt.Graphics;

public class QuaiVatB extends QuaiVat {

	public QuaiVatB(int toaDoX, int toaDoY) {
		super(toaDoX, toaDoY);
		this.tocDo = 2;
		this.rong = 20;
		this.cao = 25;
		huong = xuong;
	}
@Override
public void veQuaiVat(Graphics g) {
	if(!chet){
		if(huong == trai){
		g.drawImage(hinhAnh.quaiVatTrai, toaDoX * 20+10 , toaDoY * 20, rong, cao, null);
	}
		else if(huong == phai){
			g.drawImage(hinhAnh.quaiVatPhai, toaDoX * 20+10 , toaDoY * 20, rong, cao, null);
		}
	}
}
@Override
public void kiemTraHuong(int xHero, int yHero, int[][] map) {
	try {
		if (xHero != toaDoX && yHero != toaDoY) {
			
			if (kiemTraDiChuyen(toaDoX-1,(toaDoY),map) && huong != phai ) {
				if(toaDoX-1<=1){	
					huong = phai;
				}
				else{ 
					huong = trai;
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
		}
		
	} catch (Exception e) {
		System.out.println("");
	}
		}
}
