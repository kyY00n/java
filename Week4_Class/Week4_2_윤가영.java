import java.util.Scanner;

class Facto {
	//�� ���� factorial ���� ���̸� ������ static �����Դϴ�.
	public static int result;
	
	//���丮�� ��� ���ִ� static �޼ҵ� ����
	public static int factoVal(int x) { // x>=0 �̶�� �����߽��ϴ�
		int xFact = 1;
		
		if(x==0) //x�� 0�� ��
			return 1;
		
		for(int i = x; i > 0; i--) { //x*(x-1)*...*2*1 �̷� ������ factorial�� ����մϴ�.
			xFact *= i;
		}
		return xFact; //��� ����� ��ȯ�մϴ�.
	}
}
public class Week4_2_������ {

	public static void main(String[] args) {
		System.out.println("============");
		System.out.println("����: ���̹�����");
		System.out.println("�й�: 1971079");
		System.out.println("����: ������");
		System.out.println("============");
		
		Scanner kbd = new Scanner(System.in); //��ĳ�� ����.
		
		//ù ��° ���Ҹ� �Է¹޽��ϴ�.
		System.out.print("ù��° ���� �Է�:");
		int firstElement = kbd.nextInt();
		
		//�� ��° ���Ҹ� �Է¹޽��ϴ�.
		System.out.print("�ι�° ���� �Է�:");
		int secondElement = kbd.nextInt();
		
		//Facto class�� static ���� result�� �� ���丮�� ���� ���� �����մϴ�.
		Facto.result = Facto.factoVal(firstElement) - Facto.factoVal(secondElement);
		
		//result���� ����մϴ�.
		System.out.println("Factorial("+firstElement+") - Factorial("+secondElement+") = "
							+ Facto.result);
	}

}
