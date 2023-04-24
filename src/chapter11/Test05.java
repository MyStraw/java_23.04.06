package chapter11;

class NegativeNumberException extends Exception {
	public NegativeNumberException() {
		super("음수는 허용하지 않음"); //negative~의 위의 부모의 생성자 호출.
	}
}

public class Test05 {

	int battery = 0;

	public void charge(int time) {
		
		if(time < 0) {
			time = 0;
			try {
				throw new NegativeNumberException();
			} catch(NegativeNumberException e) {
				e.printStackTrace();
				
			}
		}
		battery += time;
		System.out.println("현재 배터리 :" + battery);
		
	}

	public static void main(String[] args) {

		Test05 test = new Test05();
		test.charge(30);
		test.charge(20);
		test.charge(-10);

	}

}

//main 에서 charge 함수를 불러. 실행을 하는데~
//-
