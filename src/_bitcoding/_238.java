package _bitcoding;

public class _238 {
	public static void printHello(int n) {
		if(n>0) {
			System.out.println("Hello!");
			printHello(n-1);
		}
		else {
			return;
		}
	}

	public static void main(String[] args) {
		printHello(4);
	}
}
