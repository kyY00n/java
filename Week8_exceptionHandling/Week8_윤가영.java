import java.util.Scanner;
import java.lang.Math;

public class Week8_������ {

	public static void main(String[] args) {
		System.out.println("============");
		System.out.println("����: ���̹�����");
		System.out.println("�й�: 1971079");
		System.out.println("����: ������");
		System.out.println("============");
		
		Game g = new Game(); // Game ��ü ����
		g.play(); //���� play
	}

}

class Game {
	private int youIn, comIn; //����ڿ� ��ǻ���� �Է��� ������ ����
	private int youWin, comWin; //����ڿ� ��ǻ�Ͱ� ���� �̱� Ƚ��
	
	public void play() {
		System.out.println("���������� ������ �����մϴ�.");
		
		//�ݺ���
		while(youWin< 3 && comWin < 3) { //�̱� Ƚ���� 3�� �Ǹ� ���� ����
			System.out.println("����� ������?(You("+youWin+") - Com("+comWin+"))"); //�̱� Ƚ�� ���
			System.out.println("����(1) ����(2) ��(3)");
			input();
		}//�ݺ��� ����
		
		System.out.println();
		System.out.println("You("+youWin+")  Com("+comWin+")");
		if(youWin > comWin)
			System.out.println("����� �̰���ϴ�.");
		else
			System.out.println("��ǻ�Ͱ� �̰���ϴ�.");
		System.out.println("������ �����մϴ�.");
	}
	
	public void input() { //����� �Է� �޴� �޼���
		Scanner sc = new Scanner(System.in);
		
		try
		{	//������� �Է��� �޽��ϴ�.
			youIn = sc.nextInt();
			
			if (youIn < 1 || youIn > 3) //1,2,3�� ���Ե��� �ʴ� ���
				throw new Exception("������ �߸��ƽ��ϴ�.");
			
			//��ǻ���� �Է��� �޽��ϴ�.(�����޼�����)
			comIn = (int) (Math.random()*3) + 1;
			
			//����ڿ� ��ǻ���� �Է��� �����ݴϴ�.
			System.out.println("<You>   <Com>");
			System.out.println(IntToShape(youIn)+"          "+IntToShape(comIn));
			
			//���� ����� ����մϴ�.
			writeOutput();
		}
		catch(Exception e) //���� ó��
		{
			System.out.println(e.getMessage());
			System.out.println();
		}
	}
	
	public void writeOutput() { //���������� ����� ����ϴ� �޼���
		
		//�ٸ� ����� ������ �����غ����� �̰� �ּ��̾����ϴ�.. ���� �� ����� ��Һ��Դϴ�.
		//�ٵ� ����(1) ��(3) �� ��� ���п� ��Ұ� �ݴ�� ���� ���־����ϴ�.
		//�̱� �� ��� �� �̱� Ƚ�� ���������־����ϴ�.
		if(comIn < youIn) {
			if (comIn == 1 && youIn ==3) {
				System.out.println("��ǻ�� ��"); comWin++;
			}
			else {
				System.out.println("��� ��"); youWin++;
			}
		}
		else if(comIn > youIn) {
			if (comIn == 3 && youIn == 1) {
				System.out.println("��� ��"); youWin++;
			}
			else {
				System.out.println("��ǻ�� ��"); comWin++;
			}
		}
		else
			System.out.println("���");
		
		System.out.println();
	}
	
	public String IntToShape (int num) { //���ڸ� �޾� �ո���� ��ȯ�ϴ� �޼���
		if(num == 1)
			return "����";
		else if(num == 2)
			return "����";
		else 
			return "��";
	}
}