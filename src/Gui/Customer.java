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

public class Customer extends JPanel {
    private JTextField tfTimKiem;
    private JTextField tfMaKhachHang;
    private JTextField tfHoTen;
    private JTextField tfSoDienThoai;
    private JTextField tfGioiTinh;
    private JTextField tfQuocTich;
    private JTextField tfDiemKhuyenMai;

    public Customer() {
        setLayout(new BorderLayout(0, 0));

        JPanel header = new JPanel();
        add(header, BorderLayout.NORTH);

        JLabel title = new JLabel("Quản Lý Khách Hàng");
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
        btnTimKiem.setIcon(new ImageIcon(Customer.class.getResource("/Photos/search.png")));
        btnTimKiem.setFont(new Font("Tahoma", Font.PLAIN, 15));
        control.add(btnTimKiem);

        JPanel mainPane = new JPanel();
        body.add(mainPane, BorderLayout.CENTER);
        mainPane.setLayout(new BorderLayout(0, 0)); // Sử dụng BorderLayout cho mainPane

        // Thêm padding cho mainPane
        mainPane.setBorder(new EmptyBorder(20, 20, 20, 20)); // Thêm padding 20 pixel

        // Tạo bảng với các trường đã chỉ định
        String[] columnNames = {"Mã Khách Hàng","Họ Tên","Số điện thoại","Giới tính","Quốc tịch","Điểm khuyến mãi"};
        Object[][] data = {
            {"005", "NguyenWuan", "123", "Nam", "VN","100"}
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
        infor.setLayout(new GridLayout(4, 2, 0, 0));

        JPanel panel = new JPanel();
        infor.add(panel);
        panel.setLayout(new GridLayout(1, 2, 0, 0));
        
        JPanel panel_14 = new JPanel();
        panel.add(panel_14);

        JLabel lblNewLabel = new JLabel("Mã Khách Hàng");
        panel_14.add(lblNewLabel);
        lblNewLabel.setVerticalAlignment(SwingConstants.TOP);
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);

        JPanel panel_6 = new JPanel();
        panel.add(panel_6);

        tfMaKhachHang = new JTextField();
        tfMaKhachHang.setEditable(false);
        tfMaKhachHang.setFont(new Font("Tahoma", Font.PLAIN, 15));
        panel_6.add(tfMaKhachHang);
        tfMaKhachHang.setColumns(10);

        JPanel panel_1 = new JPanel();
        infor.add(panel_1);
        panel_1.setLayout(new GridLayout(1, 2, 0, 0));
        
        JPanel panel_15 = new JPanel();
        panel_1.add(panel_15);

        JLabel lbHoTen = new JLabel("Họ Tên");
        panel_15.add(lbHoTen);
        lbHoTen.setVerticalAlignment(SwingConstants.TOP);
        lbHoTen.setFont(new Font("Tahoma", Font.BOLD, 15));
        lbHoTen.setHorizontalAlignment(SwingConstants.CENTER);

        JPanel panel_7 = new JPanel();
        panel_1.add(panel_7);

        tfHoTen = new JTextField();
        tfHoTen.setFont(new Font("Tahoma", Font.PLAIN, 15));
        panel_7.add(tfHoTen);
        tfHoTen.setColumns(10);

        JPanel panel_2 = new JPanel();
        infor.add(panel_2);
        panel_2.setLayout(new GridLayout(1, 2, 0, 0));
        
        JPanel panel_16 = new JPanel();
        panel_2.add(panel_16);

        JLabel lbSoDienThoai = new JLabel("Số Điện Thoại");
        panel_16.add(lbSoDienThoai);
        lbSoDienThoai.setVerticalAlignment(SwingConstants.TOP);
        lbSoDienThoai.setHorizontalAlignment(SwingConstants.CENTER);
        lbSoDienThoai.setFont(new Font("Tahoma", Font.BOLD, 15));

        JPanel panel_8 = new JPanel();
        panel_2.add(panel_8);

        tfSoDienThoai = new JTextField();
        tfSoDienThoai.setFont(new Font("Tahoma", Font.PLAIN, 15));
        panel_8.add(tfSoDienThoai);
        tfSoDienThoai.setColumns(10);

        JPanel panel_3 = new JPanel();
        infor.add(panel_3);
        panel_3.setLayout(new GridLayout(1, 2, 0, 0));
        
        JPanel panel_17 = new JPanel();
        panel_3.add(panel_17);

        JLabel lbGioiTinh = new JLabel("Giới Tính");
        panel_17.add(lbGioiTinh);
        lbGioiTinh.setVerticalAlignment(SwingConstants.TOP);
        lbGioiTinh.setFont(new Font("Tahoma", Font.BOLD, 15));
        lbGioiTinh.setHorizontalAlignment(SwingConstants.CENTER);

        JPanel panel_9 = new JPanel();
        panel_3.add(panel_9);

        tfGioiTinh = new JTextField();
        tfGioiTinh.setFont(new Font("Tahoma", Font.PLAIN, 15));
        panel_9.add(tfGioiTinh);
        tfGioiTinh.setColumns(10);

        JPanel panel_4 = new JPanel();
        infor.add(panel_4);
        panel_4.setLayout(new GridLayout(1, 2, 0, 0));
        
        JPanel panel_18 = new JPanel();
        panel_4.add(panel_18);

        JLabel lbQuocTich = new JLabel("Quốc Tịch");
        panel_18.add(lbQuocTich);
        lbQuocTich.setVerticalAlignment(SwingConstants.TOP);
        lbQuocTich.setHorizontalAlignment(SwingConstants.CENTER);
        lbQuocTich.setFont(new Font("Tahoma", Font.BOLD, 15));

        JPanel panel_12 = new JPanel();
        panel_4.add(panel_12);

        tfQuocTich = new JTextField();
        tfQuocTich.setFont(new Font("Tahoma", Font.PLAIN, 15));
        panel_12.add(tfQuocTich);
        tfQuocTich.setColumns(10);

        JPanel panel_5 = new JPanel();
        infor.add(panel_5);
        panel_5.setLayout(new GridLayout(1, 2, 0, 0));
        
        JPanel panel_19 = new JPanel();
        panel_5.add(panel_19);
        
        JLabel lbDiemKhuyenMai = new JLabel("Điểm khuyến mãi");
        panel_19.add(lbDiemKhuyenMai);
        lbDiemKhuyenMai.setHorizontalAlignment(SwingConstants.CENTER);
        lbDiemKhuyenMai.setFont(new Font("Tahoma", Font.BOLD, 15));
        
        JPanel panel_13 = new JPanel();
        panel_5.add(panel_13);
        
        tfDiemKhuyenMai = new JTextField();
        tfDiemKhuyenMai.setFont(new Font("Tahoma", Font.PLAIN, 15));
        panel_13.add(tfDiemKhuyenMai);
        tfDiemKhuyenMai.setColumns(10);
        
        JPanel panel_10 = new JPanel();
        infor.add(panel_10);
        
        JButton btnThem = new JButton("");
        btnThem.setIcon(new ImageIcon(Customer.class.getResource("/Photos/plus.png")));
        btnThem.setBackground(Color.LIGHT_GRAY);
        panel_10.add(btnThem);
        
        JButton btnSua = new JButton("");
        btnSua.setIcon(new ImageIcon(Customer.class.getResource("/Photos/settings.png")));
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
