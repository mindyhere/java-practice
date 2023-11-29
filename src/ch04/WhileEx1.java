package ch04;

public class WhileEx1 {
	public static void main(String[] args) {
		int i=5 ;
		while(true) {
			System.out.println(i++);
			if (i>10)
				break;
		}
		System.out.println();
		i=1;
		while (i<=10) {
			System.out.println(i);
			i++;
		}
	}
}
