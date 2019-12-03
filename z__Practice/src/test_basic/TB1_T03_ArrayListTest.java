package test_basic;

import java.util.ArrayList;
import java.util.Scanner;

public class TB1_T03_ArrayListTest {
	
//	문제1) 5명의 사람 이름을 입력하여 ArrayList에 저장하고 이 중에 '김'씨 성의 이름을 출력하시오.
//	(단, 입력은 Scanner를 이용하여 입력받는다.)

	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		
		ArrayList<String> list = new ArrayList<String>();
		
		
		System.out.println("▷ 총 5명의 이름을 입력해주세요.");
		String input = "";
		
		for(int i = 0; i < 5; i++) {
			System.out.print("- 이름을 입력해주세요.(" + (i + 1) + "번): ");
			input = s.nextLine();
			list.add(input);
		}
		
		String tmp = "";
		
		System.out.println("-----------------------");
		System.out.print("문제1) 김씨 성을 가진 사람: ");
		for(int i = 0; i < list.size(); i++) {
			String tmp1 = list.get(i).substring(0,1); 
			if(tmp1.contains("김")) {
				tmp += list.get(i) + ", ";
			}
		}System.out.println(tmp.substring(0, tmp.lastIndexOf(", ")));
		
		//if(name.charAt(0) == "김"){}
		//if(name.substring(0,1).equals("김")){}
		//if(name.indexOf("김"))==0){}
		//if(name.startWith("김")){}
		
		
	}
	
}
