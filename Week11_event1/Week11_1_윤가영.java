import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class MyFrame extends JFrame {
	
	//MyFrame ������
	public MyFrame() {
		//����
		setTitle("Calculator");
		//close operation
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//size
		setSize(300, 200);
		
		//PAGE_START�� CENTER�� ���� panel 2���� �����մϴ�.
		JPanel panel1, panel2;
		
		//panel1: PAGE_START, textField�� �����ϴ� panel
		panel1 = new JPanel();
		JTextField t = new JTextField(20);
		t.setHorizontalAlignment(JTextField.RIGHT);
		panel1.add(t);
		
		//panel2: CENTER, ���� ����/��ȣ Button�� �����ϴ� panel
		panel2 = new JPanel();
		panel2.setLayout(new GridLayout(0, 4)); //GridLayout���� �ٲ��ݴϴ�.
		
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
		
		//Frame�� panel 1�� 2�� �����ݴϴ�.
		add(panel1, BorderLayout.PAGE_START);
		add(panel2, BorderLayout.CENTER);
		
		pack();
		setVisible(true);
		
	}
	
	//panel�� button�� �߰��ϴ� �޼����Դϴ�.
	public void makeButton(String text, JPanel panel) {
		panel.add(new Button(text));
	}
}
public class Week11_1_������ {

	public static void main(String[] args) {
		System.out.println("============");
		System.out.println("����: ���̹�����");
		System.out.println("�й�: 1971079");
		System.out.println("����: ������");
		System.out.println("============");
		
		MyFrame calculator = new MyFrame();
	}

}
