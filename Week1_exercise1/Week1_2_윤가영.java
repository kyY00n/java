import java.util.Scanner;
public class Week1_2_������ {

	public static void main(String[] args) {
		System.out.println("============");
		System.out.println("����: ���̹�����");
		System.out.println("�й�: 1971079");
		System.out.println("����: ������");
		System.out.println("============");
		
		//��ĳ�� sc�� �����մϴ�.
		Scanner sc = new Scanner(System.in);
		
		//���� 3���� �Է¹޽��ϴ�.
		System.out.println("���� �� �� �Է�");
		int num1 = sc.nextInt();
		int num2 = sc.nextInt();
		int num3 = sc.nextInt();
		
		//����� ����մϴ�.
		float value = (float) (num1 + num2 + num3) / 3;
		//����� �Ҽ��� ��° �ڸ����� ����մϴ�.
		System.out.printf("���: %.2f", value);

	}

}