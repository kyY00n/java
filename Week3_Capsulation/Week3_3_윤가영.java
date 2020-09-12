package ass3;
import java.util.Scanner;

class MyFile {
	private String title;
	private int page;
	
	public void setTitle(String title) { //���� setter
		this.title = title;
	}
	public String getTitle() { //���� getter
		return title;
	}
	public void setPage(int page) { //������ setter
		this.page = page;
	}
	public int getPage() { //������ getter
		return page;
	}
	public void fileCopy(MyFile mf) { //���Ϻ��� method
		
		//parameter�� ���� mf�� ����� �������� �����Ѵ�.
		mf.setTitle(this.title);
		mf.setPage(this.page);
	}
	public void fileInfo() { //���� ���� �����ִ� method
		System.out.println("��������:"+this.getTitle());
		System.out.println("������:"+getPage());
	}
}

public class Week3_3_������ {

	public static void main(String[] args) {
		System.out.println("============");
		System.out.println("����: ���̹�����");
		System.out.println("�й�: 1971079");
		System.out.println("����: ������");
		System.out.println("============");
		
		Scanner kbd = new Scanner(System.in); //��ĳ��
		String title;
		int page;
		MyFile fOld = new MyFile();
		MyFile fNew = new MyFile();
		System.out.println("--File�����Է� (����, ������ ��)--");
		fOld.setTitle(kbd.nextLine());
		fOld.setPage(kbd.nextInt());
		fOld.fileCopy(fNew);
		System.out.println("<���� File>");
		fOld.fileInfo();
		System.out.println("<����� File>");
		fNew.fileInfo();
	}

}
