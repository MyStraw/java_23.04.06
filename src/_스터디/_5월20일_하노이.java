package _스터디;

import java.util.Scanner;

public class _5월20일_하노이 {
	static StringBuffer str = new StringBuffer();
	static int K = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		Hanoi(N, 1, 2, 3);
		System.out.println(K);
		System.out.println(str);
	}

	public static void Hanoi(int Num, int from, int by, int to) {
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
