import java.util.*;

public class Week10_2_윤가영 {

	public static void main(String[] args) {
		System.out.println("============");
		System.out.println("전공: 사이버보안");
		System.out.println("학번: 1971079");
		System.out.println("성명: 윤가영");
		System.out.println("============");
		
		//스캐너 객체 sc 생성
		Scanner sc = new Scanner(System.in);
		
		////////////////////////////////////
		//학생 아이디, 이름 저장하는 HashMap 만들기~//
		///////////////////////////////////
		
		String ID, name, str; //학생들을 hashmap에 추가할 때 키보드 입력을 저장할 변수.
				
		Map<String, String> stuMap = new HashMap<String, String>();
		
		System.out.println("학생의 ID와 이름을 차례로 입력하세요. (종료시 0 0 입력)");
		while(true)
		{
			ID = sc.next();
			name = sc.next();
			
			if(ID.equals("0") && name.equals("0")) break;
			
			stuMap.put(ID, name); //Data input
		}
		
		Set s = stuMap.keySet();
		Iterator<String> it = s.iterator();
		
		System.out.println("<학생명단>");
		System.out.println("[ID]			[NAME]");
		
		while(it.hasNext())
		{	
			str = it.next();
			System.out.println(str+"			"+stuMap.get(str));
		}
		
		System.out.println();
		System.out.println("전체 학생수:" + stuMap.size()); //stuMap 만들기 끝
		
		//////////////////
		//긴 이름 짦은 이름 찾기//
		//////////////////
		
		int maxLength = 0, minLength = 0;
		String maxID, minID;
		
		//제일 긴 이름 찾기
		String nextID; //iterator의 다음 key(ID)를 저장할 문자열 변수 
		int nextLength = 0; //iterator의 다음 value(name)의 길이를 저장할 정수 변수
		
		Iterator<String> itMx = s.iterator(); //가장 긴 이름을 찾을 때 사용할 iterator
		
		
		maxID = itMx.next(); //maxID를 원래 있는 아이디 중 하나로 초기화.
		maxLength = stuMap.get(maxID).length(); //maxLength를 초기화한 maxID의 value로 초기화.
		
		while(itMx.hasNext())
		{
			nextID = itMx.next();
			nextLength = stuMap.get(nextID).length();
			
			if(maxLength < nextLength) //다음 value의 길이가 더 길 때
			{
				maxID = nextID;
				maxLength = nextLength;
			}
		}
		
		System.out.println("<가장 긴 이름을 가진 학생>");
		System.out.println("ID: "+maxID+" Name: "+stuMap.get(maxID)+" 길이: "+maxLength);
		//////////////////////////////////////////////////////////////////////////////// 제일 긴 이름 찾기 끝
		
		//가장 짧은 이름 찾기
		Iterator<String> itMn = s.iterator();
		minID = itMn.next();
		minLength = stuMap.get(minID).length();
		
		while(itMn.hasNext())
		{
			nextID = itMn.next();
			nextLength = stuMap.get(nextID).length();
			
			if(minLength > nextLength) //다음 value의 길이가 더 짧을 때
			{
				minID = nextID;
				minLength = nextLength;
			}
		}
		
		System.out.println("<가장 짧은 이름을 가진 학생>");
		System.out.println("ID: "+minID+" Name: "+stuMap.get(minID)+" 길이: "+minLength);
		//////////////////////////////////////////////////////////////////////////////// 제일 짧은 이름 찾기 끝
		
		sc.close();
		
	}

}
