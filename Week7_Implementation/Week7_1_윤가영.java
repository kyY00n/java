import java.util.Scanner;

abstract class Pet{
	public String species;
	public String name;
	public int age;
	
	public abstract void move();
}

class Dog extends Pet{
	public Dog(String name, int age) {
		this.species = "Dog"; this.name = name; this.age = age;
	}
	public void move() {
		System.out.print("run");
	}
}

class Cat extends Pet{
	public Cat(String name, int age) {
		this.species = "Cat"; this.name = name; this.age = age;
	}
	public void move() {
		System.out.print("jump");
	}
}

class Bird extends Pet{
	public Bird(String name, int age) {
		this.species = "Bird"; this.name = name; this.age = age;
	}
	public void move() {
		System.out.print("fly");
	}
}

class Snake extends Pet{
	public Snake(String name, int age) {
		this.species = "Snake"; this.name = name; this.age = age;
	}
	public void move() {
		System.out.print("crawl");
	}
}
public class Week7_1_������ {
	public static void main(String[] args) {
		System.out.println("============");
		System.out.println("����: ���̹�����");
		System.out.println("�й�: 1971079");
		System.out.println("����: ������");
		System.out.println("============");
		
		//inputNum: �ϰ���� �۾�, inputSp: ���� ��, inputAge: ���� ����
		int inputNum = 0, inputSp = 0, inputAge = 0;
		//inputName: ���� �̸�
		String inputName = null;
		int i = 0; //������ ��
		
		Scanner sc = new Scanner(System.in); //��ĳ�� ����
		
		Pet[] pets = new Pet[10]; 
		
		while(i<10) { //������ 10������ �Ǹ� �ݺ��� Ż��
			System.out.println("���ϴ� �۾��� �����Դϱ�?");
			System.out.println("1.New input 2.output 3.Exit");
			inputNum = sc.nextInt();
			
			if(inputNum == 1) { // ���� �Է��� ���ϴ� ���
				System.out.println("���� �����Դϱ�?");
				System.out.println("1.Dog 2.Cat 3.Snake 4.Bird");
				inputSp = sc.nextInt();
				
				if(inputSp == 1) { //�������� ���ϴ� ���
					System.out.print("Name: ");
					inputName = sc.next();
					System.out.print("Age: ");
					inputAge = sc.nextInt();
					
					//���ο� Dog ��ü�� �����մϴ�.
					pets[i] = new Dog(inputName, inputAge);
				}
				else if(inputSp == 2) { //����̸� ���ϴ� ���
					System.out.print("Name: ");
					inputName = sc.next();
					System.out.print("Age: ");
					inputAge = sc.nextInt();
					
					//���ο� Cat ��ü�� �����մϴ�.
					pets[i] = new Cat(inputName, inputAge);
				}
				else if(inputSp == 3) { //���� ���ϴ� ���
					System.out.print("Name: ");
					inputName = sc.next();
					System.out.print("Age: ");
					inputAge = sc.nextInt();
					
					//���ο� Snake ��ü�� �����մϴ�.
					pets[i] = new Snake(inputName, inputAge);
				}
					
				else if(inputSp == 4) { //���� ���ϴ� ���
					System.out.print("Name: ");
					inputName = sc.next();
					System.out.print("Age: ");
					inputAge = sc.nextInt();
					
					//���ο� Bird ��ü�� �����մϴ�.
					pets[i] = new Bird(inputName, inputAge);
				}
				else { //�̿��� ���� ������ ���� �ٽ� �۾��������� ���ư��ϴ�.
					System.out.println("�߸� �Է��ϼ̽��ϴ�. �ٽ� �۾��� ����ּ���.");
					i--; //�� ���� ��ü�� �߰����� �ʾ����Ƿ� ������ ���� �þ�� �ʰ� �̸� ���ݴϴ�.
				}
				i++; //���� ���� �ø��ϴ�.		
			}
			else if(inputNum == 2) { //Output�� ���ϴ� ���
				System.out.println();
				System.out.println();
				System.out.println("Species Name    Age     Movement");
				for(int j = 0; j < i; j++) {
					System.out.printf("%-8s%-8s%-8d", pets[j].species, pets[j].name, pets[j].age);
					pets[j].move(); //�����Դϴ�. �������̵��� �޼��尡 ȣ��˴ϴ�.
					System.out.println();
				}
			}
			else if(inputNum ==3) { //Exit�� ���ϴ� ���
				System.out.println("����");
				System.exit(0); //���α׷��� �����մϴ�.
			}
			else //1,2,3 ���� �ٸ� ���� �Է��� ���
				System.out.println("�߸� �Է��ϼ̽��ϴ�. �ٽ� �Է����ּ���.");
			System.out.println();
		}
		//10������ ä������ while�� Ż���ϸ� ���ݱ��� ����� pets�� ����մϴ�.
		System.out.println();
		System.out.println();
		System.out.println("Species Name    Age     Movement");
		for(int j = 0; j < i; j++) {
			System.out.printf("%-8s%-8s%-8d", pets[j].species, pets[j].name, pets[j].age);
			pets[j].move(); //�����Դϴ�. �������̵��� �޼��尡 ȣ��˴ϴ�.
			System.out.println();
		}
	}
}
