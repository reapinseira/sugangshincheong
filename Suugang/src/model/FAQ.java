package model;

public class FAQ {

	private int fno;
	private String ftitle;
	private String fcontent;
	private String fdate;
	private int fclick;
	private String ano;
	
	public int getFno() {
		return fno;
	}
	public String getFtitle() {
		return ftitle;
	}
	public String getFcontent() {
		return fcontent;
	}
	public String getFdate() {
		return fdate;
	}
	public int getFclick() {
		return fclick;
	}
	public String getAno() {
		return ano;
	}
	public void setFno(int fno) {
		this.fno = fno;
	}
	public void setFtitle(String ftitle) {
		this.ftitle = ftitle;
	}
	public void setFcontent(String fcontent) {
		this.fcontent = fcontent;
	}
	public void setFdate(String fdate) {
		this.fdate = fdate;
	}
	public void setFclick(int fclick) {
		this.fclick = fclick;
	}
	public void setAno(String ano) {
		this.ano = ano;
	}
	
}
