package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import ConnectDB.database;
import Entity.DichVu;


public class DichVu_dao {
//	DichVu_dao dichVu_dao = new DichVu_dao();
	public DichVu_dao() {
		
	}
	
	public static void khoiTao () {
		try {
			database.getInstance().Connect();;
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public static ArrayList<DichVu> danhSachDichVu(){
		khoiTao();
		ArrayList<DichVu> dsDV = new ArrayList<DichVu>();
		try {
			Connection con = database.getInstance().getConnection();
		    if (con == null) {
		        System.out.println("Connection is not established.");
		    }
			String sql = "Select * from DichVu";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				String maDichVu = rs.getString(1);
				String tenDichVu = rs.getString(2);
				double giaTien = rs.getDouble(3);
				String trangThai = rs.getString(4);
				DichVu dichVu = new DichVu(maDichVu, tenDichVu, giaTien, trangThai);
				
				dsDV.add(dichVu);
	
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dsDV;
	}
	
	public static boolean themDichVu (DichVu dichVu) {
		khoiTao();
		Connection con = database.getInstance().getConnection();
	    PreparedStatement stmt = null;
	    boolean isSuccess = false;
	    
	    try {
	    	ArrayList<DichVu> dsDV = danhSachDichVu();
	    	if (dsDV.contains(dichVu)) {
	    		System.out.println("Dịch vụ đã tồn tại, không thể thêm");
	    	} else {
	    		String sql = "INSERT INTO DichVu(MaDichVu, TenDichVu, DonGia, TrangThai) VALUES (?, ?, ?, ?)";
	    		stmt = con.prepareStatement(sql);
	    		stmt.setString(1, "DV00" + String.valueOf(dsDV.size() + 1));
	    		stmt.setString(2, dichVu.getTenDV());
	    		stmt.setDouble(3, dichVu.getDonGia());
	    		stmt.setString(4, dichVu.getTrangThaiDichVu());
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
	
	public static List<DichVu> getDichVuTheoTen(String hoTen) {
		List<DichVu> dv = null;
	    try {
			ArrayList<DichVu> dsDV = danhSachDichVu();
			dv = dsDV.stream().filter(x -> x.getTenDV().matches(".*" + hoTen + ".*")).collect(Collectors.toList());
		} catch (Exception e) {
			// TODO: handle exception
		}
	    return dv;
	}
	
	public static DichVu getDichVuTheoMa(String maDV) {
		DichVu dv = null;
		try {
			ArrayList<DichVu> dsDV = danhSachDichVu();
			dv = dsDV.stream().filter(x -> x.getMaDV().equalsIgnoreCase(maDV)).findFirst().orElse(null);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return dv;
	}
	
	public static boolean suaDichVu(DichVu dichVu) {
		khoiTao();
		Connection connection = database.getInstance().getConnection();
		boolean isSuccess = false;
		try {
			ArrayList<DichVu> dsDV = danhSachDichVu();
			if (!dsDV.contains(dichVu)) {
				System.out.println("Dịch vụ không tồn tại");
			} else {
				String updateSql = "UPDATE DichVu SET TenDichVu = ?, DonGia = ?, TrangThai = ? WHERE MaDichVu = ?";
		        PreparedStatement updateStmt = connection.prepareStatement(updateSql);
		        updateStmt.setString(1, dichVu.getTenDV());
		        updateStmt.setDouble(2, dichVu.getDonGia());
		        updateStmt.setString(3, dichVu.getTrangThaiDichVu());
		        updateStmt.setString(4, dichVu.getMaDV());
		        
		        
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
