package chapter2;

public class Test13 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		byte a = 0b1011; // 그냥 1001만 있므면 1001로 인식
		byte b = 0b1101;
		int c = a & b; // 그냥 & 하나는 비트연산이다. a와 b를 비트연산으로 하고 그 값은 2진수가 아닌 정수로 메모리에 저장되기 때문에 c를 byte로 정의하면 안되고 int로 정의해야 에러 안난다
		// byte c = a & b 하면 에러가 뜬다는 얘기.
		System.out.println("c = " + c);
		System.out.println(Integer.toBinaryString(c)); // 정수를 정의한 class(Integer)
		System.out.println(Integer.toBinaryString(a)); // 정수가 된걸 2진수로
		int e = a ^ b;
		System.out.println(Integer.toBinaryString(e)); // 0110
		int f = 12;
		int g = (~f)+1; // -12 (~f는 비트연산에서 0을 1로 1을 0으로 바꾸는것)
		System.out.println(g);
		System.out.println(Integer.toBinaryString(g));
		int h = f << 2;
		int i = h >> 1;
		System.out.println(Integer.toBinaryString(h));
		
				

	}

}
