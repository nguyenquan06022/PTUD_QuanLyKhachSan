package Entity;

import java.security.Timestamp;
import java.util.Objects;

public class ChiTietHoaDonPhong {
	private PhieuDatPhong phieuDatPhong;
	private Phong phong;
	private Timestamp thoiGianNhan;
	private Timestamp thoiGianTra;
	private String cachThue;
	private int soLuongNguoi;
	public PhieuDatPhong getPhieuDatPhong() {
		return phieuDatPhong;
	}
	public void setPhieuDatPhong(PhieuDatPhong phieuDatPhong) {
		this.phieuDatPhong = phieuDatPhong;
	}
	public Phong getPhong() {
		return phong;
	}
	public void setPhong(Phong phong) {
		this.phong = phong;
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
	public String getCachThue() {
		return cachThue;
	}
	public void setCachThue(String cachThue) {
		this.cachThue = cachThue;
	}
	public int getSoLuongNguoi() {
		return soLuongNguoi;
	}
	public void setSoLuongNguoi(int soLuongNguoi) {
		this.soLuongNguoi = soLuongNguoi;
	}
	public ChiTietHoaDonPhong(PhieuDatPhong phieuDatPhong, Phong phong, Timestamp thoiGianNhan, Timestamp thoiGianTra,
			String cachThue, int soLuongNguoi) {
		super();
		this.phieuDatPhong = phieuDatPhong;
		this.phong = phong;
		this.thoiGianNhan = thoiGianNhan;
		this.thoiGianTra = thoiGianTra;
		this.cachThue = cachThue;
		this.soLuongNguoi = soLuongNguoi;
	}
	@Override
	public String toString() {
		return "ChiTietHoaDonPhong [phieuDatPhong=" + phieuDatPhong + ", phong=" + phong + ", thoiGianNhan="
				+ thoiGianNhan + ", thoiGianTra=" + thoiGianTra + ", cachThue=" + cachThue + ", soLuongNguoi="
				+ soLuongNguoi + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(phieuDatPhong);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ChiTietHoaDonPhong other = (ChiTietHoaDonPhong) obj;
		return Objects.equals(phieuDatPhong, other.phieuDatPhong);
	}
}
