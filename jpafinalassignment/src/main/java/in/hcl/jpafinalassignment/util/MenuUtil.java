package in.hcl.jpafinalassignment.util;

import java.util.Scanner;

import in.hcl.jpafinalassignment.domain.Food;
import in.hcl.jpafinalassignment.domain.User;
import in.hcl.jpafinalassignment.exception.UserNotFoundException;
import in.hcl.jpafinalassignment.service.UserService;
import in.hcl.jpafinalassignment.serviceimpl.UserServiceImpl;

public class MenuUtil {
	private UserService userService;

	public MenuUtil() {
		userService = new UserServiceImpl();
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
			switch (menuChoice) {
			case 1:
				User user = new User();
				Food food = new Food();
				System.out.println("------Creating User Order------");

				System.out.println("Enter User Name");
				user.setName(sc.nextLine());

				System.out.println("Enter User Mob");
				user.setMob(sc.nextLine());

				System.out.println("Enter User OrderId");
				user.setOrderId(sc.nextLine());

				System.out.println("Enter User Addr");
				user.setAddr(sc.nextLine());
				
				System.out.println("Enter Food Name");
				food.setName(sc.nextLine());

				System.out.println("Enter Food Cost");
				food.setCost(sc.nextInt());
				user.setFood(food);
				sc.nextLine();
				
				userService.createUser(user);
				break;

			case 2:
				System.out.println("------Removing User Order------");
				System.out.println("Enter User ID");
				int remId = sc.nextInt();
				try {
					userService.removeUser(remId);
				} catch (UserNotFoundException e) {
					System.out.println("Problem : " + e.getMessage());
				}
				break;

			case 3:
				User user1 = new User();
				System.out.println("------Updating User Order------");
				System.out.println("Enter User ID");
				user1.setId(sc.nextInt());
				sc.nextLine();

				System.out.println("Enter User name");
				user1.setName(sc.nextLine());

				System.out.println("Enter User Mob");
				user1.setMob(sc.nextLine());

				System.out.println("Enter User OrderId");
				user1.setOrderId(sc.nextLine());
				System.out.println("Enter User Addr");
				user1.setAddr(sc.nextLine());
				Food f = new Food();
				System.out.println("Enter Food");
				f.setName(sc.nextLine());
				System.out.println("Enter cost");
				f.setCost(sc.nextInt());
				user1.setFood(f);
				sc.nextLine();
				userService.updateUser(user1);
				break;

			case 4:
				System.out.println("------Displaying User Orders------");
				userService.showAllUser();
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
		} while (continueChoice.equals("yes"));
		sc.close();
	}

	private void showMenu() {
		System.out.println("User Application");
		System.out.println("1. Add User");
		System.out.println("2. Delete User");
		System.out.println("3. Update User");
		System.out.println("4. List User");
		System.out.println("0 to exit");
	}
}