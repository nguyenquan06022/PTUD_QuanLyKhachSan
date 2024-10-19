package Gui;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;
import java.awt.geom.RoundRectangle2D;

public class itemPhong extends RoundedPanel{
    public itemPhong(String maPhong ,String tang, String trangThai, String tenKhachHang, String loaiPhong, String thoiGianConLai) {
    	
        super(30);
    	Color colortext = Color.black;
        Color colorbg = SystemColor.activeCaptionBorder;
        if(trangThai.equals("Đã đặt")) {
        	colortext = Color.white;
            colorbg = new Color(0, 153, 255);
        }else if(trangThai.equals("Đang thuê")) {
        	colortext = Color.black;
            colorbg = new Color(153, 255, 153);
        }
        
        setBorder(new EmptyBorder(10, 10, 10, 10));
        setBackground(colorbg);

        setLayout(new BorderLayout(0, 0));
        setBackground(colorbg);
        JPanel panel = new JPanel();
        panel.setBackground(colorbg);
        add(panel, BorderLayout.NORTH);
        panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
        
        JPanel panel_3 = new JPanel();
        panel_3.setBackground(colorbg);
        panel.add(panel_3);

        JLabel lbMaPhong = new JLabel(tang + " - " + maPhong);
        lbMaPhong.setForeground(colortext);
        lbMaPhong.setFont(new Font("Tahoma", Font.BOLD, 15));
        panel_3.add(lbMaPhong);
        
        JPanel panel_4 = new JPanel();
        panel_4.setBackground(colorbg);
        panel.add(panel_4);
        
        JLabel lbTrangThai = new JLabel(trangThai);
        lbTrangThai.setForeground(colortext);
        lbTrangThai.setFont(new Font("Tahoma", Font.BOLD, 15));
        panel_4.add(lbTrangThai);
        
        JPanel panel_1 = new JPanel();
        panel_1.setBackground(colorbg);
        add(panel_1, BorderLayout.CENTER);
        panel_1.setLayout(new BoxLayout(panel_1, BoxLayout.X_AXIS));
        
        JPanel panel_5 = new JPanel();
        panel_5.setBackground(colorbg);
        panel_1.add(panel_5);
        panel_5.setLayout(new BorderLayout(0, 0));
        
        JLabel lbIcon = new JLabel("");
        lbIcon.setForeground(colortext);
        lbIcon.setHorizontalAlignment(SwingConstants.CENTER);
        lbIcon.setIcon(new ImageIcon(itemPhong.class.getResource("/Photos/user.png")));
        lbIcon.setFont(new Font("Tahoma", Font.BOLD, 15));
        panel_5.add(lbIcon);
        
        JPanel panel_6 = new JPanel();
        panel_6.setBackground(colorbg);
        panel_1.add(panel_6);
        panel_6.setLayout(new BorderLayout(0, 0));
        
        JLabel lbName = new JLabel(tenKhachHang);
        lbName.setForeground(colortext);
        lbName.setHorizontalAlignment(SwingConstants.CENTER);
        lbName.setFont(new Font("Tahoma", Font.BOLD, 15));
        panel_6.add(lbName);
        
        JPanel panel_2 = new JPanel();
        panel_2.setBackground(colorbg);
        add(panel_2, BorderLayout.SOUTH);
        panel_2.setLayout(new BoxLayout(panel_2, BoxLayout.X_AXIS));
        
        JPanel panel_7 = new JPanel();
        panel_7.setBackground(colorbg);
        panel_2.add(panel_7);
        
        JLabel lbLoaiPhong = new JLabel(loaiPhong);
        lbLoaiPhong.setForeground(colortext);
        lbLoaiPhong.setFont(new Font("Tahoma", Font.BOLD, 15));
        panel_7.add(lbLoaiPhong);
        
        JPanel panel_8 = new JPanel();
        panel_8.setBackground(colorbg);
        panel_2.add(panel_8);
        
        JLabel lbRemain = new JLabel(thoiGianConLai);
        lbRemain.setForeground(colortext);
        lbRemain.setFont(new Font("Tahoma", Font.BOLD, 15));
        panel_8.add(lbRemain);
    }
}
