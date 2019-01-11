package model;

/**
 * @author huynh_000
 *
 */
public class ThongTinDiem {
	private String name;
	private int diem;
	public ThongTinDiem(String name, int diem) {
		super();
		this.name = name;
		this.diem = diem;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getDiem() {
		return diem;
	}
	public void setDiem(int diem) {
		this.diem = diem;
	}
	public Object[] getRow(){
		return new Object[]{name,diem};
	}
	@Override
	public String toString() {
		String s=this.getName()+" "+this.getDiem()+"";
		return s;
	}

}
