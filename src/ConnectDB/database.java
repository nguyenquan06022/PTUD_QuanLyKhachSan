package ConnectDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class database {
	public static Connection con = null;
	private static database instance = new database();
	public static database getInstance() {
		return instance;
	}
	
	public void Connect() {
		String url = "jdbc:sqlserver://localhost:1433;databasename=QuanLyKhachSan";
		String user = "sa";
		String password = "sapassword";
		
		try {
			con=DriverManager.getConnection(url,user,password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	public void disconnect() {
		if(con!=null)
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}


	public Connection getConnection() {
		return con;
	}
}
