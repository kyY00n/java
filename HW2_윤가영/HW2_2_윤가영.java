import java.util.*;

public class HW2_2_윤가영 {
	
	
	public static void main(String[] args) {
		System.out.println("============");
		System.out.println("전공: 사이버보안");
		System.out.println("학번: 1971079");
		System.out.println("성명: 윤가영");
		System.out.println("============");
		
		//스캐너 객체 생성
		Scanner sc = new Scanner(System.in);
		
		//while문 끝에서 결과 출력시 조건문에 사용할 boolean 값입니다.
		boolean isCorrect = false;
		
		//계속 단어를 입력받아요
		while(true)
		{	
			System.out.print("Input: ");
			String str = sc.next();
			
			//사용자가 "0"을 입력시 프로그램이 종료되어요
			if(str.equals("0"))
			{
				System.out.println("Program finished");
				System.exit(0);
			}
			
			//main 밑에 문자열이 correct한지 incorrect한지 판별해주는 메서드 solvePrb()를 정의 했습니다.
			//이 함수는 입력값으로 들어온 문자열의 correct 여부를 return 해요(boolean)
			isCorrect = solvePrb(str); 
			
			//solvePrb의 반환값이 true이면 "Correct"출력
			if(isCorrect) System.out.println("Correct");
			//false이면 "Incorrect"출력
			else System.out.println("Incorrect");
			
			System.out.println();
			System.out.println();
		}
	}
	
	public static boolean solvePrb(String input)
	{
		//solvePrb가 반환할 boolean 값을 저장한 변수입니다.
		//초기값은 false이고 이 값은 input의 모든 글자가 검사되기 전까진 항상 false입니다.
		boolean result = false;
		
		//입력받은 문자열을 한 글자씩 문자열 배열에 저장합니다.
		String [] inputSplit = input.split("");
		
		//이건 판별에 쓰일 Stack입니다.
		Stack<String> myStack = new Stack<String>();
		
		//이제 inputSplit의 문자열들을 하나씩 검사합니다.
		for(int i = 0; i < input.length(); i++)
		{
			String nextToken = inputSplit[i];
			
			switch(nextToken)
			{
				//이번 글자가 여는 괄호일 때
				case "(":
				case "{":
				case "[":
					myStack.push(nextToken); //스택에 추가합니다.
					break;
					
				case ")": // ")"일 때
					//만약 스택이 비어있으면 바로 false를 반환합니다.
					if(myStack.isEmpty()) return result;
					//만약 여는 괄호 "("와 일치하면 스택의 맨 위의 요소를 삭제합니다.
					else if(myStack.peek().equals("(")) myStack.pop();
					break;
					
				case "}": // "}"일 때
					//만약 스택이 비어있으면 바로 false를 반환합니다.
					if(myStack.isEmpty()) return result;
					//만약 여는 괄호 "{"와 일치하면 스택의 맨 위의 요소를 삭제합니다.
					else if(myStack.peek().equals("{")) myStack.pop();
					break;
					
				case "]":
					//만약 스택이 비어있으면 바로 false를 반환합니다.
					if(myStack.isEmpty()) return result;
					//만약 여는 괄호 "["와 일치하면 스택의 맨 위의 요소를 삭제합니다.
					else if(myStack.peek().equals("[")) myStack.pop();
					break;
				//그 외의 문자가 입력됐을 경우 false를 반환합니다.	
				default: return result;
				
			}//switch문 종료
			
		}//for문 종료 (input 검사 끝)
		
		if(myStack.isEmpty()) result = true;
		
		return result;
	}

}
