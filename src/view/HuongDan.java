package view;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JFrame;
import javax.swing.JPanel;

import model.HinhAnh;

public class HuongDan extends JFrame  {

	public HuongDan() {
		// TODO Auto-generated constructor stub
		add(new jpnPhong());
		setTitle("Hướng Dẫn Chơi Game");
		setSize(520, 550);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setResizable(false);
		setVisible(true);
	}
public static void main(String[] args) {
//	new HuongDan();
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
		g.drawImage(HinhAnh.huongDanPanel,0, 0, 500, 500, null);
	}
}

}
