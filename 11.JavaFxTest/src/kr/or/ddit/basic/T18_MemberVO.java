package kr.or.ddit.basic;

public class T18_MemberVO {
	
	private String id;
	private String name;
	private String address;
	
	public T18_MemberVO(String id, String name, String address) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
	}
	
	// Ibatis를 할 때 기본 생성자를 추가해주지 않으면 오류가 날 수 있다. 혹시 모르니 추가해주는 것도 좋음.
	public T18_MemberVO() {}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
}
