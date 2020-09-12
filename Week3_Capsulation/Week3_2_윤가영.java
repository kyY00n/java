package ass3;
import java.util.Scanner;

class Circle{
	final double PI = 3.14159; //�������
	private double radius; //private ��� ����
	
	public void setRadius (double rd) //������ setter
	{
		radius = rd;
	}
	public double getRadius() { //������ getter
		return radius;
	}
	public double perimeter() { //���� ��� method
		return PI*2*radius;
	}
	public double area() { //���� ��� method
		return PI*radius*radius;
	}
	public void circleinfo() { //�� ���� ���� �Լ�
		System.out.println("������:" + this.getRadius());
		System.out.printf("���ѷ�:%.2f\n", this.perimeter());
		System.out.printf("������:%.2f\n", this.area());
	}
}

public class Week3_2_������ {

	public static void main(String[] args) {
		System.out.println("============");
		System.out.println("����: ���̹�����");
		System.out.println("�й�: 1971079");
		System.out.println("����: ������");
		System.out.println("============");
		
		Scanner kbd = new Scanner(System.in); //��ĳ�� ����
		Circle cc = new Circle(); // Circle ��ü ����
		
		System.out.print("�������Է�:"); 
		cc.setRadius(kbd.nextDouble()); //������ �Է¹ޱ� (Double)
		
		cc.circleinfo(); //cc ���� ����ϱ�.
	}

}
