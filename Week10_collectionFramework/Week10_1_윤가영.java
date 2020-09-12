import java.util.*;
class Student {
	public Student() {}
	
	public Student (String n, String id, int a)
	{
		name = n; ID = id; age = a;
	}
	
	//따로 조건이 없어서 public으로 선언했어요
	public String name;
	public String ID;
	public int age;
	
	public String toString() //참조변수 호출 했을 때 이름, 아이디, 나이를 반환하도록 toString을 overriding
	{
		return String.format("%-8s%-8s%-4d", name, ID, age);
	}
}
public class Week10_1_윤가영 {

	public static void main(String[] args) {
		System.out.println("============");
		System.out.println("전공: 사이버보안");
		System.out.println("학번: 1971079");
		System.out.println("성명: 윤가영");
		System.out.println("============");
		
		Scanner sc = new Scanner(System.in);
		
		///////////학생 정보를 저장할 ArrayList s 선언////////////
		ArrayList <Student> s = new ArrayList<Student>();
		
		System.out.println("Input Student Name, ID, and age. 0 for name to quit.");
		
		while(true) //학생 정보를 입력받습니다
		{
			String name = sc.next();  //저는 이름을 먼저 받아서 변수에 저장했어요
			
			if(name.equals("0")) break; //break 조건으로 name을 썼습니다
			
			s.add(new Student(name, sc.next(), sc.nextInt())); //s에 학생 객체 추가!
		}
		
		System.out.println();
		printResult(s);
		///////////////////////ArrayList s 초기화 끝///////////////////////////////////
		
		
		int num = 0; //사용자가 어떤 기능을 쓸지 입력받는 변수입니다
		for(;;) //구간을 어떻게 설정해야할 지 모르겠어서 계속 돌아가게..
		{	
			System.out.println();
			System.out.println("Choose the operation you want.");
			System.out.println("1.add information 2.delete information 3.show list 4.Finish program");
			num = sc.nextInt();
			switch(num) 
			{
				case 1: System.out.println("Input new Student Name, ID, and Age, and the location");
						addStudent(s); printResult(s); break;
				case 2: System.out.println("Input Student Number to delete.");
						deleteStudent(s); printResult(s); break;
				case 3: printResult(s); break;
				case 4: System.exit(0);
				default: System.out.println("Wrong input."); break;
			}
		}
	}
	
	public static void printResult(List<Student> student) //학생 목록을 출력하는 메서드
	{
		System.out.println("NUMBER  NAME    ID      AGE");
		for(int i = 0; i < student.size(); i++)
		{
			System.out.printf("%-8d", i+1); //0번째를 1번으로 출력해야하니까 +1했어요
			System.out.println(student.get(i)); //toString()
		}
	}
	
	public static void deleteStudent(List<Student> stu)
	{
		Scanner sc = new Scanner(System.in); //입력받아야하니까 스캐너 sc 생성
		int index = sc.nextInt() - 1; //사용자가 입력한 건 실제 index에 1을 더한 것이므로 1을 빼서 저장합니다.
		
		stu.remove(index); //선택 요소 지우기
		
	}
	
	public static void addStudent(List<Student> stu)
	{		
		Scanner sc = new Scanner(System.in); //스캐너 생성
		
		String name = sc.next();
		String ID = sc.next();
		int age = sc.nextInt();
		int index = sc.nextInt() - 1;
		
		stu.add(index, new Student(name, ID, age));

	}
	
}
