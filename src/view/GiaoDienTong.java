package view;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

import controller.ControllerTong;
import model.HinhAnh;
import model.NhanVat;

public class GiaoDienTong extends JFrame implements Observer {

	public JMenuBar jMenuBar;
	public JMenu menuTroChoi, menuTuyChon;
	public JMenuItem itemNewGame, itemLuuDiem,  itemThoatGame, itemGiupDo, itemGioiThieu, itemDiem,itemDiemCao;
	NhanVat nhanvat=ControllerTong.nhanVat;
	public GiaoDienTong() throws IOException {
		
		Game vaoGame = new Game();
		add(vaoGame);
		
		jMenuBar = new JMenuBar();
		menuTroChoi = new JMenu("Tro Choi");
		menuTuyChon = new JMenu("Tuy Chon");

		itemNewGame = new JMenuItem("Tro choi moi");
		itemNewGame.setIcon(HinhAnh.gameMoi);

		itemLuuDiem = new JMenuItem("Luu diem");
		itemLuuDiem.setIcon(HinhAnh.luuDiem);

		
		itemThoatGame = new JMenuItem("Thoat game");
		itemThoatGame.setIcon(HinhAnh.thoat);

		itemGioiThieu = new JMenuItem("Gioi thieu");
		itemGioiThieu.setIcon(HinhAnh.gioiThieu);

		itemDiem = new JMenuItem("Điểm của bạn");
		itemDiem.setIcon(HinhAnh.diem);
		itemDiemCao=new JMenuItem("Điểm cao nhất");
		itemDiemCao.setIcon(HinhAnh.diemcao);
		
		itemGiupDo = new JMenuItem("Giup do");
		itemGiupDo.setIcon(HinhAnh.giupDo);
		menuTroChoi.add(itemNewGame);
		menuTroChoi.add(itemLuuDiem);
		menuTroChoi.add(itemDiem);
		menuTroChoi.add(itemDiemCao);
		menuTroChoi.add(itemThoatGame);

		menuTuyChon.add(itemGiupDo);
		menuTuyChon.add(itemGioiThieu);

		jMenuBar.add(menuTroChoi);
		jMenuBar.add(menuTuyChon);
		setJMenuBar(jMenuBar);

		// menuTroChoi.setMnemonic(KeyEvent.VK_T);
		// menuTuyChon.setMnemonic(KeyEvent.VK_T);

		itemGioiThieu.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_G, KeyEvent.CTRL_DOWN_MASK));

		itemGiupDo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_H, KeyEvent.CTRL_DOWN_MASK));

		itemNewGame.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, KeyEvent.CTRL_DOWN_MASK));

		itemLuuDiem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, KeyEvent.CTRL_DOWN_MASK));
//		if(nhanvat.getDiemSo()==0){
//			itemLuuDiem.setEnabled(false);
//		}

		
		itemThoatGame.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, KeyEvent.CTRL_DOWN_MASK));

		itemDiem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, KeyEvent.CTRL_DOWN_MASK));
		itemDiemCao.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_I,KeyEvent.CTRL_DOWN_MASK));
		// set for frame
		setVisible(true);
		setSize(700, 483);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		;
		setFocusable(true);
		setTitle("GAME ĐẶT BOOM");
	}

	@Override
	public void update(Observable obs, Object obj) {
		if(obs instanceof NhanVat){
			if(obj != null){
				String item = (String) obj;
				System.out.println(item);
			NhanVat nhanVat = (NhanVat) obs;
		if (item.equals("lua")) {
			nhanVat.setCapDoBoom(nhanVat.getCapDoBoom() + 1);
		}
		if (item.equals("heart")) {
			nhanVat.setSoMang(nhanVat.getSoMang()+1);
		}
		if (item.equals("boom")) {
			nhanVat.setSoBoomDuocDat(nhanVat.getSoBoomDuocDat()+1);
			System.out.println("So boom duoc dat hien tai la:"+ nhanVat.getSoBoomDuocDat());
		}
	}
		}
	}
}
