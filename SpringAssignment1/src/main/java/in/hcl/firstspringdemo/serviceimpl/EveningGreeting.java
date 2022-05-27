package in.hcl.firstspringdemo.serviceimpl;

public class EveningGreeting {

	public EveningGreeting() {
		System.out.println("----------EveningGreeting object created--------------");
	}
	public void greetUser(String userName) {
		System.out.println(userName+": Good Evening");
	}
}
