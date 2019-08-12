package model;

public class Lecture {
	private String lno;
	private String lname;
	private int credit;
	private String lroom;
	private int pno;
	private String pname;
	private int dno;
	private String dname;
	
	
	
	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public String getLno() {
		return lno;
	}
	public String getLname() {
		return lname;
	}
	public int getCredit() {
		return credit;
	}
	public String getLroom() {
		return lroom;
	}
	public int getPno() {
		return pno;
	}
	public int getDno() {
		return dno;
	}
	public void setLno(String lno) {
		this.lno = lno;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public void setCredit(int credit) {
		this.credit = credit;
	}
	public void setLroom(String lroom) {
		this.lroom = lroom;
	}
	public void setPno(int pno) {
		this.pno = pno;
	}
	public void setDno(int dno) {
		this.dno = dno;
	}
	
	
}
