package ch13;

public class Student {
	private String name;
	private String major;
	private int year;

	public Student() {
	} // 기본생성자

	public Student(String name, String major, int year) {
		this.name = name;
		this.major = major;
		this.year = year;
	} //생성자 오버로딩

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

}
