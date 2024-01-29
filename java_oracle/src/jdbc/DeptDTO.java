package jdbc;

public class DeptDTO {
	private int deptno;
	private String dname;
	
	public int getDeptno() {
		return deptno;
	}
	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}
	
	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}
	
	public DeptDTO() {} //기본생성자
	
	public DeptDTO(int deptno, String dname) {
		super();
		this.deptno = deptno;
		this.dname = dname;
	}
	
	@Override
	public String toString() {
		return "DeptDTO [deptno=" + deptno + ", dname=" + dname + "]";
	}
}
