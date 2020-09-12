import java.util.Scanner;

class StudentInformation { //�л����� Ŭ���� ����
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

class StudentScore extends StudentInformation{ //�л� ���� Ŭ���� - �л� ���� Ŭ������ �ڼ�
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
	
	public double calcAvg() { //�л��� ��� ������ ��ȯ�ϴ� �޼���
		return (korean+math+english)/3;
	}
	public void display() { //�л��� ������ �����ִ� �޼���
		System.out.printf("%-16s%-8s%-8d%-8d%-8d%-8d%-8.2f\n", getName(), getId(), getKorean(),
				getMath(), getEnglish(), getKorean()+getMath()+getEnglish(), calcAvg());
	}
}
public class HW1_4_������ {

	public static void main(String[] args) {
		System.out.println("============");
		System.out.println("����: ���̹�����");
		System.out.println("�й�: 1971079");
		System.out.println("����: ������");
		System.out.println("============");
		
		double korAvg = 0, mathAvg = 0, engAvg = 0; //���� �� ��ü �л��� ��� ������ ������ ����
		
		Scanner sc = new Scanner(System.in); //��ĳ�� ����
		
		System.out.println("How many students are there?");
		int numStd = sc.nextInt(); //�� �л��� ��
		
		//�л��� ���� ���߾� �л� ���� �������� �迭 ����
		StudentScore[] stdList = new StudentScore[numStd]; 
		
		
		System.out.println("Input the information.");
		for(int i = 0; i < numStd; i++) //�л� ����ŭ �ݺ�
		{	System.out.println();
		
			stdList[i] = new StudentScore(); //�л� ���� ��ü ����
			
			System.out.print("ID: "); 
			stdList[i].setId(sc.next()); //���̵� ����
			
			sc.nextLine();
			System.out.print("Name: ");
			stdList[i].setName(sc.nextLine()); //�̸� ����
			
			System.out.print("Korean: ");
			stdList[i].setKorean(sc.nextInt()); //���� ���� ����
			
			System.out.print("Math: ");
			stdList[i].setMath(sc.nextInt()); //���� ���� ����
			
			System.out.print("English: ");
			stdList[i].setEnglish(sc.nextInt()); //���� ���� ����
			
		}
		
		//�л� ����, ���� �հ�, ��� ���
		System.out.printf("\n%-16s%-8s%-8s%-8s%-8s%-8s%-8s\n","NAME","ID","KOREAN","MATH"
				, "ENGLISH", "SUM", "AVG");
		for(int i = 0; i < numStd; i++) {
			stdList[i].display();
			
			//�л� ����� �����ֱ� ���� ���񺰷� �л����� ���� �ջ��ϱ�
			korAvg += stdList[i].getKorean();
			mathAvg += stdList[i].getMath();
			engAvg += stdList[i].getEnglish();
		}
		
		//�л� ���� ���� �� ��� ���� ����
		korAvg /= numStd;
		mathAvg /= numStd;
		engAvg /= numStd;
		
		//���� ��� ���� ���
		System.out.printf("Subject Avg             %-8.2f%-8.2f%-8.2f\n\n", korAvg, mathAvg, engAvg);
		
		//���񺰷� ����� ���� �л��� ���
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
