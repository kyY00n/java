package ass3;
import java.util.Scanner;

class MyFile {
	private String title;
	private int page;
	
	public void setTitle(String title) { //제목 setter
		this.title = title;
	}
	public String getTitle() { //제목 getter
		return title;
	}
	public void setPage(int page) { //페이지 setter
		this.page = page;
	}
	public int getPage() { //페이지 getter
		return page;
	}
	public void fileCopy(MyFile mf) { //파일복사 method
		
		//parameter로 들어온 mf의 제목과 페이지를 변경한다.
		mf.setTitle(this.title);
		mf.setPage(this.page);
	}
	public void fileInfo() { //파일 정보 보여주는 method
		System.out.println("파일제목:"+this.getTitle());
		System.out.println("페이지:"+getPage());
	}
}

public class Week3_3_윤가영 {

	public static void main(String[] args) {
		System.out.println("============");
		System.out.println("전공: 사이버보안");
		System.out.println("학번: 1971079");
		System.out.println("성명: 윤가영");
		System.out.println("============");
		
		Scanner kbd = new Scanner(System.in); //스캐너
		String title;
		int page;
		MyFile fOld = new MyFile();
		MyFile fNew = new MyFile();
		System.out.println("--File정보입력 (제목, 페이지 수)--");
		fOld.setTitle(kbd.nextLine());
		fOld.setPage(kbd.nextInt());
		fOld.fileCopy(fNew);
		System.out.println("<원래 File>");
		fOld.fileInfo();
		System.out.println("<복사된 File>");
		fNew.fileInfo();
	}

}
