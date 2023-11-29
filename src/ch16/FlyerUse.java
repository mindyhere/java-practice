package ch16;

public class FlyerUse {
	public static void main(String[] args) {
		Flyer f = new Flyer() {
//add unimplemented methods => 구현되지 않은 메서드를 추가
//내부클래스, 무명클래스
			@Override
			public void takeOff() {
				System.out.println("fly");
			}

			@Override
			public void fly() {
				System.out.println("take off");
			}

			@Override
			public void land() {
				System.out.println("land");
			}
		};
		
		f.takeOff();
		f.fly();
		f.land();
	}
}