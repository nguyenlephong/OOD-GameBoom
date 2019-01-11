package view;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.io.IOException;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;
import controller.ControllerTong;
import model.BanDo;
import model.Boss;
import model.DanhSachQuaiVat;
import model.HinhAnh;
import model.Item;
import model.NhanVat;
import model.QuaiVat;

public class Game extends JPanel implements Observer{
	public static NhanVat nhanVat;
	BanDo banDo;
	Boss boss;
	Item item;
	HinhAnh hinhAnh;
	DanhSachQuaiVat ds;
	public static int sinhLucBoss = 100;
	int x =0,y =0;
	public Game() throws IOException {
		nhanVat=ControllerTong.nhanVat;
		banDo=ControllerTong.banDo;
		boss=ControllerTong.boss;
		item=ControllerTong.item;
		ds= ControllerTong.dsQuaiVat;
		boss.addObserver(this);
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
			
			graphics2d.drawString("> ĐIỂM HIỆN TẠI LÀ: " + nhanVat.getDiemSo(), 430, 210);
			graphics2d.setColor(Color.RED);
			g.drawLine(475, 220, 620, 220);
			
			graphics2d.drawString("> MÀN CHƠI HIỆN TẠI LÀ: " + nhanVat.getManChoi(), 430, 240);
			graphics2d.setColor(Color.RED);
			
			g.drawLine(475, 250, 620, 250);
			graphics2d.drawString("> SỐ BOMB MÀ BẠN ĐƯỢC ĐẶT: " + nhanVat.getSoBoomDuocDat(), 430, 270);
			graphics2d.setColor(Color.RED);
			g.drawLine(475, 280, 620, 280);
			// graphics2d.drawString("SPACE DE TAM DUNG ", 420, 300);
			graphics2d.drawImage(hinhAnh.logo, 415, 300, null);
			/*
			 * HAU DA VE PHAN NAY
			 */
			banDo.veMap(g);
			nhanVat.veNhanVat(g);
			for (QuaiVat quaiVat : ds.getDsquaiVat()) {
				quaiVat.veQuaiVat(g);
			}
			if(nhanVat.getManChoi()==3){
				boss.veBoss(g);
				graphics2d.drawString("> SINH LỰC CỦA BOSS",430, 300);
				graphics2d.setColor(Color.RED);
				g.fillRect(430, 320, sinhLucBoss*2, 20);
			}
//			quaiVat.veQuaiVat(g);
			item.veItem(g);
			graphics2d.setColor(Color.RED);
			Font font = new Font("Courier", Font.PLAIN, 15);
			graphics2d.setFont(font);
			if (!ControllerTong.dangChoi && !ControllerTong.tamDung) {
				graphics2d.setColor(Color.cyan);
				graphics2d.setFont(new Font("NewellsHand", Font.PLAIN, 30));
				graphics2d.drawString("NHAN S DE BAT DAU !!!", 60, 150);
			}
			if (!ControllerTong.dangChoi && ControllerTong.tamDung) {
				graphics2d.setColor(Color.cyan);
				graphics2d.setFont(new Font("NewellsHand", Font.PLAIN, 30));
				graphics2d.drawString("NHAN S DE TIEP TUC !!!", 60, 150);
			}
		} else {
			graphics2d.setStroke(new BasicStroke(7));
			graphics2d.drawRect(6, 6,667, 407);
			g.setColor(Color.BLACK);
			g.fillRect(10, 10, 660, 400);
			g.drawImage(hinhAnh.hinhNen, 10, 10, 660, 400, null);
		}
	}
	@Override
	public void update(Observable o, Object arg) {
		Boss boss = (Boss)o;
		sinhLucBoss = boss.getSinhLuc();
	}
}
