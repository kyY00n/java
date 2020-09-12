import java.util.Scanner;

public class Week2_1_윤가영 {

	public static void main(String[] args) {
		System.out.println("============");
		System.out.println("전공: 사이버보안");
		System.out.println("학번: 1971079");
		System.out.println("성명: 윤가영");
		System.out.println("============");
		
		Scanner sc = new Scanner(System.in); //스캐너를 생성합니다.
		
		//현금의 총 액수를 입력받습니다.
		System.out.print("Input the amount of money(0~100000): ");
		int money = sc.nextInt();
		
		//올바른 입력(0원~100000원)의 경우
		if(money>=0 && money<=100000) {
			System.out.println("The output will be");
			
			//먼저 5만원으로 나눈 몫을 출력합니다.
			System.out.printf("50000 won: %d\n", money/50000);
			//그리고 5만원으로 나눈 나머지를  money에 저장합니다.
			money %= 50000;
			
			//이 과정을 10원까지 반복합니다.
			System.out.printf("10000 won: %d\n", money/10000);
			money %= 10000;
			
			System.out.printf("5000 won: %d\n", money/5000);
			money %= 5000;
			
			System.out.printf("1000 won: %d\n", money/1000);
			money %= 1000;
			
			System.out.printf("500 won: %d\n", money/500);
			money %= 500;
			
			System.out.printf("100 won: %d\n", money/100);
			money %= 100;
			
			System.out.printf("50 won: %d\n", money/50);
			money %= 50;
			
			System.out.printf("10 won: %d\n", money/10);
			money %= 10;
			
			//이제 money에는 1원 단위만 저장돼있으므로 money를 그대로 출력합니다.
			System.out.printf("Remainder: %d\n", money);
		}
		
		//잘못된 입력의 경우
		else
			System.out.println("잘못된 입력");
	}

}
