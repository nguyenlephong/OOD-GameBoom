package controller;

import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.Observable;
import java.util.Random;

import javax.swing.JOptionPane;
import javax.swing.Timer;

import model.AmThanh;
import model.BanDo;
import model.Boom;
import model.BoomMax;
import model.BoomThuong;
import model.Boss;
import model.DanhSachQuaiVat;
import model.DatabaseConnection;
import model.DiemNhanVat;
import model.HinhAnh;
import model.Item;
import model.ModelTong;
import model.NhanVat;
import model.QuaiVat;
import model.ThongTinDiem;
import view.Diem;
import view.GiaoDienTong;
import view.GioiThieu;
import view.HuongDan;

public class ControllerTong extends Observable implements ControlTheGame {
	int thoiGianTanCong = 1;
	public int thoiGianThayDoi = 0;
	public int count = 0;
	public static String itemNao = "";
	public int soBoomDaDat = 0;
	static int cut = 0;
	boolean dichuyen;
	boolean coboom;
	boolean duocDatBoom = true;
	public static boolean batDauLoadGame = false;
	public static boolean daBatDauGameChua = false;
	public static boolean dangChoi = false;
	public static boolean tamDung = false;
	public static boolean chienThangChua = false;
	public static boolean thuaCuocChua = false;
	public static boolean quaManChua = false;
	public static boolean xuatHienBossChua = false;
	public static boolean isBossXuatHien = true;
	public static HinhAnh hinhAnh = new HinhAnh();
	public static NhanVat nhanVat = new NhanVat(2, 0, 0, 2, 2, 0, 1, hinhAnh);
	public static BanDo banDo = new BanDo(hinhAnh);
	public static Item item = new Item(5, 5, hinhAnh, "");
	public static Boss boss = new Boss(-100, -100, 100, hinhAnh);
	public static DanhSachQuaiVat dsQuaiVat = DanhSachQuaiVat.getInstance();

	// model diem
	DiemNhanVat modelDiem = new DiemNhanVat();

	// xy ly cac timer
	public Timer amthanhTimer = new Timer(1200, new XuLyAmThanhNen());
	public Timer boomNoTimer = new Timer(1000, new XuLyTimerBomNo());
	public Timer itemTimer = new Timer(3000, new XuLyTimerItem());
	public Timer AnItemTimer = new Timer(1, new XuLyTimerAnItem());

	private GiaoDienTong giaoDienTong;
	private ModelTong modelTong;
	private int[][] map = banDo.getMap();
	int xTam = 0, yTam = 0, huongTam = 0;

	public ControllerTong(GiaoDienTong giaoDienTong, ModelTong modelTong) {
		this.giaoDienTong = giaoDienTong;
		this.modelTong = new ModelTong(hinhAnh, nhanVat, banDo, item, boss);
		nhanVat.addObserver(giaoDienTong);
	}

	public ControllerTong() {
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
				dichuyen = true;
				// public static final int LEN=1,XUONG=2,TRAI=3,PHAI=4;
				int toaDoX = nhanVat.getToaDoX();
				int toaDoY = nhanVat.getToaDoY();
				int huongDi = nhanVat.getHuongDi();
				ArrayList<Boom> boom = nhanVat.getDanhSachBoom();
				if (e.getKeyCode() == KeyEvent.VK_UP && dangChoi && !tamDung) {
					if (toaDoY > 0
							&& (banDo.getMap()[toaDoY - 1][toaDoX] == 0 || banDo.getMap()[toaDoY - 1][toaDoX] == 0)) {
						if (huongDi == NhanVat.LEN) {
							xTam = toaDoX;
							yTam = toaDoY - 1;
						}

						if (huongDi != NhanVat.LEN) {
							// huongTam =1;
							nhanVat.setHuongDi(NhanVat.LEN);
						}
						// Vong for kiem tra neu co boom se ko dc di qua
						for (int i = 0; i < boom.size(); i++) {
							if (xTam == boom.get(i).getToaDoX() && yTam == boom.get(i).getToaDoY()) {
								dichuyen = false;
							}
						}
						if (dichuyen) {
							nhanVat.setChangeViTri(xTam, yTam, null);
						}

					}
				}
				if (e.getKeyCode() == KeyEvent.VK_DOWN && dangChoi && !tamDung) {
					if (toaDoY < 19
							&& (banDo.getMap()[toaDoY + 1][toaDoX] == 0 || banDo.getMap()[toaDoY + 1][toaDoX] == 0)) {
						if (huongDi == NhanVat.XUONG) {
							xTam = toaDoX;
							yTam = toaDoY + 1;
							// nhanVat.setToaDoY(toaDoY + 1);
						}
						if (huongDi != NhanVat.XUONG) {
							// huongTam =2;
							nhanVat.setHuongDi(NhanVat.XUONG);
						}

						// Vong for kiem tra neu co boom se ko dc di qua
						for (int i = 0; i < boom.size(); i++) {
							if (xTam == boom.get(i).getToaDoX() && yTam == boom.get(i).getToaDoY()) {
								dichuyen = false;
							}
						}
						if (dichuyen) {
							nhanVat.setChangeViTri(xTam, yTam, null);
						}
					}
				}
				if (e.getKeyCode() == KeyEvent.VK_LEFT && dangChoi && !tamDung) {
					if (toaDoX > 0
							&& (banDo.getMap()[toaDoY][toaDoX - 1] == 0 || banDo.getMap()[toaDoY][toaDoX - 1] == 0)) {
						if (huongDi == NhanVat.TRAI) {
							xTam = toaDoX - 1;
							yTam = toaDoY;
							// nhanVat.setToaDoX(toaDoX - 1);
						}
						if (huongDi != NhanVat.TRAI) {
							// huongTam =3;
							nhanVat.setHuongDi(NhanVat.TRAI);
						}
						// Vong for kiem tra neu co boom se ko dc di qua
						for (int i = 0; i < boom.size(); i++) {
							if (xTam == boom.get(i).getToaDoX() && yTam == boom.get(i).getToaDoY()) {
								dichuyen = false;
							}
						}
						if (dichuyen) {
							nhanVat.setChangeViTri(xTam, yTam, null);
						}
					}
				}
				if (e.getKeyCode() == KeyEvent.VK_RIGHT && dangChoi && !tamDung) {
					if (toaDoX < 19
							&& (banDo.getMap()[toaDoY][toaDoX + 1] == 0 || banDo.getMap()[toaDoY][toaDoX + 1] == 0)) {
						if (huongDi == NhanVat.PHAI) {
							xTam = toaDoX + 1;
							yTam = toaDoY;
							// nhanVat.setToaDoX(toaDoX + 1);
						}
						if (huongDi != NhanVat.PHAI) {
							// huongTam =3;
							nhanVat.setHuongDi(NhanVat.PHAI);
						}
						// Vong for kiem tra neu co boom se ko dc di qua
						for (int i = 0; i < boom.size(); i++) {
							if (xTam == boom.get(i).getToaDoX() && yTam == boom.get(i).getToaDoY()) {
								dichuyen = false;
							}
						}
						if (dichuyen) {
							nhanVat.setChangeViTri(xTam, yTam, null);
						}
					}
				}

				if (e.getKeyCode() == KeyEvent.VK_SPACE && dangChoi && !tamDung) {
					if (soBoomDaDat >= nhanVat.getSoBoomDuocDat()) {
						duocDatBoom = false;
					} else {
						duocDatBoom = true;
					}
					coboom = false;
					// tiimer bom nổ bắt đầu

					boomNoTimer.start();
					int x = nhanVat.getToaDoX();
					int y = nhanVat.getToaDoY();
					for (int i = 0; i < boom.size(); i++) {
						if (boom.get(i).getToaDoX() == x && boom.get(i).getToaDoY() == y) {
							coboom = true;
						}
					}
					if (coboom == false && duocDatBoom) {
						datBoom();
						soBoomDaDat++;
					}
				}
				if (e.getKeyCode() == KeyEvent.VK_P) {
					tamDung = true;
					dangChoi = false;
				}
				if (e.getKeyCode() == KeyEvent.VK_S) {
					dangChoi = true;
					tamDung = false;
				}
				giaoDienTong.repaint();
			}
			// datboom

			private void datBoom() {
				if (nhanVat.getCapDoBoom() >= 4) {
					nhanVat.getDanhSachBoom().add(new BoomMax(nhanVat.getToaDoX(), nhanVat.getToaDoY()));
				} else {
					nhanVat.getDanhSachBoom().add(new BoomThuong(nhanVat.getToaDoX(), nhanVat.getToaDoY()));
				}
			}
		});
	}

	@Override
	public void xuLyBoomNo() {
		// boomNo();
	}

	// xu ly item xuat hien
	private void xuatHienItem() {
		Timer timer = new Timer(2000, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Random rdItem = new Random();
				cut++;
				String toado = ranDomViTriXuatHienItem();
				int toaDoX = Integer.parseInt(toado.substring(0, toado.indexOf("+")));
				int toaDoY = Integer.parseInt(toado.substring(toado.indexOf("+") + 1, toado.length()));
				if (cut % 10 == 2) {
					modelTong.getItem().setTenItem("itemHeart");
					modelTong.getItem().setxItem(toaDoX);
					modelTong.getItem().setyItem(toaDoY);
				}
				if (cut % 10 == 5) {
					modelTong.getItem().setTenItem("itemLua");
					modelTong.getItem().setxItem(toaDoX);
					modelTong.getItem().setyItem(toaDoY);

				}
				if (cut % 10 == 4) {
					modelTong.getItem().setTenItem("itemBoom");
					modelTong.getItem().setxItem(toaDoX);
					modelTong.getItem().setyItem(toaDoY);

				}
				ranDomViTriXuatHienItem();
				giaoDienTong.repaint();
			}
		});
		itemTimer.start();
	}

	private void thayDoiViTriItem() {
		Timer timerAnItem = new Timer(1, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (getModelTong().getItem().getxItem() == getModelTong().getNhanVat().getToaDoX()
						&& getModelTong().getItem().getyItem() == getModelTong().getNhanVat().getToaDoY()
						&& getModelTong().getItem().getTenItem().equals("itemHeart")) {
					// AmThanh.music(AmThanh.Sound_Item);
					itemNao = "heart";
					nhanVat.setChangeViTri(xTam, yTam, itemNao);
					getModelTong().getItem().setxItem(-5);
					getModelTong().getItem().setyItem(-5);
				}
				if (getModelTong().getItem().getxItem() == getModelTong().getNhanVat().getToaDoX()
						&& getModelTong().getItem().getyItem() == getModelTong().getNhanVat().getToaDoY()
						&& getModelTong().getItem().getTenItem().equals("itemLua")) {
					// AmThanh.music(AmThanh.Sound_Item);
					itemNao = "lua";
					nhanVat.setChangeViTri(xTam, yTam, itemNao);
					getModelTong().getItem().setxItem(-5);
					getModelTong().getItem().setyItem(-5);
				}
				if (getModelTong().getItem().getxItem() == getModelTong().getNhanVat().getToaDoX()
						&& getModelTong().getItem().getyItem() == getModelTong().getNhanVat().getToaDoY()
						&& getModelTong().getItem().getTenItem().equals("itemBoom")) {
					// AmThanh.music(AmThanh.Sound_Item);
					itemNao = "boom";
					nhanVat.setChangeViTri(xTam, yTam, itemNao);
					getModelTong().getItem().setxItem(-5);
					getModelTong().getItem().setyItem(-5);
				}
			}
		});
		AnItemTimer.start();
	}

	private String ranDomViTriXuatHienItem() {
		Random rd = new Random();
		int toaDoX = rd.nextInt(19);
		int toaDoY = rd.nextInt(19);
		while (banDo.getMap()[toaDoY][toaDoX] != BanDo.CO) {
			toaDoX = rd.nextInt(19);
			toaDoY = rd.nextInt(19);
		}
		return toaDoX + "+" + toaDoY + "";
	}

	private void quaiVatTrungBoom() {
		ArrayList<Point> viTri = Boom.vitri;
		loop: for (int i = 0; i < viTri.size(); i++) {
			dsQuaiVat.xuLyTrungBom(viTri.get(i).x, viTri.get(i).y);
		}
	}

	private boolean heroTrungBoom() {
		ArrayList<Point> viTri = Boom.vitri;
		int xhero = getModelTong().getNhanVat().getToaDoX();
		int yhero = getModelTong().getNhanVat().getToaDoY();
		for (int i = 0; i < viTri.size(); i++) {
			if (xhero == viTri.get(i).x && yhero == viTri.get(i).y) {
				// AmThanh.music(AmThanh.Sound_Die);
				int soMangHienTai = getModelTong().getNhanVat().getSoMang();
				if (soMangHienTai - 1 <= 0) {
					int action = JOptionPane.showConfirmDialog(null, "Bạn đã chết bạn có muốn lưu điểm", "Thoat Game",
							JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
					if (action == JOptionPane.YES_OPTION) {
						xuLyLuuDiem();
						xuLyNewGame();
					} else {
						System.exit(0);
					}
				} else {
					modelTong.getNhanVat().setSoMang(soMangHienTai - 1);
				}
				Boom.vitri.removeAll(Boom.vitri);
			}
		}
		Boom.vitri.removeAll(Boom.vitri);
		return false;
	}

	@Override
	public void xuLyAnItem() {
		xuatHienItem();
		// Chuyen timer thay doi vi tri tu xuatHienItem() vao day boi LE PHONG
		thayDoiViTriItem();
	}

	@Override
	public void quaiVatDiChuyen() {
		Thread thread = new Thread(new Runnable() {
			@Override
			public void run() {
				while (true) {
					try {
						if (!tamDung && nhanVat.getManChoi() < 3 && dangChoi && nhanVat.getSoMang() > 0) {
							for (QuaiVat quaiVat : dsQuaiVat.getDsquaiVat()) {
								quaiVat.diChuyen(0, 0, banDo.getMap());
							}
						}
						Thread.sleep(700);

					} catch (InterruptedException e) {
					}
				}
			}
		});
		thread.start();
	}

	@Override
	public void xuLyTieuDietQuaiVat() {

	}

	// xử lý new game lưu game và tiếp tục cái game

	@Override
	public void xuLyNewGame() {
		amthanhTimer.stop();
		nhanVat.setToaDoX(0);
		nhanVat.setToaDoY(0);
		nhanVat.setHuongDi(2);
		nhanVat.setCapDoBoom(2);
		nhanVat.setManChoi(1);
		nhanVat.setDiemSo(0);
		nhanVat.setSoMang(5);
		boss.setToaDoX(-100);
		boss.setToaDoY(-100);
		boss.setSinhLuc(100);
		banDo.setMap(banDo.map1);
		giaoDienTong.repaint();
	}

	@Override
	public synchronized void xuLyQuaManVaThuaCuoc() {
		Thread thread = new Thread(new Runnable() {
			@Override
			public void run() {
				while (true) {
					xuLyQuaMan();
					xuLyBossTrungBoom();
					xuLyBiBossTanCong();
					giaoDienTong.repaint();
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {

					}
				}
			}

		});
		thread.start();
	}

	private void xuLyBiBossTanCong() {
		int xBoss = getModelTong().getBoss().getToaDoX();
		int yBoss = getModelTong().getBoss().getToaDoY();
		int xNhanVat = getModelTong().getNhanVat().getToaDoX();
		int yNhanVat = getModelTong().getNhanVat().getToaDoY();
		if ((xBoss / 20 - 1 <= xNhanVat && yBoss / 20 - 1 <= yNhanVat)
				&& (xBoss / 20 + 1 >= xNhanVat && yBoss / 20 + 1 >= yNhanVat)) {
			int soMangHienTai = getModelTong().getNhanVat().getSoMang();
			if (soMangHienTai - 1 < 0) {
				int action = JOptionPane.showConfirmDialog(null, "Bạn đã chết bạn có muốn lưu điểm", "Thoat Game",
						JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
				if (action == JOptionPane.YES_OPTION) {
					xuLyLuuDiem();
					xuLyNewGame();
				} else {
					System.exit(0);
				}
			} else {
				modelTong.getNhanVat().setSoMang(soMangHienTai - 1);
			}
		}
	}

	public void xuLyBossTrungBoom() {
		ArrayList<Point> viTri = Boom.vitriTrungBoss;
		int xBoss = getModelTong().getBoss().getToaDoX();
		int yBoss = getModelTong().getBoss().getToaDoY();
		for (int i = 0; i < viTri.size(); i++) {
			if ((xBoss / 20 - 1 <= viTri.get(i).x && yBoss / 20 - 1 <= viTri.get(i).y)
					&& (xBoss / 20 + 1 >= viTri.get(i).x && yBoss / 20 + 1 >= viTri.get(i).y)) {
				int sinhLucBoss = getModelTong().getBoss().getSinhLuc();
				if (sinhLucBoss - 1 < 0) {
					int action = JOptionPane.showConfirmDialog(null, "Bạn đã chiến thắng bạn có muốn lưu điểm",
							"Thoat Game", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
					if (action == JOptionPane.YES_OPTION) {
						xuLyLuuDiem();
						xuLyNewGame();
					} else {
						System.exit(0);
					}
				} else {
					getModelTong().getBoss().setSinhLuc(sinhLucBoss - 10);
					Boom.vitriTrungBoss.removeAll(Boom.vitriTrungBoss);
				}
			}
		}
		Boom.vitriTrungBoss.removeAll(Boom.vitriTrungBoss);
	}

	public void xuLyBossDiChuyen() {
		if (isBossXuatHien) {
			boss.setToaDoX(200);
			boss.setToaDoY(200);
		}
		thoiGianThayDoiTrangThai();
		new Thread(() -> {
			while (true) {
				if (!tamDung && nhanVat.getManChoi() == 3 && dangChoi && nhanVat.getSoMang() > 0
						&& boss.getSinhLuc() >= 0) {
					isBossXuatHien = false;
					if (thoiGianThayDoi == 1) {
						boss.diLen();
					}
					if (thoiGianThayDoi == 2) {
						boss.diXuong();
					}
					if (thoiGianThayDoi == 3) {
						boss.sangTrai();
					}
					if (thoiGianThayDoi == 4) {
						boss.sangPhai();
					}
					if (boss.getToaDoX() - 50 < 0) {
						thoiGianThayDoi = 4;
					} else if (boss.getToaDoY() - 50 < 0) {
						thoiGianThayDoi = 2;
					} else if (boss.getToaDoX() + 100 > 400) {
						thoiGianThayDoi = 3;
					} else if (boss.getToaDoY() + 100 > 400) {
						thoiGianThayDoi = 1;
					}
				}
				try {
					Thread.sleep(30);
				} catch (Exception e) {
				}
			}
		}).start();
	}

	private void thoiGianThayDoiTrangThai() {
		Timer timer = new Timer(5000, new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				thoiGianThayDoi = new Random().nextInt(4) + 1;
			}
		});
		timer.start();
	}

	private synchronized void xuLyQuaMan() {
		if (nhanVat.getManChoi() == 1) {
			banDo.setMap(BanDo.map1);
		}
		if (nhanVat.getManChoi() == 2) {
			banDo.setMap(BanDo.map2);
		}
		if (nhanVat.getManChoi() == 3) {
			banDo.setMap(BanDo.map3);
		}
	}

	@Override
	public void xuLyMenu() {
		giaoDienTong.itemThoatGame.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int action = JOptionPane.showConfirmDialog(null, "Bạn có muốn lưu điểm", "Thoat Game",
						JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
				if (action == JOptionPane.YES_OPTION) {
					xuLyLuuDiem();

				} else {
					System.exit(0);
				}
			}
		});
		giaoDienTong.itemNewGame.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				daBatDauGameChua = true;
				if (nhanVat.getManChoi() == 1) {
					dsQuaiVat.setSoLuongQuaiVat(5, 1);
				} else if (nhanVat.getManChoi() == 2) {
					dsQuaiVat.setSoLuongQuaiVat(3, 2);
				} else {
					dsQuaiVat.setSoLuongQuaiVat(0, 3);
				}
				xuLyNewGame();
			}
		});
		giaoDienTong.itemLuuDiem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				xuLyLuuDiem();
			}
		});
		giaoDienTong.itemGiupDo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new HuongDan();
			}
		});
		giaoDienTong.itemGioiThieu.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new GioiThieu();
			}
		});
		giaoDienTong.itemDiem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (Diem.model.getRowCount() == 0) {
					xulyXemDiem();
				} else {
					for (int i = Diem.model.getRowCount() - 1; i >= 0; i--) {
						Diem.model.removeRow(i);
					}
					xulyXemDiem();
				}
				xuLyXoaDiem();
			}

		});
		// Xử lý xem điểm cao nhất!
		giaoDienTong.itemDiemCao.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String name = "";
				ThongTinDiem tt = new DiemNhanVat().diemCaoNhat();
				if (tt.getDiem() == 0) {
					name = "";
				} else {
					name = tt.getName();
				}
				JOptionPane.showMessageDialog(null,
						"Điểm cao nhất là:" + "\n" + name + " " + tt.getDiem() + " " + "điểm");
			}
		});
		giaoDienTong.repaint();
	}

	@Override
	public void xuLyTieuDietBossVaChienThang() {
		// TODO Auto-generated method stub

	}

	private void taoThoiGianTanCong() {
		Timer timer = new Timer(1000, new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				thoiGianTanCong++;
			}
		});
		timer.start();
	}

	@Override
	public void xuLyAmThanh() {

	}

	// xu lý âm thanh của Phong
	private class XuLyAmThanhNen implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// AmThanh.music(AmThanh.Sound_Backgound);
			amthanhTimer.stop();
		}

	}

	private class XuLyTimerBomNo implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			count++;
			ArrayList<Boom> dsBom = modelTong.getNhanVat().getDanhSachBoom();
			ArrayList<Boom> dsBoomNo = modelTong.getNhanVat().getDsBoomNo();
			if (count % 2 == 0 && dsBom.size() > 0) {
				boomNoTimer.start();
				Boom boom = dsBom.remove(0);
				dsBoomNo.add(boom);

			} else if (count % 2 == 1 && dsBoomNo.size() > 0) {
				// AmThanh.music(AmThanh.Sound_Bomb);
				dsBoomNo.remove(0);
				count = 0;
				soBoomDaDat--;
				// boomNoTimer.stop();
			}
			giaoDienTong.repaint();
			// Xu ly quai vat trung boom
			quaiVatTrungBoom();
			// Xu ly hero bi mat mau
			heroTrungBoom();
		}

	}

	private class XuLyTimerItem implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			Random rdItem = new Random();
			cut++;
			String toado = ranDomViTriXuatHienItem();
			int toaDoX = Integer.parseInt(toado.substring(0, toado.indexOf("+")));
			int toaDoY = Integer.parseInt(toado.substring(toado.indexOf("+") + 1, toado.length()));
			if (cut % 10 == 4) {
				modelTong.getItem().setTenItem("itemHeart");
				modelTong.getItem().setxItem(toaDoX);
				modelTong.getItem().setyItem(toaDoY);
			}
			if (cut % 10 == 7) {
				modelTong.getItem().setTenItem("itemLua");
				modelTong.getItem().setxItem(toaDoX);
				modelTong.getItem().setyItem(toaDoY);

			}
			if (cut % 10 == 0) {
				modelTong.getItem().setTenItem("itemBoom");
				modelTong.getItem().setxItem(toaDoX);
				modelTong.getItem().setyItem(toaDoY);

			}
			ranDomViTriXuatHienItem();
			itemTimer.start();
			giaoDienTong.repaint();
		}

	}

	private class XuLyTimerAnItem implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			AnItemTimer.start();
			xTam = getModelTong().getNhanVat().getToaDoX();
			yTam = getModelTong().getNhanVat().getToaDoY();
			if (getModelTong().getItem().getxItem() == getModelTong().getNhanVat().getToaDoX()
					&& getModelTong().getItem().getyItem() == getModelTong().getNhanVat().getToaDoY()
					&& getModelTong().getItem().getTenItem().equals("itemHeart")) {
				// AmThanh.music(AmThanh.Sound_Item);
				itemNao = "heart";
				nhanVat.setChangeViTri(xTam, yTam, itemNao);
				getModelTong().getItem().setxItem(-5);
				getModelTong().getItem().setyItem(-5);
			}
			if (getModelTong().getItem().getxItem() == getModelTong().getNhanVat().getToaDoX()
					&& getModelTong().getItem().getyItem() == getModelTong().getNhanVat().getToaDoY()
					&& getModelTong().getItem().getTenItem().equals("itemLua")) {
				// AmThanh.music(AmThanh.Sound_Item);
				itemNao = "lua";
				nhanVat.setChangeViTri(xTam, yTam, itemNao);
				getModelTong().getItem().setxItem(-5);
				getModelTong().getItem().setyItem(-5);
			}
			if (getModelTong().getItem().getxItem() == getModelTong().getNhanVat().getToaDoX()
					&& getModelTong().getItem().getyItem() == getModelTong().getNhanVat().getToaDoY()
					&& getModelTong().getItem().getTenItem().equals("itemBoom")) {
				// AmThanh.music(AmThanh.Sound_Item);
				itemNao = "boom";
				nhanVat.setChangeViTri(xTam, yTam, itemNao);
				getModelTong().getItem().setxItem(-5);
				getModelTong().getItem().setyItem(-5);
			}
		}

	}

	@Override
	public void xuLyLuuDiem() {
		int diem = modelTong.getNhanVat().getDiemSo();
		String name = JOptionPane.showInputDialog(null, "Mời bạn nhập tên!!");
		Connection conn;

		if (name != null && name.length() > 0) {
			modelDiem.luuDiem(name, diem);
		} else {
			System.out.println("Khong luu diem");
		}
	}

	@Override
	public void xulyXemDiem() {
		String[] array = { "tên", "điểm" };
		modelDiem.xemDiem();
		ArrayList<ThongTinDiem> list = modelDiem.listDiem;
		Diem.model.setColumnIdentifiers(array);
		for (ThongTinDiem thongTinDiem : list) {
			Diem.model.addRow(thongTinDiem.getRow());
		}
		new Diem("Điểm của bạn");
	}

	public void xuLyXoaDiem() {
		Diem.xoa.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new DiemNhanVat().xoaDiem();
				Diem.model.setRowCount(0);
				new Diem().revalidate();
			}
		});
	}

	@Override
	public void xuLyThuaCuoc() {
		// TODO Auto-generated method stub

	}

}
