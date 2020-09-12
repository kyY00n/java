import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.io.EOFException;
import java.io.IOException;
import java.util.Scanner;

public class Week9_1_������ {

	public static void main(String[] args) {
		System.out.println("============");
		System.out.println("����: ���̹�����");
		System.out.println("�й�: 1971079");
		System.out.println("����: ������");
		System.out.println("============");
		
		//��ĳ�� sc ����
		Scanner sc = new Scanner(System.in);
		
		//���� �̸��� �Է¹޽��ϴ�.
		System.out.println("File name for input:");
		String inFileName = sc.next();
		System.out.println("File name for output:");
		String outFileName = sc.next();
		
		try
		{	//�Է����ϰ� ������� ��Ʈ�� ��ü�� �����մϴ�.
			ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(inFileName));
			ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(outFileName));
			
			System.out.println("The numbers in File, " + inFileName);
			
			//�Է� ������ �а� *2 �ؼ� �ٷ� ����մϴ�.
			try
			{	while(true) {
					int anInteger = inputStream.readInt();
					System.out.println(anInteger);
					
					outputStream.writeInt(2*anInteger);
				}
			}
			catch(EOFException e) //���� �бⰡ ������ ��
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
		
		catch(FileNotFoundException e) //�Է� ���� ã�� �� ����
		{
			System.out.println("Cannot found file " + inFileName);
			System.exit(0);
		}
		catch(IOException e) //�Է� ����ó��
		{
			System.out.println("Problem with input from file " + inFileName);
			System.exit(0);
		}
		catch(Exception e) //����ó��
		{
			System.out.println("Exception.");
			System.exit(0);
		}
		
		System.out.println(); //���� ����
		
		try
		{
			//���� �Է¹��� ��Ʈ�� ��ü�� �����մϴ�.
			ObjectInputStream inStream = new ObjectInputStream(new FileInputStream(outFileName));
			
			System.out.println("The numbers in new File, " + outFileName);
			try
			{	//�ι�� ������ �������� �ֿܼ� ����մϴ�.
				while(true)
				{
					int anInteger = inStream.readInt();
					System.out.println(anInteger);
				}
			}
			catch(EOFException e) //������ ������ ���� ó��
			{
				inStream.close(); //��Ʈ�� �ݱ�
				System.out.println("End of reading from 2nd File, " + outFileName);
					
			}
			
		}
		catch(FileNotFoundException e) //�ι�° �Է����� �� ã��
		{
			System.out.println("Cannot fine tile " + outFileName);
		}
		catch(IOException e) //�ι�° �Է� ���� ����ó��
		{
			System.out.println("Problem with input from file " + outFileName);
		}
		catch(Exception e) //����ó��
		{
			System.out.println("Exception.");
		}
		
		sc.close(); //��ĳ�� �ݱ�
	}

}
