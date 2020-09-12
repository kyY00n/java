import java.io.*;
import java.net.*;
import java.util.*;

public class Week14_client_������ {

	public static void main(String[] args) {
		
		System.out.println("����: ���̹���������");
		System.out.println("�й�: 1971079");
		System.out.println("�̸�: ������");
		
		//���� ���������� �����մϴ�.
		Socket socket = null;
	
		try 
		{
			//�� IP�ּҿ� server�� ��Ʈ��ȣ�� �����Ͽ� ���� ��ü�� �����մϴ�. 
			socket = new Socket("192.168.219.106", 4444);
			
			Scanner userSc = new Scanner(System.in); //console �Է��� ���� Scanner
			Scanner in = new Scanner(socket.getInputStream()); //Socket input Stream - Scanner
			PrintWriter out = new PrintWriter(socket.getOutputStream()); //Socket output Stream - PrintWriter
			
			out.println("Hello?"); //server���� "Hello?"�� �����ϴ�.
			out.flush(); //flush
			
			System.out.println(in.nextLine()); //"How many numbers?"�� �޾ƿɴϴ�.
			
			String userIn = userSc.next(); //��� ���ڸ� �Է����� �����մϴ�.
			out.println(userIn);
			out.flush();
			
			System.out.println(in.nextLine()); //"Input (userIn) numbers" �� �޾ƿɴϴ�.
			
			int numCount = Integer.parseInt(userIn); //�Ʊ� ����ڰ� �Է��� ���� ���ڿ��� int�� ��ȯ�մϴ�.
			
			//numCount�� �ݺ��Ͽ� ���ڸ� �Է��մϴ�.
			for(int i = 0; i< numCount; i++)
			{
				userIn = userSc.next();
				out.println(userIn);
				out.flush();
			}
			
			//Sum�� Avg�� �޾ƿɴϴ�.
			System.out.println(in.nextLine());
			System.out.println(in.nextLine());
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		finally
		{
			try
			{
				socket.close();
			}
			catch(Exception e)
			{
				System.out.println(e.getMessage());
			}
		}
	}

}