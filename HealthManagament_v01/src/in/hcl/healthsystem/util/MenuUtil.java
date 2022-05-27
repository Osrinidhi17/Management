package in.hcl.healthsystem.util;

import java.util.Scanner;
import in.hcl.healthsystem.main.DoctorMain;
import in.hcl.healthsystem.main.PatientMain;

public class MenuUtil {

	static boolean ordering = true;
	static Scanner sc=new Scanner(System.in);
	
	public static void main(String[] args) {
	
		mainMenu();
	}
	public static void mainMenu() {
		while (true) {
			System.out.println("********** MAIN MODULE *********** " + "\n1. Doctor Details" + "\n2. Patient details"
					+"\nAny other key to exit. ");

			int choice = sc.nextInt();
			switch (choice) {
			case 1:
				doctorMenu();
				break;
			case 2:
				patientMenu();
				break;

			default:
				System.exit(0);
				break;
			}
		}
	}
	
	public static void doctorMenu() {
		
		DoctorMain dm = new DoctorMain();
		
		while (true) {
			System.out.println("********** DOCTOR MODULE *********** " + "\n1. Add Doctor " + "\n2.View Doctor"
					+ "\n3.Update Doctor" + "\n4. Delete Doctor" + "\n5.View All Doctor" + "\n6. Main Menu" +"\nAny other key to exit. ");

			int choice = sc.nextInt();
			switch (choice) {
			case 1:
				dm.addDoctor();
				break;
			case 2:
				dm.viewDoctor();
				break;
			case 3:
				dm.updateDoctor();
				break;
			case 4:
				dm.deleteDoctor();
				break;
			case 5:
				dm.viewAllDoctor();
				break;
			case 6:
				mainMenu();
				break;
			default:
				System.exit(0);
				break;
			}
		}
	}
	
	public static void patientMenu() {
		
		PatientMain pm = new PatientMain();
		while (true) {
			System.out.println("*********** PATIENT MODULE *********** "
	        		+ "\n1. Add Patient "
	        		+ "\n2.View Patient"
	        		+ "\n3.Update Patient"
	        		+ "\n4. Delete Patient"
	        		+ "\n5.View All Patient"
	        		+ "\n6. Main Menu" +"\nAny other key to exit. ");

			int choice = sc.nextInt();
			switch (choice) {
			case 1:
				pm.addPatient();
				break;
			case 2:
				pm.viewPatient();
				break;
			case 3:
				pm.updatePatient();
				break;
			case 4:
				pm.deletePatient();
				break;
			case 5:
				pm.viewAllPatient();
				break;
			case 6:
				mainMenu();
				break;
			default:
				System.exit(0);
				break;
			}
		}
	}
}
