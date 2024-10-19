package Entity;

public class ChiTietHoaDonDichVu {
	private int soLuong;
	private DichVu dichVu;
	private HoaDon hoaDon;
	public ChiTietHoaDonDichVu(int soLuong, DichVu dichVu, HoaDon hoaDon) {
		super();
		this.soLuong = soLuong;
		this.dichVu = dichVu;
		this.hoaDon = hoaDon;
	}
	public ChiTietHoaDonDichVu() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getSoLuong() {
		return soLuong;
	}
	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}
	public DichVu getDichVu() {
		return dichVu;
	}
	public void setDichVu(DichVu dichVu) {
		this.dichVu = dichVu;
	}
	public HoaDon getHoaDon() {
		return hoaDon;
	}
	public void setHoaDon(HoaDon hoaDon) {
		this.hoaDon = hoaDon;
	}
	@Override
	public String toString() {
		return "ChiTietHoaDonDichVu [soLuong=" + soLuong + ", dichVu=" + dichVu + ", hoaDon=" + hoaDon + "]";
	}
	
}
