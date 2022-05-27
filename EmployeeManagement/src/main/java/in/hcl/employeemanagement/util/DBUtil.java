package in.hcl.employeemanagement.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DBUtil {
	private static final String driverclassName="com.mysql.cj.jdbc.Driver";
	String url="jdbc:mysql://localhost/empmanagement"; 
	String username="root";
	String password="root";
	private  Connection conn=null;
	private PreparedStatement pstmt =null;
	
	static {
		try {
			Class c = Class.forName(driverclassName);
			System.out.println(c);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public Connection connect() {
		try {
			conn = DriverManager.getConnection (url, username, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;	
	}
	public PreparedStatement preparedStatement(String sql) {
		try {
			pstmt = connect().prepareStatement(sql);
		} catch (SQLException e) {
			
		}
		return pstmt;
	}
	public void closePreparedStatement() {
		try {
			pstmt.close();
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void closeConnection() {
		try {
		conn.close();
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
