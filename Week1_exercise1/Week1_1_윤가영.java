import java.util.Scanner; //�ܺ� Ŭ���� ���
public class Week1_1_������ {

	public static void main(String[] args) {
		System.out.println("============");
		System.out.println("����: ���̹�����");
		System.out.println("�й�: 1971079");
		System.out.println("����: ������");
		System.out.println("============");
		
		//��ĳ�� Ŭ���� sc�� �����մϴ�. 
		Scanner sc = new Scanner(System.in);
		
		//�غ��� �Է¹޽��ϴ�.
		System.out.println("Input base :");
		int base = sc.nextInt();
		
		//���̸� �Է¹޽��ϴ�.
		System.out.println("Input height :");
		int height = sc.nextInt();
		
		//���̸� ����մϴ�.
		float area = (float) base * height / 2;
		
		//���̸� ����մϴ�.
		System.out.println("The area: "+ area);
	}

}