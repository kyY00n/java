import java.util.*;

public class Week10_2_������ {

	public static void main(String[] args) {
		System.out.println("============");
		System.out.println("����: ���̹�����");
		System.out.println("�й�: 1971079");
		System.out.println("����: ������");
		System.out.println("============");
		
		//��ĳ�� ��ü sc ����
		Scanner sc = new Scanner(System.in);
		
		////////////////////////////////////
		//�л� ���̵�, �̸� �����ϴ� HashMap �����~//
		///////////////////////////////////
		
		String ID, name, str; //�л����� hashmap�� �߰��� �� Ű���� �Է��� ������ ����.
				
		Map<String, String> stuMap = new HashMap<String, String>();
		
		System.out.println("�л��� ID�� �̸��� ���ʷ� �Է��ϼ���. (����� 0 0 �Է�)");
		while(true)
		{
			ID = sc.next();
			name = sc.next();
			
			if(ID.equals("0") && name.equals("0")) break;
			
			stuMap.put(ID, name); //Data input
		}
		
		Set s = stuMap.keySet();
		Iterator<String> it = s.iterator();
		
		System.out.println("<�л����>");
		System.out.println("[ID]			[NAME]");
		
		while(it.hasNext())
		{	
			str = it.next();
			System.out.println(str+"			"+stuMap.get(str));
		}
		
		System.out.println();
		System.out.println("��ü �л���:" + stuMap.size()); //stuMap ����� ��
		
		//////////////////
		//�� �̸� �F�� �̸� ã��//
		//////////////////
		
		int maxLength = 0, minLength = 0;
		String maxID, minID;
		
		//���� �� �̸� ã��
		String nextID; //iterator�� ���� key(ID)�� ������ ���ڿ� ���� 
		int nextLength = 0; //iterator�� ���� value(name)�� ���̸� ������ ���� ����
		
		Iterator<String> itMx = s.iterator(); //���� �� �̸��� ã�� �� ����� iterator
		
		
		maxID = itMx.next(); //maxID�� ���� �ִ� ���̵� �� �ϳ��� �ʱ�ȭ.
		maxLength = stuMap.get(maxID).length(); //maxLength�� �ʱ�ȭ�� maxID�� value�� �ʱ�ȭ.
		
		while(itMx.hasNext())
		{
			nextID = itMx.next();
			nextLength = stuMap.get(nextID).length();
			
			if(maxLength < nextLength) //���� value�� ���̰� �� �� ��
			{
				maxID = nextID;
				maxLength = nextLength;
			}
		}
		
		System.out.println("<���� �� �̸��� ���� �л�>");
		System.out.println("ID: "+maxID+" Name: "+stuMap.get(maxID)+" ����: "+maxLength);
		//////////////////////////////////////////////////////////////////////////////// ���� �� �̸� ã�� ��
		
		//���� ª�� �̸� ã��
		Iterator<String> itMn = s.iterator();
		minID = itMn.next();
		minLength = stuMap.get(minID).length();
		
		while(itMn.hasNext())
		{
			nextID = itMn.next();
			nextLength = stuMap.get(nextID).length();
			
			if(minLength > nextLength) //���� value�� ���̰� �� ª�� ��
			{
				minID = nextID;
				minLength = nextLength;
			}
		}
		
		System.out.println("<���� ª�� �̸��� ���� �л�>");
		System.out.println("ID: "+minID+" Name: "+stuMap.get(minID)+" ����: "+minLength);
		//////////////////////////////////////////////////////////////////////////////// ���� ª�� �̸� ã�� ��
		
		sc.close();
		
	}

}
