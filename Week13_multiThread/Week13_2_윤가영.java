import javax.swing.JOptionPane;

class SharedArea2 //공유영역 정의
{
	String randomWord; //MyGame스레드가 랜덤 선택한 단어가 저장됩니다.
}

//랜덤 단어를 골라주는 스레드 클래스 정의
class MyGame extends Thread
{
	SharedArea2 sharedArea;
	int randNum; //0~14 까지의 랜덤넘버
	boolean stop; //run()을 멈추는 조건
	
	//스트링 배열 초기화
	String[] myWords = new String[]{"dog", "cat", "water", "fruit", "milk", "hot", "air",
			"cool", "cold", "off", "good", "tired", "sleep", "wake", "eat"};
	
	public void run()
	{	

		for(int i = 20; i > 0; i--) //20번 반복
		{
			if(stop == true) break;
			
			randNum = (int) (Math.random() * 15);
			
			//sharedArea의 랜덤 단어 = 방금 뽑은 랜덤 단어
			sharedArea.randomWord = myWords[randNum];
			System.out.println(sharedArea.randomWord);
			
			try
			{
				sleep(1000); //1초 쉬기
			}
			catch(InterruptedException e)
			{
				System.out.println(e.getMessage());
			}
			
		}
		// 실패하면 stop은 false이므로
		if(!stop)
		{
			System.out.println("실패");
			System.exit(0);
		}
						
		else //stop이 true일 때
		{
			System.out.println("성공!");
			System.out.println("Timer is stopped.");
		}
	}
	
	public void setStop(boolean stop)
	{
		this.stop = stop;
	}
}


public class Week13_2_윤가영 {

	public static void main(String[] args) {
		System.out.println("============");
		System.out.println("전공: 사이버보안");
		System.out.println("학번: 1971079");
		System.out.println("성명: 윤가영");
		System.out.println("============");
		
		//랜덤하게 단어를 고를 스레드입니다.
		MyGame g = new MyGame();
		
		//메인스레드와 MyGame스레드의 공유영역입니다.
		SharedArea2 sa = new SharedArea2();
		g.sharedArea = sa;
	
		g.start();
		
		String st; //사용자의 입력을 저장할 String 변수입니다.

		while(true)
		{	
			st = JOptionPane.showInputDialog("문자열 입력");
			
			//사용자가 x(exit)을 눌렀을 때
			if(st == null) break;
			
			System.out.println("<"+st+">을 입력하셨습니다.");
			
			//화면에 나온 단어(randomWord)와 사용자 입력 단어가 일치할 때
			if(st.equals(sa.randomWord))
			{
				g.setStop(true); //MyGame 스레드 멈추기
				break; //while 탈출
			}
		}
		
		//메인스레드 종료
		System.exit(0);
	}
		
}

