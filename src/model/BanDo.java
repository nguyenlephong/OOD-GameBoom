package model;

import java.awt.Graphics;
import java.awt.Image;
import java.io.IOException;

import controller.ControllerTong;

public class BanDo {
	public static final int CO = 0, BUICO = 1, CAY = 2, DA1 = 3, DA2 = 4, DA3 = 5, DA4 = 6, DA5 = 7, THUNG = 8,
			NUOC = 9, BOOM = 10, BOOMMax = 11;
	public int KICHTHUOCKHUNG = 20, DODAI = 20, MORONG = 10;
	private HinhAnh hinhAnh;
	private int[][] map;
	public static int[][] map1 = { // NGANG LA DUNG, DOC LA NAM
			{ CO, CO, CAY, CAY, CO, CAY, CO, CO, CAY, CO, CAY, CO, CAY, CO, CAY, CO, CAY, CO, CAY, CO },
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
			{ CAY, CO, CAY, CO, CAY, CO, CAY, CO, CAY, CO, CAY, CO, CAY, CO, CAY, CO, CAY, CO, CAY, CO },
			{ CAY, CO, CAY, CO, CAY, CO, CAY, CO, CAY, CO, CAY, CO, CAY, CO, CAY, CO, CAY, CO, CAY, CO } };

	public static int[][] map2 = {
			{ CO, CO, CAY, CAY, CAY, CAY, CAY, CO, CO, CO, CAY, CO, CO, CO, CAY, CO, CO, CO, CAY, CO },
			{ CAY, CO, CAY, CO, CO, CO, CAY,CO, CAY, CO, CAY, CO, CAY, CO, CAY, CO, CAY, CO, CAY, CO },
			{ DA1, CO, CO, CO, CO, CO, CO, CO,  CO, CO, CO, CO, CO, CO, CO, CO, CO, CO, CO, CO },
			{ NUOC, THUNG, THUNG, THUNG, THUNG, THUNG, THUNG, THUNG, THUNG, THUNG, THUNG, THUNG, THUNG, THUNG, THUNG, THUNG, THUNG, THUNG, THUNG, THUNG},
			{ NUOC, CO, CO, CO, CO, CO, CO, CO, CO, CO, CO, CO, CO, CO, CO, CO, CO, CO, CO, CO },
			{ NUOC, THUNG, THUNG, THUNG, THUNG, THUNG, THUNG, THUNG, THUNG, THUNG, THUNG, THUNG, THUNG, THUNG, THUNG, THUNG, THUNG, THUNG, THUNG, THUNG},
			{ NUOC, CO, CO, CO, CO, CO, CO, CO, CO, CO, CO, CO, CO, CO, CO, CO, CO, CO, CO, CO },
			{ NUOC, THUNG, THUNG, THUNG, THUNG, THUNG, THUNG, THUNG, THUNG, THUNG, THUNG, THUNG, THUNG, THUNG, THUNG, THUNG, THUNG, THUNG, THUNG, THUNG },
			{ NUOC, CO, CO, CO, CO, CO, CO, CO, CO, CO, CO, CO, CO, CO, CO, CO, CO, CO, CO, CO },
			{ NUOC, THUNG, THUNG, THUNG, THUNG, THUNG, THUNG, THUNG, THUNG, THUNG, THUNG, THUNG, THUNG, THUNG, THUNG, THUNG, THUNG, THUNG, THUNG, THUNG },
			{ NUOC, CO, CO, CO, CO, CO, CO, CO, CO, CO, CO, CO, CO, CO, CO, CO, CO, CO, CO, CO},
			{ NUOC, THUNG, THUNG, THUNG, THUNG, THUNG, THUNG, THUNG, THUNG, THUNG, THUNG, THUNG, THUNG, THUNG, THUNG, THUNG, THUNG, THUNG, THUNG, THUNG},
			{ NUOC, CO, CO, CO, CO, CO, CO, CO, CO, CO, CO, CO, CO, CO, CO, CO, CO, CO, CO, CO },
			{ NUOC, THUNG, THUNG, THUNG, THUNG, THUNG, THUNG, THUNG, THUNG, THUNG, THUNG, THUNG, THUNG, THUNG, THUNG, THUNG, THUNG, THUNG, THUNG, THUNG},
			{ NUOC, CO, CO, CO, CO, CO, CO, CO, CO, CO, CO, CO, CO, CO, CO, CO, CO, CO, CO, CO },
			{ NUOC, THUNG, THUNG, THUNG, THUNG, THUNG, THUNG, THUNG, THUNG, THUNG, THUNG, THUNG, THUNG, THUNG, THUNG, THUNG, THUNG, THUNG, THUNG, THUNG},
			{ NUOC, CO, CO, CO, CO, CO, CO, CO, CO, CO,CO, CO, CO, CO, CO, CO, CO, CO, CO, CO },
			{ NUOC, THUNG, THUNG, THUNG, THUNG, THUNG, THUNG, THUNG, THUNG, THUNG, THUNG, THUNG, THUNG, THUNG, THUNG, THUNG, THUNG, THUNG, THUNG, THUNG },
			{ NUOC, CO, CO, CO, CO, CO, CO, CO, CO, CO, CO, CO, CO, CO, CO, CO, CO, CO, CO, CO },
			{ NUOC, THUNG, THUNG, THUNG, THUNG, THUNG, THUNG, THUNG, THUNG, THUNG, THUNG, THUNG, THUNG, THUNG, THUNG, THUNG, THUNG, THUNG, THUNG, THUNG} };

	public static int[][] map22 = {
			{ CO, CO, CAY, CAY, CAY, CAY, CAY, CO, CO, CO, CAY, CO, CO, CO, CAY, CO, CO, CO, CAY, CO },
			{ CAY, CO, CAY, CO, CO, CO, CAY, CO, CAY, CO, CAY, CO, CAY, CO, CAY, CO, CAY, CO, CAY, CO },
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

	public static int[][] map3 = {
			{ CO, CO, CO, CO, CO, CO, BUICO, BUICO, DA1, BUICO, CO, BUICO, BUICO, CO, BUICO, CO, BUICO, CO, CO, CO },
			{ CO, CAY, CO, CO, CO, BUICO, CO, CO, CO, CAY, CO, CO, CO, CO, CO, CO, CAY, CO, CO, CO },
			{ CO, CAY, CO, CO, CO, CO, CO, CO, CO, CO, CO, CO, CO, CAY, CO, CO, CO, CO, CO, CAY },
			{ CO, CAY, CO, CO, CO, BUICO, CO, CO, CO, CO, CO, DA1, CO, CO, CO, CO, CAY, CO, CO, CO },
			{ CO, CO, CO, CO, CO, CO, CO, CO, CAY, CO, CAY, CO, CO, CO, CO, NUOC, NUOC, BUICO, CO, CO },
			{ CO, CAY, NUOC, NUOC, NUOC, CO, CO, CO, CO, CO, CO, CO, CAY, CO, CO, NUOC, NUOC, CO, BUICO, CO },
			{ CO, CAY, NUOC, NUOC, NUOC, CO, CAY, CO, BUICO, BUICO, CO, CO, CO, CO, NUOC, NUOC, NUOC, CAY, CO, CO },
			{ CO, CO, NUOC, NUOC, CO, CO, CO, CO, CO, CO, CO, BUICO, CAY, CO, NUOC, NUOC, NUOC, CO, CO, CO },
			{ CO, CO, NUOC, NUOC, CO, BUICO, CO, CAY, BUICO, CO, CO, CO, CO, CO, NUOC, NUOC, NUOC, CO, CO, CAY },
			{ CO, CO, CO, CO, CO, CO, CO, CO, CO, CO, BUICO, CO, CAY, CO, NUOC, NUOC, NUOC, CO, CO, CO },
			{ CO, CAY, CO, CO, CO, CAY, BUICO, BUICO, CO, CAY, CO, CO, CO, CO, CAY, CO, NUOC, CO, CAY, CAY },
			{ CO, CO, CO, CO, CO, CO, CO, CAY, BUICO, CO, CO, BUICO, CO, CO, CO, CAY, NUOC, CO, CO, CO },
			{ CO, CO, CO, DA1, CO, CAY, CO, NUOC, NUOC, NUOC, NUOC, CO, CAY, BUICO, CO, CO, BUICO, CAY, CO, CAY },
			{ CO, CO, CO, CO, CO, CO, BUICO, NUOC, NUOC, NUOC, NUOC, BUICO, CO, BUICO, CO, CAY, CO, CO, CAY, CO },
			{ CO, CAY, NUOC, NUOC, CO, CO, CO, NUOC, NUOC, NUOC, NUOC, BUICO, CO, BUICO, CO, BUICO, BUICO, CAY, CO,
					CAY },
			{ CO, CO, NUOC, NUOC, CO, CAY, CO, CAY, CO, BUICO, BUICO, CO, CAY, CO, CO, CAY, CO, CO, CO, CO },
			{ BUICO, NUOC, NUOC, NUOC, CO, CO, CO, CO, CO, CO, BUICO, BUICO, CO, CO, CO, CO, CO, CO, CO, CAY },
			{ CO, NUOC, NUOC, NUOC, CAY, CO, CAY, BUICO, CO, BUICO, DA1, CO, CO, BUICO, CO, CAY, CO, DA1, CO, CO },
			{ CO, NUOC, NUOC, NUOC, CO, CO, CO, CO, BUICO, CO, BUICO, BUICO, CAY, CO, CO, CO, CAY, CO, CO, CO },
			{ CO, CAY, CO, BUICO, CO, DA1, BUICO, CO, BUICO, CO, BUICO, CO, CO, BUICO, CO, CAY, CO, CAY, CO, CO } };

	public BanDo(HinhAnh hinhAnh) {
		this.hinhAnh = hinhAnh;
		if (ControllerTong.nhanVat.getManChoi() == 1) {
			map = map1;
		}
		if (ControllerTong.nhanVat.getManChoi() == 2) {
			map = map2;
		}
		if (ControllerTong.nhanVat.getManChoi() == 3) {
			map = map3;
		}
	}

	public void veHinh(Image img, int x, int y, Graphics g) {
		g.drawImage(img, x * KICHTHUOCKHUNG + MORONG, y * KICHTHUOCKHUNG + MORONG, null);
	}

	public HinhAnh getHinhAnh() {
		return hinhAnh;
	}

	public void setHinhAnh(HinhAnh hinhAnh) {
		this.hinhAnh = hinhAnh;
	}

	public int[][] getMap() {
		return map;
	}

	public void setMap(int[][] map) {
		this.map = map;
	}

	// khoa da lam phan nay, khoa da sua j thanh i
	public void veMap(Graphics g) {
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				switch (map[j][i]) {
				case 0:
					veHinh(hinhAnh.co, i, j, g);
					break;
				case 1:
					veHinh(hinhAnh.buiCo, i, j, g);
					break;
				case 3:
					veHinh(hinhAnh.da1, i, j, g);
					break;
				case 4:
					veHinh(hinhAnh.da2, i, j, g);
					break;
				case 5:
					veHinh(hinhAnh.da3, i, j, g);
					break;
				case 6:
					veHinh(hinhAnh.da4, i, j, g);
					break;
				case 7:
					veHinh(hinhAnh.da5, i, j, g);
					break;
				case 8:
					veHinh(hinhAnh.thung1, i, j, g);
					break;
				case 9:
					veHinh(hinhAnh.nuoc, i, j, g);
					break;

				case 2:
					veHinh(hinhAnh.cay, i, j, g);
					break;

				// ý tưởng của ngaà
				case BOOM:
					veHinh(hinhAnh.boom, i, j, g);
					break;
				case BOOMMax:
					veHinh(hinhAnh.boomMax, i, j, g);
					break;

				default:
					break;
				}
			}
		}
	}

}
