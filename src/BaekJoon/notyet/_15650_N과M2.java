package BaekJoon.notyet;

import java.util.Scanner;

public class _15650_N과M2 {
	static int N, M;
	static int[] dfs; // 현재 만들어진 수열을 저장.

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();

		dfs = new int[M];

		backtrack(0, 1);

	}

	static void backtrack(int count, int start) {
		if (count == M) { // 현재 포함된 원소의 수가 M개와 같으면 스탑
			for (int num : dfs) {
				System.out.print(num + " ");
			}
			System.out.println();
			return;
		}
		for (int i = start; i <= N; i++) { // 1부터 N까지 돌면서 사용 되었는지 판단.
			dfs[count] = i;//
			backtrack(count + 1, i + 1);

		}
	}
}
