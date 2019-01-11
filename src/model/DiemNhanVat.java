package model;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
public class DiemNhanVat {
	public static ArrayList<ThongTinDiem>listDiem;
	Connection conn;
	ResultSet result;
	Statement stmt;
	public DiemNhanVat() {
		super();
		conn=DatabaseConnection.getConnection();
	}


	public void xemDiem(){
		listDiem = new ArrayList<>();
		String sql="select * from luudiem";
		try {
			stmt=conn.createStatement();
			result=stmt.executeQuery(sql);
			while(result.next()){
				ThongTinDiem tt=new ThongTinDiem(result.getString(1), result.getInt(2));
				listDiem.add(tt);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void xoaDiem(){
		listDiem=new ArrayList<>();
		String sql="delete from luudiem";
		try {
			PreparedStatement pre=conn.prepareStatement(sql);
			pre.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void luuDiem(String name,int diem){
		if(name.length()>0){
		String sql="insert into luudiem values ('"+name+"','"+diem+"')";
		PreparedStatement pre;
		try {
			pre = conn.prepareStatement(sql);
			pre.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}else{
			System.out.println("luu thanh cong");
		}
	}
	public ThongTinDiem diemCaoNhat(){
		ThongTinDiem tt = null;
		String sql="select l.Ten,max(l.Diem) from LuuDiem l";
		try {
			stmt=conn.createStatement();
			result=stmt.executeQuery(sql);
			while(result.next()){
				tt=new ThongTinDiem(result.getString(1), result.getInt(2));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return tt;
		
	}
}
