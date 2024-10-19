package Gui;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.RoundRectangle2D;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.border.EmptyBorder;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JScrollPane;
import java.awt.GridLayout;
import javax.swing.border.LineBorder;
import java.awt.FlowLayout;

public class Search extends JPanel {
    private JTextField input;
    private JButton activeButton = null;
    private JPanel detail;

    public Search() {
        setLayout(new BorderLayout(0, 0));

        JPanel header = new JPanel();
        header.setBorder(new EmptyBorder(10, 0, 10, 0));
        add(header, BorderLayout.NORTH);

        JLabel title = new JLabel("Tra Cứu");
        title.setFont(new Font("Tahoma", Font.BOLD, 17));
        header.add(title);

        JPanel body = new JPanel();
        body.setBackground(new Color(255, 255, 255));
        body.setBorder(new EmptyBorder(10, 10, 10, 10)); 
        add(body, BorderLayout.CENTER);
        body.setLayout(new BorderLayout(0, 0));

        JPanel selection = new JPanel();
        selection.setBackground(new Color(255, 255, 255));
        selection.setBorder(new EmptyBorder(10, 10, 10, 10));
        body.add(selection, BorderLayout.NORTH);

        input = new JTextField();
        input.setFont(new Font("Tahoma", Font.PLAIN, 15));
        selection.add(input);
        input.setColumns(20);

        JButton btnRoom = createCustomButton("Phòng", Color.LIGHT_GRAY);
        selection.add(btnRoom);

        JButton btnHoaDon = createCustomButton("Hóa Đơn", Color.LIGHT_GRAY);
        selection.add(btnHoaDon);

        JButton btnDatPhong = createCustomButton("Thông Tin Đặt Phòng", Color.LIGHT_GRAY);
        selection.add(btnDatPhong);
        
        JButton btnTraCuu = new JButton("Tra Cứu");
        btnTraCuu.setBackground(Color.LIGHT_GRAY);
        btnTraCuu.setFont(new Font("Tahoma", Font.BOLD, 15));
        selection.add(btnTraCuu);

        // Table Panel với margin
        JPanel table = new JPanel();
        table.setBorder(new EmptyBorder(20, 10, 20, 10));
        body.add(table, BorderLayout.CENTER);
        table.setLayout(new BorderLayout(0, 0));

        JLabel title2 = new JLabel("Danh Sách Kết Quả");
        title2.setFont(new Font("Tahoma", Font.BOLD, 17));
        title2.setHorizontalAlignment(SwingConstants.CENTER);
        table.add(title2, BorderLayout.NORTH);
        
        JPanel tableBody = new JPanel();
        table.add(tableBody, BorderLayout.CENTER);
        tableBody.setLayout(new GridLayout(0, 2, 0, 0));
        
        JPanel tableLeft = new JPanel();
        tableLeft.setLayout(new BoxLayout(tableLeft, BoxLayout.Y_AXIS));

        JScrollPane scrollPane = new JScrollPane(tableLeft);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        tableBody.add(scrollPane);

        JPanel panelItem1 = createCustomPanelItem("HD06022004120000");
        tableLeft.add(panelItem1);

        tableLeft.add(Box.createVerticalStrut(10)); 

        JPanel panelItem2 = createCustomPanelItem("ví dụ 2");
        tableLeft.add(panelItem2);
        
        tableLeft.add(Box.createVerticalStrut(10)); 
        
        JPanel panelItem3 = createCustomPanelItem("ví dụ 3");
        tableLeft.add(panelItem3);
        
        tableLeft.add(Box.createVerticalStrut(10)); 
        
        JPanel panelItem4 = createCustomPanelItem("ví dụ 4");
        tableLeft.add(panelItem4);
        
        tableLeft.add(Box.createVerticalStrut(10));
        
        JPanel panelItem5 = createCustomPanelItem("ví dụ 5");
        tableLeft.add(panelItem5);
        
        tableLeft.add(Box.createVerticalStrut(10));
        
        JPanel panelItem6 = createCustomPanelItem("ví dụ 6");
        tableLeft.add(panelItem6);
        
        tableLeft.add(Box.createVerticalStrut(10)); 
        
        JPanel panelItem7 = createCustomPanelItem("ví dụ 7");
        tableLeft.add(panelItem7);
        
        tableLeft.add(Box.createVerticalStrut(10)); 

        JPanel tableRight = new JPanel();
        tableRight.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
        tableBody.add(tableRight);
        tableRight.setLayout(new BorderLayout(0, 0));
        
        JLabel lblNewLabel = new JLabel("Thông Tin Chi Tiết");
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        tableRight.add(lblNewLabel, BorderLayout.NORTH);
        
        detail = new JPanel();
        detail.setBackground(new Color(255, 255, 255));
        tableRight.add(detail, BorderLayout.CENTER);
        detail.setLayout(new BoxLayout(detail, BoxLayout.Y_AXIS));
        
        btnRoom.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setActiveButton(btnRoom, btnHoaDon, btnDatPhong);
            }
        });

        btnHoaDon.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setActiveButton(btnHoaDon, btnRoom, btnDatPhong);
            }
        });

        btnDatPhong.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setActiveButton(btnDatPhong, btnRoom, btnHoaDon);
            }
        });
        
        btnTraCuu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               
            }
        });
        
        formPhieuDatPhong();
        formHoaDon();
        formPhong();
    }

    private JButton createCustomButton(String text, Color backgroundColor) {
        JButton button = new JButton(text) {
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2 = (Graphics2D) g.create();
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g2.setColor(getBackground());
                g2.fill(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), 30, 30)); // Bo góc 30px
                super.paintComponent(g2);
                g2.dispose();
            }
        };
        button.setFont(new Font("Tahoma", Font.BOLD, 15));
        button.setForeground(Color.BLACK);
        button.setFocusPainted(false);
        button.setBorderPainted(false);
        button.setContentAreaFilled(false);
        button.setBackground(backgroundColor);
        return button;
    }

    private JPanel createCustomPanelItem(String text) {
        JPanel panelItem = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2 = (Graphics2D) g;
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g2.setColor(Color.LIGHT_GRAY);
                g2.fill(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), 20, 20));
            }
        };
        panelItem.setBorder(new EmptyBorder(10, 10, 10, 10));
        JLabel label = new JLabel(text);
        panelItem.add(label);
        return panelItem;
    }

    private void setActiveButton(JButton activeButton, JButton... otherButtons) {
        activeButton.setBackground(new Color(0, 153, 255));
        activeButton.setForeground(Color.WHITE);
        
        for (JButton btn : otherButtons) {
            btn.setBackground(Color.LIGHT_GRAY); 
            btn.setForeground(Color.BLACK);
        }
    }
    
    private void formPhieuDatPhong() {
        // Clear previous content in detail panel
        detail.removeAll();
        
        // Set layout for detail panel with GridLayout (6 rows, 1 column)
        detail.setLayout(new GridLayout(6, 1, 0, 0)); // 6 rows, 1 column, with no spacing between panels
        
        // Kích thước chung cho các JPanel

        // Mã phiếu đặt phòng
        JPanel maPhieuPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel maPhieuLabel = new JLabel("Mã phiếu đặt phòng:    ");
        JTextField maPhieuField = new JTextField(20);
        maPhieuField.setEditable(false); // Không cho phép chỉnh sửa
        maPhieuPanel.add(maPhieuLabel);
        maPhieuPanel.add(maPhieuField);
        detail.add(maPhieuPanel);
        
        // Thời gian nhận phòng
        JPanel thoiGianNhanPhongPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel thoiGianNhanPhongLabel = new JLabel("Thời gian nhận phòng: ");
        JTextField thoiGianNhanPhongField = new JTextField(20);
        thoiGianNhanPhongField.setEditable(false); // Không cho phép chỉnh sửa
        thoiGianNhanPhongPanel.add(thoiGianNhanPhongLabel);
        thoiGianNhanPhongPanel.add(thoiGianNhanPhongField);
        detail.add(thoiGianNhanPhongPanel);
        
        // Số lượng người
        JPanel soLuongNguoiPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel soLuongNguoiLabel = new JLabel("Số lượng người:          ");
        JTextField soLuongNguoiField = new JTextField(20);
        soLuongNguoiField.setEditable(false); // Không cho phép chỉnh sửa
        soLuongNguoiPanel.add(soLuongNguoiLabel);
        soLuongNguoiPanel.add(soLuongNguoiField);
        detail.add(soLuongNguoiPanel);
        
        // Thời gian đặt
        JPanel thoiGianDatPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel thoiGianDatLabel = new JLabel("Thời gian đặt:               ");
        JTextField thoiGianDatField = new JTextField(20);
        thoiGianDatField.setEditable(false); // Không cho phép chỉnh sửa
        thoiGianDatPanel.add(thoiGianDatLabel);
        thoiGianDatPanel.add(thoiGianDatField);
        detail.add(thoiGianDatPanel);
        
        // Mã Khách Hàng
        JPanel maKhachHangPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel maKhachHangLabel = new JLabel("Mã Khách Hàng:           ");
        JTextField maKhachHangField = new JTextField(20);
        maKhachHangField.setEditable(false); // Không cho phép chỉnh sửa
        maKhachHangPanel.add(maKhachHangLabel);
        maKhachHangPanel.add(maKhachHangField);
        detail.add(maKhachHangPanel);
        
        // Mã Nhân Viên
        JPanel maNhanVienPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel maNhanVienLabel = new JLabel("Mã Nhân Viên:               ");
        JTextField maNhanVienField = new JTextField(20);
        maNhanVienField.setEditable(false); // Không cho phép chỉnh sửa
        maNhanVienPanel.add(maNhanVienLabel);
        maNhanVienPanel.add(maNhanVienField);
        detail.add(maNhanVienPanel);
        
        // Refresh panel to apply changes
        detail.revalidate();
        detail.repaint();
    }
    
    private void formHoaDon() {
        // Clear previous content in detail panel
        detail.removeAll();
        
        // Set layout for detail panel with GridLayout (7 rows, 1 column)
        detail.setLayout(new GridLayout(7, 1, 0, 0)); // 7 rows, 1 column, with no spacing between panels

        // Mã hóa đơn
        JPanel maHoaDonPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel maHoaDonLabel = new JLabel("Mã hóa đơn:              ");
        JTextField maHoaDonField = new JTextField(20);
        maHoaDonField.setEditable(false); // Không cho phép chỉnh sửa
        maHoaDonPanel.add(maHoaDonLabel);
        maHoaDonPanel.add(maHoaDonField);
        detail.add(maHoaDonPanel);
        
        // Thời gian nhận
        JPanel thoiGianNhanPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel thoiGianNhanLabel = new JLabel("Thời gian nhận:        ");
        JTextField thoiGianNhanField = new JTextField(20);
        thoiGianNhanField.setEditable(false); // Không cho phép chỉnh sửa
        thoiGianNhanPanel.add(thoiGianNhanLabel);
        thoiGianNhanPanel.add(thoiGianNhanField);
        detail.add(thoiGianNhanPanel);
        
        // Thời gian trả
        JPanel thoiGianTraPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel thoiGianTraLabel = new JLabel("Thời gian trả:            ");
        JTextField thoiGianTraField = new JTextField(20);
        thoiGianTraField.setEditable(false); // Không cho phép chỉnh sửa
        thoiGianTraPanel.add(thoiGianTraLabel);
        thoiGianTraPanel.add(thoiGianTraField);
        detail.add(thoiGianTraPanel);
        
        // Ngày lập hóa đơn
        JPanel ngayLapPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel ngayLapLabel = new JLabel("Ngày lập hóa đơn:     ");
        JTextField ngayLapField = new JTextField(20);
        ngayLapField.setEditable(false); // Không cho phép chỉnh sửa
        ngayLapPanel.add(ngayLapLabel);
        ngayLapPanel.add(ngayLapField);
        detail.add(ngayLapPanel);
        
        // Mã phiếu đặt phòng
        JPanel maPhieuDatPhongPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel maPhieuDatPhongLabel = new JLabel("Mã phiếu đặt phòng: ");
        JTextField maPhieuDatPhongField = new JTextField(20);
        maPhieuDatPhongField.setEditable(false); // Không cho phép chỉnh sửa
        maPhieuDatPhongPanel.add(maPhieuDatPhongLabel);
        maPhieuDatPhongPanel.add(maPhieuDatPhongField);
        detail.add(maPhieuDatPhongPanel);
        
        // Mã nhân viên
        JPanel maNhanVienPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel maNhanVienLabel = new JLabel("Mã nhân viên:             ");
        JTextField maNhanVienField = new JTextField(20);
        maNhanVienField.setEditable(false); // Không cho phép chỉnh sửa
        maNhanVienPanel.add(maNhanVienLabel);
        maNhanVienPanel.add(maNhanVienField);
        detail.add(maNhanVienPanel);
        
        // Tổng tiền
        JPanel tongTienPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel tongTienLabel = new JLabel("Tổng tiền:                    ");
        JTextField tongTienField = new JTextField(20);
        tongTienField.setEditable(false); // Không cho phép chỉnh sửa
        tongTienPanel.add(tongTienLabel);
        tongTienPanel.add(tongTienField);
        detail.add(tongTienPanel);
        
        // Refresh panel to apply changes
        detail.revalidate();
        detail.repaint();
    }
    
    private void formPhong() {
        // Clear previous content in detail panel
        detail.removeAll();
        
        // Set layout for detail panel with GridLayout (4 rows, 1 column)
        detail.setLayout(new GridLayout(4, 1, 0, 0)); // 4 rows, 1 column, with no spacing between panels

        // Mã phòng
        JPanel maPhongPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel maPhongLabel = new JLabel("Mã phòng:                            ");
        JTextField maPhongField = new JTextField(20);
        maPhongField.setEditable(false); // Không cho phép chỉnh sửa
        maPhongPanel.add(maPhongLabel);
        maPhongPanel.add(maPhongField);
        detail.add(maPhongPanel);
        
        // Trạng thái
        JPanel trangThaiPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel trangThaiLabel = new JLabel("Trạng thái:                          ");
        JTextField trangThaiField = new JTextField(20);
        trangThaiField.setEditable(false); // Không cho phép chỉnh sửa
        trangThaiPanel.add(trangThaiLabel);
        trangThaiPanel.add(trangThaiField);
        detail.add(trangThaiPanel);
        
        // Mã loại phòng
        JPanel maLoaiPhongPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel maLoaiPhongLabel = new JLabel("Mã loại phòng:                   ");
        JTextField maLoaiPhongField = new JTextField(20);
        maLoaiPhongField.setEditable(false); // Không cho phép chỉnh sửa
        maLoaiPhongPanel.add(maLoaiPhongLabel);
        maLoaiPhongPanel.add(maLoaiPhongField);
        detail.add(maLoaiPhongPanel);
        
        // Khách hàng đang thuê
        JPanel khachHangPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel khachHangLabel = new JLabel("Khách hàng đang thuê:    ");
        JTextField khachHangField = new JTextField(20);
        khachHangField.setEditable(false); // Không cho phép chỉnh sửa
        khachHangPanel.add(khachHangLabel);
        khachHangPanel.add(khachHangField);
        detail.add(khachHangPanel);
        
        // Refresh panel to apply changes
        detail.revalidate();
        detail.repaint();
    }

}
