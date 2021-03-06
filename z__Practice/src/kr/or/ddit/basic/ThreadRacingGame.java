package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ThreadRacingGame {
	static int racingRank = 1;	// 순위 저장

	public static void main(String[] args) {
		
		List<Horse1> racing = new ArrayList<>();
		racing.add(new Horse1("1번마"));
		racing.add(new Horse1("2번마"));
		racing.add(new Horse1("3번마"));
		racing.add(new Horse1("4번마"));
		racing.add(new Horse1("5번마"));
		racing.add(new Horse1("6번마"));
		racing.add(new Horse1("7번마"));
		racing.add(new Horse1("8번마"));
		racing.add(new Horse1("9번마"));
		racing.add(new Horse1("10번마"));
		
		for(int i = 0; i < racing.size(); i++) {
			racing.get(i).start();
		}
		
		while(true) {
			boolean finish = false;
			
			System.out.println("==========================================================");
			for(int i = 0; i < racing.size(); i++) {
				Thread.State state = racing.get(i).getState();

				for(int j = 0; j < 50; j++) {
					if(j == 0) {
						System.out.print(i + 1 + "번말\t" );
					} else if(j == racing.get(i).position) {
						System.out.print(">");
					} else {
						System.out.print("-");
					}
				}
				System.out.println();
				
				if(state != Thread.State.TERMINATED) {
					continue;
				}
				if(i == racing.size() - 1) {
					finish = true;
				}
			}
			System.out.println("==========================================================");
			
			if(finish) {
				break;
			}
			
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
					
		}
		
		for(Horse1 hs : racing) {
			try {
				hs.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		System.out.println("경기 끝.");
		System.out.println("----------------------------");
		System.out.println();
		System.out.println(" 경기 결과 ");
		
		Collections.sort(racing);
		
		for(Horse1 h : racing) {
			System.out.println(h);
		}
	}
}


// 영어 대문자를 출력하는 쓰레드 클래스
class Horse1 extends Thread implements Comparable<Horse1>{
	private String name;
	private int rank;
	int position = 0;
	
	public Horse1(String name) {
		super();
		this.name = name;
	}
	
	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}



	@Override
	public void run() {
		for(int i = 1; i <= 50; i++) {
			position = i;
			try {
				Thread.sleep((int)(Math.random() * 400 + 101));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println(name + " 완주.");
		rank = ThreadRacingGame.racingRank++;
	}

	@Override
	public int compareTo(Horse1 o) {
		return new Integer(this.rank).compareTo(o.rank);
	}

	@Override
	public String toString() {
		return "Horse1 [ 순위 = " + rank + ",  " + name +" ]";
	}
		
}