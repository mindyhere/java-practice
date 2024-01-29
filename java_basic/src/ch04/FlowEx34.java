package ch04;

import java.util.Scanner;

public class FlowEx34 {
	public static void main(String[] args) {
		int menu = 0, num = 0;

		Scanner sc = new Scanner(System.in);

		outer: while (true) {
			System.out.println("(1) 제곱");
			System.out.println("(2) 제곱근");
			System.out.println("(3) 로그");
			System.out.print("Choose a menu you wnat(Number 1~3. exit:0) -> ");

			int tmp = sc.nextInt();
			if (tmp == 0) {
				System.out.println("End this program.");
				break;
			} else if (tmp < 1 || tmp > 3) {
				System.out.println("Error ;  try the number between 1~3");
				continue;
			}

			for (;;) {
				System.out.print("X(* X=0 : cancle, 99 : end program) = ");
				num = sc.nextInt();

				if (num == 0)
					break;
				if (num == 99)
					break outer;
				switch (menu) {
				case 1:
					System.out.println("Result : " + num * num);
					break;
				case 2:
					System.out.println("Result : " + Math.sqrt(num));
					break;
				case 3:
					System.out.println("Result : " + Math.log(num));
					break;

				}
			}
		}

	}
}
