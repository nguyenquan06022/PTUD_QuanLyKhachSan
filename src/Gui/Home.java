package Gui;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import ConnectDB.database;
import Dao.LoaiPhong_dao;
import Dao.PhieuDatPhong_dao;
import Dao.Phong_dao;
import Entity.Phong;

import java.awt.*;
import java.util.ArrayList;

import javax.swing.border.BevelBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Home extends JPanel {
	
	private static final long serialVersionUID = 1L;
	private LoaiPhong_dao loaiPhongDao = new LoaiPhong_dao();
    private Phong_dao phongDao = new Phong_dao();
    private PhieuDatPhong_dao phieuDatPhongDao = new PhieuDatPhong_dao();
    private JPanel itemPanel = new JPanel();
    private ArrayList<itemPhong> dsItemPhong = new ArrayList<itemPhong>();
    private ArrayList<itemPhong> dsCurItemPhong = new ArrayList<itemPhong>();
    private JTextField tfSoDienThoai;
    private JButton btnSearch;
    
    public Home() {
        try {
            database.getInstance().Connect();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Lỗi database vui lòng kiểm tra lại","Lỗi",JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
        
        setBackground(new Color(255, 255, 255));
        setLayout(new BorderLayout(0, 0));

        JPanel panel = new JPanel();
        setBorder(new EmptyBorder(20, 20, 20, 20));
        add(panel, BorderLayout.NORTH);
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        
        JPanel panel_12 = new JPanel();
        panel.add(panel_12);
        
        JLabel lblTrangChu = new JLabel("Trang Chủ");
        lblTrangChu.setFont(new Font("Tahoma", Font.BOLD, 20));
        panel_12.add(lblTrangChu);
        
        JPanel panel_13 = new JPanel();
        panel.add(panel_13);
        panel_13.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
        
        JPanel panel_14 = new JPanel();
        panel_13.add(panel_14);
        
        JLabel lblNewLabel = new JLabel("Tìm theo số điện thoại");
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblNewLabel.setHorizontalAlignment(SwingConstants.TRAILING);
        panel_14.add(lblNewLabel);
        
        JPanel panel_15 = new JPanel();
        panel_13.add(panel_15);
        
        btnSearch = new JButton("");
        btnSearch.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		itemPanel.removeAll();
        		dsCurItemPhong.forEach(item -> {
        			if(tfSoDienThoai.getText().trim().equals(item.getSdt()) && !item.getSdt().equals("")) {
        				if(dsItemPhong.size() != 3) {
                            dsItemPhong.add(item);
                        } else {
                            JPanel rowPanel = new JPanel();
                            rowPanel.setPreferredSize(new Dimension(itemPanel.getPreferredSize().width,150));
                            rowPanel.setBackground(Color.white);
                            rowPanel.setMaximumSize(new Dimension(Integer.MAX_VALUE, 150));
                            rowPanel.setLayout(new GridLayout(1, 3, 10, 10));
                            rowPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
                            dsItemPhong.forEach(x -> {
                                rowPanel.add(x);
                            });
                            itemPanel.add(rowPanel);
                            dsItemPhong.clear();
                            
                            dsItemPhong.add(item);
                        }
        				item.addMouseListener(new java.awt.event.MouseAdapter() {
        	                @Override
        	                public void mouseClicked(java.awt.event.MouseEvent e) {
        	                	System.out.println(item.getTrangThai());
        	                	if(item.getTrangThai().equals("Đã đặt")) {
        	                		//String maPhong, String tang,String loaiPhong, String tenKhachHang, String sdt, String thoiGianDat, String thoiGianNhan, String thoiGianTra, String soLuongNguoiThue, String hinhThucThue
        	                		String thoiGianDat = phieuDatPhongDao.getThongTinForNhanPhong("ThoiGianDat",item.getMaPhong());
        	                		String thoiGianNhan = phieuDatPhongDao.getThongTinForNhanPhong("ThoiGianNhan", item.getMaPhong());
        	                		String thoiGianTra = phieuDatPhongDao.getThongTinForNhanPhong("ThoiGianTra", item.getMaPhong());
        	                		String soLuongNguoi = phieuDatPhongDao.getThongTinForNhanPhong("SoLuongNguoi", item.getMaPhong());
        	                		String hinhThucThue = phieuDatPhongDao.getThongTinForNhanPhong("CachThue", item.getMaPhong());
        	                		new NhanPhong(item.getMaPhong(),item.getTang(),item.getLoaiPhong(),item.getTenKhachHang(),item.getSdt(),thoiGianDat,thoiGianNhan,thoiGianTra,soLuongNguoi,hinhThucThue);
        	                	}
        	                	else if(item.getTrangThai().equals("Đang thuê")) {
        	                		
        	                	}
        	                }
        	            });
        			}
        		});
        		if(!dsItemPhong.isEmpty()) {
                    int remain = 3 - dsItemPhong.size();
                    JPanel rowPanel = new JPanel();
                    rowPanel.setPreferredSize(new Dimension(itemPanel.getPreferredSize().width,150));
                    rowPanel.setBackground(Color.white);
                    rowPanel.setMaximumSize(new Dimension(Integer.MAX_VALUE, 150));
                    rowPanel.setLayout(new GridLayout(1, 3, 10, 10));
                    rowPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
                    dsItemPhong.forEach(x -> {
                        rowPanel.add(x);
                    });
                    for(int i = 0; i < remain; i++) {
                        JPanel pn = new JPanel();
                        pn.setBackground(Color.white);
                        rowPanel.add(pn);
                    }
                    itemPanel.add(rowPanel);
                    dsItemPhong.clear();
                }

                itemPanel.revalidate();
                itemPanel.repaint();
        	}
        });
        btnSearch.setIcon(new ImageIcon(Home.class.getResource("/Photos/search.png")));
        btnSearch.setSelectedIcon(new ImageIcon(Home.class.getResource("/Photos/search.png")));
        btnSearch.setFont(new Font("Tahoma", Font.BOLD, 15));
        
        tfSoDienThoai = new JTextField();
        tfSoDienThoai.setPreferredSize(new Dimension(200, btnSearch.getPreferredSize().height));
        tfSoDienThoai.setFont(new Font("Tahoma", Font.BOLD, 15));
        panel_15.add(tfSoDienThoai);
        tfSoDienThoai.setColumns(20);
        
        panel_15.add(btnSearch);
        
        JPanel panel_16 = new JPanel();
        panel_13.add(panel_16);

        JPanel panel_1 = new JPanel();
        add(panel_1, BorderLayout.CENTER);
        panel_1.setLayout(new BorderLayout(0, 0));
        
        JPanel pnControl = new JPanel();
        pnControl.setBorder(new EmptyBorder(10, 10, 10, 10));
        pnControl.setLayout(new BoxLayout(pnControl, BoxLayout.Y_AXIS));
        panel_1.add(pnControl, BorderLayout.WEST);
        
        JPanel panel_11 = new JPanel();
        pnControl.add(panel_11);
        panel_11.setLayout(new BoxLayout(panel_11, BoxLayout.Y_AXIS));
        
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
        ArrayList<String> dslp = new ArrayList<String>();
        loaiPhongDao.danhSachLoaiPhong().forEach(item-> {
        	if(!dslp.contains(item.getTenLoaiPhong())) cbbLoaiPhong.addItem(item.getTenLoaiPhong());
        });
        panel_6.add(cbbLoaiPhong);
        
        JPanel panel_4 = new JPanel();
        pnControl.add(panel_4);
        panel_4.setLayout(new BoxLayout(panel_4, BoxLayout.Y_AXIS));
        
        JPanel panel_10 = new JPanel();
        panel_4.add(panel_10);
        
        JLabel lbLau = new JLabel("Tầng");
        panel_10.add(lbLau);
        lbLau.setFont(new Font("Tahoma", Font.BOLD, 15));
        
        JPanel panel_7 = new JPanel();
        panel_4.add(panel_7);
        
        JComboBox<String> cbbLau = new JComboBox<>();
        cbbLau.addItem("Tất Cả");
        ArrayList<Phong> dsPhong = phongDao.danhSachPhong();
        ArrayList<String> dsTang = new ArrayList<>();
        dsPhong.forEach(item -> {
        	if(!dsTang.contains(item.getTang())) {
        		dsTang.add(item.getTang());
        		cbbLau.addItem(item.getTang());
        	}
        });
        panel_7.add(cbbLau);
        
        ActionListener comboBoxListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String trangThai = (String) cbbTrangThai.getSelectedItem();
                String loaiPhong = (String) cbbLoaiPhong.getSelectedItem();
                String lau = (String) cbbLau.getSelectedItem();
                itemPanel.removeAll();

                dsPhong.stream()
                    .filter(item -> (trangThai.equals("Tất Cả") || item.getTrangThai().equals(trangThai)))
                    .filter(item -> (loaiPhong.equals("Tất Cả") || item.getLoaiPhong().getTenLoaiPhong().equals(loaiPhong)))
                    .filter(item -> (lau.equals("Tất Cả") || item.getTang().equals(lau)))
                    .forEach(item -> {
                        itemPhong itemphong;
                        if (item.getTrangThai().equals("Đã đặt")) {
                            itemphong = phieuDatPhongDao.createItemPhongTheoMaPhong(item.getMaPhong(), "Đã đặt");
                        } else if (item.getTrangThai().equals("Đang thuê")) {
                            itemphong = phieuDatPhongDao.createItemPhongTheoMaPhong(item.getMaPhong(), "Đang thuê");
                        } else {
                            itemphong = phieuDatPhongDao.createItemPhongTheoMaPhong(item.getMaPhong(), "Trống");
                        }

                        itemphong.addMouseListener(new java.awt.event.MouseAdapter() {
        	                @Override
        	                public void mouseClicked(java.awt.event.MouseEvent e) {
        	                	if(itemphong.getTrangThai().equals("Đã đặt")) {
        	                		//String maPhong, String tang,String loaiPhong, String tenKhachHang, String sdt, String thoiGianDat, String thoiGianNhan, String thoiGianTra, String soLuongNguoiThue, String hinhThucThue
        	                		String thoiGianDat = phieuDatPhongDao.getThongTinForNhanPhong("ThoiGianDat",itemphong.getMaPhong());
        	                		String thoiGianNhan = phieuDatPhongDao.getThongTinForNhanPhong("ThoiGianNhan", itemphong.getMaPhong());
        	                		String thoiGianTra = phieuDatPhongDao.getThongTinForNhanPhong("ThoiGianTra", itemphong.getMaPhong());
        	                		String soLuongNguoi = phieuDatPhongDao.getThongTinForNhanPhong("SoLuongNguoi", itemphong.getMaPhong());
        	                		String hinhThucThue = phieuDatPhongDao.getThongTinForNhanPhong("CachThue", itemphong.getMaPhong());
        	                		new NhanPhong(itemphong.getMaPhong(),itemphong.getTang(),itemphong.getLoaiPhong(),itemphong.getTenKhachHang(),itemphong.getSdt(),thoiGianDat,thoiGianNhan,thoiGianTra,soLuongNguoi,hinhThucThue);
        	                	}
        	                	else if(itemphong.getTrangThai().equals("Đang thuê")) {
        	                		
        	                	}
        	                }
        	            });

                        if(dsItemPhong.size() != 3) {
                            dsItemPhong.add(itemphong);
                        } else {
                            JPanel rowPanel = new JPanel();
                            rowPanel.setPreferredSize(new Dimension(itemPanel.getPreferredSize().width,150));
                            rowPanel.setBackground(Color.white);
                            rowPanel.setMaximumSize(new Dimension(Integer.MAX_VALUE, 150));
                            rowPanel.setLayout(new GridLayout(1, 3, 10, 10));
                            rowPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
                            dsItemPhong.forEach(x -> {
                                rowPanel.add(x);
                            });
                            itemPanel.add(rowPanel);
                            dsItemPhong.clear();
                            dsItemPhong.add(itemphong);
                        }
                    });

                if(!dsItemPhong.isEmpty()) {
                    int remain = 3 - dsItemPhong.size();
                    JPanel rowPanel = new JPanel();
                    rowPanel.setPreferredSize(new Dimension(itemPanel.getPreferredSize().width,150));
                    rowPanel.setBackground(Color.white);
                    rowPanel.setMaximumSize(new Dimension(Integer.MAX_VALUE, 150));
                    rowPanel.setLayout(new GridLayout(1, 3, 10, 10));
                    rowPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
                    dsItemPhong.forEach(x -> {
                        rowPanel.add(x);
                    });
                    for(int i = 0; i < remain; i++) {
                        JPanel pn = new JPanel();
                        pn.setBackground(Color.white);
                        rowPanel.add(pn);
                    }
                    itemPanel.add(rowPanel);
                    dsItemPhong.clear();
                }

                itemPanel.revalidate();
                itemPanel.repaint();
            }
        };

        
        cbbTrangThai.addActionListener(comboBoxListener);
        cbbLoaiPhong.addActionListener(comboBoxListener);
        cbbLau.addActionListener(comboBoxListener);

        JPanel main = new JPanel();
        main.setBackground(SystemColor.menu);
        main.setBorder(new EmptyBorder(0, 0, 10, 10));
        panel_1.add(main, BorderLayout.CENTER);
        main.setLayout(new BorderLayout(0, 0));
        
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        itemPanel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
        
        itemPanel.setBackground(new Color(255, 255, 255));
        
        dsPhong.forEach(item -> {
            itemPhong itemphong;
            if (item.getTrangThai().equals("Đã đặt")) {
                itemphong = phieuDatPhongDao.createItemPhongTheoMaPhong(item.getMaPhong(), "Đã đặt");
            } else if (item.getTrangThai().equals("Đang thuê")) {
            	itemphong = phieuDatPhongDao.createItemPhongTheoMaPhong(item.getMaPhong(), "Đang thuê");
            } else {
            	itemphong = phieuDatPhongDao.createItemPhongTheoMaPhong(item.getMaPhong(), "Trống");
            }
            
            itemphong.addMouseListener(new java.awt.event.MouseAdapter() {
                @Override
                public void mouseClicked(java.awt.event.MouseEvent e) {
                	if(itemphong.getTrangThai().equals("Đã đặt")) {
                		//String maPhong, String tang,String loaiPhong, String tenKhachHang, String sdt, String thoiGianDat, String thoiGianNhan, String thoiGianTra, String soLuongNguoiThue, String hinhThucThue
                		String thoiGianDat = phieuDatPhongDao.getThongTinForNhanPhong("ThoiGianDat",itemphong.getMaPhong());
                		String thoiGianNhan = phieuDatPhongDao.getThongTinForNhanPhong("ThoiGianNhan", itemphong.getMaPhong());
                		String thoiGianTra = phieuDatPhongDao.getThongTinForNhanPhong("ThoiGianTra", itemphong.getMaPhong());
                		String soLuongNguoi = phieuDatPhongDao.getThongTinForNhanPhong("SoLuongNguoi", itemphong.getMaPhong());
                		String hinhThucThue = phieuDatPhongDao.getThongTinForNhanPhong("CachThue", itemphong.getMaPhong());
                		new NhanPhong(itemphong.getMaPhong(),itemphong.getTang(),itemphong.getLoaiPhong(),itemphong.getTenKhachHang(),itemphong.getSdt(),thoiGianDat,thoiGianNhan,thoiGianTra,soLuongNguoi,hinhThucThue);
                	}
                	else if(itemphong.getTrangThai().equals("Đang thuê")) {
                		
                	}
                }
            });

            
            if(dsItemPhong.size() != 3) {
            	dsItemPhong.add(itemphong);
            }
            else {
            	JPanel rowPanel = new JPanel();
            	rowPanel.setPreferredSize(new Dimension(itemPanel.getPreferredSize().width,150));
            	rowPanel.setBackground(Color.white);
            	rowPanel.setMaximumSize(new Dimension(Integer.MAX_VALUE, 150));
            	rowPanel.setLayout(new GridLayout(1, 3, 10, 10));
            	rowPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
            	dsItemPhong.forEach(x -> {
            		rowPanel.add(x);
            	});
            	itemPanel.add(rowPanel);
            	dsItemPhong.clear();
            	
            	dsItemPhong.add(itemphong);
            }
            dsCurItemPhong.add(itemphong);
        });
        
        if(!dsItemPhong.isEmpty()) {
        	int remain = 3 - dsItemPhong.size();
        	JPanel rowPanel = new JPanel();
        	rowPanel.setPreferredSize(new Dimension(itemPanel.getPreferredSize().width,150));
        	rowPanel.setBackground(Color.white);
        	rowPanel.setMaximumSize(new Dimension(Integer.MAX_VALUE, 150));
        	rowPanel.setLayout(new GridLayout(1, 3, 10, 10));
        	rowPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        	dsItemPhong.forEach(x -> {
        		rowPanel.add(x);
        	});
        	for(int i = 0; i < remain; i++) {
        		JPanel pn = new JPanel();
        		pn.setBackground(Color.white);
        		rowPanel.add(pn);
        	}
        	itemPanel.add(rowPanel);
        	dsItemPhong.clear();
        }
        
        scrollPane.setViewportView(itemPanel);
        itemPanel.setLayout(new BoxLayout(itemPanel, BoxLayout.Y_AXIS));
        
        main.add(scrollPane, BorderLayout.CENTER);
        
    }
}
