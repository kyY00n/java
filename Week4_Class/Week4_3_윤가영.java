
public class Week4_3_������ {

	public static void main(String[] args) {
		int a = 5, b = 10;
		double da = 3.4, db = 5.2;
		char ca = 'a', cb = 'b' ;
		int iarr[] = {1, 2, 3};
		double darr[] = {1.1, 2.2, 3.3};
		char carr[] = {'a', 'p', 'p', 'l', 'e'};
		System.out.println("a+b="+sum(a,b));
		System.out.println("da+b="+sum(da,b));
		System.out.println("a+db="+sum(a,db));
		System.out.println("da+db="+sum(da,db));
		System.out.println("ca+cb="+sum(ca,cb));
		System.out.println("sum of Int_Arr="+sum(iarr));
		System.out.println("sum of Double_Arr="+sum(darr));
		System.out.println("sum of Char_Arr="+sum(carr));
	}
	
	//���� ���ڸ� �޴� sum()
	public static int sum(int a, int b) {
		return a + b;
	}
	
	//�Ǽ�, ������ ���ڷ� �޴� sum()
	public static double sum(double da, int b) {
		return da + b;
	}
	
	//����, �Ǽ�
	public static double sum(int a, double db) {
		return a + db;
	}
	
	//�Ǽ�, �Ǽ�
	public static double sum(double da, double db) {
		return da + db;
	}
	
	//����, ����
	public static String sum(char ca, char cb) {
		//���ڸ� �̾���̱� ���� ���ڿ� ������ ��������ϴ�.
		String sa = Character.toString(ca); //static �޼��带 ����� char�� String���� �ٲ���.
		String sb = Character.toString(cb);
		return sa + sb;
	}
	
	//�����迭
	public static int sum(int[] arr) {
		int result = 0; //�޼��尡 ������ �հ��Դϴ�.
		
		//�迭�� ���ҵ��� ��� �����ݴϴ�.
		for(int i = 0 ; i < arr.length ; i++) {
			result += arr[i];
		}
		//��� ����� ��ȯ�մϴ�.
		return result;
	}
	
	//�Ǽ� �迭
	public static double sum(double[] darr) {
		double result = 0; // �޼��尡 ������ �հ��Դϴ�.
		
		//�迭�� ���ҵ��� result�� ��� �����ݴϴ�.
		for(int i = 0; i < darr.length; i++) {
			result += darr[i];
		}
		//��� ����� ��ȯ�մϴ�.
		return result;
	}
	
	//���� �迭
	public static String sum(char[] carr) {
		String result = ""; // �޼��尡 ������ ���ڿ��Դϴ�.
		String concat = null; // �� �ε����� ���ڸ� String���� ��ȯ�� ���� ������ String�����Դϴ�.
		
		//�迭�� ���ڸ� ������� result�� concatenate ���־��.
		for(int i = 0; i < carr.length; i++) {
			concat = Character.toString(carr[i]);
			result += concat;
		}
		//�� �̾���� result�� ��ȯ�մϴ�.
		return result;
	}
}
