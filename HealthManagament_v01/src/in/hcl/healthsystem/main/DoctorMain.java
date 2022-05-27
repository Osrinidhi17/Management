package in.hcl.healthsystem.main;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import in.hcl.healthsystem.model.Doctor;

public class DoctorMain {
		
		HashSet<Doctor> docset=new HashSet<Doctor>();

		Doctor doc1=new Doctor(101,"Srinidhi","Neurologist","201");
		Doctor doc2= new Doctor(102,"Arjun","Dermatologist","202");
		Doctor doc3 = new Doctor(103,"Priya","Dentist","203");
		Doctor doc4 = new Doctor(104,"Bhargava","Orthopedic","204");
		
		
		Scanner sc=new Scanner(System.in);
		boolean found=false;
		int docid;
		String docname;
		String speciality;
		String patient;
		
		public DoctorMain() {
			
			docset.add(doc1);
			docset.add(doc2);
			docset.add(doc3);
			docset.add(doc4);
			
		}
		
		//view all Doctor
		public void viewAllDoctor() {
			for(Doctor doc:docset) {
				System.out.println(doc);
			}
		}
		
		//view doc based on there id
		public void viewDoctor(){
			
			System.out.println("Enter id: ");
			docid=sc.nextInt();
			for(Doctor doc:docset) {
				if(doc.getDocid()==docid) {
					System.out.println(doc);
					found=true;
				}	
			}
			if(!found) {
				System.out.println("Doctor with this id is not present");
			}
		}
				
		
		//update
			public void updateDoctor() {
				System.out.println("Enter id: ");
				docid=sc.nextInt();
				boolean found=false;
				for(Doctor doc:docset) {
					if(doc.getDocid()==docid) {
						System.out.println("Enter new name: ");
						docname=sc.next();
						System.out.println("Enter new speciality");
						speciality=sc.next();
						System.out.println("Enter new patient");
						patient=sc.next();
						doc.setDocname(docname);
						doc.setSpeciality(speciality);
						doc.setPatient(patient);
						System.out.println("Updated Details of doctor are: ");
						System.out.println(doc);
						found=true;
					}
				}
				if(!found) {
					System.out.println("Doctor is not present");
				}
				else {
					System.out.println("Doctor details updated successfully !!");
				}
			}
			
			public void deleteDoctor() {
				System.out.println("Enter id");
				docid=sc.nextInt();
				boolean found=false;
				Doctor docdelete=null;
				for(Doctor doc:docset) {
					if(doc.getDocid()==docid) {
						docdelete=doc;
						found=true;
					}
				}
				if(!found) {
					System.out.println("Doctor is not present");
				}
				else {
					docset.remove(docdelete);
					System.out.println("Doctor deleted successfully!!");
				}
			}
		
			//add emp
			public void addDoctor() {
				System.out.println("Enter id:");
				docid=sc.nextInt();
				System.out.println("Enter name");
				docname=sc.next();
				System.out.println("Enter speciality");
				speciality=sc.next();
				System.out.println("enter patient");
				patient=sc.next();
				
				Doctor doc=new Doctor (docid, docname, speciality, patient);
				
				docset.add(doc);
				System.out.println(doc);
				System.out.println("Doctor addeed successsfully");
		
		try {
			PrintStream ps = new PrintStream (new File("C:\\HealthMangament\\DocData.txt"));
			System.setOut(ps);
			ps.print(docset);
		}
		catch(FileNotFoundException ft) {
   	 ft.printStackTrace();
		}
	}
}
