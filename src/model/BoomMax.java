package model;

public class BoomMax extends Boom{

	public BoomMax(int toaDoX, int toaDoY) {
		super(toaDoX, toaDoY);
		this.strategy=new VeBoomMax();
		}

}
