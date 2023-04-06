package chapter2;

public class Test15 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub		
		byte a = 0b1011;
		byte b = 0b1101;
		char c = 'A';
		//c = a; // 큰바이트를 작은 바이트로 불가
		c = (char)a; //이런식으로 쓰면 분명히 문제 생긴다. 극도로 피해야 해. 자동변환은 정보손실 없지만 직접변환은 문제생김. 안정성에 문제 생김
		int n;
		n = a; //1바이트를 2바이트론 가능 (자동으로 변환됨. 자동변환)
		//a = n; //2바이트를 1바이트론 안돼
		a = (byte)n; // 억지로 이렇게 바꾸는게 직접 타입변경. 근데 이건 조심해야돼. 소실이 생김.
 		String gender = (c == 'A') ? "여자" : "남자";
		System.out.println(gender);

	}

}
