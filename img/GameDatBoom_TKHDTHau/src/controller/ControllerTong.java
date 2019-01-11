package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JOptionPane;
import javax.swing.Timer;

import model.Boom;
import model.Item;
import model.ModelTong;
import model.NhanVat;
import view.GiaoDienTong;
import view.VaoGame;

public class ControllerTong implements ControlTheGame {
	public int count = 0;
	int cut = 0;
	public static boolean batDauLoadGame = false;
	public static boolean daBatDauGameChua = false;
	public static boolean dangChoiGame = false;
	public static boolean daTamNgung = false;
	public static boolean chienThangChua = false;
	public static boolean thuaCuocChua = false;
	public static boolean quaManChua = false;
	public static boolean xuatHienBossChua = false;
	public static boolean bossChetChua = false;
	public static Item itemBoom, itemLua, itemHeart;

	private GiaoDienTong giaoDienTong;
	private ModelTong modelTong;

	public ControllerTong(GiaoDienTong giaoDienTong, ModelTong modelTong) {
		this.giaoDienTong = giaoDienTong;
		this.modelTong = modelTong;
	}

	public GiaoDienTong getGiaoDienTong() {
		return giaoDienTong;
	}

	public ModelTong getModelTong() {
		return modelTong;
	}

	@Override
	public void diChuyenNhanVatVaDatBoom() {
		giaoDienTong.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {
			}

			@Override
			public void keyReleased(KeyEvent e) {
			}

			@Override
			public void keyPressed(KeyEvent e) {
				NhanVat nhanVat = modelTong.getNhanVat();
				int toaDoX = nhanVat.getToaDoX();
				int toaDoY = nhanVat.getToaDoY();
				int huongDi = nhanVat.getHuongDi();
				if (e.getKeyCode() == KeyEvent.VK_UP) {
					if (toaDoY > 0 && (VaoGame.banDo.mapGame[toaDoY - 1][toaDoX] == 0
							|| VaoGame.banDo.mapGame[toaDoY - 1][toaDoX] == 0)) {
						if (huongDi == 1) {
							nhanVat.setToaDoY(toaDoY - 1);
						}
						if (huongDi != 1) {
							nhanVat.setHuongDi(1);
						}
					}
				}
				if (e.getKeyCode() == KeyEvent.VK_DOWN) {
					if (toaDoY < 19 && (VaoGame.banDo.mapGame[toaDoY + 1][toaDoX] == 0
							|| VaoGame.banDo.mapGame[toaDoY + 1][toaDoX] == 0)) {
						if (huongDi == 2) {
							nhanVat.setToaDoY(toaDoY + 1);
						}
						if (huongDi != 2) {
							nhanVat.setHuongDi(2);
						}
					}
				}
				if (e.getKeyCode() == KeyEvent.VK_LEFT) {
					if (toaDoX > 0 && (VaoGame.banDo.mapGame[toaDoY][toaDoX - 1] == 0
							|| VaoGame.banDo.mapGame[toaDoY][toaDoX - 1] == 0)) {
						if (huongDi == 3) {
							nhanVat.setToaDoX(toaDoX - 1);
						}
						if (huongDi != 3) {
							nhanVat.setHuongDi(3);
						}
					}
				}
				if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
					if (toaDoX < 19 && (VaoGame.banDo.mapGame[toaDoY][toaDoX + 1] == 0
							|| VaoGame.banDo.mapGame[toaDoY][toaDoX + 1] == 0)) {
						if (huongDi == 4) {
							nhanVat.setToaDoX(toaDoX + 1);
						}
						if (huongDi != 4) {
							nhanVat.setHuongDi(4);
						}
					}
				}

				/*
				 * DAT BOOM VIET O DAY NHA
				 */
				if (e.getKeyCode() == KeyEvent.VK_SPACE) {
					nhanVat.getListBoom().add(new Boom(toaDoX, toaDoY));
					// boomNo();
				}
				giaoDienTong.repaint();
			}
		});
	}

	// Xử Lý Nổ Boom
	private void boomNo() {
		Timer timer = new Timer(1000, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				count++;
				ArrayList<Boom> dsBom = modelTong.getNhanVat().getListBoom();
				ArrayList<Boom> dsBoomNo = modelTong.getNhanVat().getListBoomNo();
				if (count % 2 == 0 && dsBom.size() > 0) {
					Boom boom = dsBom.remove(0);
					dsBoomNo.add(boom);

				} else if (count % 2 == 1 && dsBoomNo.size() > 0) {
					dsBoomNo.remove(0);
					count = 0;
				}
				giaoDienTong.repaint();
			}
		});
		timer.start();
	}

	// Xử Lý Item Xuất Hiện
	private void xuatHienItem() {
		Timer timer = new Timer(2000, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Random rdItem = new Random();
				cut++;
				if (cut % 10 == 4) {
					modelTong.getItem().setTenItem("itemHeart");
					modelTong.getItem().setxItem(rdItem.nextInt(20));
					modelTong.getItem().setyItem(rdItem.nextInt(20));
				}
				if (cut % 10 == 7) {
					modelTong.getItem().setTenItem("itemLua");
					modelTong.getItem().setxItem(rdItem.nextInt(20));
					modelTong.getItem().setyItem(rdItem.nextInt(20));

				}


				// if (getModelTong().getNhanVat().isNhanDuocItem(itemBoom)) {
				// Item.xuatHienItemBoom = false;
				// getModelTong().getNhanVat().capDoBoom++;
				// // System.out.println(getModelTong().getNhanVat().capDoBoom);
				// itemBoom.setxItem(rdItem.nextInt(18) + 1);
				// itemBoom.setyItem(rdItem.nextInt(18) + 1);
				// }
				// if (getModelTong().getNhanVat().isNhanDuocItem(itemLua)) {
				// Item.xuatHienItemLua = false;
				// getModelTong().getNhanVat().capDoBoom++;
				// // System.out.println(getModelTong().getNhanVat().capDoBoom);
				// itemLua.setxItem(rdItem.nextInt(18) + 1);
				// itemLua.setyItem(rdItem.nextInt(18) + 1);
				// }
				// if (getModelTong().getNhanVat().isNhanDuocItem(itemHeart)) {
				// Item.xuatHienItemHeart = false;
				// getModelTong().getNhanVat().soMang++;
				// // System.out.println(getModelTong().getNhanVat().soMang);
				// itemHeart.setxItem(rdItem.nextInt(18) + 1);
				// itemHeart.setyItem(rdItem.nextInt(18) + 1);
				// }
				giaoDienTong.repaint();
			}
		});
		timer.start();
	}

	private void thayDoiViTriItem() {
		if (modelTong.getItem().getxItem() == modelTong.getNhanVat().getToaDoX()
				&& modelTong.getItem().getxItem() == modelTong.getNhanVat().getToaDoX()
				&& modelTong.getItem().getTenItem().equals("itemHeart")) {
			modelTong.getNhanVat().setSoMang(modelTong.getNhanVat().getSoMang() + 1);
			modelTong.getItem().setxItem(-5);
			modelTong.getItem().setyItem(-5);
		}
		if (modelTong.getItem().getxItem() == modelTong.getNhanVat().getToaDoX()
				&& modelTong.getItem().getxItem() == modelTong.getNhanVat().getToaDoX()
				&& modelTong.getItem().getTenItem().equals("itemLua")) {
			modelTong.getNhanVat().setCapDoBoom(modelTong.getNhanVat().getCapDoBoom() + 1);
			modelTong.getItem().setxItem(-5);
			modelTong.getItem().setyItem(-5);
			cut = 0;
		}
	}

	@Override
	public void xuLyBoomNo() {
		boomNo();
	}

	@Override
	public void xuLyAnItem() {
		xuatHienItem();
		thayDoiViTriItem();
	}

	@Override
	public void xuLyMatMau() {

	}

	@Override
	public void xuLyTieuDietQuaiVat() {

	}

	@Override
	public void xuLyNewGame() {
		daBatDauGameChua = true;
		giaoDienTong.repaint();
	}

	@Override
	public void xuLyLuuGame() {

	}

	@Override
	public void xuLyQuaManVaThuaCuoc() {

	}

	@Override
	public void xuLyTieuDietBossVaChienThang() {

	}

	@Override
	public void xuLyMenu() {
		giaoDienTong.itemThoatGame.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		giaoDienTong.itemNewGame.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				xuLyNewGame();
			}
		});
		giaoDienTong.itemLuuGame.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				xuLyLuuGame();
			}
		});
		giaoDienTong.itemGiupDo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "");
			}
		});
		giaoDienTong.itemGioiThieu.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "");
			}
		});
		giaoDienTong.repaint();
	}

}
