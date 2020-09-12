import java.io.Serializable;
import java.util.Scanner;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.EOFException;

class Pet implements Serializable{ //Pet class ����
	private String name;
	private int age;
	private double weight;
	
	public void setPet(String newName, int newAge, double newWeight) {
		name = newName; age = newAge; weight = newWeight;
	}
	
	public void setName(String newName) { //�̸� setter
		name = newName;
	}
	
	public void setAge(int newAge) { //age setter
		age = newAge;
	}
	
	public void setWeight(double newWeight) { //weight setter
		weight = newWeight;
	}
	
	public String getName() { //name getter
		return name;
	}
	
	public int getAge() { //age getter
		return age;
	}
	
	public double getWeight() { //weight getter
		return weight;
	}
}

class Dog extends Pet implements Serializable{ //Dog class ���� (Pet ���, Serializable ����)
	private String breed;
	private boolean boosterShot;
	
	public Dog (String newName, int newAge, double newWeight, String newBreed, boolean newBS) {
		super(); super.setPet(newName, newAge, newWeight); //Pet class ������, �޼��� ���
		breed = newBreed;
		boosterShot = newBS;
	}
	public void setBreed(String breed) { //breed setter
		this.breed = breed;
	}
	
	public void setBoosterShot(boolean boosterShot) { //boosterShot setter
		this.boosterShot = boosterShot;
	}
	
	public String getBreed() { //breed getter
		return breed;
	}
	
	public boolean getBoosterShot() { //boosterShot getter
		return boosterShot;
	}
	
	public String toString() { //toString ���� : �̸�, ����, ����, ��, �������� ��ȯ
		String bS;
		if (boosterShot) bS="O";
		else bS ="X";
		return String.format("%-8s%-8d%-8.1f%-16s%s", getName(),getAge(),getWeight(),getBreed(),bS);
	}
}
public class Week9_2_������ {

	public static void main(String[] args) {
		System.out.println("============");
		System.out.println("����: ���̹�����");
		System.out.println("�й�: 1971079");
		System.out.println("����: ������");
		System.out.println("============");
		
		//Scanner sc ����
		Scanner sc = new Scanner(System.in);
		//Dog �迭 ����
		Dog[] myDog = new Dog[10];
		//�ν��Ͻ� ����
		myDog[0] = new Dog("Merry", 3, 2.5, "Bulldog", false);
		myDog[1] = new Dog("JJong", 5, 5.5, "Mix", false);
		myDog[2] = new Dog("Kong", 4, 3, "Poodle", true);
		myDog[3] = new Dog("Apple", 2, 2.5, "Collie", true);
		myDog[4] = new Dog("Candy", 5, 5.5, "Coca", false);
		myDog[5] = new Dog("Cutie", 7, 2.5, "Chiwawa", true);
		myDog[6] = new Dog("Peace", 3, 2.5, "Huskey", false);
		myDog[7] = new Dog("Lion", 9, 1.5, "Shepard", true);
		myDog[8] = new Dog("Windy", 2, 9, "Jindo", true);
		myDog[9] = new Dog("Sweetie", 1, 2.5, "Maltiz", false);
		
		//���� �迭�� ����� ���� �̸� �ޱ�
		System.out.println("Input File name to write Dog data");
		String fileName = sc.next(); 
		
		try
		{	//output stream ��ü ����
			ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(fileName));
			//���Ͽ� myDog �迭 ����ϱ�
			outputStream.writeObject(myDog);
			//output stream �ݱ�
			outputStream.close();
		}
		catch(IOException e) //��¿���
		{
			System.out.println("Error writing to file "+fileName+".");
			System.exit(0);
		}
		
		//���ο� Dog �迭 dogList ����.
		Dog[] dogList = null;
		
		try
		{	//input stream ��ü ����
			ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(fileName));
			
			//����ȯ(�ٿ�ĳ����)�� �Բ� ���� �б�
			dogList = (Dog[])inputStream.readObject();
			//input stream �ݱ�
			inputStream.close();
		}
		catch(EOFException e) //������ ����
		{
			
		}
		catch(FileNotFoundException e) //������ ã�� ����
		{
			System.out.println("Cannot find the file"+ fileName);
			System.exit(0);
		}
		catch(IOException e) //�Է� ���� ó��
		{
			System.out.println("Problem with input from file"+ fileName);
			System.exit(0);
		}
		catch(Exception e) //����
		{
			System.out.println("Exception.");
			System.exit(0);
		}
		
		//����Ʈ ����ϱ�
		System.out.println("Name    Age     Weight  Breed           BoosterShot");
		
		for(int i = 0; i < dogList.length; i++)
			System.out.println(dogList[i]);
		
		System.out.println();
		
		System.out.println("Dogs older than 2 years and did not get the boosterShot.");
		
		for(int i = 0; i < dogList.length; i++)
		{	
			//���̰� 2�캸�� ���� ���������� ���� ���� �������� �̸��� �� ���
			if(dogList[i].getAge() > 2 && !dogList[i].getBoosterShot())
				System.out.printf("%-16s%-16s\n", dogList[i].getName(), dogList[i].getBreed());
		}
		
		sc.close(); //��ĳ�� �ݱ�
		System.out.println();
		System.out.println("Program finished"); //���α׷� ����
	}

}
