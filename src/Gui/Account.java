package Gui;

import javax.swing.*;
import javax.swing.border.EmptyBorder; // Import EmptyBorder
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.table.DefaultTableModel; // Import DefaultTableModel
import javax.swing.table.TableCellRenderer;

import Dao.NhanVien_dao;
import Dao.TaiKhoan_dao;
import Entity.TaiKhoan;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class Account extends JPanel implements ActionListener, MouseListener {
    private JTextField tfTimKiem;
    private JTextField textField;
    private JTextField textField_1;
    private JTextField textField_2;
    private JTextField textField_3;
    private JTextField textField_4;
    private ArrayList<TaiKhoan> dsTK;
    private NhanVien_dao nhanVien_dao = new NhanVien_dao();
    private TaiKhoan_dao taiKhoan_dao = new TaiKhoan_dao();
	private JTable table;
	private DefaultTableModel model;
	private JButton btnTimKiem;
	private JButton btnSua;
	private JButton btnXacNhan;
	private JButton btnHuy;
	private JButton btnThem;
	private int row = -1;
	private int luaChon = 0;
	
	public ArrayList<TaiKhoan> danhSachTaiKhoan(){
		return taiKhoan_dao.danhSachTaiKhoan();
	}
	
	public void khoaTruong() {
        textField.setEditable(false);
        textField_1.setEditable(false);
        textField_2.setEditable(false);
        textField_3.setEditable(false);
        textField_4.setEditable(false);
	}
	
	public void moTruongThem () {
		textField.setEditable(false);
		textField_1.setEditable(false);
        textField_2.setEditable(true);
        textField_3.setEditable(true);
        textField_4.setEditable(true);
	}
	
	public void moTruongSua (){
		textField.setEditable(false);
		textField_1.setEditable(false);
        textField_2.setEditable(true);
        textField_3.setEditable(true);
        textField_4.setEditable(false);
	}

    public void hienBang() {
    	dsTK = danhSachTaiKhoan();
    	dsTK.forEach(x -> themDong(x));
    }
    
    public void themDong(TaiKhoan a) {
		model.addRow(new Object[] {a.getMaTK(),
				a.getTenDN(),
				a.getMatKhau(),
				a.getNhanVien().getMaNV(),
				a.getTrangThai()});
	}
    
    public void xoaTrang() {
    	textField.setText("");
    	textField_1.setText("");
    	textField_2.setText("");
    	textField_3.setText("");
    	textField_4.setText("");
    }
    
    public void hienTaiKhoan (TaiKhoan a) {
    	textField.setText(a.getMaTK());
		textField_1.setText(a.getTenDN());
		textField_2.setText(a.getMatKhau());
		textField_3.setText(a.getNhanVien().getMaNV());
		textField_4.setText(a.getTrangThai());
    }
    
    public TaiKhoan taoTaiKhoan() {
    	return new TaiKhoan(textField.getText(),
				textField_1.getText(),
				textField_2.getText(),
				nhanVien_dao.getNhanVienTheoMa(textField_4.getText()),
				textField_3.getText());
    }
    
    public Account() {
        setLayout(new BorderLayout(0, 0));

        JPanel header = new JPanel();
        add(header, BorderLayout.NORTH);

        JLabel title = new JLabel("Quản Lý Tài Khoản");
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
        btnTimKiem.setIcon(new ImageIcon(Account.class.getResource("/Photos/search.png")));
        btnTimKiem.setFont(new Font("Tahoma", Font.PLAIN, 15));
        control.add(btnTimKiem);

        JPanel mainPane = new JPanel();
        body.add(mainPane, BorderLayout.CENTER);
        mainPane.setLayout(new BorderLayout(0, 0)); // Sử dụng BorderLayout cho mainPane

        // Thêm padding cho mainPane
        mainPane.setBorder(new EmptyBorder(20, 20, 20, 20)); // Thêm padding 20 pixel

        // Tạo bảng với các trường đã chỉ định
        String[] columnNames = {"Mã Tài Khoản", "Tên Đăng Nhập", "Mật Khẩu", "Mã NV", "Trạng Thái"};
        

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
        
        JPanel panel_13 = new JPanel();
        panel.add(panel_13);

        JLabel lblNewLabel = new JLabel("Mã Tài Khoản");
        panel_13.add(lblNewLabel);
        lblNewLabel.setVerticalAlignment(SwingConstants.TOP);
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);

        JPanel panel_6 = new JPanel();
        panel.add(panel_6);

        textField = new JTextField();
        textField.setEditable(false);
        textField.setFont(new Font("Tahoma", Font.PLAIN, 15));
        panel_6.add(textField);
        textField.setColumns(10);

        JPanel panel_1 = new JPanel();
        infor.add(panel_1);
        panel_1.setLayout(new GridLayout(1, 2, 0, 0));
        
        JPanel panel_14 = new JPanel();
        panel_1.add(panel_14);

        JLabel lblNewLabel_1 = new JLabel("Tên Đăng Nhập");
        panel_14.add(lblNewLabel_1);
        lblNewLabel_1.setVerticalAlignment(SwingConstants.TOP);
        lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);

        JPanel panel_7 = new JPanel();
        panel_1.add(panel_7);

        textField_1 = new JTextField();
        textField_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
        panel_7.add(textField_1);
        textField_1.setColumns(10);

        JPanel panel_2 = new JPanel();
        infor.add(panel_2);
        panel_2.setLayout(new GridLayout(1, 2, 0, 0));
        
        JPanel panel_15 = new JPanel();
        panel_2.add(panel_15);

        JLabel lblNewLabel_2 = new JLabel("Mật Khẩu");
        panel_15.add(lblNewLabel_2);
        lblNewLabel_2.setVerticalAlignment(SwingConstants.TOP);
        lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 15));

        JPanel panel_8 = new JPanel();
        panel_2.add(panel_8);

        textField_2 = new JTextField();
        textField_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
        panel_8.add(textField_2);
        textField_2.setColumns(10);

        JPanel panel_3 = new JPanel();
        infor.add(panel_3);
        panel_3.setLayout(new GridLayout(1, 2, 0, 0));
        
        JPanel panel_16 = new JPanel();
        panel_3.add(panel_16);

        JLabel lblNewLabel_3 = new JLabel("Trạng Thái");
        panel_16.add(lblNewLabel_3);
        lblNewLabel_3.setVerticalAlignment(SwingConstants.TOP);
        lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);

        JPanel panel_9 = new JPanel();
        panel_3.add(panel_9);

        textField_3 = new JTextField();
        textField_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
        panel_9.add(textField_3);
        textField_3.setColumns(10);

        JPanel panel_4 = new JPanel();
        infor.add(panel_4);
        panel_4.setLayout(new GridLayout(1, 2, 0, 0));
        
        JPanel panel_17 = new JPanel();
        panel_4.add(panel_17);

        JLabel lblNewLabel_4 = new JLabel("Mã Nhân Viên");
        panel_17.add(lblNewLabel_4);
        lblNewLabel_4.setVerticalAlignment(SwingConstants.TOP);
        lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 15));

        JPanel panel_12 = new JPanel();
        panel_4.add(panel_12);

        textField_4 = new JTextField();
        textField_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
        panel_12.add(textField_4);
        textField_4.setColumns(10);

        JPanel panel_5 = new JPanel();
        infor.add(panel_5);

        JPanel panel_10 = new JPanel();
        infor.add(panel_10);
        
        btnThem = new JButton("");
        btnThem.setBackground(Color.LIGHT_GRAY);
        btnThem.setIcon(new ImageIcon(Account.class.getResource("/Photos/plus.png")));
        panel_10.add(btnThem);
        
        btnSua = new JButton("");
        btnSua.setBackground(Color.LIGHT_GRAY);
        btnSua.setIcon(new ImageIcon(Account.class.getResource("/Photos/settings.png")));
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
        hienBang();
        khoaTruong();
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

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		int row = table.getSelectedRow();
		textField.setText(model.getValueAt(row, 0).toString());
		textField_1.setText(model.getValueAt(row, 1).toString());
		textField_2.setText(model.getValueAt(row, 2).toString());
		textField_4.setText(model.getValueAt(row, 3).toString());
		textField_3.setText(model.getValueAt(row, 4).toString());
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

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JButton btn= (JButton)e.getSource();
		
		if (btn.equals(btnTimKiem)) {
			TaiKhoan tk = new TaiKhoan();
			String timKiem = tfTimKiem.getText();
			if (timKiem.isEmpty()) {
				JOptionPane.showMessageDialog(this, "Nhập vào trường tìm kiếm");
			} else {
				tk = taiKhoan_dao.timTaiKhoan(timKiem);
				model.getDataVector().removeAllElements();
				themDong(tk);
			}
		}
		if (btn.equals(btnThem)) {
			xoaTrang();
			moTruongThem();
			luaChon = 1;
		}
		if (btn.equals(btnSua)) {
			row  = table.getSelectedRow();
			if(row>=0) {
				moTruongSua();
				luaChon = 2;
			}
			else{
				JOptionPane.showMessageDialog(this, "Cần chọn nhân viên");
			}
		}
		if (btn.equals(btnHuy)) {
			model.getDataVector().removeAllElements();
			xoaTrang();
			khoaTruong();
			hienBang();
			luaChon = 0;
			row = -1;
		}
		if (btn.equals(btnXacNhan)) {
    		if (luaChon == 1) {
    			TaiKhoan a = taoTaiKhoan();
    			boolean dung = taiKhoan_dao.themTaiKhoan(a);
    			if (dung==true) {
    				JOptionPane.showMessageDialog(this, "Thêm tài khoản mới thành công");
    			} else JOptionPane.showMessageDialog(this, "Thêm tài khoản mới không thành công");
    			model.getDataVector().removeAllElements();
    			hienBang();
    		} else if (luaChon == 2) {
    			TaiKhoan b = taoTaiKhoan();
				boolean dung = taiKhoan_dao.suaTaiKhoan(b);
				if (dung==true) {
    				JOptionPane.showMessageDialog(this, "Sửa tài khoản thành công");
    			} else JOptionPane.showMessageDialog(this, "Sửa tài khoản không thành công");
				model.getDataVector().removeAllElements();
				hienBang();
    		}
    		
    		xoaTrang();
    		khoaTruong();
    	}
	}
}
