package in.hcl.employeemanagement.dao;

import java.util.List;

import in.hcl.employeemanagement.model.Employee;
public interface EmployeeDAO {

	void save(Employee employee);
	void update(Employee project);
	List<Employee>list();
	void delete(Long id);


}
