import java.util.Scanner; //외부 클래스 사용
public class Week1_1_윤가영 {

	public static void main(String[] args) {
		System.out.println("============");
		System.out.println("전공: 사이버보안");
		System.out.println("학번: 1971079");
		System.out.println("성명: 윤가영");
		System.out.println("============");
		
		//스캐너 클래스 sc를 생성합니다. 
		Scanner sc = new Scanner(System.in);
		
		//밑변을 입력받습니다.
		System.out.println("Input base :");
		int base = sc.nextInt();
		
		//높이를 입력받습니다.
		System.out.println("Input height :");
		int height = sc.nextInt();
		
		//넓이를 계산합니다.
		float area = (float) base * height / 2;
		
		//넓이를 출력합니다.
		System.out.println("The area: "+ area);
	}

}