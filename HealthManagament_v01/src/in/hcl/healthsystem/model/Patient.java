package in.hcl.healthsystem.model;

import java.util.Objects;

public class Patient {
	private int patid;
	private String pname;
	private String problem;
	
	public Patient() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Patient(int patid, String pname, String problem) {
		super();
		this.patid = patid;
		this.pname = pname;
		this.problem = problem;
	}

	public int getPatid() {
		return patid;
	}
	public void setPatid(int patid) {
		this.patid = patid;
	}

	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public String getProblem() {
		return problem;
	}
	public void setProblem(String problem) {
		this.problem = problem;
	}
	@Override
	public String toString() {
		return "Patient [patid=" + patid + ", pname=" + pname + ", problem=" + problem + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(patid);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Patient other = (Patient) obj;
		return patid == other.patid;
	}
	
	

}
