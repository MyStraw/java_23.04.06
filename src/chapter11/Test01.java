package chapter11;

public class Test01 {

	public static void main(String[] args) {
		try { // 이 밑에서 에러가 발생하면
			int arr[] = new int[3];
			arr[3] = 30;
			String s = "java";
			s = null;
			System.out.println(s.length());

			System.out.println("OK");
		} catch (ArrayIndexOutOfBoundsException e) { // 여기서 잡아서
			System.out.println("에러발생" + e.toString());// 투스트링으로 에러 가져와
			e.printStackTrace();//
		} catch (NullPointerException e1) {
			e1.getMessage();
			e1.toString();
			System.out.println("null 에러발생" + e1);
		}
		System.out.println("GOOD");
	}

}
