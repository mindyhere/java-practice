package ch09;

public class VolumeUse {
	public static void main(String[] args) {
		Volume vol1 = new Volume();
// Area & Volume 생성
		
		System.out.println("Volume : " + vol1.getVolume());
// vol1 	Volume 객체 	 	<==상속	Area 객체
//참조변수		getVolume() 호출	<==   getArea() 사용

		Volume vol2 = new Volume(10, 20, 30);
		System.out.println("Volume : " + vol2.getVolume());
	}
}