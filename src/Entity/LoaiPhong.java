package Entity;

import java.util.Objects;

public class LoaiPhong {
	private String maLoaiPhong;
	private String tenLoaiPhong;
	private double giaGioDau;
	private double giaGioTiepTheo;
	private double giaQuaDem;
	private double giaCaNgay;
	public LoaiPhong(String maLoaiPhong, String tenLoaiPhong, double giaGioDau, double giaGioTiepTheo, double giaQuaDem,
			double giaCaNgay) {
		super();
		this.maLoaiPhong = maLoaiPhong;
		this.tenLoaiPhong = tenLoaiPhong;
		this.giaGioDau = giaGioDau;
		this.giaGioTiepTheo = giaGioTiepTheo;
		this.giaQuaDem = giaQuaDem;
		this.giaCaNgay = giaCaNgay;
	}
	public LoaiPhong() {
		this("", "", 0.0, 0.0, 0.0, 0.0);
	}
	public String getMaLoaiPhong() {
		return maLoaiPhong;
	}
	public void setMaLoaiPhong(String maLoaiPhong) {
		this.maLoaiPhong = maLoaiPhong;
	}
	public String getTenLoaiPhong() {
		return tenLoaiPhong;
	}
	public void setTenLoaiPhong(String tenLoaiPhong) {
		this.tenLoaiPhong = tenLoaiPhong;
	}
	public double getGiaGioDau() {
		return giaGioDau;
	}
	public void setGiaGioDau(double giaGioDau) {
		this.giaGioDau = giaGioDau;
	}
	public double getGiaGioTiepTheo() {
		return giaGioTiepTheo;
	}
	public void setGiaGioTiepTheo(double giaGioTiepTheo) {
		this.giaGioTiepTheo = giaGioTiepTheo;
	}
	public double getGiaQuaDem() {
		return giaQuaDem;
	}
	public void setGiaQuaDem(double giaQuaDem) {
		this.giaQuaDem = giaQuaDem;
	}
	public double getGiaCaNgay() {
		return giaCaNgay;
	}
	public void setGiaCaNgay(double giaCaNgay) {
		this.giaCaNgay = giaCaNgay;
	}
	
	public LoaiPhong(String maLoaiPhong) {
		super();
		this.maLoaiPhong = maLoaiPhong;
	}
	@Override
	public int hashCode() {
		return Objects.hash(maLoaiPhong);
	}
	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LoaiPhong other = (LoaiPhong) obj;
		return Objects.equals(maLoaiPhong, other.maLoaiPhong);
	}
	@Override
	public String toString() {
		return "LoaiPhong [maLoaiPhong=" + maLoaiPhong + ", tenLoaiPhong=" + tenLoaiPhong + ", giaGioDau=" + giaGioDau
				+ ", giaGioTiepTheo=" + giaGioTiepTheo + ", giaQuaDem=" + giaQuaDem + ", giaCaNgay=" + giaCaNgay + "]";
	}
	
	
}
