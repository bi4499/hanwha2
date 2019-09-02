package lab2;

public class SamsungTV {
	
	public SamsungTV() {
		
	}
	
	public void powerOn() {
		System.out.println(this.getClass().getSimpleName() + "전원을 켠다.");
	}
	public void powerOff() {
		System.out.println(this.getClass().getSimpleName() + "전원을 끈다.");
	}

}
