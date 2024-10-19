package Gui;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import ConnectDB.database;
import Dao.PhieuDatPhong_dao;
import Dao.Phong_dao;
import Entity.PhieuDatPhong;
import Entity.Phong;

import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Home extends JPanel {
    
    private Phong_dao phongDao = new Phong_dao();
    private PhieuDatPhong_dao phieuDatPhongDao = new PhieuDatPhong_dao();
    public Home() {
        
        // Kết nối cơ sở dữ liệu
        try {
            database.getInstance().Connect();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Lỗi database vui lòng kiểm tra lại","Lỗi",JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
        
        setBackground(new Color(255, 255, 255));
        setLayout(new BorderLayout(0, 0));
        
        // Tạo panel cho tiêu đề
        JPanel panel = new JPanel();
        setBorder(new EmptyBorder(20, 20, 20, 20));
        add(panel, BorderLayout.NORTH);
        
        JLabel lblNewLabel = new JLabel("Trang Chủ");
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
        panel.add(lblNewLabel);
        
        // Tạo panel cho điều khiển
        JPanel panel_1 = new JPanel();
        add(panel_1, BorderLayout.CENTER);
        panel_1.setLayout(new BorderLayout(0, 0));
        
        JPanel pnControl = new JPanel();
        pnControl.setBorder(new EmptyBorder(10, 10, 10, 10));
        pnControl.setLayout(new BoxLayout(pnControl, BoxLayout.Y_AXIS));
        panel_1.add(pnControl, BorderLayout.WEST);
        
        // Trạng Thái
        JPanel panel_5 = new JPanel();
        pnControl.add(panel_5);
        panel_5.setLayout(new BoxLayout(panel_5, BoxLayout.Y_AXIS));
        
        JPanel panel_8 = new JPanel();
        panel_5.add(panel_8);
        
        JLabel lblNewLabel_1 = new JLabel("Trạng Thái");
        lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
        panel_8.add(lblNewLabel_1);
        
        JPanel panel_2 = new JPanel();
        panel_5.add(panel_2);
        
        JComboBox<String> cbbTrangThai = new JComboBox<>();
        panel_2.add(cbbTrangThai);
        cbbTrangThai.addItem("Tất Cả");
        cbbTrangThai.addItem("Trống");
        cbbTrangThai.addItem("Đã đặt");
        cbbTrangThai.addItem("Đang Thuê");
        
        // Loại Phòng
        JPanel panel_3 = new JPanel();
        pnControl.add(panel_3);
        panel_3.setLayout(new BoxLayout(panel_3, BoxLayout.Y_AXIS));
        
        JPanel panel_9 = new JPanel();
        panel_3.add(panel_9);
        
        JLabel lblNewLabel_2 = new JLabel("Loại Phòng");
        panel_9.add(lblNewLabel_2);
        lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 15));
        
        JPanel panel_6 = new JPanel();
        panel_3.add(panel_6);
        
        JComboBox<String> cbbLoaiPhong = new JComboBox<>();
        cbbLoaiPhong.addItem("Tất Cả");
        cbbLoaiPhong.addItem("Phòng đơn");
        cbbLoaiPhong.addItem("Phòng đôi");
        cbbLoaiPhong.addItem("Phòng VIP");
        panel_6.add(cbbLoaiPhong);
        
        // Lầu
        JPanel panel_4 = new JPanel();
        pnControl.add(panel_4);
        panel_4.setLayout(new BoxLayout(panel_4, BoxLayout.Y_AXIS));
        
        JPanel panel_10 = new JPanel();
        panel_4.add(panel_10);
        
        JLabel lbLau = new JLabel("Lầu");
        panel_10.add(lbLau);
        lbLau.setFont(new Font("Tahoma", Font.BOLD, 15));
        
        JPanel panel_7 = new JPanel();
        panel_4.add(panel_7);
        
        JComboBox<String> cbbLau = new JComboBox<>();
        cbbLau.addItem("Tất Cả");
        cbbLau.addItem("Lầu 1");
        cbbLau.addItem("Lầu 2");
        cbbLau.addItem("Lầu 3");
        panel_7.add(cbbLau);

        // Thêm các ItemListener cho các JComboBox
        ItemListener comboBoxListener = new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    // Lấy giá trị của tất cả JComboBox
                    String trangThai = (String) cbbTrangThai.getSelectedItem();
                    String loaiPhong = (String) cbbLoaiPhong.getSelectedItem();
                    String lau = (String) cbbLau.getSelectedItem();
                    
                    // In ra giá trị
                    System.out.println("Trạng Thái: " + trangThai);
                    System.out.println("Loại Phòng: " + loaiPhong);
                    System.out.println("Lầu: " + lau);
                    System.out.println("---------------------");
                }
            }
        };

        // Gán listener cho từng JComboBox
        cbbTrangThai.addItemListener(comboBoxListener);
        cbbLoaiPhong.addItemListener(comboBoxListener);
        cbbLau.addItemListener(comboBoxListener);

        // Tạo panel chính
        JPanel main = new JPanel();
        main.setBackground(new Color(255, 255, 255));
        main.setBorder(new LineBorder(new Color(0, 0, 0)));
        panel_1.add(main, BorderLayout.CENTER);
        main.setLayout(new BorderLayout(0, 0));
        
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        
        JPanel itemPanel = new JPanel();
        itemPanel.setBackground(SystemColor.menu);
        
        ArrayList<Phong> dsPhong = phongDao.danhSachPhong();
        int row = dsPhong.size() / 3;
        if (dsPhong.size() % 3 != 0) row += 1;

        dsPhong.forEach(item -> {
            String maPhong = item.getMaPhong();
            String trangThai = item.getTrangThai();
            String tang = item.getTang();
            String loaiPhong = item.getLoaiPhong().getTenLoaiPhong();
            String tenKhachHang = "";
            String thoiGianConLai = "";
            if (item.getTrangThai().equals("Da Dat")) {
                PhieuDatPhong phieuDatPhong = phieuDatPhongDao.getPhieuDatPhongTheoMaPhong(maPhong, "Chua thanh toan");
                tenKhachHang = phieuDatPhong.getKhachHang().getTenKH();
                String targetTimeStr = phieuDatPhong.getThoiGianTraPhong().toString();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.S");
                LocalDateTime targetTime = LocalDateTime.parse(targetTimeStr, formatter);
                LocalDateTime now = LocalDateTime.now();
                Duration duration = Duration.between(now, targetTime);
                long days = duration.toDays();
                long hours = duration.toHours() % 24;
                long minutes = duration.toMinutes() % 60;
                thoiGianConLai = days + " Ngày " + hours + " Giờ " + minutes + " Phút "; 
            } else if (item.getTrangThai().equals("Dang Thue")) {
                PhieuDatPhong phieuDatPhong = phieuDatPhongDao.getPhieuDatPhongTheoMaPhong(maPhong, "Da thanh toan");
                tenKhachHang = phieuDatPhong.getKhachHang().getTenKH();
                String targetTimeStr = phieuDatPhong.getThoiGianTraPhong().toString();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.S");
                LocalDateTime targetTime = LocalDateTime.parse(targetTimeStr, formatter);
                LocalDateTime now = LocalDateTime.now();
                Duration duration = Duration.between(now, targetTime);
                long days = duration.toDays();
                long hours = duration.toHours() % 24;
                long minutes = duration.toMinutes() % 60;
                thoiGianConLai = days + " Ngày " + hours + " Giờ " + minutes + " Phút "; 
            }
            itemPhong itemphong = new itemPhong(maPhong, tang, trangThai, tenKhachHang, loaiPhong, thoiGianConLai);
            itemPanel.add(itemphong);
        });
        
        scrollPane.setViewportView(itemPanel);
        itemPanel.setLayout(new GridLayout(3, row, 10, 10));
        
        main.add(scrollPane, BorderLayout.CENTER);
    }
}
