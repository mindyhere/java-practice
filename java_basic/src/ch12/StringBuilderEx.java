package ch12;

public class StringBuilderEx {
	public static void main(String[] args) {
		StringBuilder strl = new StringBuilder();
		strl.append("java");
		strl.append(" programming");
		String str2 = strl.toString();
	//				스트리빌더 => 스트링
		System.out.println(str2);
	}
}
