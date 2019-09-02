package lab1;

public class TVUser {
	
	public static void main(String[] args) {
	TV tv1 = TVFactory.makeTV("sam");
	tv1.powerOn();
	tv1.powerOff();
	
	
	TV tv2 = TVFactory.makeTV("lg");
	tv2.powerOn();
	tv2.powerOff();
	}
}
