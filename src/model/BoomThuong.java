package model;

public class BoomThuong extends Boom{

	public BoomThuong(int toaDoX, int toaDoY) {
		super(toaDoX, toaDoY);
		this.strategy=new VeBoomThuong();
	}

}
