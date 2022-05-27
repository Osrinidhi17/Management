package in.hcl.healthsystem.main;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import in.hcl.healthsystem.model.Patient;

public class PatientMain {
	
	    HashSet<Patient> patset=new HashSet<Patient>();
		Patient pat1 = new Patient(201,"Arun"," brain injury,spinal cord injury");
		Patient pat2 = new Patient(202,"Nitesh","conditions involving the skin, hair");
		Patient pat3 = new Patient(203,"Uma","conditions that affect oral health");
		Patient pat4 = new Patient(204,"Sundeep","Lower Back Pain,Lower back pain,Knee pain");
		Patient pat5 = new Patient(205,"Vijay","Headaches are one of the most common");
		
		Scanner sc=new Scanner(System.in);
		boolean found=false;
		int patid;
		String pname;
		String problem;
		
        public PatientMain() {
			
			patset.add(pat1);
			patset.add(pat2);
			patset.add(pat3);
			patset.add(pat4);
			
		}
        
      //view all Doctor
      		public void viewAllPatient() {
      			for(Patient pat:patset) {
      				System.out.println(pat);
      			}
      		}
		
      		
      	//view pat based on there id
    		public void viewPatient(){
    			
    			System.out.println("Enter id: ");
    			patid=sc.nextInt();
    			for(Patient pat:patset) {
    				if(pat.getPatid()==patid) {
    					System.out.println(pat);
    					found=true;
    				}	
    			}
    			if(!found) {
    				System.out.println("Patient with this id is not present");
    			}
    		}
    		
    		
    		//update
			public void updatePatient() {
				System.out.println("Enter id: ");
				patid=sc.nextInt();
				boolean found=false;
				for(Patient pat:patset) {
					if(pat.getPatid()==patid) {
						System.out.println("Enter new name: ");
						pname=sc.next();
						System.out.println("Enter new speciality");
						problem=sc.next();
						System.out.println("Enter new problem");
						problem=sc.next();
						pat.setPname(pname);
						pat.setProblem(problem);
						System.out.println("Updated Details of doctor are: ");
						System.out.println(pat);
						found=true;
					}
				}
				if(!found) {
					System.out.println("Patient is not present");
				}
				else {
					System.out.println("Patient details updated successfully !!");
				}
			}
			
			
			public void deletePatient() {
				System.out.println("Enter id");
				patid=sc.nextInt();
				boolean found=false;
				Patient patdelete=null;
				for(Patient pat:patset) {
					if(pat.getPatid()==patid) {
						patdelete=pat;
						found=true;
					}
				}
				if(!found) {
					System.out.println("Patient is not present");
				}
				else {
					patset.remove(patdelete);
					System.out.println("Patient deleted successfully!!");
				}
			}
			
			//add patient
			public void addPatient() {
				System.out.println("Enter id:");
				patid=sc.nextInt();
				System.out.println("Enter name");
				pname=sc.next();
				System.out.println("Enter problem");
				problem=sc.next();
				
				Patient pat=new Patient (patid, pname, problem);
				
				patset.add(pat);
				System.out.println(pat);
				System.out.println("Patient addeed successsfully");
		
		try {
			PrintStream ps = new PrintStream (new File("C:\\HealthMangament\\PatData.txt"));
			System.setOut(ps);
			ps.print(patset);
		}
		catch(FileNotFoundException ft) {
   	 ft.printStackTrace();
		}
	}
}	
		