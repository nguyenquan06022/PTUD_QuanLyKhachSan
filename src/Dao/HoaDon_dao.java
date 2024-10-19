package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.sql.Timestamp;
import java.util.List;
import java.util.stream.Collectors;

import ConnectDB.database;
import Entity.HoaDon;
import Entity.KhachHang;
import Entity.NhanVien;
import Entity.PhieuDatPhong;

public class HoaDon_dao {
//	HoaDon_dao hoaDon_dao = new HoaDon_dao();
	static PhieuDatPhong_dao phieuDatPhong_dao = new PhieuDatPhong_dao();
	static NhanVien_dao nhanVien_dao = new NhanVien_dao();
	static KhachHang_dao khachHang_dao = new KhachHang_dao();
	public HoaDon_dao() {
		
	}
	
	public static void khoiTao () {
		try {
			database.getInstance().Connect();;
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public ArrayList<HoaDon> danhSachHoaDon(){
		khoiTao();
		ArrayList<HoaDon> dsHD = new ArrayList<HoaDon>();
		try {
			Connection con = database.getInstance().getConnection();
			String sql = "Select * from HoaDon";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				String maHD = rs.getString(1);
				Timestamp thoiGianNhan = rs.getTimestamp(2);
				Timestamp thoiGianTra = rs.getTimestamp(3);
				Timestamp ngayLapHoaDon = rs.getTimestamp(4);
				PhieuDatPhong phieuDatPhong = phieuDatPhong_dao.timPhieuDatPhongChinhXac(rs.getString(5));
				KhachHang khachHang = khachHang_dao.timKhachHangTheoMa(rs.getString(7));
				NhanVien nhanVien = nhanVien_dao.getNhanVienTheoMa(rs.getString(6));
				
				HoaDon hoaDon = new HoaDon(maHD, thoiGianNhan, thoiGianTra, ngayLapHoaDon, nhanVien, khachHang, phieuDatPhong);
				
				dsHD.add(hoaDon);
	
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dsHD;
	}
	
	public List<HoaDon> timHoaDonTheoMa (String maHD){
		ArrayList<HoaDon> dsHD = danhSachHoaDon();
		return dsHD.stream().filter(x -> x.getMaHD().matches(".*" + maHD + ".*")).collect(Collectors.toList());
	}
	
	public static String taoMaHoaDon() {
	    LocalDateTime now = LocalDateTime.now();
	    String ngay = String.valueOf(now.getDayOfMonth());
	    String thang = String.valueOf(now.getMonthValue());
	    String nam = String.valueOf(now.getYear());
	    String gio = String.valueOf(now.getHour());
	    String phut = String.valueOf(now.getMinute());
	    String giay = String.valueOf(now.getSecond());
	    
	    return "HD" + nam + thang + ngay + gio + phut + giay;
	}
	
	public boolean themHoaDon (HoaDon hoaDon) {
		khoiTao();
		Connection con = database.getInstance().getConnection();
	    PreparedStatement stmt = null;
	    boolean isSuccess = false;
	    String maHoaDon = taoMaHoaDon();
	    try {
	    		String sql = "INSERT INTO HoaDon (MaHoaDon, ThoiGianNhan, ThoiGianTra, NgayLapHoaDon, MaPhieuDatPhong, MaNV, MaKH) VALUES (?, ?, ?, ?, ?, ?, ?)";
	    		stmt = con.prepareStatement(sql);
	    		stmt.setString(1, maHoaDon);
	    		stmt.setTimestamp(2, hoaDon.getThoiGianNhan());
	    		stmt.setTimestamp(3, hoaDon.getThoiGianTra());
	    		stmt.setTimestamp(4, hoaDon.getNgayLapHD());
	    		stmt.setString(5, hoaDon.getPhieuDatPhong().getMaPhieuDatPhong());
	    		stmt.setString(6, hoaDon.getNhanVien().getMaNV());
	    		stmt.setString(7, hoaDon.getKhachHang().getMaKH());
	    		int rowsInserted = stmt.executeUpdate();
	            if (rowsInserted > 0) {
	                isSuccess = true;
	            }
	    } catch (Exception e) {
	    	e.printStackTrace();
	    }
	    return isSuccess;
	}
}

