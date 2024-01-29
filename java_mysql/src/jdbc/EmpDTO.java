package jdbc;

//사원테이블 예제
public class EmpDTO {
	private int empno;
	private String ename;
	private String job;
	private String hiredate;
	private double sal;
	private int deptno;

	public int getEmpno() {
		return empno;
	}

	public void setEmpno(int empno) {
		this.empno = empno;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public String getHiredate() {
		return hiredate;
	}

	public void setHiredate(String hiredate) {
		this.hiredate = hiredate;
	}

	public double getSal() {
		return sal;
	}

	public void setSal(double sal) {
		this.sal = sal;
	}

	public int getDeptno() {
		return deptno;
	}

	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}

	public EmpDTO() {
		// TODO Auto-generated constructor stub
	}

	public EmpDTO(int empno, String ename, String job, String hiredate, double sal, int deptno) {
		super();
		this.empno = empno;
		this.ename = ename;
		this.job = job;
		this.hiredate = hiredate;
		this.sal = sal;
		this.deptno = deptno;
	}

	@Override
	public String toString() {
		return "EmpDTO [empno=" + empno + ", ename=" + ename + ", job=" + job + ", hiredate=" + hiredate + ", sal="
				+ sal + ", deptno=" + deptno + "]";
	}

}
