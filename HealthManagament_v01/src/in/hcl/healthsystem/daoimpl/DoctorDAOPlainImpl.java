package in.hcl.healthsystem.daoimpl;

import java.util.ArrayList;
import java.util.List;

import in.hcl.healthsystem.dao.DoctorDAO;
import in.hcl.healthsystem.model.Doctor;


public class DoctorDAOPlainImpl implements DoctorDAO {

    List<Doctor> localRepository;

	@Override
	public void addDoctor(Doctor doctor) {
   	 localRepository=new ArrayList<>();
		
	}

	@Override
	public void viewDoctor(Doctor doctor) {
   	 localRepository.add(doctor);
		
	}

	@Override
	public List<Doctor> viewAllDoctor() {
		return localRepository;
		}

	@Override
	public void updateDoctor(Doctor doctor) {
		
	}

	@Override
	public void deleteDoctor(Long id) {
		
	}
 

}