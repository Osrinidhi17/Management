package in.hcl.trainingtracker.employeemanagement.serviceimpl;

import in.hcl.trainingtracker.employeemanagement.dao.EmployeeDAO;
import in.hcl.trainingtracker.employeemanagement.daoimpl.EmployeeDAOImpl;
import in.hcl.trainingtracker.employeemanagement.exception.EmployeeNotFoundException;
import in.hcl.trainingtracker.employeemanagement.model.Employee;
import in.hcl.trainingtracker.employeemanagement.service.EmployeeService;

public class EmployeeServiceImpl implements EmployeeService {

private EmployeeDAO employeeDAO;
	
	public EmployeeServiceImpl() {
		employeeDAO = new EmployeeDAOImpl();
	}
	
	@Override
	public void createEmployee(Employee employee) {
		employeeDAO.addEmployee(employee);
	}

	@Override
	public void updateEmployee(Employee employee) {
		employeeDAO.updateEmployee(employee);
	}

	@Override
	public void removeEmployee(Long id) throws EmployeeNotFoundException {
		try {
			employeeDAO.deleteEmployee(id);
		} catch (EmployeeNotFoundException e) {
			throw new EmployeeNotFoundException(e.getMessage());
		}
	}

	@Override
	public void searchEmployee(Long id) {
		employeeDAO.searchEmployee(id);
	}

	@Override
	public void advanceSearch() {
		employeeDAO.advanceSearch();
	}

	@Override
	public void showAllEmployee() {
		employeeDAO.showEmployee();
		
	}
}
