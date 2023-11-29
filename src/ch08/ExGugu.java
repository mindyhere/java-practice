package ch08;

public class ExGugu {
	private int dan;

	public int getDan() {
		return dan;
	}

	public void setDan(int dan) {
		this.dan = dan;
	}

	public void print() {
		for (int i = 1; i <= 9; i++) {
			System.out.println(dan + " X " + i + " = " + dan * i);
		}
	}
//메서드 오버로드
	public ExGugu(int dan) {
		this.dan = dan;
	}

	public ExGugu() {
		// TODO Auto-generated constructor stub
		// 기본생성자 ; ctrl + space (단축키)
	}

	public static void main(String[] args) {
		ExGugu g2 = new ExGugu(); // 메모리에 object 생성, 인스턴스화
		g2.setDan(5);
		g2.print();

		ExGugu g1 = new ExGugu(7);
		// Scanner sc = new Scanner();
	}
}
