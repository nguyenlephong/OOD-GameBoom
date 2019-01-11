/*
 *
 * 
 * 
 * */

package playgame;

import java.io.IOException;

import controller.ControllerTong;
import model.ModelTong;
import view.GiaoDienTong;
import view.VaoGame;

public class MainProgram {
	private ModelTong modelTong;
	private GiaoDienTong giaoDienTong;
	private ControllerTong controllerTong;

	public MainProgram() throws IOException {
		giaoDienTong = new GiaoDienTong();
		modelTong = new ModelTong(VaoGame.nhanVat, VaoGame.hinhAnh, null, null, VaoGame.item, null, VaoGame.banDo);
		controllerTong = new ControllerTong(giaoDienTong, modelTong);
	}

	public void dieuKhienGame() {
		controllerTong.diChuyenNhanVatVaDatBoom();
		controllerTong.xuLyBoomNo();
		controllerTong.xuLyAnItem();
		controllerTong.xuLyMatMau();
		controllerTong.xuLyTieuDietQuaiVat();
//		controllerTong.xuLyNewGame();
//		controllerTong.xuLyLuuGame();
		controllerTong.xuLyMenu();
		controllerTong.xuLyQuaManVaThuaCuoc();
		controllerTong.xuLyTieuDietBossVaChienThang();

	}

	public static void main(String[] args) throws IOException {
		MainProgram mainProgram = new MainProgram();
		mainProgram.dieuKhienGame();
	}
}
