package in.hcl.employeemanagement.service;

import java.util.List;

import in.hcl.employeemanagement.model.Employee;

public interface EmployeeService {
	void save(Employee employee);
	void update(Employee employee);
	List<Employee>list();
	void delete(Long id);

}
