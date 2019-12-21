package kr.or.ddit.member;

public class MemberVO {

	private String id;
	private String name;
	private String tel;
	private String addr;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getEname() {
		return name;
	}
	public void setEname(String ename) {
		this.name = ename;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	
	public MemberVO(String id, String ename, String tel, String addr) {
		super();
		this.id = id;
		this.name = ename;
		this.tel = tel;
		this.addr = addr;
	}
	
}
