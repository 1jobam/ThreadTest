package tutorial;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HorseRacing {
	public static void main(String[] args) {
		
		List<Horse> mal = new ArrayList<Horse>();
			mal.add(new Horse("첫말"));
			mal.add(new Horse("두말"));
			mal.add(new Horse("셋말"));
			mal.add(new Horse("넷말"));
			mal.add(new Horse("다말"));
			mal.add(new Horse("여말"));
			mal.add(new Horse("칠말"));
			mal.add(new Horse("팔말"));
			mal.add(new Horse("구말"));
			mal.add(new Horse("십말"));
		
		for(Horse hor : mal) {
			hor.start();
		}
		
		Racing go = new Racing(mal);
			go.start();
		
	}
}

class Racing extends Thread{
	List<Horse> all;

	public Racing(List<Horse> all) {
		this.all = all;
	}
	
	@Override
	public void run() {
		String[] arr = new String[50];
		int ran = 0;
		boolean chk = true;
		
		while(chk) {
			
			for(Horse horrac : all) {
				if(horrac.isEnd() == true) {
					System.out.print(horrac.getNames() + " : ");
				for(int j = 0; j < 50; j++) {
					arr[j] = "*";
					System.out.print(arr[j]);
				}
				System.out.println();
				continue;	
				}
				
				System.out.println();
				System.out.print(horrac.getNames() + " : ");
				for(int i = 0; i < 50; i++) {
					arr[i] = "-";
					if(horrac.getLoc() == i) {
						arr[i] = ">";
					}
				}
				
				for(int j = 0; j < 50; j++) {
					System.out.print(arr[j]);
				}
				System.out.println();
				
				if(horrac.getLoc() >= 50) {
					horrac.setRank(ran);
					ran++;
					horrac.setEnd(true);
				}
			}
			
			try {
				Thread.sleep(1000);
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
			for(int i = 0; i < 55; i++) {
				System.out.print("=");
			}
			System.out.println();
			
			if(ran == 10) {
				System.out.println("경기 종료.");
				chk = false;
			}
			
		}
		
		Collections.sort(all);
		for(Horse res : all) {
			System.out.println(res.getNames() + " 말은 " + res.getRank() + "등 입니다.");
			System.out.println();
		}
		System.exit(0);
		
	}
}

class Horse extends Thread implements Comparable<Horse>{
	private String names;
	private int rank = 0;
	private int loc = 0;
	
	public int getLoc() {
		return loc;
	}

	public volatile boolean end = false;
	
	
	
	public Horse(String names) {
		this.names = names;
	}

	@Override
	public void run() {
		int count = 0;
		while(true) {
			loc += count;
			try {
				Thread.sleep((int)(Math.random() * 1000) + 1001);
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
			
			if(loc == 50) {
				break;
			}
			count++;
		}
	}

	public boolean isEnd() {
		return end;
	}

	public void setEnd(boolean end) {
		this.end = end;
	}

	public String getNames() {
		return names;
	}

	public void setNames(String names) {
		this.names = names;
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	@Override
	public int compareTo(Horse o) {
		return getNames().compareTo(getNames());
	}
}