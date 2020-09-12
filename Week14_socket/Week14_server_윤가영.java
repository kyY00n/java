import java.io.*;
import java.net.*;
import java.util.*;

public class Week14_server_������ {
	
	public static void main(String[] args) {
		
		System.out.println("����: ���̹���������");
		System.out.println("�й�: 1971079");
		System.out.println("�̸�: ������");

		ServerSocket serverSocket = null; //�������� ��������
		Socket socket = null; //���� ��������
		
		try
		{
			serverSocket = new ServerSocket(4444); //��Ʈ��ȣ�� 4444�� �����Ͽ� ���ο� ���������� �����մϴ�.
			socket = serverSocket.accept(); //client�� connect��û�� �޽��ϴ�.
			
			Scanner in = new Scanner(socket.getInputStream()); //Socket inputStream - Scanner
			PrintWriter out = new PrintWriter(socket.getOutputStream()); //Socket outputStream - PrintWriter
			
			String strIn = in.next(); //"Hello?"�� �޾ƿɴϴ�.
			System.out.println(strIn); //���
			
			out.println("How many numbers?"); //"How many numbers?"�� print
			out.flush(); //flush buffer
			
			strIn = in.next(); //client input number
			
			System.out.println(strIn); //print client input
			
			out.println("Input "+strIn+" numbers"); //client�� ���� 5�� �Է������� "Input 5 numbers"�� ������
			out.flush(); //flush
			
			int numCount = Integer.parseInt(strIn); //client�� ������ ���� ���ڿ��� int�� ��ȯ�� numCount�� �������ݴϴ�.

			//client�� ���� ���ڵ��� �հ� ����� ������ ������
			int sum = 0;
			double avg = 0.0;
			
			//numCount �� �ݺ��ؼ� client�� ���� �Է��� �޾ƿ� sum�� ���մϴ�.
			for(int i = 0; i < numCount; i++)
			{
				strIn = in.next();
				int numIn = Integer.parseInt(strIn);
				
				sum += numIn;
			}
			
			//avg�� ������ݴϴ�.
			avg = (double)sum/numCount;
			
			//����� �����ϴ�.
			out.println("Sum: "+Integer.toString(sum));
			out.println("Avg: "+Double.toString(avg));
			out.flush();
			
			System.out.println("Service finished.");
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
			try
			{
				serverSocket.close();
			}
			catch(Exception e)
			{
				System.out.println(e.getMessage());
			}
		}
	}

}
