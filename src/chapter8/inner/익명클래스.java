package chapter8.inner;

interface Messenger {// 376~377p
	String getMessage();// 아래와 마찬가지

	void setMessage(String msg); // 함수 선언만 있고 바디가없다.
}
//class GMessenger implements Messenger {
//	public String getMessage(){
//		return "good";		
//	}
//	public void setMessage(String msg) {
//		System.out.println("my data = " + msg);		
//	}	
//	public void changeMode() {
//		System.out.println("changed");
//	}
//}

public class 익명클래스 {
	public static void main(String[] args) {
//		GMessenger gm = new GMessenger(); //뒤 연두색은 인터페이스. 이거에대해 new? 못만들어. 
		// 인터페이스에 대해 객체를 만들어?X. 근데 자바가 클래스 자동생성. 이거에 대해 new 적용. 이걸 익명클래스라고 한다.
		// 앞에 파란색은 인터페이스, gm은변수.
		Messenger gm = new Messenger() {

			public String getMessage() {
				return "good";
			}

			public void setMessage(String msg) {
				System.out.println("my data = " + msg);
			}

			public void changeMode() {
				System.out.println("changed");
			}
		};

		gm.getMessage();
		gm.setMessage("hong");
	}

}
