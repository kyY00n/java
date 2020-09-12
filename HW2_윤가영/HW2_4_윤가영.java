import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.lang.NumberFormatException;
import java.lang.Exception;

class MyScore extends JFrame
{
	JPanel p1, p2; //p1: �׷����� �׸� �г�, p2: �����Է� textField�� button�� �ø� �г�.
	
	JTextField korTF, engTF, mathTF; //���� kor, eng, math�� ������ �Է��� textField�Դϴ�.
	int kor, eng, math; //������ ������ ����!
	JButton button; //"Show Graph" ��ư
	boolean wrongInput; //�߸��� �Է��� ��� true�� �Ǵ� boolean���Դϴ�.
	
	public MyScore()
	{
		//JFrame ����!
		Toolkit tk = getToolkit();
		Dimension d = tk.getScreenSize();
		int screenHeight = d.height;
		int screenWidth = d.width;
		setSize(500, 450);
		setLocation(screenWidth/2-this.getWidth()/2, screenHeight/2-this.getHeight()/2);
		setTitle("Score Graph");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//�ؿ� inner class�� ������ �׷��� �׸� �г� ��ü�� �����մϴ�.
		p1 = new ScoreGraph();
		
		//���� �Է� �г� ��ü�� �����մϴ�.
		p2 = new JPanel();
		p2.add(new JLabel("Kor"));
		p2.add(korTF = new JTextField(5));
		p2.add(new JLabel("Eng"));
		p2.add(engTF = new JTextField(5));
		p2.add(new JLabel("Math"));
		p2.add(mathTF = new JTextField(5));
		button = new JButton("Show Graph"); //Show Graph��� ��ư�� �����ϰ�
		button.addActionListener(new ScoreListener()); //�� ��ư�� ������ �߻��ϴ� �̺�Ʈ�� ActionListener�� �߰��մϴ�.
		p2.add(button);
		
		
		add(p1, BorderLayout.CENTER);
		add(p2, BorderLayout.PAGE_END);
		
		setVisible(true);
	}
	
	//���� �׷����� �׸� �г��Դϴ�.
	class ScoreGraph extends JPanel
	{
		public static final int x = 100;
		public static final int y = 80;
		public void paint(Graphics g) //�׷����� �׸��� paint�޼���
		{
			/////////////////////////////�׷��� �⺻ Ʋ �׸���///////////////////////////////
			g.drawLine(x, y, x, y+210);
			
			g.drawString("100", x-30, y+10);
			g.drawLine(x, y+10, x+280, y+10);
			
			int j = 20;
			int k = 10;
			
			for(int i = 0; i < 10; i++)
			{
				if(k<100) g.drawString(Integer.toString(100-k), x-30, y+10+j);
				g.drawLine(x, y+10+j, x+280, y+10+j); 
				j += 20; //�׷������� 10�� ������ 20���� �����߽��ϴ�. (���� 1��: 2)
				k += 10;
			}
			
			g.drawString("KOR", x+70, y+230);
			g.drawString("ENG", x+140, y+230);
			g.drawString("MATH", x+210, y+230);
			////////////////////////////////////////////////////////////////////////////
			
			////////////////////////////////////////////////////////////////////////////
			//ó������ ������ 0, 0, 0���� �ʱ�ȭ �Ǿ������Ƿ� else�� ���� ���̰� 0�� �簢���� �׸� ���Դϴ�.
			//���� ����ڰ� �߸��� �Է��� �� ��� wrongInput == true �� �Ǿ� ���� ���ǹ��� ����˴ϴ�.
			if(wrongInput)
			{
				g.drawString("Wrong Input", x+120, y-10);
			}
			//�߸��� �Է��� �ƴ� ��� �� ������ 2*���� ������ �簢���� �׸� ���Դϴ�.
			else
			{
				g.setColor(new Color(255, 0, 0));
			
				g.fillRect(x+70, y+210-2*kor, 10, 2*kor);
				g.fillRect(x+140, y+210-2*eng, 10, 2*eng);
				g.fillRect(x+210, y+210-2*math, 10, 2*math);
			}
						
		}
	}
	
	//��ư�� ������ ���� actionListener Ŭ������ �����մϴ�.
	//���� event ��Ȳ���� repaint�� � ������� ���� �����մϴ�.
	class ScoreListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == button) //��ư�� ������
			{
				wrongInput = false;
				try
				{
					//����ڰ� textField�� �Է��� ���� ���ڿ��� int������ ��ȯ�Ͽ� �� ���� ������ �����մϴ�.
					kor = Integer.parseInt(korTF.getText());
					eng = Integer.parseInt(engTF.getText());
					math = Integer.parseInt(mathTF.getText());
					
					if(kor<0 || kor>100 || eng<0 || eng>100 || math<0 || math>100) //������ 0~100 ���̰� �ƴ� ���
					throw new MyException(); //�߸��� �Է�
				}
				catch(NumberFormatException ne) //���� ����ڰ� ���ڸ� �Է����� ���� ���
				{
					wrongInput= true; //�߸��� �Է�
				}
				catch(MyException me)
				{
					wrongInput = true;
				}
				
				
				//repaint ShowGraph
				repaint();
			}
		
		}
	
	}
	
	class MyException extends Exception
	{
		public MyException() {}		
	}
}


public class HW2_4_������ {

	public static void main(String[] args) {
		/*
		 ����: ���̹�����
		 �й�: 1971079
		 �̸�: ������		 
		*/
		
		MyScore ms = new MyScore();
	}

}

