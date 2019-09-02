package lab3;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Lab3Test {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("lab3.xml");
								//빈 ID, 빈 타입을 Object에서 -> 원하는 타입으로 캐스팅
		Car c = context.getBean("car", Car.class);
				System.out.println(c.model);
				System.out.println(c.price);
		
		//bean의 디폴트가 싱글톤이기 때문에 둘다 동일 주소
		People p =  context.getBean("people", People.class);
		System.out.println(p);		
		
		People p2 =  context.getBean("people", People.class);
		System.out.println(p2);
		
		System.out.println(p==p2);
		System.out.println(System.identityHashCode(p));
		System.out.println(System.identityHashCode(p2));		
	}
}
