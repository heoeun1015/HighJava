package test_basic;

import java.util.Arrays;

 	// 와일드카드 타입 예제  
 
public class TB2_T07_WildCardTest {
	
	
	/* << 와일드 카드 예제 >>
	 
	 <? extends T> => 와일드 카드의 상한 제한. T와 그 자손들만 가능
	 <? super T>   => 와일드 카드의 하한 제한. T와 그 조상들만 가능
	 <?>           => 모든타입이 가능 <? extends Object>와 동일 */
	
	
	/** 모든과정 등록
	  @param course 모든과정 */
	public static void registerCourse(Course<?> course) {	// 어떤 코스든 받아들이겠다. 직장인이든 학생이든 뭐든.
		System.out.println(course.getName() 
							+ " 수강생: " 
				            + Arrays.toString(course.getStudent1s()));
	}
	
	/** 학생과정 등록
	 @param course 학생 */
	public static void registerCourseStudent1(Course<? extends Student1> course) {
		// Student1 일 수도 있고, HighStudent1일 수도 있다.
		System.out.println(course.getName() 
				+ " 수강생: " 
				+ Arrays.toString(course.getStudent1s()));
	}
	
	/** 직장인과정 등록
	  @param course 직장인과 일반인 */
	public static void registerCourseWorker(Course<? super Worker> course) {	//Worker랑 Person
		System.out.println(course.getName() 
				+ " 수강생: " 
				+ Arrays.toString(course.getStudent1s()));
	}
	
	public static void main(String[] args) {
		
		Course<Person> personCourse = new Course("일반인과정", 5);
		personCourse.add(new Person("일반인1"));
		personCourse.add(new Worker("직장인1"));
		personCourse.add(new Student1("학생1"));
		personCourse.add(new HighStudent1("고등학생1"));
		
		Course<Worker> workerCourse = new Course("직장인과정", 5);
		workerCourse.add(new Worker("직장인1"));
		
		Course<Student1> studentCourse = new Course("학생과정", 5);
		studentCourse.add(new Student1("학생1"));
		studentCourse.add(new HighStudent1("고등학생1"));
//		studentCourse.add(new Worker("직장인1"));		//에러.
		
		Course<HighStudent1> highStudent1Course = new Course("고등학생과정", 5);
		highStudent1Course.add(new HighStudent1("고등학생1"));
		
		registerCourse(personCourse);
		registerCourse(workerCourse);
		registerCourse(studentCourse);
		registerCourse(highStudent1Course);
		System.out.println("──────────────────────────────────────────────────────────────");
		
//		registerCourseStudent1(personCourse);	// 타입 에러
//		registerCourseStudent1(workerCourse);	// 타입 에러
		registerCourseStudent1(studentCourse);
		registerCourseStudent1(highStudent1Course);
		System.out.println("──────────────────────────────────────────────────────────────");
		
		registerCourseWorker(personCourse);
		registerCourseWorker(workerCourse);
//		registerCourseWorker(studentCourse);
//		registerCourseWorker(highStudent1Course);
	}
}



// Person클래스
class Person{
	String name; // 이름
	public Person(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return "이름:" + name;
	}
}

// Worker
class Worker extends Person{
	public Worker(String name) {
		super(name);
	}
}

class Student1 extends Person{
	public Student1(String name) {
		super(name);
	}
}

class HighStudent1 extends Student1{	// extends Student1
	public HighStudent1(String name) {
		super(name);
	}
}


// 수강코스
class Course<T>{
	private String name; // 코스명
	private T[] students; // 수강생 배열
	
	public Course(String name, int capacity) {
		this.name = name;
		// 타입 파라미터로 배열을 생성시 오브젝트 배열을 생성후, 
		// 타입파라미터 배열로 캐스팅 처리해야함.
		students = (T[])(new Object[capacity]); 	// 오브젝트로 만든 다음에 캐스팅
	}
	
	public String getName() { return name; }
	public T[] getStudent1s() { return students; }
	public void add(T t) {
		for(int i=0; i<students.length; i++) {
			if(students[i] == null) {
				students[i] = t;
				break;
			}
		}
	}
}
