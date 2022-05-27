package in.hcl.trainingtracker.employeemanagement.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DBUtil {
	   private static final String driverclassName = "com.mysql.cj.jdbc.Driver";
		private String url="jdbc:mysql://localhost/employeemanagement"; 
		private String username="root";
		private String password="Twindisc@3703";
		private PreparedStatement ptst;
		private static Connection conn=null;
		
		static {
			try {
				Class.forName(driverclassName);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
		
		public Connection connect() {
			try {
				conn = DriverManager.getConnection(url, username, password);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return conn;
		}
		
		public PreparedStatement preparedStatement(String sql) {
			try {
				ptst = connect().prepareStatement(sql);
			} catch (SQLException e) {
				e.printStackTrace();
			}	
			return ptst;
		}
		
		public void closePreparedStatement() {
			try {
				ptst.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		public void closeConnection() {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
}
 