
public class Week4_3_윤가영 {

	public static void main(String[] args) {
		int a = 5, b = 10;
		double da = 3.4, db = 5.2;
		char ca = 'a', cb = 'b' ;
		int iarr[] = {1, 2, 3};
		double darr[] = {1.1, 2.2, 3.3};
		char carr[] = {'a', 'p', 'p', 'l', 'e'};
		System.out.println("a+b="+sum(a,b));
		System.out.println("da+b="+sum(da,b));
		System.out.println("a+db="+sum(a,db));
		System.out.println("da+db="+sum(da,db));
		System.out.println("ca+cb="+sum(ca,cb));
		System.out.println("sum of Int_Arr="+sum(iarr));
		System.out.println("sum of Double_Arr="+sum(darr));
		System.out.println("sum of Char_Arr="+sum(carr));
	}
	
	//정수 인자를 받는 sum()
	public static int sum(int a, int b) {
		return a + b;
	}
	
	//실수, 정수를 인자로 받는 sum()
	public static double sum(double da, int b) {
		return da + b;
	}
	
	//정수, 실수
	public static double sum(int a, double db) {
		return a + db;
	}
	
	//실수, 실수
	public static double sum(double da, double db) {
		return da + db;
	}
	
	//문자, 문자
	public static String sum(char ca, char cb) {
		//문자를 이어붙이기 위해 문자열 변수를 만들었습니다.
		String sa = Character.toString(ca); //static 메서드를 사용해 char를 String으로 바꿨어요.
		String sb = Character.toString(cb);
		return sa + sb;
	}
	
	//정수배열
	public static int sum(int[] arr) {
		int result = 0; //메서드가 리턴할 합계입니다.
		
		//배열의 원소들을 모두 더해줍니다.
		for(int i = 0 ; i < arr.length ; i++) {
			result += arr[i];
		}
		//계산 결과를 반환합니다.
		return result;
	}
	
	//실수 배열
	public static double sum(double[] darr) {
		double result = 0; // 메서드가 리턴할 합계입니다.
		
		//배열의 원소들을 result에 모두 더해줍니다.
		for(int i = 0; i < darr.length; i++) {
			result += darr[i];
		}
		//계산 결과를 반환합니다.
		return result;
	}
	
	//문자 배열
	public static String sum(char[] carr) {
		String result = ""; // 메서드가 리턴할 문자열입니다.
		String concat = null; // 각 인덱스의 문자를 String으로 변환한 것을 저장할 String변수입니다.
		
		//배열의 문자를 순서대로 result에 concatenate 해주어요.
		for(int i = 0; i < carr.length; i++) {
			concat = Character.toString(carr[i]);
			result += concat;
		}
		//다 이어붙인 result를 반환합니다.
		return result;
	}
}
