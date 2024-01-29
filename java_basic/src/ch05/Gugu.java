package ch05;

public class Gugu {
	public static void main(String[] args) {
		if(args.length ==0) {
			System.out.println("사용방법 : Gugu 숫자");
			System.exit(0); 
			//프로그램 종료 exit(0) 정상적인종료(숫자는 의미x) 
		}
		int dan = Integer.parseInt(args[0]);
		//Integer.parseInt(스트링) -> 숫자로 변환
		for (int i = 1; i <= 9; i++) {
			System.out.println(dan + "X" + i + "=" + dan * i);
		}
	}
}