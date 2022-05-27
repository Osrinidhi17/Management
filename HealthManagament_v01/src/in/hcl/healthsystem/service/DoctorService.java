package in.hcl.healthsystem.service;

import java.util.List;

import in.hcl.healthsystem.model.Doctor;


public interface DoctorService {
    void addDoctor(Doctor doctor);
	void viewDoctor(Doctor doctor);
	List<Doctor> viewAllDoctor();
	void updateDoctor(Doctor doctor);
	void deleteDoctor(Long id);

}
