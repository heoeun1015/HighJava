package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class T11_BaseBallTest {
	public static void main(String[] args) {
		
		/*문제) Set을 이용하여 숫자 야구 게임 프로그램을 작성하시오.
			컴퓨터의 숫자는 난수를 이용하여 구한다.
			(스트라이크는 'S', 볼은 'B'로 출력한다.)
			
			컴퓨터의 난수가 9 5 7 일 때 실행 예시
			
				- 숫자입력 → 3 5 6
				  3 5 6 → 1S 0B
				  
				- 숫자입력 → 7 8 9 
				  7 8 9 → 0S 2B
						…
				- 숫자입력 → 9 5 7
				  9 5 7 → 3S 0B
				
				5번째 만에 맞추셨군요.*/
		
		
		Set computer = new HashSet<Integer>();
		
		while(computer.size() < 3) {
			int num = (int)(Math.random() * 9 + 1);
			computer.add(num);
		}
		
		
		ArrayList<Integer> comList = new ArrayList<Integer>(computer);
		
		Collections.shuffle(comList);
		
		System.out.println(comList);
		
		
		Scanner s = new Scanner(System.in);
		
		int cnt = 0;
		int strike = 0;
		System.out.println("─────────────────[야구게임]─────────────────");
		do {
			System.out.print("▷ 세 자리의 숫자를 입력해주세요.: ");
			int input = Integer.parseInt(s.nextLine());
			
			int input3 = input % 10;
			input /= 10;
			int input2 = input % 10;
			input /= 10;
			int input1 = input % 10;
			
			strike = 0;
			int ball = 0;
			
			if(comList.get(0) == input1) strike++;
			if(comList.get(1) == input2) strike++;
			if(comList.get(2) == input3) strike++;
			
			if(comList.get(0) == input2 || comList.get(0) == input3) ball++;
			if(comList.get(1) == input1 || comList.get(1) == input3) ball++;
			if(comList.get(2) == input1 || comList.get(2) == input2) ball++;
			
			cnt++;
			
			if(strike == 3) {
				System.out.println("─────────────────────────────────────────");
				System.out.println(strike + "S " + ball + "B");
				System.out.println("▷ " + cnt +"번만에 맞추셨습니다!");
			}else {
				System.out.println(strike + "S " + ball + "B");
			}
			
		}while(strike != 3);
		System.out.println("─────────────────────────────────────────");
		
			
		
	}
}
