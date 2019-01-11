/*
 *
 * 
 * 
 * */

package playgame;

import java.io.IOException;

import controller.ControlTheGame;
import controller.ControllerTong;
import model.Boss;
import model.ModelTong;
import view.GiaoDienTong;
import view.Game;

public class MainProgram {
	private ModelTong modelTong;
	private GiaoDienTong giaoDienTong;
	private ControlTheGame controllerTong;

	public MainProgram() throws IOException {
//		new ControllerTong().amthanhTimer.start();
		giaoDienTong = new GiaoDienTong();
		modelTong = new ModelTong();
		controllerTong = new ControllerTong(giaoDienTong, modelTong);
	}

	public void dieuKhienGame() {
			controllerTong.xuLyMenu();
			controllerTong.diChuyenNhanVatVaDatBoom();
			controllerTong.xuLyBoomNo();
			controllerTong.xuLyAnItem();	
			controllerTong.xuLyTieuDietQuaiVat();
			controllerTong.quaiVatDiChuyen();
			controllerTong.xuLyQuaManVaThuaCuoc();
			controllerTong.xuLyBossDiChuyen();
			controllerTong.xuLyTieuDietBossVaChienThang();
			giaoDienTong.repaint();
		}

	public static void main(String[] args) throws IOException {
		MainProgram mainProgram = new MainProgram();
		mainProgram.dieuKhienGame();
	}
}
