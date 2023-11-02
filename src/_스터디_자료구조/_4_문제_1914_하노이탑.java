package _스터디_자료구조;

import java.io.IOException;
import java.math.BigInteger;
import java.util.Scanner;

public class _4_문제_1914_하노이탑 {
	
	static StringBuffer str = new StringBuffer();

	static int K = 0;
	
	public static void main(String[] args) throws IOException {		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();		
		if (N <= 20) {
			Hanoi(N, 1, 2, 3);
			System.out.println(K);
			System.out.println(str);
			
		} else if (N > 20) {			
//			BigInteger a = BigInteger.valueOf(2);
//			BigInteger b = a.pow(N);
//			BigInteger c = BigInteger.ONE;
//			BigInteger d = b.subtract(c);
			System.out.println(new BigInteger("2").pow(N).subtract(BigInteger.ONE));
		}
	}

	public static void Hanoi(int Num, int from, int by, int to) throws IOException {
		if (Num == 1) {
			str.append(from + " " + to).append("\n");
			K++;
		}

		else {
			Hanoi(Num - 1, from, to, by);
			K++;
			str.append(from + " " + to).append("\n");
			Hanoi(Num - 1, by, from, to);

		}
	}
}
