import java.util.Scanner;
public class Week1_3_윤가영 {

	public static void main(String[] args) {
		System.out.println("============");
		System.out.println("전공: 사이버보안");
		System.out.println("학번: 1971079");
		System.out.println("성명: 윤가영");
		System.out.println("============");
		
		//스캐너 sc를 생성합니다.
		Scanner sc = new Scanner(System.in);
		
		//화씨온도를 입력받습니다.
		System.out.println("화씨온도 입력: ");
		int temF = sc.nextInt();
		
		//섭씨온도를 계산합니다.
		float temC = (float) 5 / 9 * (F - 32);
		
		//온도를 출력합니다.
		System.out.println("화씨온도: " + temF);
		System.out.printf("섭씨온도: %.1f", temC); //섭씨온도는 소수점 첫째 자리까지 출력합니다.
	}

}