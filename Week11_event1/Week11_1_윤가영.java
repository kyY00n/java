import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class MyFrame extends JFrame {
	
	//MyFrame 생성자
	public MyFrame() {
		//제목
		setTitle("Calculator");
		//close operation
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//size
		setSize(300, 200);
		
		//PAGE_START와 CENTER에 놓을 panel 2개를 선언합니다.
		JPanel panel1, panel2;
		
		//panel1: PAGE_START, textField를 포함하는 panel
		panel1 = new JPanel();
		JTextField t = new JTextField(20);
		t.setHorizontalAlignment(JTextField.RIGHT);
		panel1.add(t);
		
		//panel2: CENTER, 계산기 숫자/기호 Button을 포함하는 panel
		panel2 = new JPanel();
		panel2.setLayout(new GridLayout(0, 4)); //GridLayout으로 바꿔줍니다.
		
		makeButton("ON", panel2);
		makeButton("AC", panel2); 
		makeButton("C", panel2);
		makeButton("OFF", panel2);
		makeButton("7", panel2);
		makeButton("8", panel2);
		makeButton("9", panel2);
		makeButton("/", panel2);
		makeButton("4", panel2);
		makeButton("5", panel2);
		makeButton("6", panel2);
		makeButton("X", panel2);
		makeButton("1", panel2);
		makeButton("2", panel2);
		makeButton("3", panel2);
		makeButton("-", panel2);
		makeButton("0", panel2);
		makeButton(".", panel2);
		makeButton("=", panel2);
		makeButton("+", panel2);
		
		//Frame에 panel 1과 2를 놓아줍니다.
		add(panel1, BorderLayout.PAGE_START);
		add(panel2, BorderLayout.CENTER);
		
		pack();
		setVisible(true);
		
	}
	
	//panel에 button을 추가하는 메서드입니다.
	public void makeButton(String text, JPanel panel) {
		panel.add(new Button(text));
	}
}
public class Week11_1_윤가영 {

	public static void main(String[] args) {
		System.out.println("============");
		System.out.println("전공: 사이버보안");
		System.out.println("학번: 1971079");
		System.out.println("성명: 윤가영");
		System.out.println("============");
		
		MyFrame calculator = new MyFrame();
	}

}
