import java.util.Scanner;
public class Week1_3_������ {

	public static void main(String[] args) {
		System.out.println("============");
		System.out.println("����: ���̹�����");
		System.out.println("�й�: 1971079");
		System.out.println("����: ������");
		System.out.println("============");
		
		//��ĳ�� sc�� �����մϴ�.
		Scanner sc = new Scanner(System.in);
		
		//ȭ���µ��� �Է¹޽��ϴ�.
		System.out.println("ȭ���µ� �Է�: ");
		int temF = sc.nextInt();
		
		//�����µ��� ����մϴ�.
		float temC = (float) 5 / 9 * (F - 32);
		
		//�µ��� ����մϴ�.
		System.out.println("ȭ���µ�: " + temF);
		System.out.printf("�����µ�: %.1f", temC); //�����µ��� �Ҽ��� ù° �ڸ����� ����մϴ�.
	}

}