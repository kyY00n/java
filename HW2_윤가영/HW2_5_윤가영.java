import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class NameFrame extends JFrame
{
	JPanel p1, p2; // p1: Pie Chart를 그릴 패널, p2: textField들과 button을 올릴 패널
	int kim, lee, park, etc; //각 성의 학생 수를 저장할 변수
	JTextField kimTF, leeTF, parkTF, etcTF; //학생 수를 입력 받는 textField
	JButton button; //"Graph"버튼
	
	//wrongInput은 숫자가 아닌 문자를 입력했을 때 true로 바꿔줄 변수.
	//wrongNumberInput은 합이 100이 넘는 입력일 때 true로 바꿉니다.
	//isInputBeing은 사용자가 프로그램 실행 후 최초로 입력한 후 항상 true값을 유지합니다.
	boolean wrongInput, wrongNumberInput, isInputBeing;
	
	//프레임 class를 정의합니다.
	public NameFrame()
	{
		setTitle("Pie Chart of Student names - 윤가영");
		setSize(500, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//파이차트를 그릴 패널 객체를 생성합니다.
		p1 = new PieChart();
		//textField와 button을 올릴 패널 객체를 생성합니다.
		p2 = new JPanel();
		
		//p2에 올릴 TextField들과 button을 생성합니다.
		kimTF = new JTextField(6);
		leeTF = new JTextField(6);
		parkTF = new JTextField(6);
		etcTF = new JTextField(6);
		button = new JButton("Graph");
		//생성한 객체들을 p2에 올립니다.
		p2.add(new JLabel("Kim"));
		p2.add(kimTF);
		p2.add(new JLabel("Lee"));
		p2.add(leeTF);
		p2.add(new JLabel("Park"));
		p2.add(parkTF);
		p2.add(new JLabel("Etc"));
		p2.add(etcTF);
		button.addActionListener(new NameListener()); //button에 제가 정의한 ActionLister 구현 객체를 추가합니다.
		p2.add(button);		
		
		add(p1, BorderLayout.CENTER);
		add(p2, BorderLayout.SOUTH);
		
		setVisible(true);
	}
	
	//PieChart를 그릴 패널 클래스 정의입니다. (p1에 이 클래스 객체를 대입합니다.)
	class PieChart extends JPanel
	{
		public void paint(Graphics g)
		{
			final int x = 120, y = 90, width = 150, height = 150;
			Color c = new Color(0, 0, 0);
			
			if(wrongInput) //만약 입력값이 숫자가 아닐 경우
			{
				g.drawString("Input numbers of student names", 150 ,280);
				kimTF.setText("0");
				leeTF.setText("0");
				parkTF.setText("0");
				etcTF.setText("0");
			}
			else if(wrongNumberInput) //만약 입력한 학생 수가 100명을 넘을 경우
			{
				g.drawString("Number of students is 100.", 150, 280);
				kimTF.setText("0");
				leeTF.setText("0");
				parkTF.setText("0");
				etcTF.setText("0");
			}
			else
			{
				if(isInputBeing) //실행 후에 한번이라도 사용자가 입력을 했다면
				{
					kimTF.setText(Integer.toString(kim));
					leeTF.setText(Integer.toString(lee));
					parkTF.setText(Integer.toString(park));
					etcTF.setText(Integer.toString(etc));
				}
				
				g.setColor(c.YELLOW);
				g.fillArc(x, y, width, height, 0, 360*kim/100);
				g.drawString("YELLOW: KIMs", 350, 150);
				g.setColor(c.RED);
				g.fillArc(x, y, width, height, 360*kim/100, 360*lee/100);
				g.drawString("RED: LEEs", 350, 170);
				g.setColor(c.BLUE);
				g.fillArc(x, y, width, height, 360*(kim+lee)/100, 360*park/100);
				g.drawString("BLUE: PARKs", 350, 190);
				g.setColor(c.GREEN);
				g.fillArc(x, y, width, height, 360*(kim+lee+park)/100, 360*etc/100);
				g.drawString("GREEN: Etc.", 350, 210);
			}
			
		}
	}
	
	class NameListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			if(e.getSource() == button) //사용자가 버튼을 클릭하면
			{
				isInputBeing = true; //최초로 버튼을 눌렀을때만 의미가 있는 코드입니다.
				//프로그램 실행 후, 사용자가 숫자를 입력하고
				//버튼을 누르면 그 때부터 TextField는 항상 비어있지 않게 하기 위해 추가했습니다.
				
				try
				{
					//입력받은 학생 수 문자열을 int형으로 변환합니다.
					//만약 숫자가 아닌 다른 문자를 입력하면 여기서 NumberFormatException 예외가 발생합니다.
					kim = Integer.parseInt(kimTF.getText());
					lee = Integer.parseInt(leeTF.getText());
					park = Integer.parseInt(parkTF.getText());
					
					//입력받은 숫자들의 합이 100을 넘을 경우 제가 정의한 SumException 객체를 생성하여 예외처리합니다.
					if((kim+lee+park) > 100) throw new SumException();
					
					//어떠한 예외도 발생하지 않았을 경우 etc를 계산해줍니다.
					etc = 100 - (kim+lee+park);
				}
				catch(NumberFormatException ne)
				{
					wrongInput = true; //잘못된 입력
				}
				catch(SumException se)
				{
					wrongNumberInput = true; //잘못된 숫자입력
				}
				
				repaint(); //다시 그리기
			}
		}
	}
	
	class SumException extends Exception 
	{
		public SumException() {} //아무것도 없습니다. 그냥 객체만 생성합니다.
	}
}
public class HW2_5_윤가영 {

	public static void main(String[] args) {
		/*
		 전공: 사이버보안
		 학번: 1971079
		 이름: 윤가영		 
		*/
		
		NameFrame nf = new NameFrame(); //프레임 실행

	}

}
