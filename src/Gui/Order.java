package Gui;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import Dao.LoaiPhong_dao;
import Dao.Phong_dao;
import Entity.Phong;

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

public class Order extends JPanel implements ActionListener{
	private Phong_dao phongDao = new Phong_dao();
	private LoaiPhong_dao loaiPhongDao = new LoaiPhong_dao();
	
	private MainGUI mainGUI;
    private JTextField tfHoTen;
    private JTextField tfSoDienThoai;
    private JTextField tfQuocTich;
    private JComboBox<String> cbbLoaiPhong;
    private JPanel availableRoomPanel = new JPanel();
    private ArrayList<Phong> dsPhongDaDat;
    private JRadioButton radioNam;
    private JRadioButton radioNu; 
    
    public Order(MainGUI mainGUI) {
    	this.mainGUI = mainGUI;
    	dsPhongDaDat = new ArrayList<Phong>();
        setLayout(new BorderLayout(0, 0));
        
        JPanel panel = new JPanel();
        add(panel, BorderLayout.NORTH);
        
        JLabel lblNewLabel = new JLabel("Đặt Phòng");
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
        
        radioNam = new JRadioButton("Nam");
        radioNam.setBackground(new Color(255, 255, 255));
        radioNam.setFont(new Font("Tahoma", Font.BOLD, 15));
        radioNam.setSelected(true);
        panel_6.add(radioNam);
        
        radioNu = new JRadioButton("Nữ");
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
        
        //ArrayList<Phong> dsPhongTrong = phongDao.danhSachPhongTheoTrangThai("Trống");
        
        cbbLoaiPhong = new JComboBox<>();
        cbbLoaiPhong.setFont(new Font("Tahoma", Font.BOLD, 15));
        cbbLoaiPhong.setBackground(Color.LIGHT_GRAY);
        panel_8.add(cbbLoaiPhong);
        
        addRoomTypes();
        cbbLoaiPhong.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedLoaiPhong = (String) cbbLoaiPhong.getSelectedItem();
                updatePanelDanhSachPhongTrong(selectedLoaiPhong);
            }
        });



        JButton btnDatPhong = new JButton("Đặt Phòng");
        btnDatPhong.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		if(checkForm() == false) {
        			return;
        		}
        		if(dsPhongDaDat.size() == 0) {
        			JOptionPane.showMessageDialog(null,"Chưa chọn phòng nào!", "Thông báo",JOptionPane.INFORMATION_MESSAGE);
        			return;
        		}
        		
        	}
        });
        btnDatPhong.setFont(new Font("Tahoma", Font.BOLD, 15));
        btnDatPhong.setForeground(Color.WHITE);
        btnDatPhong.setBackground(new Color(0, 153, 255));
        btnDatPhong.setOpaque(true);
        btnDatPhong.setBorder(BorderFactory.createEmptyBorder(5, 15, 5, 15)); // Bo góc cho nút
        panel_8.add(btnDatPhong);
        
        JButton btnXoaTrang = new JButton("Xóa trắng");
        btnXoaTrang.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		tfHoTen.setText("");
        		tfSoDienThoai.setText("");
        		tfQuocTich.setText("");
        		cbbLoaiPhong.setSelectedIndex(0);
        		radioNam.setSelected(true);
        	}
        });
        btnXoaTrang.setBackground(new Color(192, 192, 192));
        btnXoaTrang.setFont(new Font("Tahoma", Font.BOLD, 15));
        panel_8.add(btnXoaTrang);
        
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

        availableRoomPanel.setLayout(new BoxLayout(availableRoomPanel, BoxLayout.Y_AXIS));
        scrollPane.setViewportView(availableRoomPanel);
//        ArrayList<Phong> filteredRooms = (ArrayList<Phong>) dsPhongTrong.stream()
//                .filter(item -> item.getLoaiPhong().getTenLoaiPhong().equals("Phòng đơn"))
//                .collect(Collectors.toList());
//        addRoomItems(availableRoomPanel, "Phòng trống",filteredRooms);
        updatePanelDanhSachPhongTrong("Phòng đơn");
        JPanel ordered = new JPanel();
        list.add(ordered);
        ordered.setLayout(new BorderLayout(0, 0));
        
        JPanel panel_10 = new JPanel();
        panel_10.setBackground(new Color(255, 255, 255));
        ordered.add(panel_10, BorderLayout.NORTH);
        
        JLabel lblNewLabel_5 = new JLabel("Danh sách phòng đặt");
        lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 15));
        panel_10.add(lblNewLabel_5);
        
        JScrollPane scrollPane_1 = new JScrollPane();
        ordered.add(scrollPane_1, BorderLayout.CENTER);

        JPanel bookedRoomPanel = new JPanel();
        bookedRoomPanel.setLayout(new BoxLayout(bookedRoomPanel, BoxLayout.Y_AXIS));
        scrollPane_1.setViewportView(bookedRoomPanel);
    }

    private void addRoomTypes() {
    	loaiPhongDao.danhSachLoaiPhong().forEach(item -> {
    		cbbLoaiPhong.addItem(item.getTenLoaiPhong());
    	});
    }

 
    private void addRoomItems(JPanel panel, String type, ArrayList<Phong> dsPhong) {
        dsPhong.forEach(item -> {
        	JPanel itemPanel = new JPanel();
        	itemPanel.setPreferredSize(new Dimension(panel.getPreferredSize().width,50));
        	itemPanel.setMaximumSize(new Dimension(Integer.MAX_VALUE, 50));
            itemPanel.setLayout(new BorderLayout());
            
            JLabel lbIcon = new JLabel("");
            lbIcon.setIcon(new ImageIcon(Service.class.getResource("/Photos/living-room.png")));
            lbIcon.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 10));
            itemPanel.add(lbIcon, BorderLayout.WEST);
            
            JPanel itemContent = new JPanel();
            itemContent.setLayout(new BoxLayout(itemContent, BoxLayout.Y_AXIS));
            itemContent.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); 
            itemContent.setAlignmentX(Component.CENTER_ALIGNMENT); 
            
            JLabel maPhong = new JLabel(item.getTang() + " - " + item.getMaPhong());
            maPhong.setAlignmentX(Component.CENTER_ALIGNMENT);
            JLabel loaiPhong = new JLabel(item.getLoaiPhong().getTenLoaiPhong());
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
                        mainGUI.openChiTietDatPhong("Đặt Phòng");
                    }
                });
            } else {
            	btn.setIcon(new ImageIcon(Service.class.getResource("/Photos/plus.png")));
            	btn.addMouseListener(new java.awt.event.MouseAdapter() {
                    @Override
                    public void mouseClicked(java.awt.event.MouseEvent evt) {
                    	// logic kiểm tra các field
              
                        int gioiTinh = 1;
                        if(radioNu.isSelected()) gioiTinh = 0;
                        mainGUI.openChiTietDatPhong("Đặt Phòng");
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
        });
    }

    private boolean checkForm() {
        String hoTen = tfHoTen.getText();
        String sdt = tfSoDienThoai.getText();
        String quocTich = tfQuocTich.getText();
        int gioiTinh = 1;
        if (radioNu.isSelected()) gioiTinh = 0;

        if (hoTen.equals("") || sdt.equals("") || quocTich.equals("")) {
            JOptionPane.showMessageDialog(null, "Vui lòng điền thông tin vào các trường", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            return false;
        }

        if (!hoTen.matches("^[a-zA-Z\\s]+$")) {
            JOptionPane.showMessageDialog(null, "Tên chỉ bao gồm chữ cái và khoảng trắng", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            return false;
        }

        if (!sdt.matches("^\\d{9,11}$")) {
            JOptionPane.showMessageDialog(null, "Số điện thoại chỉ bao gồm số và có độ dài từ 9 đến 11 ký tự", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            return false;
        }

        if (!quocTich.matches("^[a-zA-Z\\s]+$")) {
            JOptionPane.showMessageDialog(null, "Quốc tịch chỉ bao gồm chữ cái và khoảng trắng", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            return false;
        }

        return true;
    }

    private void updatePanelDanhSachPhongTrong(String LoaiPhong) {
    	ArrayList<Phong> dsPhongTrong = phongDao.danhSachPhongTheoTrangThai("Trống");

        ArrayList<Phong> filteredRooms = (ArrayList<Phong>) dsPhongTrong.stream()
            .filter(item -> item.getLoaiPhong().getTenLoaiPhong().equals(LoaiPhong))
            .filter(item -> !dsPhongDaDat.contains(item))
            .collect(Collectors.toList());
        availableRoomPanel.removeAll(); 

        addRoomItems(availableRoomPanel, "Phòng trống", filteredRooms); 

        availableRoomPanel.revalidate();
        availableRoomPanel.repaint();
    }
    
@Override
public void actionPerformed(ActionEvent e) {
	
}

}
