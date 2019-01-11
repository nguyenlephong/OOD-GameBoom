package model;

import java.util.ArrayList;

import view.Game;

/*
 * BOOM LA 1 THUOC TINH CUA NHAN VAT NEN KHONG LA 1 MODEL NHA
 * */
public class ModelTong {
//	public static HinhAnh hinhAnh =new HinhAnh();
//	public static NhanVat nhanVat = new NhanVat(2, 0, 0, 2, 1,0, 1, hinhAnh); // man 1;
//	public static BanDo banDo  = new BanDo(hinhAnh, nhanVat.getManChoi()) ;
//	public static Item item = new Item(5, 5, hinhAnh,""); ;
//	public static Boss boss=new Boss(10, 10, hinhAnh);;
//	private AmThanh amThanh;
	private HinhAnh hinhAnh;
	private NhanVat nhanVat;
	private BanDo banDo;
	private Item item;
	private Boss boss;
	
//	private DanhSachQuaiVat dsQuaiVat;
	public ModelTong() {
	}
	
//	public DanhSachQuaiVat getDsQuaiVat() {
//		return dsQuaiVat;
//	}
//
//	public void setDsQuaiVat(DanhSachQuaiVat dsQuaiVat) {
//		this.dsQuaiVat = dsQuaiVat;
//	}

	public ModelTong(HinhAnh hinhAnh, NhanVat nhanVat, BanDo banDo, Item item, Boss boss) {
		super();
		this.hinhAnh = hinhAnh;
		this.nhanVat = nhanVat;
		this.banDo = banDo;
		this.item = item;
		this.boss = boss;
	}

	public NhanVat getNhanVat() {
		return nhanVat;
	}
	public void setNhanVat(NhanVat nhanVat) {
		this.nhanVat = nhanVat;
	}
	public HinhAnh getHinhAnh() {
		return hinhAnh;
	}
	public void setHinhAnh(HinhAnh hinhAnh) {
		this.hinhAnh = hinhAnh;
	}
	
//	public AmThanh getAmThanh() {
//		return amThanh;
//	}
//	public void setAmThanh(AmThanh amThanh) {
//		this.amThanh = amThanh;
//	}
	
	public Item getItem() {
		return item;
	}
	public void setItem(Item item) {
		this.item = item;
	}
	public Boss getBoss() {
		return boss;
	}
	public void setBoss(Boss boss) {
		this.boss = boss;
	}
	public BanDo getBanDo() {
		return banDo;
	}
	public void setBanDo(BanDo banDo) {
		this.banDo = banDo;
	}
}
