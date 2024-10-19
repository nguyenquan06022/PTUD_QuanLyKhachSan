package Entity;

import java.util.Objects;

public class TaiKhoan {
	private String maTK;
	private String tenDN;
	private String matKhau;
	private NhanVien nhanVien;
	private String trangThai;
	public TaiKhoan(String maTK, String tenDN, String matKhau, NhanVien nhanVien, String trangThai) {
		super();
		this.maTK = maTK;
		this.tenDN = tenDN;
		this.matKhau = matKhau;
		this.nhanVien = nhanVien;
		this.trangThai = trangThai;
	}
	public TaiKhoan() {
		super();
	}
	public String getMaTK() {
		return maTK;
	}
	public void setMaTK(String maTK) {
		this.maTK = maTK;
	}
	public String getTenDN() {
		return tenDN;
	}
	public void setTenDN(String tenDN) {
		this.tenDN = tenDN;
	}
	public String getMatKhau() {
		return matKhau;
	}
	public void setMatKhau(String matKhau) {
		this.matKhau = matKhau;
	}
	public NhanVien getNhanVien() {
		return nhanVien;
	}
	public void setNhanVien(NhanVien nhanVien) {
		this.nhanVien = nhanVien;
	}
	
	public String getTrangThai() {
		return trangThai;
	}
	public void setTrangThai(String trangThai) {
		this.trangThai = trangThai;
	}
	public TaiKhoan(String maTK) {
		super();
		this.maTK = maTK;
	}
	@Override
	public int hashCode() {
		return Objects.hash(maTK);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TaiKhoan other = (TaiKhoan) obj;
		return Objects.equals(maTK, other.maTK);
	}
	@Override
	public String toString() {
		return "TaiKhoan [maTK=" + maTK + ", tenDN=" + tenDN + ", matKhau=" + matKhau + ", nhanVien=" + nhanVien
				+ ", trangThai=" + trangThai + "]";
	}
	
}
