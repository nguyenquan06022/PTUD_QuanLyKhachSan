package Entity;

import java.util.Objects;

public class KhachHang {
	private String maKH;
	private String tenKH;
	private String soDT;
	private int gioiTinh;
	private String quocTich;
	private long diemKM;
	public KhachHang(String maKH, String tenKH, String soDT, int gioiTinh, String quocTich, long diemKM) {
		super();
		this.maKH = maKH;
		this.tenKH = tenKH;
		this.soDT = soDT;
		this.gioiTinh = gioiTinh;
		this.quocTich = quocTich;
		this.diemKM = diemKM;
	}
	public KhachHang() {
		this("", "", "", 0, "", 0);
	}
	public String getMaKH() {
		return maKH;
	}
	public void setMaKH(String maKH) {
		this.maKH = maKH;
	}
	public String getTenKH() {
		return tenKH;
	}
	public void setTenKH(String tenKH) {
		this.tenKH = tenKH;
	}
	public String getSoDT() {
		return soDT;
	}
	public void setSoDT(String soDT) {
		this.soDT = soDT;
	}
	public int getGioiTinh() {
		return gioiTinh;
	}
	public void setGioiTinh(int gioiTinh) {
		this.gioiTinh = gioiTinh;
	}
	public String getQuocTich() {
		return quocTich;
	}
	public void setQuocTich(String quocTich) {
		this.quocTich = quocTich;
	}
	public long getDiemKM() {
		return diemKM;
	}
	public void setDiemKM(long diemKM) {
		this.diemKM = diemKM;
	}
	public KhachHang(String maKH) {
		super();
		this.maKH = maKH;
	}
	@Override
	public int hashCode() {
		return Objects.hash(maKH);
	}
	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		KhachHang other = (KhachHang) obj;
		return Objects.equals(maKH, other.maKH);
	}
	@Override
	public String toString() {
		return "KhachHang [maKH=" + maKH + ", tenKH=" + tenKH + ", soDT=" + soDT + ", gioiTinh=" + gioiTinh
				+ ", quocTich=" + quocTich + ", diemKM=" + diemKM + "]";
	}
	
	
}
