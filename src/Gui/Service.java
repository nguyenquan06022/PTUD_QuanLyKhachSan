package Gui;

import javax.swing.*;
import javax.swing.border.EmptyBorder; // Import EmptyBorder
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.table.DefaultTableModel; // Import DefaultTableModel
import javax.swing.table.TableCellRenderer;

import Dao.DichVu_dao;
import Entity.DichVu;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

public class Service extends JPanel implements ActionListener, MouseListener{
    private JTextField tfTimKiem;
    private JTextField tfMaDichVu;
    private JTextField tfTenDichVu;
    private JTextField tfDonGia;
    private JTextField tfTrangThai;
    private DichVu_dao dichVu_dao = new DichVu_dao();
	private ArrayList<DichVu> dsDV;
	private DefaultTableModel model;
	private JTable table;
	private JButton btnThem;
	private JButton btnSua;
	private JButton btnXacNhan;
	private JButton btnHuy;
	private JButton btnTimKiem;
	private int luaChon = 0;
	private int row = -1;
    
    public ArrayList<DichVu> danhSachDichVu(){
		return dichVu_dao.danhSachDichVu();
	}
	
	public void khoaTruong() {
        tfMaDichVu.setEditable(false);
        tfTenDichVu.setEditable(false);
        tfDonGia.setEditable(false);
        tfTrangThai.setEditable(false);
	}
	
	public void moTruongThem () {
		tfMaDichVu.setEditable(false);
        tfTenDichVu.setEditable(true);
        tfDonGia.setEditable(true);
        tfTrangThai.setEditable(false);
	}
	
	public void moTruongSua (){
		tfMaDichVu.setEditable(false);
        tfTenDichVu.setEditable(true);
        tfDonGia.setEditable(true);
        tfTrangThai.setEditable(true);
	}

    public void hienBang() {
    	dsDV = danhSachDichVu();
    	dsDV.forEach(x -> themDong(x));
    }
    
    public void themDong(DichVu a) {
		model.addRow(new Object[] {a.getMaDV(),
									a.getTenDV(),
									a.getDonGia(),
									a.getTrangThaiDichVu()});
	}
    
    public void xoaTrang() {
    	tfMaDichVu.setText("");
        tfTenDichVu.setText("");
        tfDonGia.setText("");
        tfTrangThai.setText("");
    }
    
    public void hienDichVu (DichVu a) {
    	tfMaDichVu.setText(a.getMaDV());
        tfTenDichVu.setText(a.getTenDV());
        tfDonGia.setText(String.valueOf(a.getDonGia()));
        tfTrangThai.setText(a.getTrangThaiDichVu());
    }
    
    public DichVu taoDichVu() {
    	return new DichVu(tfMaDichVu.getText(),
    						tfTenDichVu.getText(),
    						Double.parseDouble(tfDonGia.getText()),
    						tfTrangThai.getText());
    }

    public Service() {
        setLayout(new BorderLayout(0, 0));

        JPanel header = new JPanel();
        add(header, BorderLayout.NORTH);

        JLabel title = new JLabel("Quản Lý Dịch Vụ");
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
        btnTimKiem.setIcon(new ImageIcon(Service.class.getResource("/Photos/search.png")));
        btnTimKiem.setFont(new Font("Tahoma", Font.PLAIN, 15));
        control.add(btnTimKiem);

        JPanel mainPane = new JPanel();
        body.add(mainPane, BorderLayout.CENTER);
        mainPane.setLayout(new BorderLayout(0, 0)); // Sử dụng BorderLayout cho mainPane

        // Thêm padding cho mainPane
        mainPane.setBorder(new EmptyBorder(20, 20, 20, 20)); // Thêm padding 20 pixel

        // Tạo bảng với các trường đã chỉ định
        String[] columnNames = {"Mã dịch vụ","Tên dịch vụ","Đơn giá","Trạng thái"};

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
        infor.setLayout(new GridLayout(3, 2, 0, 0));

        JPanel panel = new JPanel();
        infor.add(panel);
        panel.setLayout(new GridLayout(1, 2, 0, 0));

        JLabel lblNewLabel = new JLabel("Mã Dịch Vụ");
        lblNewLabel.setVerticalAlignment(SwingConstants.TOP);
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(lblNewLabel);

        JPanel panel_6 = new JPanel();
        panel.add(panel_6);

        tfMaDichVu = new JTextField();
        tfMaDichVu.setEditable(false);
        tfMaDichVu.setFont(new Font("Tahoma", Font.PLAIN, 15));
        panel_6.add(tfMaDichVu);
        tfMaDichVu.setColumns(10);

        JPanel panel_1 = new JPanel();
        infor.add(panel_1);
        panel_1.setLayout(new GridLayout(1, 2, 0, 0));

        JLabel lblNewLabel_1 = new JLabel("Tên Dịch Vụ");
        lblNewLabel_1.setVerticalAlignment(SwingConstants.TOP);
        lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
        panel_1.add(lblNewLabel_1);

        JPanel panel_7 = new JPanel();
        panel_1.add(panel_7);

        tfTenDichVu = new JTextField();
        tfTenDichVu.setFont(new Font("Tahoma", Font.PLAIN, 15));
        panel_7.add(tfTenDichVu);
        tfTenDichVu.setColumns(10);

        JPanel panel_2 = new JPanel();
        infor.add(panel_2);
        panel_2.setLayout(new GridLayout(1, 2, 0, 0));

        JLabel lblNewLabel_2 = new JLabel("Đơn Giá");
        lblNewLabel_2.setVerticalAlignment(SwingConstants.TOP);
        lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 15));
        panel_2.add(lblNewLabel_2);

        JPanel panel_8 = new JPanel();
        panel_2.add(panel_8);

        tfDonGia = new JTextField();
        tfDonGia.setFont(new Font("Tahoma", Font.PLAIN, 15));
        panel_8.add(tfDonGia);
        tfDonGia.setColumns(10);

        JPanel panel_3 = new JPanel();
        infor.add(panel_3);
        panel_3.setLayout(new GridLayout(1, 2, 0, 0));

        JLabel lblNewLabel_3 = new JLabel("Trạng Thái");
        lblNewLabel_3.setVerticalAlignment(SwingConstants.TOP);
        lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
        panel_3.add(lblNewLabel_3);

        JPanel panel_9 = new JPanel();
        panel_3.add(panel_9);

        tfTrangThai = new JTextField();
        tfTrangThai.setFont(new Font("Tahoma", Font.PLAIN, 15));
        panel_9.add(tfTrangThai);
        tfTrangThai.setColumns(10);

        JPanel panel_10 = new JPanel();
        infor.add(panel_10);
        
        btnThem = new JButton("");
        btnThem.setBackground(Color.LIGHT_GRAY);
        btnThem.setIcon(new ImageIcon(Service.class.getResource("/Photos/plus.png")));
        panel_10.add(btnThem);
        
        btnSua = new JButton("");
        btnSua.setBackground(Color.LIGHT_GRAY);
        btnSua.setIcon(new ImageIcon(Service.class.getResource("/Photos/settings.png")));
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
        khoaTruong();
        hienBang();
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
		tfMaDichVu.setText(model.getValueAt(row, 0).toString());
		tfTenDichVu.setText(model.getValueAt(row, 1).toString());
		tfDonGia.setText(model.getValueAt(row, 2).toString());
		tfTrangThai.setText(model.getValueAt(row, 3).toString());
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
			String timKiem = tfTimKiem.getText();
			if (timKiem.isEmpty()) {
				JOptionPane.showMessageDialog(this, "Nhập vào trường tìm kiếm");
			} else {
				List<DichVu> dv  = dichVu_dao.getDichVuTheoTen(timKiem);
				model.getDataVector().removeAllElements();
				dv.forEach(x -> themDong(x));
			}
		}
		if (btn.equals(btnThem)) {
			xoaTrang();
			moTruongThem();
			tfTrangThai.setText("Đang sử dụng");
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
    			DichVu a = taoDichVu();
    			boolean dung = dichVu_dao.themDichVu(a);
    			if (dung==true) {
    				JOptionPane.showMessageDialog(this, "Thêm dịch vụ mới thành công");
    			} else JOptionPane.showMessageDialog(this, "Thêm dịch vụ mới không thành công");
    			model.getDataVector().removeAllElements();
    			hienBang();
    		} else if (luaChon == 2) {
    			DichVu b = taoDichVu();
				boolean dung = dichVu_dao.suaDichVu(b);
				if (dung==true) {
    				JOptionPane.showMessageDialog(this, "Sửa dịch vụ thành công");
    			} else JOptionPane.showMessageDialog(this, "Sửa dịch vụ không thành công");
				model.getDataVector().removeAllElements();
				hienBang();
    		}
    		
    		xoaTrang();
    		khoaTruong();
    	}
	}
}
