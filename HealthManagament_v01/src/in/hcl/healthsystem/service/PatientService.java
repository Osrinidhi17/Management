package in.hcl.healthsystem.service;

import java.util.List;

import in.hcl.healthsystem.model.Patient;
public interface PatientService {

	void addPatient(Patient patient);
	void viewPatient(Patient patient);
	List<Patient> viewAllPatient();
	void updatePatient(Patient patient);
	void deletePatient(Long id);
}
