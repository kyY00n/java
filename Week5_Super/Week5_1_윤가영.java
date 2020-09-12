import java.util.Scanner;

class Production{ //Production 클래스 정의
	private String title;
	private String director;
	private String writer;
	
	public Production() {} //default 생성자
	
	// private 멤버 변수의 accessor 메서드 정의
	public String getTitle() {
		return title;
	}
	public String getDirector() {
		return director;
	}
	public String getWriter() {
		return writer;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	
	//display() 메서드 입니다. 정보를 출력해요.
	public void display() {
		System.out.println("Title:"+title);
		System.out.println("Director:"+director);
		System.out.println("Writer:"+writer);
	}
}
class Play extends Production { //Play 클래스 정의입니다.
	private int performanceCost;
	
	public Play() {
		this(null, null, null); //바로 밑에 있는 생성자로 했어요.
	}
	
	public Play(String title, String director, String writer) { //매개변수가 있는 생성자입니다.
		this.setTitle(title);
		this.setDirector(director);
		this.setWriter(writer);
	}
	
	//private 변수 accessor 메서드
	public int getPerformanceCost() {
		return performanceCost;
	}
	public void setPerformanceCost(int pc) {
		performanceCost = pc;
	}
	
	//display() 메서드 - Play의 정보를 보여줍니다.
	public void display() {
		super.display();
		System.out.println("performance cost:"+performanceCost);
	}
}
class Film extends Production { //Film 클래스 정의입니다.
	private int boxOfficeGross;
	
	public Film() { //Film 생성자입니다.
		this(null, null, null);
	}

	public Film(String title, String director, String writer) { //Film 생성자 - 매개변수가 있음
		this.setTitle(title);
		this.setDirector(director);
		this.setWriter(writer);
	}
	
	//private 변수 accessor 메서드
	public int getBoxOfficeGross() {
		return boxOfficeGross;
	}
	public void setBoxOfficeGross(int bog) {
		boxOfficeGross = bog;
	}
	
	//Film의 정보를 출력하는 메서드입니다.
	public void display() {
		super.display();
		System.out.println("boxOfficeGross:"+boxOfficeGross);
	}
}
public class Week5_1_윤가영 {

	public static void main(String[] args) {
		System.out.println("============");
		System.out.println("전공: 사이버보안");
		System.out.println("학번: 1971079");
		System.out.println("성명: 윤가영");
		System.out.println("============");
		
		Scanner sc = new Scanner(System.in); //스캐너 생성
		
		Play p = new Play(); //play 객체 생성
		Film f = new Film(); //Film 객체 생성
		
		//p의 정보를 입력받습니다.
		System.out.println("Input Title for play");
		p.setTitle(sc.nextLine());
		System.out.println("Input Director for play");
		p.setDirector(sc.nextLine());
		System.out.println("Input Writer for play");
		p.setWriter(sc.nextLine());
		
		//f의 정보를 입력받습니다.
		System.out.println("Input Title for film");
		f.setTitle(sc.nextLine());
		System.out.println("Input Director for film");
		f.setDirector(sc.nextLine());
		System.out.println("Input Writer for film");
		f.setWriter(sc.nextLine());
		
		//p의 performanceCost와 f의 boxOfficeGross 를 입력받습니다.
		System.out.println("Input Performance Cost for Play");
		p.setPerformanceCost(sc.nextInt());
		System.out.println("Input boxOfficeGross for Film");
		f.setBoxOfficeGross(sc.nextInt());
		
		//p와 f의 정보를 출력합니다.
		p.display();
		System.out.println();
		f.display();
	}

}
