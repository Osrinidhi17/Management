package in.hcl.trainingtracker.employeemanagement.service;

import in.hcl.trainingtracker.employeemanagement.exception.EmployeeNotFoundException;
import in.hcl.trainingtracker.employeemanagement.model.Employee;

public interface EmployeeService {

	void createEmployee(Employee employee);
	void updateEmployee(Employee employee);
	void removeEmployee(Long id)throws EmployeeNotFoundException;
	void searchEmployee(Long id);
	void showAllEmployee();
	void advanceSearch();
}
