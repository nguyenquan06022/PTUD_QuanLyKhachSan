package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import ConnectDB.database;
import Entity.TaiKhoan;
import Entity.NhanVien;

public class TaiKhoan_dao {
	NhanVien_dao nhanVien_dao = new NhanVien_dao();
	public TaiKhoan_dao() {
		
	}
	
	public String getRole(String tenTaiKhoan) {
		try {
			Connection con = database.getInstance().getConnection();
			String sql = "select nv.ChucVu from TaiKhoan tk "
					+ "join NhanVien nv on tk.MaNV = nv.MaNV "
					+ "where tk.TenDangNhap = ?";
			PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1, tenTaiKhoan);
            ResultSet rs = preparedStatement.executeQuery();
            if(rs.next() && rs.getString(1) != "") return rs.getString(1);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}
	
	public boolean checkTaiKhoan(String tenTaiKhoan,String matKhau) {
		try {
			Connection con = database.getInstance().getConnection();
			String sql = "select count(*) from TaiKhoan where TenDangNhap=? and MatKhau=?";
			PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1, tenTaiKhoan);
            preparedStatement.setString(2, matKhau);
            ResultSet rs = preparedStatement.executeQuery();
            if(rs.next() && rs.getInt(1) == 1) return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public ArrayList<TaiKhoan> danhSachTaiKhoan(){
		ArrayList<TaiKhoan> dsTK = new ArrayList<TaiKhoan>();
		try {
			Connection con = database.getInstance().getConnection();
			String sql = "Select * from TaiKhoan";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				String maTK = rs.getString(1);
				String tenDN = rs.getString(2);
				String matKhau = rs.getString(3);
				NhanVien nhanVien = nhanVien_dao.getNhanVienTheoMa(rs.getString(4));
				String trangThai = rs.getString(5);
				
				TaiKhoan taiKhoan = new TaiKhoan(maTK, tenDN, matKhau, nhanVien, trangThai);
				dsTK.add(taiKhoan);
	
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dsTK;
	}
	
	public TaiKhoan timTaiKhoan (String tenDN){
		ArrayList<TaiKhoan> dsTK = danhSachTaiKhoan();
		return dsTK.stream().filter(x -> x.getTenDN().equalsIgnoreCase(tenDN)).findFirst().orElse(null);
	}
	
	public boolean dangNhap (String tenDN, String matKhau) {
		TaiKhoan taiKhoan = timTaiKhoan(tenDN);
		
		if (taiKhoan != null && taiKhoan.getMatKhau().equalsIgnoreCase(matKhau)) {
			return true;
		}
		
		return false;
	}
	
	public boolean suaTaiKhoan(TaiKhoan taiKhoan) {
		Connection connection = database.getInstance().getConnection();
		boolean isSuccess = false;
		try {
			ArrayList<TaiKhoan> dsTK = danhSachTaiKhoan();
			if (!dsTK.contains(taiKhoan)) {
				System.out.println("Tài khoản không tồn tại");
			} else {
				String updateSql = "UPDATE TaiKhoan SET MatKhau = ?, TrangThai = ? WHERE MaTaiKhoan = ?";
		        PreparedStatement updateStmt = connection.prepareStatement(updateSql);
		        updateStmt.setString(1, taiKhoan.getMatKhau().trim());
		        updateStmt.setString(2, taiKhoan.getTrangThai().trim());
		        updateStmt.setString(3, taiKhoan.getMaTK());
		        int rowsInserted = updateStmt.executeUpdate();
	            if (rowsInserted > 0) {
	                isSuccess = true;
	            }
			}
		} catch (Exception e) {
	
		}
		return isSuccess;
	}
}
