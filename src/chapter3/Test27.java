package chapter3;

public class Test27 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// for 문
		for(int i = 10; i < 10; i++) { //i = 10 인데 i가 10보다 작은 조건? 성럽 안함. 출력X
			System.out.println("for OK");
		}
		// while 문
		int j = 10;
		while(j < 10) {
			System.out.println("while OK");
			j++;			
		}
		// do while 문
		int k = 10;
		do {
			System.out.println("do-while OK"); // 마찬가지로 조건성립 안하지만 그래도 1번은 무조건 실행시키고
			k++;
		} while(k < 10);

	}

}
