import java.util.Scanner;

class Song {
	public String title;
	public String singer;
	public int price;
	
	public void play() {
		System.out.println(title+" by "+singer);
	}
	
	public Song() { //default ������
		
	}
	
	public Song(String title, int price) { //���� ������ ���� ������
		this(title,"��",price);
	}
	
	public Song(String title, String singer, int price) { //��� ������ �ִ� ������
		this.title = title;
		this.singer = singer;
		this.price = price;
	}
}

public class Week4_1_������ {

	public static void main(String[] args) {
		System.out.println("============");
		System.out.println("����: ���̹�����");
		System.out.println("�й�: 1971079");
		System.out.println("����: ������");
		System.out.println("============");
		
		//��ĳ�� �Է°��� ���� �뷡 ����, ����, ������ ������ �����Դϴ�.
		String inputTt = null;
		String inputSinger = null;
		int inputPrice = 0;
		
		Scanner kbd = new Scanner(System.in); //��ĳ�� ����
		
		System.out.println("*Song ����*");
		System.out.print("���: ");
		inputTt = kbd.nextLine(); //����� �Է¹޾ƿ�.
		
		while(inputTt.equals("")) { //����� �Է����� ������ ��� ����� while�� �Դϴ�.
			System.out.println("����� �ݵ�� �ʿ��մϴ�.");
			System.out.print("���: ");
			inputTt = kbd.nextLine();
		}
		
		//������ �Է¹޾ƿ�.
		System.out.print("������: ");
		inputSinger = kbd.nextLine();
		//������ �Է¹޾ƿ�.
		System.out.print("����: ");
		inputPrice = kbd.nextInt();
		
		//Song Ŭ���� ������ �����մϴ�.
		Song ipSong;
		
		if(!inputSinger.equals("")) { //�������� �Է��� ���, �� ���ڸ� ��� ����ϴ� �����ڸ� ����մϴ�.
			ipSong = new Song(inputTt, inputSinger, inputPrice);
		}
		else //�������� �Է����� ���� ��쿡�� �������� �ʿ���� �����ڸ� ����մϴ�.
			ipSong = new Song(inputTt, inputPrice);
		
		System.out.println("�� �� �����ðڽ��ϱ�?");
		int count = kbd.nextInt(); //���� Ƚ���� �Է¹޽��ϴ�.
		for(int i = 0; i < count; i++) {
			ipSong.play(); //�Է¹��� Ƚ����ŭ play()�� ȣ���մϴ�.
		}
		System.out.println("�� "+inputPrice*count+"���Դϴ�."); //�� ������ ����մϴ�.
		
	}

}
