import java.io.Serializable;
import java.util.Scanner;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.EOFException;

class Pet implements Serializable{ //Pet class 정의
	private String name;
	private int age;
	private double weight;
	
	public void setPet(String newName, int newAge, double newWeight) {
		name = newName; age = newAge; weight = newWeight;
	}
	
	public void setName(String newName) { //이름 setter
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

class Dog extends Pet implements Serializable{ //Dog class 정의 (Pet 상속, Serializable 구현)
	private String breed;
	private boolean boosterShot;
	
	public Dog (String newName, int newAge, double newWeight, String newBreed, boolean newBS) {
		super(); super.setPet(newName, newAge, newWeight); //Pet class 생성자, 메서드 사용
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
	
	public String toString() { //toString 정의 : 이름, 나이, 무게, 종, 접종여부 반환
		String bS;
		if (boosterShot) bS="O";
		else bS ="X";
		return String.format("%-8s%-8d%-8.1f%-16s%s", getName(),getAge(),getWeight(),getBreed(),bS);
	}
}
public class Week9_2_윤가영 {

	public static void main(String[] args) {
		System.out.println("============");
		System.out.println("전공: 사이버보안");
		System.out.println("학번: 1971079");
		System.out.println("성명: 윤가영");
		System.out.println("============");
		
		//Scanner sc 생성
		Scanner sc = new Scanner(System.in);
		//Dog 배열 생성
		Dog[] myDog = new Dog[10];
		//인스턴스 생성
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
		
		//위의 배열을 출력할 파일 이름 받기
		System.out.println("Input File name to write Dog data");
		String fileName = sc.next(); 
		
		try
		{	//output stream 객체 생성
			ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(fileName));
			//파일에 myDog 배열 출력하기
			outputStream.writeObject(myDog);
			//output stream 닫기
			outputStream.close();
		}
		catch(IOException e) //출력오류
		{
			System.out.println("Error writing to file "+fileName+".");
			System.exit(0);
		}
		
		//새로운 Dog 배열 dogList 선언.
		Dog[] dogList = null;
		
		try
		{	//input stream 객체 생성
			ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(fileName));
			
			//형변환(다운캐스팅)과 함께 파일 읽기
			dogList = (Dog[])inputStream.readObject();
			//input stream 닫기
			inputStream.close();
		}
		catch(EOFException e) //파일이 끝남
		{
			
		}
		catch(FileNotFoundException e) //파일을 찾지 못함
		{
			System.out.println("Cannot find the file"+ fileName);
			System.exit(0);
		}
		catch(IOException e) //입력 예외 처리
		{
			System.out.println("Problem with input from file"+ fileName);
			System.exit(0);
		}
		catch(Exception e) //예외
		{
			System.out.println("Exception.");
			System.exit(0);
		}
		
		//리스트 출력하기
		System.out.println("Name    Age     Weight  Breed           BoosterShot");
		
		for(int i = 0; i < dogList.length; i++)
			System.out.println(dogList[i]);
		
		System.out.println();
		
		System.out.println("Dogs older than 2 years and did not get the boosterShot.");
		
		for(int i = 0; i < dogList.length; i++)
		{	
			//나이가 2살보다 많고 예방접종을 하지 않은 강아지의 이름과 종 출력
			if(dogList[i].getAge() > 2 && !dogList[i].getBoosterShot())
				System.out.printf("%-16s%-16s\n", dogList[i].getName(), dogList[i].getBreed());
		}
		
		sc.close(); //스캐너 닫기
		System.out.println();
		System.out.println("Program finished"); //프로그램 종료
	}

}
