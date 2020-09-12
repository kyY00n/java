import java.util.Scanner;

class Time {
	private int hour;
	private int minute;
	
	private boolean isValid(int hour, int minute) { //��ȿ�� �ð����� �Ǵ��ϴ� �޼���
		if (hour >= 0 && hour <=23 && minute >= 0 && minute <=59)
			return true;
		else
			return false;
	}
	
	public void setTime(int hour, int minute) { //time setter
		if(this.isValid(hour, minute) == true) { //isValid�� true�̸� �Է°��� ����.
			this.hour = hour;
			this.minute = minute;
		}
		else { //isValid�� false�� ��
			System.out.println("Wrong Input"); //"Wrong Input" ���
			this.hour = 0; //0�� 0������ set
			this.minute = 0;
		}
	}
	
	public int getTime(char ch) { //time getter
		if(ch == 'h' || ch == 'H') //get hour
			return hour;
		else if (ch == 'M' || ch == 'm') //get minute
			return minute;
		else return -1;
	}
}
public class HW1_1_������ {

	public static void main(String[] args) {
		System.out.println("============");
		System.out.println("����: ���̹�����");
		System.out.println("�й�: 1971079");
		System.out.println("����: ������");
		System.out.println("============");
		
		Scanner sc = new Scanner(System.in); //��ĳ�� ����
		
		Time t = new Time(); // Time ��ü t ����
		int inHour=0, inMin=0; // �ð��� �Է¹��� �����Դϴ�.
		
		System.out.println("Hour:");
		inHour = sc.nextInt(); //�ð� �Է�
		System.out.println("Minute:");
		inMin = sc.nextInt(); //�� �Է�
		
		t.setTime(inHour, inMin); //t �ð� set
		
		System.out.println(t.getTime('h')+":"+t.getTime('m')); //t �ð� ���
	}

}
