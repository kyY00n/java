import java.util.Scanner;
import java.lang.Math;

class DiceGame {
	private int diceFace = 1;
	private int userGuess = 1;
	
	public DiceGame() {
		
	}
	
	private int rollDice() { //Math Ŭ������ random()�޼���� �ֻ��� �� ��ȯ
		return (int)(Math.random()*6) + 1;
	}
	
	private int getUserInput() { //1~6 ���� ������ check�ϴ� �޼���
		int input = 0;
		Scanner sc = new Scanner(System.in);
		
		while(true) //�ݺ���
		{ 
			input = sc.nextInt(); //������� �Է��� ������ ����
			
			if(input >=1 && input <=6) { //����� �Է��� ���� ���� ������
				userGuess = input; //Ŭ������ userGuess �� �����մϴ�.
				return userGuess; //�׸��� userGuess�� ��ȯ�մϴ�.
			}
			else //���� ���� ���� ������ �ݺ��մϴ�.
				System.out.println("Input number between 1~6.");
		}
	}
	
	private void checkUserGuess(int input) {
		
		if(diceFace == input) //���� ����ڰ� ������ ��
			System.out.println("Bingo!");
		
		else //Ʋ���� ��
			System.out.println("Wrong!");
			System.out.println("The face was " + diceFace);
			
	}
	
	public void startPlaying() { //���� �ϴ� �޼���
		
		System.out.println("<< GAME START >>"); //���ӽ���
		
		diceFace = this.rollDice(); //�ֻ��� ������
		System.out.println("Dice is rolled!!");
		
		System.out.println("Guess the number! What do you think?");
		
		this.checkUserGuess(this.getUserInput()); //����� �Է°� �ֻ��� ���� ��ġ�ϴ� �� check
		
	}
}
public class HW1_2_������ {

	public static void main(String[] args) {
		System.out.println("============");
		System.out.println("����: ���̹�����");
		System.out.println("�й�: 1971079");
		System.out.println("����: ������");
		System.out.println("============");
		
		Scanner sc = new Scanner(System.in); //��ĳ�� ����
		
		String keepGoing = "y"; //����ڰ� ������ ��� �Ұ��� �Է¹޴� ����
		DiceGame dg = new DiceGame(); //���ο� ���� ��ü ����
		
		while(!keepGoing.equalsIgnoreCase("n")) { //����ڰ� n�� ������ ������
			
			dg.startPlaying(); //���� ����
			
			System.out.println("Try again?(y/n)");
			keepGoing = sc.nextLine(); //��� �Ұ��� �Է¹ޱ�
			
			System.out.println();
		}
		
		System.out.println("Game finished."); //���� ����
	}

}
