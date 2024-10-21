package Gui;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.util.Date;

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
import java.text.SimpleDateFormat;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JDialog;

public class ChiTietPhongDat extends JPanel implements ActionListener{

	private static final long serialVersionUID = 1L;
	private RoundedButton btnDatTheoGio;
	private RoundedButton btnDatQuaDem;
	private RoundedButton btnDatTheoNgay;
	private RoundedButton btnHuy;
	private JTextField tfGioTu;
	private JTextField tfNgayTu;
	private JTextField tfGioDen;
	private JTextField tfNgayDen;
	private JTextField tfSoLuongNguoi;
	private JButton btnCalendar1;
	private JButton btnCalendar2;
	private JLabel lblNewLabel;
	private String type;
	private JComboBox<String> cbbGio;
	private JComboBox<String> cbbGio2;
	private MainGUI mainGUI;
	
	public ChiTietPhongDat(String type, MainGUI mainGUI) {
		this.mainGUI = mainGUI;
		this.type = type;
		setLayout(new BorderLayout(0, 0));
		lblNewLabel = new JLabel();
		
		JPanel panel = new JPanel();
		add(panel, BorderLayout.NORTH);
		
		lblNewLabel.setText(type);
		
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBorder(new EmptyBorder(20, 20, 20, 20)); // padding: top, left, bottom, right
		panel_1.setLayout(new BorderLayout(0, 0));
		add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 255, 255));
		panel_1.add(panel_2, BorderLayout.NORTH);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		JLabel lbMaPhong = new JLabel("P001");
		lbMaPhong.setBackground(new Color(255, 255, 255));
		lbMaPhong.setHorizontalAlignment(SwingConstants.CENTER);
		lbMaPhong.setFont(new Font("Tahoma", Font.BOLD, 20));
		panel_2.add(lbMaPhong, BorderLayout.NORTH);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(255, 255, 255));
		panel_1.add(panel_3, BorderLayout.CENTER);
		panel_3.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(new Color(255, 255, 255));
		panel_3.add(panel_5, BorderLayout.NORTH);
		panel_5.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		
		JLabel lbThoiGian = new JLabel("Thời gian:");
		lbThoiGian.setBackground(new Color(255, 255, 255));
		lbThoiGian.setFont(new Font("Tahoma", Font.BOLD, 15));
		panel_5.add(lbThoiGian);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBackground(new Color(255, 255, 255));
		panel_3.add(panel_6, BorderLayout.CENTER);
		panel_6.setLayout(new GridLayout(3, 2, 0, 0));
		
		JPanel panel_7 = new JPanel();
		panel_7.setBackground(new Color(255, 255, 255));
		panel_6.add(panel_7);
		panel_7.setLayout(new BoxLayout(panel_7, BoxLayout.LINE_AXIS));
		
		JPanel panel_22 = new JPanel();
		panel_22.setBackground(new Color(255, 255, 255));
		panel_7.add(panel_22);
		
		JLabel lblNewLabel_1 = new JLabel("Từ:");
		panel_22.add(lblNewLabel_1);
		lblNewLabel_1.setAlignmentY(Component.BOTTOM_ALIGNMENT);
		lblNewLabel_1.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		JPanel panel_13 = new JPanel();
		panel_13.setBackground(new Color(255, 255, 255));
		panel_7.add(panel_13);
		
		tfGioTu = new JTextField();
		tfGioTu.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel_13.add(tfGioTu);
		tfGioTu.setColumns(10);
		
		JPanel panel_14 = new JPanel();
		panel_14.setBackground(new Color(255, 255, 255));
		panel_7.add(panel_14);
		String[] amPmOptions = {"AM", "PM"};
		cbbGio = new JComboBox(amPmOptions);
		cbbGio.setFont(new Font("Tahoma", Font.BOLD, 15));
		panel_14.add(cbbGio);
		
		JPanel panel_8 = new JPanel();
		panel_8.setBackground(new Color(255, 255, 255));
		panel_6.add(panel_8);
		panel_8.setLayout(new BoxLayout(panel_8, BoxLayout.X_AXIS));
		
		JPanel panel_23 = new JPanel();
		panel_23.setBackground(new Color(255, 255, 255));
		panel_8.add(panel_23);
		
		JLabel lblNewLabel_2 = new JLabel("Ngày:");
		panel_23.add(lblNewLabel_2);
		lblNewLabel_2.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		JPanel panel_15 = new JPanel();
		panel_15.setBackground(new Color(255, 255, 255));
		panel_8.add(panel_15);
		
		tfNgayTu = new JTextField();
		tfNgayTu.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel_15.add(tfNgayTu);
		tfNgayTu.setColumns(10);
		
		JPanel panel_16 = new JPanel();
		panel_16.setBackground(new Color(255, 255, 255));
		panel_8.add(panel_16);
		
		btnCalendar1 = new JButton(new ImageIcon(Statistics.class.getResource("/Photos/calendar.png"))); // Thay JLabel bằng JButton
		btnCalendar1.setBackground(new Color(240, 240, 240));
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
		panel_9.setBackground(new Color(255, 255, 255));
		panel_6.add(panel_9);
		panel_9.setLayout(new BoxLayout(panel_9, BoxLayout.X_AXIS));
		
		JPanel panel_24 = new JPanel();
		panel_24.setBackground(new Color(255, 255, 255));
		panel_9.add(panel_24);
		
		JLabel tf231 = new JLabel("Đến:");
		tf231.setFont(new Font("Tahoma", Font.BOLD, 15));
		panel_24.add(tf231);
		
		JPanel panel_17 = new JPanel();
		panel_17.setBackground(new Color(255, 255, 255));
		panel_9.add(panel_17);
		
		tfGioDen = new JTextField();
		tfGioDen.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel_17.add(tfGioDen);
		tfGioDen.setColumns(10);
		
		JPanel panel_18 = new JPanel();
		panel_18.setBackground(new Color(255, 255, 255));
		panel_9.add(panel_18);
		
		cbbGio2 = new JComboBox(amPmOptions);
		cbbGio2.setFont(new Font("Tahoma", Font.BOLD, 15));
		panel_18.add(cbbGio2);
		
		JPanel panel_10 = new JPanel();
		panel_10.setBackground(new Color(255, 255, 255));
		panel_6.add(panel_10);
		panel_10.setLayout(new BoxLayout(panel_10, BoxLayout.X_AXIS));
		
		JPanel panel_25 = new JPanel();
		panel_25.setBackground(new Color(255, 255, 255));
		panel_10.add(panel_25);
		
		JLabel lblNewLabel_4 = new JLabel("Ngày:");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 15));
		panel_25.add(lblNewLabel_4);
		
		JPanel panel_19 = new JPanel();
		panel_19.setBackground(new Color(255, 255, 255));
		panel_10.add(panel_19);
		
		tfNgayDen = new JTextField();
		tfNgayDen.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel_19.add(tfNgayDen);
		tfNgayDen.setColumns(10);
		
		JPanel panel_20 = new JPanel();
		panel_20.setBackground(new Color(255, 255, 255));
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
		panel_11.setBackground(new Color(255, 255, 255));
		panel_6.add(panel_11);
		panel_11.setLayout(new BoxLayout(panel_11, BoxLayout.X_AXIS));
		
		JPanel panel_26 = new JPanel();
		panel_26.setBackground(new Color(255, 255, 255));
		panel_11.add(panel_26);
		
		JLabel lblNewLabel_5 = new JLabel("Số lượng người:");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 15));
		panel_26.add(lblNewLabel_5);
		
		JPanel panel_21 = new JPanel();
		panel_21.setBackground(new Color(255, 255, 255));
		panel_11.add(panel_21);
		
		tfSoLuongNguoi = new JTextField();
		tfSoLuongNguoi.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel_21.add(tfSoLuongNguoi);
		tfSoLuongNguoi.setColumns(10);
		
		JPanel panel_12 = new JPanel();
		panel_12.setBackground(new Color(255, 255, 255));
		panel_6.add(panel_12);
		panel_12.setLayout(new BoxLayout(panel_12, BoxLayout.X_AXIS));
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(255, 255, 255));
		panel_1.add(panel_4, BorderLayout.EAST);
		panel_4.setLayout(new BoxLayout(panel_4, BoxLayout.Y_AXIS));
		
		btnDatQuaDem = new RoundedButton("Đặt qua đêm");
		btnDatQuaDem.setForeground(Color.WHITE);
		btnDatQuaDem.setBackground(new Color(0, 153, 255));
		btnDatQuaDem.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnDatQuaDem.addActionListener(this);
		setButtonSize(btnDatQuaDem);
		panel_4.add(btnDatQuaDem);
		panel_4.add(Box.createVerticalStrut(20));
		btnDatTheoGio = new RoundedButton("Đặt theo giờ");
		btnDatTheoGio.setForeground(Color.WHITE);
		btnDatTheoGio.setBackground(new Color(0, 153, 255));
		btnDatTheoGio.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnDatTheoGio.addActionListener(this);
		setButtonSize(btnDatTheoGio);
		panel_4.add(btnDatTheoGio);
		panel_4.add(Box.createVerticalStrut(20));
		btnDatTheoNgay = new RoundedButton("Đặt theo ngày");
		btnDatTheoNgay.setForeground(Color.WHITE);
		btnDatTheoNgay.setBackground(new Color(0, 153, 255));
		btnDatTheoNgay.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnDatTheoNgay.addActionListener(this);
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
		tfSoLuongNguoi.setPreferredSize(new Dimension(200, 30));
		
		btnHuy.addActionListener(this);
		panel_4.add(btnHuy);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if(o.equals(btnHuy)) {
			if(type.equals("Đặt Phòng")) mainGUI.openDatPhong();
			else mainGUI.openThuePhong();
		}
		else {
			if(checkForm() == false) {
				return;
			}
			// openDatPhong
		}
	}
	
	class RoundedButton extends JButton {
		private static final long serialVersionUID = 1L;

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

	private boolean checkForm() {
	    String gioTu = tfGioTu.getText();
	    String ngayTu = tfNgayTu.getText();
	    String gioDen = tfGioDen.getText();
	    String ngayDen = tfNgayDen.getText();  
	    String soLuongNguoi = tfSoLuongNguoi.getText();
	    String ampmTu = cbbGio.getSelectedItem().toString();
	    String ampmDen = cbbGio2.getSelectedItem().toString();

	    if (gioTu.equals("") || ngayTu.equals("") || gioDen.equals("") || ngayDen.equals("") || soLuongNguoi.equals("")) {
	        JOptionPane.showMessageDialog(null, "Chưa điền đầy đủ thông tin!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
	        return false;
	    }

	    if (!gioTu.matches("^(0?[1-9]|1[0-2]):[0-5]\\d$") || !gioDen.matches("^(0?[1-9]|1[0-2]):[0-5]\\d$")) {
	        JOptionPane.showMessageDialog(null, "Giờ không hợp lệ. Định dạng phải là HH:mm (ví dụ: 12:59)", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
	        return false;
	    }

	    if (!ngayTu.matches("^\\d{2}/\\d{2}/\\d{4}$") || !ngayDen.matches("^\\d{2}/\\d{2}/\\d{4}$")) {
	        JOptionPane.showMessageDialog(null, "Ngày không hợp lệ. Định dạng phải là dd/MM/yyyy", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
	        return false;
	    }

	    if (!soLuongNguoi.matches("^[1-9]\\d*$")) {
	        JOptionPane.showMessageDialog(null, "Số lượng người phải là số nguyên dương", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
	        return false;
	    }

	    SimpleDateFormat sdfDateTime = new SimpleDateFormat("dd/MM/yyyy hh:mm a");
	    SimpleDateFormat sdfDate = new SimpleDateFormat("dd/MM/yyyy");

	    try {
	        Date dateTimeTu = sdfDateTime.parse(ngayTu + " " + gioTu + " " + ampmTu);
	        Date dateTimeDen = sdfDateTime.parse(ngayDen + " " + gioDen + " " + ampmDen);
	        Date currentDate = new Date();

	        if (dateTimeTu.before(currentDate)) {
	            JOptionPane.showMessageDialog(null, "Thời gian 'Từ' phải lớn hơn thời gian hiện tại", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
	            return false;
	        }

	        if (dateTimeTu.after(dateTimeDen)) {
	            JOptionPane.showMessageDialog(null, "Ngày 'Từ' phải nhỏ hơn hoặc bằng ngày 'Đến'", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
	            return false;
	        }
	    } catch (Exception e) {
	        JOptionPane.showMessageDialog(null, "Định dạng ngày/giờ không hợp lệ", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
	        return false;
	    }

	    return true;
	}



	
	private void showCalendar(JTextField textField) {
        JCalendar calendar = new JCalendar();
        JOptionPane optionPane = new JOptionPane(calendar, JOptionPane.PLAIN_MESSAGE, JOptionPane.OK_CANCEL_OPTION);
        JDialog dialog = optionPane.createDialog(this, "Chọn ngày");
        
        dialog.setVisible(true); 
        
        if (optionPane.getValue() != null && optionPane.getValue().equals(JOptionPane.OK_OPTION)) {
            java.util.Date selectedDate = calendar.getDate();
            String formattedDate = new java.text.SimpleDateFormat("dd/MM/yyyy").format(selectedDate);
            textField.setText(formattedDate);
        }
    }
}
