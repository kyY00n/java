package ass3;
import java.util.Scanner;

class Song{
	String title;
	String singer;
	int price;
	
	public void play() { // ������ �뷡 Ʋ���ִ� play method
		System.out.println("�뷡����: \""+title+"\" by "+singer);
	}
	
	public void price() { // ���� �����ִ� method
		System.out.println(price +"���Դϴ�.");
	}
}
public class Week3_1_������ {

	public static void main(String[] args) {
		System.out.println("============");
		System.out.println("����: ���̹�����");
		System.out.println("�й�: 1971079");
		System.out.println("����: ������");
		System.out.println("============");
		
		Scanner kbd = new Scanner(System.in); //��ĳ�� ����
		//Song ��ü 2�� ����
		Song s1 = new Song(); 
		Song s2 = new Song();
		
		//ù��° �뷡 ���� �Է¹ޱ�
		System.out.println("\n*Song 1*");
		System.out.print("����Է�:");
		s1.title = kbd.nextLine();
		System.out.print("�������Է�:");
		s1.singer = kbd.nextLine();
		System.out.print("�����Է�:");
		s1.price = kbd.nextInt();
		
		kbd.nextLine(); //���ۿ� ���� ���� �����
		
		//�ι�° �뷡 ���� �Է¹ޱ�
		System.out.println("\n*Song 2*");
		System.out.print("����Է�:");
		s2.title = kbd.nextLine();
		System.out.print("�������Է�:");
		s2.singer = kbd.nextLine();
		System.out.print("�����Է�:");
		s2.price = kbd.nextInt();
		
		//�뷡 ����
		System.out.println("\n�뷡�� ������");
		System.out.println("1:"+s1.title+" 2:"+s2.title);
		int songNum;
		songNum = kbd.nextInt();
		
		if(songNum == 1) { //1�� ����� ��
			s1.play();
			s1.price();
		}
		else if(songNum == 2) { //2�� ����� ��
			s2.play();
			s2.price();
		}
		else //�̻��� ���� ������ ��
			System.out.println("�߸��� �Է��Դϴ�.");
		
		System.out.println("�����մϴ�."); //����
	}

}
