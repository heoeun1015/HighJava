package kr.or.ddit.basic;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class T12_Equals_hashCodeTest {
	public static void main(String[] args) {
		
		/*
		HashSet, HashMap, HashTable과 같은 객체들을 사용할 경우 객체가 서로 같은지를 비교하기 위해
		equals() 메서드와 hashCode() 메서드를 호출함.
				//* 속도가 굉장히 빠르다. 주소를 호출해서 인덱스 번호처럼 사용하기 때문.
				//* 단점으로는 결과값 자체가 100% 중복이 나지 않는다는 보장이 없다.
				   (충돌이 났다고 함. 충돌이 나지 않게 하는게 hashCode를 사용할 때 최대의 이슈)
				//* 충돌: input이 같으면 출력값도 같이 나와야 한다.
				 
		그래서 객체가 같은지 여부를 결정하려면 두 메서드를 재정의 해야 한다.
		HashSet, HashMap, HashTable에서는 객체가 같은지 여부는 데이터를 추가할 때  검사한다.
		
				//* 모든 객체는 equals와 hashCode를 가지고 있어야 한다. 비교해야 하기 때문. 같으면 안 된다.
				//* hashCode를 사용하면 두 개가 달라도 같다고 할 때가 있다. 그때 필요한 게 equals
		- equals() 메서드: 두 객체의 내용(값)이 같은지 비교하는 메서드
		- hashCode() 메서드: 두 객체가 같은 메서드인지를 비교하는 메서드
		
		
		<< equals() 메서드와 hashCode()메서드에 관련된 규칙 >>
		
		1. 두 객체가 같으면 반드시 같은 hashCode를 가져야 한다.
		
		2. 두 객체가 같으면 equals() 메서드를 호출했을 때 true를 반환해야 한다.
		     즉, 객체 a, b가 같다면 a.equals(b)와 b.equals(a) 둘 다 true여야 한다.		//* 이렇게 안해주면 중복이 들어갈 수 있다.
		     
		3. 두 객체의 hashCode가 같다고 두 객체가 반드시 같은 객체는 아니다.					//* hashCode 충돌이랑 비슷한 개념. 의심을 해볼 것.
		     하지만, 두 객체가 같으면 반드시 hashCode가 같아야 한다.							//* 달라도 같을 수 있다. (희박함)
		     
		4. equals()메서드를 override하면 반드시 hashCode() 메서드도 override 해야 한다.	//* 해주지 않으면 hashCode는 object 속성을 가지고 있음.
		
		5. hashCode()는 기본적으로 Heap에 있는 각 객체에 대한 메모리 주소 매핑정보를 기반으로 한 정수값을 반환한다.
		     그러므로, 클래스에서 hashCode()메서드를 override 하지 않으면 절대로 두 객체가 같은 것으로 간주될 수 없다.
		     	//* 이름, 학번이 같은 두 개의 객체라고 했을 때 그 두 개는 같다고 하고 싶음.
		     	    해시코드는 메모리 기반이기 때문에 숫자가 다르게 나와서 두 개를 같다고 보지 않는다.
		     	    해시코드가 같게 나오게끔 override를 시켜줘야 한다.
		     
		   - hashCode()메서드에서 사용하는 '해싱 알고리즘'에서 서로 다른 객체에 대하여 같은 hashCode 값을 만들어낼 수 있다.
		       그래서 객체가 같지 않더라도 hashCode가 같을 수 있다.    
		      //* == hashCode가 같을 때 equals로 판단하고, 그렇지 않을 경우 hashCode로만 비교한다.   */
		
		
		Person p1 = new Person(1, "홍길동");
		Person p2 = new Person(1, "홍길동");
		Person p3 = new Person(1, "이순신");

		System.out.println("p1.equals(p2) : " + p1.equals(p2));		//true
			// 오브젝트 기반의 equals를 사용하고 있기 때문에 객체를 따로 만든 걸로 쳐서 오버라이드를 하지 않으면 false로 뜬다. 
		System.out.println("p1 == p2 : " + (p1 == p2));
		System.out.println("───────────────────────────────────────");
		
		
		
		
		Set<Person> set = new HashSet<Person>();
		
		set.add(p1);
		set.add(p2);
		
		System.out.println("p1, p2 등록후 데이터");
		for(Person p : set) {
			System.out.println(p.getId() +" : " + p.getName());
		}System.out.println("───────────────────────────────────────");
		
		
		
		
		System.out.println("add(p3) 성공여부 : " + set.add(p3)); 
		
		System.out.println("add(p3) 후 데이터");  
		for(Person p : set) {
			System.out.println(p.getId() +" : " + p.getName());
		}System.out.println("───────────────────────────────────────");
		
		
		
		
		System.out.println("remove(p2) 성공여부 : " + set.remove(p2));
		
		System.out.println("set.remove(p2) 후 데이터");  
		for(Person p : set) {
			System.out.println(p.getId() +" : " + p.getName());
		}System.out.println("───────────────────────────────────────");
		
		
		
		
		
		Map<Person, String> map = new HashMap<>();
		
		//map.put(p1, "홍길동1");
		
		//System.out.println("map에 담겨진 p1 객체 꺼내오기" );
		
		
		
	}
}



class Person {
	
	private int id;
	private String name;
	
	
	public Person(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}


	
	//Source - hashCode() and equals()
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}
	// 재정의를 하지 않으면 object 속성을 가지고 있기 때문에 두 값이 다를 수밖에 없다.
	

	//Source - hashCode() and equals()
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())	// getClass(): 만든 클래스 객체(person) 
			return false;
		Person other = (Person) obj;		// 캐스팅
		if (id != other.id)					// id 같나 비교. id가 다르면 다른 것.
			return false;
		if (name == null) {
			if (other.name != null)			// 내가 null인데 상대가 null이 아니면 false
				return false;
		} else if (!name.equals(other.name))// 내가 홍길동이고 얘가 홍길순이면 다른거.
			return false;
		return true;						// 여기까지 왔으면 인정해주자. 같은게 맞다.
	}
	
	
	
}







