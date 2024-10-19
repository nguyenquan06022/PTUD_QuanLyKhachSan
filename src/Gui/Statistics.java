package Gui;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.RoundRectangle2D;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import com.toedter.calendar.JCalendar; // Import JCalendar
import com.toedter.calendar.JDateChooser; // Import JDateChooser

public class Statistics extends JPanel {

    private JPanel control;
    private JTextField tfFrom;
    private JTextField tfTo;

    public Statistics() {
        setBackground(SystemColor.text);
        setLayout(new BorderLayout(0, 0));

        JPanel header = new JPanel();
        header.setBackground(SystemColor.menu);
        add(header, BorderLayout.NORTH);

        JLabel title = new JLabel("Thống Kê");
        title.setFont(new Font("Tahoma", Font.BOLD, 20));
        header.add(title);

        JPanel body = new JPanel();
        body.setBackground(SystemColor.text);
        add(body, BorderLayout.CENTER);
        body.setLayout(new BorderLayout(0, 0));

        JPanel Selection = new JPanel();
        Selection.setBackground(SystemColor.text);
        body.add(Selection, BorderLayout.NORTH);

        JButton btnRevenue = createCustomButton("Doanh Thu", Color.LIGHT_GRAY);
        Selection.add(btnRevenue);

        JButton btnService = createCustomButton("Dịch Vụ", Color.LIGHT_GRAY);
        Selection.add(btnService);

        JButton btnNewButton_2 = createCustomButton("Thuê Phòng", Color.LIGHT_GRAY);
        Selection.add(btnNewButton_2);

        JPanel mainPane = new JPanel();
        mainPane.setBackground(SystemColor.text);
        mainPane.setBorder(new EmptyBorder(20, 80, 20, 80)); // Thêm padding
        body.add(mainPane, BorderLayout.CENTER);
        mainPane.setLayout(new BorderLayout(0, 0));

        control = new JPanel();
        control.setVisible(false); // Ban đầu ẩn control
        mainPane.add(control, BorderLayout.CENTER);
        control.setLayout(new BorderLayout(0, 0));

        JLabel ControlHeader = new JLabel("Chọn Thời Gian Thống Kê");
        ControlHeader.setHorizontalAlignment(SwingConstants.CENTER);
        ControlHeader.setFont(new Font("Tahoma", Font.BOLD, 17));
        ControlHeader.setBorder(new EmptyBorder(20, 0, 20, 0)); // Thêm margin trên và dưới
        control.add(ControlHeader, BorderLayout.NORTH);

        JPanel ControlBody = new JPanel();
        control.add(ControlBody, BorderLayout.CENTER);
        ControlBody.setLayout(new GridLayout(1, 2, 0, 0));
        
        JPanel bodyLeft = new JPanel();
        ControlBody.add(bodyLeft);
        bodyLeft.setLayout(new BoxLayout(bodyLeft, BoxLayout.Y_AXIS));
        
        JPanel left1 = new JPanel();
        bodyLeft.add(left1);
        
        JRadioButton btnDay = new JRadioButton("Theo ngày");
        btnDay.setFont(new Font("Tahoma", Font.BOLD, 14));
        left1.add(btnDay);
        
        JPanel left2 = new JPanel();
        bodyLeft.add(left2);
        
        JRadioButton btnMonth = new JRadioButton("Theo tháng");
        btnMonth.setFont(new Font("Tahoma", Font.BOLD, 14));
        left2.add(btnMonth);
        
        JPanel left3 = new JPanel();
        bodyLeft.add(left3);
        
        JRadioButton btnYear = new JRadioButton("Theo năm");
        btnYear.setFont(new Font("Tahoma", Font.BOLD, 14));
        left3.add(btnYear);

        // Nhóm các nút radio
        ButtonGroup group = new ButtonGroup();
        group.add(btnDay);
        group.add(btnMonth);
        group.add(btnYear);
        
        JPanel bodyRight = new JPanel();
        ControlBody.add(bodyRight);
        bodyRight.setLayout(new BoxLayout(bodyRight, BoxLayout.Y_AXIS));
        
        JPanel right1 = new JPanel();
        bodyRight.add(right1);
        
        JLabel lbFrom = new JLabel("Từ");
        lbFrom.setFont(new Font("Tahoma", Font.BOLD, 15));
        right1.add(lbFrom);
        
        tfFrom = new JTextField();
        tfFrom.setFont(new Font("Tahoma", Font.PLAIN, 15));
        right1.add(tfFrom);
        tfFrom.setColumns(15);
        
        JButton btnCelendar1 = new JButton(new ImageIcon(Statistics.class.getResource("/Photos/calendar.png"))); // Thay JLabel bằng JButton
        btnCelendar1.setBorderPainted(false);
        btnCelendar1.setContentAreaFilled(false);
        btnCelendar1.setFocusPainted(false);
        btnCelendar1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showCalendar(tfFrom);
            }
        });
        right1.add(btnCelendar1);
        
        JPanel right2 = new JPanel();
        bodyRight.add(right2);
        
        JLabel lbTo = new JLabel("Đến");
        lbTo.setFont(new Font("Tahoma", Font.BOLD, 15));
        right2.add(lbTo);
        
        tfTo = new JTextField();
        tfTo.setFont(new Font("Tahoma", Font.PLAIN, 15));
        right2.add(tfTo);
        tfTo.setColumns(15);
        
        JButton btnCelendar2 = new JButton(new ImageIcon(Statistics.class.getResource("/Photos/calendar.png"))); // Thay JLabel bằng JButton
        btnCelendar2.setBorderPainted(false);
        btnCelendar2.setContentAreaFilled(false);
        btnCelendar2.setFocusPainted(false);
        btnCelendar2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showCalendar(tfTo);
            }
        });
        right2.add(btnCelendar2);

        JPanel right3 = new JPanel();
        bodyRight.add(right3);

        JPanel ControlFooter = new JPanel();
        control.add(ControlFooter, BorderLayout.SOUTH);

        JButton btnConfirm = createCustomConfirmCancelButton("Xác Nhận", new Color(0, 153, 255), Color.WHITE);
        ControlFooter.add(btnConfirm);

        JButton btnCancel = createCustomConfirmCancelButton("Hủy", Color.LIGHT_GRAY, Color.BLACK);
        ControlFooter.add(btnCancel);
        
        JPanel chart = new JPanel();
        
        JLabel chartContainer = new JLabel("chart");
        chart.add(chartContainer);

        btnRevenue.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setActiveButton(btnRevenue, btnService, btnNewButton_2);
                control.setVisible(true); // Hiện control khi nhấn nút Doanh Thu
            }
        });

        btnService.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setActiveButton(btnService, btnRevenue, btnNewButton_2);
                control.setVisible(true); // Hiện control khi nhấn nút Dịch Vụ
            }
        });

        btnNewButton_2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setActiveButton(btnNewButton_2, btnRevenue, btnService);
                control.setVisible(true); // Hiện control khi nhấn nút Thuê Phòng
            }
        });

        btnCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                control.setVisible(false); // Ẩn control khi nhấn nút Hủy
            }
        });
    }

    private void showCalendar(JTextField textField) {
        JCalendar calendar = new JCalendar();
        JOptionPane optionPane = new JOptionPane(calendar, JOptionPane.PLAIN_MESSAGE, JOptionPane.OK_CANCEL_OPTION);
        JDialog dialog = optionPane.createDialog(this, "Chọn ngày");
        
        dialog.setVisible(true); // Hiện dialog
        
        // Kiểm tra lựa chọn của người dùng
        if (optionPane.getValue() != null && optionPane.getValue().equals(JOptionPane.OK_OPTION)) {
            // Lấy ngày đã chọn và định dạng lại trước khi đưa vào JTextField
            java.util.Date selectedDate = calendar.getDate();
            // Chuyển đổi thành định dạng chuỗi
            String formattedDate = new java.text.SimpleDateFormat("dd/MM/yyyy").format(selectedDate);
            textField.setText(formattedDate); // Cập nhật ngày đã chọn vào JTextField
        }
    }

    private void setActiveButton(JButton activeButton, JButton... otherButtons) {
        // Đặt màu cho nút đang hoạt động
        activeButton.setBackground(new Color(0, 153, 255)); // Màu xanh
        activeButton.setForeground(Color.WHITE);
        
        for (JButton btn : otherButtons) {
            // Đặt lại màu cho các nút không hoạt động
            btn.setBackground(Color.LIGHT_GRAY); 
            btn.setForeground(Color.BLACK);
        }
    }

    private JButton createCustomConfirmCancelButton(String text, Color backgroundColor, Color foregroundColor) {
        JButton button = new JButton(text) {
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2 = (Graphics2D) g.create();
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                if (getModel().isPressed()) {
                    g2.setColor(backgroundColor.darker());
                } else {
                    g2.setColor(backgroundColor);
                }

                g2.fill(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), 30, 30)); // Bo góc 30px
                super.paintComponent(g2);
                g2.dispose();
            }
        };
        button.setFont(new Font("Tahoma", Font.BOLD, 15));
        button.setForeground(foregroundColor);
        button.setFocusPainted(false);
        button.setBorderPainted(false);
        button.setContentAreaFilled(false);
        return button;
    }

    private JButton createCustomButton(String text, Color backgroundColor) {
        JButton button = new JButton(text) {
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2 = (Graphics2D) g.create();
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g2.setColor(getBackground()); // Đặt màu nền dựa trên trạng thái
                g2.fill(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), 30, 30)); // Bo góc 30px
                super.paintComponent(g2);
                g2.dispose();
            }
        };
        button.setFont(new Font("Tahoma", Font.BOLD, 15));
        button.setForeground(Color.BLACK); // Màu chữ
        button.setFocusPainted(false);
        button.setBorderPainted(false);
        button.setContentAreaFilled(false);
        button.setBackground(backgroundColor); // Đặt màu nền cho nút
        return button;
    }
}
