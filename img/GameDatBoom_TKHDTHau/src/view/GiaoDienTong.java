package view;

import java.awt.ItemSelectable;
import java.awt.event.KeyEvent;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

import model.HinhAnh;

public class GiaoDienTong extends JFrame {

	public JMenuBar jMenuBar;
	public JMenu menuFile, menuTuyChon;
	public JMenuItem itemNewGame, itemLuuGame, itemThoatGame, itemGiupDo, itemGioiThieu;
	public VaoGame vaoGame;

	public GiaoDienTong() throws IOException {

		vaoGame = new VaoGame();
		add(vaoGame);

		jMenuBar = new JMenuBar();
		menuFile = new JMenu("Game");
		menuTuyChon = new JMenu("Tuy Chon");

		itemNewGame = new JMenuItem("Tro choi moi");
		itemNewGame.setIcon(HinhAnh.gameMoi);

		itemLuuGame = new JMenuItem("Luu tro choi");
		itemLuuGame.setIcon(HinhAnh.luuTroChoi);

		itemThoatGame = new JMenuItem("Thoat game");
		itemThoatGame.setIcon(HinhAnh.thoat);

		itemGioiThieu = new JMenuItem("Gioi thieu");
		itemGioiThieu.setIcon(HinhAnh.gioiThieu);

		itemGiupDo = new JMenuItem("Giup do");
		itemGiupDo.setIcon(HinhAnh.giupDo);
		menuFile.add(itemNewGame);
		menuFile.add(itemLuuGame);
		menuFile.add(itemThoatGame);

		menuTuyChon.add(itemGiupDo);
		menuTuyChon.add(itemGioiThieu);

		jMenuBar.add(menuFile);
		jMenuBar.add(menuTuyChon);
		setJMenuBar(jMenuBar);

		menuFile.setMnemonic(KeyEvent.VK_F);
		menuTuyChon.setMnemonic(KeyEvent.VK_H);

		itemGioiThieu.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_G, KeyEvent.CTRL_DOWN_MASK));

		itemGiupDo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_H, KeyEvent.CTRL_DOWN_MASK));

		itemNewGame.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, KeyEvent.CTRL_DOWN_MASK));

		itemLuuGame.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, KeyEvent.CTRL_DOWN_MASK));

		itemThoatGame.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, KeyEvent.CTRL_DOWN_MASK));

		// set for frame
		setVisible(true);
		setSize(700, 483);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocation(100, 50);
		setFocusable(true);
		setTitle("GAME ĐẶT BOOM");
	}
}
