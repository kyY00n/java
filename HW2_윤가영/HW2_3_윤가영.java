import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class MyCalc extends JFrame
{
	boolean isFirstNum; //첫번째 숫자인지 구분하기 위한 boolean값입니다.
	int num1, num2; //연산자 앞에오는 숫자를 num1, 뒤에오는 수를 num2라고 합니다.
	String operator; //연산자
	JTextField t; //연산 결과를 보여주는 textField입니다.
	JPanel p1, p2; //p1: textField를 올릴 패널, p2: 버튼들을 올릴 패널.
	
	//MyCalc 생성자
	public MyCalc()
	{
		//제목
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
	
	//숫자 버튼 생성 메서드
	public void makeNumButton(String text, JPanel panel) 
	{
		JButton button = new JButton(text);
		button.addActionListener(new NumListener());
		panel.add(button);
	}
	
	//연산자 버튼 생성 메서드
	public void makeOprButton(String text, JPanel panel)
	{
		JButton button = new JButton(text);
		button.addActionListener(new OprListener());
		panel.add(button);
	}
	
	//숫자 버튼 이벤트 처리: inner 클래스
	private class NumListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			//사용자가 누른 버튼의 숫자를 int로 형변환해 input에 대입합니다.
			int input = Integer.parseInt(e.getActionCommand());
			
			if(isFirstNum) //식의 첫번째 숫자이면
			{
				num1 = input;
				isFirstNum = false;
			}
				else num2 = input;
		}
		
	}
	
	//연산자 버튼 이벤트 처리: inner 클래스
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
	
	//New 버튼 이벤트 처리: inner 클래스
	private class NewListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			num1 = 0;
			isFirstNum = true;
		}
	}
	
	//"=" 버튼 이벤트 처리: inner 클래스
	private class CalcListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{			
			if(operator.equals("+")) t.setText(Integer.toString(num1+num2));
			else if(operator.equals("-")) t.setText(Integer.toString(num1-num2));
			else if(operator.equals("*")) t.setText(Integer.toString(num1*num2));
			else
			{
				if(num2 == 0) //0으로 나누었을 때,, 이거 안해도 Infinity로 나오긴 합니다
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

public class HW2_3_윤가영 {

	public static void main(String[] args) {
		System.out.println("============");
		System.out.println("전공: 사이버보안");
		System.out.println("학번: 1971079");
		System.out.println("성명: 윤가영");
		System.out.println("============");
		
		MyCalc calc = new MyCalc();
	}

}
