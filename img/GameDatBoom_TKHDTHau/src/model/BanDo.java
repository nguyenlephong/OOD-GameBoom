package model;

import java.awt.Graphics;
import java.io.IOException;

public class BanDo {
	private HinhAnh hinhAnh;
	public static int[][] mapGame = null;
	public static final int CO = 0, BUICO = 1, CAY = 2, DA1 = 3, DA2 = 4, DA3 = 5, DA4 = 6, DA5 = 7, THUNG = 8,
			NUOC = 9;
	public BanDo(HinhAnh hinhAnh,NhanVat nhanVat) throws IOException {
		 this.hinhAnh=hinhAnh;
		 if(nhanVat.getManChoi()==1){
			 mapGame=map1;
		 }
		 if(nhanVat.getManChoi()==2){
			 mapGame=map2;
		 }
		 if(nhanVat.getManChoi()==3){
			 mapGame=map3;
		 }
	}
	private int[][] map1 = {
			{ CO, CO, CAY, CAY, CAY, CAY, CAY, CO, CO, CO, CAY, CO, CO, CO, CAY, CO, CO, CO, CAY, CO },
			{ CAY, CO, CAY, CO, CO, CO, CAY, CO, CAY, CO, CAY, CO, CAY, CO, CAY, CO, CAY, CO, CAY, CO },
			{ DA1, CO, CAY, CO, CAY, CO, CAY, CO, CAY, CO, CAY, CO, CAY, CO, CAY, CO, CAY, CO, CAY, CO },
			{ CO, CO, CAY, CO, CAY, CO, CAY, CO, CAY, CO, CAY, CO, CAY, CO, CAY, CO, CAY, CO, CAY, CO },
			{ DA1, CO, CAY, CO, CAY, CO, CAY, CO, CAY, CO, CAY, CO, CAY, CO, CAY, CO, CAY, CO, CAY, CO },
			{ CO, CO, CAY, CO, CAY, CO, CAY, CO, CAY, CO, CAY, CO, CAY, CO, CAY, CO, CAY, CO, CAY, CO },
			{ DA1, CO, CAY, CO, CAY, CO, CAY, CO, CAY, CO, CAY, CO, CAY, CO, CAY, CO, CAY, CO, CAY, CO },
			{ CO, CO, CAY, CO, CAY, CO, CAY, CO, CAY, CO, CAY, CO, CAY, CO, CAY, CO, CAY, CO, CAY, CO },
			{ DA1, CO, CAY, CO, CAY, CO, CAY, CO, CAY, CO, CAY, CO, CAY, CO, CAY, CO, CAY, CO, CAY, CO },
			{ CO, CO, CAY, CO, CAY, CO, CAY, CO, CAY, CO, CAY, CO, CAY, CO, CAY, CO, CAY, CO, CAY, CO },
			{ DA1, CO, CAY, CO, CAY, CO, CAY, CO, CAY, CO, CAY, CO, CAY, CO, CAY, CO, CAY, CO, CAY, CO },
			{ CO, CO, CAY, CO, CAY, CO, CAY, CO, CAY, CO, CAY, CO, CAY, CO, CAY, CO, CAY, CO, CAY, CO },
			{ DA1, CO, CAY, CO, CAY, CO, CAY, CO, CAY, CO, CAY, CO, CAY, CO, CAY, CO, CAY, CO, CAY, CO },
			{ CO, CO, CAY, CO, CAY, CO, CAY, CO, CAY, CO, CAY, CO, CAY, CO, CAY, CO, CAY, CO, CAY, CO },
			{ DA1, CO, CAY, CO, CAY, CO, CAY, CO, CAY, CO, CAY, CO, CAY, CO, CAY, CO, CAY, CO, CAY, CO },
			{ CO, CO, CAY, CO, CAY, CO, CAY, CO, CAY, CO, CAY, CO, CAY, CO, CAY, CO, CAY, CO, CAY, CO },
			{ DA1, CO, CAY, CO, CAY, CO, CAY, CO, CAY, CO, CAY, CO, CAY, CO, CAY, CO, CAY, CO, CAY, CO },
			{ CO, CO, CAY, CO, CAY, CO, CAY, CO, CAY, CO, CAY, CO, CAY, CO, CAY, CO, CAY, CO, CAY, CO },
			{ CAY, CO, CO, CO, CAY, CO, CAY, CO, CAY, CO, CAY, CO, CAY, CO, CAY, CO, CAY, CO, CAY, CO },
			{ CAY, CAY, CAY, CAY, CAY, CO, CO, CO, CAY, CO, CO, CO, CAY, CO, CO, CO, CAY, CO, CO, CO }

	};

	private int[][] map2 = {
			{ DA1, DA1, DA1, DA1, DA1, DA1, DA1, DA1, DA1, DA2, DA1, DA3, DA1, DA1, DA1, DA1, DA1, DA1, DA1, DA1 },
			{ DA1, DA1, DA1, DA1, DA1, DA1, DA1, DA1, DA1, DA1, DA1, DA1, DA1, DA1, DA1, DA1, DA1, DA1, DA1, DA1 },
			{ DA1, CO, CO, CO, CO, CO, CO, CO, CO, CO, CO, CO, CO, CO, CO, CO, CO, CO, CO, CO },
			{ CO, CO, CO, CO, DA1, CO, DA1, CO, DA1, CO, DA1, CO, DA1, CO, DA1, CO, DA1, CO, DA1, CO },
			{ DA1, CO, DA1, CO, CO, CO, CO, CO, CO, CO, CO, CO, CO, CO, CO, CO, CO, CO, CO, CO },
			{ CO, CO, CO, CO, CO, CO, DA1, CO, DA1, CO, DA1, CO, DA1, CO, DA1, CO, DA1, CO, DA1, CO },
			{ DA1, CO, DA1, CO, DA1, CO, CO, CO, CO, CO, CO, CO, CO, CO, CO, CO, CO, CO, CO, CO },
			{ CO, CO, CO, CO, CO, CO, CO, CO, DA1, CO, DA1, CO, DA1, CO, DA1, CO, DA1, CO, DA1, CO },
			{ DA1, CO, DA1, CO, DA1, CO, DA1, CO, CO, CO, CO, CO, CO, CO, CO, CO, CO, CO, CO, CO },
			{ CO, CO, CO, CO, CO, CO, CO, CO, CO, CO, DA1, CO, DA1, CO, DA1, CO, DA1, CO, DA1, CO },
			{ DA1, CO, DA1, CO, DA1, CO, DA1, CO, DA1, CO, CO, CO, CO, CO, BUICO, BUICO, BUICO, BUICO, BUICO, BUICO },
			{ CO, CO, CO, CO, CO, CO, CO, CO, CO, CO, CO, CO, DA1, CO, DA1, CO, DA1, CO, DA1, CO },
			{ DA1, CO, DA1, CO, DA1, CO, DA1, CO, DA1, CO, DA1, CO, CO, CO, CO, CO, CO, CO, CO, CO },
			{ CO, CO, CO, CO, CO, CO, CO, CO, CO, CO, CO, CO, CO, CO, DA1, CO, DA1, CO, DA1, CO },
			{ DA1, CO, DA1, CO, DA1, CO, DA1, CO, DA1, CO, DA1, CO, DA1, CO, CO, CO, CO, CO, CO, CO },
			{ CO, CO, CO, CO, CO, CO, CO, CO, CO, CO, CO, CO, CO, CO, CO, CO, DA1, CO, DA1, CO },
			{ DA1, CO, DA1, CO, DA1, CO, DA1, CO, DA1, CO, DA1, CO, DA1, CO, DA1, CO, CO, CO, CO, CO },
			{ CO, CO, CO, CO, CO, CO, CO, CO, CO, CO, CO, CO, CO, CO, CO, CO, CO, CO, DA1, CO },
			{ DA1, CO, DA1, CO, DA1, CO, DA1, CO, DA1, CO, DA1, CO, DA1, CO, DA1, CO, DA1, CO, CO, CO },
			{ CO, CO, CO, CO, CO, CO, CO, CO, CO, CO, CO, CO, CO, CO, CO, CO, CO, CO, CO, CO } };

	private int[][] map3 = {
			{ CO, CO, CO, CO, CO, CO, BUICO, BUICO, DA1, BUICO, CO, BUICO, BUICO, CO, BUICO, CO, BUICO, CO, CO, CO },
			{ CO, CAY, CO, CO, CO, BUICO, CO, CO, CO, CAY, CO, CO, CO, CO, CO, CO, CAY, CO, CO, CO },
			{ CO, CAY, CO, CO, CO, CO, CO, CO, CO, CO, CO, CO, CO, CAY, CO, CO, CO, CO, CO, CAY },
			{ CO, CAY, CO, CO, CO, BUICO, CO, CO, CO, CO, CO, DA1, CO, CO, CO, CO, CAY, CO, CO, CO },
			{ CO, CO, CO, CO, CO, CO, CO, CO, CAY, CO, CAY, CO, CO, CO, CO, DA3, DA3, BUICO, CO, CO },
			{ CO, CAY, DA3, DA3, DA3, CO, CO, CO, CO, CO, CO, CO, CAY, CO, CO, DA3, DA3, CO, BUICO, CO },
			{ CO, CAY, DA3, DA3, DA3, CO, CAY, CO, BUICO, BUICO, CO, CO, CO, CO, DA3, DA3, DA3, CAY, CO, CO },
			{ CO, CO, DA3, DA3, CO, CO, CO, CO, CO, CO, CO, BUICO, CAY, CO, DA3, DA3, DA3, CO, CO, CO },
			{ CO, CO, DA3, DA3, CO, BUICO, CO, CAY, BUICO, CO, CO, CO, CO, CO, DA3, DA3, DA3, CO, CO, CAY },
			{ CO, CO, CO, CO, CO, CO, CO, CO, CO, CO, BUICO, CO, CAY, CO, DA3, DA3, DA3, CO, CO, CO },
			{ CO, CAY, CO, CO, CO, CAY, BUICO, BUICO, CO, CAY, CO, CO, CO, CO, CAY, CO, DA3, CO, CAY, CAY },
			{ CO, CO, CO, CO, CO, CO, CO, CAY, BUICO, CO, CO, BUICO, CO, CO, CO, CAY, DA3, CO, CO, CO },
			{ CO, CO, CO, DA1, CO, CAY, CO, DA3, DA3, DA3, DA3, CO, CAY, BUICO, CO, CO, BUICO, CAY, CO, CAY },
			{ CO, CO, CO, CO, CO, CO, BUICO, DA3, DA3, DA3, DA3, BUICO, CO, BUICO, CO, CAY, CO, CO, CAY, CO },
			{ CO, CAY, DA3, DA3, CO, CO, CO, DA3, DA3, DA3, DA3, BUICO, CO, BUICO, CO, BUICO, BUICO, CAY, CO, CAY },
			{ CO, CO, DA3, DA3, CO, CAY, CO, CAY, CO, BUICO, BUICO, CO, CAY, CO, CO, CAY, CO, CO, CO, CO },
			{ BUICO, DA3, DA3, DA3, CO, CO, CO, CO, CO, CO, BUICO, BUICO, CO, CO, CO, CO, CO, CO, CO, CAY },
			{ CO, DA3, DA3, DA3, CAY, CO, CAY, BUICO, CO, BUICO, DA1, CO, CO, BUICO, CO, CAY, CO, DA1, CO, CO },
			{ CO, DA3, DA3, DA3, CO, CO, CO, CO, BUICO, CO, BUICO, BUICO, CAY, CO, CO, CO, CAY, CO, CO, CO },
			{ CO, CAY, CO, BUICO, CO, DA1, BUICO, CO, BUICO, CO, BUICO, CO, CO, BUICO, CO, CAY, CO, CAY, CO, CO },
			{ CO, CAY, CO, BUICO, CO, DA1, BUICO, CO, BUICO, CO, BUICO, CO, CO, BUICO, CO, CAY, CO, CAY, CO, CO },
			{ CO, CAY, CO, BUICO, CO, DA1, BUICO, CO, BUICO, CO, BUICO, CO, CO, BUICO, CO, CAY, CO, CAY, CO, CO } };
	
	public void veMap(Graphics g){
		for (int i = 0; i < mapGame.length; i++) {
			for (int j = 0; j < mapGame.length; j++) {
				switch (mapGame[i][j]) {
				case CO:
					g.drawImage(hinhAnh.co, j*20+10, i*20+10, null);
					break;
				case BUICO:
					g.drawImage(hinhAnh.buiCo, j*20+10, i*20+10, null);
					break;
				case DA1:
					g.drawImage(hinhAnh.da1, j*20+10, i*20+10, null);
					break;
				case DA2:
					g.drawImage(hinhAnh.da2, j*20+10, i*20+10, null);
					break;
				case DA3:
					g.drawImage(hinhAnh.da3, j*20+10, i*20+10, null);
					break;
				case DA4:
					g.drawImage(hinhAnh.da4, j*20+10, i*20+10, null);
					break;
				case DA5:
					g.drawImage(hinhAnh.da5, j*20+10, i*20+10, null);
					break;
				case THUNG:
					g.drawImage(hinhAnh.thung1, j*20+10, i*20+10, null);
					break;
				case NUOC:
					g.drawImage(hinhAnh.nuoc, j*20+10, i*20+10, null);
					break;
				case CAY:
					g.drawImage(hinhAnh.cay, j*20+10, i*20+10, null);
					break;
				default:
					break;
				}
			}
		}
	}
	
	
}
