import java.util.Scanner;
public class Week1_2_윤가영 {

	public static void main(String[] args) {
		System.out.println("============");
		System.out.println("전공: 사이버보안");
		System.out.println("학번: 1971079");
		System.out.println("성명: 윤가영");
		System.out.println("============");
		
		//스캐너 sc를 생성합니다.
		Scanner sc = new Scanner(System.in);
		
		//정수 3개를 입력받습니다.
		System.out.println("정수 세 개 입력");
		int num1 = sc.nextInt();
		int num2 = sc.nextInt();
		int num3 = sc.nextInt();
		
		//평균을 계산합니다.
		float value = (float) (num1 + num2 + num3) / 3;
		//평균을 소수점 둘째 자리까지 출력합니다.
		System.out.printf("평균: %.2f", value);

	}

}