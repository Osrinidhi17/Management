package in.hcl.healthsystem.serviceimpl;

import java.util.List;

import in.hcl.healthsystem.dao.DoctorDAO;
import in.hcl.healthsystem.model.Doctor;
import in.hcl.healthsystem.service.DoctorService;

public class DoctorServiceImpl implements DoctorService {

	private DoctorDAO doctorDAO; 
	
	@Override
	public void addDoctor(Doctor doctor) {
	}
	@Override
	public void viewDoctor(Doctor doctor) {
		
	}
	public void viewAllDoctor(Doctor doctor) {
	}
	@Override
	public void updateDoctor(Doctor doctor) {		
	}
	@Override
	public void deleteDoctor(Long id)  {
	}
	@Override
	public List<Doctor> viewAllDoctor() {
		return null;
	}
}
