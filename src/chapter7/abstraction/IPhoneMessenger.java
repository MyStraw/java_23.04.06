package chapter7.abstraction;

public class IPhoneMessenger extends GraphicIOS implements Messenger {
	
	public String getMessage() {
		return "iPhone";
		
	}	
	
	
	public void setMessage(String msg) {
		System.out.println("iPhone에서 메세지를 설정합니다 : " + msg);
				
	}
	
	public void clearMessage() {
		System.out.println("좌우로 흔들어 문자열을 지웁니다.");
	}


	public void draw_textBox() { //메소드
		System.out.println("텍스트 상자를 그린다.");
		super.draw_textBox();
	}
	
	public void draw_submitButton() {
		System.out.println("IPhoneMessenger : 전송버튼을 그린다.");
		super.draw_submitButton();  //부모꺼도 그대로 출력하고, 자기꺼도 오버라이딩.
	}
}

