package Entity;

import java.sql.Timestamp;
import java.util.Objects;

public class HoaDon {
	private String maHD;
	private Timestamp thoiGianNhan;
	private Timestamp thoiGianTra;
	private Timestamp ngayLapHD;
	private NhanVien nhanVien;
	private KhachHang khachHang;
	private PhieuDatPhong phieuDatPhong;
	private String trangThai;
	public HoaDon(String maHD, Timestamp thoiGianNhan, Timestamp thoiGianTra, Timestamp ngayLapHD, NhanVien nhanVien,
			KhachHang khachHang, PhieuDatPhong phieuDatPhong, String trangThai) {
		super();
		this.maHD = maHD;
		this.thoiGianNhan = thoiGianNhan;
		this.thoiGianTra = thoiGianTra;
		this.ngayLapHD = ngayLapHD;
		this.nhanVien = nhanVien;
		this.khachHang = khachHang;
		this.phieuDatPhong = phieuDatPhong;
		this.trangThai = trangThai;
	}
	public String getTrangThai() {
		return trangThai;
	}
	public void setTrangThai(String trangThai) {
		this.trangThai = trangThai;
	}
	public HoaDon(String maHD, Timestamp thoiGianNhan, Timestamp thoiGianTra, Timestamp ngayLapHD, NhanVien nhanVien,
			KhachHang khachHang, PhieuDatPhong phieuDatPhong) {
		super();
		this.maHD = maHD;
		this.thoiGianNhan = thoiGianNhan;
		this.thoiGianTra = thoiGianTra;
		this.ngayLapHD = ngayLapHD;
		this.nhanVien = nhanVien;
		this.khachHang = khachHang;
		this.phieuDatPhong = phieuDatPhong;
	}
	public HoaDon() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getMaHD() {
		return maHD;
	}
	public void setMaHD(String maHD) {
		this.maHD = maHD;
	}
	public Timestamp getThoiGianNhan() {
		return thoiGianNhan;
	}
	public void setThoiGianNhan(Timestamp thoiGianNhan) {
		this.thoiGianNhan = thoiGianNhan;
	}
	public Timestamp getThoiGianTra() {
		return thoiGianTra;
	}
	public void setThoiGianTra(Timestamp thoiGianTra) {
		this.thoiGianTra = thoiGianTra;
	}
	public Timestamp getNgayLapHD() {
		return ngayLapHD;
	}
	public void setNgayLapHD(Timestamp ngayLapHD) {
		this.ngayLapHD = ngayLapHD;
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
	public PhieuDatPhong getPhieuDatPhong() {
		return phieuDatPhong;
	}
	public void setPhieuDatPhong(PhieuDatPhong phieuDatPhong) {
		this.phieuDatPhong = phieuDatPhong;
	}
	public HoaDon(String maHD) {
		super();
		this.maHD = maHD;
	}
	@Override
	public int hashCode() {
		return Objects.hash(maHD);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		HoaDon other = (HoaDon) obj;
		return Objects.equals(maHD, other.maHD);
	}
	@Override
	public String toString() {
		return "HoaDon [maHD=" + maHD + ", thoiGianNhan=" + thoiGianNhan + ", thoiGianTra=" + thoiGianTra
				+ ", ngayLapHD=" + ngayLapHD + ", nhanVien=" + nhanVien + ", khachHang=" + khachHang
				+ ", phieuDatPhong=" + phieuDatPhong + ", trangThai=" + trangThai + "]";
	}
	
}
