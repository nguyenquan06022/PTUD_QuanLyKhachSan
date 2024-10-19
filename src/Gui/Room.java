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

public class Room extends JPanel {
    private JTextField tfTimKiem;
    private JTextField tfMaPhong;
    private JTextField tfTrangThai;
    private JTextField tfTenLoaiPhong;
    private JTextField textField;

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

        JButton btnTimKiem = new JButton("");
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
        String[] columnNames = {"Mã phòng","Trạng thái","Tên loại phòng","Lầu"};
        Object[][] data = {
            {"001", "Trống", "VIP","Lầu 1"}
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
        
        JLabel lbLau = new JLabel("Lầu");
        lbLau.setFont(new Font("Tahoma", Font.BOLD, 15));
        panel_12.add(lbLau);
        
        JPanel panel_13 = new JPanel();
        panel_5.add(panel_13);
        
        textField = new JTextField();
        textField.setFont(new Font("Tahoma", Font.PLAIN, 15));
        panel_13.add(textField);
        textField.setColumns(10);

        JPanel panel_10 = new JPanel();
        infor.add(panel_10);
        
        JButton btnThem = new JButton("");
        btnThem.setBackground(Color.LIGHT_GRAY);
        btnThem.setIcon(new ImageIcon(Room.class.getResource("/Photos/plus.png")));
        panel_10.add(btnThem);
        
        JButton btnSua = new JButton("");
        btnSua.setBackground(Color.LIGHT_GRAY);
        btnSua.setIcon(new ImageIcon(Room.class.getResource("/Photos/settings.png")));
        panel_10.add(btnSua);

        JPanel panel_11 = new JPanel();
        infor.add(panel_11);
        
        JButton btnXacNhan = new JButton("Xác nhận");
        btnXacNhan.setBackground(Color.LIGHT_GRAY);
        btnXacNhan.setFont(new Font("Tahoma", Font.BOLD, 15));
        panel_11.add(btnXacNhan);
        
        JButton btnHuy = new JButton("Hủy");
        btnHuy.setBackground(Color.LIGHT_GRAY);
        btnHuy.setFont(new Font("Tahoma", Font.BOLD, 15));
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
