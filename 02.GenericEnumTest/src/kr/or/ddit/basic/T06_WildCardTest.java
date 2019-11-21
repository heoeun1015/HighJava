package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.List;

	/*	<< 와일드 카드 >>
	 	
	 	<? extends T>	→ 와일드 카드의 상한 제한. T와 그 자손들만 가능		// T를 쓰는 것도 가능하긴 하다.
	 	<? super T>		→ 와일드 카드의 하한 제한. T와 그 조상들만 가능		// T와 T상위도 가능하긴 하다. 그렇다고 object까지 가는 건 아님.	
	 						// 그냥 제너릭 타입과 가장 다른 점은 super 를 쓸 수 있다는 점
	 	<?>				→ 모든 타입이 가능 <? extends Object> 와 동일 */


public class T06_WildCardTest {
	public static void main(String[] args) {
		
		FruitBox<Fruit> fruitBox = new FruitBox<>();	// 과일 상자
		FruitBox<Apple> appleBox = new FruitBox<>();	// 사과 상자
		
		fruitBox.add(new Apple());
		fruitBox.add(new Grape());
		
		appleBox.add(new Apple());
		appleBox.add(new Apple());
//		appleBox.add(new Grape());	// 사과인데 왜 포도를 넣냐? 제한을 걸었기 때문에 오류가 난다.
		
		Juicer.makeJuice(fruitBox);
//		Juicer.makeJuice(appleBox);	// Fruit 제한. 과일 상자가 들어온다고 했는데 왜 사과 상자를 집어넣냐?
									// Juicer에 제너릭 메서드를 사용해주면 허용 가능 범위가 넓어진다. <T extends Fruit> 
		
	}
}


// 쥬서: 과일의 상위 클래스
class Juicer{
	
//	 static void makeJuice(FruitBox<Fruit> box) {	// Fruit 타입만 허용 가능
	
//	 static <T extends Fruit>void makeJuice(FruitBox<T> box) {	// 제한된 타입 파라미터 이용(제너릭 메서드)
		// fruit을 extends한 클래스까지는 허용을 해주겠다. extends한 제너릭타입의 T가 오면 된다. 
		// 제한된 타입: (파라미터, extends, 상속받은 클래스명). super 같은거 쓰면 안 됨.
	
	 static void makeJuice(FruitBox<? extends Fruit> box) {	// 와일드 카드 이용
		 													// 융통성 면에서는 와일드 카드를 사용하는 것이 더 좋다.
		 
		 String fruitListStr = "";	// 과일 목록
		 
		 int cnt = 0;
		 for(Fruit f : box.getFruitList()) {
			 if(cnt == 0) {
				 fruitListStr += f;
			 }else {
				 fruitListStr += "," + f;
			 }
			 cnt++;
		 }
		 System.out.println(fruitListStr + "→ 쥬스 완성!");
		 
	 }
}

// 과일
class Fruit{
	
	private String name;

	public Fruit(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "과일(" + name + ")";
	}
	
}


class Apple extends Fruit{
	
	public Apple() {
		super("사과");
	}
	
}

class Grape extends Fruit{
	
	public Grape() {
		super("포도");
	}
	
}


// 과일 상자: 무슨 타입을 담을지는 컴파일 할 때 알 수 있다.
class FruitBox<T>{
	
	private List<T> fruitList;
	
	public FruitBox() {
		fruitList = new ArrayList<>();
	}

	public List<T> getFruitList() {
		return fruitList;
	}
	public void setFruitList(List<T> fruitList) {
		this.fruitList = fruitList;
	}
	
	public void add(T fruit) {
		fruitList.add(fruit);
	}
	
}






