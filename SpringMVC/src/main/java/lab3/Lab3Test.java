package lab3;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Lab3Test {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("lab3.xml");
								//�� ID, �� Ÿ���� Object���� -> ���ϴ� Ÿ������ ĳ����
		Car c = context.getBean("car", Car.class);
				System.out.println(c.model);
				System.out.println(c.price);
		
		//bean�� ����Ʈ�� �̱����̱� ������ �Ѵ� ���� �ּ�
		People p =  context.getBean("people", People.class);
		System.out.println(p);		
		
		People p2 =  context.getBean("people", People.class);
		System.out.println(p2);
		
		System.out.println(p==p2);
		System.out.println(System.identityHashCode(p));
		System.out.println(System.identityHashCode(p2));		
	}
}