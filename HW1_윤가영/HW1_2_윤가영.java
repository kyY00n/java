import java.util.Scanner;
import java.lang.Math;

class DiceGame {
	private int diceFace = 1;
	private int userGuess = 1;
	
	public DiceGame() {
		
	}
	
	private int rollDice() { //Math 클래스의 random()메서드로 주사위 눈 반환
		return (int)(Math.random()*6) + 1;
	}
	
	private int getUserInput() { //1~6 범위 내인지 check하는 메서드
		int input = 0;
		Scanner sc = new Scanner(System.in);
		
		while(true) //반복문
		{ 
			input = sc.nextInt(); //사용자의 입력을 저장할 변수
			
			if(input >=1 && input <=6) { //사용자 입력이 범위 내에 있으면
				userGuess = input; //클래스의 userGuess 에 대입합니다.
				return userGuess; //그리고 userGuess를 반환합니다.
			}
			else //범위 내에 있지 않으면 반복합니다.
				System.out.println("Input number between 1~6.");
		}
	}
	
	private void checkUserGuess(int input) {
		
		if(diceFace == input) //만약 사용자가 맞췄을 때
			System.out.println("Bingo!");
		
		else //틀렸을 때
			System.out.println("Wrong!");
			System.out.println("The face was " + diceFace);
			
	}
	
	public void startPlaying() { //게임 하는 메서드
		
		System.out.println("<< GAME START >>"); //게임시작
		
		diceFace = this.rollDice(); //주사위 던지기
		System.out.println("Dice is rolled!!");
		
		System.out.println("Guess the number! What do you think?");
		
		this.checkUserGuess(this.getUserInput()); //사용자 입력과 주사위 눈이 일치하는 지 check
		
	}
}
public class HW1_2_윤가영 {

	public static void main(String[] args) {
		System.out.println("============");
		System.out.println("전공: 사이버보안");
		System.out.println("학번: 1971079");
		System.out.println("성명: 윤가영");
		System.out.println("============");
		
		Scanner sc = new Scanner(System.in); //스캐너 생성
		
		String keepGoing = "y"; //사용자가 게임을 계속 할건지 입력받는 변수
		DiceGame dg = new DiceGame(); //새로운 게임 객체 생성
		
		while(!keepGoing.equalsIgnoreCase("n")) { //사용자가 n을 누르지 않으면
			
			dg.startPlaying(); //게임 실행
			
			System.out.println("Try again?(y/n)");
			keepGoing = sc.nextLine(); //계속 할건지 입력받기
			
			System.out.println();
		}
		
		System.out.println("Game finished."); //게임 종료
	}

}
