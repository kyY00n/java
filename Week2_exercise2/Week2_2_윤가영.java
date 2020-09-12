import java.util.Scanner;

public class Week2_2_윤가영 {

	public static void main(String[] args) {
		System.out.println("============");
		System.out.println("전공: 사이버보안");
		System.out.println("학번: 1971079");
		System.out.println("성명: 윤가영");
		System.out.println("============");
		
		Scanner sc = new Scanner(System.in); //스캐너를 생성합니다.
		
		String degreeType; //온도의 종류를 입력받을 String 변수
		double Degree_C = 0; //섭씨 온도
		int Degree_F = 0; //화씨 온도
		String keepGoing; //y를 입력받을 String 변수
		
		while(true) {
			//온도의 종류를 입력받습니다.
			System.out.println("입력할 온도의 종류? C(섭씨) 또는 F(화씨): ");
			degreeType = sc.nextLine();
			
			//C또는c를 입력한 경우
			if(degreeType.equalsIgnoreCase("C")) {
				System.out.println("섭씨온도 (실수) 입력");
				Degree_C = sc.nextDouble();
				
				sc.nextLine(); //마지막에 keepGoing을 입력받기 위해 버퍼에 남은 엔터를 지웁니다.
				
				Degree_F = (int) (9*Degree_C/5) + 32; //화씨 온도를 계산합니다.

				System.out.printf("섭씨 %.1f도/화씨 %d도\n", Degree_C, Degree_F); //printf로 온도를 출력합니다.
			}
			
			//F또는f를 입력한 경우
			else if(degreeType.equalsIgnoreCase("F")) {
				System.out.println("화씨온도 (정수) 입력");
				Degree_F = sc.nextInt();
				
				sc.nextLine(); //마찬가지로 keepGoing을 입력받기 위해 버퍼에 남은 엔터를 지웁니다.
				
				Degree_C = (double) 5 * (Degree_F - 32) / 9; //섭씨 온도를 계산합니다.
				
				System.out.printf("화씨 %d도/섭씨 %.1f도\n", Degree_F, Degree_C);
			}
			
			//잘못된 입력의 경우
			else
				System.out.println("잘못된 입력\n\n");
			
			
			//온도 계산이 끝나고 프로그램을 계속할 지 입력받습니다.
			System.out.println("계속하시겠습니까? (Y)");
			keepGoing = sc.nextLine();
			
			//Y또는y가 아닐 경우 프로그램을 종료합니다.
			if(!keepGoing.equalsIgnoreCase("Y")) {
				System.out.println("프로그램 종료");
				break;
			}
			
			System.out.println("\n");
		}
	}
}
