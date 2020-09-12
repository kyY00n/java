import java.util.*;
import java.io.*;

public class HW2_1_윤가영 {

	public static void main(String[] args) {
		System.out.println("============");
		System.out.println("전공: 사이버보안");
		System.out.println("학번: 1971079");
		System.out.println("성명: 윤가영");
		System.out.println("============");
		
		//콘솔 입력을 받을 스캐너 객체를 생성합니다.
		Scanner sc = new Scanner(System.in);
		//파일을 읽어올 스캐터 객체를 생성합니다.
		Scanner inputStream = null;
		//파일을 출력할 PrintWriter 객체를 생성합니다.
		PrintWriter outputStream = null;
		
		StringTokenizer token;
		
		//input 파일 명을 읽어옵니다.
		System.out.println("Input the filename to read.");
		String inFileName = sc.next();
		//output 파일 명을 읽어옵니다.
		System.out.println("Input the filename to write.");
		String outFileName = sc.next();
		
		try
		{
			//스트림을 생성한다.
			inputStream = new Scanner(new File(inFileName));
			outputStream = new PrintWriter(outFileName);
		}
		catch(FileNotFoundException e) { //입력파일 오픈 오류
			System.out.println("Error in opening a file. \n");
			System.exit(0);
		}
		catch(IOException e) { //입출력 예외 처리
			System.out.println("Exception occurs. \n");
			System.exit(0);
		}
		
		while(inputStream.hasNextLine()) //파일에 읽어올 줄이 남아있으면 반복!
		{
			String line = inputStream.nextLine(); //한 줄씩 읽습니다.
			token = new StringTokenizer(line, ", \n"); //읽은 문장을 Token화 합니다.
			
			while(token.hasMoreTokens()) { //다음 토큰이 있다면..
				String tokenS = token.nextToken(); //토큰을 내놔
				if(tokenS.length() > 4) { //그 토큰이 4글자 초과라면
					outputStream.println(tokenS); //토큰을 outFile에 쓰세요.
				}
			}
		}
		System.out.println(outFileName+" is generated.");
		outputStream.close();
		inputStream.close();
		sc.close();
		
	}

}
