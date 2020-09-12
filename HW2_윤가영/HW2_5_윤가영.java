import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class NameFrame extends JFrame
{
	JPanel p1, p2; // p1: Pie Chart�� �׸� �г�, p2: textField��� button�� �ø� �г�
	int kim, lee, park, etc; //�� ���� �л� ���� ������ ����
	JTextField kimTF, leeTF, parkTF, etcTF; //�л� ���� �Է� �޴� textField
	JButton button; //"Graph"��ư
	
	//wrongInput�� ���ڰ� �ƴ� ���ڸ� �Է����� �� true�� �ٲ��� ����.
	//wrongNumberInput�� ���� 100�� �Ѵ� �Է��� �� true�� �ٲߴϴ�.
	//isInputBeing�� ����ڰ� ���α׷� ���� �� ���ʷ� �Է��� �� �׻� true���� �����մϴ�.
	boolean wrongInput, wrongNumberInput, isInputBeing;
	
	//������ class�� �����մϴ�.
	public NameFrame()
	{
		setTitle("Pie Chart of Student names - ������");
		setSize(500, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//������Ʈ�� �׸� �г� ��ü�� �����մϴ�.
		p1 = new PieChart();
		//textField�� button�� �ø� �г� ��ü�� �����մϴ�.
		p2 = new JPanel();
		
		//p2�� �ø� TextField��� button�� �����մϴ�.
		kimTF = new JTextField(6);
		leeTF = new JTextField(6);
		parkTF = new JTextField(6);
		etcTF = new JTextField(6);
		button = new JButton("Graph");
		//������ ��ü���� p2�� �ø��ϴ�.
		p2.add(new JLabel("Kim"));
		p2.add(kimTF);
		p2.add(new JLabel("Lee"));
		p2.add(leeTF);
		p2.add(new JLabel("Park"));
		p2.add(parkTF);
		p2.add(new JLabel("Etc"));
		p2.add(etcTF);
		button.addActionListener(new NameListener()); //button�� ���� ������ ActionLister ���� ��ü�� �߰��մϴ�.
		p2.add(button);		
		
		add(p1, BorderLayout.CENTER);
		add(p2, BorderLayout.SOUTH);
		
		setVisible(true);
	}
	
	//PieChart�� �׸� �г� Ŭ���� �����Դϴ�. (p1�� �� Ŭ���� ��ü�� �����մϴ�.)
	class PieChart extends JPanel
	{
		public void paint(Graphics g)
		{
			final int x = 120, y = 90, width = 150, height = 150;
			Color c = new Color(0, 0, 0);
			
			if(wrongInput) //���� �Է°��� ���ڰ� �ƴ� ���
			{
				g.drawString("Input numbers of student names", 150 ,280);
				kimTF.setText("0");
				leeTF.setText("0");
				parkTF.setText("0");
				etcTF.setText("0");
			}
			else if(wrongNumberInput) //���� �Է��� �л� ���� 100���� ���� ���
			{
				g.drawString("Number of students is 100.", 150, 280);
				kimTF.setText("0");
				leeTF.setText("0");
				parkTF.setText("0");
				etcTF.setText("0");
			}
			else
			{
				if(isInputBeing) //���� �Ŀ� �ѹ��̶� ����ڰ� �Է��� �ߴٸ�
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
			if(e.getSource() == button) //����ڰ� ��ư�� Ŭ���ϸ�
			{
				isInputBeing = true; //���ʷ� ��ư�� ���������� �ǹ̰� �ִ� �ڵ��Դϴ�.
				//���α׷� ���� ��, ����ڰ� ���ڸ� �Է��ϰ�
				//��ư�� ������ �� ������ TextField�� �׻� ������� �ʰ� �ϱ� ���� �߰��߽��ϴ�.
				
				try
				{
					//�Է¹��� �л� �� ���ڿ��� int������ ��ȯ�մϴ�.
					//���� ���ڰ� �ƴ� �ٸ� ���ڸ� �Է��ϸ� ���⼭ NumberFormatException ���ܰ� �߻��մϴ�.
					kim = Integer.parseInt(kimTF.getText());
					lee = Integer.parseInt(leeTF.getText());
					park = Integer.parseInt(parkTF.getText());
					
					//�Է¹��� ���ڵ��� ���� 100�� ���� ��� ���� ������ SumException ��ü�� �����Ͽ� ����ó���մϴ�.
					if((kim+lee+park) > 100) throw new SumException();
					
					//��� ���ܵ� �߻����� �ʾ��� ��� etc�� ������ݴϴ�.
					etc = 100 - (kim+lee+park);
				}
				catch(NumberFormatException ne)
				{
					wrongInput = true; //�߸��� �Է�
				}
				catch(SumException se)
				{
					wrongNumberInput = true; //�߸��� �����Է�
				}
				
				repaint(); //�ٽ� �׸���
			}
		}
	}
	
	class SumException extends Exception 
	{
		public SumException() {} //�ƹ��͵� �����ϴ�. �׳� ��ü�� �����մϴ�.
	}
}
public class HW2_5_������ {

	public static void main(String[] args) {
		/*
		 ����: ���̹�����
		 �й�: 1971079
		 �̸�: ������		 
		*/
		
		NameFrame nf = new NameFrame(); //������ ����

	}

}
