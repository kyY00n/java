import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.io.EOFException;
import java.io.IOException;
import java.util.Scanner;

public class Week9_1_윤가영 {

	public static void main(String[] args) {
		System.out.println("============");
		System.out.println("전공: 사이버보안");
		System.out.println("학번: 1971079");
		System.out.println("성명: 윤가영");
		System.out.println("============");
		
		//스캐너 sc 생성
		Scanner sc = new Scanner(System.in);
		
		//파일 이름을 입력받습니다.
		System.out.println("File name for input:");
		String inFileName = sc.next();
		System.out.println("File name for output:");
		String outFileName = sc.next();
		
		try
		{	//입력파일과 출력파일 스트림 객체를 생성합니다.
			ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(inFileName));
			ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(outFileName));
			
			System.out.println("The numbers in File, " + inFileName);
			
			//입력 파일을 읽고 *2 해서 바로 출력합니다.
			try
			{	while(true) {
					int anInteger = inputStream.readInt();
					System.out.println(anInteger);
					
					outputStream.writeInt(2*anInteger);
				}
			}
			catch(EOFException e) //파일 읽기가 끝났을 때
			{
				System.out.println("End of reading from File, " + inFileName);
				System.out.println(outFileName + " is generated.");
			}
			catch(IOException e)
			{
				System.out.println("IOException.");
				System.exit(0);
			}
			
			inputStream.close();
			outputStream.close();
		}
		
		catch(FileNotFoundException e) //입력 파일 찾을 수 없음
		{
			System.out.println("Cannot found file " + inFileName);
			System.exit(0);
		}
		catch(IOException e) //입력 예외처리
		{
			System.out.println("Problem with input from file " + inFileName);
			System.exit(0);
		}
		catch(Exception e) //예외처리
		{
			System.out.println("Exception.");
			System.exit(0);
		}
		
		System.out.println(); //한줄 띄우고
		
		try
		{
			//새로 입력받을 스트림 객체를 생성합니다.
			ObjectInputStream inStream = new ObjectInputStream(new FileInputStream(outFileName));
			
			System.out.println("The numbers in new File, " + outFileName);
			try
			{	//두배로 저장한 정수들을 콘솔에 출력합니다.
				while(true)
				{
					int anInteger = inStream.readInt();
					System.out.println(anInteger);
				}
			}
			catch(EOFException e) //파일이 끝나면 예외 처리
			{
				inStream.close(); //스트림 닫기
				System.out.println("End of reading from 2nd File, " + outFileName);
					
			}
			
		}
		catch(FileNotFoundException e) //두번째 입력파일 못 찾음
		{
			System.out.println("Cannot fine tile " + outFileName);
		}
		catch(IOException e) //두번째 입력 파일 예외처리
		{
			System.out.println("Problem with input from file " + outFileName);
		}
		catch(Exception e) //예외처리
		{
			System.out.println("Exception.");
		}
		
		sc.close(); //스캐너 닫기
	}

}
