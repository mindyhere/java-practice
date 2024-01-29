package jdbc;

public class StudExDTO {
	private int studno;
	private String sname;
	private int grade;
	private int majorno;
	private int profno;
	private String mname;

	public int getStudno() {
		return studno;
	}

	public void setStudno(int studno) {
		this.studno = studno;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	public int getMajorno() {
		return majorno;
	}

	public void setMajorno(int majorno) {
		this.majorno = majorno;
	}

	public int getProfno() {
		return profno;
	}

	public void setProfno(int profno) {
		this.profno = profno;
	}

	public String getMname() {
		return mname;
	}

	public void setMname(String mname) {
		this.mname = mname;
	}

	@Override
	public String toString() {
		return "StudExDTO [studno=" + studno + ", sname=" + sname + ", grade=" + grade + ", majorno=" + majorno
				+ ", profno=" + profno + ", mname=" + mname + "]";
	}

	public StudExDTO() {
	}

	public StudExDTO(int studno, String sname, int grade, int majorno, int profno, String mname) {
		super();
		this.studno = studno;
		this.sname = sname;
		this.grade = grade;
		this.majorno = majorno;
		this.profno = profno;
		this.mname = mname;
	}
}
