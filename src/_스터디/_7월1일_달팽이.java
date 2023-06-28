package _스터디;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class _7월1일_달팽이 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int ja = sc.nextInt();

		int gaesu = N * N;

		Stack<Integer> st = new Stack<>();
		Queue<Integer> que = new LinkedList<>();

		for (int i = 1; i <= gaesu; i++) {
			st.push(i);
		}

	}

}
