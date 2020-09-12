import java.util.Scanner;

class Product {//tv, computer, video, audio, notebook의 조상이 될 product 클래스
	int price;
	int bonusPoint;
	
	Product(int price){ //price를 파라미터로 가진 생성자
		this.price = price;
		bonusPoint = (int)(price/10.0);
	}
}

class Tv extends Product{ //tv클래스
	
	Tv(){ //super(price)를 이용한 생성자
		super(100);
	}
	public String toString() {
		return "Tv";
	}
}

class Computer extends Product //computer 클래스
{
	Computer(){ //super(price)를 이용한 생성자
		super(200);
	}
	public String toString() {
		return "Computer";
	}
}

class Video extends Product //video 클래스
{
	Video(){ //super(price)를 이용
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

class Buyer { //buyer 구매자 클래스
	int money ; //가진 돈
	int bonusPoint = 0; //포인트
	Product item[] = new Product[10]; //구매목록 - product 가문?의 인스턴스 참조변수 배열
	int i; //배열 인덱스로 사용
	
	void buy(Product pd) { //물건을 parameter로 갖는 메서드
		
		if(pd.price>money) { //돈이 부족할 때
			System.out.println("Money is not enough.");
			this.summary(); //종료하기 전에 구매목록을 보여줍니다.
			System.exit(0); //종료
		}
		
		//정상 구매 시
		System.out.println("You bought "+pd+"("+pd.price+").");
		money -= pd.price; //돈 차감
		bonusPoint += pd.bonusPoint; //보너스 더하기
		item[i++] = pd; //구매 목록에 추가
	}
	
	void summary() { //구매자의 구매목록 정리해서 출력하는 메서드
		System.out.print("Shopping list: ");
		
		for(int j=0;j<i;j++)
			System.out.print(item[j]+" ");
		System.out.println("\nMoney left: "+money);
		System.out.println("Current bonus point: "+bonusPoint);
		
	}
}
public class Week6_1_윤가영 {

	public static void main(String[] args) {
		System.out.println("============");
		System.out.println("전공: 사이버보안");
		System.out.println("학번: 1971079");
		System.out.println("성명: 윤가영");
		System.out.println("============");
		
		Scanner sc = new Scanner(System.in); //스캐너 생성
		
		//구매자 한 명 (객체)생성
		Buyer Buyer1 = new Buyer();

		//저는 상품 종류 별로 객체를 미리 생성해주었습니다.
		Tv t = new Tv();
		Computer c = new Computer();
		Video v = new Video();
		Audio a = new Audio();
		NoteBook n = new NoteBook();
		
		System.out.println("How much money do you have?");
		Buyer1.money = sc.nextInt(); //가진 돈을 입력받아요.
		
		int inputNum = -1; //물건 사기 전에 어떤 물건 살지 입력받는 변수를 초기화 해요
		
		while(Buyer1.money != 0) { //돈이 없으면 실행하지 않아요..
			System.out.println("What do yout want to buy? Input 0 to quit.");
			System.out.println("1. TV(100)     2.Computer(200)     3.Video(110)     4.Audio(50)     5.NoteBook(300)");
			inputNum = sc.nextInt(); //살 품목을 입력받아요
			
			if(inputNum == 0)  //종료
				break;
			
			else if(inputNum == 1) //tv 사기
					Buyer1.buy(t);
			
			else if(inputNum == 2) //컴퓨터 사기
					Buyer1.buy(c);
			
			else if(inputNum == 3) //비디오사기
					Buyer1.buy(v);
			
			else if(inputNum ==4)//오디오사기
					Buyer1.buy(a);
			
			else if(inputNum == 5) //노트북 사기
					Buyer1.buy(n);
			
			else System.out.println("No such item."); //0~5 외에 다른 숫자 입력 시 출력
		}
		System.out.println();
		System.out.println();
		Buyer1.summary(); //구매가 끝난 후 구매목록을 보여줍니다.
	}
}

