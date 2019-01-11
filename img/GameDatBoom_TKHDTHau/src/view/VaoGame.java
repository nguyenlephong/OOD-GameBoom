package view;

import model.*;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.io.IOException;

import javax.swing.JPanel;

import controller.ControllerTong;

public class VaoGame extends JPanel {
	public static HinhAnh hinhAnh;
	public static NhanVat nhanVat;
	public static BanDo banDo;
	public static Boom boom;
	public static Item item;
	public static Boss boss;
	public static QuaiVat quaiVat;
//	public static String tenItem="";
	public VaoGame() throws IOException {
		/*
		 * HAU DA THUC HIEN CAC BUOC NAY
		 */
		hinhAnh = new HinhAnh();
		nhanVat = new NhanVat(2, 3, 3, 10, 1, 1, hinhAnh);
		banDo = new BanDo(hinhAnh, nhanVat);
		boss=new Boss(10, 10, hinhAnh);
		/*
		 * PHAN TIEP THEO LA XUAT HIEN ITEM
		 */
		item = new Item(3, 3, "");

		/*
		 * PHAN TIEP THEO LA TIEU DIET QUAI VAT
		 */
		quaiVat = null;

		/*
		 * PHAN TIEP THEO LA TIEU DIET BOSS
		 */
		boss = null;
	}

	@Override
	public void paint(Graphics g) {
		Graphics2D graphics2d = (Graphics2D) g;
		if (ControllerTong.daBatDauGameChua) {
			graphics2d.setColor(Color.PINK);
			graphics2d.setStroke(new BasicStroke(7));
			graphics2d.drawRect(6, 6, 407, 407);
			/*KHU VUC NAY SE VE KHUNG BEN PHAI
			 *KHU VUC NAY SE VE CAC THUC TINH CUA RAN VA THONG TIN VE TRO CHOI
			 * */
			graphics2d.setColor(Color.ORANGE);
			graphics2d.setStroke(new BasicStroke(7));
			graphics2d.drawRect(423, 6, 255, 408);
			g.setColor(Color.WHITE);
			g.fillRect(426, 8, 250, 403);
//			graphics2d.setColor(Color.BLUE);
			// graphics2d.drawRect(415, 10, 190, 60);
			// graphics2d.drawString("CHOI MOI ", 420, 30);
			// graphics2d.drawString("LUU GAME", 520, 30);
			// graphics2d.drawString("DIEM CAO ", 420, 60);
			// graphics2d.drawString("THOAT GAME ", 520, 60);
			Font font = new Font("Courier", Font.PLAIN, 15);
			graphics2d.setFont(font);
//			if (!ControllerTong.coDangChoiGame && !ControllerTong.coTamDung) {
//				graphics2d.drawString("NHAN SPACE DE BAT DAU !!!", 100, 150);
//			}
//			if (!ControllerTong.coDangChoiGame && ControllerTong.coTamDung) {
//				graphics2d.drawString("NHAN SPACE DE TIEP TUC !!!", 100, 150);
//			}
			graphics2d.setColor(Color.RED);
			graphics2d.drawString("MÔN THKHDT - CÔ NGA", 465, 20);
			graphics2d.drawString("PROJECT GAME ĐẶT BOOM", 455, 40);
			graphics2d.setColor(Color.BLUE);
			graphics2d.setStroke(new BasicStroke(1));
			g.drawLine(455, 50, 650, 50);
			
			graphics2d.drawString("CHÚC BẠN CHƠI GAME VUI VẺ !", 430, 120);
			graphics2d.setColor(Color.RED);
			g.drawLine(475, 130, 620, 130);
			
			graphics2d.drawString("> CẤP ĐỘ BOOM HIỆN TẠI: " + nhanVat.getCapDoBoom(), 430, 150);
			graphics2d.setColor(Color.RED);
			g.drawLine(475, 160, 620, 160);
			
			graphics2d.drawString("> SỐ MẠNG CỦA BẠN LÀ: " + nhanVat.getSoMang(), 430,180);
			graphics2d.setColor(Color.RED);
			g.drawLine(475, 190, 620, 190);
			
			graphics2d.drawString("> MÀN CHƠI HIỆN TẠI LÀ: " + nhanVat.getManChoi(), 430, 210);
			graphics2d.setColor(Color.RED);
			g.drawLine(475, 220, 620, 220);
			
			// graphics2d.drawString("SPACE DE TAM DUNG ", 420, 300);
			graphics2d.drawImage(hinhAnh.logo, 415, 300, null);
			
			
			/*
			 * HAU DA VE PHAN NAY
			 */
			banDo.veMap(g);
			nhanVat.veNhanVat(g);
			if(nhanVat.getManChoi()==3){
				boss.veBoss(g);
			}
			item.veItem(g);
			System.out.println(item.getTenItem());
		} else {
			graphics2d.setStroke(new BasicStroke(7));
			graphics2d.drawRect(6, 6,667, 407);
			g.setColor(Color.BLACK);
			g.fillRect(10, 10, 660, 400);
			g.drawImage(hinhAnh.hinhNen, 10, 10, 660, 400, null);
		}
	}
}
