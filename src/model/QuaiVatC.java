package model;

import java.awt.Graphics;

public class QuaiVatC extends QuaiVat {

	public QuaiVatC(int toaDoX, int toaDoY) {
		super(toaDoX, toaDoY);
		this.tocDo = 700;
		this.rong = 20;
		this.cao = 30;
		huong = xuong;
	}
	@Override
	public void veQuaiVat(Graphics g) {
		if(!chet){
			if(huong == xuong){
				g.drawImage(hinhAnh.quaiVatXuong, toaDoX * 20+10 , toaDoY * 20, rong, cao, null);
			}
				else if(huong == len){
					g.drawImage(hinhAnh.quaiVatLen, toaDoX * 20+10 , toaDoY * 20, rong, cao, null);
				}
		}	
	}
	@Override
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

		
	}
	@Override
	public void kiemTraHuong(int xHero,int yHero,int[][] map){
		try {
		 if (xHero != toaDoX && yHero != toaDoY) {
			/*	if (kiemTraDiChuyen(toaDoX-1,(toaDoY),map) && huong != phai ) {
					if(toaDoX-1<=0){	
						huong = len;
					}
					else{ 
						huong = trai;
					}
				}*/
			 if (kiemTraDiChuyen(toaDoX, (toaDoY + 1), map )&& huong != len) {
					huong = xuong;
					if((toaDoY+1) >= 18){
						huong = len;
					}
				}
			
			/*	else if (kiemTraDiChuyen((toaDoX + 1), toaDoY, map) &&  huong != trai  ) {
					if((toaDoX+1) >=19){
						huong = trai;
					}
					else{
						huong = phai;
						}
				}*/
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
}
