package ch07;

public class Employee {
//전역변수, 프로퍼티변수, 멤버변수
	public String name;
	public int basic;
	private int bonus;
	private int total;
	private int tax;
	private int salary;

	public void input(String name, int basic) {
		this.name = name;
		this.basic = basic;
	}

	public void calc() {
		bonus = basic * 3;
		total = basic + bonus;
		tax = (int) (total * 0.033);
		salary = total - tax;
	}

	public void print() {
		System.out.println("Name : " + name);
		System.out.println("Basic : " + basic);
		System.out.println("Bonus : " + bonus);
		System.out.println("Total : " + total);
		System.out.println("Tax :" + tax);
		System.out.println("Salary :" + salary);
	}
}
