import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

//Frame 객체 생성
class MouseFrame extends JFrame{
	
	//MouseFrame 위에 얹을 Panel p 선언.
	JPanel p = new JPanel();
	//튕겨나가는 Button b 선언.
	JButton b = new JButton();
	
	//MouseFrame 생성자
	public MouseFrame() {
		setTitle("나 잡아봐~라! - 윤가영");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(300, 300);
		setResizable(false);
		
		//Button b의 text를 설정합니다.
		b.setText("Click!");
		//b가 마우스 이벤트를 처리합니다. 
		b.addMouseListener(new MyListener());
		//p에 b를 추가합니다.
		p.add(b);
		
		add(p, BorderLayout.CENTER);
		
		setVisible(true);
	}
	
	//inner class MyListener를 정의합니다.
	private class MyListener extends MouseAdapter{
		
		//mouseEntered 메서드를 overriding합니다.
		public void mouseEntered(MouseEvent e) {
			int x, y;
			
			//랜덤함수를 이용해서 좌표를 정합니다. (잡기 어려워서 200으로 설정했습니다.)
			x = (int)(Math.random()*200);
			y = (int)(Math.random()*200);
			
			//버튼 b를 정해놓은 좌표를 옮깁니다.
			b.setLocation(x, y);
			//console 창에 버튼의 좌표를 출력합니다.
			System.out.println("x="+x+", y="+y);
		}
		
		//mouseClicked 메서드를 overriding
		public void mouseClicked(MouseEvent e) {
			if(e.getSource() == b)
				System.out.println("윽,,, 잡혔다ㅠㅠ");
		}
	}
}
public class Week12_1_윤가영 {

	public static void main(String[] args) {
		System.out.println("============");
		System.out.println("전공: 사이버보안");
		System.out.println("학번: 1971079");
		System.out.println("성명: 윤가영");
		System.out.println("============");
		
		//MouseFrame을 실행합니다.
		MouseFrame m = new MouseFrame();
	}

}
