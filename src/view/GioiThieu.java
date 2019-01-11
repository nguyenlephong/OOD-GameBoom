package view;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

import model.HinhAnh;

public class GioiThieu extends JFrame {
	JPanel jpnTieuDe, jpnTong, jpnTongPhu;

	public GioiThieu(){
		jpnTong = new JPanel();
		jpnTongPhu = new JPanel();
		jpnTieuDe = new jpnTieuDe();
		jpnTieuDe.setPreferredSize(new Dimension(1037, 160));

		jpnTongPhu.setLayout(new GridLayout(2, 2));
		jpnTongPhu.add(new jpnKhoa());
		jpnTongPhu.add(new jpnHau());
		jpnTongPhu.add(new jpnNga());
		jpnTongPhu.add(new jpnPhong());
		jpnTongPhu.setPreferredSize(new Dimension(1037, 492));

		jpnTong.setLayout(new BorderLayout());
		jpnTong.add(jpnTieuDe, BorderLayout.NORTH);
		jpnTong.add(jpnTongPhu, BorderLayout.CENTER);
		jpnTong.setPreferredSize(new Dimension(1037, 652));

		add(jpnTong);
		
		setTitle("Giới thiệu các thành viên trong nhóm");
		setVisible(true);
		pack();
		setLocationRelativeTo(null);
	}
	public static void main(String[] args) {
		new GioiThieu();
	}
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D graphics2d = (Graphics2D) g;
		// graphics2d.setStroke(new BasicStroke(7));
		graphics2d.drawRect(6, 6, 1037, 652);
		g.setColor(Color.BLACK);
		// g.fillRect(10, 10, 660, 400);
		// g.drawImage(HinhAnh.getItemHeart(), 10, 10, 30, 30, null);
	}

	private class jpnHau extends JPanel {
		public jpnHau() {

		}

		@Override
		public void paint(Graphics g) {
			super.paint(g);
			Graphics2D graphics2d = (Graphics2D) g;
			graphics2d.setStroke(new BasicStroke(7));
			graphics2d.drawRect(6, 6, 500, 226);
			g.setColor(Color.BLACK);
			g.fillRect(10, 10, 500, 226);
			g.drawImage(HinhAnh.imgGioiThieuHau, 10, 10, 495, 219, null);
		}
	}

	private class jpnKhoa extends JPanel {
		public jpnKhoa() {

		}

		@Override
		public void paint(Graphics g) {
			super.paint(g);
			Graphics2D graphics2d = (Graphics2D) g;
			graphics2d.setStroke(new BasicStroke(7));
			graphics2d.drawRect(6, 6, 500, 226);
			g.setColor(Color.BLACK);
			g.fillRect(10, 10, 500, 226);
			g.drawImage(HinhAnh.imgGioiThieuKhoa, 10, 10, 495, 219, null);
		}
	}

	private class jpnNga extends JPanel {
		public jpnNga() {

		}

		@Override
		public void paint(Graphics g) {
			super.paint(g);
			Graphics2D graphics2d = (Graphics2D) g;
			graphics2d.setStroke(new BasicStroke(7));
			graphics2d.drawRect(6, 6, 500, 226);
			g.setColor(Color.BLACK);
			g.fillRect(10, 10, 500, 226);
			g.drawImage(HinhAnh.imgGioiThieuNga, 10, 10, 495, 219, null);
		}
	}

	private class jpnPhong extends JPanel {
		public jpnPhong() {

		}

		@Override
		public void paint(Graphics g) {
			super.paint(g);
			Graphics2D graphics2d = (Graphics2D) g;
			graphics2d.setStroke(new BasicStroke(7));
			graphics2d.drawRect(6, 6, 500, 226);
			g.setColor(Color.BLACK);
			g.fillRect(10, 10, 500, 226);
			g.drawImage(HinhAnh.imgGioiThieuPhong, 10, 10, 495, 219, null);
		}
	}

	private class jpnTieuDe extends JPanel {
		public jpnTieuDe() {

		}

		@Override
		public void paint(Graphics g) {
			super.paint(g);
			Graphics2D g2d = (Graphics2D) g;
			g2d.setFont(new Font("TimesRoman", Font.BOLD, 17)); 
			g2d.setColor(Color.RED);
			g2d.drawString(
					"Chào mừng các bạn đến với project games của mình.",
					30, 15);
			g2d.drawString(
					"Đề tài nhóm mình là thiết kế games đặt boom dựa theo mẫu của games boomber heroer của app android.",
					30, 40);
			g2d.drawString(
					"Theo đề tài này mình đã thiết kế giao diện và hoàn thành được các chức năng cơ bản.",
					30, 65);
			g2d.drawString(
					"Để đạt được những thành công đó nhóm mình đã phân công công việc rõ ràng,và công bằng nhất có thể cho các thành viên ",
					30, 90);
			g2d.drawString(
					"trong nhóm để có thể hoàn thành sớm project.",
					10, 115);
			g2d.drawString(
					"Phía dưới là các thông tin cơ bản của thành viên nhóm mình.",
					30, 145);
		}
	}
}
