import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.lang.NumberFormatException;
import java.lang.Exception;

class MyScore extends JFrame
{
	JPanel p1, p2; //p1: 그래프를 그릴 패널, p2: 점수입력 textField와 button을 올릴 패널.
	
	JTextField korTF, engTF, mathTF; //각각 kor, eng, math의 점수를 입력할 textField입니다.
	int kor, eng, math; //점수를 저장할 변수!
	JButton button; //"Show Graph" 버튼
	boolean wrongInput; //잘못된 입력일 경우 true가 되는 boolean값입니다.
	
	public MyScore()
	{
		//JFrame 정의!
		Toolkit tk = getToolkit();
		Dimension d = tk.getScreenSize();
		int screenHeight = d.height;
		int screenWidth = d.width;
		setSize(500, 450);
		setLocation(screenWidth/2-this.getWidth()/2, screenHeight/2-this.getHeight()/2);
		setTitle("Score Graph");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//밑에 inner class로 정의한 그래프 그릴 패널 객체를 생성합니다.
		p1 = new ScoreGraph();
		
		//점수 입력 패널 객체를 생성합니다.
		p2 = new JPanel();
		p2.add(new JLabel("Kor"));
		p2.add(korTF = new JTextField(5));
		p2.add(new JLabel("Eng"));
		p2.add(engTF = new JTextField(5));
		p2.add(new JLabel("Math"));
		p2.add(mathTF = new JTextField(5));
		button = new JButton("Show Graph"); //Show Graph라는 버튼을 생성하고
		button.addActionListener(new ScoreListener()); //이 버튼을 누르면 발생하는 이벤트의 ActionListener를 추가합니다.
		p2.add(button);
		
		
		add(p1, BorderLayout.CENTER);
		add(p2, BorderLayout.PAGE_END);
		
		setVisible(true);
	}
	
	//과목 그래프를 그릴 패널입니다.
	class ScoreGraph extends JPanel
	{
		public static final int x = 100;
		public static final int y = 80;
		public void paint(Graphics g) //그래프를 그리는 paint메서드
		{
			/////////////////////////////그래프 기본 틀 그리기///////////////////////////////
			g.drawLine(x, y, x, y+210);
			
			g.drawString("100", x-30, y+10);
			g.drawLine(x, y+10, x+280, y+10);
			
			int j = 20;
			int k = 10;
			
			for(int i = 0; i < 10; i++)
			{
				if(k<100) g.drawString(Integer.toString(100-k), x-30, y+10+j);
				g.drawLine(x, y+10+j, x+280, y+10+j); 
				j += 20; //그래프에서 10을 사이즈 20으로 설정했습니다. (점수 1점: 2)
				k += 10;
			}
			
			g.drawString("KOR", x+70, y+230);
			g.drawString("ENG", x+140, y+230);
			g.drawString("MATH", x+210, y+230);
			////////////////////////////////////////////////////////////////////////////
			
			////////////////////////////////////////////////////////////////////////////
			//처음에는 점수가 0, 0, 0으로 초기화 되어있으므로 else로 가서 높이가 0인 사각형을 그릴 것입니다.
			//만약 사용자가 잘못된 입력을 할 경우 wrongInput == true 가 되어 다음 조건문이 실행됩니다.
			if(wrongInput)
			{
				g.drawString("Wrong Input", x+120, y-10);
			}
			//잘못된 입력이 아닐 경우 각 과목이 2*점수 높이의 사각형을 그릴 것입니다.
			else
			{
				g.setColor(new Color(255, 0, 0));
			
				g.fillRect(x+70, y+210-2*kor, 10, 2*kor);
				g.fillRect(x+140, y+210-2*eng, 10, 2*eng);
				g.fillRect(x+210, y+210-2*math, 10, 2*math);
			}
						
		}
	}
	
	//버튼을 눌렀을 때의 actionListener 클래스를 정의합니다.
	//여러 event 상황에서 repaint가 어떤 방식으로 될지 정의합니다.
	class ScoreListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == button) //버튼을 누르면
			{
				wrongInput = false;
				try
				{
					//사용자가 textField에 입력한 정수 문자열을 int형으로 변환하여 각 점수 변수에 저장합니다.
					kor = Integer.parseInt(korTF.getText());
					eng = Integer.parseInt(engTF.getText());
					math = Integer.parseInt(mathTF.getText());
					
					if(kor<0 || kor>100 || eng<0 || eng>100 || math<0 || math>100) //점수가 0~100 사이가 아닌 경우
					throw new MyException(); //잘못된 입력
				}
				catch(NumberFormatException ne) //만약 사용자가 숫자를 입력하지 않은 경우
				{
					wrongInput= true; //잘못된 입력
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


public class HW2_4_윤가영 {

	public static void main(String[] args) {
		/*
		 전공: 사이버보안
		 학번: 1971079
		 이름: 윤가영		 
		*/
		
		MyScore ms = new MyScore();
	}

}

