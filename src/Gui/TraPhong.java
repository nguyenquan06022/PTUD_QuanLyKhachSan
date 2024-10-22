package Gui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;

public class TraPhong extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JButton btnTraPhong;
	private JButton btnHuy;

	public TraPhong(String maPhong, String tang,String loaiPhong, String tenKhachHang, String sdt, String thoiGianDat, String thoiGianNhan, String thoiGianTra, String soLuongNguoiThue, String hinhThucThue) {
		setTitle("Xác nhận nhận phòng");
		setSize(800,600);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		
		JLabel lblNewLabel = new JLabel("Nhận Phòng");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_2 = new JPanel();
		panel_1.add(panel_2, BorderLayout.NORTH);
		
		JLabel lblNewLabel_1 = new JLabel(tang + " - " + maPhong);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		panel_2.add(lblNewLabel_1);
		
		JPanel panel_3 = new JPanel();
		panel_1.add(panel_3, BorderLayout.CENTER);
		panel_3.setLayout(new GridLayout(4, 2, 0, 0));
		
		JPanel panel_4 = new JPanel();
		panel_3.add(panel_4);
		
		JLabel lblNewLabel_2 = new JLabel("Loại phòng");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		panel_4.add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setText(loaiPhong);
		textField.setEditable(false);
		textField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel_4.add(textField);
		textField.setColumns(10);
		
		JPanel panel_5 = new JPanel();
		panel_3.add(panel_5);
		
		JLabel lblNewLabel_3 = new JLabel("Tên khách hàng");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		panel_5.add(lblNewLabel_3);
		
		textField_1 = new JTextField();
		textField_1.setText(tenKhachHang);
		textField_1.setEditable(false);
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel_5.add(textField_1);
		textField_1.setColumns(10);
		
		JPanel panel_6 = new JPanel();
		panel_3.add(panel_6);
		
		JLabel lblNewLabel_4 = new JLabel("Số điện thoại");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 15));
		panel_6.add(lblNewLabel_4);
		
		textField_2 = new JTextField();
		textField_2.setText(sdt);
		textField_2.setEditable(false);
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel_6.add(textField_2);
		textField_2.setColumns(10);
		
		JPanel panel_7 = new JPanel();
		panel_3.add(panel_7);
		
		JLabel lblNewLabel_5 = new JLabel("Thời gian đặt");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 15));
		panel_7.add(lblNewLabel_5);
		
		textField_3 = new JTextField();
		textField_3.setText(thoiGianDat);
		textField_3.setEditable(false);
		textField_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel_7.add(textField_3);
		textField_3.setColumns(15);
		
		JPanel panel_8 = new JPanel();
		panel_3.add(panel_8);
		
		JLabel lblNewLabel_6 = new JLabel("Thời gian nhận");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 15));
		panel_8.add(lblNewLabel_6);
		
		textField_4 = new JTextField();
		textField_4.setText(thoiGianNhan);
		textField_4.setEditable(false);
		textField_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel_8.add(textField_4);
		textField_4.setColumns(15);
		
		JPanel panel_9 = new JPanel();
		panel_3.add(panel_9);
		
		JLabel lblNewLabel_7 = new JLabel("Thời gian trả");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 15));
		panel_9.add(lblNewLabel_7);
		
		textField_5 = new JTextField();
		textField_5.setText(thoiGianTra);
		textField_5.setEditable(false);
		textField_5.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel_9.add(textField_5);
		textField_5.setColumns(15);
		
		JPanel panel_10 = new JPanel();
		panel_3.add(panel_10);
		
		JLabel lblNewLabel_8 = new JLabel("Số lượng người thuê");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.BOLD, 15));
		panel_10.add(lblNewLabel_8);
		
		textField_6 = new JTextField();
		textField_6.setText(soLuongNguoiThue);
		textField_6.setEditable(false);
		textField_6.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel_10.add(textField_6);
		textField_6.setColumns(10);
		
		JPanel panel_11 = new JPanel();
		panel_3.add(panel_11);
		
		JLabel lblNewLabel_9 = new JLabel("Hình thức thuê");
		lblNewLabel_9.setFont(new Font("Tahoma", Font.BOLD, 15));
		panel_11.add(lblNewLabel_9);
		
		textField_7 = new JTextField();
		textField_7.setText(hinhThucThue);
		textField_7.setEditable(false);
		textField_7.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel_11.add(textField_7);
		textField_7.setColumns(10);
		
		JPanel panel_12 = new JPanel();
		contentPane.add(panel_12, BorderLayout.SOUTH);
		
		btnTraPhong = new JButton("Nhận phòng");
		btnTraPhong.setForeground(Color.WHITE);
		btnTraPhong.setBackground(new Color(0, 153, 255));
		btnTraPhong.setFont(new Font("Tahoma", Font.BOLD, 15));
		panel_12.add(btnTraPhong);
		
		btnHuy = new JButton("Hủy");
		btnHuy.setFont(new Font("Tahoma", Font.BOLD, 15));
		panel_12.add(btnHuy);
		
		btnTraPhong.addActionListener(this);
		btnHuy.addActionListener(this);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if(o.equals(btnTraPhong)) {
			
		}else if(o.equals(btnHuy)) {
			dispose();
		}
	}

}
