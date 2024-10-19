package Run;

import Dao.TaiKhoan_dao;
import Gui.Login;

class App {
	public static void main(String[] args) {
		Login dangnhap = new Login();
		dangnhap.setLocationRelativeTo(null);
		dangnhap.setVisible(true);
	}
}