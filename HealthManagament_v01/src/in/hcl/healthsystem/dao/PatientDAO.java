package in.hcl.healthsystem.dao;

import java.util.List;

import in.hcl.healthsystem.model.Patient;


public interface PatientDAO {
	void addPatient(Patient patient);
	void viewPatient(Patient patient);
	List<Patient> viewAllPatient();
	void updatePatient(Patient patient);
	void deletePatient(Long id);
}
