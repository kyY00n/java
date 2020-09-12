package ass3;
import java.util.Scanner;

class MenuOrder {
	private int cokePrice;
	private int lemonadePrice;
	private int coffeePrice;
	private int inputMoney;
	private String drinkSelected;
	
	public void setPrice(String menuNum, int price)
	{ // setPrice함수: 메뉴 번호와 설정할 가격을 인자로 받습니다.
		if(menuNum.equals("coke")) 
			cokePrice = price;
		else if(menuNum.equals("lemonade"))
			lemonadePrice = price;
		else if(menuNum.equals("coffee"))
			coffeePrice = price;
	}
	
	public void setDrink(int drinkNum) //사용자가 선택한 음료 숫자 설정
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

	public void showMenu() //메뉴판 보여주는 method
	{ 
		System.out.println("1. Coke: " + cokePrice);
		System.out.println("2. Lemonade: "+ lemonadePrice);
		System.out.println("3. Coffee: "+ coffeePrice);
	}
	
	public void showResult(int money) //1,2,3 중 하나를 선택 했을 때 보여줄 결과.
	{ 
		inputMoney = money; // private inputMoney 먼저 set할게요..
		
		//콜라 골랐을 때
		if(drinkSelected.equals("1")) 
		{
			System.out.println("Coke를 선택하셨습니다.");
			if ((inputMoney - cokePrice) > 0) //돈 많이 넣었을 때
				System.out.println("잔돈은 "+(inputMoney-cokePrice)+"입니다."); //잔돈
			else if ((inputMoney - cokePrice) < 0) //돈 부족하게 넣었을 때
				System.out.println((cokePrice - inputMoney)+"원 더 넣어주세요."); //부족한 돈
		}
		//레몬에이드 골랐을 때
		else if(drinkSelected.equals("2"))
		{
			System.out.println("Lemonade를 선택하셨습니다.");
			if ((inputMoney - lemonadePrice) > 0) //많이 넣음
				System.out.println("잔돈은 "+(inputMoney-lemonadePrice)+"입니다.");
			else if ((inputMoney - lemonadePrice) < 0) //부족
				System.out.println((lemonadePrice - inputMoney)+"원 더 넣어주세요.");
		}
		//커피 골랐을 때
		else if(drinkSelected.equals("3"))
		{
			System.out.println("Coffee를 선택하셨습니다.");
			if ((inputMoney - coffeePrice) > 0) //많이 넣음
				System.out.println("잔돈은 "+(inputMoney-coffeePrice)+"입니다.");
			else if ((inputMoney - coffeePrice) < 0) //부족
				System.out.println((coffeePrice - inputMoney)+"원 더 넣어주세요.");
		}
		else
			System.out.println("없는 메뉴를 선택하셨습니다.");
		
	}
}

public class Week3_4_윤가영 {

	public static void main(String[] args) {
		System.out.println("============");
		System.out.println("전공: 사이버보안");
		System.out.println("학번: 1971079");
		System.out.println("성명: 윤가영");
		System.out.println("============");
		
		Scanner kbd = new Scanner(System.in); //스캐너 생성
		
		String keepGoing = "y"; //계속하시겠습니까
		
		//메뉴 생성!
		MenuOrder mo = new MenuOrder();
		
		//setPrice method로 가격 설정하기
		System.out.println("--- 음료 가격 설정 ---");
		System.out.print("Coke가격:");
		mo.setPrice("coke", kbd.nextInt());
		System.out.print("Lemonade가격:");
		mo.setPrice("lemonade", kbd.nextInt());
		System.out.print("Coffee가격:");
		mo.setPrice("coffee", kbd.nextInt());
	
		//while문
		while(keepGoing.equalsIgnoreCase("y")) {
			System.out.println();
			
			System.out.println("--- 돈을 넣으세요 ---");
			int money = kbd.nextInt(); //넣은 돈
			
			System.out.println("--- 음료를 선택하세요 ---");
			mo.showMenu(); //가격 설정 완료한 메뉴 보여주기
			
			mo.setDrink(kbd.nextInt()); //몇 번 음료 고를 건지 입력받기
			kbd.nextLine(); // 버퍼에 남은 엔터 지우기
	
			mo.showResult(money); //무슨 음료 선택했는지, 거스름돈 / 부족한 돈 보여주기
			System.out.println("계속 하시겠습니까?(y/n)");
			keepGoing = kbd.nextLine();
		}
	}

}
