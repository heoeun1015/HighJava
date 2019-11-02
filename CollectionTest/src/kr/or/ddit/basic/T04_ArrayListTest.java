package kr.or.ddit.basic;

import java.util.ArrayList;

public class T04_ArrayListTest {
	public static void main(String[] args) {
		
		
//		문제2) 5명의 별명을 입력하여 ArrayList에 저장하고, 별명의 길이가 제일 긴 별명을 출력하시오.
//		(단, 각 별명의 길이는 모두 다르게 입력한다.)
		
//		문제3) 문제2에서 별명의 길이가 같은 것을 여러개 입력했을 때도 출력되도록 처리하시오.

		
		ArrayList<String> list2 = new ArrayList<String>();
		
		list2.add("너구리");
		list2.add("오리너구리입술");
		list2.add("아메리카");
		list2.add("원숭이꼬리만두");
		list2.add("감자칩");
		
		int max = list2.get(0).length();
		String tmp2 = ""; 
		
		for(int i = 0; i < list2.size(); i++) {
			if(max < list2.get(i).length()) {
				max = list2.get(i).length();
			}
		}
		
		System.out.print("문제2) 가장 긴 별명을 가진 사람: ");
		for(int i = 0; i < list2.size(); i++) {
			if(max == list2.get(i).length()) {
				tmp2 += list2.get(i) + ", ";
			}
		}System.out.println(tmp2.substring(0, tmp2.lastIndexOf(", ")));
		
		
		
		
	}
}
