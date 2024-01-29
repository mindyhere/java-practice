package jdbc;

public class MajorExDTO {
	private int majorno;
	private String mname;
	public int getMajorno() {
		return majorno;
	}
	public void setMajorno(int majorno) {
		this.majorno = majorno;
	}
	public String getMname() {
		return mname;
	}
	public void setMname(String mname) {
		this.mname = mname;
	}
	@Override
	public String toString() {
		return "MajorExDTO [majorno=" + majorno + ", mname=" + mname + "]";
	}
	
	public MajorExDTO() {}
	public MajorExDTO(int majorno, String mname) {
		super();
		this.majorno = majorno;
		this.mname = mname;
	}
}
