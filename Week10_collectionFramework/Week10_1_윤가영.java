import java.util.*;
class Student {
	public Student() {}
	
	public Student (String n, String id, int a)
	{
		name = n; ID = id; age = a;
	}
	
	//���� ������ ��� public���� �����߾��
	public String name;
	public String ID;
	public int age;
	
	public String toString() //�������� ȣ�� ���� �� �̸�, ���̵�, ���̸� ��ȯ�ϵ��� toString�� overriding
	{
		return String.format("%-8s%-8s%-4d", name, ID, age);
	}
}
public class Week10_1_������ {

	public static void main(String[] args) {
		System.out.println("============");
		System.out.println("����: ���̹�����");
		System.out.println("�й�: 1971079");
		System.out.println("����: ������");
		System.out.println("============");
		
		Scanner sc = new Scanner(System.in);
		
		///////////�л� ������ ������ ArrayList s ����////////////
		ArrayList <Student> s = new ArrayList<Student>();
		
		System.out.println("Input Student Name, ID, and age. 0 for name to quit.");
		
		while(true) //�л� ������ �Է¹޽��ϴ�
		{
			String name = sc.next();  //���� �̸��� ���� �޾Ƽ� ������ �����߾��
			
			if(name.equals("0")) break; //break �������� name�� ����ϴ�
			
			s.add(new Student(name, sc.next(), sc.nextInt())); //s�� �л� ��ü �߰�!
		}
		
		System.out.println();
		printResult(s);
		///////////////////////ArrayList s �ʱ�ȭ ��///////////////////////////////////
		
		
		int num = 0; //����ڰ� � ����� ���� �Է¹޴� �����Դϴ�
		for(;;) //������ ��� �����ؾ��� �� �𸣰ھ ��� ���ư���..
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
	
	public static void printResult(List<Student> student) //�л� ����� ����ϴ� �޼���
	{
		System.out.println("NUMBER  NAME    ID      AGE");
		for(int i = 0; i < student.size(); i++)
		{
			System.out.printf("%-8d", i+1); //0��°�� 1������ ����ؾ��ϴϱ� +1�߾��
			System.out.println(student.get(i)); //toString()
		}
	}
	
	public static void deleteStudent(List<Student> stu)
	{
		Scanner sc = new Scanner(System.in); //�Է¹޾ƾ��ϴϱ� ��ĳ�� sc ����
		int index = sc.nextInt() - 1; //����ڰ� �Է��� �� ���� index�� 1�� ���� ���̹Ƿ� 1�� ���� �����մϴ�.
		
		stu.remove(index); //���� ��� �����
		
	}
	
	public static void addStudent(List<Student> stu)
	{		
		Scanner sc = new Scanner(System.in); //��ĳ�� ����
		
		String name = sc.next();
		String ID = sc.next();
		int age = sc.nextInt();
		int index = sc.nextInt() - 1;
		
		stu.add(index, new Student(name, ID, age));

	}
	
}
