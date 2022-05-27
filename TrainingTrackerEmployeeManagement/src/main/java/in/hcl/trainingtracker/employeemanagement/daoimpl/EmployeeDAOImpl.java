package in.hcl.trainingtracker.employeemanagement.daoimpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import in.hcl.trainingtracker.employeemanagement.dao.EmployeeDAO;
import in.hcl.trainingtracker.employeemanagement.exception.EmployeeNotFoundException;
import in.hcl.trainingtracker.employeemanagement.model.Employee;
import in.hcl.trainingtracker.employeemanagement.util.DBUtil;

public class EmployeeDAOImpl implements EmployeeDAO {
	DBUtil dbutil = new DBUtil();
	Scanner sc = new Scanner(System.in);

	@Override
	public void addEmployee(Employee employee) {
		String sql = "insert into employeedetails (empname, DOB, empaddr, salary, designation) values(?,?,?,?,?)"; 
		PreparedStatement pstmt = dbutil.preparedStatement(sql);	
		try { 
			pstmt.setString (1, employee.getName()); 
			pstmt.setString (2, employee.getDob());
			pstmt.setString (3, employee.getAddress()); 
			pstmt.setDouble(4, employee.getSalary());
			pstmt.setString (5, employee.getDesignation());
			pstmt.execute(); 
			System.out.println("Employee Created Successfully");
		}
		catch(SQLException ex) {
			System.out.println(ex.getMessage());
		}
		finally{
			dbutil.closePreparedStatement(); 
			dbutil.closeConnection();
		}
	}

	@Override
	public void updateEmployee(Employee employee) {
		PreparedStatement ptst = dbutil.preparedStatement("update employeedetails set empname = ?, DOB = ?, empaddr = ?, salary = ?, designation = ? where empid = ?");
		
		try { 
			ptst.setString (1, employee.getName()); 
			ptst.setString (2, employee.getDob());
			ptst.setString (3, employee.getAddress()); 
			ptst.setDouble(4, employee.getSalary());
			ptst.setString (5, employee.getDesignation());
			ptst.setLong(6, employee.getId());
			ptst.execute(); 
			System.out.println("Employee updated Successfully");
		}
		catch(SQLException ex) {
			System.out.println(ex.getMessage());
		}
		finally{
			dbutil.closePreparedStatement(); 
			dbutil.closeConnection();
		}
	}

	@Override
	public void searchEmployee(Long id) {
		PreparedStatement prdsmt = dbutil.preparedStatement("select * from employeedetails where empid= ?");
		try { 
			prdsmt.setLong(1, id);
			ResultSet rs = prdsmt.executeQuery();
		      System.out.println("Employee record found");
		      while(rs.next()) {
		         System.out.print("Employee Name: "+rs.getString("empname")+", ");
		         System.out.print("Date of Birth: "+rs.getString("DOB")+", ");
		         System.out.print("Address: "+rs.getString("empaddr")+", ");
		         System.out.print("Salary: "+rs.getString("salary")+", ");
		         System.out.print("Designation: "+rs.getString("designation"));
		         System.out.println();
		      }
		}
		catch(SQLException ex) {
			System.out.println(ex.getMessage());
		}
		finally{
			dbutil.closePreparedStatement(); 
			dbutil.closeConnection();
		}
	}

	@Override
	public void deleteEmployee(Long id) throws EmployeeNotFoundException {
		PreparedStatement pst = dbutil.preparedStatement("delete from employeedetails where empid= ?");
		try { 
			pst.setLong(1, id);
			pst.execute(); 
			System.out.println("Employee deleted Successfully");
		}
		catch(SQLException ex) {
			System.out.println(ex.getMessage());
		}
		finally{
			dbutil.closePreparedStatement(); 
			dbutil.closeConnection();
		}
	}

	@Override
	public void advanceSearch() {
		System.out.println("Enter your choice:\n 1. Search Salary by Name\n 2. Search Address by ID\n 3. Search Designation by Name ");
		int choice = sc.nextInt();
		sc.nextLine();
		switch(choice) {
		case 1:
			System.out.println("Enter Employee name");
			String ename = sc.nextLine();
			PreparedStatement pdst = dbutil.preparedStatement("SELECT salary FROM employeedetails WHERE empname = ?");
			try { 
				pdst.setString (1, ename);
				ResultSet ps = pdst.executeQuery();
			      while(ps.next()) {
			    	  System.out.println("Employee Name :" +ename);
			          System.out.print("Employee Salary: "+ps.getString("salary"));
			          System.out.println();
			      }
			}
			catch(SQLException ex) {
				System.out.println(ex.getMessage());
			}
			finally{
				dbutil.closePreparedStatement(); 
				dbutil.closeConnection();
			}
			break;
		case 2:
			System.out.println("Enter Employee ID");
			int emid = sc.nextInt();
			PreparedStatement pt = dbutil.preparedStatement("SELECT empaddr FROM employeedetails WHERE empid = ?");
			try { 
				pt.setInt(1, emid);
				ResultSet ps = pt.executeQuery();
			      while(ps.next()) {
			    	  System.out.println("Employee ID :" +emid);
			          System.out.print("Address: "+ps.getString("empaddr"));
			          System.out.println();
			      }
			}
			catch(SQLException ex) {
				System.out.println(ex.getMessage());
			}
			finally{
				dbutil.closePreparedStatement(); 
				dbutil.closeConnection();
			}
			break;
		case 3:
			System.out.println("Enter Employee name");
			String empnam = sc.nextLine();
			PreparedStatement pdt = dbutil.preparedStatement("SELECT designation FROM employeedetails WHERE empname = ?");
			try { 
				pdt.setString (1, empnam);
				ResultSet ps = pdt.executeQuery();
			      while(ps.next()) {
			    	  System.out.println("Employee Name :" +empnam);
			          System.out.print("Designation: "+ps.getString("designation"));
			          System.out.println();
			      }
			}
			catch(SQLException ex) {
				System.out.println(ex.getMessage());
			}
			finally{
				dbutil.closePreparedStatement(); 
				dbutil.closeConnection();
			}
			break;
			default:
				System.out.println("Wrong choice");
			break;
		}
	}

	@Override
	public void showEmployee() {
		PreparedStatement prdst = dbutil.preparedStatement("select * from employeedetails");
		try { 
			ResultSet rs = prdst.executeQuery();
		      System.out.println("Employee record's found");
		      while(rs.next()) {
		    	  System.out.print("Employee ID: "+rs.getString("empid")+", ");
		         System.out.print("Employee Name: "+rs.getString("empname")+", ");
		         System.out.print("Date of Birth: "+rs.getString("DOB")+", ");
		         System.out.print("Address: "+rs.getString("empaddr")+", ");
		         System.out.print("Salary: "+rs.getString("salary")+", ");
		         System.out.print("Designation: "+rs.getString("designation"));
		         System.out.println();
		      }
		}
		catch(SQLException ex) {
			System.out.println(ex.getMessage());
		}
		finally{
			dbutil.closePreparedStatement(); 
			dbutil.closeConnection();
		}		
	}
}
