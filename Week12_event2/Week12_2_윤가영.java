import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

//새로운 프레임 클래스 CarFrame을 정의합니다.
class CarFrame extends JFrame implements ActionListener{
	
	//RadioButton들을 add할 Panel p를 선언합니다.
	JPanel p = new JPanel();
	
	//Color 객체 c를 정의합니다. 초기값은 RED입니다.
	Color c = new Color(255,0,0);

	//자동차의 색깔을 나타내는 RadioButtonGroup을 선언합니다.
	ButtonGroup carColors = new ButtonGroup();
	//버튼들입니다. 기본값은 RED.
	JRadioButton red = new JRadioButton("RED", true);
	JRadioButton green = new JRadioButton("GREEN");
	JRadioButton blue = new JRadioButton("BLUE");
	
	//라디오버튼 선택 후 누를 버튼입니다.
	JButton paintButton = new JButton("Paint");
	
	//자동차를 그릴 Panel을 정의합니다.
	class MyCar extends JPanel{
		
		//여러 도형을 그릴 때 사용하기 위한 상수입니다.
		public static final int x = 150, y = 50;
		
		//작은 직사각형 -> 큰 직사각형 -> 왼 바퀴 -> 오른 바퀴 -> 호 의 순으로 그림을 그립니다.
		public void paint(Graphics g) {
			g.setColor(c);
			g.fillRect(x, y, 140, 60);
			g.fillRect(x - 70, y + 60, 280, 100);
			g.setColor(c.LIGHT_GRAY);
			g.fillOval(x - 40, y + 120, 80, 80);
			g.fillOval(x + 100, y + 120, 80, 80);
			g.setColor(c.BLACK);
			g.drawArc(x + 80, y + 10, 50, 40, 0, 180);
			
		}
	}
	
	//CarFrame의 생성자입니다.
	public CarFrame(){
		//창을 스크린 가운데에 놓기 위해 Toolkit을 선언해주어요
		Toolkit tk = getToolkit();
		Dimension d = tk.getScreenSize();
		
		//지금 내 pc의 스크린 가로, 세로 길이를 저장합니다.
		int scHeight = d.height;
		int scWidth = d.width;
		
		//그래픽 창의 title, size, close operation, location, layout을 설정합니다.
		setTitle("MyCar - 윤가영");
		setSize(500, 350);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocation(scWidth/2 - this.getWidth()/2, scHeight/2 - this.getHeight()/2);
		setLayout(new BorderLayout());
		
		//자동차 그림 Panel 객체를 생성합니다.
		MyCar cb = new MyCar();

		//Radio Button들을 Radio Button Group에 추가합니다.
		carColors.add(red);
		carColors.add(green);
		carColors.add(blue);
		
		add(cb, BorderLayout.CENTER);
		
		//Panel p에 radio button들을 추가합니다.
		p.add(red);
		p.add(green);
		p.add(blue);
		
		//Panel p에 paintButton도 추가합니다.
		paintButton.addActionListener(this);
		p.add(paintButton);
		
		add(p, BorderLayout.PAGE_END);
		
		setVisible(true);
	}
	
	//PaintButton을 누르면 호출되는 actionPerformed 메서드 입니다.
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == paintButton) //user가 버튼을 누르면
		{	
			//선택한 색으로 Color 객체 c의 색을 변경합니다.
			if(red.isSelected())
				c = Color.RED;
			else if(blue.isSelected())
				c = Color.BLUE;
			else if(green.isSelected())
				c = Color.GREEN;
		}
		//다시 그립니다.
		repaint();
	}
	
}
public class Week12_2_윤가영 {

	public static void main(String[] args) {
		System.out.println("============");
		System.out.println("전공: 사이버보안");
		System.out.println("학번: 1971079");
		System.out.println("성명: 윤가영");
		System.out.println("============");
		
		//새로운 CarFrame을 실행합니다.
		CarFrame cf = new CarFrame();

	}

}
