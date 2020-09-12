import javax.swing.JOptionPane;

class SharedArea2 //�������� ����
{
	String randomWord; //MyGame�����尡 ���� ������ �ܾ ����˴ϴ�.
}

//���� �ܾ ����ִ� ������ Ŭ���� ����
class MyGame extends Thread
{
	SharedArea2 sharedArea;
	int randNum; //0~14 ������ �����ѹ�
	boolean stop; //run()�� ���ߴ� ����
	
	//��Ʈ�� �迭 �ʱ�ȭ
	String[] myWords = new String[]{"dog", "cat", "water", "fruit", "milk", "hot", "air",
			"cool", "cold", "off", "good", "tired", "sleep", "wake", "eat"};
	
	public void run()
	{	

		for(int i = 20; i > 0; i--) //20�� �ݺ�
		{
			if(stop == true) break;
			
			randNum = (int) (Math.random() * 15);
			
			//sharedArea�� ���� �ܾ� = ��� ���� ���� �ܾ�
			sharedArea.randomWord = myWords[randNum];
			System.out.println(sharedArea.randomWord);
			
			try
			{
				sleep(1000); //1�� ����
			}
			catch(InterruptedException e)
			{
				System.out.println(e.getMessage());
			}
			
		}
		// �����ϸ� stop�� false�̹Ƿ�
		if(!stop)
		{
			System.out.println("����");
			System.exit(0);
		}
						
		else //stop�� true�� ��
		{
			System.out.println("����!");
			System.out.println("Timer is stopped.");
		}
	}
	
	public void setStop(boolean stop)
	{
		this.stop = stop;
	}
}


public class Week13_2_������ {

	public static void main(String[] args) {
		System.out.println("============");
		System.out.println("����: ���̹�����");
		System.out.println("�й�: 1971079");
		System.out.println("����: ������");
		System.out.println("============");
		
		//�����ϰ� �ܾ �� �������Դϴ�.
		MyGame g = new MyGame();
		
		//���ν������ MyGame�������� ���������Դϴ�.
		SharedArea2 sa = new SharedArea2();
		g.sharedArea = sa;
	
		g.start();
		
		String st; //������� �Է��� ������ String �����Դϴ�.

		while(true)
		{	
			st = JOptionPane.showInputDialog("���ڿ� �Է�");
			
			//����ڰ� x(exit)�� ������ ��
			if(st == null) break;
			
			System.out.println("<"+st+">�� �Է��ϼ̽��ϴ�.");
			
			//ȭ�鿡 ���� �ܾ�(randomWord)�� ����� �Է� �ܾ ��ġ�� ��
			if(st.equals(sa.randomWord))
			{
				g.setStop(true); //MyGame ������ ���߱�
				break; //while Ż��
			}
		}
		
		//���ν����� ����
		System.exit(0);
	}
		
}

