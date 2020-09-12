import java.util.*;

public class HW2_2_������ {
	
	
	public static void main(String[] args) {
		System.out.println("============");
		System.out.println("����: ���̹�����");
		System.out.println("�й�: 1971079");
		System.out.println("����: ������");
		System.out.println("============");
		
		//��ĳ�� ��ü ����
		Scanner sc = new Scanner(System.in);
		
		//while�� ������ ��� ��½� ���ǹ��� ����� boolean ���Դϴ�.
		boolean isCorrect = false;
		
		//��� �ܾ �Է¹޾ƿ�
		while(true)
		{	
			System.out.print("Input: ");
			String str = sc.next();
			
			//����ڰ� "0"�� �Է½� ���α׷��� ����Ǿ��
			if(str.equals("0"))
			{
				System.out.println("Program finished");
				System.exit(0);
			}
			
			//main �ؿ� ���ڿ��� correct���� incorrect���� �Ǻ����ִ� �޼��� solvePrb()�� ���� �߽��ϴ�.
			//�� �Լ��� �Է°����� ���� ���ڿ��� correct ���θ� return �ؿ�(boolean)
			isCorrect = solvePrb(str); 
			
			//solvePrb�� ��ȯ���� true�̸� "Correct"���
			if(isCorrect) System.out.println("Correct");
			//false�̸� "Incorrect"���
			else System.out.println("Incorrect");
			
			System.out.println();
			System.out.println();
		}
	}
	
	public static boolean solvePrb(String input)
	{
		//solvePrb�� ��ȯ�� boolean ���� ������ �����Դϴ�.
		//�ʱⰪ�� false�̰� �� ���� input�� ��� ���ڰ� �˻�Ǳ� ������ �׻� false�Դϴ�.
		boolean result = false;
		
		//�Է¹��� ���ڿ��� �� ���ھ� ���ڿ� �迭�� �����մϴ�.
		String [] inputSplit = input.split("");
		
		//�̰� �Ǻ��� ���� Stack�Դϴ�.
		Stack<String> myStack = new Stack<String>();
		
		//���� inputSplit�� ���ڿ����� �ϳ��� �˻��մϴ�.
		for(int i = 0; i < input.length(); i++)
		{
			String nextToken = inputSplit[i];
			
			switch(nextToken)
			{
				//�̹� ���ڰ� ���� ��ȣ�� ��
				case "(":
				case "{":
				case "[":
					myStack.push(nextToken); //���ÿ� �߰��մϴ�.
					break;
					
				case ")": // ")"�� ��
					//���� ������ ��������� �ٷ� false�� ��ȯ�մϴ�.
					if(myStack.isEmpty()) return result;
					//���� ���� ��ȣ "("�� ��ġ�ϸ� ������ �� ���� ��Ҹ� �����մϴ�.
					else if(myStack.peek().equals("(")) myStack.pop();
					break;
					
				case "}": // "}"�� ��
					//���� ������ ��������� �ٷ� false�� ��ȯ�մϴ�.
					if(myStack.isEmpty()) return result;
					//���� ���� ��ȣ "{"�� ��ġ�ϸ� ������ �� ���� ��Ҹ� �����մϴ�.
					else if(myStack.peek().equals("{")) myStack.pop();
					break;
					
				case "]":
					//���� ������ ��������� �ٷ� false�� ��ȯ�մϴ�.
					if(myStack.isEmpty()) return result;
					//���� ���� ��ȣ "["�� ��ġ�ϸ� ������ �� ���� ��Ҹ� �����մϴ�.
					else if(myStack.peek().equals("[")) myStack.pop();
					break;
				//�� ���� ���ڰ� �Էµ��� ��� false�� ��ȯ�մϴ�.	
				default: return result;
				
			}//switch�� ����
			
		}//for�� ���� (input �˻� ��)
		
		if(myStack.isEmpty()) result = true;
		
		return result;
	}

}
