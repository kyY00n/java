import java.util.Scanner;

class Product {//tv, computer, video, audio, notebook�� ������ �� product Ŭ����
	int price;
	int bonusPoint;
	
	Product(int price){ //price�� �Ķ���ͷ� ���� ������
		this.price = price;
		bonusPoint = (int)(price/10.0);
	}
}

class Tv extends Product{ //tvŬ����
	
	Tv(){ //super(price)�� �̿��� ������
		super(100);
	}
	public String toString() {
		return "Tv";
	}
}

class Computer extends Product //computer Ŭ����
{
	Computer(){ //super(price)�� �̿��� ������
		super(200);
	}
	public String toString() {
		return "Computer";
	}
}

class Video extends Product //video Ŭ����
{
	Video(){ //super(price)�� �̿�
		super(110);
	}
	public String toString() {
		return "Video";
	}
}

class NoteBook extends Product //Notebook class
{
	NoteBook(){ //super(price);
		super(300);
	}
	public String toString() {
		return "NoteBook";
	}
}

class Audio extends Product //audio class
{
	Audio(){ //super(price)
		super(50);
	}
	public String toString() {
		return "Audio";
	}
}

class Buyer { //buyer ������ Ŭ����
	int money ; //���� ��
	int bonusPoint = 0; //����Ʈ
	Product item[] = new Product[10]; //���Ÿ�� - product ����?�� �ν��Ͻ� �������� �迭
	int i; //�迭 �ε����� ���
	
	void buy(Product pd) { //������ parameter�� ���� �޼���
		
		if(pd.price>money) { //���� ������ ��
			System.out.println("Money is not enough.");
			this.summary(); //�����ϱ� ���� ���Ÿ���� �����ݴϴ�.
			System.exit(0); //����
		}
		
		//���� ���� ��
		System.out.println("You bought "+pd+"("+pd.price+").");
		money -= pd.price; //�� ����
		bonusPoint += pd.bonusPoint; //���ʽ� ���ϱ�
		item[i++] = pd; //���� ��Ͽ� �߰�
	}
	
	void summary() { //�������� ���Ÿ�� �����ؼ� ����ϴ� �޼���
		System.out.print("Shopping list: ");
		
		for(int j=0;j<i;j++)
			System.out.print(item[j]+" ");
		System.out.println("\nMoney left: "+money);
		System.out.println("Current bonus point: "+bonusPoint);
		
	}
}
public class Week6_1_������ {

	public static void main(String[] args) {
		System.out.println("============");
		System.out.println("����: ���̹�����");
		System.out.println("�й�: 1971079");
		System.out.println("����: ������");
		System.out.println("============");
		
		Scanner sc = new Scanner(System.in); //��ĳ�� ����
		
		//������ �� �� (��ü)����
		Buyer Buyer1 = new Buyer();

		//���� ��ǰ ���� ���� ��ü�� �̸� �������־����ϴ�.
		Tv t = new Tv();
		Computer c = new Computer();
		Video v = new Video();
		Audio a = new Audio();
		NoteBook n = new NoteBook();
		
		System.out.println("How much money do you have?");
		Buyer1.money = sc.nextInt(); //���� ���� �Է¹޾ƿ�.
		
		int inputNum = -1; //���� ��� ���� � ���� ���� �Է¹޴� ������ �ʱ�ȭ �ؿ�
		
		while(Buyer1.money != 0) { //���� ������ �������� �ʾƿ�..
			System.out.println("What do yout want to buy? Input 0 to quit.");
			System.out.println("1. TV(100)     2.Computer(200)     3.Video(110)     4.Audio(50)     5.NoteBook(300)");
			inputNum = sc.nextInt(); //�� ǰ���� �Է¹޾ƿ�
			
			if(inputNum == 0)  //����
				break;
			
			else if(inputNum == 1) //tv ���
					Buyer1.buy(t);
			
			else if(inputNum == 2) //��ǻ�� ���
					Buyer1.buy(c);
			
			else if(inputNum == 3) //�������
					Buyer1.buy(v);
			
			else if(inputNum ==4)//��������
					Buyer1.buy(a);
			
			else if(inputNum == 5) //��Ʈ�� ���
					Buyer1.buy(n);
			
			else System.out.println("No such item."); //0~5 �ܿ� �ٸ� ���� �Է� �� ���
		}
		System.out.println();
		System.out.println();
		Buyer1.summary(); //���Ű� ���� �� ���Ÿ���� �����ݴϴ�.
	}
}

