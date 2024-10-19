package Gui;

import javax.swing.*;
import javax.swing.border.EmptyBorder; // Import EmptyBorder
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.table.DefaultTableModel; // Import DefaultTableModel
import javax.swing.table.TableCellRenderer;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Employee extends JPanel {
    private JTextField tfTimKiem;
    private JTextField tfMaNhanVien;
    private JTextField textField_1;
    private JTextField textField_2;
    private JTextField textField_3;
    private JTextField textField_4;
    private JTextField textField_5;
    private JTextField textField_6;
    private JTextField textField_7;

    public Employee() {
        setLayout(new BorderLayout(0, 0));

        JPanel header = new JPanel();
        add(header, BorderLayout.NORTH);

        JLabel title = new JLabel("Quản Lý Nhân Viên");
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

        JButton btnTimKiem = new JButton("");
        btnTimKiem.setBackground(Color.LIGHT_GRAY);
        btnTimKiem.setIcon(new ImageIcon(Employee.class.getResource("/Photos/search.png")));
        btnTimKiem.setFont(new Font("Tahoma", Font.PLAIN, 15));
        control.add(btnTimKiem);

        JPanel mainPane = new JPanel();
        body.add(mainPane, BorderLayout.CENTER);
        mainPane.setLayout(new BorderLayout(0, 0)); // Sử dụng BorderLayout cho mainPane

        // Thêm padding cho mainPane
        mainPane.setBorder(new EmptyBorder(20, 20, 20, 20)); // Thêm padding 20 pixel

        // Tạo bảng với các trường đã chỉ định
        String[] columnNames = {"Mã nhân viên","Họ tên","Giới tính","Ngày sinh","CCCD","Số điện thoại","Chức vụ","Trạng thái làm việc"};
        Object[][] data = {
            {"NV001", "NGUYENA", "NAM", "06/02/2004", "99321","0323131","Nhân viên","Đang làm việc"}
        }; // Dữ liệu khởi tạo cho bảng

        DefaultTableModel model = new DefaultTableModel(data, columnNames);
        JTable table = new JTable(model) {
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
        infor.setLayout(new GridLayout(5, 2, 0, 0));

        JPanel panel = new JPanel();
        infor.add(panel);
        panel.setLayout(new GridLayout(1, 2, 0, 0));
        
        JPanel panel_16 = new JPanel();
        panel.add(panel_16);

        JLabel lblNewLabel = new JLabel("Mã Nhân Viên");
        panel_16.add(lblNewLabel);
        lblNewLabel.setVerticalAlignment(SwingConstants.TOP);
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);

        JPanel panel_6 = new JPanel();
        panel.add(panel_6);

        tfMaNhanVien = new JTextField();
        tfMaNhanVien.setEditable(false);
        tfMaNhanVien.setFont(new Font("Tahoma", Font.PLAIN, 15));
        panel_6.add(tfMaNhanVien);
        tfMaNhanVien.setColumns(10);

        JPanel panel_1 = new JPanel();
        infor.add(panel_1);
        panel_1.setLayout(new GridLayout(1, 2, 0, 0));
        
        JPanel panel_17 = new JPanel();
        panel_1.add(panel_17);

        JLabel tfHoTen = new JLabel("Họ Tên");
        panel_17.add(tfHoTen);
        tfHoTen.setVerticalAlignment(SwingConstants.TOP);
        tfHoTen.setFont(new Font("Tahoma", Font.BOLD, 15));
        tfHoTen.setHorizontalAlignment(SwingConstants.CENTER);

        JPanel panel_7 = new JPanel();
        panel_1.add(panel_7);

        textField_1 = new JTextField();
        textField_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
        panel_7.add(textField_1);
        textField_1.setColumns(10);

        JPanel panel_2 = new JPanel();
        infor.add(panel_2);
        panel_2.setLayout(new GridLayout(1, 2, 0, 0));
        
        JPanel panel_18 = new JPanel();
        panel_2.add(panel_18);

        JLabel tfGioiTinh = new JLabel("GioiTinh");
        panel_18.add(tfGioiTinh);
        tfGioiTinh.setVerticalAlignment(SwingConstants.TOP);
        tfGioiTinh.setHorizontalAlignment(SwingConstants.CENTER);
        tfGioiTinh.setFont(new Font("Tahoma", Font.BOLD, 15));

        JPanel panel_8 = new JPanel();
        panel_2.add(panel_8);

        textField_2 = new JTextField();
        textField_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
        panel_8.add(textField_2);
        textField_2.setColumns(10);

        JPanel panel_3 = new JPanel();
        infor.add(panel_3);
        panel_3.setLayout(new GridLayout(1, 2, 0, 0));
        
        JPanel panel_19 = new JPanel();
        panel_3.add(panel_19);

        JLabel tfNgaySinh = new JLabel("Ngày Sinh");
        panel_19.add(tfNgaySinh);
        tfNgaySinh.setVerticalAlignment(SwingConstants.TOP);
        tfNgaySinh.setFont(new Font("Tahoma", Font.BOLD, 15));
        tfNgaySinh.setHorizontalAlignment(SwingConstants.CENTER);

        JPanel panel_9 = new JPanel();
        panel_3.add(panel_9);

        textField_3 = new JTextField();
        textField_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
        panel_9.add(textField_3);
        textField_3.setColumns(10);

        JPanel panel_4 = new JPanel();
        infor.add(panel_4);
        panel_4.setLayout(new GridLayout(1, 2, 0, 0));
        
        JPanel panel_20 = new JPanel();
        panel_4.add(panel_20);

        JLabel tfCCCD = new JLabel("CCCD");
        panel_20.add(tfCCCD);
        tfCCCD.setVerticalAlignment(SwingConstants.TOP);
        tfCCCD.setHorizontalAlignment(SwingConstants.CENTER);
        tfCCCD.setFont(new Font("Tahoma", Font.BOLD, 15));

        JPanel panel_12 = new JPanel();
        panel_4.add(panel_12);

        textField_4 = new JTextField();
        textField_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
        panel_12.add(textField_4);
        textField_4.setColumns(10);

        JPanel panel_5 = new JPanel();
        infor.add(panel_5);
        panel_5.setLayout(new GridLayout(1, 2, 0, 0));
        
        JPanel panel_21 = new JPanel();
        panel_5.add(panel_21);
        
        JLabel tfSoDienThoai = new JLabel("Số Điện Thoại");
        panel_21.add(tfSoDienThoai);
        tfSoDienThoai.setHorizontalAlignment(SwingConstants.CENTER);
        tfSoDienThoai.setFont(new Font("Tahoma", Font.BOLD, 15));
        
        JPanel panel_13 = new JPanel();
        panel_5.add(panel_13);
        
        textField_5 = new JTextField();
        textField_5.setFont(new Font("Tahoma", Font.PLAIN, 15));
        panel_13.add(textField_5);
        textField_5.setColumns(10);
        
        JPanel panel_14 = new JPanel();
        infor.add(panel_14);
        panel_14.setLayout(new GridLayout(1, 2, 0, 0));
        
        JPanel panel_22 = new JPanel();
        panel_14.add(panel_22);
        
        JLabel tfChucVu = new JLabel("Chức Vụ");
        panel_22.add(tfChucVu);
        tfChucVu.setHorizontalAlignment(SwingConstants.CENTER);
        tfChucVu.setFont(new Font("Tahoma", Font.BOLD, 15));
        
        JPanel panel_15 = new JPanel();
        panel_14.add(panel_15);
        
        textField_6 = new JTextField();
        textField_6.setFont(new Font("Tahoma", Font.PLAIN, 15));
        panel_15.add(textField_6);
        textField_6.setColumns(10);
        
        JPanel panel_14_1 = new JPanel();
        infor.add(panel_14_1);
        panel_14_1.setLayout(new GridLayout(1, 2, 0, 0));
        
        JPanel panel_23 = new JPanel();
        panel_14_1.add(panel_23);
        
        JLabel tfTrangThaiLamViec = new JLabel("Trạng Thái Làm Việc");
        panel_23.add(tfTrangThaiLamViec);
        tfTrangThaiLamViec.setHorizontalAlignment(SwingConstants.CENTER);
        tfTrangThaiLamViec.setFont(new Font("Tahoma", Font.BOLD, 15));
        
        JPanel panel_15_1 = new JPanel();
        panel_14_1.add(panel_15_1);
        
        textField_7 = new JTextField();
        textField_7.setFont(new Font("Tahoma", Font.PLAIN, 15));
        textField_7.setColumns(10);
        panel_15_1.add(textField_7);
        
        JPanel panel_10 = new JPanel();
        infor.add(panel_10);
        
        JButton btnThem = new JButton("");
        btnThem.setIcon(new ImageIcon(Employee.class.getResource("/Photos/plus.png")));
        btnThem.setBackground(Color.LIGHT_GRAY);
        panel_10.add(btnThem);
        
        JButton btnSua = new JButton("");
        btnSua.setIcon(new ImageIcon(Employee.class.getResource("/Photos/settings.png")));
        btnSua.setBackground(Color.LIGHT_GRAY);
        panel_10.add(btnSua);
        
        JPanel panel_11 = new JPanel();
        infor.add(panel_11);
        
        JButton btnXacNhan = new JButton("Xác nhận");
        btnXacNhan.setFont(new Font("Tahoma", Font.BOLD, 15));
        btnXacNhan.setBackground(Color.LIGHT_GRAY);
        panel_11.add(btnXacNhan);
        
        JButton btnHuy = new JButton("Hủy");
        btnHuy.setFont(new Font("Tahoma", Font.BOLD, 15));
        btnHuy.setBackground(Color.LIGHT_GRAY);
        panel_11.add(btnHuy);
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
}
