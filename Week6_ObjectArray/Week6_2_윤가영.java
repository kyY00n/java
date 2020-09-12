import java.util.Scanner;

class Car {
	private String emgType;
	private int num;
	private String carType;
	private String reqPerson;
	
	public Car() { //디폴트 생성자입니다
	
	}
	public Car(String emg, int numb, String car, String req) { //파라미터를 갖는 생성자입니다.
		emgType = emg;
		num = numb;
		carType = car;
		reqPerson = req;
	}
	public String getEmgType() { //Emgtype getter
		return emgType;
	}
	public int getNumber() { //number getter
		return num;
	}
	public String getCarType() { //Cartype getter
		return carType;
	}
	public String getReqPerson() { //Reqired person getter
		return reqPerson;
	}
	public String getStr() { // output
		return getEmgType()+"\t\t"+
				Integer.toString(getNumber())+"\t\t"+getCarType()+"\t"+getReqPerson();
	}
}

class FireEngine extends Car { //소방차 클래스
	public FireEngine() { //car클래스 생성자 이용
		super("Fire", 119, "FireEngine", "FireFighter");
	}
	public String toString() {
		return getStr(); //상속받은 메서드
	}
}

class Ambulance extends Car { //구급차 클래스
	public Ambulance() { //super()이용
		super("Patient", 119, "Ambulance", "Doctor");
	}
	public String toString() {
		return getStr();
	}
}

class PoliceCar extends Car { //경찰차 클래스
	public PoliceCar() { //super() 이용
		super("Thief", 112, "PoilceCar", "PoliceOfficer");
	}
	public String toString() {
		return getStr();
	}
}

class Emergency { 
	public int carNum;
	public Car emgList[] = new Car[10]; // 참조변수 배열 생성
	
	public void EM_Call(Car c) {  //응급 차 부르기 메서드
		
		if(c instanceof FireEngine) { //메서드의 파라미터가 소방차일 때
			emgList[carNum] = new FireEngine();
		}
		else if(c instanceof Ambulance) { //매개변수 객체가 구급차일 때
			emgList[carNum] = new Ambulance();
		}
		else if(c instanceof PoliceCar) { //매개변수 객체가 경찰차일 때
			emgList[carNum] = new PoliceCar();
		}
		System.out.println("Call "+emgList[carNum].getNumber()); //번호 출력
		carNum++; //다음 객체를 저장할 인덱스
	}
	
	public void EM_record() { 
		System.out.printf(String.format("%-16s", "Emergency")); //줄맞춰 출력했어요
		System.out.printf(String.format("%-16s", "Number"));
		System.out.printf(String.format("%-16s", "Car_Type"));
		System.out.printf(String.format("%-16s\n", "Required"));
		
		for(int i = 0 ; i < carNum; i++) { //지금까지 저장된 객체들을 출력합니다.
			System.out.println(emgList[i]); //toString메서드를 호출합니다. (참조변수 호출)
		}
	}
}
public class Week6_2_윤가영 {

	public static void main(String[] args) {
		System.out.println("============");
		System.out.println("전공: 사이버보안");
		System.out.println("학번: 1971079");
		System.out.println("성명: 윤가영");
		System.out.println("============");
		
		int inputNum = 0; //어떤 응급상황인지 입력받을 변수입니다.
		
		Scanner sc = new Scanner(System.in);
		
		Emergency em = new Emergency(); //Emergency객체 생성
		
		while(true) {
			System.out.println("What Kind of emergency?");
			System.out.println("1.Fire   2.patient   3.Thief   4.Record   5.End");
			inputNum = sc.nextInt();
			
			if(inputNum == 5) { //종료
				System.out.println("Finished");
				break;
			}
			
			else if(inputNum == 1) { //화재 상황
				FireEngine fe = new FireEngine(); //소방차 객체 생성
				
				em.EM_Call(fe);System.out.println(em.carNum);
			}
			else if(inputNum == 2) { //환자 발생
				Ambulance ab = new Ambulance(); // 구급차 객체 생성
				em.EM_Call(ab);
			}
			else if(inputNum == 3) { //도둑 사건
				PoliceCar pc = new PoliceCar(); //경찰차 객체 생성
				em.EM_Call(pc);
			}
			else if(inputNum == 4) { //기록 보기
				em.EM_record();
			}
		}
	}

}
