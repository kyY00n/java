import java.util.Scanner;
import java.lang.Math;

public class Week8_윤가영 {

	public static void main(String[] args) {
		System.out.println("============");
		System.out.println("전공: 사이버보안");
		System.out.println("학번: 1971079");
		System.out.println("성명: 윤가영");
		System.out.println("============");
		
		Game g = new Game(); // Game 객체 생성
		g.play(); //게임 play
	}

}

class Game {
	private int youIn, comIn; //사용자와 컴퓨터의 입력을 저장할 변수
	private int youWin, comWin; //사용자와 컴퓨터가 각각 이긴 횟수
	
	public void play() {
		System.out.println("가위바위보 게임을 시작합니다.");
		
		//반복문
		while(youWin< 3 && comWin < 3) { //이긴 횟수가 3이 되면 게임 종료
			System.out.println("당신의 선택은?(You("+youWin+") - Com("+comWin+"))"); //이긴 횟수 출력
			System.out.println("가위(1) 바위(2) 보(3)");
			input();
		}//반복문 종료
		
		System.out.println();
		System.out.println("You("+youWin+")  Com("+comWin+")");
		if(youWin > comWin)
			System.out.println("당신이 이겼습니다.");
		else
			System.out.println("컴퓨터가 이겼습니다.");
		System.out.println("게임을 종료합니다.");
	}
	
	public void input() { //사용자 입력 받는 메서드
		Scanner sc = new Scanner(System.in);
		
		try
		{	//사용자의 입력을 받습니다.
			youIn = sc.nextInt();
			
			if (youIn < 1 || youIn > 3) //1,2,3에 포함되지 않는 경우
				throw new Exception("범위가 잘못됐습니다.");
			
			//컴퓨터의 입력을 받습니다.(랜덤메서드사용)
			comIn = (int) (Math.random()*3) + 1;
			
			//사용자와 컴퓨터의 입력을 보여줍니다.
			System.out.println("<You>   <Com>");
			System.out.println(IntToShape(youIn)+"          "+IntToShape(comIn));
			
			//게임 결과를 출력합니다.
			writeOutput();
		}
		catch(Exception e) //오류 처리
		{
			System.out.println(e.getMessage());
			System.out.println();
		}
	}
	
	public void writeOutput() { //가위바위보 결과를 출력하는 메서드
		
		//다른 방법을 열심히 생각해봤으나 이게 최선이었습니다.. 제가 쓴 방법은 대소비교입니다.
		//근데 가위(1) 보(3) 의 경우 승패와 대소가 반대라서 따로 써주었습니다.
		//이긴 분 출력 후 이긴 횟수 증가시켜주었습니다.
		if(comIn < youIn) {
			if (comIn == 1 && youIn ==3) {
				System.out.println("컴퓨터 승"); comWin++;
			}
			else {
				System.out.println("당신 승"); youWin++;
			}
		}
		else if(comIn > youIn) {
			if (comIn == 3 && youIn == 1) {
				System.out.println("당신 승"); youWin++;
			}
			else {
				System.out.println("컴퓨터 승"); comWin++;
			}
		}
		else
			System.out.println("비김");
		
		System.out.println();
	}
	
	public String IntToShape (int num) { //숫자를 받아 손모양을 반환하는 메서드
		if(num == 1)
			return "가위";
		else if(num == 2)
			return "바위";
		else 
			return "보";
	}
}