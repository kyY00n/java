import java.util.Scanner;

public class Week2_1_������ {

	public static void main(String[] args) {
		System.out.println("============");
		System.out.println("����: ���̹�����");
		System.out.println("�й�: 1971079");
		System.out.println("����: ������");
		System.out.println("============");
		
		Scanner sc = new Scanner(System.in); //��ĳ�ʸ� �����մϴ�.
		
		//������ �� �׼��� �Է¹޽��ϴ�.
		System.out.print("Input the amount of money(0~100000): ");
		int money = sc.nextInt();
		
		//�ùٸ� �Է�(0��~100000��)�� ���
		if(money>=0 && money<=100000) {
			System.out.println("The output will be");
			
			//���� 5�������� ���� ���� ����մϴ�.
			System.out.printf("50000 won: %d\n", money/50000);
			//�׸��� 5�������� ���� ��������  money�� �����մϴ�.
			money %= 50000;
			
			//�� ������ 10������ �ݺ��մϴ�.
			System.out.printf("10000 won: %d\n", money/10000);
			money %= 10000;
			
			System.out.printf("5000 won: %d\n", money/5000);
			money %= 5000;
			
			System.out.printf("1000 won: %d\n", money/1000);
			money %= 1000;
			
			System.out.printf("500 won: %d\n", money/500);
			money %= 500;
			
			System.out.printf("100 won: %d\n", money/100);
			money %= 100;
			
			System.out.printf("50 won: %d\n", money/50);
			money %= 50;
			
			System.out.printf("10 won: %d\n", money/10);
			money %= 10;
			
			//���� money���� 1�� ������ ����������Ƿ� money�� �״�� ����մϴ�.
			System.out.printf("Remainder: %d\n", money);
		}
		
		//�߸��� �Է��� ���
		else
			System.out.println("�߸��� �Է�");
	}

}
