import java.util.Scanner;

//SimulThread와 PrintThread의 공유 영역
class SharedArea
{
	double ratio;
	boolean isReady;
}

//SimulThread 정의
class SimulThread extends Thread
{
	SharedArea sharedArea;
	
	//count: 앞면이 나온 횟수, N: 동전 던지는 횟수
	int count, N;
	
	//result: 던져서 나온 면 (앞면: 1, 뒷면: 0)
	long result;
	
	//SimulThread 생성자
	public SimulThread(int N)
	{
		this.N = N;
	}
	
	//스레드가 생성되면 실행될 메서드
	public void run()
	{
		for(int i = 0; i < N; i++)
		{
			result = Math.round(Math.random());
			if(result == 1) //앞면이 나오면
			{
				count++;
			}
				
		}
		
		//N번 중 앞면이 나온 확률을 백분율로 저장
		sharedArea.ratio = ((double) count/N) * 100;
		
		//print 준비 완료
		sharedArea.isReady = true;
		
		synchronized(sharedArea) //동기화해주세요
		{
			//wait하는 스레드에게 알려주세요
			sharedArea.notify();
		}
	}
}

//PrintThread 정의
class PrintThread extends Thread
{
	SharedArea sharedArea;
	
	//스레드가 생성되면 실행될 메서드
	public void run()
	{
		if(!sharedArea.isReady) //Print 준비가 되지 않았다면..
		{
			try
			{
				synchronized(sharedArea)
				{
					//이 스레드는 기다려야합니다.
					sharedArea.wait();
				}
			}
			catch (InterruptedException e)
			{
				System.out.println(e.getMessage());
			}
		}//notify() 받음, wait() 풀림
		
		System.out.printf("Front Ratio: %.2f", sharedArea.ratio); //공유영역에 저장된 ratio 출력
		System.out.println("%");
	}
}
public class Week13_1_윤가영 {

	public static void main(String[] args) {
		System.out.println("============");
		System.out.println("전공: 사이버보안");
		System.out.println("학번: 1971079");
		System.out.println("성명: 윤가영");
		System.out.println("============");
		
		//사용자 입력 받을 스캐너 객체 생성
		Scanner sc = new Scanner(System.in);
		
		//동전 던지는 횟수 입력받기
		System.out.println("Input the number of coin toss:");
		int N = sc.nextInt();
		
		//스레드 객체 생성
		SimulThread s = new SimulThread(N);
		PrintThread p = new PrintThread();
		
		//공유 영역 SharedArea 객체 생성
		SharedArea sa = new SharedArea();
		
		//각자의 공유영역 멤버변수를 sa로 설정
		s.sharedArea = sa;
		p.sharedArea = sa;
		
		//스레드 생성(실행)
		s.start();
		p.start();
	
		sc.close(); 
	}

}
