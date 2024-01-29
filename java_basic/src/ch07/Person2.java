package ch07;

public class Person2 {
	private String name;
	private int age;
	private double height;

	public void setName(String name) {
		this.name = name;
	}

	public void setAge(int age) {
		if (age < 0 || age > 150) {
			System.out.println("error!");
		} else {
			this.age = age;
		}
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public double getHieght() {
		return height;
	}

	public void print() {
		System.out.println("Name : " + name + ", Age : " + age + ", Height : " + height);
	}
}
