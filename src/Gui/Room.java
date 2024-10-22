package Gui;

import javax.swing.*;
import javax.swing.border.EmptyBorder; // Import EmptyBorder
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.table.DefaultTableModel; // Import DefaultTableModel
import javax.swing.table.TableCellRenderer;

import Dao.LoaiPhong_dao;
import Dao.Phong_dao;
import Entity.KhachHang;
import Entity.Phong;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

public class Room extends JPanel implements ActionListener, MouseListener{
    private JTextField tfTimKiem;
    private JTextField tfMaPhong;
    private JTextField tfTrangThai;
    private JTextField tfTenLoaiPhong;
    private ArrayList<Phong> dsPhong;
    private Phong_dao phong_dao = new Phong_dao();
	private DefaultTableModel model;
	private JTable table;
	private JButton btnTimKiem;
	private JButton btnThem;
	private JButton btnSua;
	private JButton btnXacNhan;
	private JButton btnHuy;
	private JTextField tfLau;
	private LoaiPhong_dao loaiPhong_dao = new LoaiPhong_dao();
	private int luaChon = 0;
	private int row = -1;
    
    public ArrayList<Phong> danhSachPhong(){
    	return phong_dao.danhSachPhong();
    }
    
    public void khoaTrang () {
    	tfMaPhong.setEditable(false);
    	tfTrangThai.setEditable(false);
    	tfTenLoaiPhong.setEditable(false);
    	tfLau.setEditable(false);
    }
    
    public void moKhoaTruong() {
    	tfMaPhong.setEditable(false);
    	tfTrangThai.setEditable(true);
    	tfTenLoaiPhong.setEditable(true);
    	tfLau.setEditable(true);
    }
    
    public void hienTable() {
    	dsPhong = danhSachPhong();
    	model.getDataVector().removeAllElements();
    	dsPhong.forEach(x -> themDong(x));
    }
    
    public void themDong(Phong a) {
    	model.addRow(new Object[] {
    			a.getMaPhong(),
    			a.getTrangThai(),
    			a.getTang(),
    			a.getLoaiPhong().getTenLoaiPhong()
    	});
    }
    
    public void xoaTrang() {
    	tfMaPhong.setText("");
    	tfTrangThai.setText("");
    	tfTenLoaiPhong.setText("");
    	tfLau.setText("");
    	tfTimKiem.setText("");
    }

    public Room() {
        setLayout(new BorderLayout(0, 0));

        JPanel header = new JPanel();
        add(header, BorderLayout.NORTH);

        JLabel title = new JLabel("Quản Lý Phòng");
        title.setFont(new Font("Tahoma", Font.BOLD, 20));
        header.add(title);

        JPanel body = new JPanel();
        add(body, BorderLayout.CENTER);
        body.setLayout(new BorderLayout(0, 0));

        JPanel control = new JPanel();
        body.add(control, BorderLayout.NORTH);

        tfTimKiem = new JTextField();
        tfTimKiem.setFont(new Font("Tahoma", Font.PLAIN, 15));
        tfTimKiem.setPreferredSize(new Dimension(300, 40)); // Thay đổi kích thước ở đây
        control.add(tfTimKiem);

        btnTimKiem = new JButton("");
        btnTimKiem.setBackground(Color.LIGHT_GRAY);
        btnTimKiem.setIcon(new ImageIcon(Room.class.getResource("/Photos/search.png")));
        btnTimKiem.setFont(new Font("Tahoma", Font.PLAIN, 15));
        control.add(btnTimKiem);

        JPanel mainPane = new JPanel();
        body.add(mainPane, BorderLayout.CENTER);
        mainPane.setLayout(new BorderLayout(0, 0)); // Sử dụng BorderLayout cho mainPane

        // Thêm padding cho mainPane
        mainPane.setBorder(new EmptyBorder(20, 20, 20, 20)); // Thêm padding 20 pixel

        // Tạo bảng với các trường đã chỉ định
        String[] columnNames = {"Mã phòng","Trạng thái","Tầng","Tên loại phòng"};
         
        model = new DefaultTableModel(columnNames, 0);
        table = new JTable(model) {
            @Override
            public boolean isCellEditable(int row, int column) {
                // Không cho phép chỉnh sửa
                return false;
            }
        };

        // Tạo JScrollPane để chứa JTable
        JScrollPane scrollPane = new JScrollPane(table);
        mainPane.add(scrollPane, BorderLayout.CENTER); // Thêm JScrollPane vào mainPane

        JPanel infor = new JPanel();
        mainPane.add(infor, BorderLayout.NORTH);
        infor.setLayout(new GridLayout(4, 2, 0, 0));

        JPanel panel = new JPanel();
        infor.add(panel);
        panel.setLayout(new GridLayout(1, 2, 0, 0));
        
        JPanel panel_3 = new JPanel();
        panel.add(panel_3);

        JLabel lblNewLabel = new JLabel("Mã Phòng");
        panel_3.add(lblNewLabel);
        lblNewLabel.setVerticalAlignment(SwingConstants.TOP);
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);

        JPanel panel_6 = new JPanel();
        panel.add(panel_6);

        tfMaPhong = new JTextField();
        tfMaPhong.setEditable(false);
        tfMaPhong.setFont(new Font("Tahoma", Font.PLAIN, 15));
        panel_6.add(tfMaPhong);
        tfMaPhong.setColumns(10);

        JPanel panel_1 = new JPanel();
        infor.add(panel_1);
        panel_1.setLayout(new GridLayout(1, 2, 0, 0));
        
        JPanel panel_4 = new JPanel();
        panel_1.add(panel_4);

        JLabel lblNewLabel_1 = new JLabel("Trạng Thái");
        panel_4.add(lblNewLabel_1);
        lblNewLabel_1.setVerticalAlignment(SwingConstants.TOP);
        lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);

        JPanel panel_7 = new JPanel();
        panel_1.add(panel_7);

        tfTrangThai = new JTextField();
        tfTrangThai.setFont(new Font("Tahoma", Font.PLAIN, 15));
        panel_7.add(tfTrangThai);
        tfTrangThai.setColumns(10);

        JPanel panel_2 = new JPanel();
        infor.add(panel_2);
        panel_2.setLayout(new GridLayout(1, 2, 0, 0));
        
        JPanel panel_9 = new JPanel();
        panel_2.add(panel_9);

        JLabel lblNewLabel_2 = new JLabel("Tên Loại Phòng");
        panel_9.add(lblNewLabel_2);
        lblNewLabel_2.setVerticalAlignment(SwingConstants.TOP);
        lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 15));

        JPanel panel_8 = new JPanel();
        panel_2.add(panel_8);

        tfTenLoaiPhong = new JTextField();
        tfTenLoaiPhong.setFont(new Font("Tahoma", Font.PLAIN, 15));
        panel_8.add(tfTenLoaiPhong);
        tfTenLoaiPhong.setColumns(10);

        JPanel panel_5 = new JPanel();
        infor.add(panel_5);
        panel_5.setLayout(new GridLayout(1, 2, 0, 0));
        
        JPanel panel_12 = new JPanel();
        panel_5.add(panel_12);
        
        JLabel lbLau = new JLabel("Tầng");
        lbLau.setFont(new Font("Tahoma", Font.BOLD, 15));
        panel_12.add(lbLau);
        
        JPanel panel_13 = new JPanel();
        panel_5.add(panel_13);
        
        tfLau = new JTextField();
        tfLau.setFont(new Font("Tahoma", Font.PLAIN, 15));
        panel_13.add(tfLau);
        tfLau.setColumns(10);

        JPanel panel_10 = new JPanel();
        infor.add(panel_10);
        
        btnThem = new JButton("");
        btnThem.setBackground(Color.LIGHT_GRAY);
        btnThem.setIcon(new ImageIcon(Room.class.getResource("/Photos/plus.png")));
        panel_10.add(btnThem);
        
        btnSua = new JButton("");
        btnSua.setBackground(Color.LIGHT_GRAY);
        btnSua.setIcon(new ImageIcon(Room.class.getResource("/Photos/settings.png")));
        panel_10.add(btnSua);

        JPanel panel_11 = new JPanel();
        infor.add(panel_11);
        
        btnXacNhan = new JButton("Xác nhận");
        btnXacNhan.setBackground(Color.LIGHT_GRAY);
        btnXacNhan.setFont(new Font("Tahoma", Font.BOLD, 15));
        panel_11.add(btnXacNhan);
        
        btnHuy = new JButton("Hủy");
        btnHuy.setBackground(Color.LIGHT_GRAY);
        btnHuy.setFont(new Font("Tahoma", Font.BOLD, 15));
        panel_11.add(btnHuy);
        btnTimKiem.addActionListener(this);
        btnThem.addActionListener(this);
        btnSua.addActionListener(this);
        btnXacNhan.addActionListener(this);
        btnHuy.addActionListener(this);
        table.addMouseListener(this);
        khoaTrang();
        hienTable();
    }

    // Class cho ButtonRenderer (Không cần nữa vì đã bỏ cột Edit/Delete)
    class ButtonRenderer extends JButton implements TableCellRenderer {
        public ButtonRenderer() {
            setOpaque(true);
        }

        public Component getTableCellRendererComponent(JTable table, Object value,
                boolean isSelected, boolean hasFocus, int row) {
            setText((value == null) ? "" : value.toString());
            return this;
        }

		@Override
		public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
				int row, int column) {
			// TODO Auto-generated method stub
			return null;
		}
    }

    // Class cho ButtonEditor (Không cần nữa vì đã bỏ cột Edit/Delete)
    class ButtonEditor extends DefaultCellEditor {
        private JButton button;
        private String label;
        private boolean isPushed;

        public ButtonEditor(JCheckBox checkBox) {
            super(checkBox);
            button = new JButton();
            button.setOpaque(true);
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    fireEditingStopped(); // Ngừng chỉnh sửa
                }
            });
        }

        public Component getTableCellEditorComponent(JTable table, Object value,
                boolean isSelected, int row) {
            label = (value == null) ? "" : value.toString();
            button.setText(label);
            isPushed = true;
            return button;
        }

        public Object getCellEditorValue() {
            if (isPushed) {
                // Thực hiện hành động cho nút
                System.out.println(label + " pressed");
            }
            isPushed = false;
            return label;
        }
    }

    public Phong taoPhong() {
    	return new Phong(tfMaPhong.getText(),
    					tfTrangThai.getText(),
    					tfLau.getText(),
    					loaiPhong_dao.timLoaiPhong(tfTenLoaiPhong.getText()));
    }

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JButton btn= (JButton)e.getSource();
		
		if (btn.equals(btnTimKiem)) {
			String timKiem = tfTimKiem.getText();
			
			if (timKiem.isEmpty()) {
				JOptionPane.showMessageDialog(this, "Nhập vào trường tìm kiếm");
			} else {
				Phong phong = phong_dao.timPhongTheoMa(timKiem);
				model.getDataVector().removeAllElements();
				themDong(phong);
			}
//			if (kh == null && ds == null) {
//				model.getDataVector().removeAllElements();
//				JOptionPane.showMessageDialog(this, "Không tìm thấy");
//			}
//				
		}
		if (btn.equals(btnThem)) {
			xoaTrang();
			moKhoaTruong();
			luaChon = 1;
		}
		if (btn.equals(btnSua)) {
			row  = table.getSelectedRow();
			if(row>=0) {
				moKhoaTruong();
				luaChon = 2;
			}
			else{
				JOptionPane.showMessageDialog(this, "Cần chọn khách phòng");
			}
		}
		if (btn.equals(btnHuy)) {
			model.getDataVector().removeAllElements();
			xoaTrang();
			khoaTrang();
			hienTable();
			luaChon = 0;
			row = -1;
		}
		if (btn.equals(btnXacNhan)) {
    		if (luaChon == 1) {
    			Phong a = taoPhong();
    			boolean dung = phong_dao.themPhong(a, Integer.parseInt(a.getTang()));
    			if (dung==true) {
    				JOptionPane.showMessageDialog(this, "Thêm phòng mới thành công");
    			} else JOptionPane.showMessageDialog(this, "Thêm phòng mới không thành công");
    			model.getDataVector().removeAllElements();
    			hienTable();
    			
    		} else if (luaChon == 2) {
    			Phong b = taoPhong();
				boolean dung = phong_dao.suaPhong(b);
				if (dung==true) {
    				JOptionPane.showMessageDialog(this, "Sửa phòng thành công");
    			} else JOptionPane.showMessageDialog(this, "Sửa phòng không thành công");
				model.getDataVector().removeAllElements();
				hienTable();
    		}
    		
    		xoaTrang();
    		khoaTrang();
    	}
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		int row = table.getSelectedRow();
		tfMaPhong.setText(model.getValueAt(row, 0).toString());
		tfTrangThai.setText(model.getValueAt(row, 1).toString());
		tfTenLoaiPhong.setText(model.getValueAt(row, 3).toString());
		tfLau.setText(model.getValueAt(row, 2).toString());
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
