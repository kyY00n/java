import java.util.Scanner;

interface Geometry{ //Geometry �������̽� ����
	public final double PI = 3.14159;
	
	public double area();
	public double perimeter();
}

class Circle implements Geometry{ //Circle Ŭ���� �����Դϴ�.
	public double radius;
	
	public Circle() {}
	public Circle(double radius) {
		this.radius = radius;
	}
	
	//�������̽��� �޼��带 �����մϴ�.
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
	
	//�������̽��� �޼��带 �����մϴ�.
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
	
	//�������̽��� �޼��带 �����մϴ�.
	public double area() {
		double s = (a+b+c)/2;
		return Math.sqrt(s*(s-a)*(s-b)*(s-c));
	}
	
	public double perimeter() {
		return a+b+c;
	}
}
public class Week7_2_������ {

	public static void main(String[] args) {
		System.out.println("============");
		System.out.println("����: ���̹�����");
		System.out.println("�й�: 1971079");
		System.out.println("����: ������");
		System.out.println("============");
		
		Scanner sc = new Scanner(System.in); //��ĳ�� ��ü ����
		
		System.out.println("Input radius for a circle");
		//Circle ��ü�� �����մϴ�. �������� �Է��ϴ� ������ �̿�.
		Circle c = new Circle(sc.nextDouble());
		
		System.out.println("Input length for a square");
		//Square ��ü�� �����մϴ�. ���� ���̸� �Է��ϴ� ������ �̿�.
		Square s = new Square(sc.nextDouble());
		
		//Triangle ��ü�� �����մϴ�.
		Triangle t = new Triangle();
		
		//�ﰢ�� �� ���� ���̸� �����մϴ�.
		System.out.println("Input a for a triangle");
		t.a = sc.nextDouble();
		System.out.println("Input b for a triangle");
		t.b = sc.nextDouble();
		System.out.println("Input c for a triangle");
		t.c = sc.nextDouble();
		
		//���̿� �ѷ��� ����մϴ�.
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
