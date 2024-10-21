package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.sql.Timestamp;
import java.util.List;
import java.util.stream.Collectors;

import ConnectDB.database;
import Entity.KhachHang;
import Entity.NhanVien;
import Entity.PhieuDatPhong;
import Gui.itemPhong;

public class PhieuDatPhong_dao {
    static NhanVien_dao nhanVien_dao = new NhanVien_dao();
    static KhachHang_dao khachHang_dao = new KhachHang_dao();

    public PhieuDatPhong_dao() {}

    public static void khoiTao() {
        try {
            database.getInstance().Connect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ArrayList<PhieuDatPhong> danhSachPhieuDatPhong() {
        khoiTao();
        ArrayList<PhieuDatPhong> dsPDP = new ArrayList<PhieuDatPhong>();
        try {
            Connection con = database.getInstance().getConnection();
            String sql = "Select MaPhieuDatPhong,ThoiGianDat,MaKH,MaNV from PhieuDatPhong";
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                String maPDP = rs.getString(1);
                Timestamp thoiGianDat = rs.getTimestamp(2);
                KhachHang khachHang = khachHang_dao.timKhachHangTheoMa(rs.getString(3));
                NhanVien nhanVien = nhanVien_dao.getNhanVienTheoMa(rs.getString(4));
                PhieuDatPhong phieuDatPhong = new PhieuDatPhong(maPDP, thoiGianDat, nhanVien, khachHang);
                dsPDP.add(phieuDatPhong);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dsPDP;
    }

    public List<PhieuDatPhong> timPhieuDatPhongTheoMa(String maPDP) {
        ArrayList<PhieuDatPhong> dsPDP = danhSachPhieuDatPhong();
        return dsPDP.stream().filter(x -> x.getMaPhieuDatPhong().matches(".*" + maPDP + ".*")).collect(Collectors.toList());
    }

    public PhieuDatPhong timPhieuDatPhongChinhXac(String ma) {
        ArrayList<PhieuDatPhong> dsPDP = danhSachPhieuDatPhong();
        return dsPDP.stream().filter(x -> x.getMaPhieuDatPhong().equalsIgnoreCase(ma)).findFirst().orElse(null);
    }

    public static String taoMaPhieuDatPhong() {
        String ngay = String.valueOf(LocalDateTime.now().getDayOfMonth());
        String thang = String.valueOf(LocalDateTime.now().getMonthValue());
        String nam = String.valueOf(LocalDateTime.now().getYear());
        String gio = String.valueOf(LocalTime.now().getHour());
        String phut = String.valueOf(LocalTime.now().getMinute());
        String giay = String.valueOf(LocalTime.now().getSecond());
        return "PD" + nam + thang + ngay + gio + phut + giay;
    }

    public boolean themPhieuDatPhong(PhieuDatPhong phieuDatPhong) {
        Connection con = database.getInstance().getConnection();
        PreparedStatement stmt = null;
        boolean isSuccess = false;
        String maPhieuDatPhong = taoMaPhieuDatPhong();
        try {
            String sql = "INSERT INTO PhieuDatPhong (MaPhieuDatPhong, ThoiGianDat, MaKH, MaNV) VALUES (?, ?, ?, ?)";
            stmt = con.prepareStatement(sql);
            stmt.setString(1, maPhieuDatPhong);
            stmt.setTimestamp(2, phieuDatPhong.getThoiGianDat());
            stmt.setString(3, phieuDatPhong.getKhachHang().getMaKH());
            stmt.setString(4, phieuDatPhong.getNhanVien().getMaNV());
            int rowsInserted = stmt.executeUpdate();
            if (rowsInserted > 0) {
                isSuccess = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isSuccess;
    }

//    public boolean suaPhieuDatPhong(PhieuDatPhong phieuDatPhong) {
//        khoiTao();
//        Connection connection = database.getInstance().getConnection();
//        boolean isSuccess = false;
//        try {
//            String updateSql = "UPDATE PhieuDatPhong SET ThoiGianDat = ? WHERE MaPhieuDatPhong = ?";
//            PreparedStatement updateStmt = connection.prepareStatement(updateSql);
//            updateStmt.setTimestamp(1, phieuDatPhong.getThoiGianNhanPhong());
//            updateStmt.setInt(2, phieuDatPhong.getSoLuongNguoi());
//            updateStmt.setTimestamp(3, phieuDatPhong.getThoiGianDat());
//            updateStmt.setString(4, phieuDatPhong.getMaPhieuDatPhong());
//            int rowsUpdated = updateStmt.executeUpdate();
//            if (rowsUpdated > 0) {
//                isSuccess = true;
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return isSuccess;
//    }

    // get theo ma phong va theo trang thai [dang thue, dang dat]
    public itemPhong createItemPhongTheoMaPhong(String maPhong, String trangThai) {
        itemPhong itemphong = null;
        Connection connection = database.getInstance().getConnection();
        try {
            String sql = "select p.MaPhong, kh.HoTen, kh.SDT,p.TrangThai,p.Tang,cthdp.ThoiGianTra, lp.TenLP from PhieuDatPhong pdp\r\n"
            		+ "join ChiTietHoaDonPhong cthdp on pdp.MaPhieuDatPhong = cthdp.MaPhieuDatPhong\r\n"
            		+ "join HoaDon hd on hd.MaPhieuDatPhong = cthdp.MaPhieuDatPhong\r\n"
            		+ "join Phong p on p.MaPhong = cthdp.MaPhong\r\n"
            		+ "join KhachHang kh on kh.MaKH = pdp.MaKH\r\n"
            		+ "join LoaiPhong lp on lp.MaLP = p.MaLP\r\n"
            		+ "where p.TrangThai = ? and p.MaPhong = ?";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, trangThai);
            stmt.setString(2, maPhong);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
            	// 1 maPhong
                String hoTen = rs.getString(2);
                String sdt = rs.getString(3);
                // 4 trangthai
                String tang = rs.getString(5);
    
                String tenLP =rs.getString(7);
                
                String thoiGianTra = rs.getString(6);
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.S");
                LocalDateTime targetTime = LocalDateTime.parse(thoiGianTra, formatter);
                LocalDateTime now = LocalDateTime.now();
                Duration duration = Duration.between(now, targetTime);
                long days = duration.toDays();
                long hours = duration.toHours() % 24;
                long minutes = duration.toMinutes() % 60;
                String thoiGianConLai = days + " Ngày " + hours + " Giờ " + minutes + " Phút "; 
                
                itemphong = new itemPhong(maPhong ,tang,trangThai,hoTen, tenLP, thoiGianConLai);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return itemphong;
    }
}
