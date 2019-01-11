package model;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class HinhAnh {
	public static Image nhanVatXoayTrai, nhanVatXoayPhai, nhanVatXoayLen, nhanVatXoayXuong, nhanVatVaXe;
	public static Image boom, boomNo, boomDen, boomMax;
	public static Image buiCo, da1, cay, da2, thung1, da3, da4, da5, co, nuoc;
	public static Image tongHop;
	public static Image itemBomb, itemLua, itemHeart;

	public static ImageIcon gameMoi,luuTroChoi,thoat;
	public static ImageIcon giupDo,gioiThieu;
	public Image hinhNen;
	public static Image logo;
	public static Image tacgia;
	public  Image boss,quaiVat;
	/*
	 * Nhan vat la 1 nha la 2 cay la 3 odat la 0
	 */
	public HinhAnh() throws IOException {
		itemBomb=ImageIO.read(new File("img/itBomb.png"));
		itemLua=ImageIO.read(new File("img/iconLua.png"));
		itemHeart=ImageIO.read(new File("img/heart.png"));
		hinhNen=ImageIO.read(new File("img/hinhNen.PNG"));
		// hinh anh cho menu
		gameMoi=new ImageIcon("img/troChoiMoi.PNG");
		luuTroChoi=new ImageIcon("img/luuGame.PNG");
		thoat=new ImageIcon("img/thoat.PNG");
		
		giupDo=new ImageIcon("img/giupDo.PNG");
		gioiThieu=new ImageIcon("img/gioiThieu.PNG");
		
		// tong hop
		BufferedImage tongHop = ImageIO.read(new File("img/map.PNG"));
		BufferedImage nhanVat = ImageIO.read(new File("img/nv.PNG"));

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
	}
	public static Image getNhanVatXoayTrai() {
		return nhanVatXoayTrai;
	}

	public static void setNhanVatXoayTrai(Image nhanVatXoayTrai) {
		HinhAnh.nhanVatXoayTrai = nhanVatXoayTrai;
	}

	public static Image getNhanVatXoayPhai() {
		return nhanVatXoayPhai;
	}

	public static void setNhanVatXoayPhai(Image nhanVatXoayPhai) {
		HinhAnh.nhanVatXoayPhai = nhanVatXoayPhai;
	}

	public static Image getNhanVatXoayLen() {
		return nhanVatXoayLen;
	}

	public static void setNhanVatXoayLen(Image nhanVatXoayLen) {
		HinhAnh.nhanVatXoayLen = nhanVatXoayLen;
	}

	public static Image getNhanVatXoayXuong() {
		return nhanVatXoayXuong;
	}

	public static void setNhanVatXoayXuong(Image nhanVatXoayXuong) {
		HinhAnh.nhanVatXoayXuong = nhanVatXoayXuong;
	}

	public static Image getNhanVatVaXe() {
		return nhanVatVaXe;
	}

	public static void setNhanVatVaXe(Image nhanVatVaXe) {
		HinhAnh.nhanVatVaXe = nhanVatVaXe;
	}

	public static Image getBoom() {
		return boom;
	}

	public static void setBoom(Image boom) {
		HinhAnh.boom = boom;
	}

	public static Image getBoomNo() {
		return boomNo;
	}

	public static void setBoomNo(Image boomNo) {
		HinhAnh.boomNo = boomNo;
	}

	public static Image getBoomDen() {
		return boomDen;
	}

	public static void setBoomDen(Image boomDen) {
		HinhAnh.boomDen = boomDen;
	}

	public static Image getBoomMax() {
		return boomMax;
	}

	public static void setBoomMax(Image boomMax) {
		HinhAnh.boomMax = boomMax;
	}

	public static Image getBuiCo() {
		return buiCo;
	}

	public static void setBuiCo(Image buiCo) {
		HinhAnh.buiCo = buiCo;
	}

	public static Image getDa1() {
		return da1;
	}

	public static void setDa1(Image da1) {
		HinhAnh.da1 = da1;
	}

	public static Image getCay() {
		return cay;
	}

	public static void setCay(Image cay) {
		HinhAnh.cay = cay;
	}

	public static Image getDa2() {
		return da2;
	}

	public static void setDa2(Image da2) {
		HinhAnh.da2 = da2;
	}

	public static Image getThung1() {
		return thung1;
	}

	public static void setThung1(Image thung1) {
		HinhAnh.thung1 = thung1;
	}

	public static Image getDa3() {
		return da3;
	}

	public static void setDa3(Image da3) {
		HinhAnh.da3 = da3;
	}

	public static Image getDa4() {
		return da4;
	}

	public static void setDa4(Image da4) {
		HinhAnh.da4 = da4;
	}

	public static Image getDa5() {
		return da5;
	}

	public static void setDa5(Image da5) {
		HinhAnh.da5 = da5;
	}

	public static Image getCo() {
		return co;
	}

	public static void setCo(Image co) {
		HinhAnh.co = co;
	}

	public static Image getNuoc() {
		return nuoc;
	}

	public static void setNuoc(Image nuoc) {
		HinhAnh.nuoc = nuoc;
	}

	public static Image getTacgia() {
		return tacgia;
	}

	public static void setTacgia(Image tacgia) {
		HinhAnh.tacgia = tacgia;
	}

	public static Image getTongHop() {
		return tongHop;
	}

	public static void setTongHop(Image tongHop) {
		HinhAnh.tongHop = tongHop;
	}

	public static Image getItemBomb() {
		return itemBomb;
	}

	public static void setItemBomb(Image itemBomb) {
		HinhAnh.itemBomb = itemBomb;
	}

	public static Image getItemLua() {
		return itemLua;
	}

	public static void setItemLua(Image itemLua) {
		HinhAnh.itemLua = itemLua;
	}

	public static Image getItemHeart() {
		return itemHeart;
	}

	public static void setItemHeart(Image itemHeart) {
		HinhAnh.itemHeart = itemHeart;
	}
}
