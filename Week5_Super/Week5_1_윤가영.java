import java.util.Scanner;

class Production{ //Production Ŭ���� ����
	private String title;
	private String director;
	private String writer;
	
	public Production() {} //default ������
	
	// private ��� ������ accessor �޼��� ����
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
	
	//display() �޼��� �Դϴ�. ������ ����ؿ�.
	public void display() {
		System.out.println("Title:"+title);
		System.out.println("Director:"+director);
		System.out.println("Writer:"+writer);
	}
}
class Play extends Production { //Play Ŭ���� �����Դϴ�.
	private int performanceCost;
	
	public Play() {
		this(null, null, null); //�ٷ� �ؿ� �ִ� �����ڷ� �߾��.
	}
	
	public Play(String title, String director, String writer) { //�Ű������� �ִ� �������Դϴ�.
		this.setTitle(title);
		this.setDirector(director);
		this.setWriter(writer);
	}
	
	//private ���� accessor �޼���
	public int getPerformanceCost() {
		return performanceCost;
	}
	public void setPerformanceCost(int pc) {
		performanceCost = pc;
	}
	
	//display() �޼��� - Play�� ������ �����ݴϴ�.
	public void display() {
		super.display();
		System.out.println("performance cost:"+performanceCost);
	}
}
class Film extends Production { //Film Ŭ���� �����Դϴ�.
	private int boxOfficeGross;
	
	public Film() { //Film �������Դϴ�.
		this(null, null, null);
	}

	public Film(String title, String director, String writer) { //Film ������ - �Ű������� ����
		this.setTitle(title);
		this.setDirector(director);
		this.setWriter(writer);
	}
	
	//private ���� accessor �޼���
	public int getBoxOfficeGross() {
		return boxOfficeGross;
	}
	public void setBoxOfficeGross(int bog) {
		boxOfficeGross = bog;
	}
	
	//Film�� ������ ����ϴ� �޼����Դϴ�.
	public void display() {
		super.display();
		System.out.println("boxOfficeGross:"+boxOfficeGross);
	}
}
public class Week5_1_������ {

	public static void main(String[] args) {
		System.out.println("============");
		System.out.println("����: ���̹�����");
		System.out.println("�й�: 1971079");
		System.out.println("����: ������");
		System.out.println("============");
		
		Scanner sc = new Scanner(System.in); //��ĳ�� ����
		
		Play p = new Play(); //play ��ü ����
		Film f = new Film(); //Film ��ü ����
		
		//p�� ������ �Է¹޽��ϴ�.
		System.out.println("Input Title for play");
		p.setTitle(sc.nextLine());
		System.out.println("Input Director for play");
		p.setDirector(sc.nextLine());
		System.out.println("Input Writer for play");
		p.setWriter(sc.nextLine());
		
		//f�� ������ �Է¹޽��ϴ�.
		System.out.println("Input Title for film");
		f.setTitle(sc.nextLine());
		System.out.println("Input Director for film");
		f.setDirector(sc.nextLine());
		System.out.println("Input Writer for film");
		f.setWriter(sc.nextLine());
		
		//p�� performanceCost�� f�� boxOfficeGross �� �Է¹޽��ϴ�.
		System.out.println("Input Performance Cost for Play");
		p.setPerformanceCost(sc.nextInt());
		System.out.println("Input boxOfficeGross for Film");
		f.setBoxOfficeGross(sc.nextInt());
		
		//p�� f�� ������ ����մϴ�.
		p.display();
		System.out.println();
		f.display();
	}

}
