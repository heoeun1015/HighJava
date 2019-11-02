package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class T07_ListSortTest {
	public static void main(String[] args) {
		
	 	//Comparable and Comparator 예제
		
		List<Member> memList = new ArrayList<Member>();
		
		memList.add(new Member(1, "홍길동", "010-1111-2222"));
		memList.add(new Member(5, "변학도", "010-2222-2222"));
		memList.add(new Member(9, "성춘향", "010-3333-3333"));
		memList.add(new Member(3, "이순신", "010-4444-4444"));
		memList.add(new Member(6, "강감찬", "010-5555-5555"));
		memList.add(new Member(2, "일지매", "010-6666-6666"));
		
		System.out.println("정렬 전: ");
		for(Member mem : memList) {
			System.out.println(mem);
		}
		System.out.println("-------------------------------------------------");
		
		Collections.sort(memList);		//정렬하기. 오버라이딩 하지 않으면 바로 sort에 에러가 난다.
		
		System.out.println("이름의 오름차순으로 정렬 후: ");
		for(Member mem : memList) {
			System.out.println(mem);
		}
		System.out.println("-------------------------------------------------");
		
		//외부 정렬 기준을 이용한 정렬하기
		
		Collections.sort(memList, new SortNumDesc());
		
		for(Member mem : memList) {
			System.out.println(mem);
		}
		
		 
	}
}


	//정렬 기준의 외부 선언을 위해서는 Comparator 인터페이스를 구현하면 된다.
	//Member의 번호(num)의 내림차순으로 정렬하기

class SortNumDesc implements Comparator<Member>{

	@Override
	public int compare(Member mem1, Member mem2) {	//외부정렬자 오버라이드. 구현을 해주어야 한다.
		if(mem1.getNum() > mem2.getNum()) {		
			return -1;
		}else if(mem1.getNum() == mem2.getNum()) {
			return 0;
		}else {
			return 1;
		}
		
		//Wrapper클래스에서 제공하는 메서드를 이용하는 방법 (유틸 메서드 호출)
//		return Integer.compare(mem1.getName(), mem2.getName()) * -1;
		
		//Wrapper클래스에서 제공하는 메서드를 이용하는 방법2
//		return new Integer(mem1.getNum()).compareTo(mem2.getNum()) * -1;

		//앞에 있는 값이 크면 음수, 뒤에 있는 값이 크면 양수로 바꿔준다.
		
		
	}
	
}




/*
 	회원의 정보를 저장할 클래스
 	회원정보는 회원번호, 회원이름, 전화번호로 되어 있다.
 	회원 이름을 기준으로 오름차순 정렬이 될 수 있는 클래스 만들기.
 */

class Member implements Comparable<Member>{		//Comparable를 구현해주어야 하기 때문에 오버라이드 했다.
	private int num;		//번호
	private String name;	//이름
	private String tel;		//전화번호
	
	//생성자 Source - Gnerate Constructor using Fields 선택
	public Member(int num, String name, String tel) { 
		super();
		this.num = num;
		this.name = name;
		this.tel = tel;
	}

	//Getter&Setter
	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}
		
	@Override //이걸 안 해주면 안 된다. 출력값 설정을 위함.
	public String toString() {
		return "Member[num = " + num + ", name = " + name + ", tel = " + tel + "]";
	}
	
	//이름을 기준으로 오름차순 정렬이 되도록 설정한다.
	@Override
	public int compareTo(Member mem) {
//		return getName().compareTo(mem.getName()) * -1;		//내림차순
		return getName().compareTo(mem.getName());			//오름차순
	}
	
	
}