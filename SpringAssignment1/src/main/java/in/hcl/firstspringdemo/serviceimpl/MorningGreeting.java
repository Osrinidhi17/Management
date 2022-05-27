package in.hcl.firstspringdemo.serviceimpl;

import in.hcl.firstspringdemo.service.GreetingService;

public class MorningGreeting implements GreetingService  {

	public MorningGreeting() {
		System.out.println("----------MorningGreeting object created--------------");
	}
	@Override
	public void greetUser(String userName) {
		System.out.println(userName+": Good Morning");
	}
}
