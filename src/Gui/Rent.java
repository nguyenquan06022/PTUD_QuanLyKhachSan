package Gui;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.BorderFactory;
import javax.swing.Box;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.Dimension;
import javax.swing.JScrollPane;
import javax.swing.border.LineBorder;

public class Rent extends JPanel implements ActionListener{
    private JTextField tfHoTen;
    private JTextField tfSoDienThoai;
    private JTextField tfQuocTich;
    private JComboBox<String> cbbLoaiPhong;

    public Rent() {
        setLayout(new BorderLayout(0, 0));
        
        JPanel panel = new JPanel();
        add(panel, BorderLayout.NORTH);
        
        JLabel lblNewLabel = new JLabel("Thuê Phòng");
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
        panel.add(lblNewLabel);
        
        JPanel datPhong = new JPanel();
        add(datPhong, BorderLayout.CENTER);
        datPhong.setLayout(new BorderLayout(0, 0));
        
        // Thêm margin cho panel_1
        datPhong.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        JPanel form = new JPanel();
        datPhong.add(form, BorderLayout.CENTER);
        form.setLayout(new BorderLayout(0, 0));
        
        JPanel panel_2 = new JPanel();
        panel_2.setBackground(new Color(255, 255, 255));
        form.add(panel_2, BorderLayout.NORTH);
        
        JLabel lblNewLabel_1 = new JLabel("Thông Tin Khách Hàng");
        lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
        panel_2.add(lblNewLabel_1);
        
        JPanel panel_3 = new JPanel();
        form.add(panel_3, BorderLayout.CENTER);
        panel_3.setLayout(new BoxLayout(panel_3, BoxLayout.Y_AXIS));
        
        JPanel panel_4 = new JPanel();
        panel_4.setBackground(new Color(255, 255, 255));
        panel_3.add(panel_4);
        
        tfHoTen = new JTextField();
        tfHoTen.setFont(new Font("Tahoma", Font.PLAIN, 15));
        tfHoTen.setColumns(20);
        TitledBorder border = BorderFactory.createTitledBorder("Họ tên");
        tfHoTen.setBorder(border);
        panel_4.add(tfHoTen);
        
        JPanel panel_5 = new JPanel();
        panel_5.setBackground(new Color(255, 255, 255));
        panel_3.add(panel_5);
        
        tfSoDienThoai = new JTextField();
        tfSoDienThoai.setFont(new Font("Tahoma", Font.PLAIN, 15));
        tfSoDienThoai.setColumns(20);
        TitledBorder border2 = BorderFactory.createTitledBorder("Số điện thoại");
        tfSoDienThoai.setBorder(border2);
        panel_5.add(tfSoDienThoai);
        
        JPanel panel_6 = new JPanel();
        panel_6.setBackground(new Color(255, 255, 255));
        panel_3.add(panel_6);
        
        JLabel lblNewLabel_2 = new JLabel("Giới tính");
        lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 15));
        panel_6.add(lblNewLabel_2);
        
        JRadioButton radioNam = new JRadioButton("Nam");
        radioNam.setBackground(new Color(255, 255, 255));
        radioNam.setFont(new Font("Tahoma", Font.BOLD, 15));
        panel_6.add(radioNam);
        
        JRadioButton radioNu = new JRadioButton("Nữ");
        radioNu.setBackground(new Color(255, 255, 255));
        radioNu.setFont(new Font("Tahoma", Font.BOLD, 15));
        panel_6.add(radioNu);
        
        ButtonGroup group = new ButtonGroup();
        group.add(radioNam);
        group.add(radioNu);
        
        JPanel panel_7 = new JPanel();
        panel_7.setBackground(new Color(255, 255, 255));
        panel_3.add(panel_7);
        
        tfQuocTich = new JTextField();
        tfQuocTich.setFont(new Font("Tahoma", Font.PLAIN, 15));
        tfQuocTich.setColumns(20);
        TitledBorder border3 = BorderFactory.createTitledBorder("Quốc tịch");
        tfQuocTich.setBorder(border3);
        panel_7.add(tfQuocTich);
        
        JPanel panel_8 = new JPanel();
        panel_8.setBackground(new Color(255, 255, 255));
        panel_3.add(panel_8);
        
        JLabel lblNewLabel_3 = new JLabel("Loại phòng");
        lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 15));
        panel_8.add(lblNewLabel_3);
        
        cbbLoaiPhong = new JComboBox<>();
        cbbLoaiPhong.setFont(new Font("Tahoma", Font.BOLD, 15));
        cbbLoaiPhong.setBackground(Color.LIGHT_GRAY);
        panel_8.add(cbbLoaiPhong);
        
        // Thêm các giá trị cho JComboBox
        addRoomTypes();

        JButton btnDatPhong = new JButton("Thuê Phòng");
        btnDatPhong.setFont(new Font("Tahoma", Font.BOLD, 15));
        btnDatPhong.setForeground(Color.WHITE);
        btnDatPhong.setBackground(new Color(0, 153, 255));
        btnDatPhong.setOpaque(true);
        btnDatPhong.setBorder(BorderFactory.createEmptyBorder(5, 15, 5, 15)); // Bo góc cho nút
        panel_8.add(btnDatPhong);
        
        JPanel list = new JPanel();
        list.setPreferredSize(new Dimension(300, list.getHeight()));
        list.setBackground(Color.WHITE);
        datPhong.add(list, BorderLayout.EAST);
        list.setLayout(new GridLayout(2, 1, 0, 5));
        
        JPanel empty = new JPanel();
        empty.setBackground(Color.WHITE);
        list.add(empty);
        empty.setLayout(new BorderLayout(0, 0));
        
        JPanel panel_9 = new JPanel();
        panel_9.setBackground(new Color(255, 255, 255));
        empty.add(panel_9, BorderLayout.NORTH);
        
        JLabel lblNewLabel_4 = new JLabel("Danh sách phòng trống");
        lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 15));
        panel_9.add(lblNewLabel_4);
        
        JScrollPane scrollPane = new JScrollPane();
        empty.add(scrollPane, BorderLayout.CENTER);

        // Tạo JPanel chứa các item cho phòng trống
        JPanel availableRoomPanel = new JPanel();
        availableRoomPanel.setLayout(new BoxLayout(availableRoomPanel, BoxLayout.Y_AXIS));
        scrollPane.setViewportView(availableRoomPanel);

        // Thêm các item vào danh sách phòng trống
        addRoomItems(availableRoomPanel, "Phòng trống");

        JPanel ordered = new JPanel();
        list.add(ordered);
        ordered.setLayout(new BorderLayout(0, 0));
        
        JPanel panel_10 = new JPanel();
        panel_10.setBackground(new Color(255, 255, 255));
        ordered.add(panel_10, BorderLayout.NORTH);
        
        JLabel lblNewLabel_5 = new JLabel("Danh sách phòng thuê");
        lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 15));
        panel_10.add(lblNewLabel_5);
        
        JScrollPane scrollPane_1 = new JScrollPane();
        ordered.add(scrollPane_1, BorderLayout.CENTER);

        // Tạo JPanel chứa các item cho phòng đặt
        JPanel bookedRoomPanel = new JPanel();
        bookedRoomPanel.setLayout(new BoxLayout(bookedRoomPanel, BoxLayout.Y_AXIS));
        scrollPane_1.setViewportView(bookedRoomPanel);

        // Thêm các item vào danh sách phòng đặt
        addRoomItems(bookedRoomPanel, "Phòng đã đặt");
    }

    // Hàm thêm các giá trị loại phòng vào JComboBox
    private void addRoomTypes() {
        cbbLoaiPhong.addItem("Phòng đơn");
        cbbLoaiPhong.addItem("Phòng đôi");
        cbbLoaiPhong.addItem("Phòng VIP");
    }

 // Hàm thêm các item vào danh sách phòng trống và phòng đặt
    private void addRoomItems(JPanel panel, String type) {
        for (int i = 1; i <= 10; i++) {
            JPanel itemPanel = new JPanel();
            itemPanel.setLayout(new BorderLayout());
            
            JLabel lbIcon = new JLabel("");
            lbIcon.setIcon(new ImageIcon(Service.class.getResource("/Photos/living-room.png")));
            lbIcon.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 10));
            itemPanel.add(lbIcon, BorderLayout.WEST);
            
            JPanel itemContent = new JPanel();
            itemContent.setLayout(new BoxLayout(itemContent, BoxLayout.Y_AXIS));
            itemContent.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); 
            itemContent.setAlignmentX(Component.CENTER_ALIGNMENT); 
            
            JLabel maPhong = new JLabel("P2006");
            maPhong.setAlignmentX(Component.CENTER_ALIGNMENT);
            JLabel loaiPhong = new JLabel("Phòng đôi");
            loaiPhong.setAlignmentX(Component.CENTER_ALIGNMENT);
            itemContent.add(maPhong);
            itemContent.add(loaiPhong);
            
            itemPanel.add(itemContent, BorderLayout.CENTER);
            JButton btn = new JButton("");
            if(type == "Phòng đã đặt") {
            	btn.setIcon(new ImageIcon(Service.class.getResource("/Photos/close.png")));
            	itemPanel.addMouseListener(new java.awt.event.MouseAdapter() {
                    @Override
                    public void mouseClicked(java.awt.event.MouseEvent evt) {
                        MainGUI main = new MainGUI();
                        main.openChiTietDatPhong("Thuê Phòng");
                    }
                });
            } else {
            	btn.setIcon(new ImageIcon(Service.class.getResource("/Photos/plus.png")));
            	btn.addMouseListener(new java.awt.event.MouseAdapter() {
                    @Override
                    public void mouseClicked(java.awt.event.MouseEvent evt) {
                        MainGUI main = new MainGUI();
                        main.openChiTietDatPhong("Thuê Phòng");
                    }
                });
            }
            btn.setBackground(Color.LIGHT_GRAY);
            btn.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 10)); 
            btn.addActionListener(this);
            itemPanel.add(btn, BorderLayout.EAST);
            
            itemPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1)); 
            itemPanel.setBackground(Color.LIGHT_GRAY); 
            
            panel.add(itemPanel);
            panel.add(Box.createRigidArea(new Dimension(0, 5)));
        }
    }

@Override
public void actionPerformed(ActionEvent e) {
	
}

}
