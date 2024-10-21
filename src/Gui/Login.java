package Gui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.*;
import ConnectDB.database;
import Dao.TaiKhoan_dao;

public class Login extends JFrame implements ActionListener {

    private JPanel contentPane;
    private static JTextField tfTenDangNhap;
    private static JPasswordField tfMatKhau;
    private static JButton btnDangNhap;
    private static TaiKhoan_dao taiKhoanDao;
    private static JCheckBox chboxShowHidePWD;

    public Login() {

        taiKhoanDao = new TaiKhoan_dao();

        try {
            database.getInstance().Connect();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Lỗi database vui lòng kiểm tra lại", "Lỗi", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
        setTitle("Quản Lý Khách Sạn");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(500, 400);
        setResizable(false);
        setLocationRelativeTo(null);

        contentPane = new JPanel() {
            private Image backgroundImage = new ImageIcon(getClass().getResource("/Photos/login.jpg")).getImage();

            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
            }
        };

        contentPane.setOpaque(true);
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel title = new JLabel("Đăng Nhập");
        title.setForeground(new Color(255, 255, 255));
        title.setBounds(173, 11, 147, 37);
        title.setFont(new Font("Tahoma", Font.BOLD, 24));
        contentPane.add(title);

        JLabel lbTenDangNhap = new JLabel("Tên đăng nhập");
        lbTenDangNhap.setForeground(new Color(255, 255, 255));
        lbTenDangNhap.setFont(new Font("Tahoma", Font.BOLD, 20));
        lbTenDangNhap.setBounds(60, 59, 171, 23);
        contentPane.add(lbTenDangNhap);

        tfTenDangNhap = new JTextField();
        tfTenDangNhap.setFont(new Font("Tahoma", Font.PLAIN, 17));
        tfTenDangNhap.setBounds(60, 93, 367, 42);
        contentPane.add(tfTenDangNhap);
        tfTenDangNhap.setColumns(10);

        JLabel lbMatKhau = new JLabel("Mật khẩu");
        lbMatKhau.setForeground(new Color(255, 255, 255));
        lbMatKhau.setFont(new Font("Tahoma", Font.BOLD, 20));
        lbMatKhau.setBounds(60, 153, 131, 25);
        contentPane.add(lbMatKhau);

        tfMatKhau = new JPasswordField();
        tfMatKhau.setFont(new Font("Tahoma", Font.PLAIN, 17));
        tfMatKhau.setColumns(10);
        tfMatKhau.setBounds(60, 189, 366, 42);
        contentPane.add(tfMatKhau);

        btnDangNhap = new JButton("Đăng Nhập");
        btnDangNhap.setFont(new Font("Tahoma", Font.BOLD, 20));
        btnDangNhap.setForeground(new Color(255, 255, 255));
        btnDangNhap.setBackground(new Color(0, 128, 255));
        btnDangNhap.setBounds(60, 269, 367, 42);
        contentPane.add(btnDangNhap);

        chboxShowHidePWD = new JCheckBox("Hiện mật khẩu");
        chboxShowHidePWD.setFont(new Font("Tahoma", Font.PLAIN, 17));
        chboxShowHidePWD.setBackground(new Color(0, 0, 0));
        chboxShowHidePWD.setForeground(new Color(255, 255, 255));
        chboxShowHidePWD.setBounds(60, 238, 147, 23);
        contentPane.add(chboxShowHidePWD);

        // Thêm KeyListener cho tfTenDangNhap và tfMatKhau để xử lý sự kiện Enter
        tfTenDangNhap.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    btnDangNhap.doClick(); // Kích hoạt sự kiện nhấn nút đăng nhập
                }
            }
        });

        tfMatKhau.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    btnDangNhap.doClick(); // Kích hoạt sự kiện nhấn nút đăng nhập
                }
            }
        });

        // add action listener
        btnDangNhap.addActionListener(this);
        chboxShowHidePWD.addActionListener(this);

        setResizable(false);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object o = e.getSource();
        if (o.equals(btnDangNhap)) {
            String tenDangNhap = tfTenDangNhap.getText();
            String matKhau = new String(tfMatKhau.getPassword());
            if (tenDangNhap.isEmpty() || matKhau.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Vui lòng điền đầy đủ thông tin!", "Lỗi", JOptionPane.ERROR_MESSAGE);
                return;
            }
            if (taiKhoanDao.checkTaiKhoan(tenDangNhap, matKhau)) {
                dispose();
                new flashForm(tenDangNhap, taiKhoanDao.getRole(tenDangNhap));
            } else {
                JOptionPane.showMessageDialog(this, "Tài khoản hoặc mật khẩu sai", "Lỗi", JOptionPane.ERROR_MESSAGE);
            }
        } else if (o.equals(chboxShowHidePWD)) {
            if (chboxShowHidePWD.isSelected()) {
                tfMatKhau.setEchoChar((char) 0);
            } else {
                tfMatKhau.setEchoChar('*');
            }
        }
    }
}
