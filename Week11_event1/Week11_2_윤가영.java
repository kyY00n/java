import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class studentFrame extends JFrame{
	
	//studentFrame 생성자
	public studentFrame() {
		
		//제목
		setTitle("Student Information");
		//close operation
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//size
		setSize(350, 200);
		
		//Panel 4개 선언 1, 2, 4를 frame에 추가할거고, 3은 pn2에 들어갈 radio button group을 한 번에 넣기 위한 Panel입니다.
		JPanel pn1, pn2, pn3, pn4;
		
		//pn1
		pn1 = new JPanel();
		pn1.add(new JLabel("STUDENT INFORMATION"));
		
		//pn2
		pn2 = new JPanel();
		pn2.setLayout(new GridLayout(0,2));
		
		JLabel name = new JLabel("NAME");
		JLabel gender = new JLabel("GENDER");
		JLabel id = new JLabel("ID");
		JLabel department = new JLabel("DEPARTMENT");
		
		JTextField nameField = new JTextField();
		JTextField idField = new JTextField();
		JTextField departmentField = new JTextField();
		
		//pn3 - pn2의 한 sector에 들어갈 panel입니다.
		pn3 = new JPanel();
		
		JRadioButton male = new JRadioButton("Male");
		JRadioButton female = new JRadioButton("Female", true);
		ButtonGroup genderBG = new ButtonGroup();
		genderBG.add(male);
		genderBG.add(female);
		
		pn3.add(male);
		pn3.add(female);
		
		//pn2에 component를 추가합니다^_^
		pn2.add(name);
		pn2.add(nameField);
		pn2.add(gender);
		pn2.add(pn3);
		pn2.add(id);
		pn2.add(idField);
		pn2.add(department);
		pn2.add(departmentField);
		
		//pn4
		pn4 = new JPanel();
		
		pn4.add(new Button("Save"));
		pn4.add(new Button("Cancel"));
		
		//Frame의 위, 가운데, 아래 sector에 만들어둔 panel들을 추가합니다.
		add(pn1, BorderLayout.PAGE_START);
		add(pn2, BorderLayout.CENTER);
		add(pn4, BorderLayout.PAGE_END);
		
		pack();
		setVisible(true);
	}
}
public class Week11_2_윤가영 {

	public static void main(String[] args) {
		System.out.println("============");
		System.out.println("전공: 사이버보안");
		System.out.println("학번: 1971079");
		System.out.println("성명: 윤가영");
		System.out.println("============");
		
		studentFrame st = new studentFrame();

	}

}
