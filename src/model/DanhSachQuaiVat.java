package model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Observable;
import java.util.Observer;
import java.util.Random;

import controller.ControllerTong;
import view.Game;

public class DanhSachQuaiVat extends Observable  {
	private ArrayList<QuaiVat> dsquaiVat;
	private int soLuongQuaiVat;
	int x = 3, y = 3;
	Random rd = new Random();
	int soQuaiVatChet = 0;
	int manChoi = 0;
	NhanVat nv ;
	boolean quaMan = true;
	private static DanhSachQuaiVat instance;

	public static DanhSachQuaiVat getInstance() {
		if (instance == null) {
			instance = new DanhSachQuaiVat(0);
		}
		return instance;
	}

	private DanhSachQuaiVat(int soLuongQuaiVat) {
		dsquaiVat = new ArrayList<>();
		this.soLuongQuaiVat = soLuongQuaiVat;
		
	}

	public void taoQuaiVat(int loai, int x, int y) {
		switch (loai) {
		case 1:
			dsquaiVat.add(new QuaiVatA(x, y));
			break;
		case 2:
			dsquaiVat.add(new QuaiVatB(x, y));
			break;
		case 3:
			dsquaiVat.add(new QuaiVatC(x, y));
			break;
		default:
			break;
		}
	}

	public void taoDSQuaiVat(int loai) {
		int count = 0;
		while (count < soLuongQuaiVat) {
			x = rd.nextInt(17) + 2;
			y = rd.nextInt(17) + 2;
			if (ControllerTong.banDo.getMap()[x][y] == 0) {
				if(loai == 2){
					if(y%2 == 0){
						taoQuaiVat(loai, x, y);
						count++;
					}
				}
				else{
				taoQuaiVat(loai, x, y);
				count++;
				}
				/*
				 * if(loai ==1 && y %2==0 ){ taoQuaiVat(loai,x,y); count++; }
				 * else if(loai ==2 && y %2 !=0){ taoQuaiVat(loai, x, y); }
				 */
			}
		}
	}

	public int laySoLuongQuai() {
		return dsquaiVat.size();
	}

	public void xuLyTrungBom(int x, int y) {
		Iterator iter = dsquaiVat.iterator();
		
		while (iter.hasNext()) {
			QuaiVat qv = (QuaiVat) iter.next();
			
			if (qv.xuLyTrungBom(x, y)) {
				iter.remove();
				nv = ControllerTong.nhanVat;
				nv.setDiemSo(nv.getDiemSo()+3);
			}
		}
		if (manChoi != 3) {
			if (dsquaiVat.size() == 0 && quaMan) {
				quaMan = false;		
				manChoi++;
				setChanged();
				notifyObservers("Qua Man");
				if (manChoi == 1) {
					setSoLuongQuaiVat(8, 2);
					quaMan = true;
				} else if (manChoi == 2) {
					setSoLuongQuaiVat(0, 2);
				}
			}
		}
	}

	public ArrayList<QuaiVat> getDsquaiVat() {
		return dsquaiVat;
	}

	public void setDsquaiVat(ArrayList<QuaiVat> dsquaiVat) {
		this.dsquaiVat = dsquaiVat;
	}

	public int getSoLuongQuaiVat() {
		return soLuongQuaiVat;
	}
	private void addObserverNhanVat() {
		nv = ControllerTong.nhanVat;
		for (QuaiVat quaiVat : dsquaiVat) {
			quaiVat.addObserver(nv);
		}
	}
	public void setSoLuongQuaiVat(int soLuongQuaiVat, int loai) {
		this.soLuongQuaiVat = soLuongQuaiVat;
		taoDSQuaiVat(loai);
		addObserverNhanVat();
	}

}
