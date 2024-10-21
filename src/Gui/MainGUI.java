package Gui;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MainGUI extends JFrame implements ActionListener {

	private JPanel contentPane;

    private static JButton btnUser;
    private static JButton btnHome;
    private static JButton btnOrder;
    private static JButton btnRent;
    private static JButton btnManage;
    private static JButton btnStatistics;
    private static JButton btnSearch;
    private static JButton btnLogout;
    private static JButton selectedButton;
    private static JPanel body;
    private String userName1;
    private String role1;
    private Order order;
    private Rent rent;

    private JPopupMenu manageMenu;

    public static void removeBodyComponent() {
        body.removeAll();
        body.revalidate();
        body.repaint();
    }

    public MainGUI(String userName, String role) {
    	order = new Order(this);
    	rent = new Rent(this);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Quản Lý Khách Sạn");
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLocationRelativeTo(null);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(new BorderLayout(0, 0));

        JPanel navbar = new JPanel();
        navbar.setBackground(new Color(0, 153, 255));
        contentPane.add(navbar, BorderLayout.WEST);
        navbar.setLayout(new GridLayout(8, 3, 0, 0));

        btnUser = createNavbarButton(navbar, userName, "/Photos/multiple-user.png");
        btnHome = createNavbarButton(navbar, "Trang Chủ", "/Photos/home.png");
        btnOrder = createNavbarButton(navbar, "Đặt Phòng", "/Photos/order.png");
        btnRent = createNavbarButton(navbar, "Thuê Phòng", "/Photos/money.png");
        btnManage = createNavbarButton(navbar, "Quản Lý", "/Photos/project-management.png");
        btnStatistics = createNavbarButton(navbar, "Thống Kê", "/Photos/statistic.png");
        btnSearch = createNavbarButton(navbar, "Tra Cứu", "/Photos/research.png");
        btnLogout = createNavbarButton(navbar, "Đăng Xuất", "/Photos/logout.png");
        btnHome.setBackground(Color.gray);
        selectedButton = btnHome;
        
        // Tạo submenu cho "Quản Lý"
        manageMenu = new JPopupMenu();
        manageMenu.setBorder(new EmptyBorder(0, 0, 0, 0));  // Bỏ viền để submenu trông đẹp hơn

        // Danh sách các mục trong submenu
        JMenuItem accountItem = createSubmenuItem("Tài Khoản");
        JMenuItem employeeItem = createSubmenuItem("Nhân Viên");
        JMenuItem customerItem = createSubmenuItem("Khách Hàng");
        JMenuItem serviceItem = createSubmenuItem("Dịch Vụ");
        JMenuItem roomItem = createSubmenuItem("Phòng");

        // Thêm các mục vào popup menu
        manageMenu.add(accountItem);
        manageMenu.add(employeeItem);
        manageMenu.add(customerItem);
        manageMenu.add(serviceItem);
        manageMenu.add(roomItem);

        // Action listeners cho các mục submenu
        accountItem.addActionListener(e -> handleSubmenuSelection("account"));
        employeeItem.addActionListener(e -> handleSubmenuSelection("employee"));
        customerItem.addActionListener(e -> handleSubmenuSelection("customer"));
        serviceItem.addActionListener(e -> handleSubmenuSelection("service"));
        roomItem.addActionListener(e -> handleSubmenuSelection("room"));

        JPanel header = new JPanel();
        FlowLayout flowLayout = (FlowLayout) header.getLayout();
        flowLayout.setAlignment(FlowLayout.LEADING);
        header.setBackground(UIManager.getColor("Button.light"));
        contentPane.add(header, BorderLayout.NORTH);

        ImageIcon originalIcon = new ImageIcon(MainGUI.class.getResource("/Photos/logo.png"));
        Image scaledLogo = originalIcon.getImage().getScaledInstance(250, 120, Image.SCALE_SMOOTH);
        JLabel lbLogo = new JLabel(new ImageIcon(scaledLogo));
        lbLogo.setHorizontalAlignment(SwingConstants.LEADING);
        header.add(lbLogo, BorderLayout.WEST);

        ImageIcon originalHeaderIcon = new ImageIcon(MainGUI.class.getResource("/Photos/header-removebg-preview.png"));
        Image scaledHeaderImage = originalHeaderIcon.getImage().getScaledInstance(800, 120, Image.SCALE_SMOOTH);
        JLabel img = new JLabel(new ImageIcon(scaledHeaderImage));
        img.setHorizontalAlignment(SwingConstants.LEADING);
        header.add(img, BorderLayout.CENTER);

        body = new JPanel();
        contentPane.add(body, BorderLayout.CENTER);
        body.setLayout(new BorderLayout());
        body.add(new Home(),BorderLayout.CENTER);
        setVisible(true);
        userName1 = userName;
        role1 = role;
    }

    // Tạo các item cho submenu với màu sắc và hiệu ứng hover giống navbar
    private JMenuItem createSubmenuItem(String text) {
        JMenuItem item = new JMenuItem(text);
        item.setOpaque(true);
        item.setBackground(new Color(0, 153, 255));  // Màu nền giống navbar
        item.setForeground(Color.WHITE);  // Chữ màu trắng
        item.setFont(new Font("Tahoma", Font.BOLD, 17));  // Phông chữ đậm

        // Hiệu ứng hover: đổi màu khi di chuột vào
        item.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                item.setBackground(Color.gray);  // Đổi màu nền khi hover
            }

            @Override
            public void mouseExited(MouseEvent e) {
                item.setBackground(new Color(0, 153, 255));  // Trở lại màu gốc khi không hover
            }
        });
        return item;
    }

    private JButton createNavbarButton(JPanel navbar, String text, String iconPath) {
        JButton button = new JButton(text);
        button.setHorizontalAlignment(SwingConstants.LEFT);
        button.setIcon(new ImageIcon(MainGUI.class.getResource(iconPath)));
        button.setBackground(new Color(0, 153, 255));
        button.setForeground(Color.WHITE);
        button.setFont(new Font("Tahoma", Font.BOLD, 17));

        button.setBorderPainted(false);
        button.setContentAreaFilled(false);
        button.setFocusPainted(false);
        button.setOpaque(true);

        button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                if (selectedButton != button) {
                    button.setBackground(Color.gray);
                }
            }

            @Override
            public void mouseExited(MouseEvent e) {
                if (selectedButton != button) {
                    button.setBackground(new Color(0, 153, 255));
                }
            }

            @Override
            public void mouseClicked(MouseEvent e) {
                button.setBackground(Color.gray);
                if (selectedButton != null && selectedButton != button) {
                    selectedButton.setBackground(new Color(0, 153, 255));
                }
                selectedButton = button;
            }
        });

        button.addActionListener(this);
        navbar.add(button);
        return button;
    }

    private void handleSubmenuSelection(String menu) {
        removeBodyComponent();
        switch (menu) {
            case "account":
                body.add(new Account());
                break;
            case "employee":
                body.add(new Employee());
                break;
            case "customer":
                body.add(new Customer());
                break;
            case "service":
                body.add(new Service());
                break;
            case "room":
                body.add(new Room());
                break;
        }
        body.revalidate();
        body.repaint();
    }
    
    public void openThuePhong() {
    	removeBodyComponent();
    	body.add(rent, BorderLayout.CENTER);
    }
    
    public void openDatPhong() {
    	removeBodyComponent();
    	body.add(order, BorderLayout.CENTER);
    }
    
    public void openChiTietDatPhong(String type) {
    	removeBodyComponent();
    	body.add(new ChiTietPhongDat(type,this), BorderLayout.CENTER);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object o = e.getSource();
        if (o.equals(btnManage)) {
            manageMenu.show(btnManage, btnManage.getWidth(), btnManage.getHeight()); // Hiển thị submenu cạnh nút "Quản Lý"
        } else if (o.equals(btnLogout)) {
            int choice = JOptionPane.showConfirmDialog(null, "Bạn có chắc muốn đăng xuất?", "Xác nhận", JOptionPane.YES_NO_OPTION);
            if (choice == JOptionPane.YES_OPTION) {
                dispose();
                new Login();
            }
        } else if (o.equals(btnUser)) {
            removeBodyComponent();
            body.add(new UserInfor(userName1, role1),BorderLayout.CENTER);
        } else if (o.equals(btnHome)) {
            removeBodyComponent();
            body.add(new Home(),BorderLayout.CENTER);
        } else if (o.equals(btnOrder)) {
            removeBodyComponent();
            body.add(order,BorderLayout.CENTER);
        } else if (o.equals(btnRent)) {
            removeBodyComponent();
            body.add(rent,BorderLayout.CENTER);
        } else if (o.equals(btnStatistics)) {
            removeBodyComponent();
            body.add(new Statistics(),BorderLayout.CENTER);
        } else if (o.equals(btnSearch)) {
            removeBodyComponent();
            body.add(new Search(),BorderLayout.CENTER);
        }
    }
}
