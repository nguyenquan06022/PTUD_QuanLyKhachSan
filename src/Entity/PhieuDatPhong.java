package Entity;

import java.sql.Timestamp;
import java.util.Objects;

public class PhieuDatPhong {
	private String maPhieuDatPhong;
	private Timestamp thoiGianNhanPhong;
	private int soLuongNguoi;
	private Timestamp thoiGianDat;
	private NhanVien nhanVien;
	private KhachHang khachHang;
	private Timestamp thoiGianTraPhong;
	
	public PhieuDatPhong(String maPhieuDatPhong, Timestamp thoiGianNhanPhong, int soLuongNguoi, Timestamp thoiGianDatPhong,
			NhanVien nhanVien, KhachHang khachHang, Timestamp thoiGianTraPhong) {
		super();
		this.maPhieuDatPhong = maPhieuDatPhong;
		this.thoiGianNhanPhong = thoiGianNhanPhong;
		this.soLuongNguoi = soLuongNguoi;
		this.thoiGianDat = thoiGianDatPhong;
		this.nhanVien = nhanVien;
		this.khachHang = khachHang;
		this.thoiGianTraPhong = thoiGianTraPhong;
	}
	public Timestamp getThoiGianTraPhong() {
		return thoiGianTraPhong;
	}
	public void setThoiGianTraPhong(Timestamp thoiGianTraPhong) {
		this.thoiGianTraPhong = thoiGianTraPhong;
	}
	public PhieuDatPhong() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getMaPhieuDatPhong() {
		return maPhieuDatPhong;
	}
	public void setMaPhieuDatPhong(String maPhieuDatPhong) {
		this.maPhieuDatPhong = maPhieuDatPhong;
	}
	public Timestamp getThoiGianNhanPhong() {
		return thoiGianNhanPhong;
	}
	public void setThoiGianNhanPhong(Timestamp thoiGianNhanPhong) {
		this.thoiGianNhanPhong = thoiGianNhanPhong;
	}
	public int getSoLuongNguoi() {
		return soLuongNguoi;
	}
	public void setSoLuongNguoi(int soLuongNguoi) {
		this.soLuongNguoi = soLuongNguoi;
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
	public PhieuDatPhong(String maPhieuDatPhong) {
		super();
		this.maPhieuDatPhong = maPhieuDatPhong;
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
		return "PhieuDatPhong [maPhieuDatPhong=" + maPhieuDatPhong + ", thoiGianNhanPhong=" + thoiGianNhanPhong
				+ ", soLuongNguoi=" + soLuongNguoi + ", thoiGianDat=" + thoiGianDat + ", nhanVien=" + nhanVien
				+ ", khachHang=" + khachHang + ", thoiGianTraPhong=" + thoiGianTraPhong + "]";
	}
	
}
