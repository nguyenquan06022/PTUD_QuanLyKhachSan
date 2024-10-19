package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import ConnectDB.database;
import Entity.KhachHang;

public class KhachHang_dao {
//	static KhachHang_dao khachHang_dao = new KhachHang_dao();
	public KhachHang_dao() {
		
	}
	
	public ArrayList<KhachHang> danhSachKhachHang(){
		ArrayList<KhachHang> dsKH = new ArrayList<KhachHang>();
		try {
			Connection con = database.getInstance().getConnection();
			String sql = "Select * from KhachHang";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				String maKH = rs.getString(1);
				String hoTen = rs.getString(2);
				String SDT = rs.getString(3);
				int gioiTinh = rs.getInt(4);
				String quocTich = rs.getString(5);
				int diemKM = rs.getInt(6);
				KhachHang khachHang = new KhachHang(maKH, hoTen, SDT, gioiTinh, quocTich, diemKM);
				
				dsKH.add(khachHang);
	
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dsKH;
	}
	
	public KhachHang timKhachHangTheoMa(String maKH) {
		ArrayList<KhachHang> dsKH = danhSachKhachHang();
		return dsKH.stream().filter(x -> x.getMaKH().equalsIgnoreCase(maKH)).findFirst().orElse(null);
	}
	
	public List<KhachHang> timKhachHangTheoTen (String hoTen){
		ArrayList<KhachHang> dsKH = danhSachKhachHang();
		return dsKH.stream().filter(x -> x.getTenKH().matches(".*" + hoTen + ".*")).collect(Collectors.toList());
	}
	
	public KhachHang timKhachHangTheoSDT (String SDT){
		ArrayList<KhachHang> dsKH = danhSachKhachHang();
		return dsKH.stream().filter(x -> x.getSoDT().equalsIgnoreCase(SDT)).findFirst().orElse(null);
	}
	
	public boolean kiemTraKhachHangCu (String hoTen, String SDT) {
		ArrayList<KhachHang> dsKH = danhSachKhachHang();
		KhachHang khachHang = dsKH.stream().filter(x -> (x.getTenKH().equalsIgnoreCase(SDT))).findFirst().orElse(null);
		
		if (khachHang.getTenKH().equalsIgnoreCase(hoTen)) {
			return true;
		}
		
		return false;
	}
	
	public boolean themKhachHang (KhachHang khachHang) {
		Connection con = database.getInstance().getConnection();
	    PreparedStatement stmt = null;
	    boolean isSuccess = false;
	    
	    try {
	    	ArrayList <KhachHang> dsKH = danhSachKhachHang();
	    		String sql = "INSERT INTO KhachHang (MaKH, HoTen, SDT, GioiTinh, QuocTich, DiemKhuyenMai) VALUES (?, ?, ?, ?, ?, ?)";
	    		int soLuong = dsKH.size();
	    		String maKH = "KH00" + String.valueOf(soLuong + 1);
	    		stmt = con.prepareStatement(sql);
	    		stmt.setString(1, maKH);
	    		stmt.setString(2, khachHang.getTenKH());
	    		stmt.setString(3,  khachHang.getSoDT());
	    		stmt.setInt(4, khachHang.getGioiTinh());
	    		stmt.setString(5, khachHang.getQuocTich());
	    		stmt.setInt(6, 0);
	    		int rowsInserted = stmt.executeUpdate();
	            if (rowsInserted > 0) {
	                isSuccess = true;
	            }
	    } catch (Exception e) {
	    	e.printStackTrace();
	    }
	    return isSuccess;
	}
	
	public boolean suaKhachHang(KhachHang khachHang){
		Connection connection = database.getInstance().getConnection();
		boolean isSuccess = false;
		try {
			ArrayList<KhachHang> dsKH = danhSachKhachHang();
			if (!dsKH.contains(khachHang)) {
				System.out.println("Khách hàng không tồn tại");
			} else {
				String updateSql = "UPDATE KhachHang SET SDT = ?, GioiTinh = ?, QuocTich = ? WHERE MaKH = ?";
		        PreparedStatement updateStmt = connection.prepareStatement(updateSql);
		        updateStmt.setString(1, khachHang.getSoDT());
		        updateStmt.setInt(2, khachHang.getGioiTinh());
		        updateStmt.setString(3, khachHang.getQuocTich());
		        updateStmt.setString(4, khachHang.getMaKH());
		        
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
