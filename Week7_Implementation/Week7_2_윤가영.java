import java.util.Scanner;

interface Geometry{ //Geometry 인터페이스 정의
	public final double PI = 3.14159;
	
	public double area();
	public double perimeter();
}

class Circle implements Geometry{ //Circle 클래스 정의입니다.
	public double radius;
	
	public Circle() {}
	public Circle(double radius) {
		this.radius = radius;
	}
	
	//인터페이스의 메서드를 구현합니다.
	//area()
	public double area() { 
		return PI*radius*radius;
	}
	//perimeter()
	public double perimeter() {
		return 2*PI*radius;
	}
	
}

class Square implements Geometry{
	public double side;
	
	public Square() {}
	public Square(double side) {
		this.side = side;
	}
	
	//인터페이스의 메서드를 구현합니다.
	public double area() {
		return side*side;
	}
	
	public double perimeter() {
		return 4*side;
	}	
}

class Triangle implements Geometry {
	public double a;
	public double b;
	public double c;
	
	public Triangle() {}
	public Triangle(double a, double b, double c) {
		this.a = a; this.b = b; this.c = c;
	}
	
	//인터페이스의 메서드를 구현합니다.
	public double area() {
		double s = (a+b+c)/2;
		return Math.sqrt(s*(s-a)*(s-b)*(s-c));
	}
	
	public double perimeter() {
		return a+b+c;
	}
}
public class Week7_2_윤가영 {

	public static void main(String[] args) {
		System.out.println("============");
		System.out.println("전공: 사이버보안");
		System.out.println("학번: 1971079");
		System.out.println("성명: 윤가영");
		System.out.println("============");
		
		Scanner sc = new Scanner(System.in); //스캐너 객체 생성
		
		System.out.println("Input radius for a circle");
		//Circle 객체를 생성합니다. 반지름을 입력하는 생성자 이용.
		Circle c = new Circle(sc.nextDouble());
		
		System.out.println("Input length for a square");
		//Square 객체를 생성합니다. 변의 길이를 입력하는 생성자 이용.
		Square s = new Square(sc.nextDouble());
		
		//Triangle 객체를 생성합니다.
		Triangle t = new Triangle();
		
		//삼각형 각 변의 길이를 대입합니다.
		System.out.println("Input a for a triangle");
		t.a = sc.nextDouble();
		System.out.println("Input b for a triangle");
		t.b = sc.nextDouble();
		System.out.println("Input c for a triangle");
		t.c = sc.nextDouble();
		
		//넓이와 둘레를 출력합니다.
		System.out.println("<Circle>");
		System.out.println("Area: "+c.area());
		System.out.println("Circumference: "+c.perimeter());
		
		System.out.println("<Square>");
		System.out.println("Area: "+s.area());
		System.out.println("Perimeter: "+s.perimeter());
		
		System.out.println("<Triangle>");
		System.out.println("Area: "+t.area());
		System.out.println("Perimeter: "+t.perimeter());
	}
}
