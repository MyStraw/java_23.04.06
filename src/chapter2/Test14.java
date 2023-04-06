package chapter2;

public class Test14 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		byte a = 0b1011;
		byte b = 0b1101;
		
		char c = 'A';
		int n = c;
		System.out.println("n = " + n);
		System.out.println(Integer.toBinaryString(n));
		c ^= (1<<5);
		System.out.println(c);
		int x = c;
		System.out.println(x);
		System.out.println(Integer.toBinaryString(x));

	}

}
