package kr.or.ddit.basic;

import java.util.Map;

public class T16_HorseRacingTest {
	
	static String strRank = "";
	
	public static void main(String[] args) {
		
		HorseRacing[] horse = new HorseRacing[] {
				new HorseRacing("1번 말 "),
				new HorseRacing("2번 말 "),
				new HorseRacing("3번 말 "),
				new HorseRacing("4번 말 "),
				new HorseRacing("5번 말 "),
				new HorseRacing("6번 말 "),
				new HorseRacing("7번 말 "),
				new HorseRacing("8번 말 "),
				new HorseRacing("9번 말 "),
				new HorseRacing("10번 말 "),
		};
		
		for(int i = 0; i < horse.length; i++) {
			horse[i].start();
		}
		
		for(HorseRacing hr : horse) {
			try {
				hr.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		System.out.println("▶ 경기 끝");
		System.out.println();
		System.out.println("──────────────────────────────────");
		System.out.println();
		System.out.println("▷ 경기 결과: ");
//		System.out.println("  순위: " + strRank);
		int i = 0;
		while(true) {
			
			String a = strRank.substring(0, strRank.indexOf("_"));
			System.out.println(++i + "등:\t" + a);
			strRank = strRank.substring(strRank.indexOf("_") + 1); 
			
			if(strRank.length() == 0 || strRank.length() <= 1) {break;}
		}
		
	}
	

}

//
//class Horse{
//	
//	private String horse;
//	private int rank;
//	
//	public Horse(String horse, int rank) {
//		this.horse = horse;
//		this.rank = rank;
//	}
//
//	
//}


class Stop{
	
	
	
	
}




class HorseRacing extends Thread{
	private String name;
	
	public HorseRacing(String name) {
		this.name = name;
	}

	@Override
	public void run() {
		
		boolean check = true;
		
		for(int i = 1; i <= 50; i++) {
			
			try {
				Thread.sleep((int)(Math.random() * 200 + 1));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			System.out.print("▷ " + name/* + "번 말  "*/);
			for(int j = 1; j <= 50; j++) {
				if(j == 1) {
					System.out.print("\t-");
				}
				if(j < i) {
					System.out.print("-");
				}else if(j == i) {
					System.out.print(">");
				}else if(j == 50) {
					System.out.print("-");
				}else{
					System.out.print("-");
				}
			}
			System.out.println();
//			System.out.println("─────────────────────────────────────────────────");
		}
		System.out.println("\t\t▶ " + name + "경주 끝");
		T16_HorseRacingTest.strRank += name + "_";		// 순위를 저장하기 위함
		
	}
	
}