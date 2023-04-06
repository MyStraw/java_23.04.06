package chapter3;

import java.util.Scanner;

public class Test22_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a = 12;
		int b = 2;
	//	char op = '+';
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Op[+,-,*,/]:");
		
		String ops = sc.next(); //
		char op = ops.charAt(0); // 이거 두줄이 밑에 한줄이다. 즉 아래설명. 받는 데이터 형태.
		//char op = sc.next().charAt(0); // 22_2번이랑 비교해서 다른점? 
		//char은 한글자니까 받아올때 char로 지정하고 위치 At(0) 0번째에 있는 글자를 받는다고 해두면 해결~ 어차피 한글자니까 0번재걸 받아온다 하믄 되지
				switch(op) {
		case '+': // 22_2번은 큰따옴표. String 이다. 이건 char
			System.out.println("+:" + (a + b));
			break;
		case '-':
			System.out.println("-:" + (a - b));
			break;
		case '*':
			System.out.println("*:" + (a * b));
			break;
		case '/':
			System.out.println("/:" + (a / b));
			break;
		default:				
			System.out.println("잘못된 연산자입니다");
			break;
		
		}// a+b부분을 아래를 써서 sum(a,b)로 쓸수있다.
				// public static int sum(int a, int b) {
				// return a+b: 이런식으로 쓸수도 있다.

	}

}
