package chapter11;

public class Test03 { //550p 내용. 뭔말이여.

	public static void c() throws Exception { // throws를 넣으면 에러가발생한다면 괄호 넘어서 다음.메인으로간다.
		String s = null;
		s.length();

//		try {

//	} 
		// catch(Exception e) { //c에서 에러나면 여기서 처리. 위에 throws 넣으면 이 부분이 필요가 없다. try도.

	}

	public static void main(String[] args) { //메인으로 가서 에러 발생한 c를 try catch로 처리해준다. 그냥 일 떠넘기기네.
		try {
			c(); //
		} catch (Exception e) {

		}
	}
}