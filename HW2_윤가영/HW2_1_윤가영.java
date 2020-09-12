import java.util.*;
import java.io.*;

public class HW2_1_������ {

	public static void main(String[] args) {
		System.out.println("============");
		System.out.println("����: ���̹�����");
		System.out.println("�й�: 1971079");
		System.out.println("����: ������");
		System.out.println("============");
		
		//�ܼ� �Է��� ���� ��ĳ�� ��ü�� �����մϴ�.
		Scanner sc = new Scanner(System.in);
		//������ �о�� ��ĳ�� ��ü�� �����մϴ�.
		Scanner inputStream = null;
		//������ ����� PrintWriter ��ü�� �����մϴ�.
		PrintWriter outputStream = null;
		
		StringTokenizer token;
		
		//input ���� ���� �о�ɴϴ�.
		System.out.println("Input the filename to read.");
		String inFileName = sc.next();
		//output ���� ���� �о�ɴϴ�.
		System.out.println("Input the filename to write.");
		String outFileName = sc.next();
		
		try
		{
			//��Ʈ���� �����Ѵ�.
			inputStream = new Scanner(new File(inFileName));
			outputStream = new PrintWriter(outFileName);
		}
		catch(FileNotFoundException e) { //�Է����� ���� ����
			System.out.println("Error in opening a file. \n");
			System.exit(0);
		}
		catch(IOException e) { //����� ���� ó��
			System.out.println("Exception occurs. \n");
			System.exit(0);
		}
		
		while(inputStream.hasNextLine()) //���Ͽ� �о�� ���� ���������� �ݺ�!
		{
			String line = inputStream.nextLine(); //�� �پ� �н��ϴ�.
			token = new StringTokenizer(line, ", \n"); //���� ������ Tokenȭ �մϴ�.
			
			while(token.hasMoreTokens()) { //���� ��ū�� �ִٸ�..
				String tokenS = token.nextToken(); //��ū�� ����
				if(tokenS.length() > 4) { //�� ��ū�� 4���� �ʰ����
					outputStream.println(tokenS); //��ū�� outFile�� ������.
				}
			}
		}
		System.out.println(outFileName+" is generated.");
		outputStream.close();
		inputStream.close();
		sc.close();
		
	}

}
