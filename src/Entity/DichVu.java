package Entity;

import java.util.Objects;

public class DichVu {
	private String maDV;
	private String tenDV;
	private double donGia;
	private String trangThaiDichVu;
	public DichVu(String maDV, String tenDV, double donGia, String trangThaiDichVu) {
		super();
		this.maDV = maDV;
		this.tenDV = tenDV;
		this.donGia = donGia;
		this.trangThaiDichVu = trangThaiDichVu;
	}
	public DichVu() {
		this("", "", 0.0, "");
	}
	public String getMaDV() {
		return maDV;
	}
	public void setMaDV(String maDV) {
		this.maDV = maDV;
	}
	public String getTenDV() {
		return tenDV;
	}
	public void setTenDV(String tenDV) {
		this.tenDV = tenDV;
	}
	public double getDonGia() {
		return donGia;
	}
	public void setDonGia(double donGia) {
		this.donGia = donGia;
	}
	public String getTrangThaiDichVu() {
		return trangThaiDichVu;
	}
	public void setTrangThaiDichVu(String trangThaiDichVu) {
		this.trangThaiDichVu = trangThaiDichVu;
	}
	public DichVu(String maDV) {
		super();
		this.maDV = maDV;
	}
	@Override
	public int hashCode() {
		return Objects.hash(maDV);
	}
	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DichVu other = (DichVu) obj;
		return Objects.equals(maDV, other.maDV);
	}
	@Override
	public String toString() {
		return "DichVu [maDV=" + maDV + ", tenDV=" + tenDV + ", donGia=" + donGia + "]";
	}
	
	
}
