package ch11;

public class Flyuse {
	public static void main(String[] args) {
		Flyer f = new Drone();
	//상위 자료형 		하위자료형 ->다형성에 의해 참조가능
		f.takeOff();
		f.fly();
		f.land();

		f = new Airplane();
		f.takeOff();
		f.fly();
	}
}
