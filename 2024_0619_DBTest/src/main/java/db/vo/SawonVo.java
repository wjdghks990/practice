package db.vo;

public class SawonVo {
	
	int 	sabun;
	String	saname;
	String	sasex;
	int		deptno;
	String	sajob;
	String	sahire;
	int		samgr;
	int		sapay;
	
	public SawonVo() {
		// TODO Auto-generated constructor stub
	}
	
	public SawonVo(int sabun, String saname, String sasex, int deptno, String sajob, String sahire, int samgr, int sapay) {
		super();
		this.sabun = sabun;
		this.saname = saname;
		this.sasex =sasex;
		this.deptno = deptno;
		this.sajob = sajob;
		this.sahire = sahire;
		this.samgr = samgr;
		this.sapay = sapay;
	}
	public String getSasex() {
		return sasex;
	}

	public void setSasex(String sasex) {
		this.sasex = sasex;
	}

	public int getSabun() {
		return sabun;
	}
	public void setSabun(int sabun) {
		this.sabun = sabun;
	}
	public String getSaname() {
		return saname;
	}
	public void setSaname(String saname) {
		this.saname = saname;
	}
	public int getDeptno() {
		return deptno;
	}
	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}
	public String getSajob() {
		return sajob;
	}
	public void setSajob(String sajob) {
		this.sajob = sajob;
	}
	public String getSahire() {
		return sahire;
	}
	public void setSahire(String sahire) {
		this.sahire = sahire;
	}
	public int getSamgr() {
		return samgr;
	}
	public void setSamgr(int samgr) {
		this.samgr = samgr;
	}
	public int getSapay() {
		return sapay;
	}
	public void setSapay(int sapay) {
		this.sapay = sapay;
	}
	
	
}


