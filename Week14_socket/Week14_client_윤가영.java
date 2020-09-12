import java.io.*;
import java.net.*;
import java.util.*;

public class Week14_client_윤가영 {

	public static void main(String[] args) {
		
		System.out.println("전공: 사이버보안전공");
		System.out.println("학번: 1971079");
		System.out.println("이름: 윤가영");
		
		//소켓 참조변수를 선언합니다.
		Socket socket = null;
	
		try 
		{
			//제 IP주소와 server의 포트번호를 설정하여 소켓 객체를 생성합니다. 
			socket = new Socket("192.168.219.106", 4444);
			
			Scanner userSc = new Scanner(System.in); //console 입력을 받을 Scanner
			Scanner in = new Scanner(socket.getInputStream()); //Socket input Stream - Scanner
			PrintWriter out = new PrintWriter(socket.getOutputStream()); //Socket output Stream - PrintWriter
			
			out.println("Hello?"); //server에게 "Hello?"를 보냅니다.
			out.flush(); //flush
			
			System.out.println(in.nextLine()); //"How many numbers?"를 받아옵니다.
			
			String userIn = userSc.next(); //몇번 숫자를 입력할지 전송합니다.
			out.println(userIn);
			out.flush();
			
			System.out.println(in.nextLine()); //"Input (userIn) numbers" 를 받아옵니다.
			
			int numCount = Integer.parseInt(userIn); //아까 사용자가 입력한 숫자 문자열을 int로 변환합니다.
			
			//numCount번 반복하여 숫자를 입력합니다.
			for(int i = 0; i< numCount; i++)
			{
				userIn = userSc.next();
				out.println(userIn);
				out.flush();
			}
			
			//Sum과 Avg를 받아옵니다.
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