package Gui;

import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;

import Dao.NhanVien_dao;
import Dao.TaiKhoan_dao;
import Entity.TaiKhoan;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Dimension; // Thêm import cho Dimension
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class UserInfor extends JPanel implements ActionListener {
    private JTextField tfTenTaiKhoan;
    private JTextField tfTenNhanVien;
    private JTextField textField_2;
    private JButton btnDoiMatKhau;
    private TaiKhoan_dao taiKhoan_dao = new TaiKhoan_dao();
    private String userName1;
    private NhanVien_dao nhanVien_dao = new NhanVien_dao();
    private String role1;

    public void khoaTruong () {
    	tfTenTaiKhoan.setEditable(false);
    	tfTenNhanVien.setEditable(false);
    	textField_2.setEditable(false);
    }
    
    public UserInfor(String userName, String role) {
        setLayout(new BorderLayout(0, 0));

        JPanel header = new JPanel();
        add(header, BorderLayout.NORTH);

        JLabel title = new JLabel("Chi Tiết Tài Khoản");
        title.setFont(new Font("Tahoma", Font.BOLD, 20));
        header.add(title);

        JPanel body = new JPanel();
        body.setBackground(new Color(255, 255, 255));
        body.setBorder(new EmptyBorder(20, 40, 20, 40));
        body.setLayout(new BorderLayout(0, 0));

        JPanel mainPane = new JPanel();
        mainPane.setBorder(new EmptyBorder(20, 20, 20, 20));
        mainPane.setLayout(new BorderLayout(0, 0));
        body.add(mainPane);
        mainPane.setLayout(new GridLayout(3, 2, 10, 10));

        JLabel lbTenTaiKhoan = new JLabel("Tên tài khoản");
        lbTenTaiKhoan.setVerticalAlignment(SwingConstants.TOP);
        lbTenTaiKhoan.setHorizontalAlignment(SwingConstants.CENTER);
        lbTenTaiKhoan.setFont(new Font("Tahoma", Font.BOLD, 15));
        mainPane.add(lbTenTaiKhoan);

        JPanel panelTenTaiKhoan = new JPanel();
        mainPane.add(panelTenTaiKhoan);

        tfTenTaiKhoan = new JTextField();
        tfTenTaiKhoan.setFont(new Font("Tahoma", Font.PLAIN, 15));
        tfTenTaiKhoan.setPreferredSize(new Dimension(200, 40)); // Đặt chiều cao cho ô nhập
        panelTenTaiKhoan.add(tfTenTaiKhoan);
        tfTenTaiKhoan.setColumns(20);

        JLabel lbTenNhanVien = new JLabel("Tên nhân viên");
        lbTenNhanVien.setVerticalAlignment(SwingConstants.TOP);
        lbTenNhanVien.setHorizontalAlignment(SwingConstants.CENTER);
        lbTenNhanVien.setFont(new Font("Tahoma", Font.BOLD, 15));
        mainPane.add(lbTenNhanVien);

        JPanel panelTenNhanVien = new JPanel();
        mainPane.add(panelTenNhanVien);

        tfTenNhanVien = new JTextField();
        tfTenNhanVien.setFont(new Font("Tahoma", Font.PLAIN, 15));
        tfTenNhanVien.setPreferredSize(new Dimension(200, 40)); // Đặt chiều cao cho ô nhập
        panelTenNhanVien.add(tfTenNhanVien);
        tfTenNhanVien.setColumns(20);

        JLabel lbSoDienThoai = new JLabel("Số điện thoại");
        lbSoDienThoai.setVerticalAlignment(SwingConstants.TOP);
        lbSoDienThoai.setHorizontalAlignment(SwingConstants.CENTER);
        lbSoDienThoai.setFont(new Font("Tahoma", Font.BOLD, 15));
        mainPane.add(lbSoDienThoai);

        JPanel panel_2 = new JPanel();
        mainPane.add(panel_2);

        textField_2 = new JTextField();
        textField_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
        textField_2.setPreferredSize(new Dimension(200, 40)); // Đặt chiều cao cho ô nhập
        panel_2.add(textField_2);
        textField_2.setColumns(20);

        add(body, BorderLayout.CENTER);

        JPanel panelDoiMatKhau = new JPanel();
        body.add(panelDoiMatKhau, BorderLayout.SOUTH);

        btnDoiMatKhau = new JButton("Đổi mật khẩu");
        btnDoiMatKhau.setForeground(Color.WHITE);
        btnDoiMatKhau.setFont(new Font("Tahoma", Font.BOLD, 15));
        btnDoiMatKhau.setBackground(new Color(0, 153, 255));
        panelDoiMatKhau.add(btnDoiMatKhau);
        btnDoiMatKhau.addActionListener(this);
        TaiKhoan a = taiKhoan_dao.timTaiKhoan(userName);
        khoaTruong();
        userName1 = userName;
        role1 = role;
        tfTenTaiKhoan.setText(a.getTenDN());
        tfTenNhanVien.setText(a.getNhanVien().getHoTen());
        textField_2.setText(a.getNhanVien().getSoDT());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object o = e.getSource();
        if (o.equals(btnDoiMatKhau)) {
            // Tạo cửa sổ đổi mật khẩu
            JDialog dialog = new JDialog();
            dialog.setTitle("Đổi Mật Khẩu");
            dialog.setModal(true);
            dialog.setSize(300, 200);
            dialog.setLocationRelativeTo(null); // Đặt cửa sổ ở giữa màn hình

            JPanel panel = new JPanel();
            panel.setBorder(new EmptyBorder(10, 10, 10, 10)); // padding: top, left, bottom, right
            panel.setLayout(new GridLayout(4, 2, 10, 10));

            // Trường nhập mật khẩu hiện tại
            JLabel lbMatKhauHienTai = new JLabel("Mật khẩu hiện tại:");
            JPasswordField tfMatKhauHienTai = new JPasswordField();
            panel.add(lbMatKhauHienTai);
            panel.add(tfMatKhauHienTai);

            // Trường nhập mật khẩu mới
            JLabel lbMatKhauMoi = new JLabel("Mật khẩu mới:");
            JPasswordField tfMatKhauMoi = new JPasswordField();
            panel.add(lbMatKhauMoi);
            panel.add(tfMatKhauMoi);

            // Nút xác nhận
            JButton btnXacNhan = new JButton("Xác nhận");
            btnXacNhan.setForeground(Color.WHITE);
            btnXacNhan.setFont(new Font("Tahoma", Font.BOLD, 15));
            btnXacNhan.setBackground(new Color(0, 153, 255));
            panel.add(new JLabel()); // Ô trống
            panel.add(btnXacNhan);

            dialog.add(panel);

            btnXacNhan.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String matKhauHienTai = new String(tfMatKhauHienTai.getPassword());
                    String matKhauMoi = new String(tfMatKhauMoi.getPassword());

                    // Kiểm tra mật khẩu và thực hiện đổi mật khẩu
                    if (validateCurrentPassword(matKhauHienTai)) {
                        // Thực hiện đổi mật khẩu ở đây
                        changePassword(matKhauMoi);
                        JOptionPane.showMessageDialog(dialog, "Đổi mật khẩu thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                        dialog.dispose();
                    } else {
                        JOptionPane.showMessageDialog(dialog, "Mật khẩu hiện tại không đúng!", "Lỗi", JOptionPane.ERROR_MESSAGE);
                    }
                }
            });

            dialog.setVisible(true); // Hiển thị cửa sổ
        }
    }

    // Phương thức kiểm tra mật khẩu hiện tại (giả định)
    private boolean validateCurrentPassword(String currentPassword) {
    	return taiKhoan_dao.timTaiKhoan(userName1).getMatKhau().equals(currentPassword); // Giả định mật khẩu cũ là "matkhaucu"
    }

    // Phương thức để đổi mật khẩu (giả định)
    private void changePassword(String newPassword) {
    	TaiKhoan a = new TaiKhoan("", userName1, newPassword, nhanVien_dao.getNhanVienTheoMa(userName1), "Đang sử dụng");
    	taiKhoan_dao.suaTaiKhoan(a);
        System.out.println("Mật khẩu mới đã được thay đổi thành: " + newPassword);
    }
}
