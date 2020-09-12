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
public class Week7_1_윤가영 {
	public static void main(String[] args) {
		System.out.println("============");
		System.out.println("전공: 사이버보안");
		System.out.println("학번: 1971079");
		System.out.println("성명: 윤가영");
		System.out.println("============");
		
		//inputNum: 하고싶은 작업, inputSp: 동물 종, inputAge: 동물 나이
		int inputNum = 0, inputSp = 0, inputAge = 0;
		//inputName: 동물 이름
		String inputName = null;
		int i = 0; //동물의 수
		
		Scanner sc = new Scanner(System.in); //스캐너 생성
		
		Pet[] pets = new Pet[10]; 
		
		while(i<10) { //동물이 10마리가 되면 반복문 탈출
			System.out.println("원하는 작업은 무엇입니까?");
			System.out.println("1.New input 2.output 3.Exit");
			inputNum = sc.nextInt();
			
			if(inputNum == 1) { // 동물 입력을 원하는 경우
				System.out.println("종은 무엇입니까?");
				System.out.println("1.Dog 2.Cat 3.Snake 4.Bird");
				inputSp = sc.nextInt();
				
				if(inputSp == 1) { //강아지를 원하는 경우
					System.out.print("Name: ");
					inputName = sc.next();
					System.out.print("Age: ");
					inputAge = sc.nextInt();
					
					//새로운 Dog 객체를 생성합니다.
					pets[i] = new Dog(inputName, inputAge);
				}
				else if(inputSp == 2) { //고양이를 원하는 경우
					System.out.print("Name: ");
					inputName = sc.next();
					System.out.print("Age: ");
					inputAge = sc.nextInt();
					
					//새로운 Cat 객체를 생성합니다.
					pets[i] = new Cat(inputName, inputAge);
				}
				else if(inputSp == 3) { //뱀을 원하는 경우
					System.out.print("Name: ");
					inputName = sc.next();
					System.out.print("Age: ");
					inputAge = sc.nextInt();
					
					//새로운 Snake 객체를 생성합니다.
					pets[i] = new Snake(inputName, inputAge);
				}
					
				else if(inputSp == 4) { //새를 원하는 경우
					System.out.print("Name: ");
					inputName = sc.next();
					System.out.print("Age: ");
					inputAge = sc.nextInt();
					
					//새로운 Bird 객체를 생성합니다.
					pets[i] = new Bird(inputName, inputAge);
				}
				else { //이외의 수를 눌렀을 때는 다시 작업설정으로 돌아갑니다.
					System.out.println("잘못 입력하셨습니다. 다시 작업을 골라주세요.");
					i--; //이 경우는 객체를 추가하지 않았으므로 동물의 수가 늘어나지 않게 미리 빼줍니다.
				}
				i++; //동물 수를 늘립니다.		
			}
			else if(inputNum == 2) { //Output을 원하는 경우
				System.out.println();
				System.out.println();
				System.out.println("Species Name    Age     Movement");
				for(int j = 0; j < i; j++) {
					System.out.printf("%-8s%-8s%-8d", pets[j].species, pets[j].name, pets[j].age);
					pets[j].move(); //움직입니다. 오버라이딩된 메서드가 호출됩니다.
					System.out.println();
				}
			}
			else if(inputNum ==3) { //Exit을 원하는 경우
				System.out.println("종료");
				System.exit(0); //프로그램을 종료합니다.
			}
			else //1,2,3 외의 다른 수를 입력한 경우
				System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
			System.out.println();
		}
		//10마리가 채워져서 while을 탈출하면 지금까지 저장된 pets을 출력합니다.
		System.out.println();
		System.out.println();
		System.out.println("Species Name    Age     Movement");
		for(int j = 0; j < i; j++) {
			System.out.printf("%-8s%-8s%-8d", pets[j].species, pets[j].name, pets[j].age);
			pets[j].move(); //움직입니다. 오버라이딩된 메서드가 호출됩니다.
			System.out.println();
		}
	}
}
