package Entity;

import java.sql.Timestamp;
import java.util.Objects;

public class PhieuDatPhong {
	private String maPhieuDatPhong;
	private Timestamp thoiGianDat;
	private NhanVien nhanVien;
	private KhachHang khachHang;
	public String getMaPhieuDatPhong() {
		return maPhieuDatPhong;
	}
	public void setMaPhieuDatPhong(String maPhieuDatPhong) {
		this.maPhieuDatPhong = maPhieuDatPhong;
	}
	public Timestamp getThoiGianDat() {
		return thoiGianDat;
	}
	public void setThoiGianDat(Timestamp thoiGianDat) {
		this.thoiGianDat = thoiGianDat;
	}
	public NhanVien getNhanVien() {
		return nhanVien;
	}
	public void setNhanVien(NhanVien nhanVien) {
		this.nhanVien = nhanVien;
	}
	public KhachHang getKhachHang() {
		return khachHang;
	}
	public void setKhachHang(KhachHang khachHang) {
		this.khachHang = khachHang;
	}
	public PhieuDatPhong(String maPhieuDatPhong, Timestamp thoiGianDat, NhanVien nhanVien, KhachHang khachHang) {
		super();
		this.maPhieuDatPhong = maPhieuDatPhong;
		this.thoiGianDat = thoiGianDat;
		this.nhanVien = nhanVien;
		this.khachHang = khachHang;
	}
	@Override
	public int hashCode() {
		return Objects.hash(maPhieuDatPhong);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PhieuDatPhong other = (PhieuDatPhong) obj;
		return Objects.equals(maPhieuDatPhong, other.maPhieuDatPhong);
	}
	@Override
	public String toString() {
		return "PhieuDatPhong [maPhieuDatPhong=" + maPhieuDatPhong + ", thoiGianDat=" + thoiGianDat + ", nhanVien="
				+ nhanVien + ", khachHang=" + khachHang + "]";
	}
}
