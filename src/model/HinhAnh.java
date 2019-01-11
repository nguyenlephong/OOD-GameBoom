package model;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class HinhAnh {
	public Image nhanVatXoayTrai, nhanVatXoayPhai, nhanVatXoayLen, nhanVatXoayXuong, nhanVatVaXe;
	public Image  quaiVatXoayPhai, quaiVatXoayLen, quaiVatXoayXuong;
	public static Image boom;
	public static Image boomNo;
	public Image boomDen;
	public static Image huongDanPanel;
	public static Image boomMax;
	public Image buiCo, da1, cay, da2, thung1, da3, da4, da5, co, nuoc;
	public Image tongHop;
	
	//Hinh anh item
	public Image itemBomb, itemLua, itemHeart;
	
	public static Image imgGioiThieuKhoa, imgGioiThieuHau, imgGioiThieuNga,imgGioiThieuPhong;
	public static ImageIcon gameMoi, luuDiem, choiTiep, thoat,diem,diemcao;
	public static ImageIcon giupDo, gioiThieu;
	public static Image hinhNen, logo, tacgia;
	public Image boss;
	public Image quaiVatLen,quaiVatPhai,quaiVatTrai,quaiVatXuong;
	/*
	 * Nhan vat la 1 nha la 2 cay la 3 odat la 0
	 */
	public HinhAnh() {
		try {
			//item phuc vu chuc nang gioi thieu
			huongDanPanel = ImageIO.read(new File("img/huongdan.png"));
			imgGioiThieuKhoa=ImageIO.read(new File("img/khoa.png"));
			imgGioiThieuNga=ImageIO.read(new File("img/nga.png"));
			imgGioiThieuHau=ImageIO.read(new File("img/hau.png"));
			imgGioiThieuPhong=ImageIO.read(new File("img/phong.png"));
			boss = ImageIO.read(new File("img/boss.png"));

			//hinh anh item
			itemBomb = ImageIO.read(new File("img/itBomb.png"));
			itemLua = ImageIO.read(new File("img/iconLua.png"));
			itemHeart = ImageIO.read(new File("img/heart.png"));
			hinhNen = ImageIO.read(new File("img/hinhNen.PNG"));
			
			
			
			// hinh anh cho menu
			gameMoi = new ImageIcon("img/troChoiMoi.PNG");
			luuDiem = new ImageIcon("img/luuGame.PNG");
			choiTiep = new ImageIcon("img/choiTiep.PNG");
			thoat = new ImageIcon("img/thoat.PNG");
			diem=new ImageIcon("img/icon-s.png");
			diemcao=new ImageIcon("img/highscore.png");

			giupDo = new ImageIcon("img/giupDo.PNG");
			gioiThieu = new ImageIcon("img/gioiThieu.PNG");

//			quaiVat = ImageIO.read(new File("img/quaivat.PNG"));

			// tong hop
			BufferedImage tongHop = ImageIO.read(new File("img/map.PNG"));
			BufferedImage nhanVat = ImageIO.read(new File("img/nv.PNG"));
			BufferedImage quaivat = ImageIO.read(new File("img/quaivatIcon.png"));
		/*	 quaiVatRong = ImageIO.read(new File("img/QVQL.gif"));
			 URL url = new URL("img/QVQL.gif");
				gioiThieu = new ImageIcon("url");
			*/
			quaiVatLen = new ImageIcon(new URL("file:///E:/Code_LapTrinh/workspace/ProjectGameNhom12-5/img/final4.gif")).getImage();
			quaiVatPhai = new ImageIcon(new URL("file:///E:/Code_LapTrinh/workspace/ProjectGameNhom12-5/img/quayphai.gif")).getImage();
			quaiVatTrai = new ImageIcon(new URL("file:///E:/Code_LapTrinh/workspace/ProjectGameNhom12-5/img/quaytrai.gif")).getImage();
			quaiVatXuong = new ImageIcon(new URL("file:///E:/Code_LapTrinh/workspace/ProjectGameNhom12-5/img/quayxuong.gif")).getImage();

			
			
			quaiVatXoayXuong = quaivat.getSubimage(5, 0, 25, 28);
			quaiVatXoayLen = quaivat.getSubimage(31, 26, 25, 28);
			quaiVatXoayPhai = quaivat.getSubimage(31, 0, 25, 28);
			
			nhanVatXoayPhai = quaivat.getSubimage(15, 0, 20, 30);
			
			nhanVatXoayTrai = nhanVat.getSubimage(20, 90, 20, 30);
			nhanVatXoayPhai = nhanVat.getSubimage(20, 30, 20, 30);
			nhanVatXoayLen = nhanVat.getSubimage(20, 0, 20, 30);
			nhanVatXoayXuong = nhanVat.getSubimage(20, 60, 20, 30);
			// hinh boom
			BufferedImage boomTong = ImageIO.read(new File("img/boom.PNG"));
			boomMax = ImageIO.read(new File("img/boommax.PNG"));
			boom = boomTong.getSubimage(0, 0, 23, 23);
			boomDen = boomTong.getSubimage(0, 23, 23, 23);
			boomNo = boomTong.getSubimage(0, 40, 20, 20);

			// Model Map
			buiCo = tongHop.getSubimage(0, 0, 20, 20);
			da1 = tongHop.getSubimage(0, 20, 20, 20);
			cay = tongHop.getSubimage(0, 40, 20, 20);
			da2 = tongHop.getSubimage(0, 60, 20, 20);
			thung1 = tongHop.getSubimage(0, 80, 20, 20);
			da3 = tongHop.getSubimage(0, 120, 20, 20);
			da4 = tongHop.getSubimage(0, 180, 20, 20);
			da5 = tongHop.getSubimage(0, 200, 20, 20);
			co = tongHop.getSubimage(0, 220, 20, 20);
			nuoc = tongHop.getSubimage(0, 260, 20, 20);
		} catch (IOException e) {
		}
		
	}
}
