package in.hcl.trainingtracker.employeemanagement.util;

import java.util.Scanner;

import in.hcl.trainingtracker.employeemanagement.exception.EmployeeNotFoundException;
import in.hcl.trainingtracker.employeemanagement.model.Employee;
import in.hcl.trainingtracker.employeemanagement.service.EmployeeService;
import in.hcl.trainingtracker.employeemanagement.serviceimpl.EmployeeServiceImpl;


public class MenuUtil {
	
	private EmployeeService employeeService;
	public MenuUtil() {
		employeeService = new EmployeeServiceImpl();
	}
	
	public void start() {
		int menuChoice;
		String continueChoice;
		Scanner sc = new Scanner(System.in);
		do {
			showMenu();
			System.out.println("Enter your choice:(1,2,3,4,5,6,0) : ");
			menuChoice = sc.nextInt();
			sc.nextLine();
			switch(menuChoice) {
			case 1:
				Employee employee = new Employee();
				System.out.println("------Creating Employee------");
				System.out.println("Enter Employee name");
				employee.setName(sc.nextLine());	
				//String name = sc.nextLine();				
				System.out.println("Enter Employee Date of Birth");
				employee.setDob(sc.nextLine());
				//String dob = sc.nextLine();
				System.out.println("Enter Employee Address");
				employee.setAddress(sc.nextLine());
				//String address = sc.nextLine();
				System.out.println("Enter Employee Salary");
				employee.setSalary(sc.nextDouble());
				//double salary = sc.nextDouble();
				System.out.println("Enter Employee Designation");
				employee.setDesignation(sc.next());
				sc.nextLine();
				//String designation = sc.next();
				employeeService.createEmployee(employee);
				break;
			case 2:
				System.out.println("------Updating Employee------");
				Employee employee1 = new Employee();
				System.out.println("Enter Employee ID");
				employee1.setId(sc.nextLong());
				sc.nextLine();
				//int id = sc.nextInt();
				//sc.nextLine();
				System.out.println("Enter Employee name");
				employee1.setName(sc.nextLine());	
				//String name = sc.nextLine();				
				System.out.println("Enter Employee Date of Birth");
				employee1.setDob(sc.nextLine());
				//String dob = sc.nextLine();
				System.out.println("Enter Employee Address");
				employee1.setAddress(sc.nextLine());
				//String address = sc.nextLine();
				System.out.println("Enter Employee Salary");
				employee1.setSalary(sc.nextDouble());
				//double salary = sc.nextDouble();
				System.out.println("Enter Employee Designation");
				employee1.setDesignation(sc.next());
				sc.nextLine();
				//String designation = sc.next();
				employeeService.updateEmployee(employee1);
				break;
			case 3:
				System.out.println("------Removing Employee------");	
				System.out.println("Enter Employee ID");
				Long remId = sc.nextLong();		
				try {
					employeeService.removeEmployee(remId);
				} catch (EmployeeNotFoundException e) {
					System.out.println("Problem : "+e.getMessage());
				}
				break;
			case 4:
				System.out.println("------Searching Employee------");
				System.out.println("Enter Employee ID");
				Long searchId = sc.nextLong();
				employeeService.searchEmployee(searchId);
				break;
			case 5:
				System.out.println("------Displaying Employees------");
				employeeService.showAllEmployee();
				break;
			case 6:
				System.out.println("------Advance Search------");
				employeeService.advanceSearch();
				break;
			case 0:
				System.exit(0);
				break;
			default:
				System.out.println("Wrong choice");
				break;
			}
			System.out.println("Do you want to continue(yes/no)");
			continueChoice = sc.next();
		}while(continueChoice.equals("yes"));
		
		sc.close(); 
	}
	
	private void showMenu() {
		System.out.println("Employee Management System");
		System.out.println("1. Add Employee");
		System.out.println("2. Update Employee");
		System.out.println("3. Delete Employee");
		System.out.println("4. Search Employee");
		System.out.println("5. List Employee");
		System.out.println("6. Advance Search Employee");
		System.out.println("0 to exit");
	}
	}
