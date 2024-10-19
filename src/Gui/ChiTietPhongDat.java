package Gui;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import com.toedter.calendar.JCalendar;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.RoundRectangle2D;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JDialog;

public class ChiTietPhongDat extends JPanel implements ActionListener{
	
	private RoundedButton btnDatTheoGio;
	private RoundedButton btnDatQuaDem;
	private RoundedButton btnDatTheoNgay;
	private RoundedButton btnHuy;
	private JTextField tfGioTu;
	private JTextField tfNgayTu;
	private JTextField tfGioDen;
	private JTextField tfNgayDen;
	private JTextField textField_4;
	private JButton btnCalendar1;
	private JButton btnCalendar2;
	private JLabel lblNewLabel;
	private String type;
	
	public ChiTietPhongDat(String type) {
		this.type = type;
		setLayout(new BorderLayout(0, 0));
		lblNewLabel = new JLabel();
		
		JPanel panel = new JPanel();
		add(panel, BorderLayout.NORTH);
		
		lblNewLabel.setText(type);
		
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new EmptyBorder(20, 20, 20, 20)); // padding: top, left, bottom, right
		panel_1.setLayout(new BorderLayout(0, 0));
		add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_2 = new JPanel();
		panel_1.add(panel_2, BorderLayout.NORTH);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		JLabel lbMaPhong = new JLabel("P001");
		lbMaPhong.setHorizontalAlignment(SwingConstants.CENTER);
		lbMaPhong.setFont(new Font("Tahoma", Font.BOLD, 20));
		panel_2.add(lbMaPhong, BorderLayout.NORTH);
		
		JPanel panel_3 = new JPanel();
		panel_1.add(panel_3, BorderLayout.CENTER);
		panel_3.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_5 = new JPanel();
		panel_3.add(panel_5, BorderLayout.NORTH);
		panel_5.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		
		JLabel lbThoiGian = new JLabel("Thời gian:");
		lbThoiGian.setFont(new Font("Tahoma", Font.BOLD, 15));
		panel_5.add(lbThoiGian);
		
		JPanel panel_6 = new JPanel();
		panel_3.add(panel_6, BorderLayout.CENTER);
		panel_6.setLayout(new GridLayout(3, 2, 0, 0));
		
		JPanel panel_7 = new JPanel();
		panel_6.add(panel_7);
		panel_7.setLayout(new BoxLayout(panel_7, BoxLayout.LINE_AXIS));
		
		JPanel panel_22 = new JPanel();
		panel_7.add(panel_22);
		
		JLabel lblNewLabel_1 = new JLabel("Từ:");
		panel_22.add(lblNewLabel_1);
		lblNewLabel_1.setAlignmentY(Component.BOTTOM_ALIGNMENT);
		lblNewLabel_1.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		JPanel panel_13 = new JPanel();
		panel_7.add(panel_13);
		
		tfGioTu = new JTextField();
		tfGioTu.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel_13.add(tfGioTu);
		tfGioTu.setColumns(10);
		
		JPanel panel_14 = new JPanel();
		panel_7.add(panel_14);
		String[] amPmOptions = {"AM", "PM"};
		JComboBox cbbGio = new JComboBox(amPmOptions);
		cbbGio.setFont(new Font("Tahoma", Font.BOLD, 15));
		panel_14.add(cbbGio);
		
		JPanel panel_8 = new JPanel();
		panel_6.add(panel_8);
		panel_8.setLayout(new BoxLayout(panel_8, BoxLayout.X_AXIS));
		
		JPanel panel_23 = new JPanel();
		panel_8.add(panel_23);
		
		JLabel lblNewLabel_2 = new JLabel("Ngày:");
		panel_23.add(lblNewLabel_2);
		lblNewLabel_2.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		JPanel panel_15 = new JPanel();
		panel_8.add(panel_15);
		
		tfNgayTu = new JTextField();
		tfNgayTu.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel_15.add(tfNgayTu);
		tfNgayTu.setColumns(10);
		
		JPanel panel_16 = new JPanel();
		panel_8.add(panel_16);
		
		btnCalendar1 = new JButton(new ImageIcon(Statistics.class.getResource("/Photos/calendar.png"))); // Thay JLabel bằng JButton
		btnCalendar1.setHorizontalAlignment(SwingConstants.LEADING);
		btnCalendar1.setBorderPainted(false);
		btnCalendar1.setContentAreaFilled(false);
		btnCalendar1.setFocusPainted(false);
		btnCalendar1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(type.equals("Đặt Phòng")) {
                	showCalendar(tfNgayTu);
                }
            }
        });
		
		if(type == "Thuê Phòng") {
			tfGioTu.setEditable(false);
			tfNgayTu.setEditable(false);
			cbbGio.setEnabled(false);
		}
		
		panel_16.add(btnCalendar1);
		
		JPanel panel_9 = new JPanel();
		panel_6.add(panel_9);
		panel_9.setLayout(new BoxLayout(panel_9, BoxLayout.X_AXIS));
		
		JPanel panel_24 = new JPanel();
		panel_9.add(panel_24);
		
		JLabel tf231 = new JLabel("Đến:");
		tf231.setFont(new Font("Tahoma", Font.BOLD, 15));
		panel_24.add(tf231);
		
		JPanel panel_17 = new JPanel();
		panel_9.add(panel_17);
		
		tfGioDen = new JTextField();
		tfGioDen.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel_17.add(tfGioDen);
		tfGioDen.setColumns(10);
		
		JPanel panel_18 = new JPanel();
		panel_9.add(panel_18);
		
		JComboBox cbbGio2 = new JComboBox(amPmOptions);
		cbbGio2.setFont(new Font("Tahoma", Font.BOLD, 15));
		panel_18.add(cbbGio2);
		
		JPanel panel_10 = new JPanel();
		panel_6.add(panel_10);
		panel_10.setLayout(new BoxLayout(panel_10, BoxLayout.X_AXIS));
		
		JPanel panel_25 = new JPanel();
		panel_10.add(panel_25);
		
		JLabel lblNewLabel_4 = new JLabel("Ngày:");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 15));
		panel_25.add(lblNewLabel_4);
		
		JPanel panel_19 = new JPanel();
		panel_10.add(panel_19);
		
		tfNgayDen = new JTextField();
		tfNgayDen.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel_19.add(tfNgayDen);
		tfNgayDen.setColumns(10);
		
		JPanel panel_20 = new JPanel();
		panel_10.add(panel_20);
		
		btnCalendar2 = new JButton(new ImageIcon(Statistics.class.getResource("/Photos/calendar.png"))); // Thay JLabel bằng JButton
		btnCalendar2.setHorizontalAlignment(SwingConstants.LEADING);
        btnCalendar2.setBorderPainted(false);
        btnCalendar2.setContentAreaFilled(false);
        btnCalendar2.setFocusPainted(false);
        btnCalendar2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showCalendar(tfNgayDen);
            }
        });
		panel_20.add(btnCalendar2);
		
		JPanel panel_11 = new JPanel();
		panel_6.add(panel_11);
		panel_11.setLayout(new BoxLayout(panel_11, BoxLayout.X_AXIS));
		
		JPanel panel_26 = new JPanel();
		panel_11.add(panel_26);
		
		JLabel lblNewLabel_5 = new JLabel("Số lượng người:");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 15));
		panel_26.add(lblNewLabel_5);
		
		JPanel panel_21 = new JPanel();
		panel_11.add(panel_21);
		
		textField_4 = new JTextField();
		textField_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel_21.add(textField_4);
		textField_4.setColumns(10);
		
		JPanel panel_12 = new JPanel();
		panel_6.add(panel_12);
		panel_12.setLayout(new BoxLayout(panel_12, BoxLayout.X_AXIS));
		
		JPanel panel_4 = new JPanel();
		panel_1.add(panel_4, BorderLayout.EAST);
		panel_4.setLayout(new BoxLayout(panel_4, BoxLayout.Y_AXIS));
		
		btnDatQuaDem = new RoundedButton("Đặt qua đêm");
		btnDatQuaDem.setForeground(Color.WHITE);
		btnDatQuaDem.setBackground(new Color(0, 153, 255));
		btnDatQuaDem.setFont(new Font("Tahoma", Font.BOLD, 15));
		setButtonSize(btnDatQuaDem);
		panel_4.add(btnDatQuaDem);
		panel_4.add(Box.createVerticalStrut(20));
		btnDatTheoGio = new RoundedButton("Đặt theo giờ");
		btnDatTheoGio.setForeground(Color.WHITE);
		btnDatTheoGio.setBackground(new Color(0, 153, 255));
		btnDatTheoGio.setFont(new Font("Tahoma", Font.BOLD, 15));
		setButtonSize(btnDatTheoGio);
		panel_4.add(btnDatTheoGio);
		panel_4.add(Box.createVerticalStrut(20));
		btnDatTheoNgay = new RoundedButton("Đặt theo ngày");
		btnDatTheoNgay.setForeground(Color.WHITE);
		btnDatTheoNgay.setBackground(new Color(0, 153, 255));
		btnDatTheoNgay.setFont(new Font("Tahoma", Font.BOLD, 15));
		setButtonSize(btnDatTheoNgay);
		panel_4.add(btnDatTheoNgay);
		panel_4.add(Box.createVerticalStrut(20));
		btnHuy = new RoundedButton("Hủy");
		btnHuy.setForeground(Color.WHITE);
		btnHuy.setBackground(new Color(255, 51, 51));
		btnHuy.setFont(new Font("Tahoma", Font.BOLD, 15));
		setButtonSize(btnHuy);
		
		tfGioTu.setPreferredSize(new Dimension(200, 30)); 
		tfNgayTu.setPreferredSize(new Dimension(200, 30));
		tfGioDen.setPreferredSize(new Dimension(200, 30));
		tfNgayDen.setPreferredSize(new Dimension(200, 30));
		textField_4.setPreferredSize(new Dimension(200, 30));
		
		btnHuy.addActionListener(this);
		panel_4.add(btnHuy);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if(o.equals(btnHuy)) {
			MainGUI main = new MainGUI();
			if(type.equals("Đặt Phòng")) main.openDatPhong();
			else main.openThuePhong();
		}
	}
	
	class RoundedButton extends JButton {
	    public RoundedButton(String label) {
	        super(label);
	        setFocusPainted(false);
	        setBorderPainted(false);
	        setContentAreaFilled(false);
	    }

	    @Override
	    protected void paintComponent(Graphics g) {
	        Graphics2D g2 = (Graphics2D) g.create();
	        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
	        g2.setColor(getBackground());
	        g2.fill(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), 20, 20));
	        super.paintComponent(g);
	    }

	    @Override
	    protected void paintBorder(Graphics g) {
	     
	    }
	}
	
	private void setButtonSize(JButton button) {
	    button.setAlignmentX(Component.CENTER_ALIGNMENT);
	    button.setPreferredSize(new Dimension(200, 40));
	    button.setMaximumSize(new Dimension(200, 40));
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
}
