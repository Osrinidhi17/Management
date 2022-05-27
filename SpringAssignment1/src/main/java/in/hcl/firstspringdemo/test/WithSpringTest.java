package in.hcl.firstspringdemo.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import in.hcl.firstspringdemo.serviceimpl.EveningGreeting;
import in.hcl.firstspringdemo.serviceimpl.MorningGreeting;

public class WithSpringTest {
    public static void main(String[] args)
    {
    	//create bean factory
    	 ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
         MorningGreeting morningGreeting = (MorningGreeting)ctx.getBean("morningGreeting");
         morningGreeting.greetUser("Srinidhi");
         
         EveningGreeting eveningGreeting = (EveningGreeting)ctx.getBean("eveningGreeting");
         eveningGreeting.greetUser("Nidhi");
    	}
}


