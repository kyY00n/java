import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class MyCalc extends JFrame
{
	boolean isFirstNum; //ù��° �������� �����ϱ� ���� boolean���Դϴ�.
	int num1, num2; //������ �տ����� ���ڸ� num1, �ڿ����� ���� num2��� �մϴ�.
	String operator; //������
	JTextField t; //���� ����� �����ִ� textField�Դϴ�.
	JPanel p1, p2; //p1: textField�� �ø� �г�, p2: ��ư���� �ø� �г�.
	
	//MyCalc ������
	public MyCalc()
	{
		//����
		setTitle("Calculator");
		//close operation
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//size
		setSize(300, 200);
		
		p1 = new JPanel();
		p2 = new JPanel();
		
		t = new JTextField(25);
		t.setHorizontalAlignment(JTextField.RIGHT);
		p1.add(t);
		
		GridLayout layout = new GridLayout(0, 4);
		p2.setLayout(layout);
		
		makeNumButton("7", p2);
		makeNumButton("8", p2);
		makeNumButton("9", p2);
		makeOprButton("/", p2);
		
		makeNumButton("4", p2);
		makeNumButton("5", p2);
		makeNumButton("6", p2);
		makeOprButton("*", p2);
		
		makeNumButton("1", p2);
		makeNumButton("2", p2);
		makeNumButton("3", p2);
		makeOprButton("-", p2);
		
		JButton newB = new JButton("New");
		newB.addActionListener(new NewListener());
		p2.add(newB);
		
		makeNumButton("0", p2);
		
		JButton calcB = new JButton("=");
		calcB.addActionListener(new CalcListener());
		p2.add(calcB);
		
		makeOprButton("+", p2);
		
		add(p1, BorderLayout.PAGE_START);
		add(p2, BorderLayout.CENTER);
		
		setVisible(true);
	}
	
	//���� ��ư ���� �޼���
	public void makeNumButton(String text, JPanel panel) 
	{
		JButton button = new JButton(text);
		button.addActionListener(new NumListener());
		panel.add(button);
	}
	
	//������ ��ư ���� �޼���
	public void makeOprButton(String text, JPanel panel)
	{
		JButton button = new JButton(text);
		button.addActionListener(new OprListener());
		panel.add(button);
	}
	
	//���� ��ư �̺�Ʈ ó��: inner Ŭ����
	private class NumListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			//����ڰ� ���� ��ư�� ���ڸ� int�� ����ȯ�� input�� �����մϴ�.
			int input = Integer.parseInt(e.getActionCommand());
			
			if(isFirstNum) //���� ù��° �����̸�
			{
				num1 = input;
				isFirstNum = false;
			}
				else num2 = input;
		}
		
	}
	
	//������ ��ư �̺�Ʈ ó��: inner Ŭ����
	private class OprListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			String opr = e.getActionCommand();
			if(opr.equals("+")) operator = "+";
			else if(opr.equals("-")) operator = "-";
			else if(opr.equals("*")) operator = "*";
			else if(opr.equals("/")) operator = "/";
		}
	}
	
	//New ��ư �̺�Ʈ ó��: inner Ŭ����
	private class NewListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			num1 = 0;
			isFirstNum = true;
		}
	}
	
	//"=" ��ư �̺�Ʈ ó��: inner Ŭ����
	private class CalcListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{			
			if(operator.equals("+")) t.setText(Integer.toString(num1+num2));
			else if(operator.equals("-")) t.setText(Integer.toString(num1-num2));
			else if(operator.equals("*")) t.setText(Integer.toString(num1*num2));
			else
			{
				if(num2 == 0) //0���� �������� ��,, �̰� ���ص� Infinity�� ������ �մϴ�
				{
					t.setText("Cannot devided by 0.");
					isFirstNum = true;
				}
				else t.setText(Double.toString((double)num1/num2));
			}
			p1.add(t);
			add(p1, BorderLayout.PAGE_START);
		}
	}
}

public class HW2_3_������ {

	public static void main(String[] args) {
		System.out.println("============");
		System.out.println("����: ���̹�����");
		System.out.println("�й�: 1971079");
		System.out.println("����: ������");
		System.out.println("============");
		
		MyCalc calc = new MyCalc();
	}

}
