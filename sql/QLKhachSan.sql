USE MASTER
GO
DROP DATABASE QuanLyKhachSan
CREATE DATABASE QuanLyKhachSan
GO
USE QuanLyKhachSan

CREATE TABLE NhanVien (
	MaNV NVARCHAR(8),
	HoTen NVARCHAR(100),
	GioiTinh INT,
	NgaySinh DATE,
	CCCD NVARCHAR(12),
	SDT NVARCHAR(10),
	ChucVu NVARCHAR(50),
	TrangThaiLamViec NVARCHAR(30),
	PRIMARY KEY (MaNV)
)

CREATE TABLE TaiKhoan (
	MaTaiKhoan NVARCHAR(8),
	TenDangNhap NVARCHAR(8),
	MatKhau NVARCHAR(25),
	MaNV NVARCHAR(8),
	TrangThai NVARCHAR(30),
	PRIMARY KEY (MaTaiKhoan),
	FOREIGN KEY (MaNV) REFERENCES NhanVien (MaNV)
)

CREATE TABLE KhachHang (
	MaKH NVARCHAR(10),
	HoTen NVARCHAR(100),
	SDT NVARCHAR(10),
	GioiTinh INT,
	QuocTich NVARCHAR(50),
	DiemKhuyenMai INT,
	PRIMARY KEY (MaKH)
)

CREATE TABLE LoaiPhong (
	MaLP NVARCHAR(20),
	TenLP NVARCHAR(50),
	GiaGioDau MONEY,
	GiaGioTiepTheo MONEY,
	GiaQuaDem MONEY,
	GiaCaNgay MONEY,
	PRIMARY KEY (MaLP)
)

CREATE TABLE Phong (
	MaPhong NVARCHAR(4),
	TrangThai NVARCHAR(30),
	Tang NVARCHAR(20),
	MaLP NVARCHAR(20),
	PRIMARY KEY (MaPhong),
	FOREIGN KEY (MaLP) REFERENCES LoaiPhong (MaLP)
)

CREATE TABLE DichVu (
	MaDichVu NVARCHAR(6),
	TenDichVu NVARCHAR(50),
	DonGia Money,
	TrangThai NVARCHAR(30),
	PRIMARY KEY (MaDichVu)
)

CREATE TABLE PhieuDatPhong (
	MaPhieuDatPhong NVARCHAR(16),
	ThoiGianNhanPhong DATETIME,
	SoluongNguoi INT,
	ThoiGianDat DATETIME,
	ThoiGianTra DATETIME,
	MaKH NVARCHAR(10),
	MaNV NVARCHAR(8),
	PRIMARY KEY (MaPhieuDatPhong),
	FOREIGN KEY (MaKH) REFERENCES KhachHang(MaKH),
	FOREIGN KEY (MaNV) REFERENCES NhanVien(MaNV)
)

CREATE TABLE ChiTietHoaDonPhong (
	MaPhieuDatPhong NVARCHAR(16),
	MaPhong NVARCHAR(4),
	PRIMARY KEY (MaPhieuDatPhong, MaPhong),
	FOREIGN KEY (MaPhieuDatPhong) REFERENCES PhieuDatPhong (MaPhieuDatPhong),
	FOREIGN KEY (MaPhong) REFERENCES Phong (MaPhong)
)

CREATE TABLE HoaDon (
	MaHoaDon NVARCHAR(16),
	ThoiGianNhan DATETIME,
	ThoiGianTra DATETIME,
	NgayLapHoaDon DATETIME,
	MaPhieuDatPhong NVARCHAR(16),
	MaNV NVARCHAR(8),
	MaKH NVARCHAR(10),
	TrangThai NVARCHAR(20),
	PRIMARY KEY (MaHoaDon),
	FOREIGN KEY (MaPhieuDatPhong) REFERENCES PhieuDatPhong (MaPhieuDatPhong),
	FOREIGN KEY (MaNV) REFERENCES NhanVien (MaNV),
	FOREIGN KEY (MaKH) REFERENCES KhachHang (MaKH)
)

CREATE TABLE ChiTietHoaDonDichVu (
	MaHoaDon NVARCHAR(16),
	MaDichVu NVARCHAR(6),
	SoLuong INT,
	PRIMARY KEY (MaHoaDon, MaDichVu),
	FOREIGN KEY (MaDichVu) REFERENCES DichVu (MaDichVu),
	FOREIGN KEY (MaHoaDon) REFERENCES HoaDon (MaHoaDon)
)

-- Chèn dữ liệu mẫu vào bảng NhanVien
INSERT INTO NhanVien (MaNV, HoTen, GioiTinh, NgaySinh, CCCD, SDT, ChucVu, TrangThaiLamViec)
VALUES 
('NV001', N'Nguyễn Văn A', 1, '1990-01-15', '123456789012', '0901234567', N'Quản Lý','Đang làm việc'),
('NV002', N'Trần Thị B', 0, '1992-05-20', '234567890123', '0912345678', N'Lễ Tân','Đang làm việc');

-- Chèn dữ liệu mẫu vào bảng TaiKhoan
INSERT INTO TaiKhoan (MaTaiKhoan, TenDangNhap, MatKhau, MaNV, TrangThai)
VALUES 
('TK001', 'NV001', 'pass123', 'NV001', N'Đang sử dụng'),
('TK002', 'NV002', 'pass456', 'NV002', N'Đang sử dụng');

-- Chèn dữ liệu mẫu vào bảng KhachHang
INSERT INTO KhachHang (MaKH, HoTen, SDT, GioiTinh, QuocTich, DiemKhuyenMai)
VALUES 
('KH001', N'Phạm Thành D', '0931234567', 1, N'Việt Nam', 100),
('KH002', N'Nguyễn Thị E', '0941234567', 0, N'Việt Nam', 150);

-- Chèn dữ liệu mẫu vào bảng LoaiPhong
INSERT INTO LoaiPhong (MaLP, TenLP, GiaGioDau, GiaGioTiepTheo, GiaQuaDem, GiaCaNgay)
VALUES 
('LP001', N'Phòng đơn', 200000, 150000, 500000, 800000),
('LP002', N'Phòng đôi', 300000, 200000, 700000, 1000000);

-- Chèn dữ liệu mẫu vào bảng Phong
INSERT INTO Phong (MaPhong, TrangThai, Tang, MaLP)
VALUES 
('P101', N'Trống', N'Tầng 1', 'LP001'),
('P102', N'Trống', N'Tầng 1', 'LP001'),
('P201', N'Trống', N'Tầng 2', 'LP002'),
('P202', N'Đã đặt', N'Tầng 2', 'LP002');

-- Chèn dữ liệu mẫu vào bảng DichVu
INSERT INTO DichVu (MaDichVu, TenDichVu, DonGia, TrangThai)
VALUES 
('DV001', N'Nước ngọt', 20000, N'Đang sử dụng'),
('DV002', N'Mì gói', 15000, N'Đang sử dụng'),
('DV003', N'Bia', 30000, N'Đang sử dụng');

-- Mã hóa mã phiếu đặt phòng theo kiểu DP + ngày tháng năm giờ phút giây
INSERT INTO PhieuDatPhong (MaPhieuDatPhong, ThoiGianNhanPhong, ThoiGianTra, SoluongNguoi, ThoiGianDat, MaKH, MaNV)
VALUES 
('DP20240920100000', '2024-09-25 14:00:00', '2024-09-26 12:00:00', 3, '2024-09-20 10:00:00', 'KH001', 'NV002'),
('DP20241211140000', '2024-12-12 14:00:00', '2024-12-16 14:00:00', 1, '2024-12-11 14:00:00', 'KH002', 'NV002');

-- Mã hóa mã hóa đơn theo kiểu HD + ngày tháng năm giờ phút giây
INSERT INTO HoaDon (MaHoaDon, ThoiGianNhan, ThoiGianTra, NgayLapHoaDon, MaPhieuDatPhong, MaNV, MaKH, TrangThai)
VALUES 
('HD20240920100000', '2024-09-25 14:00:00', '2024-09-26 12:00:00', '2024-09-26 12:00:00', 'DP20240920100000', 'NV002', 'KH001', N'Đã thanh toán'),
('HD20241211140000', '2024-12-12 14:00:00', '2024-12-16 14:00:00', null, 'DP20241211140000', 'NV002', 'KH002', N'Chưa thanh toán');

-- Chèn dữ liệu vào bảng ChiTietHoaDonPhong (Liên kết hóa đơn với nhiều phòng)
INSERT INTO ChiTietHoaDonPhong (MaPhieuDatPhong, MaPhong)
VALUES 
('DP20240920100000', 'P101'),
('DP20240920100000', 'P102'),
('DP20240920100000', 'P201'),
('DP20241211140000', 'P202');

SELECT * FROM HoaDon
