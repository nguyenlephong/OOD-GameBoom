package model;
/*
 * BOOM LA 1 THUOC TINH CUA NHAN VAT NEN KHONG LA 1 MODEL NHA
 * */
public class ModelTong {
	private NhanVat nhanVat;
	private HinhAnh hinhAnh;
	private AmThanh amThanh;
	private QuaiVat quaiVat;
	private Item item;
	private Boss boss;
	private BanDo banDo;
	public ModelTong(NhanVat nhanVat, HinhAnh hinhAnh,AmThanh amThanh, QuaiVat quaiVat, Item item, Boss boss, BanDo banDo) {
		this.nhanVat = nhanVat;
		this.hinhAnh = hinhAnh;
		this.amThanh=amThanh;
		this.quaiVat = quaiVat;
		this.item = item;
		this.boss = boss;
		this.banDo = banDo;
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
	
	public AmThanh getAmThanh() {
		return amThanh;
	}
	public void setAmThanh(AmThanh amThanh) {
		this.amThanh = amThanh;
	}
	public QuaiVat getQuaiVat() {
		return quaiVat;
	}
	public void setQuaiVat(QuaiVat quaiVat) {
		this.quaiVat = quaiVat;
	}
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
