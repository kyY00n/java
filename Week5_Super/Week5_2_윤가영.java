import java.util.Scanner;

class Pet { //����Ŭ����
	private String name;
	private int age;
	private double weight;

	public void writeOutput() { //�̸�, ����, ������ ��� �޼���
		System.out.println("Name: "+name);
		System.out.println("Age: "+age);
		System.out.println("Weight: "+weight);
	}
	
	public void setPet(String name, int age, double weight) { // ������� ����
		this.name = name; this.age = age; this.weight = weight;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	public void setWeight(double weight) {
		this.weight = weight;
	}
	
	public String getName() {
		return name;
	}
	
	public int getAge() {
		return age;
	}
	
	public double getWeight() {
		return weight;
	}
	
	public void move() { 
		System.out.println(name+" moves");
	}
}

class Dog extends Pet { //Dog Ŭ���� ����
	private boolean boosterShot;
	
	public Dog (String dName, int dAge, double dWeight){ //Dog ������
		this.setPet(dName, dAge, dWeight); // Pet�� setPet �޼���� ������� �����ϱ�
	}
	
	public void writeOutput() { //������� ����ϴ� �޼���
		super.writeOutput();
		
		//���� ���� ���� O, �ƴϸ� X ���
		if(boosterShot) System.out.println("BoosterShot: O");
		else System.out.println("BoosterShot: X");
	}
	
	public void setBoosterShot(boolean bs) {
		this.boosterShot = bs;
	}
	
	public boolean getBoosterShot() {
		return boosterShot;
	}
	
	public void move() { // "dogName" walks and runs. ���
		System.out.println(super.getName()+" walks and runs.");
	}
}

class Cat extends Pet{ //Cat Ŭ���� ����
	private String color;
	
	public Cat (String cName, int cAge, double cWeight){ //Cat ������
		this.setPet(cName, cAge, cWeight); //Pet���� ��ӹ��� setPet �޼���� ������� ���� �����ؿ�.
	}
	
	public void writeOutput() {
		super.writeOutput();
		System.out.println("Color: "+color);
	}
	
	public void setColor(String color) {
		this.color = color;
	}
	
	public String getColor() {
		return color;
	}
	
	public void move() { //"catName" creeps and jumps.�� ����ؿ�
		System.out.println(super.getName()+" creeps and jumps.");
	}
}
public class Week5_2_������ {

	public static void main(String[] args) {
		System.out.println("============");
		System.out.println("����: ���̹�����");
		System.out.println("�й�: 1971079");
		System.out.println("����: ������");
		System.out.println("============");
		
		Scanner sc = new Scanner(System.in); //��ĳ�� ����
		
		//�Է� ���� �͵��� ������ �������Դϴ�.. input�̿�
		String iName = "";
		int iAge = 0;
		double iWeight = 0;
		String iBooster = "";
		String iColor = "";
		
		Dog[] dogs = new Dog[3]; //Dog ��ü �迭�� ��������ϴ�
		
		for(int i = 0; i < 3; i++) { //Dog ������ ������ �Է¹޾ƿ�
			
			System.out.println("<<Dog "+(i+1)+">>");
			
			System.out.print("Name: ");
			iName = sc.nextLine(); //�̸� �Է¹ޱ�
			
			System.out.print("Age: ");
			iAge = sc.nextInt(); //���� �Է¹ޱ�
			
			System.out.print("Weight: ");
			iWeight = sc.nextDouble(); //������ �Է¹ޱ�
			
			sc.nextLine(); //��� ���ۿ� ���� ���͸� ������...
			System.out.print("BoosterShot(y/n): ");
			iBooster =  sc.nextLine(); //���� y, n�� �޾Ҿ��. �ؿ� ������
			
			System.out.println();
			
			dogs[i] = new Dog(iName, iAge, iWeight); //�Է¹��� ���� ������ �������� �Ű������� �־����.
			
			//�׸��� ���� ���� �޾Ҵٸ�(iBooster��"y") �� Ŭ���������� ��������� true�� �������ݴϴ�.
			if(iBooster.equalsIgnoreCase("y")) dogs[i].setBoosterShot(true);
			else dogs[i].setBoosterShot(false);
		}//������ ���� �Է� �ޱ� �� ������ ������Դϴ�.
		
		Cat[] cats = new Cat[3]; //Cat ��ü �迭�� ����ϴ�. ���� 3��
		
		for(int i = 0; i < 3; i++) {
			
			System.out.println("<<Cat "+(i+1)+">>");
			
			System.out.print("Name: "); //������̸� �Է¹ޱ�
			iName = sc.nextLine();
			
			System.out.print("Age: "); //���� �Է¹ޱ�
			iAge = sc.nextInt();
			
			System.out.print("Weight: "); //������ �Է¹ޱ�
			iWeight = sc.nextDouble();
			sc.nextLine(); //���� �����
			
			System.out.print("Color: "); //�� �Է¹ޱ�
			iColor = sc.nextLine(); 
			
			System.out.println();
			
			cats[i] = new Cat(iName, iAge, iWeight); //����� ��ü�� �����մϴ�
			cats[i].setColor(iColor); //���� �������
		} //����� ������ ������ ��� �Է¹޾Ҿ��.
		
		//���� Dog List�� Cat List�� ����ϰڽ��ϴ�.
		System.out.println("<<Dog List>>");
		
		for(int i = 0; i < 3 ; i++) { //dogs ��ü �迭�� ���� ���� �����ؿ�.
			
			dogs[i].writeOutput(); //������ ����մϴ�.
			dogs[i].move(); //�����Դϴ�.
		
			System.out.println();
		}
		
		System.out.println("<<Cat List>>"); //�̹��� cats ��ü �迭�� �غ��ڽ��ϴ�.
		for(int i = 0; i < 3; i++) {
			
			cats[i].writeOutput(); //������ ����մϴ�.
			cats[i].move(); //�����Դϴ�.
			
			System.out.println();
		}
		
		//���̰� 2�� ���� ���� ���� �������� ���� dog�� �̸��� ����ؿ�.
		System.out.println("*Dogs older than 2 years and no boostershot are...");
		for(int i = 0 ; i < 3; i++) {
			//age>2 �̸鼭 boosterShot�� false ���
			if(dogs[i].getAge()>2 && !dogs[i].getBoosterShot()) 
				System.out.print(dogs[i].getName()+" "); //�̸� ���
		}
		
		System.out.println();
		System.out.println();
		
		//black�ε� 3kg �̻��� cat �̸��� ����ؿ�.
		System.out.println("*Black cats weighs more than 3kg are...");
		for(int i = 0; i < 3; i++) {
			//color�� black �̸鼭 weight<3 �̶��
			if(cats[i].getColor().equalsIgnoreCase("black") && cats[i].getWeight() > 3)
				System.out.print(cats[i].getName()+" ");
		}
	}

}
