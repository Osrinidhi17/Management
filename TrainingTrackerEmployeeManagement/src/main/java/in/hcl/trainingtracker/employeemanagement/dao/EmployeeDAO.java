package in.hcl.trainingtracker.employeemanagement.dao;

import in.hcl.trainingtracker.employeemanagement.exception.EmployeeNotFoundException;
import in.hcl.trainingtracker.employeemanagement.model.Employee;

public interface EmployeeDAO {
	
	void addEmployee(Employee employee);
	void deleteEmployee(Long id) throws EmployeeNotFoundException;
	void updateEmployee(Employee employee);
	void searchEmployee(Long id);
	void showEmployee();
	void advanceSearch();
}
