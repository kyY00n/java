import java.util.Scanner;

class Song {
	public String title;
	public String singer;
	public int price;
	
	public void play() {
		System.out.println(title+" by "+singer);
	}
	
	public Song() { //default 생성자
		
	}
	
	public Song(String title, int price) { //가수 정보가 없는 생성자
		this(title,"모름",price);
	}
	
	public Song(String title, String singer, int price) { //모든 정보가 있는 생성자
		this.title = title;
		this.singer = singer;
		this.price = price;
	}
}

public class Week4_1_윤가영 {

	public static void main(String[] args) {
		System.out.println("============");
		System.out.println("전공: 사이버보안");
		System.out.println("학번: 1971079");
		System.out.println("성명: 윤가영");
		System.out.println("============");
		
		//스캐너 입력값을 각각 노래 제목, 가수, 가격을 저장할 변수입니다.
		String inputTt = null;
		String inputSinger = null;
		int inputPrice = 0;
		
		Scanner kbd = new Scanner(System.in); //스캐너 생성
		
		System.out.println("*Song 정보*");
		System.out.print("곡명: ");
		inputTt = kbd.nextLine(); //곡명을 입력받아요.
		
		while(inputTt.equals("")) { //곡명을 입력하지 않으면 계속 실행될 while문 입니다.
			System.out.println("곡명은 반드시 필요합니다.");
			System.out.print("곡명: ");
			inputTt = kbd.nextLine();
		}
		
		//가수를 입력받아요.
		System.out.print("가수명: ");
		inputSinger = kbd.nextLine();
		//가격을 입력받아요.
		System.out.print("가격: ");
		inputPrice = kbd.nextInt();
		
		//Song 클래스 변수를 선언합니다.
		Song ipSong;
		
		if(!inputSinger.equals("")) { //가수명을 입력한 경우, 세 인자를 모두 사용하는 생성자를 사용합니다.
			ipSong = new Song(inputTt, inputSinger, inputPrice);
		}
		else //가수명을 입력하지 않은 경우에는 가수명이 필요없는 생성자를 사용합니다.
			ipSong = new Song(inputTt, inputPrice);
		
		System.out.println("몇 번 들으시겠습니까?");
		int count = kbd.nextInt(); //들을 횟수를 입력받습니다.
		for(int i = 0; i < count; i++) {
			ipSong.play(); //입력받은 횟수만큼 play()를 호출합니다.
		}
		System.out.println("총 "+inputPrice*count+"원입니다."); //총 가격을 출력합니다.
		
	}

}
