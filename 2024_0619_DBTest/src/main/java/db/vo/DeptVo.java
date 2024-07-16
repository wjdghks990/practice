package db.vo;

// 3위일체
// DB Column명 == VO 속성명 == form parameter명
public class DeptVo {
	
	int 	deptno;
	String  dname;
	String 	loc;
	
	public DeptVo() {
		// TODO Auto-generated constructor stub
	}	
	public DeptVo(int deptno, String dname, String loc) {
		super();
		this.deptno = deptno;
		this.dname = dname;
		this.loc = loc;
	}
	
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
	public String getLoc() {
		return loc;
	}
	public void setLoc(String loc) {
		this.loc = loc;
	}
	
	
}
