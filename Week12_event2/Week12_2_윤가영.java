import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

//���ο� ������ Ŭ���� CarFrame�� �����մϴ�.
class CarFrame extends JFrame implements ActionListener{
	
	//RadioButton���� add�� Panel p�� �����մϴ�.
	JPanel p = new JPanel();
	
	//Color ��ü c�� �����մϴ�. �ʱⰪ�� RED�Դϴ�.
	Color c = new Color(255,0,0);

	//�ڵ����� ������ ��Ÿ���� RadioButtonGroup�� �����մϴ�.
	ButtonGroup carColors = new ButtonGroup();
	//��ư���Դϴ�. �⺻���� RED.
	JRadioButton red = new JRadioButton("RED", true);
	JRadioButton green = new JRadioButton("GREEN");
	JRadioButton blue = new JRadioButton("BLUE");
	
	//������ư ���� �� ���� ��ư�Դϴ�.
	JButton paintButton = new JButton("Paint");
	
	//�ڵ����� �׸� Panel�� �����մϴ�.
	class MyCar extends JPanel{
		
		//���� ������ �׸� �� ����ϱ� ���� ����Դϴ�.
		public static final int x = 150, y = 50;
		
		//���� ���簢�� -> ū ���簢�� -> �� ���� -> ���� ���� -> ȣ �� ������ �׸��� �׸��ϴ�.
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
	
	//CarFrame�� �������Դϴ�.
	public CarFrame(){
		//â�� ��ũ�� ����� ���� ���� Toolkit�� �������־��
		Toolkit tk = getToolkit();
		Dimension d = tk.getScreenSize();
		
		//���� �� pc�� ��ũ�� ����, ���� ���̸� �����մϴ�.
		int scHeight = d.height;
		int scWidth = d.width;
		
		//�׷��� â�� title, size, close operation, location, layout�� �����մϴ�.
		setTitle("MyCar - ������");
		setSize(500, 350);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocation(scWidth/2 - this.getWidth()/2, scHeight/2 - this.getHeight()/2);
		setLayout(new BorderLayout());
		
		//�ڵ��� �׸� Panel ��ü�� �����մϴ�.
		MyCar cb = new MyCar();

		//Radio Button���� Radio Button Group�� �߰��մϴ�.
		carColors.add(red);
		carColors.add(green);
		carColors.add(blue);
		
		add(cb, BorderLayout.CENTER);
		
		//Panel p�� radio button���� �߰��մϴ�.
		p.add(red);
		p.add(green);
		p.add(blue);
		
		//Panel p�� paintButton�� �߰��մϴ�.
		paintButton.addActionListener(this);
		p.add(paintButton);
		
		add(p, BorderLayout.PAGE_END);
		
		setVisible(true);
	}
	
	//PaintButton�� ������ ȣ��Ǵ� actionPerformed �޼��� �Դϴ�.
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == paintButton) //user�� ��ư�� ������
		{	
			//������ ������ Color ��ü c�� ���� �����մϴ�.
			if(red.isSelected())
				c = Color.RED;
			else if(blue.isSelected())
				c = Color.BLUE;
			else if(green.isSelected())
				c = Color.GREEN;
		}
		//�ٽ� �׸��ϴ�.
		repaint();
	}
	
}
public class Week12_2_������ {

	public static void main(String[] args) {
		System.out.println("============");
		System.out.println("����: ���̹�����");
		System.out.println("�й�: 1971079");
		System.out.println("����: ������");
		System.out.println("============");
		
		//���ο� CarFrame�� �����մϴ�.
		CarFrame cf = new CarFrame();

	}

}
