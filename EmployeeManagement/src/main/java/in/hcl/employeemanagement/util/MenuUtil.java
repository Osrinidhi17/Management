package in.hcl.employeemanagement.util;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import in.hcl.healthsystem.main.DoctorMain;

public class MenuUtil {
	//	EmployeeService service=new EmployeeService();
		//static boolean ordering = true;
		
		public static void start() {
			 System.out.println("****************Welcome To Employee Managment System *********** "
		        		+ "\n1. Add Employee "
		        		+ "\n2.View Employee"
		        		+ "\n3.Update Employee"
		        		+ "\n4. Delete Employee"
		        		+ "\n5.View All Employee"
		        		+ "\n6. Exist ");
		}
	
        //DBUtil dbutil = new DBUtil();
        //public static void employeeMenu() {
		public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		//	EmployeeService service=new EmployeeService();
			
				start();
				System.out.println("Enter your Choice");
				int choice=sc.nextInt();
				switch(choice) {
				
				case 1:
					System.out.println("Add Employee");
					service.addEmp();
					break;
				case 2:
					System.out.println("View Employee");
					service.viewEmp();
					break;
				case 3:
					System.out.println("Update Employee");
					service.updateEmployee();
					break;
				case 4:
					System.out.println("Delete Employee");
					service.deleteEmp();
					break;
				case 5:
					System.out.println("view All Employee");
					service.viewAllEmps();
					break;
				case 6:
					System.out.println("Thank you for using application!!");
					System.exit(0);
					
				default:
					System.out.println("Please enter valid choice");
					break;
				
				
				}
		}
}

