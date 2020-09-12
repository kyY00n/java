package ass3;
import java.util.Scanner;

class Circle{
	final double PI = 3.14159; //상수선언
	private double radius; //private 상수 선언
	
	public void setRadius (double rd) //반지름 setter
	{
		radius = rd;
	}
	public double getRadius() { //반지름 getter
		return radius;
	}
	public double perimeter() { //원주 계산 method
		return PI*2*radius;
	}
	public double area() { //넓이 계산 method
		return PI*radius*radius;
	}
	public void circleinfo() { //원 정보 리턴 함수
		System.out.println("반지름:" + this.getRadius());
		System.out.printf("원둘레:%.2f\n", this.perimeter());
		System.out.printf("원넓이:%.2f\n", this.area());
	}
}

public class Week3_2_윤가영 {

	public static void main(String[] args) {
		System.out.println("============");
		System.out.println("전공: 사이버보안");
		System.out.println("학번: 1971079");
		System.out.println("성명: 윤가영");
		System.out.println("============");
		
		Scanner kbd = new Scanner(System.in); //스캐너 생성
		Circle cc = new Circle(); // Circle 객체 생성
		
		System.out.print("반지름입력:"); 
		cc.setRadius(kbd.nextDouble()); //반지름 입력받기 (Double)
		
		cc.circleinfo(); //cc 정보 출력하기.
	}

}
