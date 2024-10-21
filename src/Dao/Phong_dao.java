package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import ConnectDB.database;
import Entity.LoaiPhong;
import Entity.Phong;



public class Phong_dao {
	LoaiPhong_dao loaiPhong_dao = new LoaiPhong_dao();
	public Phong_dao() {
		
	}
	
	public ArrayList<LoaiPhong> dsLP = loaiPhong_dao.danhSachLoaiPhong();
	
	public ArrayList<Phong> danhSachPhongTheoTrangThai(String trangThai1) {
		ArrayList<Phong> dsPhong = new ArrayList<Phong>();
		try {
			Connection con = database.getInstance().getConnection();
			String sql = "Select * from Phong where TrangThai = ?";
			PreparedStatement stmt = con.prepareStatement(sql);
	        stmt.setString(1, trangThai1);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {	
				String maPhong = rs.getString(1);
				String trangThai = rs.getString(2);
				String tang = rs.getString(3);
				LoaiPhong lp = loaiPhong_dao.timLoaiPhong(rs.getString(4));
				Phong phong = new Phong(maPhong, trangThai,tang, lp);
				dsPhong.add(phong);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dsPhong;
	}
	
	public ArrayList<Phong> danhSachPhong(){
		ArrayList<Phong> dsPhong = new ArrayList<Phong>();
		try {
			Connection con = database.getInstance().getConnection();
			String sql = "Select * from Phong";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {	
				String maPhong = rs.getString(1);
				String trangThai = rs.getString(2);
				String tang = rs.getString(3);
				LoaiPhong lp = loaiPhong_dao.timLoaiPhong(rs.getString(4));
				Phong phong = new Phong(maPhong, trangThai,tang, lp);
				dsPhong.add(phong);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dsPhong;
	}
	
	public List<Phong> timDanhSachPhongTheoMa(String maPhong) {
		ArrayList<Phong> dsPhong = danhSachPhong();
		return dsPhong.stream().filter(x -> x.getMaPhong().matches(maPhong)).collect(Collectors.toList());
	}
	
	public Phong timPhongTheoMa (String maPhong) {
		ArrayList<Phong> dsPhong = danhSachPhong();
		return dsPhong.stream().filter(x -> x.getMaPhong().equalsIgnoreCase(maPhong)).findFirst().orElse(null);
	}
	
	public List<Phong> locPhongTheoLoai (String maLP) {
		ArrayList<Phong> dsPhong = danhSachPhong();
		return dsPhong.stream().filter(x->x.getLoaiPhong().getMaLoaiPhong().equalsIgnoreCase(maLP)).collect(Collectors.toList());
	}
	
	public boolean themPhong (Phong phong, int tang) {
		Connection con = database.getInstance().getConnection();
	    PreparedStatement stmt = null;
	    boolean isSuccess = false;
	    List<Phong> dsPhongTheoTang = timDanhSachPhongTheoMa("P" + String.valueOf(tang));
	    int soPhong = dsPhongTheoTang.size();
	    String maPhong = "P" + String.valueOf(tang) + String.valueOf(soPhong);
	    Phong phongMoi = timPhongTheoMa(maPhong);
	    try {
	    	if (phongMoi != null) {
	    		System.out.println("Phòng đã tồn tại, không thể thêm");
	    	} else {
	    		String sql = "INSERT INTO Phong (MaPhong, TrangThai, Tang, MaLP) VALUES (?, ?, ?, ?)";
	    		stmt = con.prepareStatement(sql);
	    		stmt.setString(1, maPhong);
	    		stmt.setString(2, phong.getTrangThai());
	    		stmt.setString(3, phong.getTang());
	    		stmt.setString(4, phong.getLoaiPhong().getMaLoaiPhong());
	    		int rowsInserted = stmt.executeUpdate();
	            if (rowsInserted > 0) {
	                isSuccess = true;
	            }
	    	}
	    } catch (Exception e) {
	    	e.printStackTrace();
	    }
	    return isSuccess;
	}
	
	public boolean suaPhong(Phong phong) {
		Connection connection = database.getInstance().getConnection();
		boolean isSuccess = false;
		try {
			ArrayList<Phong> dsPhong = danhSachPhong();
			if (!dsPhong.contains(phong)) {
				System.out.println("Phòng không tồn tại");
			} else {
				String updateSql = "UPDATE Phong SET TrangThai = ?, Tang = ?, MaLP = ? WHERE MaPhong = ?";
		        PreparedStatement updateStmt = connection.prepareStatement(updateSql);
		        updateStmt.setString(1, phong.getTrangThai());
		        updateStmt.setString(2, phong.getTang());
		        updateStmt.setString(3, phong.getLoaiPhong().getMaLoaiPhong());
		        updateStmt.setString(4, phong.getMaPhong());
		        int rowsInserted = updateStmt.executeUpdate();
	            if (rowsInserted > 0) {
	                isSuccess = true;
	            }
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return isSuccess;
	}
}
