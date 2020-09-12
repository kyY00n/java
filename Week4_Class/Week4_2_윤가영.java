import java.util.Scanner;

class Facto {
	//두 개의 factorial 값의 차이를 저장할 static 변수입니다.
	public static int result;
	
	//팩토리얼 계산 해주는 static 메소드 정의
	public static int factoVal(int x) { // x>=0 이라고 가정했습니다
		int xFact = 1;
		
		if(x==0) //x가 0일 때
			return 1;
		
		for(int i = x; i > 0; i--) { //x*(x-1)*...*2*1 이런 식으로 factorial을 계산합니다.
			xFact *= i;
		}
		return xFact; //계산 결과를 반환합니다.
	}
}
public class Week4_2_윤가영 {

	public static void main(String[] args) {
		System.out.println("============");
		System.out.println("전공: 사이버보안");
		System.out.println("학번: 1971079");
		System.out.println("성명: 윤가영");
		System.out.println("============");
		
		Scanner kbd = new Scanner(System.in); //스캐너 생성.
		
		//첫 번째 원소를 입력받습니다.
		System.out.print("첫번째 원소 입력:");
		int firstElement = kbd.nextInt();
		
		//두 번째 원소를 입력받습니다.
		System.out.print("두번째 원소 입력:");
		int secondElement = kbd.nextInt();
		
		//Facto class의 static 변수 result에 두 팩토리얼 값의 차를 저장합니다.
		Facto.result = Facto.factoVal(firstElement) - Facto.factoVal(secondElement);
		
		//result값을 출력합니다.
		System.out.println("Factorial("+firstElement+") - Factorial("+secondElement+") = "
							+ Facto.result);
	}

}
