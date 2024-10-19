package Entity;

import java.util.Objects;

public class Phong {
	private String maPhong;
	private String trangThai;
	private String tang;
	private LoaiPhong loaiPhong;
	
	public String getTang() {
		return tang;
	}
	public void setTang(String tang) {
		this.tang = tang;
	}
	public Phong(String maPhong, String trangThai, String tang, LoaiPhong loaiPhong) {
		super();
		this.maPhong = maPhong;
		this.trangThai = trangThai;
		this.tang = tang;
		this.loaiPhong = loaiPhong;
	}
	public Phong() {
		super();
	}
	public String getMaPhong() {
		return maPhong;
	}
	public void setMaPhong(String maPhong) {
		this.maPhong = maPhong;
	}
	public String getTrangThai() {
		return trangThai;
	}
	public void setTrangThai(String trangThai) {
		this.trangThai = trangThai;
	}
	public LoaiPhong getLoaiPhong() {
		return loaiPhong;
	}
	public void setLoaiPhong(LoaiPhong loaiPhong) {
		this.loaiPhong = loaiPhong;
	}
	public Phong(String maPhong) {
		super();
		this.maPhong = maPhong;
	}
	@Override
	public int hashCode() {
		return Objects.hash(maPhong);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Phong other = (Phong) obj;
		return Objects.equals(maPhong, other.maPhong);
	}
	@Override
	public String toString() {
		return "Phong [maPhong=" + maPhong + ", trangThai=" + trangThai + ", loaiPhong=" + loaiPhong + "]";
	}
	
}
