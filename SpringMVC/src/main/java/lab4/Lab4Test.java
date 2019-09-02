package lab4;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Lab4Test {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("lab4.xml");
								
		Car c = context.getBean("car2", Car.class);
		System.out.println(c);
		
		People compare = context.getBean("people", People.class);
		System.out.println(compare);
		
		People3 p =  context.getBean("people3", People3.class);
		System.out.println(p);		
		
		
	}
}
