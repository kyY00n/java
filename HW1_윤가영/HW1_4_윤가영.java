import java.util.Scanner;

class StudentInformation { //학생정보 클래스 정의
	private String name;
	private String id;
	
	public void display() {
		System.out.println(name+'\t'+id);
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getId() {
		return id;
	}
}

class StudentScore extends StudentInformation{ //학생 점수 클래스 - 학생 정보 클래스의 자손
	private int korean;
	private int math;
	private int english;
	
	public void setKorean(int kor) {
		korean = kor;
	}
	
	public int getKorean() {
		return korean;
	}
	
	public void setMath(int math) {
		this.math = math;
	}
	
	public int getMath() {
		return math;
	}
	
	public void setEnglish(int eng) {
		english = eng;
	}
	
	public int getEnglish() {
		return english;
	}
	
	public double calcAvg() { //학생의 평균 점수를 반환하는 메서드
		return (korean+math+english)/3;
	}
	public void display() { //학생의 정보를 보여주는 메서드
		System.out.printf("%-16s%-8s%-8d%-8d%-8d%-8d%-8.2f\n", getName(), getId(), getKorean(),
				getMath(), getEnglish(), getKorean()+getMath()+getEnglish(), calcAvg());
	}
}
public class HW1_4_윤가영 {

	public static void main(String[] args) {
		System.out.println("============");
		System.out.println("전공: 사이버보안");
		System.out.println("학번: 1971079");
		System.out.println("성명: 윤가영");
		System.out.println("============");
		
		double korAvg = 0, mathAvg = 0, engAvg = 0; //과목 별 전체 학생들 평균 점수를 저장할 변수
		
		Scanner sc = new Scanner(System.in); //스캐너 생성
		
		System.out.println("How many students are there?");
		int numStd = sc.nextInt(); //총 학생의 수
		
		//학생의 수에 맞추어 학생 점수 참조변수 배열 정의
		StudentScore[] stdList = new StudentScore[numStd]; 
		
		
		System.out.println("Input the information.");
		for(int i = 0; i < numStd; i++) //학생 수만큼 반복
		{	System.out.println();
		
			stdList[i] = new StudentScore(); //학생 정보 객체 생성
			
			System.out.print("ID: "); 
			stdList[i].setId(sc.next()); //아이디 설정
			
			sc.nextLine();
			System.out.print("Name: ");
			stdList[i].setName(sc.nextLine()); //이름 설정
			
			System.out.print("Korean: ");
			stdList[i].setKorean(sc.nextInt()); //국어 점수 설정
			
			System.out.print("Math: ");
			stdList[i].setMath(sc.nextInt()); //수학 점수 설정
			
			System.out.print("English: ");
			stdList[i].setEnglish(sc.nextInt()); //영어 점수 설정
			
		}
		
		//학생 정보, 점수 합계, 평균 출력
		System.out.printf("\n%-16s%-8s%-8s%-8s%-8s%-8s%-8s\n","NAME","ID","KOREAN","MATH"
				, "ENGLISH", "SUM", "AVG");
		for(int i = 0; i < numStd; i++) {
			stdList[i].display();
			
			//학생 명수로 나눠주기 전에 과목별로 학생들의 점수 합산하기
			korAvg += stdList[i].getKorean();
			mathAvg += stdList[i].getMath();
			engAvg += stdList[i].getEnglish();
		}
		
		//학생 수로 나눈 후 평균 점수 저장
		korAvg /= numStd;
		mathAvg /= numStd;
		engAvg /= numStd;
		
		//과목별 평균 점수 출력
		System.out.printf("Subject Avg             %-8.2f%-8.2f%-8.2f\n\n", korAvg, mathAvg, engAvg);
		
		//과목별로 평균을 넘은 학생들 출력
		System.out.println("<Students over the average>");
		System.out.println();
		
		System.out.println("Korean: ");
		for(int i = 0; i < numStd; i++) {
			if(stdList[i].getKorean() > korAvg)
				System.out.printf("%-16s", stdList[i].getName());
		}
		System.out.println();
		System.out.println("Math: ");
		for(int i = 0; i < numStd; i++) {
			if(stdList[i].getMath() > mathAvg)
				System.out.printf("%-16s", stdList[i].getName());
		}
		System.out.println();
		System.out.println("English: ");
		for(int i = 0; i < numStd; i++) {
			if(stdList[i].getEnglish() > engAvg)
				System.out.printf("%-16s", stdList[i].getName());
		}
	}

}
