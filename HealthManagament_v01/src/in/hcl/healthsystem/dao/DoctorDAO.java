package in.hcl.healthsystem.dao;

import java.util.List;

import in.hcl.healthsystem.model.Doctor;

public interface DoctorDAO {
	void addDoctor(Doctor doctor);
	void viewDoctor(Doctor doctor);
	List<Doctor> viewAllDoctor();
	void updateDoctor(Doctor doctor);
	void deleteDoctor(Long id);
}
