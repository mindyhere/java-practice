package jdbc;

//DTO: Data Transfer Object(데이터 전달 객체)
public class ScoreDTO {
	private String student_no;
	private String name;
	private int kor, eng, mat, tot;
	private double avg;

	public String getStudent_no() {
		return student_no;
	}

	public void setStudent_no(String student_no) {
//							argument/parameter(매개변수, 인수, 인자)
		this.student_no = student_no;
//		this.변수명: 필드변수, 멤버변수 → 지역변수와 멤버변수 이름이 같은 경우를 구분
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getKor() {
		return kor;
	}

	public void setKor(int kor) {
		this.kor = kor;
	}

	public int getEng() {
		return eng;
	}

	public void setEng(int eng) {
		this.eng = eng;
	}

	public int getMat() {
		return mat;
	}

	public void setMat(int mat) {
		this.mat = mat;
	}

	public int getTot() {
		return tot;
	}

	public void setTot(int tot) {
		this.tot = tot;
	}

	public double getAvg() {
		return avg;
	}

	public void setAvg(double avg) {
		this.avg = avg;
	}

	@Override //오버라이드(함수재정의) 
//  어노테이션: 코드에 대한 설명문
	public String toString() {
		return "ScoreDTO [student_no=" + student_no + ", name=" + name + ", kor=" + kor + ", eng=" + eng + ", mat="
				+ mat + ", tot=" + tot + ", avg=" + avg + "]";
	}

	public ScoreDTO() {
	}

	public ScoreDTO(String student_no, String name, int kor, int eng, int mat) {
		super();	//상위 클래스의 생성자 호출
		this.student_no = student_no;
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.mat = mat;
		tot = kor + eng + mat;
		avg = tot / 3.0;
	}
}
