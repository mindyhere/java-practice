package ch01;

public class LongEx {
	public static void main(String[] args) {
//ctrl+space : 도움말(단축어 등)
//ctrl+shift+F : 코드정리(들여쓰기, 띄어쓰기 등)
//ctrl+F11 : Run(실행)
		int a = 2147483647;
		System.out.println(a);
		long b = 2147483648L;
		System.out.println(b);
		
		System.out.println(Integer.MIN_VALUE);
		System.out.println(Integer.MAX_VALUE);
		System.out.println(Integer.SIZE); //비트수 32bit
		
		System.out.println(Long.MIN_VALUE);
		System.out.println(Long.MAX_VALUE);
		System.out.println(Long.SIZE); //64bit

	}
}
