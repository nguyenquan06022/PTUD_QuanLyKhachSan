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
import Entity.KhachHang;
import Entity.NhanVien;
import Entity.PhieuDatPhong;

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
            String sql = "Select MaPhieuDatPhong,ThoiGianNhanPhong,SoluongNguoi,ThoiGianDat,MaKH,MaNV,ThoiGianTra from PhieuDatPhong";
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                String maPDP = rs.getString(1);
                Timestamp thoiGianNhan = rs.getTimestamp(2);
                int soLuongNguoi = rs.getInt(3);
                Timestamp thoiGianDat = rs.getTimestamp(4);
                KhachHang khachHang = khachHang_dao.timKhachHangTheoMa(rs.getString(5));
                NhanVien nhanVien = nhanVien_dao.getNhanVienTheoMa(rs.getString(6));
                Timestamp thoiGianTra = rs.getTimestamp(7);
                PhieuDatPhong phieuDatPhong = new PhieuDatPhong(maPDP, thoiGianNhan, soLuongNguoi, thoiGianDat, nhanVien, khachHang,thoiGianTra);
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
            String sql = "INSERT INTO PhieuDatPhong (MaPhieuDatPhong, ThoiGianNhanPhong, SoluongNguoi, ThoiGianDat, MaKH, MaNV) VALUES (?, ?, ?, ?, ?, ?)";
            stmt = con.prepareStatement(sql);
            stmt.setString(1, maPhieuDatPhong);
            stmt.setTimestamp(2, phieuDatPhong.getThoiGianNhanPhong());
            stmt.setInt(3, phieuDatPhong.getSoLuongNguoi());
            stmt.setTimestamp(4, phieuDatPhong.getThoiGianDat());
            stmt.setString(5, phieuDatPhong.getKhachHang().getMaKH());
            stmt.setString(6, phieuDatPhong.getNhanVien().getMaNV());
            int rowsInserted = stmt.executeUpdate();
            if (rowsInserted > 0) {
                isSuccess = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isSuccess;
    }

    public boolean suaPhieuDatPhong(PhieuDatPhong phieuDatPhong) {
        khoiTao();
        Connection connection = database.getInstance().getConnection();
        boolean isSuccess = false;
        try {
            String updateSql = "UPDATE PhieuDatPhong SET ThoiGianNhanPhong = ?, SoluongNguoi = ?, ThoiGianDat = ? WHERE MaPhieuDatPhong = ?";
            PreparedStatement updateStmt = connection.prepareStatement(updateSql);
            updateStmt.setTimestamp(1, phieuDatPhong.getThoiGianNhanPhong());
            updateStmt.setInt(2, phieuDatPhong.getSoLuongNguoi());
            updateStmt.setTimestamp(3, phieuDatPhong.getThoiGianDat());
            updateStmt.setString(4, phieuDatPhong.getMaPhieuDatPhong());
            int rowsUpdated = updateStmt.executeUpdate();
            if (rowsUpdated > 0) {
                isSuccess = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isSuccess;
    }

    // get theo ma phong va theo trang thai [dang thue, dang dat]
    public PhieuDatPhong getPhieuDatPhongTheoMaPhong(String maPhong, String trangThai) {
        PhieuDatPhong phieuDatPhong = null;
        Connection connection = database.getInstance().getConnection();
        try {
            String sql = "SELECT pdp.MaPhieuDatPhong, ThoiGianNhan, SoluongNguoi, ThoiGianDat, pdp.ThoiGianTra, pdp.MaNV, pdp.MaKH "
                       + "FROM PhieuDatPhong pdp "
                       + "JOIN HoaDon hd ON pdp.MaPhieuDatPhong = hd.MaPhieuDatPhong "
                       + "JOIN ChiTietHoaDonPhong cthdp ON cthdp.MaPhieuDatPhong = pdp.MaPhieuDatPhong "
                       + "WHERE hd.TrangThai = ? AND cthdp.MaPhong = ?";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, trangThai);
            stmt.setString(2, maPhong);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                String maPhieuDatPhong = rs.getString(1);
                Timestamp thoiGianNhan = rs.getTimestamp(2);
                int soLuongNguoi = rs.getInt(3);
                Timestamp thoiGianDat = rs.getTimestamp(4);
                Timestamp thoiGianTra = rs.getTimestamp(5);
                String maNV = rs.getString(6);
                String maKH = rs.getString(7);

                // Tạo đối tượng PhieuDatPhong với các giá trị đã lấy
                phieuDatPhong = new PhieuDatPhong(maPhieuDatPhong, thoiGianNhan, soLuongNguoi, thoiGianDat,
                        new NhanVien_dao().getNhanVienTheoMa(maNV), new KhachHang_dao().timKhachHangTheoMa(maKH), thoiGianTra);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return phieuDatPhong;
    }
}
