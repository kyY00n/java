package ass3;
import java.util.Scanner;

class MenuOrder {
	private int cokePrice;
	private int lemonadePrice;
	private int coffeePrice;
	private int inputMoney;
	private String drinkSelected;
	
	public void setPrice(String menuNum, int price)
	{ // setPrice�Լ�: �޴� ��ȣ�� ������ ������ ���ڷ� �޽��ϴ�.
		if(menuNum.equals("coke")) 
			cokePrice = price;
		else if(menuNum.equals("lemonade"))
			lemonadePrice = price;
		else if(menuNum.equals("coffee"))
			coffeePrice = price;
	}
	
	public void setDrink(int drinkNum) //����ڰ� ������ ���� ���� ����
	{
		if(drinkNum == 1)
			drinkSelected = "1";
		else if (drinkNum == 2)
			drinkSelected = "2";
		else if(drinkNum == 3)
			drinkSelected = "3";
		else
			drinkSelected = "None";
	}

	public void showMenu() //�޴��� �����ִ� method
	{ 
		System.out.println("1. Coke: " + cokePrice);
		System.out.println("2. Lemonade: "+ lemonadePrice);
		System.out.println("3. Coffee: "+ coffeePrice);
	}
	
	public void showResult(int money) //1,2,3 �� �ϳ��� ���� ���� �� ������ ���.
	{ 
		inputMoney = money; // private inputMoney ���� set�ҰԿ�..
		
		//�ݶ� ����� ��
		if(drinkSelected.equals("1")) 
		{
			System.out.println("Coke�� �����ϼ̽��ϴ�.");
			if ((inputMoney - cokePrice) > 0) //�� ���� �־��� ��
				System.out.println("�ܵ��� "+(inputMoney-cokePrice)+"�Դϴ�."); //�ܵ�
			else if ((inputMoney - cokePrice) < 0) //�� �����ϰ� �־��� ��
				System.out.println((cokePrice - inputMoney)+"�� �� �־��ּ���."); //������ ��
		}
		//�����̵� ����� ��
		else if(drinkSelected.equals("2"))
		{
			System.out.println("Lemonade�� �����ϼ̽��ϴ�.");
			if ((inputMoney - lemonadePrice) > 0) //���� ����
				System.out.println("�ܵ��� "+(inputMoney-lemonadePrice)+"�Դϴ�.");
			else if ((inputMoney - lemonadePrice) < 0) //����
				System.out.println((lemonadePrice - inputMoney)+"�� �� �־��ּ���.");
		}
		//Ŀ�� ����� ��
		else if(drinkSelected.equals("3"))
		{
			System.out.println("Coffee�� �����ϼ̽��ϴ�.");
			if ((inputMoney - coffeePrice) > 0) //���� ����
				System.out.println("�ܵ��� "+(inputMoney-coffeePrice)+"�Դϴ�.");
			else if ((inputMoney - coffeePrice) < 0) //����
				System.out.println((coffeePrice - inputMoney)+"�� �� �־��ּ���.");
		}
		else
			System.out.println("���� �޴��� �����ϼ̽��ϴ�.");
		
	}
}

public class Week3_4_������ {

	public static void main(String[] args) {
		System.out.println("============");
		System.out.println("����: ���̹�����");
		System.out.println("�й�: 1971079");
		System.out.println("����: ������");
		System.out.println("============");
		
		Scanner kbd = new Scanner(System.in); //��ĳ�� ����
		
		String keepGoing = "y"; //����Ͻðڽ��ϱ�
		
		//�޴� ����!
		MenuOrder mo = new MenuOrder();
		
		//setPrice method�� ���� �����ϱ�
		System.out.println("--- ���� ���� ���� ---");
		System.out.print("Coke����:");
		mo.setPrice("coke", kbd.nextInt());
		System.out.print("Lemonade����:");
		mo.setPrice("lemonade", kbd.nextInt());
		System.out.print("Coffee����:");
		mo.setPrice("coffee", kbd.nextInt());
	
		//while��
		while(keepGoing.equalsIgnoreCase("y")) {
			System.out.println();
			
			System.out.println("--- ���� �������� ---");
			int money = kbd.nextInt(); //���� ��
			
			System.out.println("--- ���Ḧ �����ϼ��� ---");
			mo.showMenu(); //���� ���� �Ϸ��� �޴� �����ֱ�
			
			mo.setDrink(kbd.nextInt()); //�� �� ���� �� ���� �Է¹ޱ�
			kbd.nextLine(); // ���ۿ� ���� ���� �����
	
			mo.showResult(money); //���� ���� �����ߴ���, �Ž����� / ������ �� �����ֱ�
			System.out.println("��� �Ͻðڽ��ϱ�?(y/n)");
			keepGoing = kbd.nextLine();
		}
	}

}
