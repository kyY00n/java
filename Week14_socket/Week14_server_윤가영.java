import java.io.*;
import java.net.*;
import java.util.*;

public class Week14_server_윤가영 {
	
	public static void main(String[] args) {
		
		System.out.println("전공: 사이버보안전공");
		System.out.println("학번: 1971079");
		System.out.println("이름: 윤가영");

		ServerSocket serverSocket = null; //서버소켓 참조변수
		Socket socket = null; //소켓 참조변수
		
		try
		{
			serverSocket = new ServerSocket(4444); //포트번호를 4444로 지정하여 새로운 서버소켓을 생성합니다.
			socket = serverSocket.accept(); //client의 connect요청을 받습니다.
			
			Scanner in = new Scanner(socket.getInputStream()); //Socket inputStream - Scanner
			PrintWriter out = new PrintWriter(socket.getOutputStream()); //Socket outputStream - PrintWriter
			
			String strIn = in.next(); //"Hello?"를 받아옵니다.
			System.out.println(strIn); //출력
			
			out.println("How many numbers?"); //"How many numbers?"를 print
			out.flush(); //flush buffer
			
			strIn = in.next(); //client input number
			
			System.out.println(strIn); //print client input
			
			out.println("Input "+strIn+" numbers"); //client가 만약 5를 입력했으면 "Input 5 numbers"를 보내요
			out.flush(); //flush
			
			int numCount = Integer.parseInt(strIn); //client가 보내준 숫자 문자열을 int로 변환해 numCount에 저장해줍니다.

			//client가 보낸 숫자들의 합과 평균을 저장할 변수들
			int sum = 0;
			double avg = 0.0;
			
			//numCount 번 반복해서 client의 숫자 입력을 받아와 sum에 더합니다.
			for(int i = 0; i < numCount; i++)
			{
				strIn = in.next();
				int numIn = Integer.parseInt(strIn);
				
				sum += numIn;
			}
			
			//avg를 계산해줍니다.
			avg = (double)sum/numCount;
			
			//결과를 보냅니다.
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
