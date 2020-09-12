import java.util.Scanner;

class Time {
	private int hour;
	private int minute;
	
	private boolean isValid(int hour, int minute) { //유효한 시간인지 판단하는 메서드
		if (hour >= 0 && hour <=23 && minute >= 0 && minute <=59)
			return true;
		else
			return false;
	}
	
	public void setTime(int hour, int minute) { //time setter
		if(this.isValid(hour, minute) == true) { //isValid가 true이면 입력값을 대입.
			this.hour = hour;
			this.minute = minute;
		}
		else { //isValid가 false일 때
			System.out.println("Wrong Input"); //"Wrong Input" 출력
			this.hour = 0; //0시 0분으로 set
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
public class HW1_1_윤가영 {

	public static void main(String[] args) {
		System.out.println("============");
		System.out.println("전공: 사이버보안");
		System.out.println("학번: 1971079");
		System.out.println("성명: 윤가영");
		System.out.println("============");
		
		Scanner sc = new Scanner(System.in); //스캐너 생성
		
		Time t = new Time(); // Time 객체 t 생성
		int inHour=0, inMin=0; // 시간을 입력받을 변수입니다.
		
		System.out.println("Hour:");
		inHour = sc.nextInt(); //시간 입력
		System.out.println("Minute:");
		inMin = sc.nextInt(); //분 입력
		
		t.setTime(inHour, inMin); //t 시간 set
		
		System.out.println(t.getTime('h')+":"+t.getTime('m')); //t 시간 출력
	}

}
