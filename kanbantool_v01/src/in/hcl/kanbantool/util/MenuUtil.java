package in.hcl.kanbantool.util;

import java.util.Scanner;

import in.hcl.kanbantool.exception.ProjectNotFoundException;
import in.hcl.kanbantool.model.Project;
import in.hcl.kanbantool.service.ProjectService;
import in.hcl.kanbantool.serviceimpl.ProjectServiceImpl;

public class MenuUtil {

	private ProjectService projectService;

	public MenuUtil() {
		projectService = new ProjectServiceImpl();
	}

	public void start() {
		int menuChoice;
		String continueChoice;
		Scanner sc = new Scanner(System.in);
		do {
			showMenu();
			System.out.println("Enter your choice:(1,2,3,4,5,6,0) : ");
			menuChoice = sc.nextInt();
			sc.nextLine();
			switch(menuChoice) {
			case 1:
				Project project = new Project();
				System.out.println("------Creating Project------");
				System.out.println("Enter Project name");
				project.setProjectName(sc.nextLine());
				
				System.out.println("Enter Project Identifier");
				project.setProjectIdentifier(sc.nextLine());
				
				System.out.println("Enter Project Description");
				project.setDescription(sc.nextLine());
				
				System.out.println("Enter Project StartDate");
				project.setStartDate(sc.nextLine());
				
				System.out.println("Enter Project EndDate");
				project.setEndDate(sc.next());
				sc.nextLine();
				
				projectService.createProject(project);
				break;
			case 2:
				System.out.println("------Removing Employee------");	
				System.out.println("Enter Project ID");
				Long remId = sc.nextLong();		
				try {
					projectService.removeProject(remId);
				} catch (ProjectNotFoundException e) {
					System.out.println("Problem : "+e.getMessage());
				}
				break;
			case 3:
				Project project1 = new Project();
				System.out.println("------Updating Project------");
				System.out.println("Enter Employee ID");
				project1.setId(sc.nextLong());
				sc.nextLine();
				
				System.out.println("Enter Project name");
				project1.setProjectName(sc.nextLine());
				
				System.out.println("Enter Project Identifier");
				project1.setProjectIdentifier(sc.nextLine());
				
				System.out.println("Enter Project Description");
				project1.setDescription(sc.nextLine());
				
				System.out.println("Enter Project StartDate");
				project1.setStartDate(sc.nextLine());
				
				System.out.println("Enter Project EndDate");
				project1.setEndDate(sc.next());
				sc.nextLine();
				
				projectService.updateProject(project1);
				break;
			case 4:
				System.out.println("------Displaying Projectss------");
				projectService.showAllProject();
				break;
			case 0:
				System.exit(0);
				break;
			default:
				System.out.println("Wrong choice");
				break;
			}
			System.out.println("Do you want to continue(yes/no)");
			continueChoice = sc.next();
		}while(continueChoice.equals("yes"));

		sc.close(); 
	}

	private void showMenu() {
		System.out.println("Kanbantool Application");
		System.out.println("1. Add Project");
		System.out.println("2. Delete Project");
		System.out.println("3. Update Project");
		System.out.println("4. List Project");
		System.out.println("0 to exit");
	}

}
