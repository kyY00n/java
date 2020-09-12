import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

//Frame ��ü ����
class MouseFrame extends JFrame{
	
	//MouseFrame ���� ���� Panel p ����.
	JPanel p = new JPanel();
	//ƨ�ܳ����� Button b ����.
	JButton b = new JButton();
	
	//MouseFrame ������
	public MouseFrame() {
		setTitle("�� ��ƺ�~��! - ������");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(300, 300);
		setResizable(false);
		
		//Button b�� text�� �����մϴ�.
		b.setText("Click!");
		//b�� ���콺 �̺�Ʈ�� ó���մϴ�. 
		b.addMouseListener(new MyListener());
		//p�� b�� �߰��մϴ�.
		p.add(b);
		
		add(p, BorderLayout.CENTER);
		
		setVisible(true);
	}
	
	//inner class MyListener�� �����մϴ�.
	private class MyListener extends MouseAdapter{
		
		//mouseEntered �޼��带 overriding�մϴ�.
		public void mouseEntered(MouseEvent e) {
			int x, y;
			
			//�����Լ��� �̿��ؼ� ��ǥ�� ���մϴ�. (��� ������� 200���� �����߽��ϴ�.)
			x = (int)(Math.random()*200);
			y = (int)(Math.random()*200);
			
			//��ư b�� ���س��� ��ǥ�� �ű�ϴ�.
			b.setLocation(x, y);
			//console â�� ��ư�� ��ǥ�� ����մϴ�.
			System.out.println("x="+x+", y="+y);
		}
		
		//mouseClicked �޼��带 overriding
		public void mouseClicked(MouseEvent e) {
			if(e.getSource() == b)
				System.out.println("��,,, �����٤Ф�");
		}
	}
}
public class Week12_1_������ {

	public static void main(String[] args) {
		System.out.println("============");
		System.out.println("����: ���̹�����");
		System.out.println("�й�: 1971079");
		System.out.println("����: ������");
		System.out.println("============");
		
		//MouseFrame�� �����մϴ�.
		MouseFrame m = new MouseFrame();
	}

}
