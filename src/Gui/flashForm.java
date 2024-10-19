package Gui;

import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.BorderLayout;

public class flashForm extends JFrame {

    private JPanel contentPane;

    public flashForm(String tenDangNhap, String role) {
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        setSize(500, 400);
        setLocationRelativeTo(null);

        contentPane = new JPanel() {
            private Image backgroundImage = new ImageIcon(getClass().getResource("/Photos/flashForm.jpg")).getImage();

            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
            }
        };

        contentPane.setOpaque(true);
        setContentPane(contentPane);
        contentPane.setLayout(null);

        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                setVisible(false);
                dispose();
                new MainGUI(tenDangNhap, role);
            }
        }, 1500);

        setVisible(true);
    }
}
