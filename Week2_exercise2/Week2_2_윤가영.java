import java.util.Scanner;

public class Week2_2_������ {

	public static void main(String[] args) {
		System.out.println("============");
		System.out.println("����: ���̹�����");
		System.out.println("�й�: 1971079");
		System.out.println("����: ������");
		System.out.println("============");
		
		Scanner sc = new Scanner(System.in); //��ĳ�ʸ� �����մϴ�.
		
		String degreeType; //�µ��� ������ �Է¹��� String ����
		double Degree_C = 0; //���� �µ�
		int Degree_F = 0; //ȭ�� �µ�
		String keepGoing; //y�� �Է¹��� String ����
		
		while(true) {
			//�µ��� ������ �Է¹޽��ϴ�.
			System.out.println("�Է��� �µ��� ����? C(����) �Ǵ� F(ȭ��): ");
			degreeType = sc.nextLine();
			
			//C�Ǵ�c�� �Է��� ���
			if(degreeType.equalsIgnoreCase("C")) {
				System.out.println("�����µ� (�Ǽ�) �Է�");
				Degree_C = sc.nextDouble();
				
				sc.nextLine(); //�������� keepGoing�� �Է¹ޱ� ���� ���ۿ� ���� ���͸� ����ϴ�.
				
				Degree_F = (int) (9*Degree_C/5) + 32; //ȭ�� �µ��� ����մϴ�.

				System.out.printf("���� %.1f��/ȭ�� %d��\n", Degree_C, Degree_F); //printf�� �µ��� ����մϴ�.
			}
			
			//F�Ǵ�f�� �Է��� ���
			else if(degreeType.equalsIgnoreCase("F")) {
				System.out.println("ȭ���µ� (����) �Է�");
				Degree_F = sc.nextInt();
				
				sc.nextLine(); //���������� keepGoing�� �Է¹ޱ� ���� ���ۿ� ���� ���͸� ����ϴ�.
				
				Degree_C = (double) 5 * (Degree_F - 32) / 9; //���� �µ��� ����մϴ�.
				
				System.out.printf("ȭ�� %d��/���� %.1f��\n", Degree_F, Degree_C);
			}
			
			//�߸��� �Է��� ���
			else
				System.out.println("�߸��� �Է�\n\n");
			
			
			//�µ� ����� ������ ���α׷��� ����� �� �Է¹޽��ϴ�.
			System.out.println("����Ͻðڽ��ϱ�? (Y)");
			keepGoing = sc.nextLine();
			
			//Y�Ǵ�y�� �ƴ� ��� ���α׷��� �����մϴ�.
			if(!keepGoing.equalsIgnoreCase("Y")) {
				System.out.println("���α׷� ����");
				break;
			}
			
			System.out.println("\n");
		}
	}
}
