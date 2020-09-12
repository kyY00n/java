package ass3;
import java.util.Scanner;

class Song{
	String title;
	String singer;
	int price;
	
	public void play() { // 선택한 노래 틀어주는 play method
		System.out.println("노래들어요: \""+title+"\" by "+singer);
	}
	
	public void price() { // 가격 보여주는 method
		System.out.println(price +"원입니다.");
	}
}
public class Week3_1_윤가영 {

	public static void main(String[] args) {
		System.out.println("============");
		System.out.println("전공: 사이버보안");
		System.out.println("학번: 1971079");
		System.out.println("성명: 윤가영");
		System.out.println("============");
		
		Scanner kbd = new Scanner(System.in); //스캐너 생성
		//Song 객체 2개 생성
		Song s1 = new Song(); 
		Song s2 = new Song();
		
		//첫번째 노래 정보 입력받기
		System.out.println("\n*Song 1*");
		System.out.print("곡명입력:");
		s1.title = kbd.nextLine();
		System.out.print("가수명입력:");
		s1.singer = kbd.nextLine();
		System.out.print("가격입력:");
		s1.price = kbd.nextInt();
		
		kbd.nextLine(); //버퍼에 남은 엔터 지우기
		
		//두번째 노래 정보 입력받기
		System.out.println("\n*Song 2*");
		System.out.print("곡명입력:");
		s2.title = kbd.nextLine();
		System.out.print("가수명입력:");
		s2.singer = kbd.nextLine();
		System.out.print("가격입력:");
		s2.price = kbd.nextInt();
		
		//노래 고르기
		System.out.println("\n노래를 고르세요");
		System.out.println("1:"+s1.title+" 2:"+s2.title);
		int songNum;
		songNum = kbd.nextInt();
		
		if(songNum == 1) { //1번 골랐을 때
			s1.play();
			s1.price();
		}
		else if(songNum == 2) { //2번 골랐을 때
			s2.play();
			s2.price();
		}
		else //이상한 숫자 눌렀을 때
			System.out.println("잘못된 입력입니다.");
		
		System.out.println("감사합니다."); //종료
	}

}
