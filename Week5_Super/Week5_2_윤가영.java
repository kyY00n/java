import java.util.Scanner;

class Pet { //조상클래스
	private String name;
	private int age;
	private double weight;

	public void writeOutput() { //이름, 나이, 몸무게 출력 메서드
		System.out.println("Name: "+name);
		System.out.println("Age: "+age);
		System.out.println("Weight: "+weight);
	}
	
	public void setPet(String name, int age, double weight) { // 멤버변수 대입
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

class Dog extends Pet { //Dog 클래스 정의
	private boolean boosterShot;
	
	public Dog (String dName, int dAge, double dWeight){ //Dog 생성자
		this.setPet(dName, dAge, dWeight); // Pet의 setPet 메서드로 멤버변수 설정하기
	}
	
	public void writeOutput() { //멤버변수 출력하는 메서드
		super.writeOutput();
		
		//접종 받은 개는 O, 아니면 X 출력
		if(boosterShot) System.out.println("BoosterShot: O");
		else System.out.println("BoosterShot: X");
	}
	
	public void setBoosterShot(boolean bs) {
		this.boosterShot = bs;
	}
	
	public boolean getBoosterShot() {
		return boosterShot;
	}
	
	public void move() { // "dogName" walks and runs. 출력
		System.out.println(super.getName()+" walks and runs.");
	}
}

class Cat extends Pet{ //Cat 클래스 정의
	private String color;
	
	public Cat (String cName, int cAge, double cWeight){ //Cat 생성자
		this.setPet(cName, cAge, cWeight); //Pet에게 상속받은 setPet 메서드로 멤버변수 값을 설정해요.
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
	
	public void move() { //"catName" creeps and jumps.를 출력해요
		System.out.println(super.getName()+" creeps and jumps.");
	}
}
public class Week5_2_윤가영 {

	public static void main(String[] args) {
		System.out.println("============");
		System.out.println("전공: 사이버보안");
		System.out.println("학번: 1971079");
		System.out.println("성명: 윤가영");
		System.out.println("============");
		
		Scanner sc = new Scanner(System.in); //스캐너 생성
		
		//입력 받을 것들을 저장할 변수들입니다.. input이요
		String iName = "";
		int iAge = 0;
		double iWeight = 0;
		String iBooster = "";
		String iColor = "";
		
		Dog[] dogs = new Dog[3]; //Dog 객체 배열을 만들었습니다
		
		for(int i = 0; i < 3; i++) { //Dog 세마리 정보를 입력받아요
			
			System.out.println("<<Dog "+(i+1)+">>");
			
			System.out.print("Name: ");
			iName = sc.nextLine(); //이름 입력받기
			
			System.out.print("Age: ");
			iAge = sc.nextInt(); //나이 입력받기
			
			System.out.print("Weight: ");
			iWeight = sc.nextDouble(); //몸무게 입력받기
			
			sc.nextLine(); //얘는 버퍼에 남은 엔터를 지워요...
			System.out.print("BoosterShot(y/n): ");
			iBooster =  sc.nextLine(); //저는 y, n을 받았어요. 밑에 보시죠
			
			System.out.println();
			
			dogs[i] = new Dog(iName, iAge, iWeight); //입력받은 것을 저장한 변수들을 매개변수에 넣었어요.
			
			//그리고 예방 접종 받았다면(iBooster가"y") 는 클래스원소의 멤버변수를 true로 설정해줍니다.
			if(iBooster.equalsIgnoreCase("y")) dogs[i].setBoosterShot(true);
			else dogs[i].setBoosterShot(false);
		}//강아지 정보 입력 받기 끝 다음은 고양이입니다.
		
		Cat[] cats = new Cat[3]; //Cat 객체 배열을 만듭니다. 원소 3개
		
		for(int i = 0; i < 3; i++) {
			
			System.out.println("<<Cat "+(i+1)+">>");
			
			System.out.print("Name: "); //고양이이름 입력받기
			iName = sc.nextLine();
			
			System.out.print("Age: "); //나이 입력받기
			iAge = sc.nextInt();
			
			System.out.print("Weight: "); //몸무게 입력받기
			iWeight = sc.nextDouble();
			sc.nextLine(); //엔터 지우기
			
			System.out.print("Color: "); //색 입력받기
			iColor = sc.nextLine(); 
			
			System.out.println();
			
			cats[i] = new Cat(iName, iAge, iWeight); //고양이 객체를 생성합니다
			cats[i].setColor(iColor); //색깔도 정해줘요
		} //고양이 세마리 정보를 모두 입력받았어요.
		
		//이제 Dog List와 Cat List를 출력하겠습니다.
		System.out.println("<<Dog List>>");
		
		for(int i = 0; i < 3 ; i++) { //dogs 객체 배열의 원소 마다 시행해요.
			
			dogs[i].writeOutput(); //정보를 출력합니다.
			dogs[i].move(); //움직입니다.
		
			System.out.println();
		}
		
		System.out.println("<<Cat List>>"); //이번엔 cats 객체 배열을 해보겠습니다.
		for(int i = 0; i < 3; i++) {
			
			cats[i].writeOutput(); //정보를 출력합니다.
			cats[i].move(); //움직입니다.
			
			System.out.println();
		}
		
		//나이가 2살 보다 많고 예방 접종하지 않은 dog의 이름을 출력해요.
		System.out.println("*Dogs older than 2 years and no boostershot are...");
		for(int i = 0 ; i < 3; i++) {
			//age>2 이면서 boosterShot은 false 라면
			if(dogs[i].getAge()>2 && !dogs[i].getBoosterShot()) 
				System.out.print(dogs[i].getName()+" "); //이름 출력
		}
		
		System.out.println();
		System.out.println();
		
		//black인데 3kg 이상인 cat 이름을 출력해요.
		System.out.println("*Black cats weighs more than 3kg are...");
		for(int i = 0; i < 3; i++) {
			//color가 black 이면서 weight<3 이라면
			if(cats[i].getColor().equalsIgnoreCase("black") && cats[i].getWeight() > 3)
				System.out.print(cats[i].getName()+" ");
		}
	}

}
