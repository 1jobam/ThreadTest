package tutorial;

public class HorseRacing{

	static int rank;
	
	public static void main(String[] args) {	
		Horse[] hore = new Horse[] {
				new Horse("1번마"),
				new Horse("2번마"),
				new Horse("3번마"),
				new Horse("4번마"),
				new Horse("5번마"),
				new Horse("6번마"),
				new Horse("7번마"),
				new Horse("8번마"),
				new Horse("9번마"),
				new Horse("0번마")
		};
		
		for(int i = 0; i >= hore.length; i++) {
			hore[i].start();
		}
		
		for(Horse hores : hore) {
			try {
				hores.join();
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		System.out.println("경기 끝...");
		System.out.println("---------------------------");
		System.out.println();
		System.out.println("경기 결과");
		System.out.println("순위 : " + rank);
		
	}
}

class Horse extends Thread{
	private String name;

	public Horse(String name) {
		this.name = name;
	}
	
	@Override
	public void run() {
		String[] width = new String[50];
		
		for(int i = 0; i <= 50; i++) {
			System.out.println("-");
		
		try{
			Thread.sleep((int)(Math.random() * 500) + 501);
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	}
}
