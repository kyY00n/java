import java.util.Scanner;

public class HW1_3_윤가영 {

	public static void main(String[] args) {
		System.out.println("============");
		System.out.println("전공: 사이버보안");
		System.out.println("학번: 1971079");
		System.out.println("성명: 윤가영");
		System.out.println("============");
		
		String keepGoing = "y"; //계속 할건지 입력받을 변수
		String str = null; //대칭 검사할 문자열 변수
		
		Scanner sc = new Scanner(System.in);
		
		while(keepGoing.equalsIgnoreCase("y")) 
		{
			System.out.println("Input a word");
			str = sc.next(); //단어 입력받기
			
			char Arr[] = new char[100]; //문자배열 객체 생성
			Arr = str.toCharArray(); //입력받은 str을 문자 배열로 변환해 Arr에 저장
			
			if(check(Arr)==true) // Arr이 대칭이면
				System.out.println("Symmetry");
			else //대칭이 아니면
				System.out.println("Asymmetry");
			
			System.out.println();
			System.out.print("Try again?(y/n)");
			keepGoing = sc.next(); //다시 할건지 입력받기
			System.out.println();
		}

	}
	
	public static boolean check(char[] Arr) { //대칭 확인 방법: 양끝에 있는 문자가 같은지 비교한다
		
		for(int i = 0; i < Arr.length/2; i++) //반으로 나눠 짝맞춰서 대칭인지 검사하므로 (길이/2) 번 수행
		{
			if(Arr[i] != Arr[(Arr.length-1)-i]) //대칭이 아닌 짝이 있으면 false 반환
				return false;
		}
		return true; //끝까지 잘 수행했으면 true 반환
	}

}
