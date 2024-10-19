package Dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.stream.Collectors;

import ConnectDB.database;
import Entity.NhanVien;

public class NhanVien_dao {
	//NhanVien_dao nhanVien_dao = new NhanVien_dao();
	public NhanVien_dao() {
		
	}
	
	public static void khoiTao () {
		try {
			database.getInstance().Connect();;
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public ArrayList<NhanVien> danhSachNhanVien(){
		khoiTao();
		ArrayList<NhanVien> dsNV = new ArrayList<NhanVien>();
		try {
			Connection con = database.getInstance().getConnection();
			String sql = "Select * from NhanVien";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				String maNhanVien = rs.getString(1);
				String hoTen = rs.getString(2);
				int gioiTinh = rs.getInt(3);
				Date ngaySinh = rs.getDate(4);
				String soCCCD = rs.getString(5);
				String soDT = rs.getString(6);
				String chucVu = rs.getString(7);
				String trangThai = rs.getString(8);
				NhanVien nhanVien = new NhanVien(maNhanVien, hoTen, gioiTinh, ngaySinh, soCCCD, soDT, chucVu, trangThai);
				
				dsNV.add(nhanVien);
	
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dsNV;
	}
	
	public boolean themNhanVien (NhanVien nhanVien) {
		khoiTao();
		Connection con = database.getInstance().getConnection();
	    PreparedStatement stmt = null;
	    boolean isSuccess = false;
	    
	    try {
	    	ArrayList<NhanVien> dsNV = danhSachNhanVien();
	    	if (dsNV.contains(nhanVien)) {
	    		System.out.println("Nhân viên đã tồn tại, không thể thêm");
	    	} else {
	    		String sql = "INSERT INTO NhanVien (MaNV, HoTen, GioiTinh, NgaySinh, CCCD, SDT, ChucVu, TrangThaiLamViec) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
	    		stmt = con.prepareStatement(sql);
	    		stmt.setString(1, "NV00" + String.valueOf(dsNV.size() + 1));
	    		stmt.setString(2, nhanVien.getHoTen());
	    		stmt.setInt(3, nhanVien.getGioiTinh());
	    		stmt.setDate(4, nhanVien.getNgaySinh());
	    		stmt.setString(5, nhanVien.getCCCD());
	    		stmt.setString(6, nhanVien.getSoDT());
	    		stmt.setString(7, nhanVien.getChucVu());
	    		stmt.setString(8, nhanVien.getTrangThaiLamViec());
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
	
	public List<NhanVien> getNhanVienTheoTen(String hoTen) {
		List<NhanVien> nv = null;
	    try {
			ArrayList<NhanVien> dsNV = danhSachNhanVien();
			nv = dsNV.stream().filter(x -> x.getHoTen().matches(".*" + hoTen + ".*")).collect(Collectors.toList());
		} catch (Exception e) {
			// TODO: handle exception
		}
	    return nv;
	}
	
	public NhanVien getNhanVienTheoMa(String maNV) {
		NhanVien nv = null;
		try {
			ArrayList<NhanVien> dsNV = danhSachNhanVien();
			nv = dsNV.stream().filter(x -> x.getMaNV().equalsIgnoreCase(maNV)).findFirst().orElse(null);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return nv;
	}
	
	public boolean suaNhanVien(NhanVien nhanVien) {
		khoiTao();
		Connection connection = database.getInstance().getConnection();
		boolean isSuccess = false;
		try {
			ArrayList<NhanVien> dsNV = danhSachNhanVien();
			if (!dsNV.contains(nhanVien)) {
				System.out.println("Nhân viên không tồn tại");
			} else {
				String updateSql = "UPDATE NhanVien SET HoTen = ?, GioiTinh = ?, NgaySinh = ?, CCCD = ?, SDT = ?, ChucVu = ?, TrangThaiLamViec = ? WHERE MaNV = ?";
		        PreparedStatement updateStmt = connection.prepareStatement(updateSql);
		        updateStmt.setString(1, nhanVien.getHoTen());
		        updateStmt.setInt(2, nhanVien.getGioiTinh());
		        updateStmt.setDate(3, nhanVien.getNgaySinh());
		        updateStmt.setString(4, nhanVien.getCCCD());
		        updateStmt.setString(5, nhanVien.getSoDT());
		        updateStmt.setString(6, nhanVien.getChucVu());
		        updateStmt.setString(7, nhanVien.getTrangThaiLamViec());
		        updateStmt.setString(8, nhanVien.getMaNV());
		        
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
