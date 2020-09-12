import java.util.Scanner;

//SimulThread�� PrintThread�� ���� ����
class SharedArea
{
	double ratio;
	boolean isReady;
}

//SimulThread ����
class SimulThread extends Thread
{
	SharedArea sharedArea;
	
	//count: �ո��� ���� Ƚ��, N: ���� ������ Ƚ��
	int count, N;
	
	//result: ������ ���� �� (�ո�: 1, �޸�: 0)
	long result;
	
	//SimulThread ������
	public SimulThread(int N)
	{
		this.N = N;
	}
	
	//�����尡 �����Ǹ� ����� �޼���
	public void run()
	{
		for(int i = 0; i < N; i++)
		{
			result = Math.round(Math.random());
			if(result == 1) //�ո��� ������
			{
				count++;
			}
				
		}
		
		//N�� �� �ո��� ���� Ȯ���� ������� ����
		sharedArea.ratio = ((double) count/N) * 100;
		
		//print �غ� �Ϸ�
		sharedArea.isReady = true;
		
		synchronized(sharedArea) //����ȭ���ּ���
		{
			//wait�ϴ� �����忡�� �˷��ּ���
			sharedArea.notify();
		}
	}
}

//PrintThread ����
class PrintThread extends Thread
{
	SharedArea sharedArea;
	
	//�����尡 �����Ǹ� ����� �޼���
	public void run()
	{
		if(!sharedArea.isReady) //Print �غ� ���� �ʾҴٸ�..
		{
			try
			{
				synchronized(sharedArea)
				{
					//�� ������� ��ٷ����մϴ�.
					sharedArea.wait();
				}
			}
			catch (InterruptedException e)
			{
				System.out.println(e.getMessage());
			}
		}//notify() ����, wait() Ǯ��
		
		System.out.printf("Front Ratio: %.2f", sharedArea.ratio); //���������� ����� ratio ���
		System.out.println("%");
	}
}
public class Week13_1_������ {

	public static void main(String[] args) {
		System.out.println("============");
		System.out.println("����: ���̹�����");
		System.out.println("�й�: 1971079");
		System.out.println("����: ������");
		System.out.println("============");
		
		//����� �Է� ���� ��ĳ�� ��ü ����
		Scanner sc = new Scanner(System.in);
		
		//���� ������ Ƚ�� �Է¹ޱ�
		System.out.println("Input the number of coin toss:");
		int N = sc.nextInt();
		
		//������ ��ü ����
		SimulThread s = new SimulThread(N);
		PrintThread p = new PrintThread();
		
		//���� ���� SharedArea ��ü ����
		SharedArea sa = new SharedArea();
		
		//������ �������� ��������� sa�� ����
		s.sharedArea = sa;
		p.sharedArea = sa;
		
		//������ ����(����)
		s.start();
		p.start();
	
		sc.close(); 
	}

}
