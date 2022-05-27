package in.hcl.healthsystem.model;

import java.util.Objects;

public class Doctor {
	private int docid;
	private String docname;
	private String speciality;
	private String patient;
	

	public Doctor() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Doctor(int docid , String docname, String speciality, String patient) {
		super();
		this.docid=docid;
		this.docname=docname;
		this.speciality=speciality;
		this.patient=patient;
	}
	public int getDocid() {
		return docid;
	}
	public void setDocid(int docid) {
		this.docid = docid;
	}
	
	public String getDocname() {
		return docname;
	}
	public void setDocname(String docname) {
		this.docname = docname;
	}
	public String getSpeciality() {
		return speciality;
	}
	public void setSpeciality(String speciality) {
		this.speciality = speciality;
	}
	public String getPatient() {
		return patient;
	}
	public void setPatient(String patient) {
		this.patient = patient;
	}
	@Override
	public String toString() {
		return "Doctor [docid=" + docid + ", docname=" + docname + ", speciality=" + speciality + ", patient=" + patient
				+ "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(docid);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Doctor other = (Doctor) obj;
		return docid == other.docid;
	}
	
	
	
}
