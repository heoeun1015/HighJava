package test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/*	문제) 학번, 이름, 국어점수, 영어점수, 수학점수, 총점, 등수를 멤버로 갖는 Student 클래스를 만든다.
	생성자는 학번, 이름, 국어, 영어, 수학 점수만 매개변수로 받아서 처리한다.
	
	 이 Student 객체들은 List에 저장하여 관리한다.
	List에 저장된 데이터들을 학번의 오름차순으로 정렬하여 출력하는 부분과,
	 총점의 역순으로 정렬하는 부분을 프로그래밍 하시오.
	(총점이 같으면 학번의 내림차순으로 정렬되도록 한다.)
	(학번 정렬 기준은 Student 클래스 자체에서 제공하도록 하고, 총점 정렬 기준은 외부클래스에서 제공하도록 한다.)*/


public class T1_T08_StudentTest {
	public static void main(String[] args) {
		
		List<Student> stuList = new ArrayList<Student>();
		
		stuList.add(new Student(1, "이순신", 30, 50, 60));
		stuList.add(new Student(5, "강감찬", 30, 50, 60));
		stuList.add(new Student(3, "을지문덕", 88, 87, 80));
		stuList.add(new Student(8, "세종대왕", 100, 100, 100));
		stuList.add(new Student(2, "남궁성", 80, 70, 98));
		
		for(int i = 0; i < stuList.size(); i++) {
			int num = 1;
			stuList.get(i).setRank(num);
			for(int j = 0; j < stuList.size(); j++) {
				if(stuList.get(i).getSum() < stuList.get(j).getSum()) {
					stuList.get(i).setRank(++num);
				}else {
					stuList.get(i).setRank(num);
				}
			}
		}
		
//		Collections.sort(stuList);
		Collections.sort(stuList, new Desc());
		
		for(Student stu : stuList) { 
			System.out.println(stu);
		}
		
	}
}


class Desc implements Comparator<Student>{

	@Override
	public int compare(Student stu1, Student stu2) {
		if(stu1.getSum() > stu2.getSum()) {
			return -1;
		}else if(stu1.getSum() == stu2.getSum()) {
			return new Integer(stu1.getNum()).compareTo(new Integer(stu2.getNum())) * -1;
		}else {
			return 1;
		}
	}
	
}


class Student /*implements Comparable<Student>*/{
	
	private int num;
	private String name;
	private int kor;
	private int eng;
	private int math;
	private int sum;
	private int rank;
	
	public Student(int num, String name, int kor, int eng, int math) {
		super();
		this.num = num;
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
		this.sum = kor + eng + math;
	}
	
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
	public int getKor() {
		return kor;
	}
	public void setKor(int kor) {
		this.kor = kor;
	}
	public int getEng() {
		return eng;
	}
	public void setEng(int eng) {
		this.eng = eng;
	}
	public int getMath() {
		return math;
	}
	public void setMath(int math) {
		this.math = math;
	}
	public int getSum() {
		return sum;
	}
	public void setSum(int sum) {
		this.sum = sum;
	}
	public int getRank() {
		return rank;
	}
	public void setRank(int rank) {
		this.rank = rank;
	}
	
	@Override
	public String toString() {
		return "학생 [num=" + num + ", name=" + name + ", kor=" + kor + ", eng=" + eng + ", math=" + math + ", sum="
				+ sum + ", rank=" + rank + "]";
	}

//	@Override
//	public int compareTo(Student stu) {
//		return new Integer(getNum()).compareTo(stu.getNum());
//	}
	
}
