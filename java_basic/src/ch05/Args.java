package ch05;

public class Args {
	public static void main(String[] args) {
		System.out.println("명령행 매개변수 개수 : " + args.length);
		//Run > Configurations > arguments
		for (int i = 0; i < args.length; i++) {

			System.out.println("args[" + i + "] = " + args[i]);

		}
	}
}
