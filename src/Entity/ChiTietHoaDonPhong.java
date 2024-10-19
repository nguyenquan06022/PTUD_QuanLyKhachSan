package Entity;

public class ChiTietHoaDonPhong {
	private Phong phong;
	private PhieuDatPhong phieuDatPhong;
	
	public ChiTietHoaDonPhong() {
		super();
	}
	public ChiTietHoaDonPhong(Phong phong, PhieuDatPhong phieuDatPhong) {
		super();
		this.phong = phong;
		this.phieuDatPhong = phieuDatPhong;
	}
	public Phong getPhong() {
		return phong;
	}
	public void setPhong(Phong phong) {
		this.phong = phong;
	}
	public PhieuDatPhong getPhieuDatPhong() {
		return phieuDatPhong;
	}
	public void setPhieuDatPhong(PhieuDatPhong phieuDatPhong) {
		this.phieuDatPhong = phieuDatPhong;
	}
	@Override
	public String toString() {
		return "ChiTietHoaDonPhong [phong=" + phong + ", phieuDatPhong=" + phieuDatPhong + "]";
	}
	
	
}
