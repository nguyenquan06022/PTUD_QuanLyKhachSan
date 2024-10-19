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
('NV001', 'Nguyen Van A', 1, '1990-01-15', '123456789012', '0901234567', 'Quan Ly','Dang lam viec'),
('NV002', 'Tran Thi B', 0, '1992-05-20', '234567890123', '0912345678', 'Le Tan','Dang lam viec');

-- Chèn dữ liệu mẫu vào bảng TaiKhoan
INSERT INTO TaiKhoan (MaTaiKhoan, TenDangNhap, MatKhau, MaNV, TrangThai)
VALUES 
('TK001', 'NV001', 'pass123', 'NV001', 'Dang su dung'),
('TK002', 'NV002', 'pass456', 'NV002', 'Dang su dung');

-- Chèn dữ liệu mẫu vào bảng KhachHang
INSERT INTO KhachHang (MaKH, HoTen, SDT, GioiTinh, QuocTich, DiemKhuyenMai)
VALUES 
('KH001', 'Pham Thanh D', '0931234567', 1, 'Viet Nam', 100),
('KH002', 'Nguyen Thi E', '0941234567', 0, 'Viet Nam', 150);

-- Chèn dữ liệu mẫu vào bảng LoaiPhong
INSERT INTO LoaiPhong (MaLP, TenLP, GiaGioDau, GiaGioTiepTheo, GiaQuaDem, GiaCaNgay)
VALUES 
('LP001', 'Phong don', 200000, 150000, 500000, 800000),
('LP002', 'Phong doi', 300000, 200000, 700000, 1000000);

-- Chèn dữ liệu mẫu vào bảng Phong
INSERT INTO Phong (MaPhong, TrangThai, Tang, MaLP)
VALUES 
('P101', 'Trong', 'Tang 1', 'LP001'),
('P102', 'Trong', 'Tang 1', 'LP001'),
('P201', 'Trong', 'Tang 2', 'LP002'),
('P202', 'Da Dat', 'Tang 2', 'LP002');

-- Chèn dữ liệu mẫu vào bảng DichVu
INSERT INTO DichVu (MaDichVu, TenDichVu, DonGia, TrangThai)
VALUES 
('DV001', 'Nuoc ngot', 20000, 'Dang su dung'),
('DV002', 'Mi goi', 15000, 'Dang su dung'),
('DV003', 'Bia', 30000, 'Dang su dung');

-- Mã hóa mã phiếu đặt phòng theo kiểu DP + ngày tháng năm giờ phút giây
INSERT INTO PhieuDatPhong (MaPhieuDatPhong, ThoiGianNhanPhong, ThoiGianTra, SoluongNguoi, ThoiGianDat, MaKH, MaNV)
VALUES 
('DP20240920100000', '2024-09-25 14:00:00', '2024-09-26 12:00:00', 3, '2024-09-20 10:00:00', 'KH001', 'NV002'),
('DP20241211140000', '2024-12-12 14:00:00', '2024-12-16 14:00:00', 1, '2024-12-11 14:00:00', 'KH002', 'NV002');

-- Mã hóa mã hóa đơn theo kiểu HD + ngày tháng năm giờ phút giây
INSERT INTO HoaDon (MaHoaDon, ThoiGianNhan, ThoiGianTra, NgayLapHoaDon, MaPhieuDatPhong, MaNV, MaKH, TrangThai)
VALUES 
('HD20240920100000', '2024-09-25 14:00:00', '2024-09-26 12:00:00', '2024-09-26 12:00:00', 'DP20240920100000', 'NV002', 'KH001', 'Da thanh toan'),
('HD20241211140000', '2024-12-12 14:00:00', '2024-12-16 14:00:00', null, 'DP20241211140000', 'NV002', 'KH002', 'Chua thanh toan');

-- Chèn dữ liệu vào bảng ChiTietHoaDonPhong (Liên kết hóa đơn với nhiều phòng)
INSERT INTO ChiTietHoaDonPhong (MaPhieuDatPhong, MaPhong)
VALUES 
('DP20240920100000', 'P101'),
('DP20240920100000', 'P102'),
('DP20240920100000', 'P201'),
('DP20241211140000', 'P202');

SELECT * FROM HoaDon
