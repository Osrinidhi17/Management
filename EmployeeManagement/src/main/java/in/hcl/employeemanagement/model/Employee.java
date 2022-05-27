package in.hcl.employeemanagement.model;

public class Employee {

	private int id;
	private String name;
	private int  dob;
	private String desiganation;
	private String department;
	private double salary;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getDob() {
		return dob;
	}
	public void setDob(int dob) {
		this.dob = dob;
	}
	public String getDesiganation() {
		return desiganation;
	}
	public void setDesiganation(String desiganation) {
		this.desiganation = desiganation;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	
	
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", dob=" + dob + ", desiganation=" + desiganation
				+ ", department=" + department + ", salary=" + salary + "]";
	}
	
	public Employee(int id, String name, int dob, String desiganation, String department, double salary) {
		super();
		this.id = id;
		this.name = name;
		this.dob = dob;
		this.desiganation = desiganation;
		this.department = department;
		this.salary = salary;
	}
	
}
