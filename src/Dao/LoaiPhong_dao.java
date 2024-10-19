package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import ConnectDB.database;
import Entity.LoaiPhong;



public class LoaiPhong_dao {
	public LoaiPhong_dao() {
		
	}
	
	public ArrayList<LoaiPhong> danhSachLoaiPhong(){
		ArrayList<LoaiPhong> dsLP = new ArrayList<LoaiPhong>();
		try {
			Connection con = database.getInstance().getConnection();
			String sql = "Select * from LoaiPhong";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				String maLP = rs.getString(1);
				String tenLP = rs.getString(2);
				double giaGioDau = rs.getDouble(3);
				double giaGioTiepTheo = rs.getDouble(4);
				double giaQuaDem = rs.getDouble(5);
				double giaCaNgay = rs.getDouble(6);
				
				LoaiPhong loaiPhong = new LoaiPhong(maLP, tenLP, giaGioDau, giaGioTiepTheo, giaQuaDem, giaCaNgay);
				
				dsLP.add(loaiPhong);
	
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dsLP;
	}
	
	public LoaiPhong timLoaiPhong(String maLP) {
		ArrayList<LoaiPhong> dsLP = danhSachLoaiPhong();
		return dsLP.stream().filter(x -> x.getMaLoaiPhong().equalsIgnoreCase(maLP)).findFirst().orElse(null);
	}
	
	
	//So sánh những thành phần khác nhau giữa loại phòng mới và loại phòng cũ, nếu thuộc tính nào thay đổi thì lấy cái mới, không thì lấy cái cũ
	public LoaiPhong soSanhKhacNhau(LoaiPhong loaiPhong) {
		LoaiPhong newLP = new LoaiPhong();
		LoaiPhong oldLP = timLoaiPhong(loaiPhong.getMaLoaiPhong());
		
		newLP.setMaLoaiPhong(loaiPhong.getMaLoaiPhong().trim());
		newLP.setTenLoaiPhong(loaiPhong.getTenLoaiPhong().equalsIgnoreCase(oldLP.getTenLoaiPhong())?oldLP.getTenLoaiPhong().trim():loaiPhong.getTenLoaiPhong().trim());
		newLP.setGiaGioDau(loaiPhong.getGiaGioDau() == oldLP.getGiaGioDau()?oldLP.getGiaGioDau():loaiPhong.getGiaGioDau());
		newLP.setGiaGioTiepTheo(loaiPhong.getGiaGioTiepTheo() == oldLP.getGiaGioTiepTheo()?oldLP.getGiaGioTiepTheo():loaiPhong.getGiaGioTiepTheo());
		newLP.setGiaQuaDem(loaiPhong.getGiaQuaDem() == oldLP.getGiaQuaDem()?oldLP.getGiaQuaDem():loaiPhong.getGiaQuaDem());
		newLP.setGiaCaNgay(loaiPhong.getGiaCaNgay() == oldLP.getGiaCaNgay()?oldLP.getGiaCaNgay():loaiPhong.getGiaCaNgay());
		
		return newLP;
	}
	
	public boolean suaLoaiPhong(LoaiPhong loaiPhong) {
		Connection connection = database.getInstance().getConnection();
		boolean isSuccess = false;
		try {
			ArrayList<LoaiPhong> dsLP = danhSachLoaiPhong();
			if (!dsLP.contains(loaiPhong)) {
				System.out.println("Loại phòng không tồn tại");
			} else {
				String updateSql = "UPDATE LoaiPhong SET TenLP = ?, GiaGioDau = ?, GiaGioTiepTheo = ?, GiaQuaDem = ?, GiaCaNgay = ? WHERE MaLP = ?";
		        PreparedStatement updateStmt = connection.prepareStatement(updateSql);
		        updateStmt.setString(1, loaiPhong.getTenLoaiPhong());
		        updateStmt.setDouble(2, loaiPhong.getGiaGioDau());
		        updateStmt.setDouble(3, loaiPhong.getGiaGioTiepTheo());
		        updateStmt.setDouble(4, loaiPhong.getGiaQuaDem());
		        updateStmt.setDouble(5, loaiPhong.getGiaCaNgay());
		        
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
