package in.hcl.healthsystem.daoimpl;

import java.util.ArrayList;
import java.util.List;

import in.hcl.healthsystem.dao.PatientDAO;
import in.hcl.healthsystem.model.Doctor;
import in.hcl.healthsystem.model.Patient;

public class PatientDAOPlainImpl implements PatientDAO{
   
	List<Patient> localRepository;

	@Override
	public void addPatient(Patient patient) {
	   	 localRepository=new ArrayList<>();		
	}

	@Override
	public void viewPatient(Patient patient) {
	   	 localRepository.add(patient);
	}

	@Override
	public List<Patient> viewAllPatient() {
		return localRepository;
	}

	@Override
	public void updatePatient(Patient patient) {
		
	}

	@Override
	public void deletePatient(Long id) {
		
	}

}
