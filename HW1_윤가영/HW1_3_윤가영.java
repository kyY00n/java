import java.util.Scanner;

public class HW1_3_������ {

	public static void main(String[] args) {
		System.out.println("============");
		System.out.println("����: ���̹�����");
		System.out.println("�й�: 1971079");
		System.out.println("����: ������");
		System.out.println("============");
		
		String keepGoing = "y"; //��� �Ұ��� �Է¹��� ����
		String str = null; //��Ī �˻��� ���ڿ� ����
		
		Scanner sc = new Scanner(System.in);
		
		while(keepGoing.equalsIgnoreCase("y")) 
		{
			System.out.println("Input a word");
			str = sc.next(); //�ܾ� �Է¹ޱ�
			
			char Arr[] = new char[100]; //���ڹ迭 ��ü ����
			Arr = str.toCharArray(); //�Է¹��� str�� ���� �迭�� ��ȯ�� Arr�� ����
			
			if(check(Arr)==true) // Arr�� ��Ī�̸�
				System.out.println("Symmetry");
			else //��Ī�� �ƴϸ�
				System.out.println("Asymmetry");
			
			System.out.println();
			System.out.print("Try again?(y/n)");
			keepGoing = sc.next(); //�ٽ� �Ұ��� �Է¹ޱ�
			System.out.println();
		}

	}
	
	public static boolean check(char[] Arr) { //��Ī Ȯ�� ���: �糡�� �ִ� ���ڰ� ������ ���Ѵ�
		
		for(int i = 0; i < Arr.length/2; i++) //������ ���� ¦���缭 ��Ī���� �˻��ϹǷ� (����/2) �� ����
		{
			if(Arr[i] != Arr[(Arr.length-1)-i]) //��Ī�� �ƴ� ¦�� ������ false ��ȯ
				return false;
		}
		return true; //������ �� ���������� true ��ȯ
	}

}
